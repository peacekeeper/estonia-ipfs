package com.danubetech.estoniaipfs;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ipfs.api.MerkleNode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class WriteIPFSServlet extends HttpServlet {

	private static final long serialVersionUID = 1665357099665972403L;

	private static final Log log = LogFactory.getLog(WriteIPFSServlet.class);

	private static final Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String data = request.getParameter("data");
		log.info("DATA: " + data);

		JsonObject ipfsData = gson.fromJson(new StringReader(data), JsonObject.class);
		JsonArray ipfsLinks = new JsonArray();
		JsonObject ipfsObject = new JsonObject();
		ipfsObject.addProperty("Data", gson.toJson(ipfsData));
		ipfsObject.add("Links", ipfsLinks);
		log.info("OBJECT: " + gson.toJson(ipfsObject));

		MerkleNode merkleNode = Config.ipfs.object.put(Collections.singletonList(gson.toJson(ipfsObject).getBytes(Charset.forName("UTF-8")))).get(0);
		log.info("MERKLENODE NAME: " + merkleNode.hash.toBase58());

		String ipns = (String) Config.ipfs.name.publish(merkleNode.hash).get("Name");
		log.info("IPNS ID:" + ipns);

		response.setStatus(200);
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().print("{\"ipns\":\"" + ipns + "\",\"hash\":\"" + merkleNode.hash.toBase58() + "\"}");
	}
}

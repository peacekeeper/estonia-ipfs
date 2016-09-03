package com.danubetech.estoniaipfs;

import org.ipfs.api.IPFS;

public class Config {

	public static IPFS ipfs;

	static {

		ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
	}
}

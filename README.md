Built during the [Blockchain and Identity Hackathon](http://www.hackathon.com/estonia/tallinn/blockchain-and-identity-hackathon-27210855401) in Tallinn on September 3rd 2016.

![alt tag](https://raw.githubusercontent.com/peacekeeper/estonia-ipfs/master/pic2.jpg)

### Prerequisites

Make sure that you...

 * have your Estonian e-residency card attached with working card reader.
 * have installed the [card reader software](https://installer.id.ee/?lang=eng).
 * are running a local [IPFS](http://ipfs.io/) daemon.
 * are serving this demo over a trusted TLS certificate.
 * are not running it on localhost.

![alt tag](https://raw.githubusercontent.com/peacekeeper/estonia-ipfs/master/pic1.jpg)

### How to build

Just run

    mvn clean install jetty:run

To build and run the demo.

### TODO

 * Use JSON Web Signature (JWS) instead of quick&dirty signature.
 * Implement demo relying part that accepts e-residency card and IPNS address.
 * Figure out how to share my IPNS address with a relying party in an easy way.
 * Can the e-residency certificate or serial number (together with a secret) somehow be cryptographically linked to my IPNS address?
 * Use IPNS path(s) instead of IPNS root address.
 * This could be integrated into http://smartid.ee/

### About

Markus Sabadello, Danube Tech, https://danubetech.com/


Quick hack for linking Estonian e-residency to IPFS.

### Prerequisites

Make sure that you...

 * have your Estonian e-residency card attached with working card reader.
 * have installed the [card reader software|https://installer.id.ee/?lang=eng].
 * are running a local IPFS daemon.
 * are serving this demo over a valid TLS certificate.

### How to build

Just run

    mvn clean install jetty:run

To build and run the demo.

Then open **http://localhost:8081** in your browser.

### TODO

 * Use JSON Web Signature (JWS) instead of quick&dirty signature.
 * Figure out how to share my IPNS address with a relying party in an easy way.
 * Can the e-residency certificate or serial number (together with a secret) somehow be cryptographically linked to my IPNS address?

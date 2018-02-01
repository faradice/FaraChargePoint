package com.faradice.ocpp.centralsystem;

import javax.xml.ws.Endpoint;

/*
 * create classes from wsdl from cmd line wsimport tool:
 *   wsimport -keep -extension  -s src wsdl/OCPP_CentralSystemService_1.6.wsdl
 */
public class CentralSystemMockupServer {
	public static void main(String[] args) {
		String host = "localhost";
		String port = "8079";
		String serviceName = "FaraCentralSystem";
		// Address to access wsdl file in browser
		System.out.println(host+":"+port+"/"+serviceName+"/?wsdl");
		Endpoint.publish("http://"+host+":"+port+"/"+serviceName+"/", new CentralSystem());
	}
}

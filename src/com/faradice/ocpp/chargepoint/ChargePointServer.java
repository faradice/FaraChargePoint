package com.faradice.ocpp.chargepoint;

import javax.xml.ws.Endpoint;

import com.faradice.faranet.FaraHttp;

/*
 * 
 * create classes from wsdl from cmd line wsimport tool:
 * wsimport -keep -extension  -Xendorsed -s src wsdl/OCPP_ChargePointService_1.6.wsdl
 */
public class ChargePointServer {
	public static void main(String[] args) {
		String ipAddress = FaraHttp.ipAddress();
		String host = ipAddress;
		String port = "8080";
		String serviceName = "FaraChargePoint";
		// Address to access wsdl file in browser
		System.out.println(host+":"+port+"/"+serviceName+"?wsdl");
		Endpoint.publish("http://"+host+":"+port+"/"+serviceName, new ChargePoint());
	}
}

package com.faradice.ocpp.centralsystem;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceContext;

/*
 * create classes from wsdl from cmd line wsimport tool:
 *   wsimport -keep -extension  -keep -Xendorsed -s src wsdl/OCPP_CentralSystemService_1.6.wsdl
 *   nb command line: 
 *   wsimport/Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/bin/java -d /Users/ragnar/Ocpp2/build/generated/jax-wsCache/OCPP_CentralSystemService_1.6 -extension -Xendorsed -keep -s /Users/ragnar/Ocpp2/build/generated/jax-wsCache/OCPP_CentralSystemService_1.6 -encoding UTF-8 -verbose -Xnocompile -catalog /Users/ragnar/Ocpp2/catalog.xml /Users/ragnar/Ocpp2/src/conf/xml-resources/web-service-references/OCPP_CentralSystemService_1.6/wsdl/OCPP_CentralSystemService_1.6.wsdl -p ocpp2 -wsdllocation file:/Users/ragnar/FaraChargePoint/wsdl/OCPP_CentralSystemService_1.6.wsdl
 *
 */
public class CentralSystemMockupServer {
	public static void main(String[] args) {
		String host = "localhost";
		String port = "8079";
		String serviceName = "FaraCentralSystem";
		// Address to access wsdl file in browser
		System.out.println(host+":"+port+"/"+serviceName+"/?wsdl");
		Endpoint.publish("http://"+host+":"+port+"/"+serviceName+"/", new CentralSystem());
/*		
		WebServiceContext context = 
		
		SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
		SOAPHeader header = envelope.getHeader();
		
		
		SOAPHeaderElement confirmationHeader = header.addHeaderElement(confirmation);
		confirmationHeader.setActor("http://gizmos.com/confirmations");
		confirmationHeader.setMustUnderstand(true);
*/

	}
}

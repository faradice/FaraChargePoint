package com.faradice.ocpp.centralsystem;

import java.util.List;

import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;

import com.faradice.ocpp.Ocpp15HeaderHandler;
import com.faradice.ocpp.Ocpp16HeaderHandler;

/*
 * Skoða þennan betur.  Virðist góður
 * https://www.javaworld.com/article/3215966/java-language/web-services-in-java-se-part-2-creating-soap-web-services.html
 * 
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
		String endpoint = host + ":" + port + "/" + serviceName;
		// Address to access wsdl file in browser
		System.out.println(host + ":" + port + "/" + serviceName + "?wsdl");

		Endpoint ep = Endpoint.publish("http://" + host + ":" + port + "/" + serviceName, new CentralSystem());
		List<Handler> handlerChain = ep.getBinding().getHandlerChain();
		handlerChain.add(new Ocpp16HeaderHandler("Faradice1"));
		ep.getBinding().setHandlerChain(handlerChain);
		System.out.println("Server ready");
	}
}

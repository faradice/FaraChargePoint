package com.faradice.ocpp.centralsystem;

import com.faradice.faraUtil.FaraDates;
import com.faradice.faraUtil.FaraFiles;
import com.faradice.faranet.FaraHttp;

import javax.xml.ws.Endpoint;

/*
This is the actual Central Server that chargers connect to.
See CentralSystem with the implementation for each OCPP endpoint server method
To test, run FaraChargePointChargepointTest after this server is started.
FaraChargePointCentralTest will connect to this server and call bootNotification and authenticate

 */


/*
 * create classes from wsdl from cmd line wsimport tool:
 *   wsimport -keep -extension -keep -Xendorsed -s src wsdl/OCPP_CentralSystemService_1.6.wsdl
 *   nb command line: 
 *   wsimport/Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/bin/java -d /Users/ragnar/Ocpp2/build/generated/jax-wsCache/OCPP_CentralSystemService_1.6 -extension -Xendorsed -keep -s /Users/ragnar/Ocpp2/build/generated/jax-wsCache/OCPP_CentralSystemService_1.6 -encoding UTF-8 -verbose -Xnocompile -catalog /Users/ragnar/Ocpp2/catalog.xml /Users/ragnar/Ocpp2/src/conf/xml-resources/web-service-references/OCPP_CentralSystemService_1.6/wsdl/OCPP_CentralSystemService_1.6.wsdl -p ocpp2 -wsdllocation file:/Users/ragnar/FaraChargePoint/wsdl/OCPP_CentralSystemService_1.6.wsdl
 *
 */
public class CentralSystemMockupServer {
	public static void main(String[] args) {
		String host = FaraHttp.ipAddress();
		String port = "80";
		String serviceName = "FaraCentralSystem";
		// Address to access wsdl file in browser
		System.out.println(host + ":" + port + "/" + serviceName + "?wsdl");
		Endpoint ep = Endpoint.publish("http://" + host + ":" + port + "/" + serviceName, new CentralSystem());
//		List<Handler> handlerChain = ep.getBinding().getHandlerChain();
//		handlerChain.add(new Ocpp16HeaderHandler("CentralServer"));
//		ep.getBinding().setHandlerChain(handlerChain);
		String time = FaraDates.getDateTime(System.currentTimeMillis());
		FaraFiles.appendRowToCSVFile("ocpp_log.txt", time + " -ocpp server started");

		System.out.println("Server ready");
	}
}

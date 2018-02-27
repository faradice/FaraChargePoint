package com.faradice.ocpp.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.AddressingFeature;

import com.faradice.ocpp.OcppHeaderHandler;

/* 1.5
import ocpp.cs._2012._06.IdTagInfo;
import ocpp.cs._2012._06.AuthorizeRequest;
import ocpp.cs._2012._06.AuthorizeResponse;
import ocpp.cs._2012._06.CentralSystemService;
*/
import ocpp.cs._2015._10.AuthorizeRequest;
import ocpp.cs._2015._10.AuthorizeResponse;
import ocpp.cs._2015._10.BootNotificationRequest;
import ocpp.cs._2015._10.BootNotificationResponse;
import ocpp.cs._2015._10.CentralSystemService;
import ocpp.cs._2015._10.IdTagInfo;
import ocpp.cs._2015._10.RegistrationStatus;

public class FaraChargePointCentralTest {
	static CentralSystemService ss = null;

/*	
//  FaraChargePoint local server
	static String endpoint = "http://localhost:8079/FaraCentralSystem";
	static String uri = endpoint+"?wsdl";
	static String serviceURN = "http://centralsystem.ocpp.faradice.com/";
	static String sericeName = "CentralSystemService";
*/
	
/*
//  OCPP 15 Faradice DO server
//	http://104.236.81.197:8088/Ocpp15WebAppDemo/CentralSystemService?wsdl	
	static String endpoint = "http://104.236.81.197:8088/Ocpp15WebAppDemo/CentralSystemService";
	static String uri = endpoint+"?wsdl";
	static String serviceURN = "urn://Ocpp/Cs/2012/06/";
	static String sericeName = "CentralSystemService";
	
*/

/*
//  OCPP 15 Faradice local netbeans server
//	http://localhost:8080/Ocpp15WebAppDemo/CentralSystemService?wsdl	
	static String endpoint = "http://localhost:8080/Ocpp15WebAppDemo/CentralSystemService";
	static String uri = endpoint+"?wsdl";
	static String serviceURN = "urn://Ocpp/Cs/2012/06/";
	static String sericeName = "CentralSystemService";

*/	
	
/*  
// OCPP 16 Faradice DO server 
// �ps hent �vart
	
*/
	
/*	
//  Direct local server
	static String endpoint = "http://localhost:8085/Fara_occp/CentralSystemService";
	static String uri = endpoint+"?wsdl";
	static String serviceURN = "urn://Ocpp/Cs/2015/10/";
	static String sericeName = "CentralSystemService";

*/

	
//  ON Test Server: oncore-test.on.is
//	http://oncore-test.on.is/OcppServices/Ocpp16/Ocpp16Service.svc?wsdl

	static String endpoint = "http://oncore-test.on.is/OcppServices/Ocpp16/Ocpp16Service.svc";	
	static String uri = endpoint+"?wsdl";
	static String serviceURN = "urn://Ocpp/Cs/2015/10/";
	static String sericeName = "Ocpp16Service";
	static String port = "CentralSystemServiceSoap12";

	public static void testBootNotification() {
		BootNotificationRequest bnreq = new BootNotificationRequest();
		bnreq.setChargeBoxSerialNumber("FaraX1");
		BootNotificationResponse bnrsp = ss.bootNotification(bnreq);
		RegistrationStatus rs = bnrsp.getStatus();
		System.out.println("BootNotification from server: "+rs.value());
	}
	
	public static void testAuthorizeRequest() {
		AuthorizeRequest aur = new AuthorizeRequest();
		aur.setIdTag("1234");
		AuthorizeResponse ars = ss.authorize(aur);
		IdTagInfo tagInfo = ars.getIdTagInfo();
		System.out.println("Authentication from server: "+tagInfo.getStatus().value());
	}

	public static void addHandler() {
		OcppHeaderHandler handler = new OcppHeaderHandler("Faradice1");
		BindingProvider bp = (BindingProvider) ss;
		List<Handler> handlerChain = bp.getBinding().getHandlerChain();
		handlerChain.add(handler);
		bp.getBinding().setHandlerChain(handlerChain);
		System.out.println("Handler added: "+handler.getClass().getName());
	}
	
	public static void initSoap() {
		try {
			QName serviceName = new QName(serviceURN, sericeName);
			QName portName = new QName(serviceURN, port);

			URL url = new URL(uri);
			Service service = Service.create(url, serviceName);
			AddressingFeature af = new AddressingFeature();
			Iterator<QName> qn = service.getPorts();
			System.out.println("Ports read from service:");
			while (qn.hasNext()) {
				System.out.println(qn.next());
			}
			ss = service.getPort(portName, CentralSystemService.class, af);
			addHandler();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws MalformedURLException {
		initSoap();
	}

}

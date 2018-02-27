package com.faradice.ocpp.test;

import java.net.MalformedURLException;

import com.faradice.ocpp.Ocpp16Factory;

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
// Úps hent óvart
	
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
		
	public static void main(String[] args) throws MalformedURLException {
		ss = Ocpp16Factory.centralService("Faradice1", endpoint, serviceURN, sericeName, port);
	}

}

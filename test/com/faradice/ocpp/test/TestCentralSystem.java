package com.faradice.ocpp.test;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.ws.Service;

import ocpp.cs._2015._10.AuthorizeRequest;
import ocpp.cs._2015._10.AuthorizeResponse;
import ocpp.cs._2015._10.CentralSystemService;
import ocpp.cs._2015._10.IdTagInfo;

public class TestCentralSystem {
	static String uri = "http://104.236.81.197:8088/cs_ocpp16/CentralSystemService?wsdl";
	static String serviceURN = "urn://Ocpp/Cs/2015/10/";
	static String sericeName = "CentralSystemService";

	// static String uri = "http://localhost:8079/FaraCentralSystem/?wsdl";
	// static String serviceURN = "http://centralsystem.ocpp.faradice.com/";
	// static String sericeName ="CentralSystemService";

	static CentralSystemService ss;

	public static void testAuthorizeRequest() {
		AuthorizeRequest aur = new AuthorizeRequest();
		aur.setIdTag("1234");
		AuthorizeResponse ars = ss.authorize(aur);
		IdTagInfo tagInfo = ars.getIdTagInfo();
		System.out.println(tagInfo.getStatus().value());
	}

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL(uri);
		QName qName = new QName(serviceURN, sericeName);
		Service service = Service.create(url, qName);
		ss = service.getPort(CentralSystemService.class);

		testAuthorizeRequest();
	}
}

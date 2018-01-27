package com.faradice.ocpp.test;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import ocpp.cs._2015._10.AuthorizeRequest;
import ocpp.cs._2015._10.AuthorizeResponse;
import ocpp.cs._2015._10.CentralSystemService;
import ocpp.cs._2015._10.IdTagInfo;

public class TestCentralSystem {
	public static void main(String[] args) throws MalformedURLException {
		String host = "localhost";
		String port = "8079";
		String serviceName = "FaraCentralSystem";
		URL url = new URL("http://"+host+":"+port+"/"+serviceName+"/?wsdl");
		QName qName = new QName("http://centralsystem.ocpp.faradice.com/","CentralSystemService");
		Service service = Service.create(url, qName);
		CentralSystemService ss = service.getPort(CentralSystemService.class);

		AuthorizeRequest aur = new AuthorizeRequest();
		aur.setIdTag("1234");
		AuthorizeResponse ars = ss.authorize(aur);
		IdTagInfo tagInfo = ars.getIdTagInfo();
		System.out.println(tagInfo.getStatus().value());
	}
}

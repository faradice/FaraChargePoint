package com.faradice.ocpp.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;

import common.OcppHeaderHandler;
import ocpp.cs._2015._10.AuthorizeRequest;
import ocpp.cs._2015._10.AuthorizeResponse;
import ocpp.cs._2015._10.CentralSystemService;
import ocpp.cs._2015._10.IdTagInfo;

public class FaraChargePointCentralTest {

	// https://docs.oracle.com/javaee/5/tutorial/doc/bnbis.html

	// https://jointxroad.github.io/examples.html

	// <soap12:header message="tns:Header" part="ChargeBoxIdentity" use="literal"/>
	
	
	
/*
//  FaraChargePoint server
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

//  OCPP 16 Faradice DO server 
/*	
	static String endpoint = "http://104.236.81.197:8088/cs_ocpp16/CentralSystemService";
	static String uri = endpoint+"?wsdl";
	static String serviceURN = "urn://Ocpp/Cs/2015/10/";
	static String sericeName = "CentralSystemService";
*/

	
//  Direct local server
	static String endpoint = "http://localhost:8085/Fara_occp/CentralSystemService";
	static String uri = endpoint+"?wsdl";
	static String serviceURN = "urn://Ocpp/Cs/2015/10/";
	static String sericeName = "CentralSystemService";


	
	static URL url;
	static CentralSystemService ss;
	static QName qName;
	static Service service;

	public static void testAuthorizeRequest() {
		AuthorizeRequest aur = new AuthorizeRequest();
		aur.setIdTag("1234");
		AuthorizeResponse ars = ss.authorize(aur);
		IdTagInfo tagInfo = ars.getIdTagInfo();
		System.out.println(tagInfo.getStatus().value());
	}

	public static void addHander() {
		OcppHeaderHandler handler = new OcppHeaderHandler("Faradice1");
		BindingProvider bp = (BindingProvider) ss;
		List<Handler> handlerChain = bp.getBinding().getHandlerChain();
		handlerChain.add(handler);
		bp.getBinding().setHandlerChain(handlerChain);
		System.out.println("Handler added: "+handler.getClass().getName());
	}
	
	public static void initSoap() {
		try {
			url = new URL(uri);
			qName = new QName(serviceURN, sericeName);
			service = Service.create(url, qName);
			ss = service.getPort(CentralSystemService.class);
//			addHandler();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws MalformedURLException {
		initSoap();
		testAuthorizeRequest();
	}

}

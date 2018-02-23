package com.faradice.ocpp.test;

import java.net.MalformedURLException;

import com.faradice.ocpp.OcppFactory;

/* 1.5
import ocpp.cs._2012._06.IdTagInfo;
import ocpp.cs._2012._06.AuthorizeRequest;
import ocpp.cs._2012._06.AuthorizeResponse;
import ocpp.cs._2012._06.CentralSystemService;
*/
import ocpp.cs._2015._10.AuthorizeRequest;
import ocpp.cs._2015._10.AuthorizeResponse;
import ocpp.cs._2015._10.CentralSystemService;
import ocpp.cs._2015._10.IdTagInfo;

public class FaraChargePointCentralTest {
	static CentralSystemService ss = null;
	
	public static void testAuthorizeRequest() {
		AuthorizeRequest aur = new AuthorizeRequest();
		aur.setIdTag("1234");
		AuthorizeResponse ars = ss.authorize(aur);
		IdTagInfo tagInfo = ars.getIdTagInfo();
		System.out.println("Authentication from server: "+tagInfo.getStatus().value());
	}


	public static void main(String[] args) throws MalformedURLException {
		ss = OcppFactory.digoCentralService16();
		testAuthorizeRequest();
	}

}

package com.faradice.ocpp.test;

import java.net.MalformedURLException;

import javax.xml.bind.annotation.XmlElement;

import com.faradice.ocpp.OcppFactory;

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

	public static void testBootNotification() {
		BootNotificationRequest bnr = new BootNotificationRequest();
		String s = "";
		Integer i = 0;
		bnr.setChargeBoxSerialNumber(s);
	    bnr.setChargePointVendor(s);
	    bnr.setChargePointModel(s);
	    bnr.setChargePointSerialNumber(s);
	    bnr.setChargeBoxSerialNumber(s);
	    bnr.setFirmwareVersion(s);
	    bnr.setIccid(s);
	    bnr.setImsi(s);
	    bnr.setMeterType(s);
	    bnr.setMeterSerialNumber(s);

		BootNotificationResponse bnres = ss.bootNotification(bnr);
		RegistrationStatus regStat = bnres.getStatus();
		int interval = bnres.getInterval();
		System.out.println("BootNotification from server: "+regStat.value());
	}
	
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

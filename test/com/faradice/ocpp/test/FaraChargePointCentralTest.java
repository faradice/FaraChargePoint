package com.faradice.ocpp.test;

import java.net.MalformedURLException;

import com.faradice.ocpp.Ocpp16Factory;

import ocpp.cs._2015._10.AuthorizeRequest;
import ocpp.cs._2015._10.AuthorizeResponse;
import ocpp.cs._2015._10.BootNotificationRequest;
import ocpp.cs._2015._10.BootNotificationResponse;
import ocpp.cs._2015._10.CentralSystemService;
import ocpp.cs._2015._10.IdTagInfo;

public class FaraChargePointCentralTest {

	public static void testBootNotification(CentralSystemService ss) {
		BootNotificationRequest bnreq = new BootNotificationRequest();
		bnreq.setChargeBoxSerialNumber("X1-2008-31");
		bnreq.setChargePointVendor("Faradice");
		bnreq.setChargePointModel("FDP X1 S7");
		bnreq.setFirmwareVersion("3.7.7");
		bnreq.setIccid("Iccid1");
		bnreq.setImsi("Imsi1");
		bnreq.setMeterType("EVSE 1000Hz");
		bnreq.setMeterSerialNumber("Meter-EVSE-Serial");
		BootNotificationResponse bnrsp = ss.bootNotification(bnreq);
		System.out.println("BootNotification");
		System.out.println("Status: "+bnrsp.getStatus());
		System.out.println("Interval: "+bnrsp.getInterval());
		System.out.println("Time: "+bnrsp.getCurrentTime());
	}
	
	public static void testAuthorizeRequest(CentralSystemService ss) {
		AuthorizeRequest aur = new AuthorizeRequest();
		aur.setIdTag("1234");
		AuthorizeResponse ars = ss.authorize(aur);
		IdTagInfo tagInfo = ars.getIdTagInfo();
		System.out.println("Authentication from server: "+tagInfo.getStatus().value());
	}
		
	public static void main(String[] args) throws MalformedURLException {
		CentralSystemService ss = Ocpp16Factory.loalChargePointCentralMockup("FaraX1"); 
		testBootNotification(ss);
	}
}

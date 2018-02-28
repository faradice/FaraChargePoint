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
		ss = Ocpp16Factory.loalChargePointCentralMockup("FaraX1"); 
	}

}

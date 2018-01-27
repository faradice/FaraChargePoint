package com.faradice.ocpp.test;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import ocpp.cp._2015._10.ChargePointService;
import ocpp.cp._2015._10.RemoteStartTransactionRequest;
import ocpp.cp._2015._10.RemoteStartTransactionResponse;

public class TestChargepoint {
	public static void main(String[] args) throws MalformedURLException {
		String host = "localhost";
		String port = "8069";
		String serviceName = "FaraChargePoint";
		URL url = new URL("http://"+host+":"+port+"/"+serviceName+"/?wsdl");
		QName qName = new QName("http://chargepoint.ocpp.faradice.com/","ChargePointService");
		Service service = Service.create(url, qName);
		ChargePointService cp = service.getPort(ChargePointService.class);

		RemoteStartTransactionRequest rst = new RemoteStartTransactionRequest();
		rst.setIdTag("1234");
		RemoteStartTransactionResponse rstr = cp.remoteStartTransaction(rst);
		System.out.println(rstr.getStatus().value());

		rst.setIdTag("4321");
		rstr = cp.remoteStartTransaction(rst);
		System.out.println(rstr.getStatus().value());

		
	}
}

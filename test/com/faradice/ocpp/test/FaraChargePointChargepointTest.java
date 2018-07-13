package com.faradice.ocpp.test;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import ocpp.cp._2015._10.ChargePointService;
import ocpp.cp._2015._10.RemoteStartTransactionRequest;
import ocpp.cp._2015._10.RemoteStartTransactionResponse;
import ocpp.cp._2015._10.RemoteStopTransactionRequest;
import ocpp.cp._2015._10.RemoteStopTransactionResponse;
import ocpp.cp._2015._10.ResetRequest;
import ocpp.cp._2015._10.ResetResponse;
import ocpp.cp._2015._10.ResetType;

public class FaraChargePointChargepointTest {

	static ChargePointService cp = null;
	
	private static void initTest() throws Exception {
//		String host = "192.168.1.177";
		String host = "10.15.113.88";
		String port = "8080";
		String serviceName = "FaraChargePoint";	
		URL url = new URL("http://"+host+":"+port+"/"+serviceName+"/?wsdl");
		QName qName = new QName("http://chargepoint.ocpp.faradice.com/","ChargePointService");
		Service service = Service.create(url, qName);
		cp = service.getPort(ChargePointService.class);
	}
		
	public static String testStartTransaction() {
		RemoteStartTransactionRequest rst = new RemoteStartTransactionRequest();
		rst.setIdTag("12345678");
		RemoteStartTransactionResponse rstr = cp.remoteStartTransaction(rst);
		String transVal = rstr.getStatus().value();
		System.out.println("Transaction started: "+transVal);
		return transVal;
	}

	public static void testStopTransaction() {
		RemoteStopTransactionRequest rsts = new RemoteStopTransactionRequest();
		rsts.setTransactionId(100);
		RemoteStopTransactionResponse rstopt = cp.remoteStopTransaction(rsts);
		System.out.println("Transaction stopped: "+rstopt.getStatus().value());
	}

	public static void testResetTransaction() {
		ResetRequest rsts = new ResetRequest();
		rsts.setType(ResetType.HARD);
		ResetResponse rset = cp.reset(rsts);
		System.out.println("Reset response: "+rset.getStatus().value());
	}
	
	public static void main(String[] args) throws Exception {
		initTest();
		testStartTransaction();
//		Thread.sleep(60000);
//		testStopTransaction();
		testResetTransaction();
	}
}

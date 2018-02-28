package com.faradice.ocpp.centralsystem;

import java.util.logging.Logger;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import com.faradice.faraUtil.FaraDates;

import ocpp.cs._2015._10.AuthorizationStatus;
import ocpp.cs._2015._10.AuthorizeRequest;
import ocpp.cs._2015._10.AuthorizeResponse;
import ocpp.cs._2015._10.BootNotificationRequest;
import ocpp.cs._2015._10.BootNotificationResponse;
import ocpp.cs._2015._10.CentralSystemService;
import ocpp.cs._2015._10.DataTransferRequest;
import ocpp.cs._2015._10.DataTransferResponse;
import ocpp.cs._2015._10.DiagnosticsStatusNotificationRequest;
import ocpp.cs._2015._10.DiagnosticsStatusNotificationResponse;
import ocpp.cs._2015._10.FirmwareStatusNotificationRequest;
import ocpp.cs._2015._10.FirmwareStatusNotificationResponse;
import ocpp.cs._2015._10.HeartbeatRequest;
import ocpp.cs._2015._10.HeartbeatResponse;
import ocpp.cs._2015._10.IdTagInfo;
import ocpp.cs._2015._10.MeterValuesRequest;
import ocpp.cs._2015._10.MeterValuesResponse;
import ocpp.cs._2015._10.RegistrationStatus;
import ocpp.cs._2015._10.StartTransactionRequest;
import ocpp.cs._2015._10.StartTransactionResponse;
import ocpp.cs._2015._10.StatusNotificationRequest;
import ocpp.cs._2015._10.StatusNotificationResponse;
import ocpp.cs._2015._10.StopTransactionRequest;
import ocpp.cs._2015._10.StopTransactionResponse;

@WebService(endpointInterface = "ocpp.cs._2015._10.CentralSystemService")
@HandlerChain(file="handler_chain.xml")
@Addressing(required = false)
public class CentralSystem implements CentralSystemService {
	public static final Logger logger = Logger.getLogger(CentralSystem.class.getName());

	public AuthorizeResponse authorize(AuthorizeRequest parameters) {
		String tag = parameters.getIdTag();
		logger.info("Authorize "+tag);
		boolean accepted = tag.equals("1234");
		AuthorizeResponse aur = new AuthorizeResponse();
		IdTagInfo idTagInfo = new IdTagInfo();
		if (accepted) {
			idTagInfo.setStatus(AuthorizationStatus.ACCEPTED);
		} else {
			idTagInfo.setStatus(AuthorizationStatus.INVALID);
		}
		aur.setIdTagInfo(idTagInfo);
		return aur;
	}

	public BootNotificationResponse bootNotification(BootNotificationRequest parameters) {
		System.out.println("Charger boot");
		
		logger.info("BootNotification ");
		BootNotificationResponse bns = new BootNotificationResponse();
		bns.setStatus(RegistrationStatus.ACCEPTED);
		bns.setCurrentTime(FaraDates.getXMLDateTime());
		bns.setInterval(1000);
		return bns;
	}

	public DataTransferResponse dataTransfer(DataTransferRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public DiagnosticsStatusNotificationResponse diagnosticsStatusNotification(DiagnosticsStatusNotificationRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public FirmwareStatusNotificationResponse firmwareStatusNotification(FirmwareStatusNotificationRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public HeartbeatResponse heartbeat(HeartbeatRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public MeterValuesResponse meterValues(MeterValuesRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public StartTransactionResponse startTransaction(StartTransactionRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public StatusNotificationResponse statusNotification(StatusNotificationRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public StopTransactionResponse stopTransaction(StopTransactionRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public AuthorizeResponse authorize(AuthorizeRequest parameters, String chargeBoxIdentity) {
		// TODO Auto-generated method stub
		return null;
	}

	public BootNotificationResponse bootNotification(BootNotificationRequest parameters, String chargeBoxIdentity) {
		// TODO Auto-generated method stub
		return null;
	}

	public DataTransferResponse dataTransfer(DataTransferRequest parameters, String chargeBoxIdentity) {
		// TODO Auto-generated method stub
		return null;
	}

	public DiagnosticsStatusNotificationResponse diagnosticsStatusNotification(DiagnosticsStatusNotificationRequest parameters, String chargeBoxIdentity) {
		// TODO Auto-generated method stub
		return null;
	}

	public FirmwareStatusNotificationResponse firmwareStatusNotification(FirmwareStatusNotificationRequest parameters, String chargeBoxIdentity) {
		// TODO Auto-generated method stub
		return null;
	}

	public HeartbeatResponse heartbeat(HeartbeatRequest parameters, String chargeBoxIdentity) {
		// TODO Auto-generated method stub
		return null;
	}

	public MeterValuesResponse meterValues(MeterValuesRequest parameters, String chargeBoxIdentity) {
		// TODO Auto-generated method stub
		return null;
	}

	public StartTransactionResponse startTransaction(StartTransactionRequest parameters, String chargeBoxIdentity) {
		// TODO Auto-generated method stub
		return null;
	}

	public StatusNotificationResponse statusNotification(StatusNotificationRequest parameters, String chargeBoxIdentity) {
		// TODO Auto-generated method stub
		return null;
	}

	public StopTransactionResponse stopTransaction(StopTransactionRequest parameters, String chargeBoxIdentity) {
		// TODO Auto-generated method stub
		return null;
	}
}

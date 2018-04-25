package com.faradice.ocpp.chargepoint;

import java.util.HashMap;
import java.util.logging.Logger;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.ws.Action;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.Addressing;

import com.faradice.commands.FaraWebApi;
import com.faradice.faraUtil.Log;

import ocpp.cp._2015._10.AvailabilityStatus;
import ocpp.cp._2015._10.CancelReservationRequest;
import ocpp.cp._2015._10.CancelReservationResponse;
import ocpp.cp._2015._10.CancelReservationStatus;
import ocpp.cp._2015._10.ChangeAvailabilityRequest;
import ocpp.cp._2015._10.ChangeAvailabilityResponse;
import ocpp.cp._2015._10.ChangeConfigurationRequest;
import ocpp.cp._2015._10.ChangeConfigurationResponse;
import ocpp.cp._2015._10.ChargePointService;
import ocpp.cp._2015._10.ChargingProfileStatus;
import ocpp.cp._2015._10.ChargingSchedule;
import ocpp.cp._2015._10.ClearCacheRequest;
import ocpp.cp._2015._10.ClearCacheResponse;
import ocpp.cp._2015._10.ClearCacheStatus;
import ocpp.cp._2015._10.ClearChargingProfileRequest;
import ocpp.cp._2015._10.ClearChargingProfileResponse;
import ocpp.cp._2015._10.ClearChargingProfileStatus;
import ocpp.cp._2015._10.ConfigurationStatus;
import ocpp.cp._2015._10.DataTransferRequest;
import ocpp.cp._2015._10.DataTransferResponse;
import ocpp.cp._2015._10.DataTransferStatus;
import ocpp.cp._2015._10.GetCompositeScheduleRequest;
import ocpp.cp._2015._10.GetCompositeScheduleResponse;
import ocpp.cp._2015._10.GetConfigurationRequest;
import ocpp.cp._2015._10.GetConfigurationResponse;
import ocpp.cp._2015._10.GetDiagnosticsRequest;
import ocpp.cp._2015._10.GetDiagnosticsResponse;
import ocpp.cp._2015._10.GetLocalListVersionRequest;
import ocpp.cp._2015._10.GetLocalListVersionResponse;
import ocpp.cp._2015._10.RemoteStartStopStatus;
import ocpp.cp._2015._10.RemoteStartTransactionRequest;
import ocpp.cp._2015._10.RemoteStartTransactionResponse;
import ocpp.cp._2015._10.RemoteStopTransactionRequest;
import ocpp.cp._2015._10.RemoteStopTransactionResponse;
import ocpp.cp._2015._10.ReservationStatus;
import ocpp.cp._2015._10.ReserveNowRequest;
import ocpp.cp._2015._10.ReserveNowResponse;
import ocpp.cp._2015._10.ResetRequest;
import ocpp.cp._2015._10.ResetResponse;
import ocpp.cp._2015._10.ResetStatus;
import ocpp.cp._2015._10.ResetType;
import ocpp.cp._2015._10.SendLocalListRequest;
import ocpp.cp._2015._10.SendLocalListResponse;
import ocpp.cp._2015._10.SetChargingProfileRequest;
import ocpp.cp._2015._10.SetChargingProfileResponse;
import ocpp.cp._2015._10.TriggerMessageRequest;
import ocpp.cp._2015._10.TriggerMessageResponse;
import ocpp.cp._2015._10.TriggerMessageStatus;
import ocpp.cp._2015._10.UnlockConnectorRequest;
import ocpp.cp._2015._10.UnlockConnectorResponse;
import ocpp.cp._2015._10.UnlockStatus;
import ocpp.cp._2015._10.UpdateFirmwareRequest;
import ocpp.cp._2015._10.UpdateFirmwareResponse;
import ocpp.cp._2015._10.UpdateStatus;

@WebService(endpointInterface = "ocpp.cp._2015._10.ChargePointService")
@HandlerChain(file="handler_chain2.xml")
@BindingType(value="http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
//@Addressing(required = false,enabled=true)
@Addressing(required = false,enabled=false)
public class ChargePoint implements ChargePointService {
	public static final Logger logger = Logger.getLogger(ChargePoint.class.getName());

	public CancelReservationResponse cancelReservation(CancelReservationRequest parameters) {
		logger.info("Cancel Reservation");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "cancelReservation");
		params.put("ReservationId", parameters.getReservationId());
		CancelReservationResponse crr = new CancelReservationResponse();
		if (acceptOCCPRequest(params)) {
			crr.setStatus(CancelReservationStatus.ACCEPTED);
		} else {
			crr.setStatus(CancelReservationStatus.REJECTED);
		}
		return crr;
	}

	public ChangeAvailabilityResponse changeAvailability(ChangeAvailabilityRequest parameters) {
		logger.info("changeAvailability");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "changeAvailability");
		params.put("connectorId", parameters.getConnectorId());
		ChangeAvailabilityResponse car = new ChangeAvailabilityResponse();
		if (acceptOCCPRequest(params)) {
			car.setStatus(AvailabilityStatus.ACCEPTED);
		} else {
			car.setStatus(AvailabilityStatus.REJECTED);
		}
		return car;
	}

	public ChangeConfigurationResponse changeConfiguration(ChangeConfigurationRequest parameters) {
		logger.info("changeConfiguration");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "changeConfiguration");
		params.put(parameters.getKey(), parameters.getValue());
		ChangeConfigurationResponse ccr = new ChangeConfigurationResponse();
		if (acceptOCCPRequest(params)) {
			ccr.setStatus(ConfigurationStatus.ACCEPTED);
		} else {
			ccr.setStatus(ConfigurationStatus.REJECTED);
		}
		return ccr;
	}

	public ClearCacheResponse clearCache(ClearCacheRequest parameters) {
		logger.info("clearCache");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "clearCache");
		ClearCacheResponse ccr = new ClearCacheResponse();
		if (acceptOCCPRequest(params)) {
			ccr.setStatus(ClearCacheStatus.ACCEPTED);
		} else {
			ccr.setStatus(ClearCacheStatus.REJECTED);
		}
		return ccr;
	}

	public ClearChargingProfileResponse clearChargingProfile(ClearChargingProfileRequest parameters) {
		logger.info("clearChargingProfile");
		ClearChargingProfileResponse response = new ClearChargingProfileResponse();
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "clearChargingProfile");
		params.put("Id", parameters.getId());
		params.put("ConnectorId", parameters.getConnectorId());
		params.put("StackLevel", parameters.getStackLevel());
		params.put("Purpose", parameters.getChargingProfilePurpose());
		boolean accept = acceptOCCPRequest(params);
		if (accept) {
			response.setStatus(ClearChargingProfileStatus.ACCEPTED);
		} else {
			response.setStatus(ClearChargingProfileStatus.UNKNOWN);
		}
		return response;
	}

	public DataTransferResponse dataTransfer(DataTransferRequest parameters) {
		logger.info("dataTransfer");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "dataTransfer");
		params.put("messageId", parameters.getMessageId());
		params.put("vendorId", parameters.getVendorId());
		params.put("data", parameters.getData());
		DataTransferResponse response = new DataTransferResponse();
		boolean accept = acceptOCCPRequest(params);
		if (accept) {
			response.setStatus(DataTransferStatus.ACCEPTED);
		} else {
			response.setStatus(DataTransferStatus.REJECTED);
		}
		return response;
	}

	public GetConfigurationResponse getConfiguration(GetConfigurationRequest parameters) {
		logger.info("getConfiguration");
		HashMap<String, Object> params = new HashMap<>();
		params.put("key", parameters.getKey());
		GetConfigurationResponse response = new GetConfigurationResponse();
		boolean accept = acceptOCCPRequest(params);
		return response;
	}

	public GetDiagnosticsResponse getDiagnostics(GetDiagnosticsRequest parameters) {
		logger.info("getDiagnostics");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "getDiagnostics");
		params.put("location", parameters.getLocation());
		params.put("startTime", parameters.getStartTime());
		params.put("stopTime", parameters.getStopTime());
		params.put("retries", parameters.getRetries());
		params.put("retryInterval", parameters.getRetryInterval());
		GetDiagnosticsResponse response = new GetDiagnosticsResponse();
		boolean accept = acceptOCCPRequest(params);
		if (accept) {
			response.setFileName("Diagnostic_Filename");
		} else {
			response.setFileName("Diagnostic_Filename");
		}
		return response;
	}

	public GetLocalListVersionResponse getLocalListVersion(GetLocalListVersionRequest parameters) {
		logger.info("getLocalListVersion");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "getLocalListVersion");
		GetLocalListVersionResponse response = new GetLocalListVersionResponse();
		boolean accept = acceptOCCPRequest(params);
		if (accept) {
			response.setListVersion(2020);
		} else {
			response.setListVersion(-1);
		}
		return response;
	}

	public RemoteStartTransactionResponse remoteStartTransaction(RemoteStartTransactionRequest parameters) {
		logger.info("remoteStartTransaction");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "remoteStartTransaction");
		params.put("connectorId", parameters.getConnectorId());
		params.put("idTag", parameters.getIdTag());
		params.put("chargingProfile", parameters.getChargingProfile());

		RemoteStartTransactionResponse response = new RemoteStartTransactionResponse();
		FaraWebApi.scan(parameters.getIdTag());

		// Todo check status in event file or log file to see if charger accepted request
		response.setStatus(RemoteStartStopStatus.ACCEPTED);
		return response;
	}

	public RemoteStopTransactionResponse remoteStopTransaction(RemoteStopTransactionRequest parameters) {
		logger.info("remoteStopTransaction");
		FaraWebApi.disableCharger();
		RemoteStopTransactionResponse response = new RemoteStopTransactionResponse();
		response.setStatus(RemoteStartStopStatus.ACCEPTED);
		return response;
	}

	public GetCompositeScheduleResponse getCompositeSchedule(GetCompositeScheduleRequest parameters) {
		logger.info("getCompositeSchedule");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "getCompositeSchedule");
		params.put("connectorId", parameters.getConnectorId());
		params.put("duration", parameters.getDuration());
		params.put("ChargingRateUnitType", parameters.getChargingRateUnit());
		GetCompositeScheduleResponse response = new GetCompositeScheduleResponse();
		boolean accept = acceptOCCPRequest(params);
		try {
			if (accept) {
				response.setChargingSchedule(new ChargingSchedule());
				response.setConnectorId(1);
				response.setScheduleStart(DatatypeFactory.newInstance().newXMLGregorianCalendar());
				response.setChargingSchedule(new ChargingSchedule());
			} else {
				response.setChargingSchedule(new ChargingSchedule());
				response.setConnectorId(1);
				response.setScheduleStart(DatatypeFactory.newInstance().newXMLGregorianCalendar());
				response.setChargingSchedule(new ChargingSchedule());
			}
		} catch (DatatypeConfigurationException ex) {
			Log.error(ex.getMessage(), ex);
		}
		return response;
	}

	public ReserveNowResponse reserveNow(ReserveNowRequest parameters) {
		logger.info("reserveNow");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "reserveNow");
		params.put("connectorId", parameters.getConnectorId());
		params.put("expiryDate", parameters.getExpiryDate());
		params.put("idTag", parameters.getIdTag());
		params.put("parentIdTag", parameters.getParentIdTag());
		params.put("reservationId", parameters.getReservationId());
		ReserveNowResponse response = new ReserveNowResponse();
		boolean accept = acceptOCCPRequest(params);
		if (accept) {
			response.setStatus(ReservationStatus.ACCEPTED);
		} else {
			response.setStatus(ReservationStatus.OCCUPIED);
		}
		return response;
	}
    @Action( output="/ResetResponse")
	public ResetResponse reset(ResetRequest parameters) {
		logger.info("reset requested.  Type: "+parameters.getType());
		ResetResponse response = new ResetResponse();
		response.setStatus(ResetStatus.REJECTED);
		if (parameters.getType().equals(ResetType.HARD)) {
			FaraWebApi.restartCharger();
			response.setStatus(ResetStatus.ACCEPTED);
		} else if (parameters.getType().equals(ResetType.HARD)) {
			FaraWebApi.restartPilot();
			response.setStatus(ResetStatus.ACCEPTED);
		}
		return response;
	}

	public SendLocalListResponse sendLocalList(SendLocalListRequest parameters) {
		logger.info("sendLocalList");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "sendLocalList");
		SendLocalListResponse response = new SendLocalListResponse();
		boolean accept = acceptOCCPRequest(params);
		if (accept) {
			response.setStatus(UpdateStatus.ACCEPTED);
		} else {
			response.setStatus(UpdateStatus.FAILED);
		}
		return response;
	}

	public SetChargingProfileResponse setChargingProfile(SetChargingProfileRequest parameters) {
		logger.info("setChargingProfile");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "setChargingProfile");
		params.put("connectorId", parameters.getConnectorId());
		SetChargingProfileResponse response = new SetChargingProfileResponse();
		boolean accept = acceptOCCPRequest(params);
		if (accept) {
			response.setStatus(ChargingProfileStatus.ACCEPTED);
		} else {
			response.setStatus(ChargingProfileStatus.REJECTED);
		}
		return response;
	}

	public TriggerMessageResponse triggerMessage(TriggerMessageRequest parameters) {
		logger.info("triggerMessage");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "triggerMessage");
		TriggerMessageResponse response = new TriggerMessageResponse();
		boolean accept = acceptOCCPRequest(params);
		if (accept) {
			response.setStatus(TriggerMessageStatus.ACCEPTED);
		} else {
			response.setStatus(TriggerMessageStatus.REJECTED);
		}
		return response;
	}

	public UnlockConnectorResponse unlockConnector(UnlockConnectorRequest parameters) {
		logger.info("unlockConnector");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "unlockConnector");
		UnlockConnectorResponse response = new UnlockConnectorResponse();
		boolean accept = acceptOCCPRequest(params);
		if (accept) {
			response.setStatus(UnlockStatus.UNLOCKED);
		} else {
			response.setStatus(UnlockStatus.UNLOCK_FAILED);
		}
		return response;
	}

	public UpdateFirmwareResponse updateFirmware(UpdateFirmwareRequest parameters) {
		logger.info("updateFirmware");
		HashMap<String, Object> params = new HashMap<>();
		params.put("Method", "updateFirmware");
		UpdateFirmwareResponse response = new UpdateFirmwareResponse();
		boolean accept = acceptOCCPRequest(params);
		return response;
	}

	// Only temp function to show OCPP requests
	private boolean acceptOCCPRequest(HashMap<String, Object> params) {
		for (String key : params.keySet()) {
			System.out.println(key + " " + params.get(key));
		}
		return true;
	}
	
}

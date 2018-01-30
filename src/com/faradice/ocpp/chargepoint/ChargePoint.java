package com.faradice.ocpp.chargepoint;

import java.util.HashMap;
import java.util.logging.Logger;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSchemaType;

import ocpp.cp._2015._10.*;

@WebService(endpointInterface = "ocpp.cp._2015._10.ChargePointService")
public class ChargePoint implements ChargePointService {
	public static final Logger logger = Logger.getLogger(ChargePoint.class.getName());
	
	public CancelReservationResponse cancelReservation(CancelReservationRequest parameters) {
		logger.info("Cancel Reservation");
		int reservationId = parameters.getReservationId();
		CancelReservationResponse crr = new CancelReservationResponse();
		CancelReservationStatus status = CancelReservationStatus.ACCEPTED;
		crr.setStatus(status);
		return crr;
	}

	public ChangeAvailabilityResponse changeAvailability(ChangeAvailabilityRequest parameters) {
		logger.info("changeAvailability");
		int connectorId = parameters.getConnectorId();
		ChangeAvailabilityResponse car = new ChangeAvailabilityResponse();
		AvailabilityStatus avs = AvailabilityStatus.ACCEPTED;
		car.setStatus(avs);
		return car;
	}

	public ChangeConfigurationResponse changeConfiguration(ChangeConfigurationRequest parameters) {
		logger.info("changeConfiguration");
		String key = parameters.getKey();
		String newValue = parameters.getValue();
		return new ChangeConfigurationResponse();
	}

	public ClearCacheResponse clearCache(ClearCacheRequest parameters) {
		logger.info("clearCache");
		ClearCacheResponse ccr = new ClearCacheResponse();
		ClearCacheStatus ccs = ClearCacheStatus.ACCEPTED;
		ccr.setStatus(ccs);
		return ccr;
	}

	public ClearChargingProfileResponse clearChargingProfile(ClearChargingProfileRequest parameters) {
		logger.info("clearChargingProfile");
	    int id = parameters.getId();
	    int connectorId = parameters.getConnectorId();
	    ChargingProfilePurposeType purpose = parameters.getChargingProfilePurpose();
	    int stackLevel = parameters.getStackLevel();
	    ClearChargingProfileResponse response = new ClearChargingProfileResponse();
	    boolean accept = true;
	    if (accept) {
	    		response.setStatus(ClearChargingProfileStatus.ACCEPTED);
	    } else {
	    		response.setStatus(ClearChargingProfileStatus.UNKNOWN);
	    }
	    return response;
	}

	public DataTransferResponse dataTransfer(DataTransferRequest parameters) {
		
		logger.info("dataTransfer");
		return new DataTransferResponse();
	}

	public GetConfigurationResponse getConfiguration(GetConfigurationRequest parameters) {
		logger.info("getConfiguration");
		return new GetConfigurationResponse();
	}

	public GetDiagnosticsResponse getDiagnostics(GetDiagnosticsRequest parameters) {
		logger.info("getDiagnostics");
		return new GetDiagnosticsResponse();
	}

	public GetLocalListVersionResponse getLocalListVersion(GetLocalListVersionRequest parameters) {
		logger.info("clearCache");
		return new GetLocalListVersionResponse();
	}

	public RemoteStartTransactionResponse remoteStartTransaction(RemoteStartTransactionRequest parameters) {
		String tag = parameters.getIdTag();
		logger.info("remoteStartTransaction for Tag:"+tag);
		RemoteStartTransactionResponse rst = new RemoteStartTransactionResponse();
		boolean accepted = tag.equals("1234");
		if (accepted) {
			rst.setStatus(RemoteStartStopStatus.ACCEPTED);
		} else {
			rst.setStatus(RemoteStartStopStatus.REJECTED);
		}
		return rst;
	}

	public RemoteStopTransactionResponse remoteStopTransaction(RemoteStopTransactionRequest parameters) {
		logger.info("remoteStopTransaction");
		return new RemoteStopTransactionResponse();
	}

	public GetCompositeScheduleResponse getCompositeSchedule(GetCompositeScheduleRequest parameters) {
		logger.info("getCompositeSchedule");
		return new GetCompositeScheduleResponse();
	}

	public ReserveNowResponse reserveNow(ReserveNowRequest parameters) {
		logger.info("reserveNow");
		return new ReserveNowResponse();
	}

	public ResetResponse reset(ResetRequest parameters) {
		logger.info("reset");
		return new ResetResponse();
	}

	public SendLocalListResponse sendLocalList(SendLocalListRequest parameters) {
		logger.info("sendLocalList");
		return new SendLocalListResponse();
	}

	public SetChargingProfileResponse setChargingProfile(SetChargingProfileRequest parameters) {
		logger.info("setChargingProfile");
		return new SetChargingProfileResponse();
	}

	public TriggerMessageResponse triggerMessage(TriggerMessageRequest parameters) {
		logger.info("triggerMessage");
		return new TriggerMessageResponse();
	}

	public UnlockConnectorResponse unlockConnector(UnlockConnectorRequest parameters) {
		logger.info("unlockConnector");
		UnlockConnectorResponse ucr = new UnlockConnectorResponse();
		ucr.setStatus(UnlockStatus.NOT_SUPPORTED);
		return ucr;
	}

	public UpdateFirmwareResponse updateFirmware(UpdateFirmwareRequest parameters) {
		logger.info("updateFirmware");
		UpdateFirmwareResponse rfr = new UpdateFirmwareResponse();
		return rfr;
	}
	
	
	// Only temp function to show OCPP requests 
	private boolean acceptOCCPRequest(HashMap<String, String> params) {
		for (String key : params.keySet())  {
			System.out.println("");
		}
		return true;
	}

}

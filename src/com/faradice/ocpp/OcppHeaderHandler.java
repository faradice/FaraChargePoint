package com.faradice.ocpp;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import com.sun.xml.internal.ws.developer.JAXWSProperties;

public class OcppHeaderHandler implements SOAPHandler<SOAPMessageContext> {
	final static Logger log = Logger.getLogger(OcppHeaderHandler.class.getName());

	public final String chargePointID;

	public OcppHeaderHandler(String cpi) {
		this.chargePointID = cpi;
	}

	public boolean handleMessage(SOAPMessageContext context) {
		Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		ByteOutputStream bs = new ByteOutputStream();
		SOAPMessage message = context.getMessage();
		try {
			if (outboundProperty) {
				SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
				String ns = envelope.getNamespaceURI("ns");
				if (ns == null) {
					envelope.addNamespaceDeclaration("ns", "urn://Ocpp/Cs/2015/10/");
				}

				String wsa = envelope.getNamespaceURI("wsa");
				if (wsa == null) {
					envelope.addNamespaceDeclaration("wsa", "urn://Ocpp/Cs/2015/10/");
				}
				
				SOAPHeader header = envelope.getHeader(); // addHeader();
				if (header == null) {
					header = envelope.addHeader();
				}

				// ns:chargeBoxIdentity
				SOAPElement chargeBoxIdentityElement = header.addChildElement("chargeBoxIdentity", "ns");
				chargeBoxIdentityElement.addTextNode(chargePointID);

	            // wsa:Action
	            SOAPHeaderElement ae = header.addHeaderElement(new QName("wsa", "Action"));
	            ae.setMustUnderstand(false);
	            String actionName = (String)context.get("javax.xml.ws.soap.http.soapaction.uri");
	            ae.addTextNode(actionName);
	            
	            //wsa:MessageID
	            ae = header.addHeaderElement(new QName("wsa","MessageID"));
	            String uuid = "uuid:" + UUID.randomUUID().toString();
	            ae.addTextNode(uuid);
	            
	            //wsa:To (endpoint)
	            //ae = header.addHeaderElement(new QName("wsa","To"));
	            //String endpoint = (String)context.get(JAXWSProperties.ADDRESSING_TO);
	            //ae.addTextNode(endpoint);

				message.saveChanges();
				message.writeTo(bs);
				String s = new String(bs.getBytes());
				System.out.println(s);
			} else {
				System.out.println("Inbound");
				message.writeTo(bs);
				String s = new String(bs.getBytes());
				System.out.println(s);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.severe(ex.getMessage());
		}
		return outboundProperty;
	}

	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	public void close(MessageContext context) {
	}

	public Set<QName> getHeaders() {
		Set<QName> qns = new HashSet<>();
		qns.add(new QName("wsa", "Action"));
		return qns;
	}

}

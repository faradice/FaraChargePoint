package com.faradice.ocpp.centralsystem;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

// see http://victor-ichim.blogspot.is/2011/07/three-ways-to-configure-jax-ws-handlers.html
// https://stackoverflow.com/questions/24127632/how-do-i-specify-the-ws-addressing-version-with-a-jax-ws-client
public class HeadHandler implements SOAPHandler<SOAPMessageContext> {
	public final String endpoint;
	public HeadHandler(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public Set<QName> getHeaders() {
	    QName chargeBoxIdentytyHeader = new QName("urn://Ocpp/Cs/2012/06/","chargeBoxIdentity");
        HashSet<QName> headers = new HashSet<QName>();
        headers.add(chargeBoxIdentytyHeader);
        System.out.println("got Headers:  " + headers);
        return headers;
	}

	public boolean handleMessage(SOAPMessageContext messageContext) {
		try {
			Boolean isRequest = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		    SOAPMessage soapMsg = messageContext.getMessage();
            SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
            SOAPHeader soapHeader = soapEnv.getHeader();
   			if (isRequest) {
				System.out.println("\nOutbound message:");

	            //if no header, add one
	            if (soapHeader == null){
	            		soapHeader = soapEnv.addHeader();
	            }
	            
	            // wsa:Action
	            SOAPHeaderElement ae = soapHeader.addHeaderElement(new QName("wsa","Action"));
	            ae.setMustUnderstand(true);
	            String actionName = (String)messageContext.get("javax.xml.ws.soap.http.soapaction.uri");
	            ae.addTextNode(actionName);
	            
	            // ns:chargeBoxIdentity
	            ae = soapHeader.addHeaderElement(new QName("ns","chargeBoxIdentity"));
//	            ae.setMustUnderstand(true);
	            String chargeBoxId = "FaraTestCharger";
	            ae.addTextNode(chargeBoxId);
	
	            //wsa:MessageID
	            ae = soapHeader.addHeaderElement(new QName("wsa","MessageID"));
//	            ae.setMustUnderstand(true);
	            String uuid = "uuid:" + UUID.randomUUID().toString();
	            ae.addTextNode(uuid);
	            
	            //wsa:To (endpoint)
//	            ae = soapHeader.addHeaderElement(new QName("wsa","To"));
//	            ae.setMustUnderstand(true);
//	            ae.addTextNode(endpoint);

	            soapMsg.saveChanges();
	            ByteOutputStream bs = new ByteOutputStream();
	            soapMsg.writeTo(bs);
	            String s = new String(bs.getBytes());
	            System.out.println(s);
			} else {
				System.out.println("\nInbound message:");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean handleFault(SOAPMessageContext messageContext) {
		return true;
	}

	public void close(MessageContext messageContext) {
	}

}

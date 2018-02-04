package com.faradice.ocpp.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class HeadHandler implements SOAPHandler<SOAPMessageContext> {

	public Set<QName> getHeaders() {
		return Collections.emptySet();
	}

	public boolean handleMessage(SOAPMessageContext messageContext) {
		try {

			System.out.println("Client : handleMessage()......");
			Boolean isRequest = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

			if (isRequest) {
				System.out.println("\nOutbound message:");
			    SOAPMessage soapMsg = messageContext.getMessage();
	            SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
	            SOAPHeader soapHeader = soapEnv.getHeader();

	            //if no header, add one
	            if (soapHeader == null){
	            		soapHeader = soapEnv.addHeader();
	            }
	            
	            QName qname = new QName("http://www.w3.org/2005/08/addressing/", "chargeBoxIdentity");
	            SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(qname);
	            soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
	            soapHeaderElement.addTextNode("234");
	
	            soapMsg.saveChanges();
	            soapMsg.writeTo(System.out);

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

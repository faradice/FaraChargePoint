package common;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.faradice.faranet.FaraHttp;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

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

				SOAPHeader header = envelope.getHeader(); // addHeader();
				if (header == null) {
					header = envelope.addHeader();
				}
				SOAPElement chargeBoxIdentityElement = header.addChildElement("chargeBoxIdentity", "ns");

				chargeBoxIdentityElement.addTextNode(chargePointID);
				message.saveChanges();
				message.writeTo(bs);
				String s = new String(bs.getBytes());
				System.out.println(s);
			} else {
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
		return null;
		/*
		 * QName chargeBoxIdentytyHeader = new QName("urn://Ocpp/Cs/2012/06/", "chargeBoxIdentity"); HashSet<QName> headers = new HashSet<QName>();
		 * headers.add(chargeBoxIdentytyHeader); System.out.println("got Headers:  " + headers); return headers;
		 */
	}

}

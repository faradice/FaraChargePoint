
package ocpp.cp._2015._10;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageTrigger.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MessageTrigger">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BootNotification"/>
 *     &lt;enumeration value="DiagnosticsStatusNotification"/>
 *     &lt;enumeration value="FirmwareStatusNotification"/>
 *     &lt;enumeration value="Heartbeat"/>
 *     &lt;enumeration value="MeterValues"/>
 *     &lt;enumeration value="StatusNotification"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MessageTrigger")
@XmlEnum
public enum MessageTrigger {

    @XmlEnumValue("BootNotification")
    BOOT_NOTIFICATION("BootNotification"),
    @XmlEnumValue("DiagnosticsStatusNotification")
    DIAGNOSTICS_STATUS_NOTIFICATION("DiagnosticsStatusNotification"),
    @XmlEnumValue("FirmwareStatusNotification")
    FIRMWARE_STATUS_NOTIFICATION("FirmwareStatusNotification"),
    @XmlEnumValue("Heartbeat")
    HEARTBEAT("Heartbeat"),
    @XmlEnumValue("MeterValues")
    METER_VALUES("MeterValues"),
    @XmlEnumValue("StatusNotification")
    STATUS_NOTIFICATION("StatusNotification");
    private final String value;

    MessageTrigger(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MessageTrigger fromValue(String v) {
        for (MessageTrigger c: MessageTrigger.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

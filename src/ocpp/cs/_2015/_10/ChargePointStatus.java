
package ocpp.cs._2015._10;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChargePointStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ChargePointStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Available"/>
 *     &lt;enumeration value="Preparing"/>
 *     &lt;enumeration value="Charging"/>
 *     &lt;enumeration value="SuspendedEV"/>
 *     &lt;enumeration value="SuspendedEVSE"/>
 *     &lt;enumeration value="Finishing"/>
 *     &lt;enumeration value="Reserved"/>
 *     &lt;enumeration value="Faulted"/>
 *     &lt;enumeration value="Unavailable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ChargePointStatus")
@XmlEnum
public enum ChargePointStatus {

    @XmlEnumValue("Available")
    AVAILABLE("Available"),
    @XmlEnumValue("Preparing")
    PREPARING("Preparing"),
    @XmlEnumValue("Charging")
    CHARGING("Charging"),
    @XmlEnumValue("SuspendedEV")
    SUSPENDED_EV("SuspendedEV"),
    @XmlEnumValue("SuspendedEVSE")
    SUSPENDED_EVSE("SuspendedEVSE"),
    @XmlEnumValue("Finishing")
    FINISHING("Finishing"),
    @XmlEnumValue("Reserved")
    RESERVED("Reserved"),
    @XmlEnumValue("Faulted")
    FAULTED("Faulted"),
    @XmlEnumValue("Unavailable")
    UNAVAILABLE("Unavailable");
    private final String value;

    ChargePointStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ChargePointStatus fromValue(String v) {
        for (ChargePointStatus c: ChargePointStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

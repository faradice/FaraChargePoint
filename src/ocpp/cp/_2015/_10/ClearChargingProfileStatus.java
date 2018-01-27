
package ocpp.cp._2015._10;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClearChargingProfileStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClearChargingProfileStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Accepted"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClearChargingProfileStatus")
@XmlEnum
public enum ClearChargingProfileStatus {

    @XmlEnumValue("Accepted")
    ACCEPTED("Accepted"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    ClearChargingProfileStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ClearChargingProfileStatus fromValue(String v) {
        for (ClearChargingProfileStatus c: ClearChargingProfileStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

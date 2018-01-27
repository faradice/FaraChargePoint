
package ocpp.cp._2015._10;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChargingProfilePurposeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ChargingProfilePurposeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ChargePointMaxProfile"/>
 *     &lt;enumeration value="TxDefaultProfile"/>
 *     &lt;enumeration value="TxProfile"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ChargingProfilePurposeType")
@XmlEnum
public enum ChargingProfilePurposeType {

    @XmlEnumValue("ChargePointMaxProfile")
    CHARGE_POINT_MAX_PROFILE("ChargePointMaxProfile"),
    @XmlEnumValue("TxDefaultProfile")
    TX_DEFAULT_PROFILE("TxDefaultProfile"),
    @XmlEnumValue("TxProfile")
    TX_PROFILE("TxProfile");
    private final String value;

    ChargingProfilePurposeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ChargingProfilePurposeType fromValue(String v) {
        for (ChargingProfilePurposeType c: ChargingProfilePurposeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

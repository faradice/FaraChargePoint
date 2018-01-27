
package ocpp.cs._2015._10;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DiagnosticsStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DiagnosticsStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Idle"/>
 *     &lt;enumeration value="Uploaded"/>
 *     &lt;enumeration value="UploadFailed"/>
 *     &lt;enumeration value="Uploading"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DiagnosticsStatus")
@XmlEnum
public enum DiagnosticsStatus {

    @XmlEnumValue("Idle")
    IDLE("Idle"),
    @XmlEnumValue("Uploaded")
    UPLOADED("Uploaded"),
    @XmlEnumValue("UploadFailed")
    UPLOAD_FAILED("UploadFailed"),
    @XmlEnumValue("Uploading")
    UPLOADING("Uploading");
    private final String value;

    DiagnosticsStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DiagnosticsStatus fromValue(String v) {
        for (DiagnosticsStatus c: DiagnosticsStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

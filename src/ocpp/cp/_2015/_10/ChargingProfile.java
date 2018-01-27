
package ocpp.cp._2015._10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ChargingProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChargingProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chargingProfileId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="stackLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="chargingProfilePurpose" type="{urn://Ocpp/Cp/2015/10/}ChargingProfilePurposeType"/>
 *         &lt;element name="chargingProfileKind" type="{urn://Ocpp/Cp/2015/10/}ChargingProfileKindType"/>
 *         &lt;element name="recurrencyKind" type="{urn://Ocpp/Cp/2015/10/}RecurrencyKindType" minOccurs="0"/>
 *         &lt;element name="validFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="validTo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="chargingSchedule" type="{urn://Ocpp/Cp/2015/10/}ChargingSchedule"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChargingProfile", propOrder = {
    "chargingProfileId",
    "transactionId",
    "stackLevel",
    "chargingProfilePurpose",
    "chargingProfileKind",
    "recurrencyKind",
    "validFrom",
    "validTo",
    "chargingSchedule"
})
public class ChargingProfile {

    protected int chargingProfileId;
    protected Integer transactionId;
    protected int stackLevel;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ChargingProfilePurposeType chargingProfilePurpose;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ChargingProfileKindType chargingProfileKind;
    @XmlSchemaType(name = "string")
    protected RecurrencyKindType recurrencyKind;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validFrom;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validTo;
    @XmlElement(required = true)
    protected ChargingSchedule chargingSchedule;

    /**
     * Gets the value of the chargingProfileId property.
     * 
     */
    public int getChargingProfileId() {
        return chargingProfileId;
    }

    /**
     * Sets the value of the chargingProfileId property.
     * 
     */
    public void setChargingProfileId(int value) {
        this.chargingProfileId = value;
    }

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTransactionId(Integer value) {
        this.transactionId = value;
    }

    /**
     * Gets the value of the stackLevel property.
     * 
     */
    public int getStackLevel() {
        return stackLevel;
    }

    /**
     * Sets the value of the stackLevel property.
     * 
     */
    public void setStackLevel(int value) {
        this.stackLevel = value;
    }

    /**
     * Gets the value of the chargingProfilePurpose property.
     * 
     * @return
     *     possible object is
     *     {@link ChargingProfilePurposeType }
     *     
     */
    public ChargingProfilePurposeType getChargingProfilePurpose() {
        return chargingProfilePurpose;
    }

    /**
     * Sets the value of the chargingProfilePurpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargingProfilePurposeType }
     *     
     */
    public void setChargingProfilePurpose(ChargingProfilePurposeType value) {
        this.chargingProfilePurpose = value;
    }

    /**
     * Gets the value of the chargingProfileKind property.
     * 
     * @return
     *     possible object is
     *     {@link ChargingProfileKindType }
     *     
     */
    public ChargingProfileKindType getChargingProfileKind() {
        return chargingProfileKind;
    }

    /**
     * Sets the value of the chargingProfileKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargingProfileKindType }
     *     
     */
    public void setChargingProfileKind(ChargingProfileKindType value) {
        this.chargingProfileKind = value;
    }

    /**
     * Gets the value of the recurrencyKind property.
     * 
     * @return
     *     possible object is
     *     {@link RecurrencyKindType }
     *     
     */
    public RecurrencyKindType getRecurrencyKind() {
        return recurrencyKind;
    }

    /**
     * Sets the value of the recurrencyKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecurrencyKindType }
     *     
     */
    public void setRecurrencyKind(RecurrencyKindType value) {
        this.recurrencyKind = value;
    }

    /**
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFrom(XMLGregorianCalendar value) {
        this.validFrom = value;
    }

    /**
     * Gets the value of the validTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidTo() {
        return validTo;
    }

    /**
     * Sets the value of the validTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidTo(XMLGregorianCalendar value) {
        this.validTo = value;
    }

    /**
     * Gets the value of the chargingSchedule property.
     * 
     * @return
     *     possible object is
     *     {@link ChargingSchedule }
     *     
     */
    public ChargingSchedule getChargingSchedule() {
        return chargingSchedule;
    }

    /**
     * Sets the value of the chargingSchedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargingSchedule }
     *     
     */
    public void setChargingSchedule(ChargingSchedule value) {
        this.chargingSchedule = value;
    }

}

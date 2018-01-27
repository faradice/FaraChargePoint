
package ocpp.cp._2015._10;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines the SendLocalList.req PDU
 * 
 * <p>Java class for SendLocalListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SendLocalListRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="localAuthorizationList" type="{urn://Ocpp/Cp/2015/10/}AuthorizationData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="updateType" type="{urn://Ocpp/Cp/2015/10/}UpdateType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendLocalListRequest", propOrder = {
    "listVersion",
    "localAuthorizationList",
    "updateType"
})
public class SendLocalListRequest {

    protected int listVersion;
    protected List<AuthorizationData> localAuthorizationList;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected UpdateType updateType;

    /**
     * Gets the value of the listVersion property.
     * 
     */
    public int getListVersion() {
        return listVersion;
    }

    /**
     * Sets the value of the listVersion property.
     * 
     */
    public void setListVersion(int value) {
        this.listVersion = value;
    }

    /**
     * Gets the value of the localAuthorizationList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the localAuthorizationList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocalAuthorizationList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuthorizationData }
     * 
     * 
     */
    public List<AuthorizationData> getLocalAuthorizationList() {
        if (localAuthorizationList == null) {
            localAuthorizationList = new ArrayList<AuthorizationData>();
        }
        return this.localAuthorizationList;
    }

    /**
     * Gets the value of the updateType property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateType }
     *     
     */
    public UpdateType getUpdateType() {
        return updateType;
    }

    /**
     * Sets the value of the updateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateType }
     *     
     */
    public void setUpdateType(UpdateType value) {
        this.updateType = value;
    }

}

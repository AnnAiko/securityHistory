package security.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class SecurityData {

    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "rows")
    private Securities rows;

    public SecurityData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Securities getSecurities() {
        return rows;
    }

    public void setSecurities(Securities rows) {
        this.rows = rows;
    }

    public String toString() {
        return rows.toString();
    }
}

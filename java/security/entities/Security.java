package security.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.FIELD)
public class Security {

    @XmlAttribute(name = "id")
    private int id;
    @XmlAttribute(name = "secid")
    private String secid;
    @XmlAttribute(name = "regnumber")
    private String regnumber;
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "emitent_title")
    private String emitent;
    @XmlAttribute(name = "primary_boardid")
    private String boardid;

    public Security() {

    }

    public Security(int id, String secid, String name) {
        this.id = id;
        this.secid = secid;
        this.name = name;
    }

    public Security(int id, String secid, String regnumber, String name,
            String emitent, String boardid) {
        this.id = id;
        this.secid = secid;
        this.name = name;
        this.regnumber = regnumber;
        this.emitent = emitent;
        this.boardid = boardid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecid() {
        return secid;
    }

    public void setSecid(String secid) {
        this.secid = secid;
    }

    public String getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmitent() {
        return emitent;
    }

    public void setEmitent(String emitent) {
        this.emitent = emitent;
    }

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public String toString() {
        return id + "\n " + secid + "\n " + regnumber + "\n " + name
                + "\n " + emitent + "\n " + boardid;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package history.entitiens;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class HistoryData {

    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "rows")
    private Histories histories;

    public HistoryData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Histories getHistories() {
        return histories;
    }

    public void setHistories(Histories histories) {
        this.histories = histories;
    }

    public String toString() {
        return histories.toString();
    }
}

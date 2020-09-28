package security.entities;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "document")
@XmlAccessorType(XmlAccessType.FIELD)
public class SecurityDocument {

    @XmlElement(name = "data")
    private SecurityData data;

    public SecurityDocument() {
        super();
    }

    public SecurityData getData() {
        return data;
    }

    public void setData(SecurityData data) {
        this.data = data;
    }

    /*public void setList(ArrayList<Data> list) {
        this.list = list;
    }

    public Data getElemnt() {
        return list.get(0);
    }

    public boolean add(Data emp) {
        return list.add(emp);
    }*/
    @Override
    public String toString() {
        return data.toString();
    }
}

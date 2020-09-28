package security.entities;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rows")
@XmlAccessorType(XmlAccessType.FIELD)
public class Securities {

    @XmlElement(name = "row")
    private ArrayList<Security> list = new ArrayList<Security>();

    public Securities() {
    }

    public void setList(ArrayList<Security> list) {
        this.list = list;
    }

    public ArrayList<Security> getList() {
        return list;
    }

    public Security getElement(int id) {
        return list.get(id);
    }

    public boolean add(Security emp) {
        return list.add(emp);
    }

    @Override
    public String toString() {
        return "Histories [list=" + list + "]";
    }
}

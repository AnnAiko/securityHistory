package history.entitiens;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rows")
@XmlAccessorType(XmlAccessType.FIELD)
public class Histories {

    @XmlElement(name = "row")
    private ArrayList<History> list = new ArrayList<History>();

    public Histories() {
    }

    public void setList(ArrayList< History> list) {
        this.list = list;
    }

    public ArrayList<History> getList() {
        return list;
    }

    public History getElement(int id) {
        return list.get(id);
    }

    public boolean add(History emp) {
        return list.add(emp);
    }

    @Override
    public String toString() {
        return "Histories [list=" + list + "]";
    }
}

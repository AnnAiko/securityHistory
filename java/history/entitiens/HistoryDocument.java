package history.entitiens;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "document")
@XmlAccessorType(XmlAccessType.FIELD)
public class HistoryDocument {

    @XmlElement(name = "data")
    private ArrayList<HistoryData> list = new ArrayList<HistoryData>();

    public HistoryDocument() {
        super();
    }

    public void setList(ArrayList<HistoryData> list) {
        this.list = list;
    }

    public HistoryData getElemnt() {
        return list.get(0);
    }

    public boolean add(HistoryData emp) {
        return list.add(emp);
    }

    @Override
    public String toString() {
        return "Date [list=" + list + "]";
    }
}

package history.entitiens;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.FIELD)
public class History {

    private int id;
    @XmlAttribute(name = "SECID")
    private String secid;
    @XmlAttribute(name = "BOARDID")
    private String boardid;
    @XmlAttribute(name = "TRADEDATE")
    private String tradedate;
    @XmlAttribute(name = "NUMTRADES")
    private String numtrades;
    @XmlAttribute(name = "OPEN")
    private String open;
    @XmlAttribute(name = "CLOSE")
    private String close;
    @XmlAttribute(name = "LOW")
    private String low;
    @XmlAttribute(name = "HIGH")
    private String high;

    public History() {
        // необходим для маршаллизации/демаршалиизации XML
    }

    public History(int id, String secid, String boardid, String tradedate,
            String numtrades, String open, String close, String low, String high) {
        this.id = id;
        this.secid = secid;
        this.boardid = boardid;
        this.tradedate = tradedate;
        this.numtrades = numtrades;
        this.open = open;
        this.close = close;
        this.low = low;
        this.high = high;
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

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public String getTradedate() {
        return tradedate;
    }

    public void setTradedate(String tradedate) {
        this.tradedate = tradedate;
    }

    public String getNumtrades() {
        return numtrades;
    }

    public void setNumtrades(String numtrades) {
        this.numtrades = numtrades;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String id) {
        this.high = high;
    }

    public String toString() {
        return tradedate + "\n " + secid + "\n " + numtrades + "\n" + open;
    }
}

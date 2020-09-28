package bd;

public class SecurityHistory {

    private String secid;
    private String regnumber;
    private String name;
    private String emitent;
    private String tradedate;
    private int numtrades;
    private String open;
    private String close;

    public SecurityHistory(String secid, String regnumber, String name,
            String emitent, String tradedate, int numtrades,
            String open, String close) {
        this.secid = secid;
        this.name = name;
        this.regnumber = regnumber;
        this.emitent = emitent;
        this.tradedate = tradedate;
        this.numtrades = numtrades;
        this.open = open;
        this.close = close;
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

    public String getTradedate() {
        return tradedate;
    }

    public void setTradedate(String tradedate) {
        this.tradedate = tradedate;
    }

    public int getNumtrades() {
        return numtrades;
    }

    public void setNumtrades(int numtrades) {
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
}

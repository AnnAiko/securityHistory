package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import security.entities.Security;

public class SelectBD {

    /*Получить список ценных бумаг*/
    public ArrayList<SecurityHistory> getListSecurityHistory(String sort,
            String emitent, String date)
            throws ClassNotFoundException, SQLException {
        ConnectionBD con = new ConnectionBD();
        Connection connection = con.connect();
        ArrayList<SecurityHistory> list = new ArrayList<SecurityHistory>();
        Security security = new Security();
        String SQL = "SELECT secids.secid, listSecurity.regnumber,"
                + "listSecurity.namesecurity, listSecurity.emitenttitle, "
                + "histories.tradedate, histories.Numtrades, "
                + "histories.OpenHis, histories.CloseHis "
                + "FROM listSecurity "
                + "LEFT JOIN histories ON listSecurity.idSecid=histories.idSecid "
                + "LEFT JOIN secids ON listSecurity.idSecid=secids.id "
                + "WHERE (listSecurity.emitenttitle LIKE '%" + emitent + "%') "
                + "OR (histories.tradedate LIKE '%" + date + "%')"
                + "ORDER BY " + sort;// + " LIMIT 25 OFFSET ?"
        PreparedStatement pS = connection.prepareStatement(SQL);
        //pS.setInt(1, 1);
        ResultSet resultSet = pS.executeQuery();
        while (resultSet.next()) {
            list.add(new SecurityHistory(
                    resultSet.getString("secid"),
                    resultSet.getString("regnumber"),
                    resultSet.getString("namesecurity"),
                    resultSet.getString("emitenttitle"),
                    resultSet.getString("tradedate"),
                    resultSet.getInt("numtrades"),
                    resultSet.getString("openhis"),
                    resultSet.getString("closehis"))
            );
        }
        resultSet.close();
        pS.close();
        connection.close();
        return list;
    }
}

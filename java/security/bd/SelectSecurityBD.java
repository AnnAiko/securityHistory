package security.bd;

import bd.ConnectionBD;
import security.entities.Security;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/*Получить данные из базы данных*/
public class SelectSecurityBD {

    /*Получить id secisd*/
    public int getIdSecid(Connection connection, String secid) throws ClassNotFoundException, SQLException {
        int id = 0;
        String SQLSelectSecid = "SELECT id FROM secids WHERE secid=? ";
        PreparedStatement pSelectSecid = connection.prepareStatement(SQLSelectSecid);
        pSelectSecid.setString(1, secid);
        ResultSet resSelectSecid = pSelectSecid.executeQuery();
        while (resSelectSecid.next()) {
            id = resSelectSecid.getInt("id");
        }
        resSelectSecid.close();
        pSelectSecid.close();
        return id;
    }

    /*Получить id boardid*/
    public int getBoardid(Connection connection, String boardid) throws ClassNotFoundException, SQLException { //
        int id = 0;
        String SQLSelectBoardid = "SELECT id FROM boardids WHERE boardid=? ";
        PreparedStatement pSelectBoardid = connection.prepareStatement(SQLSelectBoardid);
        pSelectBoardid.setString(1, boardid);
        ResultSet resSelectBoardid = pSelectBoardid.executeQuery();
        while (resSelectBoardid.next()) {
            id = resSelectBoardid.getInt("id");
        }
        resSelectBoardid.close();
        pSelectBoardid.close();
        return id;
    }

    /*Получить список ценных бумаг*/
    public ArrayList<Security> getListSecurity(int page) throws ClassNotFoundException, SQLException { //Connection connection
        ConnectionBD con = new ConnectionBD();
        Connection connection = con.connect();
        ArrayList<Security> list = new ArrayList<Security>();
        Security security = new Security();
        String SQL = "SELECT listSecurity.id, secids.secid, "
                + "listSecurity.namesecurity FROM listSecurity "
                + "LEFT JOIN secids ON listSecurity.idSecid=secids.id "
                + "ORDER BY id LIMIT 25 OFFSET ?";
        PreparedStatement pS = connection.prepareStatement(SQL);
        pS.setInt(1, (page * 25) + 1);
        ResultSet resultSet = pS.executeQuery();
        while (resultSet.next()) {
            list.add(new Security(
                    resultSet.getInt("id"),
                    resultSet.getString("secid"),
                    resultSet.getString("namesecurity"))
            );
        }
        resultSet.close();
        pS.close();
        connection.close();
        return list;
    }

    /*Получить все данные ценной бумаги*/
    public Security getInfoSecurity(int id) throws ClassNotFoundException, SQLException {  //Connection connection, 
        ConnectionBD con = new ConnectionBD();
        Connection connection = con.connect();
        Security security = new Security();
        String SQL = "SELECT secids.secid, listSecurity.regnumber, "
                + "listSecurity.namesecurity, listSecurity.emitenttitle, "
                + "boardids.Boardid FROM listSecurity "
                + "LEFT JOIN secids ON listSecurity.idSecid=secids.id "
                + "LEFT JOIN boardids ON listSecurity.PrimaryBoardid=boardids.id WHERE listSecurity.id=? ";
        PreparedStatement pS = connection.prepareStatement(SQL);
        pS.setInt(1, id);
        ResultSet resultSet = pS.executeQuery();
        while (resultSet.next()) {
            security.setSecid(resultSet.getString("secid"));
            security.setRegnumber(resultSet.getString("Regnumber"));
            security.setName(resultSet.getString("namesecurity"));

            security.setEmitent(resultSet.getString("emitenttitle"));
            security.setBoardid(resultSet.getString("Boardid"));
        }
        resultSet.close();
        pS.close();
        connection.close();
        return security;
    }

    /*Получить количество записей*/
    public int getCountRow(Connection connection) throws ClassNotFoundException, SQLException {
        String SQL = "SELECT count(*) FROM listSecurity";
        PreparedStatement preparedStatementWA = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatementWA.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        return count;
    }
}

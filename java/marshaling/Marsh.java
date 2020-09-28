package marshaling;

import history.bd.InsertHistoryBD;
import history.entitiens.HistoryDocument;
import security.entities.SecurityDocument;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import security.bd.InsertSecurityBD;

public class Marsh {

    public void unmarchSecurity(String path) {
        try {
            JAXBContext jc = JAXBContext.newInstance(SecurityDocument.class);
            //Экземпляр класса для демаршализации 
            Unmarshaller u = jc.createUnmarshaller();
            //Файл для чтения
            FileReader reader = new FileReader(path);
            //Записать в объект из файла
            SecurityDocument doc = (SecurityDocument) u.unmarshal(reader);
            InsertSecurityBD insert = new InsertSecurityBD();
            try {
                insert.setSecurity(doc);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
            //Если не нашли файл
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void unmarchHistory(String path) {
        try {
            JAXBContext jc = JAXBContext.newInstance(HistoryDocument.class);
            //Экземпляр класса для демаршализации 
            Unmarshaller u = jc.createUnmarshaller();
            //Файл для чтения
            FileReader reader = new FileReader(path);
            //Записать в объект из файла
            HistoryDocument doc = (HistoryDocument) u.unmarshal(reader);
            InsertHistoryBD insert = new InsertHistoryBD();
            try {
                insert.setHistory(doc);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
            //Если не нашли файл
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

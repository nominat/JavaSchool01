package de.telekom.school.dao;

import de.telekom.school.persistence.DriverPO;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

public class DriverDAO extends AbstractDAO<DriverPO> {

    public List<DriverPO> getDriverByNumber(String driverNumber) {
        Session session = sessions.openSession();
        List<DriverPO> driver = null;
        try {
            Query query = session.createQuery("select c from DriverPO c where c.driverNumber = :number").setString("number", driverNumber);
            driver = query.list();
        } catch (Exception  e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return  driver;
    }
}

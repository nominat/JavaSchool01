package de.telekom.school.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import de.telekom.school.persistence.DriverStatusPO;
import java.util.List;

public class DriverStatusDAO extends AbstractDAO<DriverStatusPO> {


    public List<DriverStatusPO> getAllDriverStatuses() {
        Session session = sessions.openSession();
        List<DriverStatusPO> status = null;
        try {
            Query query = session.createQuery("select c from DriverStatusPO c");
            status = query.list();
        } catch (Exception  e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return  status;
    }
}

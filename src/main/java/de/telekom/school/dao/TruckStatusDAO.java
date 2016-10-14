package de.telekom.school.dao;

import de.telekom.school.persistence.TruckStatusPO;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;


public class TruckStatusDAO extends AbstractDAO<TruckStatusPO> {

    public List<TruckStatusDAO> getAllTruckStatuses() {
        Session session = sessions.openSession();
        List<TruckStatusDAO> status = null;
        try {
            Query query = session.createQuery("select c from TruckStatusPO c");
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

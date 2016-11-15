package de.telekom.school.dao;

import de.telekom.school.persistence.TruckStatusPO;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;


public class TruckStatusDAO extends AbstractDAO<TruckStatusPO> {

    public List<TruckStatusPO> getAllTruckStatuses() {
        Session session = sessions.openSession();
        List<TruckStatusPO> status = null;
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

    public List<TruckStatusPO> getTruckStatusByName(String statusName) {
        Session session = sessions.openSession();
        List<TruckStatusPO> city = null;
        try {
            Query query = session.createQuery("select c from TruckStatusPO c where c.status = :name").setString("name", statusName);
            city = query.list();
        } catch (Exception  e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return  city;
    }
}

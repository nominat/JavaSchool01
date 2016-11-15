package de.telekom.school.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import de.telekom.school.persistence.TruckPO;
import java.util.List;

public class TruckDAO extends AbstractDAO<TruckPO> {

    public List<TruckPO> getTruckByNumber(String truckNumber) {
        Session session = sessions.openSession();
        List<TruckPO> truck = null;
        try {
            Query query = session.createQuery("select c from TruckPO c where c.truckNumber = :number").setString("number", truckNumber);
            truck = query.list();
        } catch (Exception  e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return  truck;
    }

}

package de.telekom.school.dao;

import de.telekom.school.persistence.CargoStatusPO;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

public class CargoStatusDAO extends AbstractDAO<CargoStatusPO> {

    public List<CargoStatusDAO> getAllDriverStatuses() {
        Session session = sessions.openSession();
        List<CargoStatusDAO> status = null;
        try {
            Query query = session.createQuery("select c from CargoStatusPO c");
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




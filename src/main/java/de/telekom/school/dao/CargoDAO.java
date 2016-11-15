package de.telekom.school.dao;

import de.telekom.school.persistence.CargoPO;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

public class CargoDAO  extends AbstractDAO<CargoPO>  {

    public List<CargoPO> getTruckByNumber(String cargoNumber) {
        Session session = sessions.openSession();
        List<CargoPO> cargo = null;
        try {
            Query query = session.createQuery("select c from CargoPO c where c.cargoNumber = :number").setString("number", cargoNumber);
            cargo = query.list();
        } catch (Exception  e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return  cargo;
    }
}

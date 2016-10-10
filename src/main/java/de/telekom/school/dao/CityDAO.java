package de.telekom.school.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import de.telekom.school.persistence.CitiesPO;

import java.util.List;

public class CityDAO extends AbstractDAO<CitiesPO> {
    public List<CitiesPO> getCityByName(String cityName) {
        Session session = sessions.openSession();
        List<CitiesPO> city = null;
        try {
            Query query = session.createQuery("select c from CitiesPO c where c.cityName = :name").setString("name", cityName);
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

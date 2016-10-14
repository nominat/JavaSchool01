package de.telekom.school.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import de.telekom.school.persistence.CityMapPO;

import java.util.List;

public class CityMapDAO extends AbstractDAO<CityMapPO> {

    public List<CityMapPO> getDistanceBetweenCities(String firstCityId, String secondCityId) {
        Session session = sessions.openSession();
        List<CityMapPO> cityMap = null;
        try {
            Query query = session.createQuery("select d from CityMapPO d where d.id_city1 = :firstCityId and d.id_city2 = :secondCityId").setString("firstCityId", firstCityId).setString("secondCityId", secondCityId);
            cityMap = query.list();
        } catch (Exception  e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return  cityMap;
    }
}

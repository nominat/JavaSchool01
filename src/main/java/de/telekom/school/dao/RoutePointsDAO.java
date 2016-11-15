package de.telekom.school.dao;

import de.telekom.school.persistence.RoutePointsPO;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

public class RoutePointsDAO extends AbstractDAO<RoutePointsPO> {

	public List<RoutePointsPO> getRoutePointsByCityFrom(String cityFrom) {
		Session session = sessions.openSession();
		List<RoutePointsPO> points = null;
		try {
			Query query = session.createQuery("select c from RoutePointsPO c where c.cityFrom = :number").setString("number", cityFrom);
			points = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return points;
	}
			
	public List<RoutePointsPO> getRoutePointsByCityTo(String cityTo) {
		Session session = sessions.openSession();
		List<RoutePointsPO> points = null;
		try {
			Query query = session.createQuery("select c from RoutePointsPO c where c.cityTo = :number").setString("number", cityTo);
			points = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return points;
	}
}

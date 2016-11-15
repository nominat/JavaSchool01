package de.telekom.school.dao;

import de.telekom.school.persistence.OrderPO;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

public class OrderDAO extends AbstractDAO<OrderPO> {

    public List<OrderPO> getOrderByNumber(String orderNumber) {
        Session session = sessions.openSession();
        List<OrderPO> order = null;
        try {
            Query query = session.createQuery("select c from OrderPO c where c.uniqNumber = :number").setString("number", orderNumber);
            order = query.list();
        } catch (Exception  e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return  order;
    }
}

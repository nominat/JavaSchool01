package de.telekom.school.servlet;

import de.telekom.school.dao.CityDAO;
import de.telekom.school.persistence.CitiesPO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.sql.SQLException;
import de.telekom.school.service.AdminServiceImpl;
/**
 * Created by Илья on 10-Oct-16.
 */
public class AddDistance extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AdminServiceImpl service = new AdminServiceImpl();
        String cityName1 =  request.getParameter("cityName1");
        String cityName2 = request.getParameter("cityName2");
        String distance = request.getParameter("distance");
        String resp = service.addCityMap(cityName1, cityName2, distance);
        response.setStatus(200);
        response.addHeader("result", resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

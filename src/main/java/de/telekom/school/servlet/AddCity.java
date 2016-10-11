package de.telekom.school.servlet;

import de.telekom.school.dao.CityDAO;
import de.telekom.school.persistence.CitiesPO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import de.telekom.school.service.AdminServiceImpl;


public class AddCity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminServiceImpl service = new AdminServiceImpl();
        String cityName =  request.getParameter("cityName");
        service.addCity(cityName);
    }
}

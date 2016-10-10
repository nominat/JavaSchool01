package de.telekom.school.servlet;

import de.telekom.school.dao.CityDAO;
import de.telekom.school.persistence.CitiesPO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class AddCity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CityDAO cityDAO = new CityDAO();
        CitiesPO city = new CitiesPO();
        city.setCityName(request.getParameter("cityName"));

        try {
            cityDAO.add(city);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

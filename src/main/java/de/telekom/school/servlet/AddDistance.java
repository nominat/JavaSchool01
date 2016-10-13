package de.telekom.school.servlet;

import de.telekom.school.dao.CityDAO;
import de.telekom.school.persistence.CitiesPO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamCorruptedException;
import java.sql.SQLException;
import de.telekom.school.service.AdminServiceImpl;
import org.json.simple.JSONObject;

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

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        JSONObject myObj = new JSONObject();
        if(resp == "success"){
            myObj.put("success", true);

        }
        else {
            myObj.put("success", false);
        }
        myObj.put("cityMap", cityName1 + " " + cityName2);
        out.println(myObj.toString());

        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package de.telekom.school.servlet;

import de.telekom.school.dao.CityDAO;
import de.telekom.school.persistence.CitiesPO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import org.json.simple.JSONObject;
import de.telekom.school.service.AdminServiceImpl;


public class AddCity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminServiceImpl service = new AdminServiceImpl();
        String cityName =  request.getParameter("cityName");
        String resp = service.addCity(cityName);

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
        myObj.put("cityName", cityName);
        out.println(myObj.toString());

        out.close();



    }
}

package de.telekom.school.servlet;

import de.telekom.school.persistence.CitiesPO;
import de.telekom.school.service.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class GetCities extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminServiceImpl service = new AdminServiceImpl();
        List<CitiesPO> cities = service.getAllCities();
        JSONObject json = new JSONObject();
        JSONArray list = new JSONArray();
        for ( CitiesPO city : cities) {
            list.add(city.getCityName());
        }
        json.put("cities", list);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}

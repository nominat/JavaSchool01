package de.telekom.school.service;

import de.telekom.school.persistence.CitiesPO;
import de.telekom.school.dao.CityDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;


public class AdminServiceImpl implements AdminService {

    private CityDAO cityDAO = new CityDAO();

    public void addCity(String cityName) {
        CitiesPO city = new CitiesPO();
        city.setCityName(cityName);
        try {
            cityDAO.add(city);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CitiesPO> getCitiesListByName(String cityName) {
        return cityDAO.getCityByName(cityName);
    }
}

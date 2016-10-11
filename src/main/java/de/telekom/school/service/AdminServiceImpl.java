package de.telekom.school.service;

import de.telekom.school.dao.CityMapDAO;
import de.telekom.school.persistence.CitiesPO;
import de.telekom.school.dao.CityDAO;
import de.telekom.school.persistence.CityMapPO;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;


public class AdminServiceImpl implements AdminService {

    private CityDAO cityDAO = new CityDAO();
    private CityMapDAO cityMapDAO = new CityMapDAO();

    public void addCity(String cityName) {
        CitiesPO city = new CitiesPO();
        city.setCityName(cityName);
        try {
            cityDAO.add(city);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String addCityMap(String firstCityName, String secondCityName, String distance) {
        CitiesPO city1 = cityDAO.getCityByName(firstCityName).get(0);
        CitiesPO city2 = cityDAO.getCityByName(secondCityName).get(0);
        String response = new String();
        List<CityMapPO> cityMaps = this.getDistanceBetweenCities(firstCityName, secondCityName);
        if (cityMaps.size() == 0) {
            CityMapPO cityMap = new CityMapPO();
            cityMap.setFirstCityId(city1);
            cityMap.setSecondCityId(city2);
            cityMap.setDistance(Integer.valueOf(distance));
            try {
                cityMapDAO.add(cityMap);
                response = "added successfull";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response = "this map already exist";
        }

        return response;
    }

    public List<CitiesPO> getCitiesListByName(String cityName) {
        return cityDAO.getCityByName(cityName);
    }

    public List<CityMapPO> getDistanceBetweenCities(String firstCityName, String secondCityName) {
        CitiesPO city1 = cityDAO.getCityByName(firstCityName).get(0);
        CitiesPO city2 = cityDAO.getCityByName(secondCityName).get(0);
        Long city1Id = city1.getId();
        Long city2Id = city2.getId();
        return cityMapDAO.getDistanceBetweenCities(city1Id.toString(), city2Id.toString());
    }
}

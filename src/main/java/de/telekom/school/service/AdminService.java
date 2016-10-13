package de.telekom.school.service;

import de.telekom.school.persistence.CitiesPO;
import de.telekom.school.persistence.CityMapPO;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface AdminService {
    String addCity(String cityName);
    String addCityMap(String firstCityName, String secondCityName, String distance);

    List<CitiesPO> getCitiesListByName(String cityName);
    List<CitiesPO> getAllCities();
    List<CityMapPO> getDistanceBetweenCities(String city1, String city2);
}

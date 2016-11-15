package de.telekom.school.service;

import de.telekom.school.persistence.CitiesPO;
import de.telekom.school.persistence.CityMapPO;

import java.util.List;

public interface AdminService {
    String addCity(String cityName);
    String addCityMap(String firstCityName, String secondCityName, String distance);

    List<CitiesPO> getCitiesListByName(String cityName);
    List<CitiesPO> getAllCities();
    List<CityMapPO> getDistanceBetweenCities(String city1, String city2);
    //TODO write methods signature
}

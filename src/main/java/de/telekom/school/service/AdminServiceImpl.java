package de.telekom.school.service;

import de.telekom.school.dao.*;
import de.telekom.school.persistence.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;


public class AdminServiceImpl implements AdminService {

    private CityDAO cityDAO = new CityDAO();
    private CityMapDAO cityMapDAO = new CityMapDAO();
    private CitiesPO cityPO = new CitiesPO();
    private DriverStatusDAO driverStatusDAO = new DriverStatusDAO();
    private CargoStatusDAO cargoStatusDAO = new CargoStatusDAO();
    private TruckStatusDAO truckStatusDAO = new TruckStatusDAO();

    public String addCity(String cityName) {
        List<CitiesPO> cities = this.getCitiesListByName(cityName);
        String resp = new String();
        if (cities.size() == 0) {
            CitiesPO city = new CitiesPO();
            city.setCityName(cityName);
            try {
                cityDAO.add(city);
                resp = "success";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            resp = "already exist";
        }
        return resp;

    }

    public String addDriverStatus(String driverStatus) {
        DriverStatusPO status = new DriverStatusPO();
        status.setStatus(driverStatus);
        String resp = "";
        try {
            driverStatusDAO.add(status);
            resp = "success";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resp;
    }

    public String addCargoStatus(String cargoStatus) {
        CargoStatusPO status = new CargoStatusPO();
        status.setStatus(cargoStatus);
        String resp = "";
        try {
            cargoStatusDAO.add(status);
            resp = "success";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resp;
    }

    public String addTruckStatus(String truckStatus) {
        TruckStatusPO status = new TruckStatusPO();
        status.setStatus(truckStatus);
        String resp = "";
        try {
            truckStatusDAO.add(status);
            resp = "success";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resp;
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
                response = "success";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response = "already exist";
        }

        return response;
    }

    public List<CitiesPO> getCitiesListByName(String cityName) {
        return cityDAO.getCityByName(cityName);
    }

    public List<CitiesPO> getAllCities() {
         return cityDAO.getAll(cityPO);
    }

    public List<CityMapPO> getDistanceBetweenCities(String firstCityName, String secondCityName) {
        CitiesPO city1 = cityDAO.getCityByName(firstCityName).get(0);
        CitiesPO city2 = cityDAO.getCityByName(secondCityName).get(0);
        Long city1Id = city1.getId();
        Long city2Id = city2.getId();
        return cityMapDAO.getDistanceBetweenCities(city1Id.toString(), city2Id.toString());
    }
}

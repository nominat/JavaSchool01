package de.telekom.school.service;

import de.telekom.school.persistence.CitiesPO;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface AdminService {
    void addCity(String cityName);

    List<CitiesPO> getCitiesListByName(String cityName);
}

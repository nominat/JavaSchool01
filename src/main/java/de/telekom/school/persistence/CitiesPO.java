package de.telekom.school.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "cities")
public class CitiesPO extends AbstractPO implements Serializable {

    @Column(name = "cityName")
    private String cityName;

    public CitiesPO() {
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String name) {
        this.cityName = name;
    }
    @Override
    public String toString() {
        return "City{name = " + this.cityName + "}";
    }

}

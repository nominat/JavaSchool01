package de.telekom.school.persistence;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "citymap")
public class CityMapPO extends AbstractPO implements Serializable{

    @Column(name = "firstcity")
    private String firstCityName;

    @Column(name = "secondcity")
    private String secondCityName;

    @Column(name = "distance")
    private long distance;

    public String getFirstCityName() {
        return this.firstCityName;
    }
    public  void setFirstCityName(String name) {
        this.firstCityName = name;
    }

    public String getSecondCityName() {
        return this.secondCityName;
    }
    public  void setSecondCityName(String name) {
        this.secondCityName = name;
    }

    public long getDistance() {
        return this.distance;
    }
    public  void setDistance(long distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "CityMap{firstCity = " + this.firstCityName + ", secondCity = " + this.secondCityName + ", distance = " + this.distance + "}";
    }
}

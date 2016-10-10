package de.telekom.school.persistence;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "citymap")
public class CityMapPO extends AbstractPO implements Serializable{

    @ManyToOne
    @JoinColumn(name = "cityname")
    @Column(name = "firstcity")
    private CitiesPO firstCityName;

    @ManyToOne
    @JoinColumn(name = "cityname")
    @Column(name = "secondcity")
    private CitiesPO secondCityName;

    @Column(name = "distance")
    private Long distance;

    public CitiesPO getFirstCityName() {
        return this.firstCityName;
    }
    public  void setFirstCityName(CitiesPO name) {
        this.firstCityName = name;
    }

    public CitiesPO getSecondCityName() {
        return this.secondCityName;
    }
    public  void setSecondCityName(CitiesPO name) {
        this.secondCityName = name;
    }

    public long getDistance() {
        return this.distance;
    }
    public  void setDistance(Long distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "CityMap{firstCity = " + this.firstCityName + ", secondCity = " + this.secondCityName + ", distance = " + this.distance + "}";
    }
}

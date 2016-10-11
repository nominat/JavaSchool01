package de.telekom.school.persistence;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "citymap")
public class CityMapPO extends AbstractPO implements Serializable{

    @ManyToOne
    @JoinColumn(name = "id_city1")
    //@Column(name = "id_city1")
    private CitiesPO id_city1;

    @ManyToOne
    @JoinColumn(name = "id_city2")
    //@Column(name = "id_city1")
    private CitiesPO id_city2;

    @Column(name = "distance")
    private Integer distance;

    public CitiesPO getFirstCityId() {
        return this.id_city1;
    }
    public  void setFirstCityId(CitiesPO name) {
        this.id_city1 = name;
    }

    public CitiesPO getSecondCityId() {
        return this.id_city2;
    }
    public  void setSecondCityId(CitiesPO name) {
        this.id_city2 = name;
    }

    public long getDistance() {
        return this.distance;
    }
    public  void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "CityMap{firstCity = " + this.id_city1 + ", secondCity = " + this.id_city2 + ", distance = " + this.distance + "}";
    }
}

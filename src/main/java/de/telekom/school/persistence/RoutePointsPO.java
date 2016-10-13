package de.telekom.school.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "routepoints")
public class RoutePointsPO extends AbstractPO implements Serializable {
    private CitiesPO cityFrom;
    private CitiesPO cityTo;
    private CargoPO cargo;

    public RoutePointsPO() {
    }

    @ManyToOne
    @JoinColumn(name = "cityFrom")
    public CitiesPO getCityFrom() {
        return this.cityFrom;
    }

    public void setCityFrom(CitiesPO cityFrom) {
        this.cityFrom = cityFrom;
    }

    @ManyToOne
    @JoinColumn(name = "cityTo")
    public CitiesPO getCityTo() {
        return this.cityTo;
    }

    public void setCityTo(CitiesPO cityTo) {
        this.cityTo = cityTo;
    }

    @OneToOne
    @JoinColumn(name = "cargo")
    public CargoPO getCargo() {
        return this.cargo;
    }

    public void setCargo(CargoPO cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutePointsPO that = (RoutePointsPO) o;

        if (cityFrom != null ? !cityFrom.equals(that.cityFrom) : that.cityFrom != null) return false;
        if (cityTo != null ? !cityTo.equals(that.cityTo) : that.cityTo != null) return false;
        return cargo != null ? cargo.equals(that.cargo) : that.cargo == null;

    }

    @Override
    public int hashCode() {
        int result = cityFrom != null ? cityFrom.hashCode() : 0;
        result = 31 * result + (cityTo != null ? cityTo.hashCode() : 0);
        result = 31 * result + (cargo != null ? cargo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RoutePointsPO{" +
                "cityFrom=" + cityFrom +
                ", cityTo=" + cityTo +
                ", cargo=" + cargo +
                '}';
    }
}

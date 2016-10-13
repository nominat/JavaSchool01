package de.telekom.school.persistence;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "cargostatus")
public class CargoStatusPO extends AbstractPO implements Serializable {
    private String status;

    public CargoStatusPO() {
    }

    @Column(name = "CargoStatus", nullable = false, length = 15)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CargoStatusPO that = (CargoStatusPO) o;

        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        return status != null ? status.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CargoStatusPO{" +
                "status='" + status + '\'' +
                '}';
    }


}

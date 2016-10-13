package de.telekom.school.persistence;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "truckstatus")
public class TruckStatusPO extends AbstractPO implements Serializable {
    private String status;

    public TruckStatusPO() {
    }

    @Column(name = "truckstatus", nullable = false, length = 15)
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

        TruckStatusPO that = (TruckStatusPO) o;

        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        return status != null ? status.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TruckStatusPO{" +
                "status='" + status + '\'' +
                '}';
    }


}

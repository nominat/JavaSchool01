package de.telekom.school.persistence;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "driverstatus")
public class DriverStatusPO extends AbstractPO implements Serializable {

    @Column(name = "status")
    private String status;

    public DriverStatusPO() {
    }

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

        DriverStatusPO that = (DriverStatusPO) o;

        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        return status != null ? status.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DriverStatusPO{" +
                "status='" + status + '\'' +
                '}';
    }
}

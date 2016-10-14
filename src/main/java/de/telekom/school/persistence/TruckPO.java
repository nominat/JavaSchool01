package de.telekom.school.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "trucks")
public class TruckPO extends AbstractPO implements Serializable {
    private String truckNumber;
    private Integer driversCount;
    private Integer capacityTonn;
    private Integer capacityKg;
    private CitiesPO currentCity;
    private TruckStatusPO truckStatus;

    public TruckPO() {
    }

    @Column(name = "truckNumber")
    public String getTruckNumber() {
        return this.truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    @Column(name = "driversCount")
    public Integer getDriversCount() {
        return this.driversCount;
    }

    public void setDriversCount(Integer driversCount) {
        this.driversCount = driversCount;
    }

    @Column(name = "capacityTonn")
    public Integer getCapacityTonn() {
        return this.capacityTonn;
    }

    public void setCapacityTonn(Integer capacityTonn) {
        this.capacityTonn = capacityTonn;
    }

    @Transient
    public Integer getCapacityKg() {
        return this.capacityKg;
    }
    public void setCapacityKg() {
        this.capacityKg = this.capacityTonn * 1000;
    }

    @ManyToOne
    @JoinColumn(name = "currentCity")
    public CitiesPO getCurrentCity() {
        return this.currentCity;
    }

    public void setCurrentCity(CitiesPO currentCity) {
        this.currentCity = currentCity;
    }

    @ManyToOne
    @JoinColumn(name = "status")
    public TruckStatusPO getTruckStatus() {
        return this.truckStatus;
    }

    public void setTruckStatus(TruckStatusPO truckStatus) {
        this.truckStatus = truckStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TruckPO truckPO = (TruckPO) o;

        if (truckNumber != null ? !truckNumber.equals(truckPO.truckNumber) : truckPO.truckNumber != null) return false;
        if (driversCount != null ? !driversCount.equals(truckPO.driversCount) : truckPO.driversCount != null)
            return false;
        if (capacityTonn != null ? !capacityTonn.equals(truckPO.capacityTonn) : truckPO.capacityTonn != null)
            return false;
        if (capacityKg != null ? !capacityKg.equals(truckPO.capacityKg) : truckPO.capacityKg != null) return false;
        return currentCity != null ? currentCity.equals(truckPO.currentCity) : truckPO.currentCity == null && (truckStatus != null ? truckStatus.equals(truckPO.truckStatus) : truckPO.truckStatus == null);

    }

    @Override
    public int hashCode() {
        int result = truckNumber != null ? truckNumber.hashCode() : 0;
        result = 31 * result + (driversCount != null ? driversCount.hashCode() : 0);
        result = 31 * result + (capacityTonn != null ? capacityTonn.hashCode() : 0);
        result = 31 * result + (capacityKg != null ? capacityKg.hashCode() : 0);
        result = 31 * result + (currentCity != null ? currentCity.hashCode() : 0);
        result = 31 * result + (truckStatus != null ? truckStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TruckPO{" +
                "truckNumber='" + truckNumber + '\'' +
                ", driversCount=" + driversCount +
                ", capacityTonn=" + capacityTonn +
                ", capacityKg=" + capacityKg +
                ", currentCity=" + currentCity +
                ", truckStatus=" + truckStatus +
                '}';
    }
}

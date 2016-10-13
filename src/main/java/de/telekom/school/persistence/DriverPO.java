package de.telekom.school.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "driver")
public class DriverPO extends AbstractPO implements Serializable {

    private String name;
    private String surname;
    private String driverNumber;
    private Integer workedHours;
    private DriverStatusPO status;
    private CitiesPO currentCity;
    private TruckPO currentTruck;


    public DriverPO() {
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "driverNumber")
    public String getDriverNumber() {
        return this.driverNumber;
    }

    public void setDriverNumber(String driverNumber) {
        this.driverNumber = driverNumber;
    }

    @Column(name = "workedHours")
    public Integer getWorkedHours() {
        return this.workedHours;
    }

    public void setWorkedHours(Integer workedHours) {
        this.workedHours = workedHours;
    }

    @ManyToOne
    @JoinColumn(name = "status")
    public DriverStatusPO getStatus() {
        return this.status;
    }

    public void setStatus(DriverStatusPO status) {
        this.status = status;
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
    @JoinColumn(name = "currentTruck")
    public TruckPO getCurrentTruck() {
        return this.currentTruck;
    }

    public void setCurrentTruck(TruckPO currentTruck) {
        this.currentTruck = currentTruck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverPO driverPO = (DriverPO) o;

        if (name != null ? !name.equals(driverPO.name) : driverPO.name != null) return false;
        if (surname != null ? !surname.equals(driverPO.surname) : driverPO.surname != null) return false;
        if (driverNumber != null ? !driverNumber.equals(driverPO.driverNumber) : driverPO.driverNumber != null)
            return false;
        if (workedHours != null ? !workedHours.equals(driverPO.workedHours) : driverPO.workedHours != null)
            return false;
        if (status != null ? !status.equals(driverPO.status) : driverPO.status != null) return false;
        if (currentCity != null ? !currentCity.equals(driverPO.currentCity) : driverPO.currentCity != null)
            return false;
        return currentTruck != null ? currentTruck.equals(driverPO.currentTruck) : driverPO.currentTruck == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (driverNumber != null ? driverNumber.hashCode() : 0);
        result = 31 * result + (workedHours != null ? workedHours.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (currentCity != null ? currentCity.hashCode() : 0);
        result = 31 * result + (currentTruck != null ? currentTruck.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DriverPO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", driverNumber='" + driverNumber + '\'' +
                ", workedHours=" + workedHours +
                ", status=" + status +
                ", currentCity=" + currentCity +
                ", currentTruck=" + currentTruck +
                '}';
    }
}

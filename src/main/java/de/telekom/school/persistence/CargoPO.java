package de.telekom.school.persistence;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class CargoPO extends  AbstractPO implements Serializable {

    private String cargoNumber;
    private String cargoName;
    private String cargoMass;
    private CargoStatusPO cargoStatus;
    private OrderPO orderNumber;

    public CargoPO() {
    }

    @Column(name = "cargoNumber")
    public String getCargoNumber () {
        return this.cargoNumber;
    }
    public void setCargoNumber (String cargoNumber) {
        this.cargoNumber = cargoNumber;
    }

    @Column(name = "cargoName")
    public String getCargoName() {
        return this.cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }
    @Column(name = "cargoMass", length = 10, nullable = false)
    public String getCargoMass() {
        return this.cargoMass;
    }

    public void setCargoMass(String cargoMass) {
        this.cargoMass = cargoMass;
    }

    @ManyToOne
    @JoinColumn(name = "status")
    public CargoStatusPO getCargoStatus() {
        return this.cargoStatus;
    }

    public void setCargoStatus(CargoStatusPO cargoStatus) {
        this.cargoStatus = cargoStatus;
    }

    @OneToOne(mappedBy = "orderNumber")
    public OrderPO getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(OrderPO orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "CargoPO{" +
                "cargoNumber='" + cargoNumber + '\'' +
                ", cargoName='" + cargoName + '\'' +
                ", cargoMass='" + cargoMass + '\'' +
                ", cargoStatus='" + cargoStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CargoPO cargoPO = (CargoPO) o;

        if (!cargoNumber.equals(cargoPO.cargoNumber)) return false;
        if (!cargoName.equals(cargoPO.cargoName)) return false;
        if (!cargoMass.equals(cargoPO.cargoMass)) return false;
        return cargoStatus.equals(cargoPO.cargoStatus);

    }

    @Override
    public int hashCode() {
        int result = cargoNumber.hashCode();
        result = 31 * result + cargoName.hashCode();
        result = 31 * result + cargoMass.hashCode();
        result = 31 * result + cargoStatus.hashCode();
        return result;
    }
}

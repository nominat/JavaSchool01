package de.telekom.school.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "order")
public class OrderPO extends AbstractPO implements Serializable {
    private Integer uniqNumber;
    private Boolean isDone;
    private TruckPO truck;
    private List<DriverPO> drivers;
    private List<RoutePointsPO> point;

    public OrderPO() {
    }

    @Column(name = "orderUniqNumber")
    public Integer getUniqNumber() {
        return uniqNumber;
    }

    public void setUniqNumber(Integer uniqNumber) {
        this.uniqNumber = uniqNumber;
    }

    @Column(name = "isDone")
    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    @ManyToOne
    @JoinColumn(name = "truck")
    public TruckPO getTruck() {
        return truck;
    }

    public void setTruck(TruckPO truck) {
        this.truck = truck;
    }

    @OneToMany(mappedBy = "drivers")
    public List<DriverPO> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverPO> drivers) {
        this.drivers = drivers;
    }

    @OneToMany(mappedBy = "points")
    public List<RoutePointsPO> getPoint() {
        return point;
    }

    public void setPoint(List<RoutePointsPO> point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderPO orderPO = (OrderPO) o;

        if (uniqNumber != null ? !uniqNumber.equals(orderPO.uniqNumber) : orderPO.uniqNumber != null) return false;
        if (isDone != null ? !isDone.equals(orderPO.isDone) : orderPO.isDone != null) return false;
        if (truck != null ? !truck.equals(orderPO.truck) : orderPO.truck != null) return false;
        return drivers != null ? drivers.equals(orderPO.drivers) : orderPO.drivers == null && (point != null ? point.equals(orderPO.point) : orderPO.point == null);

    }

    @Override
    public int hashCode() {
        int result = uniqNumber != null ? uniqNumber.hashCode() : 0;
        result = 31 * result + (isDone != null ? isDone.hashCode() : 0);
        result = 31 * result + (truck != null ? truck.hashCode() : 0);
        result = 31 * result + (drivers != null ? drivers.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderPO{" +
                "uniqNumber=" + uniqNumber +
                ", isDone=" + isDone +
                ", truck=" + truck +
                ", drivers=" + drivers +
                ", point=" + point +
                '}';
    }
}

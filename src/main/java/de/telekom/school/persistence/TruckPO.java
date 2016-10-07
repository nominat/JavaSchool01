package de.telekom.school.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "trucks")
public class TruckPO extends AbstractPO implements Serializable{
}

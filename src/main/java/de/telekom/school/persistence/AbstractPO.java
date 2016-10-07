package de.telekom.school.persistence;

import javax.persistence.*;

/**
 * Created by Илья on 07-Oct-16.
 */
@MappedSuperclass
public class AbstractPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pk")
    @SequenceGenerator(name = "seq_pk", sequenceName = "seq_pk")
    protected long id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

package com.superkassa.server.model;

import com.superkassa.server.utils.JsonModelConverter;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "sk_example_table")
public class Model {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "obj")
    @JdbcTypeCode(SqlTypes.JSON)
    @Convert(converter = JsonModelConverter.class)
    private Current current;

    public Current getObject() {
        return current;
    }

    public Model() {}
    public void setObject(Current current) {
        this.current = current;
    }
}

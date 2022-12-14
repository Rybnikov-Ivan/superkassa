package com.superkassa.server.model;

import com.superkassa.server.utils.JsonModelConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Table(name = "sk_example_table")
@AllArgsConstructor
public class Model {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "obj")
    @Convert(converter = JsonModelConverter.class)
    private Current current;

    public Current getObject() {
        return current;
    }

    public void setObject(Current current) {
        this.current = current;
    }
}

package com.superkassa.server.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Current implements Serializable {
    @Getter
    @Setter
    private int current;

    public Current() {}

    public Current(int current) {
        this.current = current;
    }
}

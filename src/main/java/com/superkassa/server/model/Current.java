package com.superkassa.server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
public class Current implements Serializable {

    @Getter
    @Setter
    private int current;

}

package com.superkassa.server.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ServiceResponse {
    private int current;
    private HttpStatus httpStatus;

    public ServiceResponse() {}

    public ServiceResponse(int current, HttpStatus httpStatus) {
        this.current = current;
        this.httpStatus = httpStatus;
    }

    public void setErrorResponse() {
        this.setHttpStatus(HttpStatus.I_AM_A_TEAPOT);
    }
}

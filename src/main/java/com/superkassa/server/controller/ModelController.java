package com.superkassa.server.controller;

import com.superkassa.server.model.Current;
import com.superkassa.server.service.ModelService;
import com.superkassa.server.utils.ServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping("/modify")
    @ExceptionHandler()
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Current add(@RequestBody ServiceRequest request) {
        return modelService.add(request);
    }
}

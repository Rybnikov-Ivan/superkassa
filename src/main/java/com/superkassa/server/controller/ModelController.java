package com.superkassa.server.controller;

import com.superkassa.server.service.ModelService;
import com.superkassa.server.utils.ServiceRequest;
import com.superkassa.server.utils.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping("/modify")
    public ServiceResponse add(@RequestBody ServiceRequest request) {
        return modelService.add(request);
    }
}

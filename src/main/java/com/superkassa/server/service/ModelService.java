package com.superkassa.server.service;

import com.superkassa.server.model.Current;
import com.superkassa.server.utils.ServiceRequest;

public interface ModelService {
    public Current add(ServiceRequest request);
}

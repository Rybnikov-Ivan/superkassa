package com.superkassa.server.service;

import com.superkassa.server.model.Current;
import com.superkassa.server.model.Model;
import com.superkassa.server.repository.ModelRepository;
import com.superkassa.server.utils.ServiceRequest;
import com.superkassa.server.utils.ServiceResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelRepository modelRepository;

    @Override
    @Transactional
    public ServiceResponse add(ServiceRequest request) {
        ServiceResponse response = new ServiceResponse();
        Model model = this.modelRepository.findById(request.getId()).get();
        if(model == null || request.getAdd() < 0) {
            response.setErrorResponse();
            return response;
        }

        Current current = new Current(model.getObject().getCurrent() + request.getAdd());
        model.setObject(current);
        this.modelRepository.save(model);

        response.setCurrent(model.getObject().getCurrent());
        return response;
    }
}

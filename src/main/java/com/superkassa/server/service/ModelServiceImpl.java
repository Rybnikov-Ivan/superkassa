package com.superkassa.server.service;

import com.superkassa.server.model.Current;
import com.superkassa.server.model.Model;
import com.superkassa.server.repository.ModelRepository;
import com.superkassa.server.utils.ServiceRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelRepository modelRepository;

    @Override
    @Transactional
    public Current add(ServiceRequest request) {
        Model model = this.modelRepository.findById(request.getId()).get();
        Current current = new Current(model.getObject().getCurrent() + request.getAdd());
        model.setObject(current);
        return modelRepository.save(model).getObject();
    }
}

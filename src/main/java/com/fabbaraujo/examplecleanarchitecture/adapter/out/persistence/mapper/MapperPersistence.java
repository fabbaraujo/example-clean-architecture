package com.fabbaraujo.examplecleanarchitecture.adapter.out.persistence.mapper;

import com.fabbaraujo.examplecleanarchitecture.adapter.out.persistence.model.TrainModel;
import com.fabbaraujo.examplecleanarchitecture.application.domain.Train;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MapperPersistence {

    public TrainModel toModelPersistence(Train domain) {
        return TrainModel.builder()
                .carriage(domain.getNumberCarriage())
                .serialNumber(domain.getSerialNumber())
                .build();
    }

    public Optional toDomain(TrainModel model) {
        if (model != null) {
            Train build = Train.builder()
                    .id(model.getId())
                    .serialNumber(model.getSerialNumber())
                    .numberCarriage(model.getCarriage())
                    .build();
            return Optional.of(build);
        } else {
            return Optional.empty();
        }
    }
}

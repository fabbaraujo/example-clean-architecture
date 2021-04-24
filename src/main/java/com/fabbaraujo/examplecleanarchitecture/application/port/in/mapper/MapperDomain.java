package com.fabbaraujo.examplecleanarchitecture.application.port.in.mapper;

import com.fabbaraujo.examplecleanarchitecture.application.domain.Train;
import com.fabbaraujo.examplecleanarchitecture.application.port.in.model.CreateTrainCommand;
import com.fabbaraujo.examplecleanarchitecture.application.port.in.model.ResponseCreateTrain;
import com.fabbaraujo.examplecleanarchitecture.application.port.in.model.ResponseFindByIdTrain;
import org.springframework.stereotype.Component;

@Component
public class MapperDomain {

    public Train toDomain(CreateTrainCommand createTrainCommand) {
        return Train.builder().numberCarriage(createTrainCommand.getNumberCarriage()).build();
    }

    public ResponseCreateTrain toResponse(Train responsePersistence) {
        return ResponseCreateTrain.builder()
                .id(responsePersistence.getId())
                .serialNumber(responsePersistence.getSerialNumber())
                .build();
    }

    public ResponseFindByIdTrain toResponseById(Train train) {
        return ResponseFindByIdTrain.builder()
                .id(train.getId())
                .serialNumber(train.getSerialNumber())
                .build();
    }
}

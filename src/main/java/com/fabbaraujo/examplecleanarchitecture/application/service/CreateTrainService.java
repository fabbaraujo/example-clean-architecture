package com.fabbaraujo.examplecleanarchitecture.application.service;

import com.fabbaraujo.examplecleanarchitecture.application.domain.Train;
import com.fabbaraujo.examplecleanarchitecture.application.exception.ErrorPersistenceException;
import com.fabbaraujo.examplecleanarchitecture.application.exception.TrainExistException;
import com.fabbaraujo.examplecleanarchitecture.application.port.in.mapper.MapperDomain;
import com.fabbaraujo.examplecleanarchitecture.application.port.in.model.CreateTrainCommand;
import com.fabbaraujo.examplecleanarchitecture.application.port.in.model.ResponseCreateTrain;
import com.fabbaraujo.examplecleanarchitecture.application.port.out.FindTrainBySerialNumberPort;
import com.fabbaraujo.examplecleanarchitecture.application.port.out.PersistenceTrainPort;
import com.fabbaraujo.examplecleanarchitecture.application.port.usecases.CreateTrainUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateTrainService implements CreateTrainUseCases {

    private final FindTrainBySerialNumberPort findTrainBySerialNumberPort;
    private final PersistenceTrainPort persistenceTrainPort;
    private final MapperDomain mapperTrain;

    @Override
    public ResponseCreateTrain process(CreateTrainCommand createTrainCommand) {
        Train train = mapperTrain.toDomain(createTrainCommand);

        String serialNumber = UUID.randomUUID().toString();
        verifyIfSerialNumberExist(serialNumber);
        train.setSerialNumber(serialNumber);
        Optional<Train> responsePersistence = this.persistenceTrainPort.saveTrain(train);

        return responsePersistence.map(this.mapperTrain::toResponse
        ).orElseThrow(ErrorPersistenceException::new);
    }

    private void verifyIfSerialNumberExist(String serialNumber) {
        Optional<Train> bySerialNumber = this.findTrainBySerialNumberPort.findBySerialNumber(serialNumber);
        bySerialNumber.map(it -> {
            throw new TrainExistException("Train exist with this serial number: " + it.getSerialNumber());
        });
    }
}

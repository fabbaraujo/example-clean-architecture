package com.fabbaraujo.examplecleanarchitecture.application.port.usecases;

import com.fabbaraujo.examplecleanarchitecture.application.port.in.model.CreateTrainCommand;
import com.fabbaraujo.examplecleanarchitecture.application.port.in.model.ResponseCreateTrain;

public interface CreateTrainUseCases {
    ResponseCreateTrain process(CreateTrainCommand createTrainCommand);
}

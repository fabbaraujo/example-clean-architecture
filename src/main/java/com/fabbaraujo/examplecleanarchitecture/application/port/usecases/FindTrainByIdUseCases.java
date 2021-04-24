package com.fabbaraujo.examplecleanarchitecture.application.port.usecases;

import com.fabbaraujo.examplecleanarchitecture.application.port.in.model.ResponseFindByIdTrain;

import java.util.Optional;

public interface FindTrainByIdUseCases {
    Optional<ResponseFindByIdTrain> process(Long id);
}

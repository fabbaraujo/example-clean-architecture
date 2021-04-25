package com.fabbaraujo.examplecleanarchitecture.application.port.out;

import com.fabbaraujo.examplecleanarchitecture.application.domain.Train;

import java.util.Optional;

public interface PersistenceTrainPort {
    Optional saveTrain(Train train);
}

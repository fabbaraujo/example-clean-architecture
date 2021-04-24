package com.fabbaraujo.examplecleanarchitecture.application.port.out;

import java.util.Optional;

public interface FindTrainBySerialNumberPort {
    Optional findBySerialNumber(String serialNumber);
}

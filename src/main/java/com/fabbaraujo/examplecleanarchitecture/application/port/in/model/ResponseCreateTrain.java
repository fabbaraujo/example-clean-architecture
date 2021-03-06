package com.fabbaraujo.examplecleanarchitecture.application.port.in.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class ResponseCreateTrain implements Serializable {
    private Long id;
    private String serialNumber;
}

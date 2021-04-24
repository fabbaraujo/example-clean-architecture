package com.fabbaraujo.examplecleanarchitecture.application.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Train {
    private Long id;
    private String serialNumber;
    private Long numberCarriage;
}

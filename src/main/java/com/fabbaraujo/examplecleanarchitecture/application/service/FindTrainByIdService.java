package com.fabbaraujo.examplecleanarchitecture.application.service;

import com.fabbaraujo.examplecleanarchitecture.application.domain.Train;
import com.fabbaraujo.examplecleanarchitecture.application.port.in.mapper.MapperDomain;
import com.fabbaraujo.examplecleanarchitecture.application.port.in.model.ResponseFindByIdTrain;
import com.fabbaraujo.examplecleanarchitecture.application.port.out.FindTrainByIdPort;
import com.fabbaraujo.examplecleanarchitecture.application.port.usecases.FindTrainByIdUseCases;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindTrainByIdService implements FindTrainByIdUseCases {

    private final FindTrainByIdPort findTrainByidPort;
    private final MapperDomain mapperDomain;

    @Override
    public Optional<ResponseFindByIdTrain> process(Long id) {

        Optional<Train> byId = this.findTrainByidPort.findById(id);

        Optional<ResponseFindByIdTrain> responseFindByIdTrain = Optional.ofNullable(byId.map(this.mapperDomain::toResponseById
        ).orElse(null));

        return responseFindByIdTrain;
    }
}

package com.fabbaraujo.examplecleanarchitecture.adapter.out.persistence.adapter;

import com.fabbaraujo.examplecleanarchitecture.adapter.out.persistence.mapper.MapperPersistence;
import com.fabbaraujo.examplecleanarchitecture.adapter.out.persistence.model.TrainModel;
import com.fabbaraujo.examplecleanarchitecture.adapter.out.persistence.repository.TrainRepository;
import com.fabbaraujo.examplecleanarchitecture.application.domain.Train;
import com.fabbaraujo.examplecleanarchitecture.application.port.out.FindTrainByIdPort;
import com.fabbaraujo.examplecleanarchitecture.application.port.out.FindTrainBySerialNumberPort;
import com.fabbaraujo.examplecleanarchitecture.application.port.out.PersistenceTrainPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TrainAdapterPersistence implements PersistenceTrainPort, FindTrainBySerialNumberPort, FindTrainByIdPort {

    private final TrainRepository trainRepository;
    private final MapperPersistence mapperPersistence;

    @Override
    public Optional findById(Long id) {
        Optional<TrainModel> byId = this.trainRepository.findById(id);

        return byId.flatMap(this.mapperPersistence::toDomain);
    }

    @Override
    public Optional findBySerialNumber(String serialNumber) {
        return this.mapperPersistence.toDomain(this.trainRepository.findBySerialNumber(serialNumber));
    }

    @Override
    public Optional saveTrain(Train train) {
        TrainModel trainModel = this.mapperPersistence.toModelPersistence(train);
        TrainModel saveTrain = this.trainRepository.save(trainModel);
        
        return this.mapperPersistence.toDomain(saveTrain);
    }
}

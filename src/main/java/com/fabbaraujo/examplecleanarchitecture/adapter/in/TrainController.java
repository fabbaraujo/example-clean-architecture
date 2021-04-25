package com.fabbaraujo.examplecleanarchitecture.adapter.in;

import com.fabbaraujo.examplecleanarchitecture.application.port.in.model.CreateTrainCommand;
import com.fabbaraujo.examplecleanarchitecture.application.port.in.model.ResponseCreateTrain;
import com.fabbaraujo.examplecleanarchitecture.application.port.in.model.ResponseFindByIdTrain;
import com.fabbaraujo.examplecleanarchitecture.application.port.usecases.CreateTrainUseCases;
import com.fabbaraujo.examplecleanarchitecture.application.port.usecases.FindTrainByIdUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/train")
public class TrainController {

    private final CreateTrainUseCases createTrainUseCases;
    private final FindTrainByIdUseCases findTrainByIdUseCases;

    @PostMapping
    public ResponseEntity<ResponseCreateTrain> createTrain(
            @Valid @RequestBody CreateTrainCommand createTrainCommand
    ) {
        ResponseCreateTrain result = this.createTrainUseCases.process(createTrainCommand);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFindByIdTrain> findTrainById(@PathVariable("id") Long id) {
        Optional<ResponseFindByIdTrain> trainOptional = this.findTrainByIdUseCases.process(id);

        return trainOptional.map(it ->
                new ResponseEntity<>(it, HttpStatus.OK)
        ).orElse(
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
        );
    }
}

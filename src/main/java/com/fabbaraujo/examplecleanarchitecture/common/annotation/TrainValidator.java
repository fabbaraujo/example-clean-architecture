package com.fabbaraujo.examplecleanarchitecture.common.annotation;

import com.fabbaraujo.examplecleanarchitecture.application.port.in.model.CreateTrainCommand;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TrainValidator implements ConstraintValidator<TrainCreatedValid, CreateTrainCommand> {

    @Override
    public void initialize(TrainCreatedValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(CreateTrainCommand value, ConstraintValidatorContext context) {
        return true;
    }
}

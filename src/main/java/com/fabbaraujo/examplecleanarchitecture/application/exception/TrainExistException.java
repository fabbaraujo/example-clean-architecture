package com.fabbaraujo.examplecleanarchitecture.application.exception;

public class TrainExistException extends RuntimeException {

    public TrainExistException(String msg) {
        super(msg);
    }
}

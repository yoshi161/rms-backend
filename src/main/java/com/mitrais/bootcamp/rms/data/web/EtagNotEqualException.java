package com.mitrais.bootcamp.rms.data.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.PRECONDITION_FAILED)
public class EtagNotEqualException extends RuntimeException {
    public EtagNotEqualException() {
        super();
    }
}
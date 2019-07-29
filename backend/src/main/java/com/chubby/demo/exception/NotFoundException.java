package com.chubby.demo.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String resourece, Long id) {
        super("Could not find " + resourece + " " + id);
    }
}

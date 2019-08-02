package com.chubby.demo.exception;

public class NotFoundException extends RuntimeException {

    private final static String NOT_FIND = "Could not find ";

    public NotFoundException(String resourece) {
        super(NOT_FIND + resourece);
    }

    public NotFoundException(String resourece, Long id) {
        super(NOT_FIND + resourece + " " + id);
    }


}

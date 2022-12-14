package com.superkassa.server.utils.exception;

public class IncorrectRequestDataException extends RuntimeException {
    public IncorrectRequestDataException() {
        super("Временная ошибка сервера, попробуйте позже");
    }
}

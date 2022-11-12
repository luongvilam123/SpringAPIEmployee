package com.lam.employeespringapi.exception;

public class DomainException extends RuntimeException{

    String message;

    public DomainException(ErrorCode errorCode){
        message=errorCode.toString();
    }
}

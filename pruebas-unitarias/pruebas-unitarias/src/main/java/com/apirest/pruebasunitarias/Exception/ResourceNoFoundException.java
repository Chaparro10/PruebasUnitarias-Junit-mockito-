package com.apirest.pruebasunitarias.Exception;

public class ResourceNoFoundException extends  RuntimeException{
    public ResourceNoFoundException(String message){
        super(message);
    }
}

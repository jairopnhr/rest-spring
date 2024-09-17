package com.example.spring_rest.error;

public class ProdutoNullException extends RuntimeException {

    public ProdutoNullException(String msg){
        super(msg);
    }
}

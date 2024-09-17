package com.example.spring_rest.error;

public class ProdutoPriceException extends RuntimeException {
    public ProdutoPriceException(String msg){
        super(msg);
    }
}

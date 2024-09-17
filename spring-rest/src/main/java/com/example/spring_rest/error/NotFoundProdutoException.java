package com.example.spring_rest.error;

public class NotFoundProdutoException  extends RuntimeException {
    public NotFoundProdutoException(String msg)
    {
        super(msg);
    }

}

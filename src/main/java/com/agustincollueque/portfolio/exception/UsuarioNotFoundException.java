package com.agustincollueque.portfolio.exception;
public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(String msj) {
        super(msj);
    }
}

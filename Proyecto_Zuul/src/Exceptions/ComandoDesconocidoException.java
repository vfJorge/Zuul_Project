package Exceptions;

public class ComandoDesconocidoException extends RuntimeException{
    public ComandoDesconocidoException(String message){
        super(message);
    }
}

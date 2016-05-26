
package org.ciudadano.exception;


public class NotValidException extends RuntimeException {


    public NotValidException() {
    }

    public NotValidException(String msg) {
        super(msg);
    }
}

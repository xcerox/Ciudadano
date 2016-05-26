
package org.ciudadano.exception;

public class NotFoundValueException extends RuntimeException {

    public NotFoundValueException() {
    }

    public NotFoundValueException(String msg) {
        super(msg);
    }
}


package org.ciudadano.exception;

public class NotInstanceException extends RuntimeException {

    public NotInstanceException() {
        this("no se a podido inicializar la clase");
    }

    public NotInstanceException(String msg) {
        super(msg);
    }
}

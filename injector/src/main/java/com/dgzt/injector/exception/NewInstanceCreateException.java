package com.dgzt.injector.exception;

/**
 * The exception if the injector cannot create new instance.
 */
public class NewInstanceCreateException extends RuntimeException {

    // --------------------------------------------------
    // ~ Constants
    // --------------------------------------------------

    private static final long serialVersionUID = 1L;

    // --------------------------------------------------
    // ~ Constructors
    // --------------------------------------------------

    /**
     * The constructor.
     *
     * @param cause The cause exception
     */
    public NewInstanceCreateException(final Throwable cause) {
        super(cause);
    }

    /**
     * The constructor.
     *
     * @param text The error text.
     */
    public NewInstanceCreateException(final String text) {
        super(text);
    }
}

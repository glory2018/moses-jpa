package com.ibm.moses.common.exception;

/**
 * @author Moses
 */
public class AlreadyExistException extends Exception {
    private static final long serialVersionUID = 1L;

    public AlreadyExistException(String exMsg) {
        super(exMsg);
    }
}

package com.test.portfolioback.exception;

import java.util.logging.Logger;

/**
 *
 * @author Robson J Silva <vantrox@yahoo.com.br>
 */
public class NotFoundException extends RuntimeException {
    
    private static final Logger LOG = Logger.getLogger(NotFoundException.class.getName());
    
    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
    }  
    
}

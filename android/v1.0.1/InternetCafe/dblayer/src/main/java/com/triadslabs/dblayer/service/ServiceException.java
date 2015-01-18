package com.triadslabs.dblayer.service;

/**
 * Created by MuzammilPeer on 1/18/2015.
 */
public class ServiceException  extends Exception {
    private static final long serialVersionUID = 1L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable tx) {
        super(tx.getMessage(), tx);
    }

    public ServiceException(String message, Throwable tx) {
        super(message, tx);
    }
}

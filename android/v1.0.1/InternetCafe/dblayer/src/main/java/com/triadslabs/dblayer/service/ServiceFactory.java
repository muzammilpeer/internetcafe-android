package com.triadslabs.dblayer.service;

/**
 * Created by MuzammilPeer on 1/18/2015.
 */
public class ServiceFactory {
    private static ServiceFactory ourInstance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private ServiceFactory() {
    }

    public Object getService(Class serviceName) throws ServiceException {

        Object service = null;
        try {
            service = serviceName.newInstance();
        } catch (InstantiationException e) {
            throw new ServiceException(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return service;
    }
}

package com.triadslabs.dblayer.service;

import android.content.Context;

import com.triadslabs.dblayer.helper.DatabaseHelper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by MuzammilPeer on 1/18/2015.
 */
public class ServiceFactory {


    private static ServiceFactory ourInstance = new ServiceFactory();

    private DatabaseHelper databaseHelper;
//    private static DatabaseManager<DatabaseHelper> manager  = new DatabaseManager<DatabaseHelper>();

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private ServiceFactory() {

    }

    public BaseService getService(Class serviceName,Context context) throws ServiceException {

        BaseService service = null;

        try {

//            service = (BaseService)serviceName.newInstance();
//            service.setDatabaseHelper(manager.getHelper(context));
//            DatabaseHelper
//get constructor that takes a String as argument
            if (databaseHelper == null) {
                databaseHelper = new DatabaseHelper(context);
            }

            Constructor constructor = serviceName.getConstructor(DatabaseHelper.class);
            service = (BaseService)constructor.newInstance(databaseHelper);



        } catch (InstantiationException e) {
            throw new ServiceException(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        catch (InvocationTargetException e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
        catch (NoSuchMethodException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return service;
    }
}

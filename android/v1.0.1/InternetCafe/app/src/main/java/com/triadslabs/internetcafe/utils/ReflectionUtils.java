package com.triadslabs.internetcafe.utils;

import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by MuzammilPeer on 1/4/2015.
 */
public class ReflectionUtils {


    public static Object instantiate(Class clazz) {
        try {
            return (Object) clazz.newInstance();
        } catch (InstantiationException e) {
            Log.e("InstantiationException", e.getLocalizedMessage());
        } catch (IllegalAccessException e) {
            Log.e("IllegalAccessException", e.getLocalizedMessage());
        }
        return null;
    }

    public static void callMethod(String methodName,Class parametersClazz,Object parametersObject,Class clazzReference,Object clazzObject)
    {
        //String parameter
        Class[] parametersClass = new Class[1];
        parametersClass[0] = parametersClazz;

        //call the printItString method, pass a String param
        try {
            Method method = clazzReference.getDeclaredMethod(methodName, parametersClass);
            method.invoke(clazzObject, parametersObject);
        } catch (NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            Log.e("NoSuchMethodException|SecurityException", e.getLocalizedMessage());
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            Log.e("IllegalAccessException", e.getLocalizedMessage());
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            Log.e("IllegalArgumentException", e.getLocalizedMessage());;
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            Log.e("InvocationTargetException", e.getLocalizedMessage());
        }

    }

}

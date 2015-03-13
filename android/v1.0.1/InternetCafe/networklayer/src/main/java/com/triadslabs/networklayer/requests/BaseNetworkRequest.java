package com.triadslabs.networklayer.requests;

import com.triadslabs.networklayer.protocols.IRequestProtocol;


/**
 * Created by MuzammilPeer on 3/13/2015.
 */
abstract public class BaseNetworkRequest implements IRequestProtocol {

    //Data model property
    protected Object dataModel = null;

    public Object getDataModel() {
        return dataModel;
    }

    //Constructors

    public BaseNetworkRequest() {
        //do any thing
    }

    //copy constructor
    public BaseNetworkRequest(Object model) {
        //passing data model to object level variables
        this.dataModel = model;
    }

//    @Override
//    public String getURL() throws Exception  {
//        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
//        String className = ReflectionUtil.getClassName(getClass());
//        throw new Exception("You must override method "+ methodName +" in "+ className);
//    }
//
//    @Override
//    public Boolean haveGetData() {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    @Override
//    public String getData() throws Exception {
//        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
//        String className = ReflectionUtil.getClassName(getClass());
//        throw new Exception("You must override method "+ methodName +" in "+ className);
//    }
//
//    @Override
//    public Boolean havePostData() {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    @Override
//    public JsonObject postData() throws Exception {
//        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
//        String className = ReflectionUtil.getClassName(getClass());
//        throw new Exception("You must override method "+ methodName +" in "+ className);
//    }
//
//    @Override
//    public Boolean haveImageData() {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    @Override
//    public Object getImageData() throws Exception {
//        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
//        String className = ReflectionUtil.getClassName(getClass());
//        throw new Exception("You must override method "+ methodName +" in "+ className);
//    }


//    //utility methods
//    public JsonObject getJsonObjectDataModel()
//    {
//        return GsonUtil.getJsonObjectFromObject(this.getDataModel());
//    }



}
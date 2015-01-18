package com.triadslabs.dblayer.service;

import com.triadslabs.dblayer.helper.DatabaseHelper;

/**
 * Created by MuzammilPeer on 1/18/2015.
 */
public class BaseService {

    public DatabaseHelper databaseHelper;

    public BaseService(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

//    public void setDatabaseHelper(DatabaseHelper databaseHelper) {
//        this.databaseHelper = databaseHelper;
//    }
}

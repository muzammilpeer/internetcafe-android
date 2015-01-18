package com.triadslabs.dblayer.service;

import com.triadslabs.dblayer.dbmodel.User;

/**
 * Created by MuzammilPeer on 1/18/2015.
 */
public interface IUserService {

    public User getByUsername(String username) throws ServiceException ;
    public int addUser(User model) throws ServiceException ;
}

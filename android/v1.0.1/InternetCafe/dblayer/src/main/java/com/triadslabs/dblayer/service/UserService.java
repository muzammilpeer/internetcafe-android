package com.triadslabs.dblayer.service;

/**
 * Created by MuzammilPeer on 1/18/2015.
 */
public class UserService implements IUserService {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUserById() throws ServiceException
    {
        String user;
        try {
            user = getUsername();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

        return user;
    }
}

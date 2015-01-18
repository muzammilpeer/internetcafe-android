package com.triadslabs.dblayer.service;

import com.triadslabs.dblayer.dao.UserDAO;
import com.triadslabs.dblayer.dbmodel.User;
import com.triadslabs.dblayer.helper.DatabaseHelper;

/**
 * Created by MuzammilPeer on 1/18/2015.
 */
public class UserService extends BaseService implements IUserService {

    public UserService(DatabaseHelper databaseHelper) {
        super(databaseHelper);
    }

    public User getByUsername(String username) throws ServiceException
    {
        User user;

        try {
            UserDAO userDao = new UserDAO(databaseHelper);
            user = userDao.getByUsername("peer");
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }

        return user;
    }

    @Override
    public int addUser(User model) throws ServiceException {
        int user;

        try {
            UserDAO userDao = new UserDAO(databaseHelper);
            user = userDao.create(model);
        } catch (Exception ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }

        return user;
    }
}

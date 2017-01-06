/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rashjz.info.app.bp.dao.UserDao;
import rashjz.info.app.bp.domain.Users;

/**
 *
 * @author Mobby
 */
@Service
public class UserServiceImpl implements Serializable, UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void addUser(Users cust) {
        userDao.addUser(cust);
    }

    @Override
    public void deleteUser(int custid) {
        userDao.deleteUser(custid);
    }

    @Override
    public void updateUser(Users cust) {
        userDao.updateUser(cust);
    }

    @Override
    public List<Users> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public Users getbyUserName(String username) {
        return userDao.getbyUserName(username);
    }

    @Override
    public Users findByUsernamePassword(String username, String password) {
        return userDao.findByUsernamePassword(username, password);
    }

}

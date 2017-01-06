/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.service;

import java.util.List;
import rashjz.info.app.bp.domain.Users;

/**
 *
 * @author Rashad Javadov
 */
public interface UserService {

    public void addUser(Users cust);

    public void deleteUser(int custid);

    public void updateUser(Users cust);

    public List<Users> getAllUser();

    public Users getbyUserName(String username);

    public Users findByUsernamePassword(String username, String password);
}

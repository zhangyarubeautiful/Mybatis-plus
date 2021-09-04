package com.xihua.service;

import com.xihua.entity.User;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {

   /**
    * Gets user list.
    *
    * @return the user list
    */
   List<User> getUserList();

}

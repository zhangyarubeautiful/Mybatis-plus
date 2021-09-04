package com.xihua.dao;

import com.xihua.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface User mapper.
 */
@Repository
public interface UserMapper {

    /**
     * Gets user list.
     *
     * @return the user list
     */
    List<User> getUserList();

}

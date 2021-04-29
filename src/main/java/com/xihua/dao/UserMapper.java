package com.xihua.dao;

import com.xihua.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> getUserList();

}

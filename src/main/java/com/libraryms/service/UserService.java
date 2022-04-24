package com.libraryms.service;

import com.libraryms.pojo.User;

import java.util.List;


public interface UserService {
    User getByUserNameAndPassword(User user);

    User getByUserName(User user);

    int insertUser(User user);

    int updatePassword(User user);

    User getByUserNameAndEmail(User user);

    List<User> getByUserList(User user);


}

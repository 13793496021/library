package com.libraryms.serviceimpl;

import com.libraryms.mapper.UserMapper;
import com.libraryms.pojo.User;
import com.libraryms.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getByUserNameAndPassword(User user) {
        return userMapper.getByUserNameAndPassword(user);
    }

    @Override
    public User getByUserName(User user) {
        return userMapper.getByUserName(user);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updatePassword(User user) {
        return userMapper.updatePassword(user);
    }

    @Override
    public User getByUserNameAndEmail(User user){
        return userMapper.getByUserNameAndEmail(user);
    }

    @Override
    public List<User> getByUserList(User user) {
        return userMapper.getByUserList(user);
    }


}

package com.libraryms.mapper;

import com.libraryms.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {

   User getByUserNameAndPassword(User user);

   User getByUserName(User user);

   int insertUser(User user);

   int updatePassword(User user);

   User getByUserNameAndEmail(User user);

   List<User> getByUserList(User user);


}

package com.ahao.mapper.user;

import com.ahao.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 用户持久层
 * @Author: ahao
 * @Date: 2022/12/6 16:20
 **/
public interface UserMapper {

    User getLoginUser(@Param("userCode") String userCode);

    int insertNewUser(User user);

    User queryTheUser(@Param("id") String id);

    int deleteById(@Param("id") String id);

    int getTotalCount(@Param("userName") String userName,@Param("userRole") Integer userRole);

    List<User> queryUsersByPage(@Param("pageHeadIndex") Integer pageHeadIndex,@Param("pageSize") Integer pageSize,@Param("userName") String userName,@Param("userRole") Integer userRole);

    int pwdSave(@Param("oldpassword") String oldpassword,@Param("rnewpassword") String rnewpassword);
}

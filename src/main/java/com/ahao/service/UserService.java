package com.ahao.service;

import com.ahao.pojo.User;

import java.util.List;

/**
 * @Description: 用户实现接口
 * @Author: ahao
 * @Date: 2022/12/6 16:37
 **/
public interface UserService {

    User login(String userCode, String userPassword);

    boolean insertNewUser(User user);

    User queryTheUser(String id);

    boolean deleteById(String id);

    int getTotalCount(String userName, Integer userRole);

    List<User> queryUsersByPage(int pageHeadIndex, int pageSize, String userName, int userRole);

    boolean pwdSave(String oldpassword, String rnewpassword);
}

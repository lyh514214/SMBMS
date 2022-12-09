package com.ahao.service.impl;

import com.ahao.mapper.user.UserMapper;
import com.ahao.pojo.User;
import com.ahao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 用户业务实现类
 * @Author: ahao
 * @Date: 2022/12/6 16:41
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @Description: 登录业务
     * @param userCode     账号
     * @param userPassword 密码
     * @return user对象
     **/
    @Override
    public User login(String userCode, String userPassword) {
        User user = userMapper.getLoginUser(userCode);
        if (user != null){
            if (!user.getUserPassword().equals(userPassword)){
                user=null;
            }
        }
        return user;
    }

    /**
     * @Description: 条件查询表总记录
     * @param userName 名称
     * @param userRole 角色
     **/
    @Override
    public int getTotalCount(String userName, Integer userRole) {
        return userMapper.getTotalCount(userName,userRole);
    }

    /**
     * @Description:  模糊+分页查询用户
     * @param pageHeadIndex  页坐标
     * @param pageSize   页容量
     * @param userName   用户名称
     * @param userRole   用户角色
    **/
    @Override
    public List<User> queryUsersByPage(int pageHeadIndex, int pageSize, String userName, int userRole) {
        return userMapper.queryUsersByPage(pageHeadIndex,pageSize,userName,userRole);
    }

    /**
     * @Description:  添加用户业务
     * @param user 表单输入用户信息
    **/
    @Override
    public boolean insertNewUser(User user) {
        int i = userMapper.insertNewUser(user);
        if (i>0){
            return true;
        }
        return false;
    }

    /**
     * @Description: 展示指定用户信息业务
     * @param id 用户id
     * @return 该用户对象
    **/
    @Override
    public User queryTheUser(String id) {
        return userMapper.queryTheUser(id);
    }

    /**
     * @Description: 删除用户信息业务
     * @param id 用户id
    **/
    @Override
    public boolean deleteById(String id) {
        int i = userMapper.deleteById(id);
        if (i>0){
            return true;
        }
        return false;
    }

    /**
     * @Description: 修改当前用户密码
     * @param oldpassword  旧密码
     * @param rnewpassword  新密码
     **/
    @Override
    public boolean pwdSave(String oldpassword, String rnewpassword) {
        int i = userMapper.pwdSave(oldpassword,rnewpassword);
        return i>0;
    }
}

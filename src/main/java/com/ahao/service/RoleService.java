package com.ahao.service;

import com.ahao.pojo.Role;

import java.util.List;

/**
 * @Description: 角色实现接口
 * @Author: ahao
 * @Date: 2022/12/7 10:36
 **/
public interface RoleService {

    List<Role> getRoleList();

    boolean addRole(Role role);

    Role queryRoleById(String id);

    boolean modifySave(Role role);

    boolean delete(String id);
}

package com.ahao.service.impl;

import com.ahao.mapper.role.RoleMapper;
import com.ahao.pojo.Role;
import com.ahao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 角色业务
 * @Author: ahao
 * @Date: 2022/12/7 10:38
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * @Description: 获取角色列表业务
     * @return 角色列表
    **/
    @Override
    public List<Role> getRoleList() {
        return roleMapper.getRoleList();
    }

    /**
     * @Description: 添加角色业务
     * @param role 表单信息
     * @return 判断是否插入成功
    **/
    @Override
    public boolean addRole(Role role) {
        int i = roleMapper.addRole(role);
        if (i>0){
            return true;
        }
        return false;
    }

    /**
     * @Description: 获取将编辑角色信息业务
     * @param id  角色id
     * @return 角色信息
    **/
    @Override
    public Role queryRoleById(String id) {
        return roleMapper.queryRoleById(id);
    }

    /**
     * @Description: 修改角色信息业务
     * @param role 角色信息表单
    **/
    @Override
    public boolean modifySave(Role role) {
        int i = roleMapper.modifySave(role);
        if (i>0){
            return true;
        }
        return false;
    }

    /**
     * @Description: 删除某个供应商
    **/
    @Override
    public boolean delete(String id) {
        int i = roleMapper.delete(id);
        if (i>0){
            return true;
        }
        return false;
    }


}

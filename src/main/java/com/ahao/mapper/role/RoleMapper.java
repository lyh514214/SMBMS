package com.ahao.mapper.role;

import com.ahao.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 角色持久层
 * @Author: ahao
 * @Date: 2022/12/7 10:41
 **/
public interface RoleMapper {

    List<Role> getRoleList();

    int addRole(Role role);

    Role queryRoleById(@Param("id") String id);

    int modifySave(Role role);

    int delete(@Param("id") String id);
}

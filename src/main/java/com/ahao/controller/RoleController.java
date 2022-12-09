package com.ahao.controller;

import com.ahao.pojo.Role;
import com.ahao.pojo.User;
import com.ahao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Description: 角色控制器
 * @Author: ahao
 * @Date: 2022/12/7 10:22
 **/
@Controller
@RequestMapping("sys/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * @Description: 角色列表
     * @return java.lang.String
    **/
    @RequestMapping("list")
    public String list(Model model){
        List<Role> roleList = roleService.getRoleList();
        model.addAttribute("roleList",roleList);
        return "rolelist";
    }

    /**
     * @Description: 角色添加页
    **/
    @RequestMapping("add")
    public String add(){
        return "roleadd";
    }

    /**
     * @Description: 添加角色
     * @param role   表单信息
     * @param session 当前用户信息
    **/
    @RequestMapping("addsave")
    public String addSave(Role role, HttpSession session){
        User currentUser = (User) session.getAttribute("userSession");
        role.setCreatedBy(currentUser.getId());
        role.setCreationDate(new Date());
        boolean r = roleService.addRole(role);
        if (r){
            return "redirect:/sys/role/list";
        }
        return "roleadd";
    }

    /**
     * @Description: 更新页
    **/
    @RequestMapping("toUpdate")
    public String roleModify(String id,Model model){
        Role role = roleService.queryRoleById(id);
        model.addAttribute("role",role);
        return "rolemodify";
    }

    /**
     * @Description: 更新角色信息
     * @param role  表单角色信息
    **/
    @PostMapping("modifysave")
    public String modifySave(Role role){
        boolean r = roleService.modifySave(role);
        if (r){
            return "redirect:/sys/role/list";
        }
        return "rolemodify";
    }

    /**
     * @Description: 删除用户信息
     * @param id  用户id
    **/
    @RequestMapping("delete")
    public String delete(String id){
        boolean r = roleService.delete(id);
        if (r){
            return "redirect:/sys/role/list";
        }
        return "redirect:/sys/role/list";
    }
}

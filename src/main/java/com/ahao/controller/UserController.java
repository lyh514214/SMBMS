package com.ahao.controller;

import com.ahao.pojo.Role;
import com.ahao.pojo.User;
import com.ahao.service.RoleService;
import com.ahao.service.UserService;
import com.ahao.tools.HaoPageHelp;
import com.ahao.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Description: 用户控制器
 * @Author: ahao
 * @Date: 2022/12/7 14:58
 **/
@Controller
@RequestMapping("sys/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * @Description: 分页+模糊查询
     * @param userName   用户名称
     * @param userRole  用户角色id
     * @param pageIndex  当前页
    **/
    @RequestMapping("list")
    public String list(@RequestParam(name = "queryname",required = false) String userName
            ,@RequestParam(name = "queryUserRole",required = false) String userRole
            ,@RequestParam(name = "pageIndex",required = false) String pageIndex,Model model){

        int currentPageNo = 1;//当前页码
        int _userRole = 0;
        if (userName == null){
            userName = "";
        }
        if (userRole != null && userRole != ""){
            _userRole = Integer.parseInt(userRole);
        }
        if (pageIndex != null)
            try {
                currentPageNo = Integer.parseInt(pageIndex);
            }catch (NumberFormatException e){
                return "redirect:/syserror";
            }
        int totalCount = userService.getTotalCount(userName,_userRole);
        HaoPageHelp haoPageHelp = new HaoPageHelp();  //需set表记录总数、当前页即可
        haoPageHelp.setTotalCount(totalCount);
        haoPageHelp.setCurrentPageNo(currentPageNo);
        List<User> users = userService.queryUsersByPage(haoPageHelp.getPageHeadIndex(),haoPageHelp.pageSize,userName,_userRole);
        model.addAttribute("roleList",roleService.getRoleList());
        model.addAttribute("queryUserName",userName);
        model.addAttribute("queryUserRole",userRole);
        model.addAttribute("userList",users);
        model.addAttribute("totalPageCount",haoPageHelp.getTotalPageCount());
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("currentPageNo",currentPageNo);
        return "userlist";
    }

    /**
     * @Description: 用户添加页
    **/
    @RequestMapping("add")
    public String add(){
        return "useradd";
    }

    /**
     * @Description: 表单获取角色信息
     * @return 角色json对象
    **/
    @GetMapping("rolelist.json")
    @ResponseBody
    public List<Role> roleList(){
        return roleService.getRoleList();
    }

    /**
     * @Description: 添加用户
     * @param user  表单数据
     * @param session  当前网页数据
    **/
    @RequestMapping("addsave")
    public String addSave(User user, HttpSession session){
        User currentUser = (User) session.getAttribute("userSession");
        user.setCreatedBy(currentUser.getId());
        user.setCreationDate(new Date());
        boolean r = userService.insertNewUser(user);
        if (r){
            return "redirect:/sys/user/list";
        }
        return "redirect:/sys/user/list";
    }

    /**
     * @Description: 展示指定用户信息
    **/
    @RequestMapping("userview")
    public String userViewById(String id,Model model){
        User theUser = userService.queryTheUser(id);
        model.addAttribute("user",theUser);
        return "userview";
    }

    /**
     * @Description: 用户信息修改页
    **/
    @RequestMapping("usermodify")
    public String userModify(String id,Model model){
        User user = userService.queryTheUser(id);
        User theUser = userService.queryTheUser(id);
        model.addAttribute("user",theUser);
        return "usermodify";
    }

    /**
     * @Description: 删除指定用户
    **/
    @RequestMapping("delete")
    public String deleteUserById(String id){
        boolean r = userService.deleteById(id);
        if (r){
            return "redirect:/sys/user/list";
        }
        return "redirect:/sys/user/list";
    }

    /**
     * @Description: 当前用户信息修改页
     **/
    @RequestMapping("pwdmodify")
    public String pwdModify(HttpSession session,Model model){
        User currUser = (User) session.getAttribute("userSession");
        model.addAttribute("user",currUser);
        return "pwdmodify";
    }

    /**
     * @Description: 修改指定用户信息
     * @param user 表单传入用户信息
    **/
    @RequestMapping("modifysave")
    public String modifySave(User user){
        return "redirect:/sys/bill/list";
    }

    /**
     * @Description: 旧密码输入判断
    **/
    @PostMapping( "/pwdmodify.json" )
    @ResponseBody
    public Result pwdModifyJson(String oldpassword,HttpSession session,Model model){
        Result result = new Result();
        if (session.getId() == null){
            result.setResult("sessionerror");
        }
        if (Objects.equals(oldpassword, "")){
            result.setResult("error");
            return result;
        }
        if (oldpassword != null){
            User currUser = (User) session.getAttribute("userSession");
            if (oldpassword.equals(currUser.getUserPassword())){
                result.setResult("true");
                model.addAttribute("message","验证成功");
                return result;
            }
        }
        result.setResult("false");
        model.addAttribute("message","校验失败");
        return result;
    }

    /**
     * @Description: 修改当前用户密码
    **/
    @RequestMapping("pwdsave")
    public String pwdSave(String oldpassword,String rnewpassword,Model model){
        boolean r = userService.pwdSave(oldpassword,rnewpassword);
        if (r){
            return "redirect:/user/toLogin";
        }
        model.addAttribute("message","修改失败");
        return "redirect:/sys/user/modifysave";
    }


}

package com.ahao.controller;

import com.ahao.pojo.Provider;
import com.ahao.pojo.User;
import com.ahao.service.ProviderService;
import com.ahao.tools.HaoPageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Description: 供应商控制器
 * @Author: ahao
 * @Date: 2022/12/6 23:50
 **/
@Controller
@RequestMapping("sys/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;


    /**
     * @Description: 分页+模糊查询
     * @param proCode  供应商编码
     * @param proName   供应商姓名
     * @param pageIndex   当前页
    **/
    @RequestMapping("list")
    public String list(@RequestParam(name = "queryProCode",required = false) String proCode,
            @RequestParam(name = "queryProName",required = false) String proName,
            @RequestParam(name = "pageIndex",required = false) String pageIndex, Model model){
        int currentPageNo = 1;
        if (proCode == null){
            proCode = "";
        }
        if (proName == null){
            proName = "";
        }
        if (pageIndex != null){
            try {
                currentPageNo = Integer.parseInt(pageIndex);
            }catch (NumberFormatException e) {
                return "redirect:/syserror";
            }
        }

        int totalCount = providerService.getTotalCount(proCode,proName);
        HaoPageHelp haoPageHelp = new HaoPageHelp();
        haoPageHelp.setCurrentPageNo(currentPageNo);
        haoPageHelp.setTotalCount(totalCount);
        List<Provider> providers = providerService.queryProsByPage(haoPageHelp.getPageHeadIndex(),haoPageHelp.pageSize,proCode,proName);
        model.addAttribute("queryProCode",proCode);
        model.addAttribute("queryProName",proName);
        model.addAttribute("providerList",providers);
        model.addAttribute("totalPageCount",haoPageHelp.getTotalPageCount());
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("currentPageNo",currentPageNo);
        return "providerlist";
    }

    /**
     * @Description: 添加页面
    **/
    @RequestMapping("add")
    public String add(){
        return "provideradd";
    }

    /**
     * @Description: 添加供应商信息
    **/
    @RequestMapping("addsave")
    public String addSave(Provider provider, HttpSession session){
        User currUser = (User) session.getAttribute("userSession");
        provider.setCreatedBy(currUser.getId());
        provider.setCreationDate(new Date());
        boolean r = providerService.addSave(provider);
        if (r){
            return "redirect:/sys/provider/list";
        }
        return "redirect:/sys/provider/list";
    }

    /**
     * @Description: 查看指定供应商信息
     * @param id  指定供应商id
     * @param model  返回信息
    **/
    @RequestMapping("providerView")
    public String providerView(Integer id,Model model){
        Provider provider = providerService.queryProById(id);
        model.addAttribute("provider",provider);
        return "providerview";
    }

    /**
     * @Description: 修改页面
     * @param id  指定供应商id
     * @param model  返回供应商原本信息
    **/
    @RequestMapping("providerModify")
    public String providerModify(Integer id,Model model){
        Provider provider = providerService.queryProById(id);
        model.addAttribute("provider",provider);
        return "providermodify";
    }

    /**
     * @Description: 修改操作
     * @param provider 供应商表单信息
    **/
    @RequestMapping("modifysave")
    public String modifySave(Provider provider){
        boolean r = providerService.updateProById(provider);
        if (r){
            return "redirect:/sys/provider/list";
        }
        return "redirect:/sys/provider/list";
    }

    /**
     * @Description: 删除指定供应商
     * @param id 指定供应商id
    **/
    @RequestMapping("providerDel")
    public String providerDel(Integer id){
        boolean r = providerService.providerDel(id);
        if (r){
            return "redirect:/sys/provider/list";
        }
        return "redirect:/sys/provider/list";
    }



}

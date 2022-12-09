package com.ahao.controller;

import com.ahao.pojo.Bill;
import com.ahao.pojo.Provider;
import com.ahao.pojo.User;
import com.ahao.service.BillService;
import com.ahao.service.ProviderService;
import com.ahao.tools.HaoPageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


/**
 * @Description: 订单控制器
 * @Author: ahao
 * @Date: 2022/12/6 21:05
 **/
@Controller
@RequestMapping("sys/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private ProviderService providerService;

    /**
     * @Description: 分页+模糊查询
     * @param productName 商品名称
     * @param providerId 供应商id
     * @param isPayment  是否付款（1、2）
     * @param pageIndex 当前页
     * @return java.lang.String
    **/
    @RequestMapping("list")
    public String order(@RequestParam(name = "queryProductName",required = false) String productName
            ,@RequestParam(name = "queryProviderId",required = false) String providerId
            ,@RequestParam(name = "queryIsPayment",required = false) String isPayment
            ,@RequestParam(name = "pageIndex",required = false) String pageIndex
            ,Model model) {
        int _providerId = 0;
        int _isPayment = 0;
        int currentPageNo =1;
        if (productName == null){
            productName = "";
        }
        if (providerId != null && !providerId.equals("")){
            _providerId = Integer.parseInt(providerId);
        }
        if (isPayment != null && !isPayment.equals("")){
            _isPayment = Integer.parseInt(isPayment);
        }
        if (pageIndex != null){
            try {
                currentPageNo = Integer.parseInt(pageIndex);
            }catch (NumberFormatException e){
                return "redirect:/syserror";
            }
        }
        int totalCount = billService.getTotalCount(productName,_providerId,_isPayment);
        HaoPageHelp haoPageHelp = new HaoPageHelp();
        haoPageHelp.setTotalCount(totalCount);
        haoPageHelp.setCurrentPageNo(currentPageNo);
        List<Bill> bills = billService.queryBillsByPage(haoPageHelp.getPageHeadIndex(),haoPageHelp.pageSize,productName,_providerId,_isPayment);
        model.addAttribute("providerList",providerService.BillGetPros());
        model.addAttribute("billList",bills);
        model.addAttribute("queryProductName",productName);
        model.addAttribute("queryProviderId",_providerId);
        model.addAttribute("queryIsPayment",_isPayment);
        model.addAttribute("totalPageCount",haoPageHelp.getTotalPageCount());
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("currentPageNo",currentPageNo);
        return "billlist";
    }

    /**
     * @Description: 账单添加页
     **/
    @RequestMapping("add")
    public String add() {
        return "billadd";
    }

    /**
     * @Description: 获取供应商名称列表
     * @return 供应商集合
    **/
    @GetMapping("providerlist.json")
    @ResponseBody
    public List<Provider> getProList(){
        List<Provider> providerList = providerService.BillGetPros();
        return providerList;
    }

    /**
     * @Description: 添加账单
    **/
    @RequestMapping("addsave")
    public String addSave(Bill bill, HttpSession session){
        User currUser = (User) session.getAttribute("userSession");
        bill.setCreatedBy(currUser.getId());
        bill.setCreationDate(new Date());
        boolean r = billService.saveNewBill(bill);
        if (r){
            return "redirect:/sys/bill/list";
        }
        return "redirect:/sys/bill/list";
    }

    /**
     * @Description: 账单详情
    **/
    @RequestMapping("viewBill")
    public String viewBill(Integer id, Model model){
        Bill bill = billService.queryBillById(id);
        model.addAttribute("bill",bill);
        return "billview";
    }

    /**
     * @Description: 修改页
    **/
    @RequestMapping("modifyBill")
    public String modifyBill(Integer id,Model model){
        Bill bill = billService.queryBillById(id);
        model.addAttribute("bill",bill);
        return "billmodify";
    }

    /**
     * @Description: 保存修改
    **/
    @RequestMapping("modifysave")
    public String modifySave(Bill bill){
        boolean r = billService.modifySave(bill);
        if (r){
            return "redirect:/sys/bill/list";
        }
        return "redirect:/sys/bill/list";
    }

    /**
     * @Description: 删除
    **/
    @RequestMapping("deleteBill")
    public String deleteBill(Integer id){
        boolean r = billService.deleteBillById(id);
        if (r){
            return "redirect:/sys/bill/list";
        }
        return "redirect:/sys/bill/list";
    }





}

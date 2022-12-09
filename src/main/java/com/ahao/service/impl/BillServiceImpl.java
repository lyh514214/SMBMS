package com.ahao.service.impl;

import com.ahao.mapper.bill.BillMapper;
import com.ahao.pojo.Bill;
import com.ahao.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 订单业务实现类
 * @Author: ahao
 * @Date: 2022/12/6 23:36
 **/
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;

    /**
     * @Description: 模糊查询表记录总数
     * @param productName 商品名称
     * @param providerId 供应商id
     * @param isPayment 是否支付（1、2）
    **/
    @Override
    public int getTotalCount(String productName, int providerId, int isPayment) {
        return billMapper.getTotalCount(productName,providerId,isPayment);
    }

    /**
     * @Description: 分页+模糊查询
     * @param pageHeadIndex 页坐标
     * @param pageSize 页容量
     * @param productName 商品名称
     * @param providerId 供应商id
    **/
    @Override
    public List<Bill> queryBillsByPage(int pageHeadIndex, int pageSize, String productName, int providerId, int isPayment) {
        return billMapper.queryBillsByPage(pageHeadIndex,pageSize,productName,providerId,isPayment);
    }

    /**
     * @Description: 添加账单信息
    **/
    @Override
    public boolean saveNewBill(Bill bill) {
        int i = billMapper.saveNewBill(bill);
        return i > 0;
    }

    /**
     * @Description: 通过账单id获取账单信息
    **/
    @Override
    public Bill queryBillById(Integer id) {
        return billMapper.queryBillById(id);
    }

    /**
     * @Description: 修改账单信息
    **/
    @Override
    public boolean modifySave(Bill bill) {
        int i = billMapper.modifySave(bill);
        return i>0;
    }

    /**
     * @Description: 删除某个账单
    **/
    @Override
    public boolean deleteBillById(Integer id) {
        int i = billMapper.deleteBillById(id);
        return false;
    }
}

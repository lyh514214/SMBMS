package com.ahao.service;

import com.ahao.pojo.Bill;

import java.util.List;

/**
 * @Description: 订单实现接口
 * @Author: ahao
 * @Date: 2022/12/6 23:29
 **/
public interface BillService {

    int getTotalCount(String productName, int providerId, int isPayment);

    List<Bill> queryBillsByPage(int pageHeadIndex, int pageSize, String productName, int providerId, int isPayment);

    boolean saveNewBill(Bill bill);

    Bill queryBillById(Integer id);

    boolean modifySave(Bill bill);

    boolean deleteBillById(Integer id);
}

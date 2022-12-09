package com.ahao.mapper.bill;

import com.ahao.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 订单持久层
 * @Author: ahao
 * @Date: 2022/12/6 23:40
 **/
public interface BillMapper {

    int getTotalCount(@Param("productName") String productName,@Param("providerId") Integer providerId,@Param("isPayment") Integer isPayment);

    List<Bill> queryBillsByPage(@Param("pageHeadIndex") Integer pageHeadIndex,@Param("pageSize") Integer pageSize,@Param("productName") String productName,@Param("providerId") Integer providerId,@Param("isPayment") Integer isPayment);

    int saveNewBill(Bill bill);

    Bill queryBillById(@Param("id") Integer id);

    int modifySave(Bill bill);

    int deleteBillById(@Param("id") Integer id);
}

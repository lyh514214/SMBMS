package com.ahao.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 订单
 * @Author: ahao
 * @Date: 2022/12/6 21:57
 **/
@Data
public class Bill implements Serializable {

    public static final long serialVersionUID = 1L;

    private Integer id;                  //订单ID
    private String billCode;             //账单编码
    private String productName;          //商品名称
    private String productDesc;          //商品描述
    private String productUnit;          //商品单位
    private Float productCount;     //商品数量
    private Float totalPrice;       //商品总额
    private Integer isPayment;           //是否支付（1：未支付 2：已支付）
    private Integer providerId;          //供应商ID

    private String providerName;     //供应商名称

    private Integer createdBy;           //创建者（userId）
    private Date creationDate;           //创建时间
    private Integer modifyBy;            //更新者（userId）
    private Date modifyDate;             //更新时间




}

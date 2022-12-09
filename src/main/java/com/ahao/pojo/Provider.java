package com.ahao.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 供应商
 * @Author: ahao
 * @Date: 2022/12/7 23:25
 **/
@Data
public class Provider implements Serializable {

    private Integer id;    //id
    private String proCode;    //编号
    private String proName;    //名称
    private String proDesc;    //详细描述
    private String proContact;     //联系人
    private String proPhone;    //联系电话
    private String proAddress;     //地址
    private String proFax;      //传真

    private Integer createdBy;     //创建人
    private Date creationDate;     //创建时间
    private Integer modifyBy;      //修改人
    private Date modifyDate;       //修改时间

}

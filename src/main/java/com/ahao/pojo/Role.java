package com.ahao.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: Role
 * @Author: ahao
 * @Date: 2022/12/7 10:26
 **/
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;       //角色id
    private String roleCode;  //角色编码
    private String roleName;  //角色名称
    private Integer createdBy;  //创建者
    private Date creationDate;  //创建时间
    private Integer modifyBy;   //修改者
    private Date modifyDate;    //修改时间

}

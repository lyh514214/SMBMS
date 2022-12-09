package com.ahao.service.impl;

import com.ahao.mapper.provider.ProviderMapper;
import com.ahao.pojo.Provider;
import com.ahao.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 供应商业务实现
 * @Author: ahao
 * @Date: 2022/12/7 23:36
 **/
@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderMapper providerMapper;

    /**
     * @Description: 添加供应商信息
    *
     * @param provider*/
    @Override
    public boolean addSave(Provider provider) {
        int i = providerMapper.addSave(provider);
        if (i>0){
            return true;
        }
        return false;
    }

    /**
     * @Description: 通过id查询指定供应商信息
     * @param id  指定供应商id
    **/
    @Override
    public Provider queryProById(Integer id) {
        return providerMapper.queryProById(id);
    }

    /**
     * @Description: 修改指定供应商信息
     * @param provider 供应商表单信息
    **/
    @Override
    public boolean updateProById(Provider provider) {
        int i = providerMapper.updateProById(provider);
        return i > 0;
    }

    /**
     * @Description: 删除指定供应商
     * @param id 指定供应商id
    **/
    @Override
    public boolean providerDel(Integer id) {
        int i = providerMapper.providerDel(id);
        return i>0;
    }

    /**
     * @Description: 模糊查询表记录总数
     * @param proCode 供应商编号
     * @param proName 供应商名称
    **/
    @Override
    public int getTotalCount(String proCode, String proName) {
        return providerMapper.getTotalCount(proCode,proName);
    }

    /**
     * @Description: 分页+模糊查询
     * @param pageHeadIndex 页坐标
     * @param pageSize 页容量
     * @param proCode  供应商编号
     * @param proName  供应商名字
    **/
    @Override
    public List<Provider> queryProsByPage(int pageHeadIndex, int pageSize, String proCode, String proName) {
        return providerMapper.queryProsByPage(pageHeadIndex,pageSize,proCode,proName);
    }

    /**
     * @Description: 商品业务获取供应商信息
    **/
    @Override
    public List<Provider> BillGetPros() {
        return providerMapper.BillGetPros();
    }


}

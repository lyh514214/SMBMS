package com.ahao.service;

import com.ahao.pojo.Provider;

import java.util.List;

/**
 * @Description: 供应商业务接口
 * @Author: ahao
 * @Date: 2022/12/7 23:35
 **/
public interface ProviderService {

    boolean addSave(Provider provider);

    Provider queryProById(Integer id);

    boolean updateProById(Provider provider);

    boolean providerDel(Integer id);

    int getTotalCount(String proCode, String proName);

    List<Provider> queryProsByPage(int pageHeadIndex, int pageSize, String proCode, String proName);

    List<Provider> BillGetPros();
}

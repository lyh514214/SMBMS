package com.ahao.mapper.provider;

import com.ahao.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 供应商持久层
 * @Author: ahao
 * @Date: 2022/12/7 23:39
 **/
public interface ProviderMapper {

    int addSave(Provider provider);

    Provider queryProById(@Param("id") Integer id);

    int updateProById(Provider provider);

    int providerDel(@Param("id") Integer id);

    int getTotalCount(@Param("proCode") String proCode,@Param("proName") String proName);

    List<Provider> queryProsByPage(@Param("pageHeadIndex") Integer pageHeadIndex,@Param("pageSize") Integer pageSize,@Param("proCode") String proCode,@Param("proName") String proName);

    List<Provider> BillGetPros();
}

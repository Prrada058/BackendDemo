package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.backenddemo.entity.BdCustomer;

@Mapper
public interface BdCustomerMapper extends BaseMapper<BdCustomer> {
    BdCustomer getCustomerByPk(@Param("pk_customer") String pk_customer);

}

package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.backenddemo.entity.BdCurrency;

@Mapper
public interface BdCurrencyMapper extends BaseMapper<BdCurrency> {
    BdCurrency getCurrencyByPk(@Param("pk_currency") String pk_currency);

}

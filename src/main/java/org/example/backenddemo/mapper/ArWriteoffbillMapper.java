package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.backenddemo.entity.ArWriteoffbill;
import org.example.backenddemo.entity.BdAccount;

@Mapper
public interface ArWriteoffbillMapper extends BaseMapper<ArWriteoffbill> {

    ArWriteoffbill getWriteoffbillByPk(@Param("pk_ar_writeoffbill") String pk_ar_writeoffbill);
}

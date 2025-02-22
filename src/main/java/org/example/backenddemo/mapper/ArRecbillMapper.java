package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.backenddemo.entity.ArRecbill;

@Mapper
public interface ArRecbillMapper extends BaseMapper<ArRecbill> {
    ArRecbill getRecbillByPk(@Param("pk_recbill") String pk_recbill);

    int updateRecbillAsWriteoff(@Param("pk_recbill") String pk_recbill, @Param("remain_money") double remain_money, @Param("write_off_status") String write_off_status);


}

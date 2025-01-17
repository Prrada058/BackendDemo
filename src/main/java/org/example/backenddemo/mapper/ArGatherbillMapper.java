package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.backenddemo.entity.ArGatherbill;
import org.example.backenddemo.entity.BdAccount;

@Mapper
public interface ArGatherbillMapper extends BaseMapper<ArGatherbill> {
    ArGatherbill getGatherbillByPk(@Param("pk_gatherbill") String pk_gatherbill);

    int updateGatherbillAsWriteoff(@Param("pk_gatherbill") String pk_gatherbill, @Param("remain_money") double remain_money, @Param("write_off_status") String write_off_status);



}

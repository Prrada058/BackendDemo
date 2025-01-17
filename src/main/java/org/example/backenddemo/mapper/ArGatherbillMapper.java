package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.backenddemo.entity.ArGatherbill;
import org.example.backenddemo.entity.BdAccount;

@Mapper
public interface ArGatherbillMapper extends BaseMapper<ArGatherbill> {
    ArGatherbill getGatherbillByPk(@Param("pk_gatherbill") String pk_gatherbill);



}

package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.backenddemo.dto.ArRecbillFull;
import org.example.backenddemo.entity.ArRecbill;

import java.util.List;

@Mapper
public interface ArRecbillMapper extends BaseMapper<ArRecbill> {
    List<ArRecbillFull> getFullRecbill();

}

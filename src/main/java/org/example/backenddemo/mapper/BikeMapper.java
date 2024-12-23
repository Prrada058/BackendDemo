package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.backenddemo.entity.Bike;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BikeMapper extends BaseMapper<Bike> {
}

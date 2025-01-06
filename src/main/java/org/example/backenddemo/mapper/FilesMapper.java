package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.backenddemo.entity.Files;

@Mapper
public interface FilesMapper extends BaseMapper<Files> {
}

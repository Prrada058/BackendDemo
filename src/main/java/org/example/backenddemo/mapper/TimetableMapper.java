package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.backenddemo.entity.Timetable;

import java.util.List;

@Mapper
public interface TimetableMapper{

    @Select("SELECT TO_CHAR(subway_time, 'HH24:MI') FROM timetable WHERE ROWNUM <= 5 AND TO_CHAR(subway_time, 'HH24:MI:SS') > TO_CHAR(SYSDATE, 'HH24:MI:SS') and SUBWAY_DIRECTION like '北安河'")
    List<String> selectTimetable();
}


//public interface TimetableMapper extends BaseMapper<Timetable> {
//
//    @Select("SELECT TO_CHAR(subway_time, 'HH24:MI') FROM timetable WHERE TO_CHAR(subway_time, 'HH24:MI:SS') > TO_CHAR(SYSDATE, 'HH24:MI:SS') and SUBWAY_DIRECTION like '北安河'")
//    List<String> selectTimetable();
//}

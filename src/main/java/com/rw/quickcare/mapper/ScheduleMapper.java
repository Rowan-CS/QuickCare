package com.rw.quickcare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rw.quickcare.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @program: quickcare
 * @InterfaceName Schedule
 * @description:
 * @author: LRW
 * @create: 2024-02-27 20:17
 * @Version 1.0
 **/
@Mapper
public interface ScheduleMapper extends BaseMapper<Schedule> {

    @Select("")
    boolean isDuplicate(Schedule schedule);
}

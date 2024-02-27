package com.rw.quickcare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rw.quickcare.entity.DoctorSchedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: quickcare
 * @InterfaceName DoctorScheduleMapper
 * @description:
 * @author: LRW
 * @create: 2024-02-27 19:37
 * @Version 1.0
 **/
@Mapper
public interface DoctorScheduleMapper extends BaseMapper<DoctorSchedule> {


    List<DoctorSchedule> getAllByDocId(Integer docId);


}

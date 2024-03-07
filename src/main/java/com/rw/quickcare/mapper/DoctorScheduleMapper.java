package com.rw.quickcare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rw.quickcare.model.entity.DoctorSchedule;
import com.rw.quickcare.model.vo.schedule.DeptSchemQueryVo;
import com.rw.quickcare.model.vo.schedule.DocSchemQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    //根据部门查排班信息
    List<DocSchemQueryVo> getSchemDetail(@Param("deptId")Integer deptId, @Param("date")String date);

    //根据部门查所有日期排班资源
    List<DeptSchemQueryVo> getSchemByDept(Integer deptId);

}

package com.rw.quickcare.service;

import com.rw.quickcare.model.entity.DoctorSchedule;
import com.rw.quickcare.model.vo.PageBean;

/**
 * @program: quickcare
 * @InterfaceName DoctorScheduleService
 * @description:
 * @author: LRW
 * @create: 2024-02-27 23:32
 * @Version 1.0
 **/
public interface DoctorScheduleService{

    //新增医生排班班次
    void add(DoctorSchedule doctorSchedule);

    //修改医生班次
    void update(DoctorSchedule doctorSchedule);

    //删除医生班次
    void delete(Integer id);

    //按医生分页查询其所有排班
    PageBean<DoctorSchedule> getByDocAndPage(Integer docId, Integer curPage);


}

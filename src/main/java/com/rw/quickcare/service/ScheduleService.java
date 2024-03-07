package com.rw.quickcare.service;

import com.rw.quickcare.model.entity.Schedule;
import com.rw.quickcare.model.vo.PageBean;

import java.util.List;

/**
 * @program: quickcare
 * @InterfaceName ScheduleService
 * @description:
 * @author: LRW
 * @create: 2024-02-27 20:19
 * @Version 1.0
 **/
public interface ScheduleService {

    //分页查询所有班次
    PageBean<Schedule> getAllByPage(Integer page);
    //新增排班班次
    void add(Schedule schedule);

    //修改
    void update(Schedule schedule);

    //删除
    void delete(Integer id);

    //查所有排班时间段（实现新增医生排班功能）
    List<Schedule> getAll();

}

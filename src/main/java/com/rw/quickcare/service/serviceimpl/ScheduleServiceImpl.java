package com.rw.quickcare.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rw.quickcare.bizException.BizException;
import com.rw.quickcare.bizException.BizExceptionCode;
import com.rw.quickcare.model.entity.DoctorSchedule;
import com.rw.quickcare.model.entity.Schedule;
import com.rw.quickcare.mapper.DoctorScheduleMapper;
import com.rw.quickcare.mapper.ScheduleMapper;
import com.rw.quickcare.service.ScheduleService;
import com.rw.quickcare.model.vo.PageBean;
import com.rw.quickcare.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName ScheduleServiceImpl
 * @description:
 * @author: LRW
 * @create: 2024-02-27 20:19
 * @Version 1.0
 **/
@Service("ScheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private DoctorScheduleMapper doctorScheduleMapper;

    @Override
    public PageBean<Schedule> getAllByPage(Integer page) {
        List<Schedule> schedules = scheduleMapper.selectList(null);
        return DataUtils.listToPagebean(schedules,page,10);
    }

    @Override
    public void add(Schedule schedule) {
        //新增排班班次业务逻辑校验：1 无重复数据
        Long count = scheduleMapper.selectCount(new QueryWrapper<Schedule>()
                .eq("schedule_start_time",schedule.getStart())
                .eq("schedule_end_time",schedule.getEnd()));
        if(count > 0){
            throw new BizException(BizExceptionCode.SCHEDULE_EXISTED);
        }else
           // 2 开始时间小于结束时间 ..
        {
            scheduleMapper.insert(schedule);
        }

    }

    @Override
    public void update(Schedule schedule) {
        Long count = scheduleMapper.selectCount(new QueryWrapper<Schedule>()
                .eq("schedule_start_time",schedule.getStart())
                .eq("schedule_end_time",schedule.getEnd()));
        if(count > 0){
            throw new BizException(BizExceptionCode.SCHEDULE_EXISTED);
        }else {
            scheduleMapper.updateById(schedule);
        }
    }

    @Override
    public void delete(Integer id) {
        QueryWrapper<DoctorSchedule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("schedule_id",id);
        List<DoctorSchedule> doctorSchedules = doctorScheduleMapper.selectList(queryWrapper);
        if (doctorSchedules.size()==0){
            scheduleMapper.deleteById(id);
        } else {
            throw new BizException(BizExceptionCode.DELETE_SCHEDULE_FAIL);
        }

    }

    @Override
    public List<Schedule> getAll() {
        List<Schedule> schedules = scheduleMapper.selectList(null);
        return schedules;
    }
}

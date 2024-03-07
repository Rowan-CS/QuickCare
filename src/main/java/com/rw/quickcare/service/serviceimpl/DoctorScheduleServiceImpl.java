package com.rw.quickcare.service.serviceimpl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rw.quickcare.bizException.BizException;
import com.rw.quickcare.bizException.BizExceptionCode;
import com.rw.quickcare.model.entity.DoctorSchedule;
import com.rw.quickcare.mapper.DoctorScheduleMapper;
import com.rw.quickcare.model.vo.schedule.DeptSchemQueryVo;
import com.rw.quickcare.model.vo.schedule.DocSchemQueryVo;
import com.rw.quickcare.service.DoctorScheduleService;
import com.rw.quickcare.model.vo.PageBean;
import com.rw.quickcare.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: quickcare
 * @ClassName DoctorScheduleServiceImpl
 * @description:
 * @author: LRW
 * @create: 2024-02-27 23:32
 * @Version 1.0
 **/
@Service("DoctorScheduleService")
public class DoctorScheduleServiceImpl implements DoctorScheduleService {

    @Autowired
    private DoctorScheduleMapper doctorScheduleMapper;


    @Override
    public void add(DoctorSchedule doctorSchedule){
        //新增医生排班业务逻辑校验：无重复数据
        Long count = doctorScheduleMapper.selectCount(new QueryWrapper<DoctorSchedule>()
                .eq("doctor_id",doctorSchedule.getDoctorId())
                .eq("schedule_id",doctorSchedule.getScheduleId())
                .eq("doctor_schedule_date",doctorSchedule.getDate()));
        if(count > 0){
            throw new BizException(BizExceptionCode.DOCTOR_SCHEDULE_EXISTED);
        }else
        {
            doctorSchedule.setResidue(doctorSchedule.getNum());
            doctorSchedule.setStatus(1);
            doctorScheduleMapper.insert(doctorSchedule);
        }

    }

    @Override
    public void update(DoctorSchedule doctorSchedule) {
        //新增医生排班业务逻辑校验：无重复数据
        Long count = doctorScheduleMapper.selectCount(new QueryWrapper<DoctorSchedule>()
                .eq("doctor_id",doctorSchedule.getDoctorId())
                .eq("schedule_id",doctorSchedule.getScheduleId())
                .eq("doctor_schedule_date",doctorSchedule.getDate()));
        if(count > 0){
            throw new BizException(BizExceptionCode.DOCTOR_SCHEDULE_EXISTED);
        }else {
            doctorScheduleMapper.updateById(doctorSchedule);
        }
    }

    @Override
    public void delete(Integer id) {
        // 删除医生排班业务逻辑校验：无预约
        DoctorSchedule doctorSchedule = doctorScheduleMapper.selectById(id);
        Long count = doctorScheduleMapper.selectCount(new QueryWrapper<DoctorSchedule>()
                .ne("doctor_schedule_residue",doctorSchedule.getNum())); //可预约量不等于剩余预约数量
        if(count > 0){
            throw new BizException(BizExceptionCode.DELETE_DOC_AND_SCHEDULE_FAIL);
        }else {
            doctorScheduleMapper.deleteById(id);
        }
    }

    @Override
    public PageBean<DoctorSchedule> getByDocAndPage(Integer docId, Integer curPage) {
        List<DoctorSchedule> list = doctorScheduleMapper.getAllByDocId(docId);
        return DataUtils.listToPagebean(list,curPage,10);
    }

    @Override
    public PageBean<DeptSchemQueryVo> getSchemsByDeptAndPage(Integer deptId, Integer page) {
        List<DeptSchemQueryVo> schemList = doctorScheduleMapper.getSchemByDept(deptId);
        String[] weekStr={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        for (DeptSchemQueryVo data :  schemList) {
            int index = DateUtil.dayOfWeek(DateUtil.parse(data.getDate()));
            data.setWeekOfDate(weekStr[index-1]);
        }
        return DataUtils.listToPagebean(schemList,page,7);
    }

    @Override
    public List<DocSchemQueryVo> getSchemDetail(Integer deptId, String date) {
        List<DocSchemQueryVo> schemDetail = doctorScheduleMapper.getSchemDetail(deptId, date);
        return  schemDetail;
    }

    }

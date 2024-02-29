package com.rw.quickcare.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.rw.quickcare.bizException.BizException;
import com.rw.quickcare.bizException.BizExceptionCode;
import com.rw.quickcare.model.entity.Doctor;
import com.rw.quickcare.model.entity.DoctorSchedule;
import com.rw.quickcare.mapper.DoctorMapper;
import com.rw.quickcare.mapper.DoctorScheduleMapper;
import com.rw.quickcare.service.DoctorService;
import com.rw.quickcare.model.vo.PageBean;
import com.rw.quickcare.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName DoctorServiceImpl
 * @description:
 * @author: LRW
 * @create: 2024-02-27 16:29
 * @Version 1.0
 **/
@Service("DoctorService")
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private DoctorScheduleMapper doctorScheduleMapper;

    @Override
    public PageBean<Doctor> getByHosIdAndPage(Integer id, Integer currentPage) {
        List<Doctor> doctors = doctorMapper.getALLByHos(id);
        PageBean pageBean = DataUtils.listToPagebean(doctors, currentPage, 10);
        return pageBean;
    }

    @Override
    public void add(Doctor doctor) {
        doctor.setStatus(1);
        doctorMapper.insert(doctor);
    }

    @Override
    public void delete(Integer id) {
        //删除条件：无排班信息
        QueryWrapper<DoctorSchedule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("doctor_id",id);
        List<DoctorSchedule> doctorSchedules = doctorScheduleMapper.selectList(queryWrapper);
        if (doctorSchedules.size()==0){
            doctorMapper.deleteById(id);
        } else {
            throw new BizException(BizExceptionCode.DELETE_DOC_FAIL);
        }
    }

    @Override
    public void update(Doctor doctor) {
        doctorMapper.updateById(doctor);
    }

    @Override
    public void block(Integer id) {
        UpdateWrapper<Doctor> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("doctor_id",id).set("doctor_status", 0);
        doctorMapper.update(null,updateWrapper);
    }

    @Override
    public void unblock(Integer id) {
        UpdateWrapper<Doctor> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("doctor_id",id).set("doctor_status", 1);
        doctorMapper.update(null,updateWrapper);
    }
}

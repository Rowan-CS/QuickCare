package com.rw.quickcare.service.serviceimpl;

import com.rw.quickcare.entity.DoctorSchedule;
import com.rw.quickcare.mapper.DoctorScheduleMapper;
import com.rw.quickcare.service.DoctorScheduleService;
import com.rw.quickcare.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        doctorSchedule.setResidue(doctorSchedule.getNum());
        doctorSchedule.setStatus(1);
        doctorScheduleMapper.insert(doctorSchedule);
    }

    @Override
    public void update(DoctorSchedule doctorSchedule) {
        doctorScheduleMapper.updateById(doctorSchedule);
    }

    @Override
    public void delete(Integer id) {
        doctorScheduleMapper.deleteById(id);
    }

    @Override
    public PageBean<DoctorSchedule> getByDocAndPage(Integer docId, Integer curPage) {
//        doctorScheduleMapper.
        return null;
    }


}

package com.rw.quickcare.service;

import com.rw.quickcare.model.entity.Doctor;
import com.rw.quickcare.model.vo.PageBean;

/**
 * @program: quickcare
 * @InterfaceName DoctorService
 * @description:
 * @author: LRW
 * @create: 2024-02-27 16:28
 * @Version 1.0
 **/
public interface DoctorService {

    //根据医院查所有医生
    PageBean<Doctor> getByHosIdAndPage(Integer id, Integer currentPage);

    //新增医生
    void add(Doctor doctor);

    //删除医生
    void delete(Integer id);
    //修改医生
    void update(Doctor doctor);
    //锁定医生（不可用）
    void block(Integer id);
    //取消锁定
    void unblock(Integer id);
}

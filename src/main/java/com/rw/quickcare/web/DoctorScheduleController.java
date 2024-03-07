package com.rw.quickcare.web;

import com.rw.quickcare.model.entity.DoctorSchedule;
import com.rw.quickcare.model.vo.schedule.DeptSchemQueryVo;
import com.rw.quickcare.model.vo.schedule.DocSchemQueryVo;
import com.rw.quickcare.service.DoctorScheduleService;
import com.rw.quickcare.model.entity.ResponseEntity;
import com.rw.quickcare.model.vo.hos.DoctorScheduleListVo;
import com.rw.quickcare.model.vo.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @program: quickcare
 * @ClassName DoctorScheduleController
 * @description:排班管理
 * @author: LRW
 * @create: 2024-02-28 15:59
 * @Version 1.0
 **/
@Transactional
@RestController("docschemcontroller")
@CrossOrigin
@RequestMapping("/api/v1/docschem")
public class DoctorScheduleController {

    @Autowired
    private DoctorScheduleService doctorScheduleService;

    @PostMapping("/add")
    public ResponseEntity add(@Validated @RequestBody(required=false) DoctorSchedule doctorSchedule){
        doctorSchedule.setDoctorId(Integer.valueOf(doctorSchedule.getDoctorId()));
        doctorScheduleService.add(doctorSchedule);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/update")
    public ResponseEntity update(@Validated @RequestBody DoctorSchedule doctorSchedule){
        doctorScheduleService.update(doctorSchedule);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/delete/{docId}")
    public ResponseEntity delete(@PathVariable Integer docId){
        doctorScheduleService.delete(docId);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/selectByDoc")
    public ResponseEntity list(@RequestBody DoctorScheduleListVo doctorScheduleListVo){
        PageBean<DoctorSchedule> pageBean = doctorScheduleService.getByDocAndPage(doctorScheduleListVo.getDocId(), doctorScheduleListVo.getPage());
        return new ResponseEntity("200",pageBean);
    }

    @RequestMapping("/selectByDept/{deptId}/{page}")
    public ResponseEntity list(@PathVariable Integer deptId, @PathVariable Integer page){
        PageBean<DeptSchemQueryVo> pageBean = doctorScheduleService.getSchemsByDeptAndPage(deptId, page);
        return new ResponseEntity("200",pageBean);
    }

    @RequestMapping("/getDetail/{deptId}/{date}")
    public ResponseEntity getDetail(@PathVariable Integer deptId,@PathVariable String date){
        List<DocSchemQueryVo> detail = doctorScheduleService.getSchemDetail(deptId, date);
        return new ResponseEntity("200",detail);
    }


}

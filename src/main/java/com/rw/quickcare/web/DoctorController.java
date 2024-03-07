package com.rw.quickcare.web;

import com.rw.quickcare.model.entity.Doctor;
import com.rw.quickcare.model.vo.hos.DoctorQueryVo;
import com.rw.quickcare.service.DoctorService;
import com.rw.quickcare.model.entity.ResponseEntity;
import com.rw.quickcare.model.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @program: quickcare
 * @ClassName DoctorController
 * @description:
 * @author: LRW
 * @create: 2024-02-27 18:51
 * @Version 1.0
 **/
@Transactional
@RestController("doctorcontroller")
@CrossOrigin
@RequestMapping("/api/v1/doc")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/selectList/{hosId}/{page}")
    public ResponseEntity selectList(@RequestBody DoctorQueryVo doctorQueryVo, @PathVariable Integer hosId, @PathVariable Integer page){
        PageBean<Doctor> pageBean = doctorService.getByCon(doctorQueryVo,hosId, page);
        return new ResponseEntity("200","查询成功",pageBean);
    }

    @RequestMapping("/add")
    public ResponseEntity add(@Validated @RequestBody Doctor doctor){
        doctorService.add(doctor);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("/update/{id}")
    public ResponseEntity update(@Validated @RequestBody Doctor doctor, @PathVariable Integer id){
        doctor.setId(id);
        doctorService.update(doctor);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("/block/{id}")
    public ResponseEntity block(@PathVariable Integer id){
        doctorService.block(id);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/unblock/{id}")
    public ResponseEntity unblock(@PathVariable Integer id){
        doctorService.unblock(id);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        doctorService.delete(id);
        return ResponseEntity.SUCCESS;
    }

}

package com.rw.quickcare.web;

import com.rw.quickcare.model.entity.Schedule;
import com.rw.quickcare.service.ScheduleService;
import com.rw.quickcare.model.entity.ResponseEntity;
import com.rw.quickcare.model.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: quickcare
 * @ClassName ScheduleController
 * @description:排班管理  -> 排班设置
 * @author: LRW
 * @create: 2024-02-27 22:18
 * @Version 1.0
 **/
@Transactional
@RestController("schemcontroller")
@RequestMapping("/api/v1/schem")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/add")
    public ResponseEntity add(@Validated @RequestBody Schedule schedule){
        scheduleService.add(schedule);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/list/{curPage}")
    public ResponseEntity select(@PathVariable Integer curPage){
        PageBean<Schedule> pageBean = scheduleService.getAllByPage(curPage);
        return new ResponseEntity("200",pageBean);
    }

    @RequestMapping("/update")
    public ResponseEntity update(@Validated @RequestBody Schedule schedule){
        scheduleService.update(schedule);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        scheduleService.delete(id);
        return ResponseEntity.SUCCESS;
    }

}

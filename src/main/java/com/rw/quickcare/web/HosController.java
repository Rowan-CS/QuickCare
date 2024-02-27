package com.rw.quickcare.web;

import com.rw.quickcare.entity.Hos;
import com.rw.quickcare.service.HosService;
import com.rw.quickcare.unityhandler.ResponseEntity;
import com.rw.quickcare.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName HosController
 * @description:
 * @author: LRW
 * @create: 2024-02-27 02:15
 * @Version 1.0
 **/
@Transactional
@RestController("hoscontroller")
@RequestMapping("/api/v1/hos")
public class HosController {

    @Autowired
    private HosService hosService;

    @RequestMapping("/add")
    public ResponseEntity add(@Validated @RequestBody Hos hos){
        hosService.addHos(hos);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        hosService.delete(id);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/selectDeleted/{page}")
    public ResponseEntity selectDeleted(@PathVariable Integer page){
        PageBean<Hos> pageBean = hosService.getAllDeleted(page);
        return new ResponseEntity("200","查询成功",pageBean);
    }

    @RequestMapping("/rerun/{id}")
    public ResponseEntity rerun(@PathVariable Integer id){
        hosService.rerunById(id);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/update")
    public ResponseEntity update(@Validated @RequestBody Hos hos){
        hosService.update(hos);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/block/{id}")
    public ResponseEntity block(@PathVariable Integer id){
        hosService.block(id);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/unblock/{id}")
    public ResponseEntity unblock(@PathVariable Integer id){
        hosService.unblock(id);
        return ResponseEntity.SUCCESS;
    }

}

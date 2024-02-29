package com.rw.quickcare.web;

import com.rw.quickcare.model.entity.Hos;
import com.rw.quickcare.model.vo.hos.HosInsertVo;
import com.rw.quickcare.model.vo.hos.HosQueryVo;
import com.rw.quickcare.model.vo.hos.HosUpdateVo;
import com.rw.quickcare.service.HosService;
import com.rw.quickcare.model.entity.ResponseEntity;
import com.rw.quickcare.model.vo.PageBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
@RequestMapping("/api/v1/hos")
public class HosController {

    @Autowired
    private HosService hosService;

    @PostMapping("/add")
    public ResponseEntity add(@Validated HosInsertVo hosInsertVo){
        System.out.println(hosInsertVo);
        Hos hos = new Hos();
        BeanUtils.copyProperties(hosInsertVo,hos);
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
    public ResponseEntity update(@Validated HosUpdateVo hosUpdateVo){
        Hos hos = new Hos();
        BeanUtils.copyProperties(hosUpdateVo,hos);
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
    @RequestMapping("/list/{curPage}")
    public ResponseEntity getAllByPage(HosQueryVo hosQueryVo, @PathVariable Integer curPage){
        PageBean<Hos> pageBean = hosService.getByConsAndPage(hosQueryVo,curPage);
        return new ResponseEntity("200","查询成功",pageBean);
    }
    @RequestMapping("/getHospSet/{id}")
    public ResponseEntity getHospSet(@PathVariable Integer id){
        HosInsertVo hosSetInfo = hosService.getHosSetInfo(id);
        return new ResponseEntity("200",hosSetInfo);
    }

}

package com.rw.quickcare.web;

import com.rw.quickcare.model.entity.Reservation;
import com.rw.quickcare.model.entity.ResponseEntity;
import com.rw.quickcare.model.entity.User;
import com.rw.quickcare.model.vo.PageBean;
import com.rw.quickcare.model.vo.reservation.ReservationCountQueryVo;
import com.rw.quickcare.model.vo.reservation.ReservationQueryVo;
import com.rw.quickcare.model.vo.user.UserQueryVo;
import com.rw.quickcare.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: quickcare
 * @ClassName ReservationController
 * @description:
 * @author: LRW
 * @create: 2024-03-04 14:59
 * @Version 1.0
 **/
@Transactional
@RestController("rescontroller")
@CrossOrigin
@RequestMapping("/api/v1/res")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/getByCon/{hosId}/{page}/{limit}")
    public ResponseEntity getByCon(
            @RequestBody ReservationQueryVo reservationQueryVo,
            @PathVariable Integer hosId,
            @PathVariable Integer page,
            @PathVariable Integer limit){
        PageBean<Reservation> pageBean = reservationService.getByCon(reservationQueryVo, hosId, page, limit);
        return new ResponseEntity("200",pageBean);
    }

    @PostMapping("/getCountMap")
    public ResponseEntity getCountMap(ReservationCountQueryVo reservationCountQueryVo) {
        Map<String, Object> countMap = reservationService.getCountMap(reservationCountQueryVo);
        return new ResponseEntity("200",countMap);
    }
}

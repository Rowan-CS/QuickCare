package com.rw.quickcare.service;

import com.rw.quickcare.model.entity.Reservation;
import com.rw.quickcare.model.vo.PageBean;
import com.rw.quickcare.model.vo.reservation.ReservationCountQueryVo;
import com.rw.quickcare.model.vo.reservation.ReservationQueryVo;

import java.util.Map;

/**
 * @program: quickcare
 * @InterfaceName ReservationService
 * @description:
 * @author: LRW
 * @create: 2024-03-04 14:55
 * @Version 1.0
 **/
public interface ReservationService {

    //多条件分页查询
    PageBean<Reservation> getByCon(ReservationQueryVo reservationQueryVo,Integer hosId, Integer page, Integer limit);

    //统计管理
    Map<String, Object> getCountMap(ReservationCountQueryVo reservationCountQueryVo);
}

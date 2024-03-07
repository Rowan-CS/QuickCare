package com.rw.quickcare.service.serviceimpl;

import com.rw.quickcare.mapper.ReservationMapper;
import com.rw.quickcare.model.entity.Reservation;
import com.rw.quickcare.model.vo.PageBean;
import com.rw.quickcare.model.vo.reservation.ReservationCountQueryVo;
import com.rw.quickcare.model.vo.reservation.ReservationCountVo;
import com.rw.quickcare.model.vo.reservation.ReservationQueryVo;
import com.rw.quickcare.service.ReservationService;
import com.rw.quickcare.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: quickcare
 * @ClassName ReservationServiceImpl
 * @description:
 * @author: LRW
 * @create: 2024-03-04 14:57
 * @Version 1.0
 **/
@Service("ReservationService")
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public PageBean<Reservation> getByCon(ReservationQueryVo reservationQueryVo, Integer hosId, Integer page, Integer limit) {
        List<Reservation> reservations = reservationMapper.selectByCondition(hosId,reservationQueryVo);
        return DataUtils.listToPagebean(reservations,page,limit);
    }

    @Override
    public Map<String, Object> getCountMap(ReservationCountQueryVo reservationCountQueryVo) {
        //调用mapper方法得到数据
        List<ReservationCountVo> reservationCountVosList = reservationMapper.selectResCount(reservationCountQueryVo);
        //获取x轴需要数据，日期数据，List集合
        List<String> dateList = reservationCountVosList.stream().map(ReservationCountVo::getReserveDate).collect(Collectors.toList());
        //获取Y轴需要数据，具体数量，List集合
        List<Integer> countList = reservationCountVosList.stream().map(ReservationCountVo::getCount).collect(Collectors.toList());

        Map<String, Object> map = new HashMap<>();
        map.put("dateList", dateList);
        map.put("countList", countList);
        return map;
    }
}

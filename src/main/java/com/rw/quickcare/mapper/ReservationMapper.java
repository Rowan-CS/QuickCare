package com.rw.quickcare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rw.quickcare.model.entity.Reservation;
import com.rw.quickcare.model.vo.admin.AdminListVo;
import com.rw.quickcare.model.vo.admin.AdminQueryVo;
import com.rw.quickcare.model.vo.reservation.ReservationCountQueryVo;
import com.rw.quickcare.model.vo.reservation.ReservationCountVo;
import com.rw.quickcare.model.vo.reservation.ReservationQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: quickcare
 * @InterfaceName ReservationMapper
 * @description:
 * @author: LRW
 * @create: 2024-03-04 12:44
 * @Version 1.0
 **/
@Mapper
public interface ReservationMapper extends BaseMapper<Reservation> {

    //多条件查预约
    List<Reservation> selectByCondition(@Param("hosId") Integer hosId, @Param("reservation") ReservationQueryVo reservation);

    //按医院查预约
//    List<Reservation> selectByHosId(Integer hosId);

    //统计查询
    List<ReservationCountVo> selectResCount(@Param("vo") ReservationCountQueryVo reservationCountQueryVo);


}

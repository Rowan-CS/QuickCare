package com.rw.quickcare.model.vo.reservation;

import lombok.Data;

/**
 * @program: quickcare
 * @ClassName ReservationQueryVo
 * @description:
 * @author: LRW
 * @create: 2024-03-04 12:45
 * @Version 1.0
 **/
@Data
public class ReservationQueryVo {
    private Integer deptId;
    private String userName;
    private String patientName;
    private Integer status;
    private String orderStartTime;
    private String orderEndTime;
//    private String createStartTime;
//    private String createEndTime;
}

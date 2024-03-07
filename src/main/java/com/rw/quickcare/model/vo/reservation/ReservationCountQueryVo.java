package com.rw.quickcare.model.vo.reservation;

import lombok.Data;

/**
 * @program: quickcare
 * @ClassName ReservationCountQueryVo
 * @description:
 * @author: LRW
 * @create: 2024-03-04 20:00
 * @Version 1.0
 **/
@Data
public class ReservationCountQueryVo {
    private String hosId;
    private String hosName;
    private String reserveDateBegin;
    private String reserveDateEnd;
}

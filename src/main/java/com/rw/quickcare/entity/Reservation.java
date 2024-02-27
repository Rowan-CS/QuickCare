package com.rw.quickcare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName Reservation
 * @description:
 * @author: LRW
 * @create: 2024-02-23 00:48
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class Reservation {
    @TableId(value = "reservation_id", type = IdType.AUTO)
    private Integer id;
    private String no;
    private User user;
    private Patient patient;
    private DoctorSchedule doctorSchedule;
    private Hos hos;
    private Dept dept;
    private Doctor doctor;
    private Integer cost;
    private Integer status;
    private String createTime;
    private String paidTime;

}

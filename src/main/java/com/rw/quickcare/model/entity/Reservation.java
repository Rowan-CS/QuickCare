package com.rw.quickcare.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    @TableField("reservation_no")
    private String no;
    @TableField("reservation_date")
    private String date;
    private User user;
    private Patient patient;
    private DoctorSchedule doctorSchedule;
    private Hos hos;
    private Dept dept;
    private Doctor doctor;
    @TableField("reservation_cost")
    private Integer cost;
    @TableField("reservation_status")
    private Integer status;
    @TableField("reservation_create_time")
    private String createTime;
    @TableField("reservation_paid_time")
    private String paidTime;

}

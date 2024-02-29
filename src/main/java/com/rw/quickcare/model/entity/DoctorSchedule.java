package com.rw.quickcare.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @program: quickcare
 * @ClassName DoctorSchedule
 * @description:
 * @author: LRW
 * @create: 2024-02-23 01:08
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class DoctorSchedule {
    @TableId(value = "doctor_schedule_id", type = IdType.AUTO)
    private Integer id;
    @TableField("doctor_id")
    @NotBlank(message = "医生不允许为空")
    private Integer doctorId;
    @TableField("schedule_id")
    @NotBlank(message = "班次不允许为空")
    private Integer scheduleId;
    @TableField("doctor_schedule_date")
    @NotBlank(message = "日期不允许为空")
    private String date;
    @TableField("doctor_schedule_num")
    @NotBlank(message = "可预约数量不允许为空")
    private Integer num;
    @TableField("doctor_schedule_residue")
    private Integer residue;
    @TableField("doctor_schedule_status")
    private Integer status;
}

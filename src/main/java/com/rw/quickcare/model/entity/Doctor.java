package com.rw.quickcare.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @program: quickcare
 * @ClassName Doctor
 * @description:
 * @author: LRW
 * @create: 2024-02-23 01:06
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class Doctor {
    @TableId(value = "doctor_id", type = IdType.AUTO)
    private Integer id;
    @TableField("dept_id")
    @NotNull(message = "所属科室不能为空")
    private Integer deptId;
    @TableField("doctor_name")
    @NotBlank(message = "医生姓名不能为空")
    @Size(min=3, max = 50, message = "医生姓名符长度必须为 2~50个")
    private String name;
    @TableField("doctor_gender")
    @NotBlank(message = "医生性别不能为空")
    private String gender;
    @TableField("doctor_title")
    @NotBlank(message = "医生职称不能为空")
    private String title;
    @TableField("doctor_fee")
    @NotBlank(message = "医生挂号费用不能为空")
    private Integer fee;
    @TableField("doctor_intro")
    @NotBlank(message = "医生简介不能为空")
    private String intro;
    @TableField("doctor_status")
    private Integer status;
    @TableField(exist = false, select = false)
    private String deptName;

    @TableField(exist = false, select = false)
    private List<Schedule> schedules;
}

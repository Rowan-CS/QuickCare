package com.rw.quickcare.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName Patient
 * @description:
 * @author: LRW
 * @create: 2024-02-23 00:48
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class Patient {
    @TableId(value = "patient_id", type = IdType.AUTO)
    private Integer id;
    @TableField("user_id")
    private Integer userId;
    @TableField("patient_name")
    private String name;
    @TableField("patient_gender")
    private String gender;
    @TableField("patient_birthdate")
    private String birthDate;
    @TableField("patient_certi_type")
    private Integer certiType;
    @TableField("patient_certi_no")
    private String certiNo;
    @TableField("patient_phone")
    private String phone;
    @TableField("patient_address")
    private String address;
    @TableField("patient_med_no")
    private String medNo;
    @TableField("patient_is_default")
    private Integer isDefault;
}

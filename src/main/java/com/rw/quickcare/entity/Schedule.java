package com.rw.quickcare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @program: quickcare
 * @ClassName Schedule
 * @description:
 * @author: LRW
 * @create: 2024-02-23 01:10
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class Schedule {
    @TableId(value = "schedule_id", type = IdType.AUTO)
    private Integer id;
    @TableField("schedule_name")
    @NotBlank(message = "班次名称不能为空")
    private String name;
    @TableField("schedule_start_time")
    @NotBlank(message = "开始时间不能为空")
    private String start;
    @TableField("schedule_end_time")
    @NotBlank(message = "结束时间不能为空")
    private String end;
}

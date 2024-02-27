package com.rw.quickcare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @program: quickcare
 * @ClassName Dept
 * @description:
 * @author: LRW
 * @create: 2024-02-23 01:04
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class Dept {
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Integer id;
    @TableField("hos_id")
    private Integer hosId;
    @TableField("dept_name")
    @NotBlank(message = "科室名不能为空")
    @Size(min=2, max = 50, message = "科室名字符长度必须为2~50个")
    private String name;
    @TableField("dept_fid")
    private Integer fid;
    @TableField("dept_intro")
    @NotBlank(message = "科室介绍不能为空")
    private String intro;
    @TableField("dept_location")
    @NotBlank(message = "科室位置不能为空")
    private String location;
    @TableField("dept_status")
    private Integer status;
}

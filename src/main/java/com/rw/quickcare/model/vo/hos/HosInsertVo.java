package com.rw.quickcare.model.vo.hos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @program: quickcare
 * @ClassName HosInsertVo
 * @description:
 * @author: LRW
 * @create: 2024-02-29 22:03
 * @Version 1.0
 **/
@Data
public class HosInsertVo {
    @NotBlank(message = "名字不能为空")
    @Size(min=3, max = 50, message = "名字字符长度必须为 3~50个")
    private String name;
    @NotNull(message = "等级不能为空")
    private Integer level;
    @NotBlank(message = "地址不能为空")
    @Size(min=3, max = 50, message = "地址字符长度必须为 3~50个")
    private String address;
    private Integer status;
    @NotBlank(message = "电话能不为空")
    @Size(min=3, max = 50, message = "字符长度必须为 3~50个")
    private String tele;
    @NotBlank(message = "简介不能为空")
    @Size(min=3, max = 200, message = "简介字符长度必须为 3~200个")
    private String intro;
}

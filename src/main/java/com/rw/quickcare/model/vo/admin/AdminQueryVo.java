package com.rw.quickcare.model.vo.admin;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: quickcare
 * @ClassName AdminQueryVo
 * @description:
 * @author: LRW
 * @create: 2024-03-03 22:52
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class AdminQueryVo {
    private String name;
    private Integer status;
    private Integer isDel;
}

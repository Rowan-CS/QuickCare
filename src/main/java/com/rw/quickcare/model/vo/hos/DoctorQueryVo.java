package com.rw.quickcare.model.vo.hos;

import lombok.Data;

/**
 * @program: quickcare
 * @ClassName DoctorQueryVo
 * @description:
 * @author: LRW
 * @create: 2024-03-08 00:08
 * @Version 1.0
 **/
@Data
public class DoctorQueryVo {
    private String name;
    private String title;
    private Integer deptId;
}

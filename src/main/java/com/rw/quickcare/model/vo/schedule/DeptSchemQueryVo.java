package com.rw.quickcare.model.vo.schedule;

import lombok.Data;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName DeptSchemQueryVo
 * @description:
 * @author: LRW
 * @create: 2024-03-03 15:17
 * @Version 1.0
 **/
@Data
public class DeptSchemQueryVo {
    private String date;   //日期 yyyy-mm-dd
    private String weekOfDate; //周几
//    private Integer docCount;  // 就诊医生人数
    private Integer reservedNum;  //科室可预约总数
    private Integer availableNum;  //科室剩余预约数

}

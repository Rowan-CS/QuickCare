package com.rw.quickcare.model.vo.schedule;

import lombok.Data;

/**
 * @program: quickcare
 * @ClassName DocSchemQueryVo
 * @description:
 * @author: LRW
 * @create: 2024-03-02 22:03
 * @Version 1.0
 **/
@Data
public class DocSchemQueryVo {
    private String docName;
    private String docTitle;
    private Integer docFee;
    private String docIntro;
    private String scheName;
    private String date;
    private Integer num; //可预约数量
    private Integer residue;//剩余预约数量
    private Integer status;
}

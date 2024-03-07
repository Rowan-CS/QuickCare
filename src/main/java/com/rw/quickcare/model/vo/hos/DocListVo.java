package com.rw.quickcare.model.vo.hos;

import com.rw.quickcare.model.entity.Dept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: quickcare
 * @ClassName DocListVo
 * @description:
 * @author: LRW
 * @create: 2024-02-27 19:46
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class DocListVo {
    private Integer hosId;
    private String deptName;
    private String gender;
    private String title;
    private Integer fee;
    private String intro;
    private String status;
}

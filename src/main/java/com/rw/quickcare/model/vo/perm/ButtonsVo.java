package com.rw.quickcare.model.vo.perm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: quickcare
 * @ClassName ButtonsVo
 * @description:
 * @author: LRW
 * @create: 2024-03-07 16:29
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ButtonsVo {
       private Integer id;
       private Integer fid;
       private String resources;
       private String title;
}

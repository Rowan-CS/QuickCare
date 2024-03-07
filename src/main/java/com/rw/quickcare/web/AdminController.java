package com.rw.quickcare.web;

import com.rw.quickcare.model.entity.Admin;
import com.rw.quickcare.model.vo.admin.AdminInfoVo;
import com.rw.quickcare.service.AdminService;
import com.rw.quickcare.service.HosService;
import com.rw.quickcare.model.vo.admin.AdminLoginVo;
import com.rw.quickcare.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.rw.quickcare.model.entity.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;


/**
 * @program: quickcare
 * @ClassName AdminController
 * @description:
 * @author: LRW
 * @create: 2024-02-26 19:15
 * @Version 1.0
 **/
@Transactional
@RestController("admincontroller")
@CrossOrigin
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private HosService hosService;

    /***
     * @description: 管理员登录
     * @param: adminLoginVo
     * @return: admin
     * @author Lrw
     * @date: 2024/2/26 20:59
     */
    @PostMapping("/login")
    public ResponseEntity login(@Validated AdminLoginVo adminLoginVo, HttpServletResponse res){
        Admin admin = adminService.login(adminLoginVo.getAcc(), adminLoginVo.getPsw());
        HashMap<String, Object> result = new HashMap<>();
        String jwt = JwtUtil.createJWT(admin.getId(), admin.getAcc());
        result.put("token",jwt);
        result.put("data",admin);
        return new ResponseEntity("200","登录成功",result);
    }

    @RequestMapping("/getUserInfoByToken")
    public ResponseEntity info(HttpServletRequest request){
        String token = request.getHeader("token");
        // 验证token的合法和有效性
        if (JwtUtil.verifyJWT(token)) {
            int id = (int) JwtUtil.getInfo(token, "id");
            AdminInfoVo admin = adminService.getInfo(id);
            return new ResponseEntity("200","登录成功",admin);
        } else {
            return ResponseEntity.INVALIDTOKEN;
        }
    }
    @RequestMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request){
        // 验证token的合法和有效性
        String token = request.getHeader("token");
        if (JwtUtil.verifyJWT(token)) {
            // 移除session中的登录标记（或者redis中的登录标记）
            return new ResponseEntity("200","logout success");
        } else {
            return ResponseEntity.INVALIDTOKEN;
        }
//        String tokenValue = JwtUtil.verifyJWT(token);// success:zhangsan1
        // 获取token中的用户名
//        String username = tokenValue.replaceFirst(JwtUtil.TOKEN_SUCCESS, "");
    }

}

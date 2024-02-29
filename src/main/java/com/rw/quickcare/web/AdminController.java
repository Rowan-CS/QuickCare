package com.rw.quickcare.web;

import com.rw.quickcare.model.entity.Admin;
import com.rw.quickcare.service.AdminService;
import com.rw.quickcare.service.HosService;
import com.rw.quickcare.model.vo.admin.AdminLoginVo;
import com.rw.quickcare.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.rw.quickcare.model.entity.ResponseEntity;


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
    @RequestMapping("/login")
    public ResponseEntity login(@RequestBody AdminLoginVo adminLoginVo){
        Admin admin = adminService.login(adminLoginVo.getAcc(), adminLoginVo.getPsw());
//        String token = JwtUtil.sign(.getUsername(), "-1");
//        res.setCode(Constants.STATUS_OK);
//        res.setMessage(Constants.MESSAGE_OK);
//        res.setData(new VoToken(token));
        return new ResponseEntity("200","登录成功",admin);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestHeader("X-Token") String token){
        // 验证token的合法和有效性
        String tokenValue = JwtUtil.verity(token);// success:zhangsan1
        // 获取token中的用户名
        String username = tokenValue.replaceFirst(JwtUtil.TOKEN_SUCCESS, "");
        // 移除session中的登录标记（或者redis中的登录标记）
        return new ResponseEntity("200","logout success");
    }

    @GetMapping("/info")
    public ResponseEntity info(@RequestParam("token") String token){
        // 验证token的合法和有效性
//        String tokenValue = JwtUtil.verity(token);// success:zhangsan1
//        if(tokenValue != null && tokenValue.startsWith(JwtUtil.TOKEN_SUCCESS)) {
//            // 如果ok-》返回需要的用户信息
//            // zhangsan1
//            String username = tokenValue.replaceFirst(JwtUtil.TOKEN_SUCCESS, "");
//
//            //下面的应该是从数据库中拿到的，现在写死了
////            VoUser user = this.userService.searchUserByUserName(username);
//            VoUserInfo info = new VoUserInfo();
//            info.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
//            info.setIntroduction("测试用户");
//            info.setName(username);
//            //给用户设定角色
//            List<String> roles = Arrays.asList("tmnl");
//            info.setRoles(roles);
//            res.setData(info);
//            res.setMessage(Constants.MESSAGE_OK);
//            res.setCode(Constants.STATUS_OK);
//        }else {
//            // 否则：500
//            res.setCode(Constants.STATUS_FAIL);
//            res.setMessage(Constants.MESSAGE_FAIL);
//        }

        return new ResponseEntity("200");
    }


}

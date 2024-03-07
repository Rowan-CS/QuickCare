package com.rw.quickcare.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: quickcare
 * @ClassName JWTUtil
 * @description:
 * @author: LRW
 * @create: 2024-02-29 01:12
 * @Version 1.0
 **/
public class JwtUtil {
    /**
     * 过期时间为一天
     */
    private static final int EXPIRE_TIME = 24*60;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "jieyiappointmentplantform";

    /**
     * 生成签名,15分钟后过期
     * @param id
     * @param account
     * @return
     */
    public static  String createJWT(int id,String account){
        DateTime now = DateTime.now();
        DateTime newTime = now.offsetNew(DateField.MINUTE, EXPIRE_TIME);
        Map<String,Object> payload = new HashMap<String,Object>();
        //签发时间
        payload.put(JWTPayload.ISSUED_AT, now);
        //过期时间
        payload.put(JWTPayload.EXPIRES_AT, newTime);
        //生效时间
        payload.put(JWTPayload.NOT_BEFORE, now);
        //载荷
        payload.put("id", id);
        payload.put("account", account);
        String key = TOKEN_SECRET;
        String token = JWTUtil.createToken(payload, key.getBytes());
        return token;
    }
    //校验jwt
    public static  boolean verifyJWT(String jwt){
        try{
            cn.hutool.jwt.JWT token = JWTUtil.parseToken(jwt);//解析
            boolean verifyKey = token.setKey(TOKEN_SECRET.getBytes()).verify();
            return verifyKey;}
        catch (Exception e){
            return false;
        }
    }
    //解析jwt并获取参数
    public static Object getInfo(String jwt, String name) {
        JWT token = JWTUtil.parseToken(jwt);
        return token.getPayload(name);
    }
}

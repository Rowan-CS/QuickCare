package com.rw.quickcare.unityhandler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*** 
 * @description: 统一响应实体类（包装了 状态码、描述信息 以及返回的数据）
 * @author Lrw
 * @date: 2024/2/26 20:19
 */
@Getter
@Setter
@NoArgsConstructor
public class ResponseEntity<T> {
    private String code;//响应码
    private String msg;//描述信息
    private T data;//响应数据
    public ResponseEntity(String code , String msg){
        this(code,msg,null);
    }
    public ResponseEntity(T data){
        this.data=data;
    }
    public ResponseEntity(String code ,  T data){
        this.code=code;
        this.data=data;
    }
    public ResponseEntity(String code , String msg, T data){
        this.code=code;
        this.data=data;
        this.msg=msg;
    }
    public static final ResponseEntity FAIL = new ResponseEntity("500" ,"失败");
    public static final ResponseEntity SUCCESS = new ResponseEntity("200" ,"OK");
    public static final ResponseEntity INVALIDTOKEN = new ResponseEntity("501" ,"invalid token");//令牌失效
    public static final ResponseEntity NOACCESS = new ResponseEntity("502" ,"invalid authrity");//无权限
}

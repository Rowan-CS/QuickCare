package com.rw.quickcare.unityhandler;

import com.rw.quickcare.bizException.BizException;
import com.rw.quickcare.model.entity.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: quickcare
 * @ClassName GlobalAdvisor
 * @description:统一异常处理
 * @author: LRW
 * @create: 2024/2/26 20:21
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice(basePackages ={"com.rw.quickcare.web"})
public class GlobalAdvisor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e){
        e.printStackTrace();
        log.error("系统异常：{}", e.getMessage());
        return ResponseEntity.FAIL;
    }

//    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
//    public ResponseEntity handleException(MethodArgumentNotValidException e, HttpServletRequest request) {
//        Map<String, String> result = new HashMap<>();
//        BindingResult bindingResult = e.getBindingResult();
//        log.error("请求[ {} ] {} 的参数校验发生错误", request.getMethod(), request.getRequestURL());
//        for (ObjectError objectError : bindingResult.getAllErrors()) {
//            FieldError fieldError = (FieldError) objectError;
//            log.error("参数 {} = {} 校验错误：{}", fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());
//            result.put(fieldError.getField(), fieldError.getDefaultMessage());
//        }
//        return new ResponseEntity("400","数据校验不通过",result);
//    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    public ResponseEntity handlerBindException(BindException exception,HttpServletRequest request) {
        Map<String, String> result = new HashMap<>();
        BindingResult bindingResult = exception.getBindingResult();
        log.error("请求[ {} ] {} 的参数校验发生错误", request.getMethod(), request.getRequestURL());
        for (ObjectError objectError : bindingResult.getAllErrors()) {
            FieldError fieldError = (FieldError) objectError;
            log.error("参数 {} = {} 校验错误：{}", fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());
            result.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity("400","数据校验不通过");
    }

    @ExceptionHandler(value = BizException.class)
    public ResponseEntity myExceptionHandler(BizException e) {
        log.error("业务异常：{}", e.getMessage());
        e.printStackTrace();
        return new ResponseEntity<>(e.getCode(),e.getMessage());
    }

//    @ExceptionHandler(NatException.class)
//    public ResponseEntity hanlerNat(Exception e){
//        e.printStackTrace();
//        return new ResponseEntity("200","success","未输入医院名称");
//    }
//    @ExceptionHandler(ValidateException.class)
//    public ResponseEntity hanlerValidateException(Exception e){
//        e.printStackTrace();
//        log.debug("令牌失效，已返回");
//        return new ResponseEntity("501","fail","令牌失效");
//    }
}

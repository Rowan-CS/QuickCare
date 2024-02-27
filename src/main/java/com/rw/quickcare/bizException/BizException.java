package com.rw.quickcare.bizException;

/**
 * @program: quickcare
 * @ClassName BizException
 * @description:
 * @author: LRW
 * @create: 2024-02-27 17:02
 * @Version 1.0
 **/
public class BizException extends RuntimeException{
    private static final long serialVersionUID = -7864604160297181941L;

    private final String code;

    /***
     * @description: 指定枚举类中的错误类
     * @param: exceptionCode
     * @return:
     * @author Lrw
     * @date: 2024/2/27 17:02
     */
    public BizException(BizExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.code = exceptionCode.getCode();
    }

    public String getCode() {
        return code;
    }
}

package com.rw.quickcare.bizException;
/***
 * @description: 业务异常枚举类
 * @author Lrw
 * @date: 2024/2/27 17:03
 */
public enum BizExceptionCode{

    // 常用业务异常
    ADMIN_LOGIN_FAIL("701" ,"用户名密码错误或用户不存在。"),
    ADMIN_BLOCKED("702","帐号已冻结，请联系系统管理员。"),
    ADMIN_DELETED("703","帐号已失效，请联系系统管理员。"),
    HOS_EXISTED("502","该医院已存在"),
    DEPT_EXISTED("502","该科室名已存在"),
    DELETE_DEPT_FAIL("502","科室删除失败，该科室有关联医生或存在二级科室！"),
    DELETE_DOC_FAIL("502","医生删除失败，该医生存在排班信息，不允许删除！"),
    DELETE_SCHEDULE_FAIL("502","排班班次删除失败，排班信息已存在医生排班，不允许删除！"),
    SCHEDULE_EXISTED("502","排班班次已存在"),
    //    USER_NAME_NULL("-1","用户名不能为空，请重新输入!"),
//    USER_PASSWORD_NULL("-1","密码不能为空，请重新输入!"),
//    USER_PASSWORD_WRONG("-1","密码错误,请检查后重新输入!"),
//    PAGE_NUM_NULL("4001","页码不能为空"),
//    PAGE_SIZE_NULL("4002","页数不能为空"),
//    SEARCH_NULL("4004","搜索条件不能为空,请检查后重新输入!"),
    NO_LOGIN("3001", "用户未进行登录");

    private final String code;

    private final String message;

    BizExceptionCode(String code,String message){
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

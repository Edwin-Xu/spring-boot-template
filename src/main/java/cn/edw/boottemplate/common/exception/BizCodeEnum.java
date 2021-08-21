package cn.edw.boottemplate.common.exception;

/**
 * @author lianchen.zhang
 */

public enum BizCodeEnum {

    UNKNOW_EXCEPTION("系统未知异常"),
    VAILD_EXCEPTION("参数格式校验失败"),
    CLIENT_EXCEPTION("客户端参数异常"),
    ;


    private String message;

    BizCodeEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

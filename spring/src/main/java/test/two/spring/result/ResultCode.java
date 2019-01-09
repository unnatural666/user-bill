package test.two.spring.result;

public enum  ResultCode {

    /* 成功状态码 */
    SUCCESS(0, "成功"),
    ERROR(1, "失败"),

    /* 参数错误*/
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),


    /* 用户错误*/
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),
    USER_Register_ERROR(20006, "请填写正确的验证码"),

    /* 数据错误 */
    RESULE_DATA_NONE(30001, "数据未找到"),
    DATA_IS_WRONG(30002, "数据有误"),
    DATA_ALREADY_EXISTED(30003, "数据已存在"),

    /* 权限错误*/
    PERMISSION_NO_ACCESS(40001, "无访问权限"),

    /* 文件上传 */
    UPLOAD_ERROR(50001, "上传失败"),
    /*服务器错误*/
    SYSTEM_INNER_ERROR(70001,"服务器错误"),

    SESSION_TIME_OUT(60001, "Session超时");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

}

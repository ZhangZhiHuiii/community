package com.zzh.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"你找的问题不在了，要不要换个试试？"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2003,"用户未登录，请先登录"),
    SYS_ERROR(2004,"系统出错了"),
    TYPE_PARAM_WRONG(2004,"系统出错了"),
    COMMENT_NOT_FOUND(2005,"你回复的评论不在了，要不要换个试试"),
    COMMENT_IS_ENPTY(2006," 回复的内容不能为空"),
    READ_NOTIFICATION_FAIL(2007," 不可以读别人的信息哦"),
    NOTIFICATION_NOT_FOUND(2008,"消息找不到了");
    private String message;
    private Integer code;
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code,String message) {
        this.message = message;
        this.code = code;
    }
}

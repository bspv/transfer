package com.bazzi.core.generic;

import lombok.Getter;

@Getter
public enum TipsCodeEnum {
    CODE_0000("0000", "成功"),

    // 客户端需要处理的情况
    CODE_0001("0001", "登录过期，请重新登录"),
    CODE_0002("0002", "请求参数有误，请检查"),
    CODE_0003("0003", "验签不通过，请检查"),
    CODE_0004("0004", "缺少header信息，请检查"),

    CODE_0011("0011", "系统异常，请稍后再试"),
    CODE_0012("0012", "访问ip不合法"),
    CODE_0013("0013", "数据异常,请联系客服"),
    CODE_0014("0014", "连接超时，请稍后再试"),
    CODE_0015("0015", "不支持的请求方式"),
    CODE_0016("0016", "异常的响应状态: %s"),
    CODE_0017("0017", "JSON序列化异常"),
    CODE_0018("0018", "缺少必要的参数，请检查"),
    CODE_0019("0019", "sign不能为空"),
    CODE_0020("0020", "该接口不支持`%s`方式请求"),
    CODE_0021("0021", "不能输入特殊字符，请重新输入"),

    // Analysis模块提示信息，以1xxx来表示
    CODE_1001("1001", "不支持的短信类型(type:%s)"),


    // 后台管理模块提示信息，以2xxx来表示
    CODE_2001("2001", "权限不足，无法访问"),
    CODE_2002("2002", "请先登录"),
    CODE_2003("2003", "登录失败，请稍后再试"),
    CODE_2004("2004", "用户名或密码不正确，请重新登陆"),

    CODE_2010("2010", "记录(ID:%s)不可删除"),
    CODE_2011("2011", "ID(%s)对应记录不存在"),
    CODE_2012("2012", "记录(ID:%s)不可修改"),
    CODE_2013("2013", "记录(ID:%s)不可删除"),
    CODE_2014("2014", "记录(ID:%s)修改失败，请刷新页面再试")

    ;


    private final String code;
    private final String message;

    TipsCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMsgByCode(String code) {
        for (TipsCodeEnum tipsCodeEnum : TipsCodeEnum.values()) {
            if (tipsCodeEnum.getCode().equals(code))
                return tipsCodeEnum.getMessage();
        }
        return "";
    }

}

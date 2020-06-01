package com.example.likelxl.manager.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/31 10:36
 * @Create by external_ll@163.com
 **/
@Data
public class Result  implements Serializable {

    private String code;

    private String msg;

    private Object data;

    public static Result success(Object data){
        Result result = new Result();
        result.setCode("0");
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static Result success(String msg,Object data){
        Result result = new Result();
        result.setCode("0");
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result fail(String msg ){
        Result result = new Result();
        result.setCode("99999");
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static Result fail(String msg,Object data){
        Result result = new Result();
        result.setCode("0");
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

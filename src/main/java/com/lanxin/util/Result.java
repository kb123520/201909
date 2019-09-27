package com.lanxin.util;

import java.io.Serializable;

/**
 * Created by 张燕彭 on 2019/8/19.
 */
public class Result implements Serializable{

    private int code;
    private String msg;
    private Object data;


    public static Result failed(){
        Result result=new Result();
        result.setCode(500);
        result.setMsg("内部异常");
        return result;
    }

    public static Result failed(int code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result ok(){
        Result result=new Result();
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }
    public static Result ok(Object date){
        Result result=new Result();
        result.setCode(200);
        result.setMsg("操作成功");
        result.setData(date);
        return result;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

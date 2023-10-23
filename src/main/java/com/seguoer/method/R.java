package com.seguoer.method;


import org.springframework.http.HttpStatus;


public class R {
    private Integer code;
    private String msg;
    private Object data;
    public R() {

    }

    public R(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static R ok(Object data){
        return new R(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),data);
    }
    public static R ok(Integer state, Object data){
        return new R(state,HttpStatus.OK.getReasonPhrase(),data);
    }
    public static R ok(){
        return new R(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),"ok");
    }
    public static R notFound(){
        return new R(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.getReasonPhrase(),"NOT_FOUND");
    }
}

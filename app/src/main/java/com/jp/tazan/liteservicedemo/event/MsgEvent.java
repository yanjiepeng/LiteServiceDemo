package com.jp.tazan.liteservicedemo.event;

/**
 * Created by Administrator on 2016-09-07.
 */
public class MsgEvent {
    String msg ;

    public MsgEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

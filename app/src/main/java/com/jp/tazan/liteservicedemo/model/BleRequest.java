package com.jp.tazan.liteservicedemo.model;


import java.util.UUID;

/**
 * 抽象ble的操作请求
 * Created by Administrator on 2016-09-12.
 */

public class BleRequest {
    String serviceUUID;
    String charUUID;
    byte[] data ;

    public BleRequest(String serviceUUID, String charUUID) {
        this.serviceUUID = serviceUUID;
        this.charUUID = charUUID;
    }

    public BleRequest(String serviceUUID, String charUUID , byte[] data) {
        this.serviceUUID = serviceUUID;
        this.charUUID = charUUID;
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public String getServiceUUID() {
        return serviceUUID;
    }

    public String getCharUUID() {
        return charUUID;
    }
}

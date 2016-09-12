package com.jp.tazan.liteservicedemo.constant;

import java.util.UUID;

/**
 * Created by Administrator on 2016-09-09.
 */
public class Constant {

    //钥匙BLE // 广播的设备名是  VWkey+id
    public final static UUID UUID_KEY_SERV = UUID.fromString("0000fff0-0000-1000-8000-00805f9b34fb");
    public final static UUID UUID_KEY_DATA = UUID.fromString("0000fff1-0000-1000-8000-00805f9b34fb");
    public final static UUID UUID_KEY_NOTIFY = UUID.fromString("0000fff2-0000-1000-8000-00805f9b34fb");




    //  锁BLE 广播的设备名是  VWlock+id
    public final static UUID RX_SERVICE_UUID = UUID.fromString("6e400001-b5a3-f393-e0a9-e50e24dcca9e");
    public final static UUID RX_CHAR_UUID = UUID.fromString("6e400002-b5a3-f393-e0a9-e50e24dcca9e");   //写数据，从手机的角度
    public final static UUID TX_CHAR_UUID = UUID.fromString("6e400003-b5a3-f393-e0a9-e50e24dcca9e");   //读数据

}

package com.jp.tazan.liteservicedemo.event;

import android.bluetooth.BluetoothDevice;

import java.util.List;

/**
 * Created by Administrator on 2016-09-06.
 */
public class BleDeviceEvent {

    List<BluetoothDevice> list;

    public BleDeviceEvent(List<BluetoothDevice> list) {
        this.list = list;
    }

    public List<BluetoothDevice> getList() {
        return list;
    }

    public void setList(List<BluetoothDevice> list) {
        this.list = list;
    }
}

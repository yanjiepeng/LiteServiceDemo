package com.jp.tazan.liteservicedemo.event;

import android.bluetooth.BluetoothGattService;

import java.util.List;

/**
 * Created by Administrator on 2016-09-07.
 */
public class BleServiceEvent {

    List<BluetoothGattService> list ;

    public BleServiceEvent(List<BluetoothGattService> list) {
        this.list = list;
    }

    public List<BluetoothGattService> getList() {
        return list;
    }

    public void setList(List<BluetoothGattService> list) {
        this.list = list;
    }
}

package com.jp.tazan.liteservicedemo.event;

import android.bluetooth.BluetoothGattCharacteristic;

/**
 * Created by Administrator on 2016-09-12.
 */
public class CharacteristicEvent {
    BluetoothGattCharacteristic characteristic;

    public CharacteristicEvent(BluetoothGattCharacteristic characteristic) {
        this.characteristic = characteristic;
    }

    public BluetoothGattCharacteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(BluetoothGattCharacteristic characteristic) {
        this.characteristic = characteristic;
    }
}

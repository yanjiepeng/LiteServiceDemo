package com.jp.tazan.liteservicedemo;

import android.content.Context;

import com.litesuits.bluetooth.LiteBluetooth;

/**
 * Created by Administrator on 2016-09-06.
 */
public class LiteBtManager {



    private static LiteBluetooth sSingleton = null;
    public static synchronized LiteBluetooth getInstance(Context context) {
        if (sSingleton == null) {
            sSingleton = new LiteBluetooth(context.getApplicationContext());
        }
        return sSingleton;
    }
}

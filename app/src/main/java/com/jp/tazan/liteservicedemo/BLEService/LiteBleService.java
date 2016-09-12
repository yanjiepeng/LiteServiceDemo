package com.jp.tazan.liteservicedemo.BLEService;

import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.jp.tazan.liteservicedemo.LiteBtManager;
import com.jp.tazan.liteservicedemo.event.BleServiceEvent;
import com.jp.tazan.liteservicedemo.event.CharacteristicEvent;
import com.jp.tazan.liteservicedemo.event.MsgEvent;
import com.jp.tazan.liteservicedemo.model.BleRequest;
import com.litesuits.bluetooth.LiteBleGattCallback;
import com.litesuits.bluetooth.LiteBluetooth;
import com.litesuits.bluetooth.conn.BleCharactCallback;
import com.litesuits.bluetooth.conn.LiteBleConnector;
import com.litesuits.bluetooth.exception.BleException;

import org.greenrobot.eventbus.EventBus;

public class LiteBleService extends Service {
    private final static String TAG = LiteBleService.class.getSimpleName();
    private  LiteBluetooth liteBluetooth;
    Context context;

    private int mConnectionState = STATE_DISCONNECTED;

    private static final int STATE_DISCONNECTED = 0;
    private static final int STATE_CONNECTING = 1;
    private static final int STATE_CONNECTED = 2;


    public LiteBleService() {


    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        if (liteBluetooth == null) {
            liteBluetooth = LiteBtManager.getInstance(this);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    public class LocalBinder extends Binder {
        public LiteBleService getService() {
            return LiteBleService.this;
        }
    }

    private final IBinder mBinder = new LocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    //初始化检测
    public Boolean initialize() {
        if (liteBluetooth == null) {
            return false;
        }
        return true;
    }


    /*
     连接设备
     */

    public boolean connect(String address) {

        if ( liteBluetooth == null || address == null) {
            Log.w(TAG, "ble设备未初始化或目标地址为空");
            return false;
        }

        //连接到设备
        final BluetoothDevice device = liteBluetooth.getBluetoothAdapter().getRemoteDevice(address);
        liteBluetooth.connect(device , false , mLiteBleGattCallback );

        return false;
    }


    /**
     *
     *     连接设备回调函数
     */
    private LiteBleGattCallback mLiteBleGattCallback = new LiteBleGattCallback(){


        @Override
        public void onConnectSuccess(BluetoothGatt gatt, int i) {

            gatt.discoverServices();

        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if ( status == BluetoothGatt.GATT_SUCCESS && gatt != null) {
                EventBus.getDefault().post(new BleServiceEvent(gatt.getServices()));
            }else {
                Log.w(TAG, "onServicesDiscovered received: " + status);
            }

        }

        @Override
        public void onConnectFailure(BleException e) {
            Toast.makeText(context, "连接设备失败"+e.toString(), Toast.LENGTH_SHORT).show();
        }
    };


    /*
     读取特征值数据
     */
    public void readCharacteristicData(BleRequest request) {

        LiteBleConnector connector = liteBluetooth.newBleConnector();
        connector.withUUIDString(request.getServiceUUID() ,request.getCharUUID() , null).readCharacteristic(new BleCharactCallback() {
            @Override
            public void onSuccess(BluetoothGattCharacteristic bluetoothGattCharacteristic) {

                EventBus.getDefault().post(new CharacteristicEvent(bluetoothGattCharacteristic));
            }

            @Override
            public void onFailure(BleException e) {
                EventBus.getDefault().post(new CharacteristicEvent(null));
            }
        });

    }

    /*
     写特征值数据
    */
    public void writeCharacteristicData(BleRequest request) {

        LiteBleConnector connector = liteBluetooth.newBleConnector();
        connector.withUUIDString(request.getServiceUUID() ,request.getCharUUID() , null).writeCharacteristic(request.getData() , new BleCharactCallback() {
            @Override
            public void onSuccess(BluetoothGattCharacteristic bluetoothGattCharacteristic) {

                EventBus.getDefault().post(new CharacteristicEvent(bluetoothGattCharacteristic));
            }

            @Override
            public void onFailure(BleException e) {
                EventBus.getDefault().post(new CharacteristicEvent(null));
            }
        });

    }

}

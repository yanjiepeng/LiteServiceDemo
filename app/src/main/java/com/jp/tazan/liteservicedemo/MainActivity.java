package com.jp.tazan.liteservicedemo;

import android.app.ActivityManager;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.jp.tazan.liteservicedemo.api.HttpApi;
import com.litesuits.bluetooth.LiteBluetooth;
import com.litesuits.bluetooth.scan.PeriodScanCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_scan)
    Button btnScan;
    @BindView(R.id.lv_devices)
    ListView lvDevices;
    private boolean mScanning;
    private static int TIME_OUT_SCAN = 5000;
    LiteBluetooth liteBluetooth;
    BleDeviceAdapter mDeviceAdapter;
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //若蓝牙未开启则启动蓝牙
        if (liteBluetooth == null) {
            liteBluetooth = LiteBtManager.getInstance(this);
        }

         retrofit = new Retrofit.Builder()
                .baseUrl(HttpApi.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        lvDevices.setOnItemClickListener(new DeviceItemClickListener());

    }

    @Override
    protected void onResume() {
        super.onResume();
        liteBluetooth.enableBluetoothIfDisabled(MainActivity.this, 1);

        //初始化adapter
        mDeviceAdapter = new BleDeviceAdapter(MainActivity.this);
        lvDevices.setAdapter(mDeviceAdapter);
    }

    // **************** 业务 ****************************

    /*
        扫描设备
     */
    public void startScan() {

        mScanning = true;
        liteBluetooth.startLeScan(mPeriodScanCallback);

    }

    /*
     扫描回调
     */

    private PeriodScanCallback mPeriodScanCallback = new PeriodScanCallback(TIME_OUT_SCAN) {
        @Override
        public void onScanTimeout() {
            //dialogShow("扫描完毕 设备如下");
            Toast.makeText(MainActivity.this, "扫描完毕", Toast.LENGTH_SHORT).show();
            mScanning = false;
        }

        @Override
        public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mDeviceAdapter.addDevice(device);
                    mDeviceAdapter.notifyDataSetChanged();
                }
            });
        }
    };


    // **************** UI ******************************

    @OnClick(R.id.btn_scan)
    public void startScanBtnClick() {
        mDeviceAdapter.clear();
        startScan();

    }




    // **************** 工具 ****************************


    /**
     * 判断某个界面是否在前台
     *
     * @param context
     * @param className 某个界面名称
     */
    private boolean isForeground(Context context, String className) {
        if (context == null || TextUtils.isEmpty(className)) {
            return false;
        }

        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(1);
        if (list != null && list.size() > 0) {
            ComponentName cpn = list.get(0).topActivity;
            if (className.equals(cpn.getClassName())) {
                return true;
            }
        }

        return false;
    }

    /*
     设备列表点击监听
     */
    class DeviceItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final BluetoothDevice device = mDeviceAdapter.getDeivce(position);
            if (device == null) return;
            final Intent intent = new Intent(MainActivity.this, ControlActivity.class);
            intent.putExtra(ControlActivity.EXTRAS_DEVICE_NAME, device.getName());
            intent.putExtra(ControlActivity.EXTRAS_DEVICE_ADDRESS, device.getAddress());
            if (mScanning) {
                liteBluetooth.stopScan(mPeriodScanCallback);
                mScanning = false;
            }
            startActivity(intent);
        }
    }

}

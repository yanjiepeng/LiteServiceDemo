package com.jp.tazan.liteservicedemo;

import android.bluetooth.BluetoothGattService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.jp.tazan.liteservicedemo.BLEService.LiteBleService;
import com.jp.tazan.liteservicedemo.event.BleServiceEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ControlActivity extends AppCompatActivity {

    private final static String TAG = ControlActivity.class.getSimpleName();
    public static final String EXTRAS_DEVICE_NAME = "DEVICE_NAME";
    public static final String EXTRAS_DEVICE_ADDRESS = "DEVICE_ADDRESS";
    @BindView(R.id.device_address)
    TextView deviceAddress;
    @BindView(R.id.connection_state)
    TextView connectionState;
    @BindView(R.id.data_value)
    TextView dataValue;
    @BindView(R.id.gatt_services_list)
    ExpandableListView gattServicesList;

    private String mDeviceName;
    private String mDeviceAddress;
    private LiteBleService mBluetoothLeService;
    //定义父列表项List数据集合
    List<Map<String, String>> group = new ArrayList<Map<String, String>>();
    //定义子列表项List数据集合
    List<List<Map<String, String>>> childs = new ArrayList<List<Map<String, String>>>();
    private SimpleExpandableListAdapter mExpandableAdapter;

    private final ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBluetoothLeService = ((LiteBleService.LocalBinder)service).getService();
            if (!mBluetoothLeService.initialize()) {
                Log.e(TAG, "Unable to initialize Bluetooth");
                finish();
            }
            //自动连接目标设备服务
            mBluetoothLeService.connect(mDeviceAddress);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBluetoothLeService = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);


        final Intent intent = getIntent();
        mDeviceName = intent.getStringExtra(EXTRAS_DEVICE_NAME);
        mDeviceAddress = intent.getStringExtra(EXTRAS_DEVICE_ADDRESS);
        deviceAddress.setText(mDeviceAddress);
        gattServicesList.setOnChildClickListener(serviceListClickListener);

        Intent gattServiceIntent = new Intent(this, LiteBleService.class);
        bindService(gattServiceIntent, mServiceConnection, BIND_AUTO_CREATE);

        /**
         * 第一个参数  应用程序接口 this
         * 第二个父列List<?extends Map<String,Object>>集合 为父列提供数据
         * 第三个参数  父列显示的组件资源文件
         * 第四个参数  键值列表 父列Map字典的key
         * 第五个要显示的父列组件id
         * 第六个 子列的显示资源文件
         * 第七个参数 键值列表的子列Map字典的key
         * 第八个要显示子列的组件id
         */
         mExpandableAdapter = new SimpleExpandableListAdapter(
                this,
                group,
                android.R.layout.simple_expandable_list_item_2,
                new String[] { "serviceUUID" },
                new int[] { android.R.id.text1 },
                childs,
                android.R.layout.simple_expandable_list_item_2,
                new String[] { "chaUUID" },
                new int[] {android.R.id.text1 });
        gattServicesList .setAdapter(mExpandableAdapter);
        
    }
    //*******************************UI*************************************************************
    //更新任务列表
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateServiceList(BleServiceEvent event) {

        List<BluetoothGattService> services = new ArrayList<>();

        group.clear();
        childs.clear();

        if (event.getList() != null && event.getList().size() !=0 ) {
            services = event.getList();
        }
        for (int i = 0; i < services.size() ; i++) {
            //提供父列表内容
            Map<String, String> map = new HashMap<String, String>();
            map.put("serviceUUID" , services.get(i).getUuid().toString());
            group.add(map);

            //提供当前父列表的子项
            List<Map<String, String>> child = new ArrayList<Map<String, String>>();
            for ( int j = 0 ;j  < services.get(i).getCharacteristics().size() ; j ++) {
                Map<String , String> cha = new HashMap<String, String>();
                cha.put("chaUUID",services.get(i).getCharacteristics().get(j).getUuid().toString());
                child.add(cha);
            }
            childs.add(child);
        }
        mExpandableAdapter.notifyDataSetChanged();
        for (int i = 0; i < mExpandableAdapter.getGroupCount() ; i++) {
            gattServicesList.expandGroup(i);
            gattServicesList.collapseGroup(i);
        }

    }

    private final ExpandableListView.OnChildClickListener serviceListClickListener = new ExpandableListView.OnChildClickListener() {
        @Override
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {



            return false;
        }
    };
}

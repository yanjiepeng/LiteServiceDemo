package com.jp.tazan.liteservicedemo;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-09-05.
 */
public class BleDeviceAdapter extends BaseAdapter {


    Context mContext;
    List<BluetoothDevice> deviceList;
    LayoutInflater mInflater;


    public BleDeviceAdapter(Context context) {

        this.mContext = context;
        deviceList = new ArrayList<BluetoothDevice>();
        mInflater = LayoutInflater.from(context);

    }

    public void addDevice(BluetoothDevice device) {
        if (!deviceList.contains(device)) {
            deviceList.add(device);
        }
    }

    public BluetoothDevice getDeivce(int pos) {
        return deviceList.get(pos);
    }

    @Override
    public int getCount() {
        return deviceList.size();
    }

    public void clear() {
        deviceList.clear();
    }

    @Override
    public Object getItem(int position) {
        return deviceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.device_list_item
                    , null);
            TextView tv_deviceName = (TextView) view.findViewById(R.id.tv_deviceName);
            TextView tv_deviceAddress = (TextView) view.findViewById(R.id.tv_deviceAdd);

            ViewHoler viewHoler = new ViewHoler();
            viewHoler.tv_deviceName = tv_deviceName;
            viewHoler.tv_deviceAddress = tv_deviceAddress;

            view.setTag(viewHoler);
        } else {
            view = convertView;
        }
        ViewHoler viewHoler = (ViewHoler) view.getTag();

        //进行数据适配
        viewHoler.tv_deviceAddress.setText(deviceList.get(position).getAddress());
        viewHoler.tv_deviceName.setText(deviceList.get(position).getName());
        return view;
    }


    class ViewHoler {
        TextView tv_deviceName;
        TextView tv_deviceAddress;
    }
}

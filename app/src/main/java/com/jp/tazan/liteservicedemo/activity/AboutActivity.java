package com.jp.tazan.liteservicedemo.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.PhoneUtils;
import com.jp.tazan.liteservicedemo.R;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout rl_help, rl_phone , rl_website ;
    TextView tv_build_ver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        rl_help = (RelativeLayout) findViewById(R.id.rl_help);
        rl_phone = (RelativeLayout) findViewById(R.id.rl_phone);
        rl_website = (RelativeLayout) findViewById(R.id.rl_website);
        tv_build_ver = (TextView) findViewById(R.id.versionbuild);

        rl_help.setOnClickListener(this);
        rl_phone.setOnClickListener(this);
        rl_website.setOnClickListener(this);
        setVersionBuild();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.rl_help:
                break;
            case R.id.rl_website:
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://www.cdtazan.com/");
                intent.setData(content_url);
                startActivity(intent);
                break;
            case R.id.rl_phone:
                PhoneUtils.call(AboutActivity.this , "4008222325");
                break;
        }

    }


    private void setVersionBuild() {
        String versionBuild = "Version: ";

        try {
            versionBuild += getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            tv_build_ver.setText(versionBuild+" Build: " + "14.10.07");
        }
        catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}

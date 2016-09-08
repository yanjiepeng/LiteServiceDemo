package com.jp.tazan.liteservicedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jp.tazan.liteservicedemo.fragment.TestFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabActivity extends AppCompatActivity {

    @BindView(R.id.main_tab)
    TabLayout mainTab;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ButterKnife.bind(this);
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager() , this);
        viewPager.setAdapter(myAdapter);
        mainTab.setupWithViewPager(viewPager);
    }

    class MyAdapter extends FragmentPagerAdapter {

        private String[] titles=new String[]{"Tab1","Tab2","Tab3","Tab4"};
        private Context mContext;
        public MyAdapter(FragmentManager fm , Context mContext) {
            super(fm);
            this.mContext = mContext;
        }

        @Override
        public Fragment getItem(int position) {
            return new TestFragment();
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}

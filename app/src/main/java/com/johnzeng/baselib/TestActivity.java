package com.johnzeng.baselib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.johnzeng.appbaselib.ui.BaseActivity;

/** test
 * Created by zengjiang2 on 2016/12/12.
 */

public class TestActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test_toolbar);
        initFragment();
    }

    private void  initFragment(){
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.app_root,new TestFrament());
        ft.commit();
        showDialog();
    }

    @Override
    protected boolean hadContentLoadView() {
        return false;
    }

    @Override
    protected boolean hadErrorView() {
        return super.hadErrorView();
    }
}

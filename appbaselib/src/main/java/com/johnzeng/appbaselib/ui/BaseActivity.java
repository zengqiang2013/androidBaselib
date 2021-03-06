package com.johnzeng.appbaselib.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.johnzeng.utils.DialogHelper;
import com.johnzeng.utils.TUtil;
import com.johnzeng.view.BaseLayoutPage;

/**activity基类
 * Created by zengjiang2 on 2016/12/7.
 */

public class BaseActivity<M> extends AppCompatActivity {
    private BaseLayoutPage mBaseLayout;
    protected M mModel;

    private Dialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initModel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissDialog();
    }

    protected void showDialog(){
        mDialog = new DialogHelper().setActivity(this).show();
    }

    protected void dismissDialog(){
        if (mDialog != null && mDialog.isShowing()){
            mDialog.dismiss();
            mDialog = null;
        }
    }


    private void initModel() {
        mModel = TUtil.getT(this, 0);
    }

    @Override
    public final void setContentView(@LayoutRes int layoutResID) {
        addBaseLayout(LayoutInflater.from(this).inflate(layoutResID, null));
    }

    protected final void addBaseLayout(View inflate) {
        BaseLayoutPage.Builder builder = new BaseLayoutPage.Builder().buildContent(inflate);
        if (hadToolBar()) {
            builder.buildTitleBar();
        }
        if (hadContentLoadView()) {
            builder.buildLoadView();
        }
        if (hadErrorView()) {
            builder.buildErrorView();
        }
        mBaseLayout = new BaseLayoutPage(this, builder);
        super.setContentView(mBaseLayout);
    }

    @Override
    public final void setContentView(View view) {
        addBaseLayout(view);
    }

    @Override
    public final void setContentView(View view, ViewGroup.LayoutParams params) {
        addBaseLayout(view);
    }

    @SuppressWarnings("unused")
    public void showContent() {
        mBaseLayout.showContent();
    }

    @SuppressWarnings("unused")
    public void showError() {
        mBaseLayout.showError();
    }

    @SuppressWarnings("unused")
    public void showLoadingView() {
        mBaseLayout.showLoadingView();
    }

    protected boolean hadToolBar() {
        return true;
    }

    protected boolean hadContentLoadView() {
        return false;
    }

    protected boolean hadErrorView() {
        return false;
    }

}

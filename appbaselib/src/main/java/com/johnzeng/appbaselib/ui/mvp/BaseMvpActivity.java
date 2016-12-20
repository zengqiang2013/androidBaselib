package com.johnzeng.appbaselib.ui.mvp;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.johnzeng.utils.TUtil;
import com.johnzeng.view.BaseLayoutPage;

/**mvp模式activity基类
 * Created by zengjiang2 on 2016/12/7.
 */

public class BaseMvpActivity<M,P> extends AppCompatActivity {
    protected M mModel;
    protected P mPresenter;
    private BaseLayoutPage mBaseLayout;

    private void initModel(){
        mModel = TUtil.getT(this,0);
        mPresenter = TUtil.getT(this,1);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initModel();
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

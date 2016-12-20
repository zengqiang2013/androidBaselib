package com.johnzeng.appbaselib.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.johnzeng.utils.TUtil;
import com.johnzeng.view.BaseLayoutPage;

/** 基类fragment
 * Created by zengjiang2 on 2016/12/9.
 */
@SuppressWarnings("unused")
public abstract class BaseFragment<M> extends Fragment {
    protected M mModel;
    private BaseLayoutPage mBaseLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initModel();
    }

    private void initModel(){
        mModel = TUtil.getT(this,0);
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return addBaseLayout(inflater.inflate(getLayoutResId(),null));
    }

    protected abstract int getLayoutResId();

    protected final View addBaseLayout(View inflate) {
        BaseLayoutPage.Builder builder = new BaseLayoutPage.Builder().buildContent(inflate);
        if (hadToolBar()) {
            builder.buildTitleBar();
        }
        if (hadContentLoadView()){
            builder.buildLoadView();
        }
        if (hadErrorView()){
            builder.buildErrorView();
        }
        mBaseLayout = new BaseLayoutPage(getContext(),builder);
        return mBaseLayout;
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
        return false;
    }

    protected boolean hadContentLoadView() {
        return false;
    }

    protected boolean hadErrorView() {
        return false;
    }



}

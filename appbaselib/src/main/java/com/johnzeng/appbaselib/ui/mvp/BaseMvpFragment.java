package com.johnzeng.appbaselib.ui.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.johnzeng.utils.TUtil;
import com.johnzeng.view.BaseLayoutPage;

/**
 * mvp模式基类fragment
 * Created by zengqiang on 2016/12/9.
 */
@SuppressWarnings("unused")
public abstract class BaseMvpFragment<M, P> extends Fragment {
    protected M mModel;
    protected P mPresenter;
    private BaseLayoutPage mBaseLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return addBaseLayout(inflater.inflate(getLayoutResId(), null));
    }

    private void initModel() {
        mModel = TUtil.getT(this, 0);
        mPresenter = TUtil.getT(this, 1);
    }

    protected abstract int getLayoutResId();

    protected final View addBaseLayout(View inflate) {
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
        mBaseLayout = new BaseLayoutPage(getContext(), builder);
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

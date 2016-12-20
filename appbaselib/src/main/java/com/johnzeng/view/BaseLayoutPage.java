package com.johnzeng.view;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.johnzeng.appbaselib.R;

/**
 * Created by zengjiang2 on 2016/12/12.
 */

public final class BaseLayoutPage extends RelativeLayout {
    private final LayoutInflater mInflater;
    private Toolbar mToolBar;
    private View mContentView;
    private View mErrorView;
    private View mLoadingView;
    private Builder mBuilder;

    public BaseLayoutPage(Context context, Builder builder) {
        super(context);
        mInflater = LayoutInflater.from(context);
        mContentView = builder.mContentView;
        mBuilder = builder;
        init();
    }

    public Toolbar getToolbar() {
        return mToolBar;
    }

    private void init() {
        if (mBuilder.mhadToolBar) {
            mToolBar = (Toolbar) mInflater.inflate(R.layout.view_toolbar_layout, null);
            int height = (int) getContext().getResources().getDimension(R.dimen.title_height);
            LayoutParams titleParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                    height);
            addView(mToolBar, titleParams);
        }

        if (mContentView != null) {
            LayoutParams params = new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT);
            params.addRule(BELOW, R.id.toolbar);
            addView(mContentView, params);
        }
        if (mBuilder.mHadLoadView){
            mLoadingView = mInflater.inflate(R.layout.view_loading,null);
            LayoutParams params = new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT);
            params.addRule(BELOW, R.id.toolbar);
            mContentView.setVisibility(GONE);
            addView(mLoadingView, params);
        }
        if (mBuilder.mHadErrorView){
            mErrorView = mInflater.inflate(R.layout.view_error,null);
            LayoutParams params = new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT);
            params.addRule(BELOW, R.id.toolbar);
            mErrorView.setVisibility(GONE);
           addView(mErrorView, params);
        }
        //添加阴影效果
        View view = new View(getContext());
        view.setBackgroundResource(R.color.title_shadow);
        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                4);
        params.addRule(BELOW, R.id.toolbar);
        addView(view, params);
    }
    public void showContent(){
        mContentView.setVisibility(VISIBLE);
        mLoadingView.setVisibility(GONE);
        mErrorView.setVisibility(GONE);
    }

    public void showError(){
        mContentView.setVisibility(GONE);
        mLoadingView.setVisibility(GONE);
        mErrorView.setVisibility(VISIBLE);
    }

    public void showLoadingView(){
        mContentView.setVisibility(GONE);
        mLoadingView.setVisibility(VISIBLE);
        mErrorView.setVisibility(GONE);
    }


    public static class Builder {
        boolean mhadToolBar;
        View mContentView;
        boolean mHadLoadView;
        boolean mHadErrorView;

        public Builder() {

        }

        public Builder buildTitleBar() {
            mhadToolBar = true;
            return this;
        }

        public Builder buildContent(View view) {
            mContentView = view;
            return this;
        }

        public Builder buildLoadView() {
            mHadLoadView = true;
            return this;
        }

        public Builder buildErrorView() {
            mHadErrorView = true;
            return this;
        }
//        public View build() {
//            //BaseLayoutPage view = new BaseLayoutPage(mContext, mToolBar, mContentView);
//            return view;
//        }


    }


}

package com.johnzeng.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;

import com.johnzeng.appbaselib.R;

/**
 * Created by zengjiang2 on 2016/12/13.
 */

public class DialogHelper {
    private Activity mActivity;

    public DialogHelper setActivity(Activity ac){
        mActivity = ac;
        return this;
    }
    public Dialog show() {
        if (mActivity == null){
            throw new RuntimeException("activity is null");
        }
        View view = View.inflate(mActivity, R.layout.dlg_loading, null);
        Dialog dialog = new Dialog(mActivity, R.style.base_dialog){
            @Override
            public void dismiss() {
                super.dismiss();
            }
        };
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setContentView(view);
        dialog.show();
        return dialog;
    }

}

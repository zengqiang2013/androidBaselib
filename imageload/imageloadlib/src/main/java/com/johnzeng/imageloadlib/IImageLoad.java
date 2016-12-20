package com.johnzeng.imageloadlib;

import android.content.Context;
import android.widget.ImageView;

/** interface
 * Created by zengqang on 2016/12/7.
 */

public interface IImageLoad {
    void LoadImage(Context context, ImageView view,String url);
}

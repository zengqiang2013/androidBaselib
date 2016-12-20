package com.johnzeng.baselib;

import android.app.Application;
import android.content.res.Configuration;

import com.johnzeng.logs.Logger;

/**App
 * Created by zengjiang2 on 2016/12/9.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.LOG_LEVEL = 5;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}

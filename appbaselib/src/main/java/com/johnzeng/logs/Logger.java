package com.johnzeng.logs;

import android.util.Log;

/**日志文件基类
 * Created by zengjiang2 on 2016/12/9.
 */
@SuppressWarnings("unused")
public class Logger {
    //日志级别，越大，打印类型越多。
    public static int LOG_LEVEL = 6;

    private static String getTag() {
        StackTraceElement thisMethodStack = Thread.currentThread().getStackTrace()[1];
        return thisMethodStack.getFileName();
    }
    private static String getLogPrefix() {
        StackTraceElement thisMethodStack = Thread.currentThread().getStackTrace()[1];
        return "Line:" + thisMethodStack.getLineNumber()+"--";
    }

    public final void v(String text) {
        if (LOG_LEVEL > 5)
            Log.v(getTag(), getLogPrefix()+text);
    }

    public final void v(Throwable e) {
        if (LOG_LEVEL > 5)
            Log.v(getTag(), getLogPrefix(), e);
    }

    public final void d(String text) {
        if (LOG_LEVEL > 4) {
            Log.d(getTag(), getLogPrefix()+text);
        }
    }

    public final void d(Throwable e) {
        if (LOG_LEVEL > 4)
            Log.d(getTag(), getLogPrefix(), e);
    }

    public final void i(String text) {
        if (LOG_LEVEL > 3) {
            Log.d(getTag(), getLogPrefix()+text);
        }
    }

    public final void i(Throwable e) {
        if (LOG_LEVEL > 3)
            Log.d(getTag(), getLogPrefix(), e);
    }


    public final void w(String text) {
        if (LOG_LEVEL > 2)
            Log.w(getTag(), getLogPrefix()+text);
    }

    public final void w(Throwable e) {
        if (LOG_LEVEL > 2)
            Log.d(getTag(), getLogPrefix(), e);
    }

    public final void e(String text) {
        if (LOG_LEVEL > 2)
            Log.e(getTag(), getLogPrefix()+text);

    }

    public final void e(Throwable e) {
        if (LOG_LEVEL > 2)
            Log.e(getTag(), getLogPrefix(), e);
    }


}

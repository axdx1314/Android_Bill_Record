package com.ldm.cashbook;

import android.app.Application;

import com.ldm.cashbook.database.GreenDaoManager;

/**
 * description： 作者：ldm 时间：20172017/3/1 11:32 邮箱：1786911211@qq.com
 */
public class GlobalApp extends Application {
    private static GlobalApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        GreenDaoManager.getInstance();
    }

    public static GlobalApp getInstance() {
        return instance;
    }
}

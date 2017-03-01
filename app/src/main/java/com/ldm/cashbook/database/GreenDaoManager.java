package com.ldm.cashbook.database;


import android.content.Context;

import com.ldm.cashbook.DaoMaster;
import com.ldm.cashbook.DaoSession;
import com.ldm.cashbook.GlobalApp;

/**
 * @author ldm
 * @description GreenDao数据库管理操作类
 * GreenDao:https://github.com/greenrobot/greenDAO
 * @time 2017/3/1 11:36
 */
public class GreenDaoManager {
    private Context mContext;
    private static GreenDaoManager instance;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private GreenDaoManager() {
        //创建数据库
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(GlobalApp.getInstance(), "cash.db");
        //初始化DaoMaster
        mDaoMaster = new DaoMaster(openHelper.getWritableDatabase());
        //初始化DaoSession
        mDaoSession = mDaoMaster.newSession();
    }

    public static GreenDaoManager getInstance() {
        if (null == instance) {
            synchronized (GreenDaoManager.class) {
                if (null == instance) {
                    instance = new GreenDaoManager();
                }
            }
        }
        return instance;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}

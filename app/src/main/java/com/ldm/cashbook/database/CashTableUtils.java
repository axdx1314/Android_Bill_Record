package com.ldm.cashbook.database;

import com.ldm.cashbook.CashModelDao;
import com.ldm.cashbook.model.CashModel;

import java.util.List;

/**
 * @author ldm
 * @description 帐单记录表操作工具类
 * @time 2017/3/1 11:36
 */
public class CashTableUtils {
    private static CashTableUtils instance;

    private CashTableUtils() {

    }

    public static CashTableUtils getInstance() {
        if (null == instance) {
            instance = new CashTableUtils();
        }
        return instance;
    }

    //插入一条记录
    public void insertCashData(CashModel cash) {
        CashModelDao dao = GreenDaoManager.getInstance().getNewSession().getCashModelDao();
        dao.insert(cash);
    }

    //查询所有记录
    public List<CashModel> queryAllCashes() {
        CashModelDao dao = GreenDaoManager.getInstance().getNewSession().getCashModelDao();
        //查询所有的数据
        return dao.loadAll();
    }
}

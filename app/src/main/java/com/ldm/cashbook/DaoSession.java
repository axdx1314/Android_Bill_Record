package com.ldm.cashbook;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.ldm.cashbook.model.CashModel;

import com.ldm.cashbook.CashModelDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig cashModelDaoConfig;

    private final CashModelDao cashModelDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        cashModelDaoConfig = daoConfigMap.get(CashModelDao.class).clone();
        cashModelDaoConfig.initIdentityScope(type);

        cashModelDao = new CashModelDao(cashModelDaoConfig, this);

        registerDao(CashModel.class, cashModelDao);
    }
    
    public void clear() {
        cashModelDaoConfig.clearIdentityScope();
    }

    public CashModelDao getCashModelDao() {
        return cashModelDao;
    }

}

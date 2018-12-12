package com.example.ppt.temp_ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

public class DataBaseManager {
    private DaoSession mDaoSession = null;
    private UserProfileDao mDao = null;

    public static DataBaseManager getInstance() {
        return Holder.DATA_BASE_MANAGER;
    }

    private static final class Holder {
        private static final DataBaseManager DATA_BASE_MANAGER = new DataBaseManager();
    }

    private DataBaseManager() {
    }

    public DataBaseManager init(Context context) {
        initDao(context);
        return this;
    }

    private void initDao(Context context) {
        //表明
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context, "fast_ec.db");
        final Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        mDao = mDaoSession.getUserProfileDao();
    }

    public final UserProfileDao getDao() {
        return mDao;
    }
}

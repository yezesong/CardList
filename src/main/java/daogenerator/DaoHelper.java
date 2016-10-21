package daogenerator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by yzs on 2016/8/23.
 */

public final class DaoHelper {
    private volatile static DaoHelper mDaoHelper;
    private static SQLiteDatabase mDatabase;
    private static DaoSession mDaoSession;
    private static DaoMaster mDaoMaster;

    private final CardItemDao mCardItemDao;

    public static void initDatabase(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "cardtest.db", null);
        mDatabase = helper.getWritableDatabase();
        mDaoMaster = new DaoMaster(mDatabase);
        mDaoSession = mDaoMaster.newSession();
    }

    private DaoHelper() {
        mCardItemDao = mDaoSession.getCardItemDao();
    }

    public static DaoHelper getDaoHelper() {
        if (mDaoHelper == null) {
            mDaoHelper = new DaoHelper();
        }
        return mDaoHelper;
    }


}

package info.prasans.mchoice.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "mchoice.db";
    private static final int DATABASE_VERSION = 1;
    private final String LOG_NAME = getClass().getName();

    private Dao<TestInfo, Integer> testInfo;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, TestInfo.class);
        } catch (SQLException e) {
            Log.e(LOG_NAME, "Could not create new table for Thing", e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, TestInfo.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            Log.e(LOG_NAME, "Could not upgrade the table for Thing", e);
        }
    }

    public Dao<TestInfo, Integer> getTestInfoDao() throws SQLException {
        if (testInfo == null) {
            testInfo = getDao(TestInfo.class);
        }
        return testInfo;
    }
}

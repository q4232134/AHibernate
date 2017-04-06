package com.jiaozhu.demo;

import android.content.Context;

import com.jiaozhu.ahibernate.util.DaoManager;
import com.jiaozhu.ahibernate.util.MyDBHelper;
import com.jiaozhu.ahibernate.util.TableHelper;

/**
 * Created by jiaozhu on 16/9/18.
 */
public class DBHelper extends MyDBHelper {

    public DBHelper(Context context) {
        super(context, "11", null, 1);
    }

    public void onUpgrade() {
        TableHelper.dropTable(this.getWritableDatabase(),
                DaoManager.getInstance().getTableNameList().toArray(new String[0]));
        TableHelper.createTable(this.getWritableDatabase(),
                DaoManager.getInstance().getTableNameList().toArray(new String[0]));
    }
}

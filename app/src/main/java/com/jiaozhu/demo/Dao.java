package com.jiaozhu.demo;

import android.database.sqlite.SQLiteOpenHelper;

import com.jiaozhu.ahibernate.dao.impl.BaseDaoImpl;
import com.jiaozhu.ahibernate.util.BackgroundExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhu on 16/9/18.
 */
public class Dao extends BaseDaoImpl<Model> {
    protected Dao(SQLiteOpenHelper dbHelper) {
        super(dbHelper);
    }

    public List<Model> getModel() {
        BackgroundExecutor.runInBackground(new BackgroundExecutor.Task() {
            @Override
            public void execute() {

            }

            @Override
            public void onBackgroundFinished() {

            }
        });
        final List<Model> list = new ArrayList<>();

        System.out.println(get(1));
        return list;
    }

}

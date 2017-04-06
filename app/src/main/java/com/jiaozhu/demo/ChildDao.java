package com.jiaozhu.demo;

import android.database.sqlite.SQLiteOpenHelper;

import com.jiaozhu.ahibernate.dao.impl.BaseDaoImpl;

/**
 * Created by jiaozhu on 16/9/18.
 */
public class ChildDao extends BaseDaoImpl<Child> {
    protected ChildDao(SQLiteOpenHelper dbHelper) {
        super(dbHelper);
    }

}

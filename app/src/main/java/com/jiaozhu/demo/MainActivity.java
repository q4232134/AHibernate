package com.jiaozhu.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jiaozhu.ahibernate.util.DaoManager;

import java.util.Date;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btn3, btn4;
    Dao dao;
    DaoManager manager;
    DBHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbh = new DBHelper(this);
        manager = DaoManager.init(dbh);
        manager.registerDao(Dao.class, ChildDao.class);
        dao = (Dao) manager.getDao(Model.class);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btn1) {
            Model m = new Model();
            m.double1 = 3.0;
            m.aBoolean = true;
            m.date1 = new Date();
            dao.replace(m);

            Child child = new Child();
            child.string1 = m.id + "";
            child.integer1 = 3;
            child.aBoolean = false;
            manager.getDao(Child.class).insert(child);
        } else if (v == btn2) {
            Model model = dao.get(1);
            System.out.println(model);
            System.out.println(manager.getDao(Child.class).findCombines(model));
        } else if (v == btn3) {
            dao.getModel();
        } else if (v == btn4) {
            dbh.onUpgrade();
        }
    }
}

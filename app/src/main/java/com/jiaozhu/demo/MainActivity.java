package com.jiaozhu.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jiaozhu.ahibernate.util.DaoManager;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


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
        manager.registerDao(Dao.class, ChildDao.class, Model.class);
        dao = (Dao) manager.getDaoByTable(Model.class);
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
            m.string1 = "123";
            m.aBoolean = true;
            m.date1 = new Date();
            dao.replace(m);
            System.out.println(dao.get(1));
        } else if (v == btn2) {
            Model model = dao.get(1);
            model.string1 = "311";
            model.aBoolean = false;
            model.double1 = 66;
            Set s = new HashSet();
            s.add("double1");
            dao.update(model, s);
            System.out.println(model);
        } else if (v == btn3) {
            System.out.println(dao.get(1));
        } else if (v == btn4) {
        }
    }
}

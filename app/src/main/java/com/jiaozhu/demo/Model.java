package com.jiaozhu.demo;

import com.jiaozhu.ahibernate.annotation.Column;
import com.jiaozhu.ahibernate.annotation.Id;
import com.jiaozhu.ahibernate.annotation.Table;

import java.util.Date;

/**
 * Created by jiaozhu on 16/9/18.
 */
@Table
public class Model {
    @Id
    @Column
    int id = 1;
    @Column
    String string1;
    @Column
    Integer integer1;
    @Column
    double double1;
    @Column
    Date date1;
    @Column
    Boolean aBoolean;

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", string1='" + string1 + '\'' +
                ", integer1=" + integer1 +
                ", double1=" + double1 +
                ", date1=" + date1 +
                ", aBoolean=" + aBoolean +
                '}';
    }
}

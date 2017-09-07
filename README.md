# AHibernate
无复杂要求的超轻量级个人ORM框架
次框架根据 lk_blog（ 博客:http://blog.csdn.net/lk_blog ）的AHibernate框架修改而成，主要解决了一些原框架遗留下来的问题。

如何加入项目：

    buildscript {
        repositories {
            jcenter()
        }
        dependencies {
            compile 'com.jiaozhu.android:ahibernate:xxx'
        }
    }

xxx为最新版本，暂时最新版本为0.9.2

主要功能：

1.增加事物操作：

    BaseDaoImpl.runInTransaction(Task task)

2.增加表关联使用@Combine标记

3.自动识别字段类型，增加默认字段名，优化反射操作，集成dao管理，所有的数据结构、表结构和dao都能在DaoManager里面获取到。

4.增加日志管理

5.增加批量操作进度

start：

每个表必须包含model类与dao类，dao类必须继承BaseDaoImpl。

创建继承与MyDBHelper的Helper类。

初始化DaoManager：

    DaoManager.init(dbh)

注册dao：

    manager.registerDao(Dao.class）

之后就可以进行使用了。

获取dao：

        daoManager.getDao(String tableName);
        
        daoManager.getDao(Object Model.class);

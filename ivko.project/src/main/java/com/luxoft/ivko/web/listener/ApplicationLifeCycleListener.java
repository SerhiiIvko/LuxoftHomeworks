package com.luxoft.ivko.web.listener;

import com.luxoft.ivko.dao.impl.DBManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationLifeCycleListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DBManager.initialize(DBManager.getH2DataSource());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBManager.stopDb();
    }
}

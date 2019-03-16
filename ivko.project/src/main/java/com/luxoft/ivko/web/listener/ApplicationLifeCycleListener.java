package com.luxoft.ivko.web.listener;

import com.luxoft.ivko.appProperties.PropertiesManager;
import com.luxoft.ivko.dao.impl.DBManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Properties;

public class ApplicationLifeCycleListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        Properties applicationProperties = PropertiesManager.getInstance().getApplicationProperties();
        DBManager.initialize(DBManager.getH2DataSource());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBManager.stopDb();
    }
}

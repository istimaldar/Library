package com.istimaldar.dao.connectionpool;

import java.io.BufferedReader;
import java.io.File;
import java.util.Properties;

/**
 * Created by istimaldar
 */
public class MySqlPropertyManager {

    private final String PATH = "db.properties";
    private final String PREFIX = this.getClass().getResource("/").getPath();

    private Properties properties = new Properties();
    private BufferedReader reader = null;
    private File file = new File(PREFIX + PATH);

    private static class MySqlPropertyManagerSingletonHolder {
        static final MySqlPropertyManager INSTANCE = new MySqlPropertyManager();
    }

    public static MySqlPropertyManager getInstance() {
        return MySqlPropertyManagerSingletonHolder.INSTANCE;
    }
}

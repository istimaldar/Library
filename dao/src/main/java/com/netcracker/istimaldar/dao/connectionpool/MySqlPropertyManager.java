package com.netcracker.istimaldar.dao.connectionpool;

import java.io.*;
import java.util.Properties;

/**
 * Created by istimaldar
 */
class MySqlPropertyManager {

    private final String PATH = "db.properties";
    private final String PREFIX = this.getClass().getResource("/").getPath();

    private Properties properties = new Properties();
    private BufferedReader reader = null;
    {
        System.out.println(PREFIX + PATH);
    }
    private File file = new File(PREFIX + PATH);

    private static class MySqlPropertyManagerSingletonHolder {
        static final MySqlPropertyManager INSTANCE = new MySqlPropertyManager();
    }

    static MySqlPropertyManager getInstance() {
        return MySqlPropertyManagerSingletonHolder.INSTANCE;
    }

    private MySqlPropertyManager() {
        try {
            reader = new BufferedReader(new FileReader(file));
            properties.load(reader);
        } catch (FileNotFoundException e) {
            System.err.println("File db.properties not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getValue(String key) {
        return properties.getProperty(key);
    }
}

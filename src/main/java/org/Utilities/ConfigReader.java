package org.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    private Properties prop;

    /**
     * this method is used to initialize properties object which will read the data from config file.
     * @return Properties object
     */
    public Properties initialize_properties() {
        prop = new Properties();
        FileInputStream fip = null;
        try {
            fip = new FileInputStream("src\\test\\resources\\Configs\\config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(fip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
}

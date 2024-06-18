package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.Factory.DriverFactories;
import org.Utilities.ConfigReader;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ImpHooks {
    public WebDriver driver;
    private DriverFactories driver_Factories;
    private ConfigReader config_Reader;

    private Properties prop;

    /**
     * This method is used to read the property from config file.
     */

    @Before(order = 0)
    public void get_property() {
        prop = new Properties();
        config_Reader = new ConfigReader();
        prop = config_Reader.initialize_properties();

    }

    /**
     * This method is used to launch the browser.
     */

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driver_Factories = new DriverFactories();
        driver = driver_Factories.initialize_Driver(browserName);

    }

    /**
     * This method is used to quit the browser after execution of a scenario.
     */
    @After(order = 0)
    public void tearDown() {
        driver.quit();
    }
}

package org.Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactories {

    public WebDriver driver;
    private static  ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize driver based on browser type.
     * @param browserName
     * @return
     */
    public WebDriver initialize_Driver(String browserName) {
        System.out.println("The browsername is " + browserName);
        WebDriverManager.chromedriver().clearDriverCache().setup();
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            tlDriver.set(new ChromeDriver(options));
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browserName.equals("safari")) {
            WebDriverManager.safaridriver().setup();
            tlDriver.set(new SafariDriver());
        } else {
            System.out.println("Please provide correct browsername");
        }

        get_driver().manage().deleteAllCookies();
        get_driver().manage().window().maximize();
        return get_driver();

    }

    public static synchronized WebDriver get_driver() {
        return tlDriver.get();
    }
}

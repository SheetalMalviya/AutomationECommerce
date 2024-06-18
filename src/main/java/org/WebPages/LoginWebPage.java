package org.WebPages;

import org.Factory.DriverFactories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginWebPage {

    private WebDriver driver;
    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By forgotPasswordLink = By.linkText("Forgot your password?");
    private By signInBtn = By.id("SubmitLogin");

    public LoginWebPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleLoginPage() {
        return driver.getTitle();
    }

    public Boolean isForgotPasswordLinkVisible() {
        return driver.findElement(forgotPasswordLink).isDisplayed();
    }

    public void enter_emailID(String email_ID) {
        driver.findElement(emailId).sendKeys(email_ID);
    }

    public void enter_password(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void click_signIn() {
        driver.findElement(signInBtn).click();
    }


    public AccountsWebpage doLogin(String email_ID, String pwd) {
        driver.findElement(emailId).sendKeys(email_ID);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInBtn).click();
        return new AccountsWebpage(driver);
    }

    public String getTitleAccountPage() {
        return driver.getTitle();
    }

}

package org.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsWebpage {
    private WebDriver driver;
    By accountSection = By.cssSelector("div#center_column span");

    public AccountsWebpage(WebDriver driver) {
        this.driver = driver;
    }

    public int getAccountSectionListCount() {
        return driver.findElements(accountSection).size();
    }
    public List<String> getAccountSectionList() {
        List<String> accountSectionList = new ArrayList<>();
        List<WebElement> sectionList = driver.findElements(accountSection);
        for (WebElement e : sectionList) {
            String text = e.getText();
            accountSectionList.add(text);
            System.out.println(text);
        }
        return accountSectionList;
    }

}

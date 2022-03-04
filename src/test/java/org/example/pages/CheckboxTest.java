package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckboxTest {

    private WebDriver driver;
    CheckboxPage checkboxPage;

    @BeforeClass
    public static void init() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        checkboxPage = new CheckboxPage(driver);
        checkboxPage.gotoHome();
        checkboxPage.navigateToCheckboxPage();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void test_lettuce_checkbox_selected() {
        checkboxPage.enableLettuceCheckBox();
        checkboxPage.verifyLettuceIsChecked();
    }


}
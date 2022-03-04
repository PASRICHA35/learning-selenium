package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TablePageTest {

    private WebDriver driver;

    @BeforeClass
    public static void init() {
        System.out.println("This will run only once");
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setup() {
        System.out.println("This will run before every Test");
        driver = new FirefoxDriver();
        driver.get("http://localhost:8082/");
        WebElement element = driver.findElement(By.id("tableLink"));
        element.click();
    }

    @After
    public void after() {
//        System.out.println("This will run after every Test");
        driver.quit();
    }

    @Test
    public void test_table() {


        WebElement tick = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td"));
//        assert(tick.isSelected());
        assertEquals("Table 2 Row 2",tick.getText());

    }
}

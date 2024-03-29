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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class ColorTest {

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
        WebElement element = driver.findElement(By.id("radioLink"));
        element.click();
    }

    @After
    public void after() {
//        System.out.println("This will run after every Test");
        driver.quit();
    }

    @Test
    public void test() {


        List<WebElement> list = driver.findElements(By.name("color"));
        WebElement color = null;
        for (WebElement webElement : list) {
            if (Objects.equals(webElement.getAttribute("value"), "blue")) {
                color = webElement;
            }
        }

//        WebElement tick=driver.findElement(By.cssSelector("body > div > form > input[type=radio]:nth-child(5)"));
        color.click();
        assertTrue(color.isSelected());

    }

//    @Test
//    public void test_loading_complete_message(){
//        //Explicit Wait, if we get, will executed then only, otherwise wait for 10 sec.
//        //By this it will wait for 10 sec in this page, driver is in checkbox page bcoz of @Before
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
//
//        //it will take time to load on the page
//        WebElement loading=driver.findElement(By.id("message"));
//        assertEquals("Loading complete...",loading.getText());
//
//    }
}

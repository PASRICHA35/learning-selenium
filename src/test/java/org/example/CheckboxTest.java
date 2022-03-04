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

import static org.junit.Assert.*;

public class CheckboxTest {

    private WebDriver driver;

    @BeforeClass
    public static void init() {
        System.out.println("This will run only once");
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setup() {
        System.out.println("This will run before every Test");
        driver=new FirefoxDriver();
        driver.get("http://localhost:8082/");
        WebElement element=driver.findElement(By.id("checkboxLink"));
        element.click();
    }

    @After
    public  void after(){
//        System.out.println("This will run after every Test");
        driver.quit();
    }

    @Test
    public void test(){


        WebElement tick=driver.findElement(By.id("lettuceCheckbox"));
        tick.click();
        assertTrue(tick.isSelected());

    }

    @Test
    public void test_loading_complete_message(){
        //Explicit Wait, if we get, will executed then only, otherwise wait for 10 sec.
        //By this it will wait for 10 sec in this page, driver is in checkbox page bcoz of @Before
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        //it will take time to load on the page
        WebElement loading=driver.findElement(By.id("message"));
        assertEquals("Loading complete...",loading.getText());

    }
}

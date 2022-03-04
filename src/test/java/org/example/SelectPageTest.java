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
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class SelectPageTest {

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
        WebElement element=driver.findElement(By.id("selectLink"));
        element.click();
    }

    @After
    public  void after(){
//        System.out.println("This will run after every Test");
        driver.quit();
    }

    @Test
    public void should_select_maybe_from_textbox(){
        WebElement selectelement=driver.findElement(By.id("select1"));
        //for selecting object in selenium
        Select select=new Select(selectelement);

        select.selectByValue("maybe");


        assertEquals("maybe",selectelement.getAttribute("value"));
    }
}

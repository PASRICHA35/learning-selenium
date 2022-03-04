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

import static org.junit.Assert.*;

public class SeleniumWebsiteTest {

    //test format must be like this
    //AAA-> Arrange, Act and Assert

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
        driver.get("https://www.selenium.dev/");

        WebElement blog=driver.findElement(By.linkText("Blog"));
        blog.click();
    }

    @After
    public  void after(){
        System.out.println("This will run after every Test");
        driver.quit();
    }

    @Test
    public void test_selenium_dot_dev_blog_2016_page(){
//        WebDriverManager.firefoxdriver().setup();

//        WebDriver driver=new FirefoxDriver();
//        driver.get("https://www.selenium.dev/");
//
//        WebElement blog=driver.findElement(By.linkText("Blog"));
//        blog.click();

        WebElement link2016=driver.findElement(By.id("m-blog2016"));
        link2016.click();

        WebElement element=driver.findElement(By.linkText("Fall Selenium Conf, Save the Date & Call for Speakers!"));
//        element.getText();
        assertEquals("Fall Selenium Conf, Save the Date & Call for Speakers!",element.getText());

        String title=driver.getTitle();
        assertEquals("Blog Posts - 2016 | Selenium",title);

//        driver.quit();
    }

    @Test
    public void test_selenium_dot_dev_blog_2017_page(){
//        WebDriverManager.firefoxdriver().setup();
//
//        WebDriver driver=new FirefoxDriver();
//        driver.get("https://www.selenium.dev/");
//
//        WebElement blog=driver.findElement(By.linkText("Blog"));
//        blog.click();

        WebElement link2017=driver.findElement(By.id("m-blog2017"));
        link2017.click();

        String title=driver.getTitle();
        assertEquals("Blog Posts - 2017 | Selenium",title);

//        driver.quit();

    }
}

package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class Test {


    @org.junit.Test
    public void test_selenium_dot_dev_blog(){
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.selenium.dev/");

        WebElement blog=driver.findElement(By.linkText("Blog"));
        blog.click();

        WebElement link2016=driver.findElement(By.id("m-blog2016"));
        link2016.click();

        WebElement element=driver.findElement(By.linkText("Fall Selenium Conf, Save the Date & Call for Speakers!"));
//        element.getText();
        assertEquals("Fall Selenium Conf, Save the Date & Call for Speakers!",element.getText());

        String title=driver.getTitle();
        assertEquals("Blog Posts - 2016 | Selenium",title);


    }
}

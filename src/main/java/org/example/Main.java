package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {

//        FirefoxOptions options=new FirefoxOptions();
//        options.setBinary("/usr/bin/firefox");

        //can call any function here
        WebDriver driver=chromeDriver();
//        google(driver);
        testselenium(driver);
    }

    private static void testselenium(WebDriver driver) {
        driver.get("https://www.selenium.dev/");
        WebElement searchbox=driver.findElement(By.cssSelector("#main_navbar > ul > li:nth-child(7) > a"));
        searchbox.click();
        searchbox=driver.findElement(By.id("m-blog2016-li"));
        searchbox.click();
        searchbox=driver.findElement(By.cssSelector("body > div > div.td-main > div > main > div:nth-child(1) > div > ul > li:nth-child(4) > div > h5 > a"));
        searchbox.click();
    }

    public static void google( WebDriver driver){
        driver.get("http://google.com");

//        document.getElementsbyName("q")[0] //this is how we inspect on chrome
        WebElement searchbox=driver.findElement(By.name("q"));
        searchbox.click();
//        document.getElementsbyName("q")[0].value="Selenium Testing"; //done on chrome
        searchbox.sendKeys("Selenium Testing");
        searchbox.sendKeys(Keys.ENTER);
//        by xpath
//        driver.findElement(By.xpath("//a[@href='https://www.guru99.com/introduction-to-selenium.html']")).click();
    }

    public static WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}

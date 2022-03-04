package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class GoogleTest {
    @Test
    public void testGoogle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://google.com");
        WebElement searchbox=driver.findElement(By.name("q"));
        searchbox.click();
        searchbox.sendKeys("selenium testing");
        searchbox.sendKeys(Keys.ENTER);

        //Implicit Wait-waiting for dom, if find out, will be executed early only.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement result= driver.findElement(By.cssSelector("#rso > div:nth-child(3) > div > div.tF2Cxc > div.yuRUbf > a > h3"));
        result.click();

    }
}

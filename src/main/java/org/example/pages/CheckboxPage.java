package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class CheckboxPage extends HomePage {

    @FindBy(id = "lettuceCheckbox")
    WebElement lettuceCheckbox;

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public void enableLettuceCheckBox() {
        lettuceCheckbox.click();
    }

    public void verifyLettuceIsChecked() {
        assertTrue(lettuceCheckbox.isSelected());
    }
}
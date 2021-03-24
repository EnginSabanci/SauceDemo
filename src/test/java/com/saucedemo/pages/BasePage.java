package com.saucedemo.pages;

import com.saucedemo.utilities.BrowserUtils;
import com.saucedemo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){

        PageFactory.initElements(Driver.get(), this);
    }

    /**
     * This method click in an element and has wait implemented on it
     *
     * @param element
     */
    public static void click(WebElement element) {
        BrowserUtils.waitForVisibility(element,10);
        element.click();
    }
}

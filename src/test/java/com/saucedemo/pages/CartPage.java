package com.saucedemo.pages;


import com.saucedemo.utilities.BrowserUtils;
import com.saucedemo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(xpath = "//*[@id='cart_contents_container']/div/div[2]/a[2]")
    public WebElement checkoutBtn;

    @FindBy(xpath = "//div[@class='cart_footer']/a")
    public WebElement continueShoppingBtn;

    @FindBy(xpath = "//button[@class='btn_secondary cart_button']")
    public List<WebElement> removeBtn;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<WebElement> itemListInCart;


    public void clickRemoveBtn(String itemName){
        String locator = "//*[contains(text(),'"+itemName+"')]/../following-sibling::div/following-sibling::div/button";
        WebElement btn = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForClickablility(btn, 15);
        btn.click();

    }

    public void choseRemovedItem(String str){
        String removedLocator ="//*[contains(text(),'"+str+"')]";
        WebElement removedOption = Driver.get().findElement(By.xpath(removedLocator));
        BrowserUtils.waitForVisibility(removedOption, 15);
        removedOption.click();


    }
}

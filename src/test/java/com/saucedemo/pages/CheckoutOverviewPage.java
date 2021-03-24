package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutOverviewPage extends BasePage{
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<WebElement> overviewItems;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> overviewItemsPrice;

    @FindBy(xpath = "//a[normalize-space()='FINISH']")
    public WebElement finishBtn;

    @FindBy(xpath ="//h2[normalize-space()='THANK YOU FOR YOUR ORDER']" )
    public WebElement thankYouMsg;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    public WebElement itemTotal;

}

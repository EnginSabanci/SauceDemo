package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryItemPage extends BasePage {
	
	@FindBy(xpath= "//button[text()='ADD TO CART']")
	public WebElement addBtn;
	
	@FindBy(xpath = "//div[@id='shopping_cart_container']")
	public WebElement shoppingCard;


	

}

package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class MainPage extends BasePage {

	@FindBy(xpath = "//div[@class='app_logo']")
	public WebElement appLogo;

	@FindBy(xpath = "//div[@class = 'inventory_item_name']")
	public List<WebElement> itemList;

	@FindBy(className = "product_label")
	public WebElement productLabel;

	@FindBy(className = "product_sort_container")
	public WebElement productSort;

	@FindBy(xpath = "//div[@class='pricebar']//button")
	public List<WebElement> items;

	@FindBy(xpath = "//button[@class = 'btn_primary btn_inventory']")
	public List<WebElement> addToCartBtn;

	@FindBy(xpath = "//button[text() = 'ADD TO CART']")
	public List<WebElement> addToCartBtn2;


	public void sortProductByValue(WebElement element, String value){
		Select select = new Select(element);
		select.selectByValue(value);
	}


}

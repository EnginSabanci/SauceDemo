package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
	
	@FindBy(id = "first-name")
	public WebElement fname;
	
	@FindBy(id = "last-name")
	public WebElement lname;
	
	@FindBy(id = "postal-code")
	public WebElement zipCode;
	
	@FindBy(xpath = "//input[@value='CONTINUE']")
	public WebElement continueBtn;


}

package com.saucedemo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement passWord;

    @FindBy(xpath = "//input [@value='LOGIN']")
    public WebElement loginBtn;


    public void login(String username, String password){
        userName.sendKeys(username);
        //Keys.ENTER to replace login click
        passWord.sendKeys(password, Keys.ENTER);
    }

}

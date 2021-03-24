package com.saucedemo.step_definitions;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.MainPage;
import com.saucedemo.utilities.ConfigurationReader;
import com.saucedemo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enters valid username and password")
    public void user_enters_valid_and() {
        String userName = ConfigurationReader.getProperty("username1");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(userName, password);
    }

    @Then("I validate that user is logged in")
    public void i_validate_that_user_is_logged_in() {
        String expected = "Products";
        String actual = mainPage.productLabel.getText();
        Assert.assertEquals(expected,actual);
    }
}

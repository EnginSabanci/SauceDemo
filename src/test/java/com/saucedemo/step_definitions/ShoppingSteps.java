package com.saucedemo.step_definitions;

import com.saucedemo.pages.*;
import com.saucedemo.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.saucedemo.pages.BasePage.click;

public class ShoppingSteps {

    MainPage mainPage = new MainPage();
    InventoryItemPage inventoryItemPage = new InventoryItemPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();

    @When("user selects price low to high")
    public void user_selects_price_low_to_high() {
        String lowtohigh = "lohi";
        mainPage.sortProductByValue(mainPage.productSort, lowtohigh);
        BrowserUtils.wait(2);
    }

    @Then("user should be able to adds items by clicking ADD TO CART button")
    public void user_should_be_able_to_adds_items_by_clicking_ADD_TO_CART_button() {
        int count = 0;
        for (WebElement element : mainPage.addToCartBtn) {
            click(element);
            count++;
            if (count == 3) {
                break;
            }

        }
    }

    @Then("user clicks on SHOPPING CART icon")
    public void user_clicks_on_SHOPPING_CART_icon() {
        inventoryItemPage.shoppingCard.click();
        BrowserUtils.wait(3); //for demo
    }

    @Then("verifies that the selected items are displayed")
    public void verifies_that_the_selected_items_are_displayed(List<String> itemName) {
        System.out.println("==============================================================");
        ArrayList<String> actual = new ArrayList<>();
        for (int i = 0; i < cartPage.itemListInCart.size(); i++) {
            actual.add(cartPage.itemListInCart.get(i).getText());

        }
        BrowserUtils.wait(3);

        ArrayList<String> expected = new ArrayList<String>(itemName);
        System.out.println("Expected " + expected.toString()); //for demo
        System.out.println("Actual " + actual.toString());   //for demo
        Assert.assertEquals(expected, actual);
    }


    @Then("user should be able to remove {string}")
    public void user_should_be_able_to_remove(String str) {
        cartPage.clickRemoveBtn(str);
        System.out.println("Left items in cart after removing " + str); //for demo
        for (int i = 0; i < cartPage.itemListInCart.size(); i++) {
            System.out.println(cartPage.itemListInCart.get(i).getText());
        }

    }

    @Then("user click on the CONTINUE SHOPPING button")
    public void user_click_on_the_CONTINUE_SHOPPING_button() {
        click(cartPage.continueShoppingBtn);
    }


    @Then("user should be able to add {string} item")
    public void user_should_be_able_to_add_item(String itemName) {
        for (WebElement item : mainPage.itemList) {
            if (item.getText().equals(itemName)) {
                click(item);
                click(inventoryItemPage.addBtn);
                break;
            }
        }

    }

    @Then("user click on the checkout button")
    public void user_click_on_the_checkout_button() {
        click(cartPage.checkoutBtn);
    }

    @Then("user enters the following information")
    public void user_enters_the_following_information(List<Map<String, String>> dataTable) {
        BrowserUtils.waitForPageToLoad(5);
        for (Map<String, String> map : dataTable) {
            checkoutPage.fname.sendKeys(map.get("firstname"));
            checkoutPage.lname.sendKeys(map.get("lastname"));
            checkoutPage.zipCode.sendKeys(map.get("zipcode"));
        }

    }

    @Then("user click on continue button")
    public void user_click_on_continue_button() {
        click(checkoutPage.continueBtn);
    }

    @Then("user verify the items name matches with fallowing items")
    public void user_verify_the_items_name_matches_with_fallowing_items(List<String> dataTable) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++"); //for demo
        for (int i = 0; i < dataTable.size(); i++) {
            System.out.println(dataTable.get(i)); //for demo
            System.out.println(checkoutOverviewPage.overviewItems.get(i).getText()); // for demo
            Assert.assertEquals(dataTable.get(i), checkoutOverviewPage.overviewItems.get(i).getText());
        }
    }

    @Then("assert that items prizes are as expected")
    public void assert_that_items_prizes_are_as_expected(List<String> dataTable) {
        int count = 0;
        for (int i = 0; i < dataTable.size(); i++) {
            System.out.println("Data Table daki itemlerin fiyatlari " + dataTable.get(i)); //for demo
            Assert.assertEquals(dataTable.get(i), checkoutOverviewPage.overviewItemsPrice.get(i).getText());
            count++;
        }
    }

    @Then("user verifies that total price is {string}")
    public void user_verifies_that_total_price_is(String string) {
        Assert.assertEquals(string, checkoutOverviewPage.itemTotal.getText().substring(12));
    }

    @Then("when user click finish button verify that THANK YOU FOR YOUR ORDER massage is displayed.")
    public void when_user_click_finish_button_verify_that_THANK_YOU_FOR_YOUR_ORDER_massage_is_displayed() {
        click(checkoutOverviewPage.finishBtn);
        String expected = "THANK YOU FOR YOUR ORDER";
        String actual = checkoutOverviewPage.thankYouMsg.getText();
        Assert.assertEquals(expected, actual);
    }

}

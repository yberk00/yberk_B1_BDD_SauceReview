package com.sauce.stepDefs;

import com.sauce.pages.CheckOutPage;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class End2End_StepDef {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    @When("The user enters {string} and {string}")
    public void theUserEntersAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("The suer should be anle to login and see {string}")
    public void theSuerShouldBeAnleToLoginAndSee(String expectedText) {
        productsPage.isDisplayedMethod();
        //Assert.assertEquals(expectedText,productsPage.productText.getText());
    }

    @And("The user should be able to sort products {string}")
    public void theUserShouldBeAbleToSortProducts(String sortType) {
        productsPage.sortProduct(sortType);
    }

    @When("The user clicks the cheapest as {string} and second costline as {string} products")
    public void theUserClicksTheCheapestAsAndSecondCostlineAsProducts(String product1, String product2) {
        productsPage.addProducts(product1);
        productsPage.addProducts(product2);
    }

    @Then("The user click cart button and click checkout button")
    public void theUserClickCartButtonAndClickCheckoutButton() {
        productsPage.cartBtn.click();
        checkOutPage.checkoutBtn.click();
    }

    @And("The user enters details as {string} {string} {string}")
    public void theUserEntersDetailsAs(String name, String lastName, String zip) {
//        checkOutPage.firstNameTextBox.sendKeys(name);
//        checkOutPage.lastNameTextBox.sendKeys(lastName);
//        checkOutPage.zipTextBox.sendKeys(zip);
        checkOutPage.enterDetails(name,lastName,zip);
    }
    @And("The user click continue button")
    public void theUserClickContinueButton() {
        checkOutPage.contButton.click();
    }

    @Then("The user verifys that the items are {string} and total is {string}")
    public void theUserVerifysThatTheItemsAreAndTotalIs(String totalPrice, String expectedTotal) {
        Assert.assertEquals(expectedTotal,checkOutPage.totalPrice(totalPrice));
        System.out.println("expectedTotal = " + expectedTotal);
        System.out.println("totalPrice = " + totalPrice);
    }
}

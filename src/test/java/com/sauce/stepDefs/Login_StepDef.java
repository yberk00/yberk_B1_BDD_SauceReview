package com.sauce.stepDefs;

import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductsPage;
import com.sauce.utilities.BrowserUtils;
import com.sauce.utilities.ConfigurationReader;
import com.sauce.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDef {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user enters {string} and {string} credantials")
    public void the_user_enters_and_credentials(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("The user able to login SwagLabs website")
    public void the_user_should_be_able_to_login_swaglabs_web_site() {
        productsPage.isDisplayedMethod();
       // Assert.assertEquals("Products",productsPage.productText.getText());
    }

    @When("The user enters invalid or empty {string} or {string} credantials")
    public void theUserEntersInvalidOrEmptyOrCredantials(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("The user able to see {string} login SwagLabs website")
    public void theUserAbleToSeeLoginSwagLabsWebsite(String errorMessage) {
        BrowserUtils.waitFor(2);
        Assert.assertEquals(errorMessage,loginPage.actualErrorMessage.getText());
    }


}
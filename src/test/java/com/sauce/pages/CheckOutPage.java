package com.sauce.pages;

import com.sauce.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{
    @FindBy(id = "checkout")
    public WebElement checkoutBtn;
    @FindBy(id = "first-name")
    public WebElement firstNameTextBox;
    @FindBy(id = "last-name")
    public WebElement lastNameTextBox;
    @FindBy(id = "postal-code")
    public WebElement zipTextBox;
    @FindBy(id = "continue")
    public WebElement contButton;

    public void enterDetails(String firstname, String lastname, String zip){
        firstNameTextBox.sendKeys(firstname);
        lastNameTextBox.sendKeys(lastname);
        zipTextBox.sendKeys(zip);
    }

    public String  totalPrice(String totalPrice){
        return Driver.get().findElement(By.xpath("//*[.='Total: $"+totalPrice+"']")).getText();
    }
}

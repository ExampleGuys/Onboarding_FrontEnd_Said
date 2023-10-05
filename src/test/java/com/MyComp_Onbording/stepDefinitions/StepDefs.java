package com.MyComp_Onbording.stepDefinitions;

import com.MyComp_Onbording.pages.OrderPage;
import com.MyComp_Onbording.pages.SignInPage;
import com.MyComp_Onbording.utils.ConfigReader;
import com.MyComp_Onbording.utils.Driver;
import com.MyComp_Onbording.utils.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.codehaus.plexus.util.FileUtils.waitFor;

public class StepDefs extends ReusableMethods {

    OrderPage orderPage = new OrderPage();
    SignInPage signInPage=new SignInPage();

    @Given("The user goes to the sign-in page")
    public void the_user_goes_to_the_sign_in_page() {
        Driver.getDriver().get(ConfigReader.getProperty("adminURL"));

    }
    @When("user logs in with the valid credentials")
    public void user_logs_in_with_the_valid_credentials() {

        // signInPage.emailSaid.sendKeys(ConfigReader.getProperty("email));
       //  signInPage.passwordInput.sendKeys(ConfigReader.getProperty("password"));

        signInPage.signIn(ConfigReader.getProperty("email"),ConfigReader.getProperty("password"));
        orderPage.signIn.click();
        ReusableMethods.wait(3);

    }

    @And("Click on the {string} section in the Navigation Menu")
    public void clickOnTheSectionInTheNavigationMenu(String navigationName) {

        WebElement sidebar=Driver.getDriver().findElement(By.xpath("//span[text()='"+navigationName+"']"));
        ReusableMethods.clickWithJS(sidebar);
        ReusableMethods.wait(3);
    }

    @And("The user click on the {string} button.")
    public void theUserClickOnTheButton(String buttonName) {
    WebElement button = Driver.getDriver().findElement(By.xpath("//span[text()='"+buttonName+"']"));
    ReusableMethods.clickWithJS(button);
    ReusableMethods.wait(3);
    }

    @Then("the user should be redirected to the new order creation page")
    public void theUserShouldBeRedirectedToTheNewOrderCreationPage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("create"));


    }

    @Then("the user should be able to redirect back to the List of Orders page again.")
    public void theUserShouldBeAbleToRedirectBackToTheListOfOrdersPageAgain() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("order"));

    }

    @And("The user clicks the {string} icon.")
    public void theUserClicksTheIcon(String arg0) {
    }
    //input[@placeholder='Enter personal email']
}

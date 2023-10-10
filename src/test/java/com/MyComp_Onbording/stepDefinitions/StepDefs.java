package com.MyComp_Onbording.stepDefinitions;

import com.MyComp_Onbording.pages.OrderPage;
import com.MyComp_Onbording.pages.SignInPage;
import com.MyComp_Onbording.utils.ConfigReader;
import com.MyComp_Onbording.utils.Driver;
import com.MyComp_Onbording.utils.ReusableMethods;
import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import javax.swing.*;
import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;

import static org.codehaus.plexus.util.FileUtils.waitFor;

public class StepDefs extends ReusableMethods {

    OrderPage orderPage = new OrderPage();
    SignInPage signInPage = new SignInPage();

    Actions actions = new Actions(Driver.getDriver());

    Faker faker = new Faker();


    @Given("The user goes to the sign-in page")
    public void the_user_goes_to_the_sign_in_page() {
        Driver.getDriver().get(ConfigReader.getProperty("adminURL"));

    }

    @When("user logs in with the valid credentials")
    public void user_logs_in_with_the_valid_credentials() {

        // signInPage.emailSaid.sendKeys(ConfigReader.getProperty("email));
        //  signInPage.passwordInput.sendKeys(ConfigReader.getProperty("password"));

        signInPage.signIn(ConfigReader.getProperty("email"), ConfigReader.getProperty("password"));
        orderPage.signIn.click();
        ReusableMethods.wait(3);

    }

    @And("Click on the {string} section in the Navigation Menu")
    public void clickOnTheSectionInTheNavigationMenu(String navigationName) {

        WebElement sidebar = Driver.getDriver().findElement(By.xpath("//span[text()='" + navigationName + "']"));
        ReusableMethods.clickWithJS(sidebar);
        ReusableMethods.wait(3);
    }

    @And("The user click on the {string} button.")
    public void theUserClickOnTheButton(String buttonName) {
        WebElement button = Driver.getDriver().findElement(By.xpath("//span[text()='" + buttonName + "']"));
        ReusableMethods.clickWithJS(button);

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
    public void theUserClicksTheIcon(String iconName) {
        orderPage.clickPlusAccordingToOptionName(iconName);
        ReusableMethods.wait(1);


    }

    @And("The user should be able to add data to {string} with {string}")
    public void theUserShouldBeAbleToCreateNewCompany(String placeHolder, String companyNAme) {
        String fakeDataInfo = fakeName();
        orderPage.boxName(placeHolder).sendKeys(companyNAme);
        ReusableMethods.wait(1);
        Assert.assertEquals(orderPage.boxName(placeHolder).getAttribute("value"), companyNAme);

}

    @And("The user should be able to see a warning message as {string}")
    public void theUserShouldBeAbleToSeeAWarningMessageAs(String message) {
        Assert.assertEquals(orderPage.getPopupsMessage(), message);


    }

    @And("The user select an option to {string} from ddm as {string}.")
    public void theUserSelectAnOptionToFromDdmAs(String ddm, String optionsFromDDM) {
        orderPage.ddm1.click();

        ReusableMethods.clickWithJS(orderPage.ddmBox(optionsFromDDM));
        ReusableMethods.wait(1);
        Assert.assertEquals(orderPage.ddmBox(ddm).getAttribute("value"), optionsFromDDM);
    }

    @And("The user select the company from ddm")
    public void theUserSelectTheCompanyFromDdm() {
        WebElement button2 = Driver.getDriver().findElement(By.cssSelector("#Order_company"));
        ReusableMethods.clickWithJS(button2);
        ReusableMethods.wait(1);
        button2.sendKeys("Test Techno Consultant" + Keys.ENTER);


    }


    @And("The user should be able to write something to {string} with {string}")
    public void theUserShouldBeAbleToWriteSomethingToWith(String placeHolder, String boxNAme) {
        orderPage.boxNAme2(placeHolder).sendKeys(boxNAme);
        ReusableMethods.wait(1);
        Assert.assertEquals(orderPage.boxName(placeHolder).getAttribute("value"), boxNAme);

    }

    @And("The user should be able to add data to {string}")
    public void theUserShouldBeAbleToAddDataTo(String placeHolder) {
        String fakeDataInfo = fakeName();
        orderPage.boxName(placeHolder).sendKeys(fakeDataInfo);

        ReusableMethods.wait(1);
        Assert.assertEquals(orderPage.boxName(placeHolder).getAttribute("value"), fakeDataInfo);

    }

    @And("user fills in all required fields properly")
    public void userFillsInAllRequiredFieldsProperly() {
        WebElement baslamakutusu = orderPage.boxName("Enter first name");
        String password = "AB123@ab";

        actions.click(baslamakutusu).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(faker.internet().
                        emailAddress()).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys("Avcilar" + Keys.ENTER)
                .sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(password).perform();

        ReusableMethods.wait(2);
        actions.sendKeys(Keys.TAB).sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).click().perform();


    }

    @And("The user select the shipping adress from ddm")
    public void theUserSelectTheShippingAdressFromDdm() {
        WebElement button2 = Driver.getDriver().findElement(By.cssSelector("#Order_delivery_address"));
        WebElement adressInfo=Driver.getDriver().findElement(By.xpath("//span[@title='Avcilar']"));
        ReusableMethods.clickWithJS(button2);
        ReusableMethods.wait(1);
        button2.sendKeys("Avcilar" + Keys.ENTER);
        Assert.assertTrue(adressInfo.isDisplayed());


    }

    @And("The user select the date from datapicker")
    public void theUserSelectTheDateFromDatapicker() {
        WebElement button2 = Driver.getDriver().findElement(By.cssSelector("#Order_delivery_date"));
        ReusableMethods.clickWithJS(button2);
        ReusableMethods.wait(1);
        button2.sendKeys("31-10-2023" + Keys.ENTER);
        Assert.assertTrue(orderPage.datapicker.isEnabled());


    }

    @And("The user select the priority from the ddm")
    public void theUserSelectThePriorityFromTheDdm() {
        WebElement button2 = Driver.getDriver().findElement(By.cssSelector("#Order_priority"));
        ReusableMethods.clickWithJS(button2);
        ReusableMethods.wait(1);
        button2.sendKeys("Normal" + Keys.ENTER);
        Assert.assertTrue(orderPage.priorityDdm.isEnabled());

    }
    @And("The user select the approver from the ddm")
    public void theUserSelectTheApproverFromTheDdm() {

        WebElement button2 = Driver.getDriver().findElement(By.cssSelector("#Order_approver"));
        ReusableMethods.clickWithJS(button2);
        ReusableMethods.wait(1);
        button2.sendKeys("test@yopmail.com - Test Tester" + Keys.ENTER);


    }

    @And("The user select the contact from the ddm")
    public void theUserSelectTheContactFromTheDdm() {

        WebElement button2 = Driver.getDriver().findElement(By.cssSelector("#Order_contactUser"));
        ReusableMethods.clickWithJS(button2);
        ReusableMethods.wait(5);
        button2.sendKeys("gpt" + Keys.ENTER);
    }

    @Then("The user should be able to type up to fivehundred characters in the Description field.")
    public void theUserShouldBeAbleToTypeUpToFivehundredCharactersInTheDescriptionField() {

       String str= faker.lorem().characters(510);
        int strlength = str.length(); //510
        orderPage.boxName("Enter reason for request").sendKeys(str);

       int textlength = orderPage.orderEnterDescriptionInfo.getText().length();

        String str500 = orderPage.order500InputDataCount.getText();

        int bosluk = str500.indexOf(" "); //3

        int fivehundred = Integer.parseInt(str500.substring(0,bosluk)); //500 int

        Assert.assertEquals(textlength,fivehundred);

       // Assert.assertNotEquals(strlength,textlength);

    }


    @And("The user should be able to add Email adress to {string}")
    public void theUserShouldBeAbleToAddEmailAdressTo(String placeHolder) {
        String fakeEmailInfo = fakeEmailAdress();
        orderPage.boxName(placeHolder).sendKeys(fakeEmailInfo);

        ReusableMethods.wait(1);
        Assert.assertEquals(orderPage.boxName(placeHolder).getAttribute("value"), fakeEmailInfo);

    }

}

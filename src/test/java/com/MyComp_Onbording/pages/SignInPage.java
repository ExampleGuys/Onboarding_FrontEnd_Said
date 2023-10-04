package com.MyComp_Onbording.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(css = "#email")
    public WebElement emailSaid;


    @FindBy(css = "#password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    public void signIn(String email,String password){
        emailSaid.sendKeys(email);
        passwordInput.sendKeys(password);
    }
}

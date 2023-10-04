package com.MyComp_Onbording.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.MyComp_Onbording.utils.Driver.getDriver;


public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }



}
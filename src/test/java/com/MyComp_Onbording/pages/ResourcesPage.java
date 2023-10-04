package com.MyComp_Onbording.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.MyComp_Onbording.utils.Driver;

import static com.MyComp_Onbording.utils.Driver.getDriver;


public class ResourcesPage {

    public ResourcesPage() {
        PageFactory.initElements(getDriver(), this);
    }

    static ResourcesPage resourcesPage = new ResourcesPage();
    static Actions actions = new Actions(Driver.getDriver());



    //Resources >clickOnResources
    @FindBy(xpath = ("//a[@href='/resources'])[1]"))
    public WebElement clickOnResourcesCategory;

    //Resources >newResourcesEnterResourcesName
    @FindBy(xpath = "//input[@id='resource_resources_0_name']")
    public WebElement newResourcesEnterResourcesName;

    //Resources >resourcesSite
    @FindBy(xpath = "(//div[@class='ant-row css-14bavl3'])[1]")
    public WebElement resourcesSite;

    //Resources > page10]
    @FindBy(xpath = "//span[@title='10 / page']")
    public WebElement page10;

    //Resources >selectionTypeTitle
    @FindBy(xpath = ("//label[normalize-space()='Selection Type']"))
    public WebElement selectionTypeTitle;

    //Resources >selectionTypeSwitch
    @FindBy(xpath = ("//div[@id='resource_isMultiSelection']")) //span[@class='ant-switch-inner']
    public WebElement selectionTypeSwitch;

    //Resources >quantitySelectionTitle
    @FindBy(xpath = ("//label[normalize-space()='Quantity Selection']]"))
    public WebElement quantitySelectionTitle;

    //Resources >quantitySelectionSwitch
    @FindBy(xpath = ("//div[@id='resource_hasQuantity']"))//span[@class='ant-switch-inner']
    public WebElement quantitySelectionSwitch;

    //Resources >autoAddtoOnboardingTitle
    @FindBy(xpath = ("//label[normalize-space()='Auto Add to Onboarding']"))
    public WebElement autoAddtoOnboardingTitle;

    //Resources >autoAddtoOnboardingTitleSwitch
    @FindBy(xpath = ("//div[@id='resource_defaultOnboardingDisplay']"))//button[@role='switch']
    public WebElement autoAddtoOnboardingTitleSwitch;

    //Resources >newResourcesNameTitle
    @FindBy(xpath = ("//label[normalize-space()='Resource Name']"))
    public WebElement newResourcesNameTitle;

    //Resources >newResourcesCompanyMessage
    @FindBy(xpath = ("(//div[@class='ant-form-item-explain-error'])[1]"))
    public WebElement newResourcesCompanyMessage;

    //Resources >newResourcesCategoryNameMessage
    @FindBy(xpath = ("(//div[@class='ant-form-item-explain-error'])[2]"))
    public WebElement newResourcesCategoryNameMessage;

    //Resources >newResourcesNameMessage
    @FindBy(xpath = ("(//div[@class='ant-form-item-explain-error'])[3]"))
    public WebElement newResourcesNameMessage;

    //Resources >newResourcesContactsMessage
    @FindBy(xpath = ("(//div[@class='ant-form-item-explain-error'])[4]"))
    public WebElement newResourcesContactsMessage;

    //Resources >newResourcesAddResourcesButton
    @FindBy(xpath = ("//span[normalize-space()='Add resource']"))
    public WebElement newResourcesAddResourcesButton;

    //Resources >resourcesLink
    @FindBy(xpath = ("//a[contains(text(),'Resources')]"))
    public WebElement resourcesLink;

}
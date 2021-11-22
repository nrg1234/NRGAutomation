package Pages.DSP;

import Utilities.CommonFunctions;
import apphooks.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class AddCustomerPopup {
    WebDriver driver;
    @FindBy(xpath = "//button[contains(text(), 'Add Customer')]")
    WebElement addCustomerBtn;
    @FindBy(xpath = "//input[@id='typeahead-customer']")
    WebElement customerNameInput;
    @FindBy(xpath = "//button[contains(text(), 'Create Customer')]")
    WebElement createCustomerBtn;
    @FindBy(xpath = "//*[@class='dropdown open dropdown-menu']")
    WebElement customersLst;
    @FindBy(xpath = "//div[@class='col p-3']")
    WebElement firstCustomerCard;
    @FindBy(xpath = "//button[contains(text(), 'Add To Opportunity')]")
    WebElement addCustomerToOptyBtn;
    @FindBy(xpath = "//button[contains(text(), 'Renew')]")
    WebElement renewButton;
    @FindBy(xpath = "//button[contains(text(), 'Restructure')]")
    WebElement restructureBtn;
    @FindBy(xpath = "//button[contains(text(), 'Create New Deal')]")
    WebElement createNewDealBtn;
    @FindBy(xpath = "//button[contains(text(),'Renew')]")
    WebElement renewBtn;
    @FindBy(xpath = "//div[@class='control__indicator contract-checkbox']")
    WebElement contractCheckbox;
    @FindBy(xpath = "//button[contains(text(), 'Create Renewal Opportunity')]")
    WebElement createRenewalOptyBtn;

    public AddCustomerPopup(Base base) {
        this.driver = base.driver;
        PageFactory.initElements(driver, this);
    }

    /*
     * Add customer to opportunity
     */

    public void AddCustomertoOpportunity(Map<String, Object> data) throws Throwable {
        CommonFunctions functions = new CommonFunctions();

        // Click add customer button
        functions.click(driver, addCustomerBtn);

        // Enter customer name
        functions.setText(driver, customerNameInput, data.get("customerName").toString());

        // Select first customer card
        functions.click(driver, firstCustomerCard);

        // Wait for customer details to Load
        functions.waitForvisibility(driver, addCustomerToOptyBtn, 20);

        // Click "add to opportunity" button
        functions.click(driver, addCustomerToOptyBtn);

        // Wait for customer details to Load
        functions.waitForvisibility(driver, createNewDealBtn, 25);

        functions.intermediatewait();
        //select Create New Deal from the Popup
        functions.click(driver, createNewDealBtn);

    }

    /*
     * Add customer to opportunity using XML .
     */

    public void AddCustomertoOpportunity(String customername) throws Throwable {
        CommonFunctions functions = new CommonFunctions();

        // Click add customer button
        functions.click(driver, addCustomerBtn);

        // Enter customer name
        functions.setText(driver, customerNameInput, customername);

        // Select first customer card
        functions.click(driver, firstCustomerCard);

        // Wait for customer details to Load
        functions.mediumWait();
        functions.waitForvisibility(driver, addCustomerToOptyBtn, 20);

        // Click "add to opportunity" button
        functions.click(driver, addCustomerToOptyBtn);

        // Wait for customer details to Load
        functions.waitForvisibility(driver, createNewDealBtn, 25);

        //select Create New Deal from the Popup
        functions.intermediatewait();
        functions.click(driver, createNewDealBtn);

    }

    /*
     * Select Renew Option
     */
    public void SelectRenewButton(Map<String, Object> data,String customername) throws Throwable {
        CommonFunctions functions = new CommonFunctions();

        // Click add customer button
        functions.click(driver, addCustomerBtn);

        // Enter customer name
	        functions.setText(driver, customerNameInput, customername);

        // Select first customer card
        functions.click(driver, firstCustomerCard);

        // Wait for customer details to Load
        functions.waitForvisibility(driver, addCustomerToOptyBtn, 20);

        // Click "add to opportunity" button
        functions.click(driver, addCustomerToOptyBtn);

        // Wait for customer details to Load
        functions.waitForvisibility(driver, createNewDealBtn, 25);

        // Click on Renew Button from the modal popup
        functions.click(driver, renewBtn);

        // wait for Contract to get displayed
        functions.intermediatewait();

        // Click on contract checkbox
        functions.click(driver, contractCheckbox);

        // Click on Create Renewal Opty Button
        functions.click(driver, createRenewalOptyBtn);

        // Wait for add sites modal to disappear, and site tracked modal to appear
        functions.longWait();

    }
    public void SelectRenewButtonforAggregate(Map<String,Object> data,String customername1,String customername2)throws Throwable  {
        CommonFunctions functions=new CommonFunctions();

        // Click add customer button
        functions.click(driver,addCustomerBtn);

        // Enter customer name
        functions.setText(driver, customerNameInput, customername1);


        // Select first customer card
        functions.click(driver,firstCustomerCard);

        // Wait for customer details to Load
        functions.waitForvisibility(driver,addCustomerToOptyBtn,20);

        // Click "add to opportunity" button
        functions.click(driver,addCustomerToOptyBtn);

        // Wait for customer details to Load
        functions.waitForvisibility(driver,createNewDealBtn,25);
        // Click on Renew Button from the modal popup
        functions.click(driver,renewBtn);

        // wait for Contract to get displayed
        functions.intermediatewait();

        // Click on contract checkbox
        functions.click(driver, contractCheckbox);

        // Click on Create Renewal Opty Button

        functions.click(driver,createRenewalOptyBtn);

        // Wait for add sites modal to disappear, and site tracked modal to appear
        functions.longWait();

        // Click add customer button
        functions.click(driver,addCustomerBtn);

        // Enter customer name
        functions.setText(driver, customerNameInput, customername2);


        // Select first customer card
        functions.click(driver,firstCustomerCard);

        // Wait for customer details to Load
        functions.waitForvisibility(driver,addCustomerToOptyBtn,20);

        // Click "add to opportunity" button
        functions.click(driver,addCustomerToOptyBtn);

        // Wait for customer details to Load
        functions.waitForvisibility(driver,createNewDealBtn,25);
        // Click on Renew Button from the modal popup
        functions.click(driver,renewBtn);

        // wait for Contract to get displayed
        functions.intermediatewait();

        // Click on contract checkbox
        functions.click(driver, contractCheckbox);

        // Click on Create Renewal Opty Button

        functions.click(driver,createRenewalOptyBtn);

        // Wait for add sites modal to disappear, and site tracked modal to appear
        functions.longWait();


    }
}

package Pages.DSP;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import apphooks.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;

public class MatrixPricing {
	  String Status;
    // Matrix locators
    CommonFunctions functions = new CommonFunctions();
    @FindBy(xpath = "//button[@id='table-optype-btn']")
    WebElement Dropdownformoreopty;
    @FindBy(xpath = "//a[contains(text(), ' ENTER MATRIX PRICE DEAL')]")
    WebElement entermatrixpricedealbtn;
    @FindAll(value = {@FindBy(xpath = "//button[contains(text(), 'Create')]")})
    public List<WebElement> matrixcreateBtn;
    @FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
    WebElement opportunityIDText;
    @FindBy(xpath = "//a[contains(text(), 'Opportunities')]")
    WebElement opportunitiesTabsiebel;
    @FindBy(xpath = "//select[@name='s_vis_div']")
    WebElement allOpportunityDropdown;
    @FindBy(xpath = "//button[@id='s_4_1_17_0_Ctrl']")
    WebElement queryBtn;
    @FindBy(xpath = "//button[contains(text(),'Query')]")
    WebElement queryBtnincontracts;
    @FindBy(xpath = "//td[@id='1_s_4_l_Opportunity__']")
    WebElement opportunityId;
    @FindBy(xpath = "//td[@id='1_s_4_l_Name']")
    WebElement opportunityName;
    @FindBy(xpath = "//button[@id='s_4_1_14_0_Ctrl']")
    WebElement goBtn;
    @FindBy(xpath = "//button[contains(text(),'Go')]")
    WebElement goBtnincontracts;
    @FindBy(id = "1_Opportunity__")
    WebElement Opportunityidfield;
    @FindBy(xpath = "//a[@name='Name']")
    WebElement opportunitiesLst;
    // Matrix locators
    WebDriver driver;

    public MatrixPricing(Base base) {
        this.driver = base.driver;
        PageFactory.initElements(driver, this);
    }

    public void Addcustomer() throws Throwable {
        functions.shortWait();
        // Handle add customer popup
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String root1 = "return document.querySelector(\"body > modal-container > div > div > app-add-customer-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div.row.mt-2.text-center > div.col-12.p-0.mb-4 > div > input\")";
        WebElement shadowDom2 = (WebElement) js.executeScript(root1);
        functions.setText(driver, shadowDom2, "ARLINGTON HEIGHTS ANIMAL HOSPITAL");
        functions.shortWait();

        String shadowDom9 = "return document.querySelector(\"body > modal-container > div > div > app-add-customer-modal > app-modal\").shadowRoot.querySelector(\"#ngb-typeahead-0-1\")";
        //String shadowDom9 ="return document.querySelector(\"body > modal-container > div > div > app-add-customer-modal > app-modal\").shadowRoot.querySelector(\"#ngb-typeahead-1-1 > div\")";
        WebElement dropdowncustomer = (WebElement) js.executeScript(shadowDom9);

        functions.intermediatewait();
        Actions action = new Actions(driver);
        action.click(dropdowncustomer).build().perform();
        functions.mediumWait();


        String root2 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(4) > div:nth-child(3) > div > app-dropdown > div > div.row > div.col-9.pr-0 > input\")";
        WebElement shadow1 = (WebElement) js.executeScript(root2);
        Actions action1 = new Actions(driver);
        action1.click(shadow1).build().perform();
        functions.shortWait();

//		String roo3 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(4) > div:nth-child(3) > div > app-dropdown > div > div.dropdown-menu > a:nth-child(3)\")";
//		WebElement shadow2 = (WebElement) js.executeScript(roo3);
//		Actions action2=new Actions(driver);
//		action2.click(shadow2).build().perform();
//		functions.shortWait();
//

        // clicking on continue sites btn

        String roo4 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > div.row.mt-4 > div > button\")";
        WebElement continuetoaddsitesbtn = (WebElement) js.executeScript(roo4);
        functions.click(driver, continuetoaddsitesbtn);
        functions.mediumWait();
        
        
        
       // Create new contract
		String ro4 = "return document.querySelector(\"body > modal-container > div > div > app-existing-customer-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div > div > div > button.btn.btn-outline-primary.mr-4.bottom-margin\")";
		WebElement newcontractbtn = (WebElement) js.executeScript(ro4);
		functions.click(driver, newcontractbtn);
		functions.intermediatewait();

        // Click on Add bill copy usage
        String roo5 = " return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-sites > div.row.mt-4.justify-content-between.ng-star-inserted > div.col-auto > div > div.d-inline-block.align-top.pt-2 > button:nth-child(3) > span\")";
        WebElement billcopybtn = (WebElement) js.executeScript(roo5);
        functions.click(driver, billcopybtn);
        functions.mediumWait();
    }

    public String Addcustomer1() throws Throwable {
        // Handle add customer popup
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String root1 = "return document.querySelector(\"body > modal-container > div > div > app-add-customer-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div.row.mt-2.text-center > div.col-12.p-0.mb-4 > div > input\")";
        WebElement shadowDom2 = (WebElement) js.executeScript(root1);
        functions.setText(driver, shadowDom2, "ARLINGTON HEIGHTS ANIMAL HOSPITAL");
        functions.shortWait();

        String shadowDom9 = "return document.querySelector(\"body > modal-container > div > div > app-add-customer-modal > app-modal\").shadowRoot.querySelector(\"#ngb-typeahead-0-1\")";
        //String shadowDom9 ="return document.querySelector(\"body > modal-container > div > div > app-add-customer-modal > app-modal\").shadowRoot.querySelector(\"#ngb-typeahead-1-1 > div\")";
        WebElement dropdowncustomer = (WebElement) js.executeScript(shadowDom9);

        functions.intermediatewait();
        Actions action = new Actions(driver);
        action.click(dropdowncustomer).build().perform();
        functions.mediumWait();


        String root2 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(4) > div:nth-child(3) > div > app-dropdown > div > div.row > div.col-9.pr-0 > input\")";
        WebElement shadow1 = (WebElement) js.executeScript(root2);
        Actions action1 = new Actions(driver);
        action1.click(shadow1).build().perform();
        functions.shortWait();

//		String roo3 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(4) > div:nth-child(3) > div > app-dropdown > div > div.dropdown-menu > a:nth-child(3)\")";
//		WebElement shadow2 = (WebElement) js.executeScript(roo3);
//		Actions action2=new Actions(driver);
//		action2.click(shadow2).build().perform();
//		functions.shortWait();
//

        // clicking on continue sites btn

        String roo4 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > div.row.mt-4 > div > button\")";
        WebElement continuetoaddsitesbtn = (WebElement) js.executeScript(roo4);
        functions.click(driver, continuetoaddsitesbtn);
        functions.mediumWait();
        //Create new contract
        String ro4 = "return document.querySelector(\"body > modal-container > div > div > app-existing-customer-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div > div > div > button.btn.btn-outline-primary.mr-4.bottom-margin\")";
        WebElement newcontractbtn = (WebElement) js.executeScript(ro4);
        functions.click(driver, newcontractbtn);
        functions.intermediatewait();

        // Click on Add bill copy usage
        String roo5 = " return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-sites > div.row.mt-4.justify-content-between.ng-star-inserted > div.col-auto > div > div.d-inline-block.align-top.pt-2 > button:nth-child(4) > span\")";
        WebElement addsitelistbtn = (WebElement) js.executeScript(roo5);
        try {
        	if(addsitelistbtn.isEnabled()) {
        functions.click(driver, addsitelistbtn);
        functions.mediumWait();
        String Status="Pass";
        	}
        }
        catch(Exception e) {
        	 String Status="Pass";
        }
        	
        return Status;
    }

    public String Addsites() throws Throwable {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Entering values in Add sites popup
        // Entering sites
        String roo6 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > form > div:nth-child(2) > div > input\")";
        WebElement entersite = (WebElement) js.executeScript(roo6);

        functions.setText(driver, entersite, "1008901022901266540117");
        functions.shortWait();
        // enter srt date
        String roo7 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#contract-start-date\")";
        WebElement srtdate = (WebElement) js.executeScript(roo7);

        functions.setText(driver, srtdate, "11/01/2021");
        functions.shortWait();
//		// enter end date//Need to fix
        String roo8 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#contract-start-date\")";
        WebElement enddate = (WebElement) js.executeScript(roo8);
        //	functions.setText(driver, enddate, "11/30/2021");
        functions.intermediatewait();
//		// enter billed kwh
//
        String roo9 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > form > div:nth-child(4) > div:nth-child(2) > input\")";
        WebElement billedkwh = (WebElement) js.executeScript(roo9);
        functions.setText(driver, billedkwh, "6000");
        functions.shortWait();
//
//		// File upload Click on browse btn
        String roo10 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#browse-file\")";
        WebElement browsebtn = (WebElement) js.executeScript(roo10);
//		WebElement browsebtn = shadowDom5.findElement(By.cssSelector("#browse-file"));
        functions.click(driver, browsebtn);
        functions.mediumWait();
        // choosing the file to upload
        String pdffile = System.getProperty("user.dir");

        StringSelection ss = new StringSelection(
                pdffile + "\\src\\test\\resources\\DataReader\\Broker Contract Document.pdf");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);

            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
        } catch (AWTException | InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.println("exception on send attchement");
        }

        // click submit btn
        String roo11 = " return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > div.row.pt-3 > div:nth-child(2) > button\")";
        WebElement submitbtn = (WebElement) js.executeScript(roo11);
        js.executeScript("arguments[0].scrollIntoView();", submitbtn);
        functions.click(driver, submitbtn);
        functions.midintermediatewait();

        // Click on validate sites

        String roo12 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#validate-sites\")";
        WebElement validatebtn = (WebElement) js.executeScript(roo12);
        functions.click(driver, validatebtn);
        functions.longWait();
        String oportyid = opportunityIDText.getText();

        // Click on continue to pricing
        String roo13 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#continue-to-pricing\")";
        WebElement continuepricingbtn = (WebElement) js.executeScript(roo13);

        functions.click(driver, continuepricingbtn);
        functions.mediumWait();
        return oportyid;
    }

    public void Quotesummary() throws Throwable {
        // filling details in quote summary page
        JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement root7 = driver.findElement(By.tagName("app-broker-pricing"));
//		WebElement shadowDom7 = (WebElement) js.executeScript("return arguments[0].shadowRoot", root7);
//		WebElement productdropdownbtn = shadowDom7
//				.findElement(By.cssSelector("#matrix-product-name > div > div.row > div.col-9.pr-0 > input"));
        String roo14 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrix-product-name > div > div.row > div.col-9.pr-0 > input\")";
        WebElement productdropdownbtn = (WebElement) js.executeScript(roo14);
        functions.click(driver, productdropdownbtn);
        functions.minwait();
        functions.setText(driver, productdropdownbtn, "FIXED PRODUCT BUNDLED");
        productdropdownbtn.sendKeys(Keys.ENTER);
        functions.shortWait();

//		WebElement termbtn = shadowDom7.findElement(By.cssSelector("#matrix-term"));
        String roo15 = " return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrix-term\")";
        WebElement termbtn = (WebElement) js.executeScript(roo15);
        functions.setText(driver, termbtn, "1");
        functions.shortWait();
        // #matrix-broker-fee-adder

        //WebElement brokerfeebtn = shadowDom7.findElement(By.cssSelector("#matrix-broker-fee-adder"));
        String roo16 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrix-broker-fee-adder\")";
        WebElement brokerfeebtn = (WebElement) js.executeScript(roo16);
        functions.setText(driver, brokerfeebtn, "0.5");
        functions.shortWait();
        //WebElement Contractpricebtn = shadowDom7.findElement(By.cssSelector("#matrix-price"));
        String roo17 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrix-price\")";
        WebElement Contractpricebtn = (WebElement) js.executeScript(roo17);
        functions.setText(driver, Contractpricebtn, "55.6");
        functions.intermediatewait();
        String roo18 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrixFormEntryScreen > div.row.mt-3 > div:nth-child(1) > button\")";
        WebElement savebtn = (WebElement) js.executeScript(roo18);
        functions.click(driver, savebtn);
        functions.midintermediatewait();
        //// #matrixFormEntryScreen > div.row.mt-3 > div:nth-child(2) > button
        String roo19 = " return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrixFormEntryScreen > div.row.mt-3 > div:nth-child(2) > button\")";
        WebElement proceedtocontractbtn = (WebElement) js.executeScript(roo19);
        functions.click(driver, proceedtocontractbtn);
        functions.intermediatewait();

        String roo20 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-contact > div.form-container > div:nth-child(4) > div:nth-child(2) > button\")";
        WebElement contractgenerationbtn = (WebElement) js.executeScript(roo20);
        functions.click(driver, contractgenerationbtn);
        functions.longWait();
//

//        String roo21 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-contracts > div.table-responsive > app-contracts-table > table > tbody > tr.parent-row > td:nth-child(17) > button\")";
//        WebElement clickuploadbtn = (WebElement) js.executeScript(roo21);
//        js.executeScript("arguments[0].scrollIntoView();", clickuploadbtn);
//        functions.click(driver, clickuploadbtn);
//        functions.intermediatewait();

//        String roo22 = "document.querySelector(\"body > modal-container > div > div > app-contract-upload-modal > app-modal\").shadowRoot.querySelector(\"#browse-file\")";
//        WebElement browsefilebtn = (WebElement) js.executeScript(roo22);
//
//        functions.click(driver, browsefilebtn);
//        functions.intermediatewait();
//
//        //choosing the file to upload
//        String pdffile = System.getProperty("user.dir");
//
//        StringSelection ss = new StringSelection(
//                pdffile + "\\src\\test\\resources\\DataReader\\Broker Contract Document.pdf");
//
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e2) {
//            // TODO Auto-generated catch block
//            e2.printStackTrace();
//        }
//
//        try {
//            Robot r = new Robot();
//            r.keyPress(KeyEvent.VK_CONTROL);
//            r.keyPress(KeyEvent.VK_V);
//            r.keyRelease(KeyEvent.VK_V);
//            r.keyRelease(KeyEvent.VK_CONTROL);
//
//            r.keyPress(KeyEvent.VK_ENTER);
//            r.keyRelease(KeyEvent.VK_ENTER);
//            Thread.sleep(2000);
//        } catch (AWTException | InterruptedException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//            System.out.println("exception on send attchement");
//        }

        functions.midintermediatewait();

        //upload contract
//        String roo23 = "document.querySelector(\"body > modal-container > div > div > app-contract-upload-modal > app-modal\").shadowRoot.querySelector(\"#browse-file\")";
//        WebElement uploadcontractbtn = (WebElement) js.executeScript(roo23);
//
//        functions.click(driver, uploadcontractbtn);
//        functions.intermediatewait();

        //functions.dealconversion3();
    }

    public String Addlessthan50sites() throws Throwable {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Entering values in Add sites popup
        // Entering sites
        String roo6 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > form > div:nth-child(2) > div > input\")";
        WebElement entersite = (WebElement) js.executeScript(roo6);

        functions.setText(driver, entersite, "1008901022900389800110");
        functions.shortWait();
        // enter srt date
        String roo7 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#contract-start-date\")";
        WebElement srtdate = (WebElement) js.executeScript(roo7);

        functions.setText(driver, srtdate, "11/01/2021");
        functions.shortWait();
//		// enter end date//Need to fix
        String roo8 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#contract-start-date\")";
        WebElement enddate = (WebElement) js.executeScript(roo8);
        functions.setText(driver, enddate, "05/30/2022");
        functions.intermediatewait();
//		// enter billed kwh
//
        String roo9 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > form > div:nth-child(4) > div:nth-child(2) > input\")";
        WebElement billedkwh = (WebElement) js.executeScript(roo9);
        functions.setText(driver, billedkwh, "6000");
        functions.shortWait();
//
//		// File upload Click on browse btn
        String roo10 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#browse-file\")";
        WebElement browsebtn = (WebElement) js.executeScript(roo10);
//		WebElement browsebtn = shadowDom5.findElement(By.cssSelector("#browse-file"));
        functions.click(driver, browsebtn);
        functions.mediumWait();
        // choosing the file to upload
        String pdffile = System.getProperty("user.dir");

        StringSelection ss = new StringSelection(
                pdffile + "\\src\\test\\resources\\DataReader\\Broker Contract Document.pdf");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);

            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
        } catch (AWTException | InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.println("exception on send attchement");
        }

        // click submit btn
        String roo11 = " return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > div.row.pt-3 > div:nth-child(2) > button\")";
        WebElement submitbtn = (WebElement) js.executeScript(roo11);
        js.executeScript("arguments[0].scrollIntoView();", submitbtn);
        functions.click(driver, submitbtn);
        functions.midintermediatewait();

        // Click on validate sites

        String roo12 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#validate-sites\")";
        WebElement validatebtn = (WebElement) js.executeScript(roo12);
        functions.click(driver, validatebtn);
        functions.longWait();
        functions.mediumWait();
        String oportyid = opportunityIDText.getText();

        // Click on continue to pricing
        String roo13 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#continue-to-pricing\")";
        WebElement continuepricingbtn = (WebElement) js.executeScript(roo13);

        functions.click(driver, continuepricingbtn);
        functions.longWait();
        return oportyid;

    }

    public void lessthan50Quotesummary() throws Throwable {
        // filling details in quote summary page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String roo14 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrix-product-name > div > div.row > div.col-9.pr-0 > input\")";
        WebElement productdropdownbtn = (WebElement) js.executeScript(roo14);
        functions.click(driver, productdropdownbtn);
        functions.minwait();
        functions.setText(driver, productdropdownbtn, "FIXED PRODUCT BUNDLED");
        productdropdownbtn.sendKeys(Keys.ENTER);
        functions.shortWait();

//	WebElement termbtn = shadowDom7.findElement(By.cssSelector("#matrix-term"));
        String roo15 = " return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrix-term\")";
        WebElement termbtn = (WebElement) js.executeScript(roo15);
        functions.setText(driver, termbtn, "3");
        functions.shortWait();
        // #matrix-broker-fee-adder


        String roo16 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrix-broker-fee-adder\")";
        WebElement brokerfeebtn = (WebElement) js.executeScript(roo16);
        functions.setText(driver, brokerfeebtn, "5");
        functions.shortWait();
        //WebElement Contractpricebtn = shadowDom7.findElement(By.cssSelector("#matrix-price"));
        String roo17 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrix-price\")";
        WebElement Contractpricebtn = (WebElement) js.executeScript(roo17);
        functions.setText(driver, Contractpricebtn, "72");
        functions.intermediatewait();

        //
        String roo1 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#load-factors > div > div.row > div.col-9.pr-0 > input\")";
        WebElement Loadfactor = (WebElement) js.executeScript(roo1);
        functions.setText(driver, Loadfactor, "Low");
        Loadfactor.sendKeys(Keys.ENTER);
        functions.intermediatewait();


        //Verify Basecharge editable
        String roo70 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#dropdownMenu1\")";
        WebElement Basechargebtn = (WebElement) js.executeScript(roo70);
        functions.click(driver, Basechargebtn);
        functions.shortWait();
        Basechargebtn.sendKeys(Keys.TAB);

        //verify Language preference
        String roo71 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#dropdownMenu1\")";
        WebElement languagebtn = (WebElement) js.executeScript(roo71);
        functions.click(driver, languagebtn);
        functions.shortWait();
        languagebtn.sendKeys(Keys.TAB);


        String roo18 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrixFormEntryScreen > div.row.mt-3 > div:nth-child(1) > button\")";
        WebElement savebtn = (WebElement) js.executeScript(roo18);
        functions.click(driver, savebtn);
        functions.midintermediatewait();
        //// #matrixFormEntryScreen > div.row.mt-3 > div:nth-child(2) > button
        String roo19 = " return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrixFormEntryScreen > div.row.mt-3 > div:nth-child(2) > button\")";
        WebElement proceedtocontractbtn = (WebElement) js.executeScript(roo19);
        functions.click(driver, proceedtocontractbtn);
        functions.intermediatewait();

        String roo20 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-contact > div.form-container > div:nth-child(4) > div:nth-child(2) > button\")";
        WebElement contractgenerationbtn = (WebElement) js.executeScript(roo20);
        functions.click(driver, contractgenerationbtn);
        functions.longWait();
//
//
//	String roo21 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-contracts > div.table-responsive > app-contracts-table > table > tbody > tr.parent-row > td:nth-child(17) > button\")";
//	WebElement clickuploadbtn = (WebElement) js.executeScript(roo21);
//	js.executeScript("arguments[0].scrollIntoView();", clickuploadbtn);
//	functions.click(driver, clickuploadbtn);
//	functions.intermediatewait();
//
//	String roo22 = "document.querySelector(\"body > modal-container > div > div > app-contract-upload-modal > app-modal\").shadowRoot.querySelector(\"#browse-file\")";
//	WebElement browsefilebtn = (WebElement) js.executeScript(roo22);
//
//	functions.click(driver, browsefilebtn);
//	functions.intermediatewait();
//
//	//choosing the file to upload
//	String pdffile = System.getProperty("user.dir");
//
//	StringSelection ss = new StringSelection(
//			pdffile + "\\src\\test\\resources\\DataReader\\Broker Contract Document.pdf");
//
//	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//	try {
//		Thread.sleep(3000);
//	} catch (InterruptedException e2) {
//		// TODO Auto-generated catch block
//		e2.printStackTrace();
//	}
//
//	try {
//		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_V);
//		r.keyRelease(KeyEvent.VK_V);
//		r.keyRelease(KeyEvent.VK_CONTROL);
//
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
//	} catch (AWTException | InterruptedException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//		System.out.println("exception on send attchement");
//	}
//
//	functions.midintermediatewait();
//
//	//upload contract
//	String roo23 = "document.querySelector(\"body > modal-container > div > div > app-contract-upload-modal > app-modal\").shadowRoot.querySelector(\"#browse-file\")";
//	WebElement uploadcontractbtn = (WebElement) js.executeScript(roo23);
//
//	functions.click(driver, uploadcontractbtn);
//functions.intermediatewait();
//
//	functions.dealconversion3();

    }

    public String pccheck(String Optyid) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        System.out.println("passing the string value from AddsitestotheoPty method:" + Optyid);
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();

        // getting all the handles currently available
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        // Wait for UI to finish building
        functions.mediumWait();
        // Go to opportunities tab

        try {
            functions.click(driver, opportunitiesTabsiebel);
        } catch (StaleElementReferenceException e) {
            e.getMessage();
        }

        // Select "all opportunities"
        functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");

        // Wait few seconds for opportunities to refresh

        functions.mediumWait();

        // Query for the opportunity
        functions.click(driver, queryBtn);

        // Wait for query view to appear
        functions.mediumWait();

        Actions actions = new Actions(driver);
        // Press the TAB Key to Switch Focus to Permanent Address
        for (int i = 0; i < 1; i++) {
            actions.sendKeys(Keys.TAB);
            actions.build().perform();
        }

        functions.setText(driver, Opportunityidfield, Optyid);

        // Query for the opportunity by ID

        functions.waitForvisibility(driver, goBtn, 5);

        functions.click(driver, goBtn);

        // Wait for query to finish
        functions.mediumWait();

        // Click somewhere else to be able to click into opportunity
        for (int i = 0; i < 2; i++) {
            actions.sendKeys(Keys.TAB);
            actions.build().perform();
        }
        // Wait for credit review request to appear, then click it

        functions.waitForvisibility(driver, opportunitiesLst, 10);

        // Click into opportunity
        functions.click(driver, opportunitiesLst);
        functions.longWait();
        
        String Status="Pass";
        return Status;
    }
}
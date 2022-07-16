package Pages.OAM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paulhammant.ngwebdriver.NgWebDriver;

import Pages.DSP.LandingPage;
import Pages.DSP.Putsbox;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import apphooks.Base;

public class BPP {
    private Base base;
    LandingPage DspLandingPage = new LandingPage(base);
    Putsbox putsbox = new Putsbox(base);
    CommonFunctions functions = new CommonFunctions();
    ConfigReader config = new ConfigReader();
    Properties prop = config.init_properties();
    NgWebDriver ngWebDriver;
    JavascriptExecutor jsDriver;
    WebDriver driver;

    public BPP(Base base) {
        this.driver = base.driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")
    WebElement sitesComponentCart;
    @FindBy(xpath = "//button[contains(text(), 'Add Site')]")
    WebElement openAddSitesModalBtn;
    @FindBy(xpath = "//textarea[@id='esiids']")
    WebElement sitesTextArea;
    @FindBy(xpath = "//select[@id='customer']")
    WebElement CustomerDropdown;
    @FindBy(xpath = "//button[contains(text(),'Add to Queue')]")
    WebElement AddtoQueueBtn;
    @FindBy(xpath = "//button[contains(text(),' Confirm Site(s)')]")
    WebElement ConfirmSitesBtn;
    @FindBy(xpath = "//button[contains(text(), 'Add Site(s)')]")
    WebElement addSitesBtn;
    @FindBy(xpath = "//button[contains(text(), ' Submit Site(s) ')]")
    WebElement submitSitesBtn;
    @FindBy(xpath = "//th[@class='search']")
    WebElement SearchBtn;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement Searchplaceholder;
    @FindBy(xpath = "//button[contains(text(), 'Clear Filters')]")
    WebElement clearFilterBtn;
    @FindBy(xpath = "//span[@class='icon icon-check brand-success align-middle ng-star-inserted']")
    WebElement ConfirmBtn;
    @FindBy(xpath = "//*[@class='dropdown']/div[@class='form-group customer-search mb-0 ng-tns-c1-1']")
    WebElement Thirdpartyplaceholder;
    @FindBy(xpath = "//p[@class='ng-tns-c1-1 blue']")
    WebElement Thirdpartycard;
    @FindAll(value = { @FindBy(xpath = "//span[@class='icon icon-caret']") })
    public List<WebElement> CustomerBtn;
    @FindBy(xpath = "//p[@class='ng-tns-c1-1 blue']")
    WebElement ThirdpartynameBTn;
    @FindBy(xpath = "//a[@class='dropdown-toggle ng-tns-c1-1']")
    WebElement DropdowntoggleOAM;
    @FindBy(xpath = "//a[contains(text(), 'Pricing')]")
    WebElement pricinglinkOAM;
    @FindBy(xpath = "//a[contains(text(), 'Contact Us')]")
    WebElement contactuslinkOAM;
    @FindAll(value = { @FindBy(xpath = "//div[@class='control__indicator']") })
    public List<WebElement> TermsandconditionsCheckbox;
    @FindBy(xpath = "//div[@class='control__indicator']")
    WebElement TermsandconditionsCheckbox1;
    @FindBy(xpath = "//button[contains(text(), 'Continue')]")
    WebElement ContinueButtonOAM;
    @FindBy(id = "embedded-app-container")
    WebElement shadowelement;
    @FindBy(css = ".btn btn-primary create-quote")
    WebElement CreateNewQuote;
    @FindBy(xpath = "//input[@class='form-control ng-valid ng-dirty ng-touched']")
    WebElement customernamefield;
    @FindBy(xpath = "//div[contains(text(),'Add Additional Customers')]")
    WebElement AddadditionalcustomerBTn;
    @FindBy(xpath = "//p[@class='dropdown-select name-styling']")
    WebElement customerFirstcard;
    @FindBy(xpath = "//button[@class='btn btn-primary p-0 mr-5 ng-star-inserted']")
    WebElement SelectHUfileBTn;
    @FindBy(css = "btn btn-primary mb-3 ng-star-inserted")
    WebElement ContinuetoAddsites;
    @FindBy(xpath = "//button[contains(text(), ' Validate Sites')]")
    WebElement Validatesites;
    @FindBy(xpath = "//button[contains(text(), ' Continue to Pricing')]")
    WebElement continuetopricing;
    @FindBy(xpath = "//button[@id='details-button']")
    WebElement AdvancedButton;
    @FindBy(xpath = "//a[@id='proceed-link']")
    WebElement proceedlink;
    @FindBy(xpath = "//button[@class='btn btn-primary p-0 mr-5 ng-star-inserted']")
    WebElement fileupload;
    @FindBy(xpath = "//input[@placeholder='Search by ID or name...']")
    WebElement ele;
    @FindBy(xpath = "//div[@id='navbar-2']")
    WebElement adk;
    @FindBy(xpath = "//span[@class='icon icon-caret']")
    WebElement logdropdown;
    @FindBy(xpath = "//*[@id=\"brand-navigation\"]/ul/li[2]/ul/li[2]/a")
    WebElement logout;
    @FindBy(xpath = "//a[@id='logAgain']")
    WebElement login;
    @FindBy(xpath = "//input[@id='user']")
    WebElement OAMEmail;
    @FindBy(xpath = "//input[@id='password']")
    WebElement OAMPassword;
    @FindBy(xpath = "//a[@id='logAgain']")
    WebElement OAMLoginButton1;
    @FindBy(xpath = "//ngb-alert[@class='alert alert-danger confirm-sites-alert alert-warning']")
    WebElement InvalidSitesMessage;
    @FindBy(xpath = "//a[@id='signin']")
    WebElement OAMLoginButton;
    @FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
    WebElement opportunityIDText;
    /*
     * Selecting third party partner
     */

    public void selectAggregatorThirdParty(String Thirdparty) throws Throwable {

        //Wait for Sometime
        functions.intermediatewait();

        //Click on Customer Button
        CustomerBtn.get(1).click();

        //Enter Third Party in the Place holder
        functions.setText(driver, ele, Thirdparty);
        ele.sendKeys(Keys.RETURN);

        //Wait for Sometime
        functions.shortWait();
    }
    /*
     * Create New Quote
     */
    public void AddnewOpportunity() throws Throwable {


        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Clicking on create new Quote
        String roo14 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quotes > div.content > div:nth-child(1) > div > div > a:nth-child(3)\")";
        WebElement createquote = (WebElement) js.executeScript(roo14);

        functions.click(driver, createquote);
        functions.shortWait();

    }


    public String Addsites() throws Throwable {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Entering values in Add sites popup

        functions.midWait();
        String roo15 = " return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-sites > div.row.mt-4.justify-content-between.ng-star-inserted > div.col-auto > div > div.d-inline-block.align-top.pt-2 > button:nth-child(3) > span\")";
        WebElement billcopybtn = (WebElement) js.executeScript(roo15);
        functions.click(driver, billcopybtn);
        functions.midWait();



        //document.querySelector("body > modal-container > div > div > app-add-sites-modal > app-modal").shadowRoot.querySelector("div > div.modal-body > div > div.row.mb-4 > div > ul > li:nth-child(4) > a")
        // Entering sites
        String roo6 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > form > div:nth-child(2) > div > input\")";
        WebElement entersite = (WebElement) js.executeScript(roo6);

        functions.setText(driver, entersite, "	10443720000262550");
        functions.shortWait();
        // enter srt date
        String roo7 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#contract-start-date\")";
        WebElement srtdate = (WebElement) js.executeScript(roo7);

        functions.setText(driver, srtdate, "11/01/2021");
        functions.shortWait();
//	// enter end date//Need to fix
        String roo8 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#contract-start-date\")";
        WebElement enddate = (WebElement) js.executeScript(roo8);
//	functions.setText(driver, enddate, "11/30/2021");
        functions.intermediatewait();
//	// enter billed kwh
//
        String roo9 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > form > div:nth-child(4) > div:nth-child(2) > input\")";
        WebElement billedkwh = (WebElement) js.executeScript(roo9);
        functions.setText(driver, billedkwh, "6000");
        functions.shortWait();
//
//	// File upload Click on browse btn
        String roo10 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#browse-file\")";
        WebElement browsebtn = (WebElement) js.executeScript(roo10);
//	WebElement browsebtn = shadowDom5.findElement(By.cssSelector("#browse-file"));
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
        WebElement  validatebtn = (WebElement) js.executeScript(roo12);
        functions.click(driver, validatebtn);
        functions.longWait();
        functions.mediumWait();

        String roo14 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.header > div.float-left > div > form > b > div > span:nth-child(1) > span\")";
        WebElement opportunityIDText = (WebElement) js.executeScript(roo14);
//
        String oportyid = opportunityIDText.getText();

        // Click on continue to pricing
        String roo13 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#continue-to-pricing\")";
        WebElement  continuepricingbtn = (WebElement) js.executeScript(roo13);

        functions.click(driver, continuepricingbtn);
        functions.mediumWait();
        return  oportyid ;
    }
    public String Quotesummary() throws Throwable {
        // filling details in quote summary page
        JavascriptExecutor js = (JavascriptExecutor) driver;
//	WebElement root7 = driver.findElement(By.tagName("app-broker-pricing"));
//	WebElement shadowDom7 = (WebElement) js.executeScript("return arguments[0].shadowRoot", root7);
//	WebElement productdropdownbtn = shadowDom7
//			.findElement(By.cssSelector("#matrix-product-name > div > div.row > div.col-9.pr-0 > input"));
        String roo14 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrix-product-name > div > div.row > div.col-9.pr-0 > input\")";
        WebElement  productdropdownbtn = (WebElement) js.executeScript(roo14);
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
        WebElement  brokerfeebtn = (WebElement) js.executeScript(roo16);
        functions.setText(driver, brokerfeebtn, "5");
        functions.shortWait();
        //WebElement Contractpricebtn = shadowDom7.findElement(By.cssSelector("#matrix-price"));
        String roo17 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#matrix-price\")";
        WebElement  Contractpricebtn = (WebElement) js.executeScript(roo17);
        functions.setText(driver, Contractpricebtn, "72");
        functions.intermediatewait();

        //
        String roo1 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#load-factors > div > div.row > div.col-9.pr-0 > input\")";
        WebElement Loadfactor = (WebElement) js.executeScript(roo1);
        functions.setText(driver, Loadfactor, "Low");
        Loadfactor.sendKeys(Keys.ENTER);
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
        
        String Status="Pass";
        return Status;

    }

    public void ContractandBilling() throws Throwable{
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String roo1 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#first-name\")";
        WebElement  Firstname = (WebElement) js.executeScript(roo1);
        functions.setText(driver,  Firstname , "test");
        functions.shortWait();

        String roo2 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#last-name\")";
        WebElement  lastname = (WebElement) js.executeScript(roo2);
        functions.setText(driver,  lastname , "test");
        functions.shortWait();

        String roo3 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#contact-email\")";
        WebElement  email = (WebElement) js.executeScript(roo3);
        functions.setText(driver, email , "sridhar.dhusa@nrg.com");
        functions.shortWait();

        String roo4 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#phone\")";
        WebElement  phone = (WebElement) js.executeScript(roo4);
        functions.setText(driver, phone , "(412)111-1111");
        functions.shortWait();

        String roo5 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#notice-address\")";
        WebElement  NoticeAddress = (WebElement) js.executeScript(roo5);
        functions.setText(driver, NoticeAddress , "12 greenway plaza");
        functions.shortWait();

        String roo6 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#zip\")";
        WebElement  zip = (WebElement) js.executeScript(roo6);
        functions.setText(driver, zip , "77081");
        functions.shortWait();

        String roo7 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#city\")";
        WebElement  city = (WebElement) js.executeScript(roo7);
        functions.setText(driver, city , "Houston");
        functions.shortWait();

        String roo8 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-contact > div.form-container > form > div:nth-child(5) > div:nth-child(2) > app-dropdown > div > div.row > div.col-9.pr-0 > input\")";
        WebElement  state = (WebElement) js.executeScript(roo8);
        functions.setText(driver, state , "TX");
        state.sendKeys(Keys.ENTER);
        functions.intermediatewait();

        String roo9 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-contact > div.form-container > div:nth-child(4) > div:nth-child(1) > button\")";
        WebElement ADDcontacttocustomerbtn = (WebElement) js.executeScript(roo9);
        functions.click(driver, ADDcontacttocustomerbtn);
        functions.shortWait();

        String roo10 = "return document.querySelector(\"body > modal-container > div > div > app-address-validation-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div.row.button-row > div > div > button\")";
        WebElement useselectedaddress = (WebElement) js.executeScript(roo10);
        functions.click(driver,  useselectedaddress);
        functions.shortWait();



        String roo20 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-contact > div.form-container > div:nth-child(4) > div:nth-child(2) > button\")";
        WebElement contractgenerationbtn = (WebElement) js.executeScript(roo20);
        functions.click(driver, contractgenerationbtn);
        functions.longWait();
//

        String roo21 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-contracts > div.table-responsive > app-contracts-table > table > tbody > tr.parent-row > td:nth-child(17) > button\")";
        WebElement clickuploadbtn = (WebElement) js.executeScript(roo21);
        js.executeScript("arguments[0].scrollIntoView();", clickuploadbtn);
        functions.click(driver, clickuploadbtn);
        functions.intermediatewait();

        String roo22 = "document.querySelector(\"body > modal-container > div > div > app-contract-upload-modal > app-modal\").shadowRoot.querySelector(\"#browse-file\")";
        WebElement browsefilebtn = (WebElement) js.executeScript(roo22);

        functions.click(driver, browsefilebtn);
        functions.intermediatewait();

        //choosing the file to upload
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

        functions.midintermediatewait();

        //upload contract
        String roo23 = "document.querySelector(\"body > modal-container > div > div > app-contract-upload-modal > app-modal\").shadowRoot.querySelector(\"#browse-file\")";
        WebElement uploadcontractbtn = (WebElement) js.executeScript(roo23);

        functions.click(driver, uploadcontractbtn);
        functions.intermediatewait();

        functions.dealconversion3();
    }

}

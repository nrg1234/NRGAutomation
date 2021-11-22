package Pages.DSP;

import Utilities.CommonFunctions;
import apphooks.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DelayedStartDatefortheSites {
    WebDriver driver;
    @FindBy(xpath = "//a[contains(text(),'Staggered Sites')]")
    WebElement StaggeredsitesBtn;
    @FindBy(xpath = "//span[@class='icon icon-pencil brand-primary align-middle']")
    WebElement EditButton;
    @FindBy(xpath = "//span[@class='mat-button-wrapper']")
    WebElement calendarbtn;
    @FindBy(xpath = "//div[contains(text(),'DEC')]")
    WebElement monthSelector;
    @FindBy(xpath = "//span[@class='icon icon-check brand-success align-middle ng-star-inserted']")
    WebElement ConfirmBtn;
    public DelayedStartDatefortheSites(Base base) {
        this.driver = Base.driver;
        PageFactory.initElements(driver, this);
    }

    //div[@class='mat-calendar-body-cell-content']


    /*
     * Delay Start Date for the Sites
     */

    public void Staggeredsites() throws Throwable {

        CommonFunctions functions = new CommonFunctions();

        // Click Staggeredsites button
        functions.click(driver, StaggeredsitesBtn);


        // Click Editsites button
        functions.click(driver, EditButton);

        // Wait for sometime
        functions.shortWait();

        // Click Calendar button
        functions.click(driver, calendarbtn);

        // Wait for sometime
        functions.shortWait();

        // Select month
        functions.click(driver, monthSelector);

        // Wait for sometime
        functions.shortWait();

        // Click Confirm Button
        functions.click(driver, ConfirmBtn);


    }


}

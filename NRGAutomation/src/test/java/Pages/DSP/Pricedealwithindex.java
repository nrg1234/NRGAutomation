package Pages.DSP;
import java.util.List;
import apphooks.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Pricedealwithindex {
	WebDriver driver;

	public Pricedealwithindex(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(), 'Quotes')]")
	WebElement quotesTAB;

	@FindBy(xpath = "//*[@id='quotesLoader']")
	WebElement quotesLoader;

	@FindBy(xpath = "//span[contains(text(), 'See Details')]")
	WebElement seeDetails;

	@FindBy(xpath = "//button[@id='bp-visible-switch']")
	WebElement brokerVisibletoggle;

	@FindBy(xpath = "//a[contains(text(), 'Index')]")
	WebElement indexTAB;

	@FindBy(xpath = "//input[@id='mat-input-12']")
	WebElement marginfield;

	@FindBy(xpath = "//input[@id='mat-input-13']")
	WebElement doaMarginfield;

	@FindBy(xpath = "//button[contains(text(), 'Calculate and Save')]")
	WebElement calculateAndSave;

	@FindAll(value = { @FindBy(xpath = "//span[contains(text(), 'Select')]") })
	public List<WebElement> productSelectBtn;

	@FindBy(xpath = "//li[@class='ng-star-inserted active']//a[contains(text(), 'Index')]")
	WebElement IndexPriceBtn;

	public Pricedealwithindex(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}

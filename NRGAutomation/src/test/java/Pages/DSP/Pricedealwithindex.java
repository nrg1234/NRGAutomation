package Pages.DSP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;

public class Pricedealwithindex extends Library {
    LandingPage Dsp = new LandingPage(driver);
 


public Pricedealwithindex (WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);

}


}

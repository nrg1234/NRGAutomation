package Pages.Siebel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;
import Pages.DSP.LandingPage;

public class ValidatelossesSeibel extends Library {
    LandingPage Dsp = new LandingPage(driver);
 


public ValidatelossesSeibel (WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);

}




}

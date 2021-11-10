package Pages.VHOS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;
import Pages.DSP.LandingPage;

public class ValidatelossesVhos extends Library {
    LandingPage Dsp = new LandingPage(driver);
 


public ValidatelossesVhos (WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}




 

}

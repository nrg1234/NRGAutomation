package Pages.DSP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;

public class Validatequotepricing extends Library {
    LandingPage Dsp = new LandingPage(driver);
 


public Validatequotepricing (WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}




}



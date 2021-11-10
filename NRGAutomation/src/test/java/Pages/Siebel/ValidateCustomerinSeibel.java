package Pages.Siebel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;
import Pages.DSP.LandingPage;

public class ValidateCustomerinSeibel extends Library {
    LandingPage Dsp = new LandingPage(driver);
 


public ValidateCustomerinSeibel(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}




}
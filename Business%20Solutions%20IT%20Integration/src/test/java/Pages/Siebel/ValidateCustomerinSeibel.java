package Pages.Siebel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Pages.DSP.LandingPage;

public class ValidateCustomerinSeibel {
    
 

WebDriver driver;
public ValidateCustomerinSeibel(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}




}
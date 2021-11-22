package Pages.DSP;

import apphooks.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Validatequotepricing {

    WebDriver driver;

    public Validatequotepricing(Base base) {
        this.driver = Base.driver;
        PageFactory.initElements(driver, this);
    }
}



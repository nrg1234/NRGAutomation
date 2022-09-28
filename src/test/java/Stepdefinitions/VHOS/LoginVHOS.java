package Stepdefinitions.VHOS;

import java.util.Properties;

import Pages.VHOS.LoginVhos;
import Utilities.ConfigReader;
import apphooks.Base;
import io.cucumber.java.en.When;

public class LoginVHOS extends Base {

    private Base base;
    public LoginVHOS(Base base) {
        this.base = base;
    }

    Utilities.CommonFunctions encrypted = new Utilities.CommonFunctions();
    LoginVhos login = new LoginVhos(base);
    ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	String browser = prop.getProperty("browser");

    @When("VHOS: Login to VHOS as Sales Person")
    public void Login_to_VHOS_as_Sales_Person() throws Throwable {
        login.loginVhos(browser);
        System.out.println("Login to Vhos is Successful");
    }
}


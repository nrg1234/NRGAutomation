package Stepdefinitions.VHOS;

import Pages.VHOS.Login;
import apphooks.Base;
import io.cucumber.java.en.When;

public class LoginVHOS extends Base {

    private Base base;
    public LoginVHOS(Base base) {
        this.base = base;
    }

    Utilities.CommonFunctions encrypted = new Utilities.CommonFunctions();
    Login login = new Login(base);

    @When("VHOS: Login to VHOS as Sales Person")
    public void Login_to_VHOS_as_Sales_Person() throws Throwable {
        login.loginVhos();
        System.out.println("Login to Vhos is Successful");
    }
}


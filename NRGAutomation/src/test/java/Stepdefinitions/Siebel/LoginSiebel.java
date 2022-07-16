package Stepdefinitions.Siebel;
import Pages.Siebel.Login;
import apphooks.Base;
import io.cucumber.java.en.When;

public class LoginSiebel extends Base {

    private Base base;
    public LoginSiebel(Base base) {
        this.base = base;
    }

    String password;
    Utilities.CommonFunctions encrypted = new Utilities.CommonFunctions();
    Login login = new Login(base);

    @When("SIEBEL: Login to Siebel as BA")
    public void Login_to_Siebel_as_BA() throws Throwable {
        password = encrypted.Encryption();
        login.LoginSiebel(password);
        System.out.println("Login to Sibel is Successful");
    }
    
   
    @When("SIEBEL: Login to Siebel again as BA")
    public void Login_to_Siebel_again_as_BA() throws Throwable {
        password = encrypted.Encryption();
        login.LoginSiebelforcontract(password);
        System.out.println("Login to Sibel is Successful");
    }
    
    
    
}


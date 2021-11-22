package Pages.Siebel;
import Utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class PasswordEncryption  {

WebDriver driver;
    public PasswordEncryption(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String Encryption() throws IOException {
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();
        String encPass = prop.getProperty("SiebelPassword");
        System.out.println(encPass);

        byte[] decpass = Base64.getDecoder().decode(encPass);

        String passNew = new String(decpass);
        System.out.println(passNew);

        //Storing and Returning the text into a String
        final String encryptedpassword = passNew;
        System.out.println(encryptedpassword);
        return encryptedpassword;

    }


}

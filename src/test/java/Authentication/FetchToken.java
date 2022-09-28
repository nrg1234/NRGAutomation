package Authentication;
import java.io.FileWriter;

import java.io.IOException;

import org.jboss.aerogear.security.otp.Totp;

public class FetchToken {

    public FetchToken() {

    }



    public String getOtp(String token) {

        Totp totp = new Totp(token);

        try {

            FileWriter myWriter = new FileWriter("token.txt");

            myWriter.write(totp.now());

            myWriter.close();

            return totp.now();

        } catch (IOException var4) {

            System.out.println("An error occurred.");

            var4.printStackTrace();

            return "Exception";

        }

    }
}


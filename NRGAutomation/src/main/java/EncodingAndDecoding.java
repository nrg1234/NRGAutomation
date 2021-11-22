import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

public class EncodingAndDecoding  {

    /**.
     * This Method is used to Encode Password String
     */
    public static void main(final String[] args) throws IOException {

        System.out.println("Enter the password to Encrypt : ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pass = reader.readLine();
        String encPass = Base64.getEncoder().encodeToString(pass.getBytes());
        System.out.println("Encrypted Password : " + encPass);

    }

}

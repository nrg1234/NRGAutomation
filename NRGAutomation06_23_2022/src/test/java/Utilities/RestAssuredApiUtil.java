package Utilities;

	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import org.apache.commons.io.IOUtils;
	import org.apache.log4j.Logger;

	import io.restassured.RestAssured;
	import io.restassured.response.Response;

	public class RestAssuredApiUtil {

		private Logger log = Logger.getLogger(RestAssuredApiUtil.class);
		private ConfigReader properties = new ConfigReader();
		private Properties prop = properties.init_properties();

		public void postRequest(String endpointUri, String requestXmlPath) {
			FileInputStream fs;
			try {
				fs = new FileInputStream(requestXmlPath);
				String username = prop.getProperty("qaApiUsername");
				String password = prop.getProperty("qaApiPassword");
				String environment = prop.getProperty("environment");
				RestAssured.baseURI = prop.getProperty("qaApiBaseUri").replace("_environment_", environment);
				given()
					.header("SOAPAction", "https://urldefense.com/v3/__http://otc.customer.integration.mas.wm.com/*22).and(__;JQ!!BJC6uDBu-zY!bdNUZu5B2pxQ5j6JAJ-qvilEH7VgkAE2_av0trIbsk7vbxcEqGf26eMWbaVEoMmE$")
					.auth().preemptive().basic(username, password).and()
					.body(IOUtils.toString(fs, "UTF-8")).
				when()
					.post(endpointUri).
				then()
					.statusCode(200)
					.log().all();
			} catch (IOException e) {
				log.error("Error in POST api call. " + e.getStackTrace());
			}
		}
		
		public String getRequest(String endpointUri) {
			String responseBody = "";
			Response response = null;
			try {
				String username = prop.getProperty("qaApiUsername");
				String password = prop.getProperty("qaApiPassword");
				String environment = prop.getProperty("environment");
				RestAssured.baseURI = prop.getProperty("qaApiBaseUri").replace("_environment_", environment);
				response = given()
					.header("SOAPAction", "https://urldefense.com/v3/__http://otc.customer.integration.mas.wm.com/*22).and(__;JQ!!BJC6uDBu-zY!bdNUZu5B2pxQ5j6JAJ-qvilEH7VgkAE2_av0trIbsk7vbxcEqGf26eMWbaVEoMmE$")
					.auth().preemptive().basic(username, password).
				when()
					.get(endpointUri);			
				responseBody = response.asPrettyString();
//				log.info("Response body: " + responseBody);
			} catch (Exception e) {
				log.error("Error in GET api call. " + e.getStackTrace());
			}
			return responseBody;
		}

	}


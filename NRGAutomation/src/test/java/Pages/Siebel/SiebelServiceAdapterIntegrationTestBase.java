package Pages.Siebel;

//
//	import com.nrg.dsp.config.SiebelConfig;
//
//	import java.io.FileInputStream;
//	import java.io.FileNotFoundException;
//	import java.io.IOException;
//	import java.util.Properties;
//
//
//
//	/**
//	 * @author adrian.moga
//	 *
//	 * Superclass for all SiebelServiceAdapter integration tests. Performs initial setup and
//	 * configuration of the SiebelServiceAdapter.
//	 */
//	public class SiebelServiceAdapterIntegrationTestBase {
//
//		/**
//		 * Gets the Siebel service URL from the application.properties file in the src/test/resources/
//		 * directory.
//		 *
//		 * @return the Siebel service URL
//		 */
//		private String getSiebelServiceUrl() {
//			String propertiesRootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//			String appPropertiesPath = propertiesRootPath + "adapter.urls.properties";
//
//			Properties props = new Properties();
//			try {
//				props.load(new FileInputStream(appPropertiesPath));
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//				System.exit(1);
//			} catch (IOException e) {
//				e.printStackTrace();
//				System.exit(1);
//			}
//
//			return props.getProperty("siebel.service.url");
//		}
//
//		/**
//		 * Performs initial setup before each test. Creates new SiebelConfig object,
//		 * sets appropriate service URL, and initializes SiebelServiceAdapter to
//		 * be tested. Returns the SiebelServiceAdapter
//		 */
//		public SiebelServiceAdapter initAdapter() {
//			String siebelServiceUrl = getSiebelServiceUrl();
//			SiebelConfig config = new SiebelConfig();
//			config.setServiceUrl(siebelServiceUrl);
//			return new SiebelServiceAdapter(config);
//		}
//
//	}
//
//}

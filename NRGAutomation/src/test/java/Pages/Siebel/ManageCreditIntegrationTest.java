package Pages.Siebel;
//
//	import static org.junit.Assert.*;
//
//	import java.util.Arrays;
//	import java.util.List;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.siebel.xml.roe_20cut_20credit_20management.data.CutCreditAlertData;
//
//	import static com.nrg.dsp.service.adapter.siebel.SiebelServiceAdapterIntegrationTestUtils.*;
//
//	/**
//	 * @author adrian.moga
//	 * 
//	 * This class tests the manage credit functionality of the SiebelServiceAdapter.
//	 * Specifically, tests the ability to create a credit alert, fetch credit alerts,
//	 * and get credit aggregation score.
//	 */
//	public class ManageCreditIntegrationTest extends SiebelServiceAdapterIntegrationTestBase {
//		
//		/**
//		 * SiebelServiceAdapter being tested.
//		 */
//		private SiebelServiceAdapter adapter;
//		
//		/**
//		 * Performs initial setup before each test. Creates new SiebelConfig object,
//		 * sets appropriate service URL, and initializes SiebelServiceAdapter to
//		 * be tested.
//		 */
//		@Before
//		public void setup() {
//			adapter = super.initAdapter();
//		}
//		
//		/**
//		 * Positive test for creating credit alerts. Passes valid customer ID and
//		 * opty ID, and expects a valid credit alert ID.
//		 */
//		@Test
//		public void createCreditAlertValidFields() {
//			String customerId = "1-1075FA3";
//			String optyId = "1-1075FBB";
//			try {
//				String creditAlertId = adapter.createCreditAlert(customerId, optyId);
//				assertFalse("Create credit alert with valid fields should not return null", 
//						creditAlertId == null);
//				assertFalse("Create credit alert with valid fields should not return empty "
//						+ "credit alert ID", creditAlertId.isEmpty());
//			} catch (SiebelException e) {
//				fail("SiebelException when creating credit alert with valid fields | "
//						+ "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * Negative test for creating credit alert. Passes Strings representing
//		 * invalid customer ID and opty ID, and expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void createCreditAlertInvalidFields() {
//			String customerId = StringUtils.randomAlphanumericString(8).toUpperCase();
//			String optyId = StringUtils.randomAlphanumericString(8).toUpperCase();
//			try {
//				adapter.createCreditAlert(customerId, optyId);
//				// If we reach this, then there was no exception
//				fail("Expected SiebelException when creating credit alert with invalid fields");
//			} catch(SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Negative test for creating credit alert. Passes empty Strings, 
//		 * and expects a SiebelException to tbe thrown.
//		 */
//		@Test
//		public void createCreditAlertEmptyFields() {
//			String customerId = "";
//			String optyId = "";
//			try {
//				adapter.createCreditAlert(customerId, optyId);
//				// If we reach this, then there was no exception
//				fail("Expected SiebelException when creating credit alert with empty fields");
//			} catch(SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Positive test for fetching credit alerts. Passes a String representing a
//		 * valid opty ID, and expects no exception to be thrown.
//		 */
//		@Test
//		public void fetchCreditAlertsValidOptyId() {
//			String optyId = "1-10C84JL";
//			try {
//				List<CutCreditAlertData> creditAlertDataList = adapter.fetchCreditAlerts(optyId);
//				assertFalse("Fetch credit alerts should not be null for valid opty ID", 
//						creditAlertDataList == null);
//			} catch (SiebelException e) {
//				fail("SiebelException when fetching credit alerts with valid opty ID | "
//						+ "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * Negative test for fetching credit alerts. Passes a String representing an
//		 * invalid opty ID, and expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void fetchCreditAlertsInvalidOptyId() {
//			String optyId = StringUtils.randomAlphanumericString(7).toUpperCase();
//			try {
//				List<CutCreditAlertData> creditAlertDataList = adapter.fetchCreditAlerts(optyId);
//				// Ensure that the returned list is not null and empty
//				assertFalse("Fetch credit alerts should not return null for invalid otpy ID", 
//						creditAlertDataList == null);
//				assertTrue("Getch credit alerts should return an empty list for invalid opty ID", 
//						creditAlertDataList.isEmpty());
//			} catch (SiebelException e) {
//				fail("SiebelException when fetching credit alerts for invalid opty ID | "
//						+ "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * Negative test for fetching credit alerts. Passes an empty String 
//		 * representing an opty ID, and expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void fetchCreditAlertsEmptyOptyId() {
//			String optyId = "";
//			try {
//				List<CutCreditAlertData> creditAlertDataList = adapter.fetchCreditAlerts(optyId);
//				// Ensure that the returned list is not null and empty
//				assertFalse("Fetch credit alerts should not return null for empty otpy ID", 
//						creditAlertDataList == null);
//				assertFalse("Getch credit alerts should not return an empty list for empty opty ID", 
//						creditAlertDataList.isEmpty());
//			} catch (SiebelException e) {
//				fail("SiebelException when fetching credit alerts for empty opty ID | "
//						+ "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * Positive test for getting credit aggregation score. Passes a valid list of Strings
//		 * representing Siebel customer IDs and a String representing a valid opty ID. 
//		 * Expects a valid aggregate credit score.
//		 */
//		@Test
//		public void getCreditAggregationScoreValidFields() { // TODO figure out this error
//			List<String> customerIds = Arrays.asList("1-109UAB5");
//			String optyId = "1-109UACD";
//			try {
//				String aggScore = adapter.getCreditAggregationScore(customerIds, optyId);
//				assertFalse("Getting credit aggregation score should not return null for vald inputs", 
//						aggScore == null);
//				assertFalse("Getting credit aggregation score should not return empty aggregate credit score", 
//						aggScore.isEmpty());
//			} catch (SiebelException e) {
//				fail("SiebelException when getting credit aggregation score for valid customers "
//						+ "with valid opty ID | Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * Negative test for getting credit aggregation score. Passes a list of Strings
//		 * representing invalid customer IDs, and an invalid opty ID. Expects a 
//		 * SiebelException to be thrown.
//		 */
//		@Test
//		public void getCreditAggregationScoreInvalidFields() {
//			List<String> customerIds = Arrays.asList(StringUtils.randomAlphanumericString(8).toUpperCase());
//			String optyId = StringUtils.randomAlphanumericString(8).toUpperCase();
//			try {
//				adapter.getCreditAggregationScore(customerIds, optyId);
//				// If we reach thins, then there was no exception
//				fail("Expected SiebelException when getting credit aggregation score with invalid inputs");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Negative test for getting credit aggregation score. Passes a list of empty
//		 * Strings representing empty customer IDs, and an empty opty ID. Expects a 
//		 * SiebelException to be thrown.
//		 */
//		@Test
//		public void getCreditAggregationScoreEmptyFields() {
//			List<String> customerIds = Arrays.asList("");
//			String optyId = "";
//			try {
//				adapter.getCreditAggregationScore(customerIds, optyId);
//				// If we reach thins, then there was no exception
//				fail("Expected SiebelException when getting credit aggregation score with invalid inputs");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//
//	}


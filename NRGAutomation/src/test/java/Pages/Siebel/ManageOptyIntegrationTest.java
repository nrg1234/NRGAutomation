package Pages.Siebel;
//
//
//	import org.junit.*;
//	import static org.junit.Assert.*;
//
//	import com.nrg.dsp.domain.Customer;
//	import com.nrg.dsp.domain.Opportunity;
//
//	import static com.nrg.dsp.service.adapter.siebel.SiebelServiceAdapterIntegrationTestUtils.*;
//
//	/**
//	 * @author adrian.moga
//	 * 
//	 * This class tests the manage opty functionality of the SiebelServiceAdapter. Specifically,
//	 * tests the ability to create or update an opty.
//	 */
//	public class ManageOptyIntegrationTest extends SiebelServiceAdapterIntegrationTestBase {
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
//		 * Positive test for creating and updating an opty, and managing the sales team. Passes a 
//		 * valid user ID, Opportunity, Customer, and status reason; and expects a valid opty ID to be
//		 * returned. Then, uses the opty ID to update the Opportunity; expects a valid opty ID to 
//		 * be returned again. Then, tries to manage the sales team by updating the opty EMA and EMM;
//		 * expects a valid return status.
//		 */
//		@Test
//		public void createUpdateManageSalesTeamAndCancelOptyValidInputs() {
//			// Create a valid opportunity
//			String userId = "amoga59";
//			Opportunity opty = createRandomValidNewOpportunity();
//			Customer customer = createCustomer("1-7JJ06", "Technology");
//			
//			String optyId = null;
//			try {
//				optyId = adapter.createOrUpdateOpty(userId, opty, customer);
//			} catch (SiebelException e1) {
//				fail("SiebelException when creating opportunity with valid fields: " + e1.getErrorMessage());
//			}
//			
//			assertFalse("Create opty should not return null for valid fields", optyId == null);
//			assertFalse("Create opty should not return empty opty ID for valid fields", 
//					optyId.isEmpty());
//			
//			// Update opportunity using returned opty ID
//			opty.setExternalId(optyId);
//			opty.setName(StringUtils.randomAlphanumericString(15)); // update opty name
//			
//			try {
//				optyId = adapter.createOrUpdateOpty(userId, opty, customer);
//			} catch (SiebelException e1) {
//				fail("SiebelException when updating an opty with valid fields: " + e1.getErrorMessage());
//			}
//			
//			assertFalse("Update opty should not return null for valid fields", optyId == null);
//			assertFalse("Update opty should not return empty opty ID for valid fields", optyId.isEmpty());
//			
//			// Try to manage opportunity sales team
//			String ema = "narriaga";
//			String emm = "zstarns1";
//			String manageSalesTeamResult = null;
//			
//			try {
//				manageSalesTeamResult = adapter.manageSalesTeam(optyId, ema, emm);
//			} catch (SiebelException e) {
//				fail("SiebelException when managing sales team for valid opty | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			assertFalse("Manage sales team result should not be null for valid inputs", 
//					manageSalesTeamResult == null);
//			assertFalse("Manage sales team result should not be empty for valid inputs", 
//					manageSalesTeamResult.isEmpty());
//			
//			// Cancel opportunity
//			opty.setSiebelStatus(Opportunity.SIEBEL_STATUS_CANCELLED);
//			
//			try {
//				optyId = adapter.createOrUpdateOpty(userId, opty, customer, "Inadvertently created");
//			} catch (SiebelException e) {
//				fail("SiebelException when cancelling opty with valid fields: " + e.getErrorMessage());
//			}
//			
//			assertFalse("Cancel opty should not return null for valid fields", optyId == null);
//			assertFalse("Cancel opty should not return empty ID for valid fields", optyId.isEmpty());
//		}
//		
//		/**
//		 * Negative test for creating an opty. Passes invalid user ID, Opportunity, Customer,
//		 * and status reason; i.e. the values are all made up. Expects a null opty ID to be 
//		 * returned.
//		 */
//		@Test
//		public void createOptyInvalidInputs() {
//			String userId = StringUtils.randomStringAllLower(10);
//			Opportunity opty = createRandomInvalidNewOpportunity();
//			Customer customer = createCustomer(StringUtils.randomNumber(10), StringUtils.randomName(15));
//			String statusReason = StringUtils.randomAlphanumericString(25);
//			
//			String optyId = null;
//			try {
//				optyId = adapter.createOrUpdateOpty(userId, opty, customer, statusReason);
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//			
//			fail("Expected SiebelException when creating opty with invalid inputs");
//		}
//		
//		/**
//		 * Negative test for Canceling an opty. Passes invalid user ID, Opportunity, Customer,
//		 * and status reason; i.e. the values are all made up. Expects a null opty ID to be 
//		 * returned.
//		 */
//		@Test(expected=javax.xml.ws.WebServiceException.class)
//		public void cancelOptyInvalidInputs() {
//			String userId = StringUtils.randomStringAllLower(10);
//			Opportunity opty = createRandomInvalidNewOpportunity();
//			opty.setExternalId(StringUtils.randomAlphanumericString(7).toUpperCase());
//			opty.setSiebelStatus(Opportunity.SIEBEL_STATUS_CANCELLED);
//			Customer customer = createCustomer(StringUtils.randomNumber(10), StringUtils.randomName(15));
//			String statusReason = "Inadvertently created";
//			
//			String optyId;
//			try {
//				optyId = adapter.createOrUpdateOpty(userId, opty, customer, statusReason);
//			} catch (SiebelException e) {
//				// Exception expected
//			}
//			
//			fail("Expected SiebelException when canceling opty with invalid inputs");
//		}
//		
//		/**
//		 * Negative test for updating an opty. Passes invalid user ID, Opportunity, Customer,
//		 * and status reason; i.e. the values are all made up. Expects a null opty ID to be 
//		 * returned.
//		 */
//		@Test(expected=javax.xml.ws.WebServiceException.class)
//		public void updateOptyInvalidInputs() {
//			String userId = StringUtils.randomStringAllLower(10);
//			Opportunity opty = createRandomInvalidNewOpportunity();
//			opty.setExternalId(StringUtils.randomAlphanumericString(7).toUpperCase());
//			Customer customer = createCustomer(StringUtils.randomNumber(10), StringUtils.randomName(15));
//			String statusReason = StringUtils.randomAlphanumericString(25);
//			
//			String optyId;
//			try {
//				optyId = adapter.createOrUpdateOpty(userId, opty, customer, statusReason);
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//			
//			fail("Expected SiebelException when updating opty with invalid inputs");
//		}
//		
//		/**
//		 * Negative test for managing sales team. Passes invalid opty ID, EMA, and EMM, i.e.
//		 * the values are all made up. Expects a SiebelException.
//		 */
//		@Test
//		public void manageSalesTeamInvalidFields() {
//			String optyId = StringUtils.randomAlphanumericString(7).toUpperCase();
//			String ema = StringUtils.randomStringAllLower(7);
//			String emm = StringUtils.randomStringAllLower(7);
//			
//			try {
//				String ret = adapter.manageSalesTeam(optyId, ema, emm);
//				// If we reach this, then there was no exception
//				assertTrue("Manage sales team should fail for invalid fields", ret.equals("FAIL"));
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Negative test for managing sales team. Passes valid opty ID and empty EMA and EMM. 
//		 * Expects a SiebelException.
//		 */
//		@Test
//		public void manageSalesTeamEmptyFields() {
//			String optyId = "1-109UACD";
//			String ema = "";
//			String emm = "";
//			
//			try {
//				adapter.manageSalesTeam(optyId, ema, emm);
//				// If we reach this, then there was no exception
//				fail("Manage sales team should fail for empty fields");
//			} catch (SiebelException e) {
//				// Exception expected
//			}
//		}
//
//	}


package Pages.Siebel;
//
//	import static org.junit.Assert.*;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	/**
//	 * @author adrian.moga
//	 * 
//	 * This class test the manage third party functionality of the SiebelServiceAdapter.
//	 */
//	public class ManageThirdPartyIntegrationTest extends SiebelServiceAdapterIntegrationTestBase {
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
//		 * Positive test for managing third party. Passes a valid Siebel opty ID, Siebel
//		 * third party ID, and boolean indicating the party should be deleted.
//		 * Expects a valid return status String.
//		 */
//		@Test
//		public void manageThirdPartyAddAndDeleteValidParty() {
//			String siebelOptyId = "1-10A48EX";
//			String siebelThirdPartyId = "1-TGW1W1"; // TODO is this in stage?
//			boolean isAdd = true;
//			String returnStatus;
//			
//			try { // add third party
//				returnStatus = adapter.manageThirdParty(siebelOptyId, siebelThirdPartyId, isAdd);
//				assertTrue("Add third party return status should be SUCCESS for valid inputs", 
//						returnStatus.equals("SUCCESS"));
//			} catch (SiebelException e) {
//				fail("SiebelException when adding third party with valid inputs | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			isAdd = false;
//			try { // delete third party
//				returnStatus = adapter.manageThirdParty(siebelOptyId, siebelThirdPartyId, isAdd);
//				assertTrue("Delete third party return status should be SUCCESS for valid inputs", 
//						returnStatus.equals("SUCCESS"));
//			} catch (SiebelException e) {
//				fail("SiebelException when deleting third party with valid inputs | "
//						+ "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * Negative test for managing third party. Passes empty Siebel opty ID, Siebel
//		 * third party ID, and boolean indicating the party should be deleted.
//		 * Expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void manageThirdPartyDeleteEmptyFields() {
//			String siebelOptyId = "1-10A48EX"; 
//			String siebelThirdPartyId = "1-TGW1W1";
//			boolean isAdd = true;
//			String returnStatus;
//			
//			try { // add third party
//				returnStatus = adapter.manageThirdParty(siebelOptyId, siebelThirdPartyId, isAdd);
//				assertTrue("Add third party return status should be SUCCESS for valid inputs", 
//						returnStatus.equals("SUCCESS"));
//			} catch (SiebelException e) {
//				fail("SiebelException when adding third party with valid inputs | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			isAdd = false;
//			siebelThirdPartyId = "";
//			try { // delete empty third party
//				returnStatus = adapter.manageThirdParty(siebelOptyId, siebelThirdPartyId, isAdd);
//				assertTrue("Delete third party should succeed for empty fields", returnStatus.equals("SUCCESS"));
//			} catch (SiebelException e) {
//				fail("SiebelException when deleting third party with valid opty ID | "
//						+ "Error: " + e.getErrorMessage());
//			}
//		}
//
//	}
//
//}

package Pages.Siebel;
//
//
//	import static org.junit.Assert.assertFalse;
//	import static org.junit.Assert.fail;
//
//	import java.util.List;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.domain.contract.Contract;
//	import com.siebel.xml.roe_20dsp_20contract_20io.data.ServiceAgreementData;
//
//	import static com.nrg.dsp.service.adapter.siebel.SiebelServiceAdapterIntegrationTestUtils.*;
//
//	/**
//	 * @author adrian.moga
//	 * 
//	 * This class tests the manage contracts functionality of the SiebelServiceAdapter. Specifically,
//	 * it tests the ability to create a contract record, update a contract's status, and create
//	 * a contract ACE record.
//	 */
//	public class ManageContractsIntegrationTest extends SiebelServiceAdapterIntegrationTestBase {
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
//		 * Positive test for creating a contract record. Passes Strings representing
//		 * valid opty ID, deal option ID, and comment, and expects a valid response,
//		 * i.e. a valid List of ServiceAgreementData.
//		 */
//		@Test
//		public void createContractRecordValidFields() {
//			String userId = "AMoga";
//			String siebelOptyId = "1-10C30VN";
//			String dealOptionId = "294764281391";
//			String comments = "";
//			try {
//				List<ServiceAgreementData> serviceAgreementDataList = adapter.createContractRecord(userId, siebelOptyId, dealOptionId, comments);
//				assertFalse("Create contract record should not return null for valid fields", 
//						serviceAgreementDataList == null);
//			} catch (SiebelException e) {
//				fail("SiebelException when creating contract record for valid fields | "
//						+ "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * Negative test for creating contract record. Passes Strings representing 
//		 * invalid opty ID, deal option ID, and comment, and expects a SiebelException
//		 * to be thrown.
//		 */
//		@Test
//		public void createContractRecordInvalidFields() {
//			String userId = StringUtils.randomAlphanumericString(10);
//			String siebelOptyId = StringUtils.randomAlphanumericString(8).toUpperCase();
//			String dealOptionId = StringUtils.randomAlphanumericString(8).toUpperCase();
//			String comments = StringUtils.randomAlphanumericString(25);
//			try {
//				adapter.createContractRecord(userId, siebelOptyId,  dealOptionId, comments);
//				// If we reach this, then there was no exception
//				fail("Expected SiebelException when creating contract record with invalid fields");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Positive test for updating contract status. Passes Strings representing a
//		 * valid Siebel contract ID, the requested Siebel status, and the Siebel
//		 * ACE ID. Expects a valid response String representing a positive return status.
//		 */
//		@Test
//		public void updateContractStatusValidFields() {
//			String siebelContractId = "1-109OUCS";
//			String requestedSiebelStatus = Contract.CANCELLED;
//			String siebelAceId = "1-109OUHQ";
//			try {
//				String returnStatus = adapter.updateContractStatus(siebelContractId, 
//						requestedSiebelStatus, siebelAceId);
//				assertFalse("Update contract status return status should not be null for valid fields", 
//						returnStatus == null);
//				assertFalse("Update contract status return status should not be emtpy for valid fields", 
//						returnStatus.isEmpty());
//			} catch (SiebelException e) {
//				fail("SiebelExceptin when updaring contract status with valid IDs | "
//						+ "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * Negative test for updating contract status. Passes Strings representing invalid
//		 * fields, and expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void updateContractStatusInvalidFields() {
//			String siebelContractId = StringUtils.randomAlphanumericString(8).toUpperCase();
//			String requestedSiebelStatus = StringUtils.randomStringAllCaps(8);
//			String siebelAceId = StringUtils.randomAlphanumericString(8).toUpperCase();
//			try {
//				adapter.updateContractStatus(siebelContractId, requestedSiebelStatus, siebelAceId);
//				// If we reach this, then there was no exception
//				fail("Expected SiebelException when updating contract status with invalid fields");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Negative test for updating contract status. Passes empty Strings as the
//		 * fields, and expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void updateContractStatusEmptyFields() {
//			String siebelContractId = "";
//			String requestedSiebelStatus = "";
//			String siebelAceId = "";
//			try {
//				adapter.updateContractStatus(siebelContractId, requestedSiebelStatus, siebelAceId);
//				// If we reach this, then there was no exception
//				fail("Expected SiebelException when updating contract status with empty fields");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Positive test for creating contract ACE record. Passes a valid Contract, and
//		 * expects a valid response status String.
//		 */
//		@Test
//		public void createContractAceRecordValidContract() {
//			Contract validContract = createValidContract();
//			try {
//				String aceDocId = adapter.createContractAceRecord(validContract);
//				assertFalse("Create contract ACE record return status should not be null for "
//						+ "valid input contract", aceDocId == null);
//				assertFalse("Create contract ACE record return status should not be empty for "
//						+ "valid input contract", aceDocId.isEmpty());
//			} catch (SiebelException e) {
//				fail("SiebelException when creating contract ACE record for valid contract | "
//						+ "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * Negative test for creating contract ACE record. Passes an invalid Contract, i.e. a
//		 * Contract with random values, and expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void createContractAceRecordInvalidContract() {
//			Contract invalidContract = createInvalidContract();
//			try {
//				adapter.createContractAceRecord(invalidContract);
//				// If we reach this, then there was no exception
//				fail("Expected SiebelException when creating contract ACE record for invalid contract");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Negative test for creating ACE record. Passes a blank Contract, i.e. a Contract 
//		 * whose fields are empty Strings, lists, etc., and expects a SiebelException to
//		 * be thrown. 
//		 */
//		@Test
//		public void createContractAceRecordBlankContract() {
//			Contract blankContract = createBlankContract();
//			try {
//				adapter.createContractAceRecord(blankContract);
//				// If we reach this, then there was no exception
//				fail("Expected SiebelException when creating contract ACE record for blank contract");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//
//	}


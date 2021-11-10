package Pages.VHOS;
//
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import java.util.List;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.dto.vhos.VhosCustomerContract;
//	import com.nrg.dsp.dto.vhos.VhosCustomerContractSend;
//
//	public class GetCustomerContractsIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid customer id
//		 * customer contract list should be returned
//		 */
//		@Test
//		public void getCustomerContractsByValidCustomerId() {
//			VhosCustomerContractSend vccs = new VhosCustomerContractSend(null);
//			vccs.setCustomerId(validCustomerId);
//			
//			try {
//				List<VhosCustomerContract> customerContract = sa.getCustomerContracts(vccs, userId);
//				assertTrue(!customerContract.isEmpty());
//			} catch (VhosException e) {
//				e.printStackTrace();
//				fail("VhosException when getting customer contracts with valid fields\n" + "Error: " + e.getErrorMessage());
//			} 
//		}
//		
//		/**
//		 * testing with invalid customer id
//		 * customer contract list should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getCustomerContractsByInvalidCustomerId() {
//			VhosCustomerContractSend vccs = new VhosCustomerContractSend(null);
//			vccs.setCustomerId(invalidCustomerId);
//			
//			try {
//				List<VhosCustomerContract> customerContract = sa.getCustomerContracts(vccs, userId);
//				if(!customerContract.isEmpty()) {
//					fail("Expected VhosException when getting customer contracts with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

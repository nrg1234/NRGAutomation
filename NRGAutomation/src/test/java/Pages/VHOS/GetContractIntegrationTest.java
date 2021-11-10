package Pages.VHOS;

//	import static org.junit.Assert.assertFalse;
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import java.util.List;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.dto.vhos.VhosContract;
//
//	public class GetContractIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid opty and contract id
//		 * contract should be returned
//		 */
//		@Test
//		public void getContractByValidExternalOptyIdAndContractIdTest() {
//			try {
//				List<VhosContract> contract = sa.getContractByExternalOptyIdAndContractId(userId, validOptyContractPairO, validOptyContractPairC);
//				System.out.println(contract.size());
//				assertTrue(!contract.isEmpty());
//			} catch (VhosException e) {
//				e.printStackTrace();
//				fail("VhosException when getting contract information with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid opty and contract id
//		 * contract should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getContractByExternalOptyIdAndContractIdInvalidTest() {
//			try {
//				List<VhosContract> contract = sa.getContractByExternalOptyIdAndContractId(userId, invalidOptyId, invalidContractId);
//				if(!contract.isEmpty()) {
//					fail("Expected VhosException when getting contract information with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

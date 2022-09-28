package Pages.VHOS;
//
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
//	public class GetOpportunityContractsIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid external id
//		 * contract should be returned
//		 */
//		@Test
//		public void getOpportunityContractsByValidExternalIdValidTest() {
//			try {
//				List<VhosContract> contract = sa.getOpportunityContractsByExternalId(userId, validOptyId);
//				assertTrue(true);
//			} catch (VhosException e) {
//				fail("VhosException when getting opportunity contracts with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid external id
//		 * contract should not be returned, ChosException should be thrown
//		 */
//		@Test
//		public void getOpportunityContractsByInvalidExternalIdValidTest() {
//			try {
//				List<VhosContract> contract = sa.getOpportunityContractsByExternalId(userId, invalidOptyId);
//				if(!contract.isEmpty()) {
//					fail("Expected VhosException when getting opportunity contracts with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

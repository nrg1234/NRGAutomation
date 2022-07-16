package Pages.VHOS;

//
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.dto.vhos.VhosOpportunityHeader;
//
//	public class GetOpportunityHeaderIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid external id
//		 * header should be returned
//		 */
//		@Test
//		public void getOpportunityHeaderByValidExternalId() {
//			try {
//				VhosOpportunityHeader header = sa.getOpportunityHeaderByExternalId(userId, validOptyId);
//				assertTrue(header != null);
//			} catch (VhosException e) {
//				fail("VhosException when getting opportunity header with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid external id
//		 * header should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getOpportunityHeaderByInvalidExternalId() {
//			try {
//				VhosOpportunityHeader header = sa.getOpportunityHeaderByExternalId(userId, invalidOptyId);
//				fail("Expected VhosException when getting opportunity header with invalid fields");
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

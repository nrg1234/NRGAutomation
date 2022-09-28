package Pages.VHOS;
//
//
//	import static org.junit.Assert.assertFalse;
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.dto.vhos.VhosOpportunityRefreshSyncSend;
//
//	public class GetSiteRefreshAvailableIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid opportunity id
//		 * site refresh available should be true
//		 */
//		@Test
//		public void getSiteRefreshAvailableByValidOpportunityId() {
//			VhosOpportunityRefreshSyncSend vorss = new VhosOpportunityRefreshSyncSend(null);
//			vorss.setOpportunityId(validOptyId);
//			
//			try {
//				boolean availability = sa.getSiteRefreshAvailable(vorss, userId);
//				assertTrue(true);
//			} catch (VhosException e) {
//				fail("VhosException when getting site refresh availablity with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid opportunity id
//		 * site refresh available should not be true, VhosException should be thrown
//		 */
//		@Test
//		public void getSiteRefreshAvailableByInvalidOpportunityId() {
//			VhosOpportunityRefreshSyncSend vorss = new VhosOpportunityRefreshSyncSend(null);
//			vorss.setOpportunityId(invalidOptyId);
//			
//			try {
//				if(sa.getSiteRefreshAvailable(vorss, userId)) {
//					fail("Expected VhosException when getting site refresh availablity with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

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
//	import com.nrg.dsp.domain.Opportunity;
//	import com.nrg.dsp.dto.vhos.VhosSiteInfo;
//
//	public class GetSiteInfoIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid opportunity id (from dsp_dev)
//		 * site info should be returned
//		 */
//		@Test
//		public void getSiteInfoValidOpportunityTest() {
//			Opportunity opportunity = new Opportunity();
//			opportunity.setExternalId(validOptyId);
//			
//			try {
//				List<VhosSiteInfo> siteInfo = sa.getSiteInfo(userId, opportunity);
//				
//				assertTrue(!siteInfo.isEmpty());
//			} catch (VhosException e) {
//				fail("VhosException when getting site information with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid opportunity
//		 * site info should not be returned, VhosException should be thrown
//		 * 	due to error message response
//		 */
//		@Test
//		public void getSiteInfoInvalidOpportunityTest() {
//			Opportunity opportunity = new Opportunity();
//			opportunity.setExternalId(invalidOptyId);
//			
//			try {
//				List<VhosSiteInfo> siteInfo = sa.getSiteInfo(userId, opportunity);
//				if(!siteInfo.isEmpty()) {
//					fail("Expected VhosException when getting site information with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

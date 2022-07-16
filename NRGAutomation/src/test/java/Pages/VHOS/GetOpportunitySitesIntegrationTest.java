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
//	import com.nrg.dsp.dto.vhos.VhosOpportunitySite;
//
//	public class GetOpportunitySitesIntegrationTest extends VhosIntegrationTestBase {
//	private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid external id 
//		 * opportunity sites should be returned
//		 */
//		@Test
//		public void getOpportunitySitesByValidExternalId() {
//			try {
//				List<VhosOpportunitySite> opportunitySites = sa.getOpportunitySitesByExternalId(userId, validOptyId);
//				assertTrue(!opportunitySites.isEmpty());
//			} catch (VhosException e) { 
//				fail("VhosException when getting opportunity sites with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid external id
//		 * opportunity sites should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getOpportunitySitesByInvalidExternalId() {
//			try {
//				List<VhosOpportunitySite> opportunitySites = sa.getOpportunitySitesByExternalId(userId, invalidOptyId);
//				if(!opportunitySites.isEmpty()) {
//					fail("Expected VhosException when getting opportunity sites with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

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
//	import com.nrg.dsp.dto.vhos.VhosSiteOverlap;
//
//	public class GetOverlappingSitesIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid siebel opty id (id from dsp dev)
//		 * over lapping sites list should be returned
//		 */
//		@Test
//		public void getOverlappingSitesByValidSiebelOptyId() {
//			try {
//				List<VhosSiteOverlap> overLappingSites = sa.getOverlappingSites(validOptyId, userId);
//				assertTrue(!overLappingSites.isEmpty());
//			} catch (VhosException e) {
//				fail("VhosException when getting overlapping sites with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid siebel opty id
//		 * opty lapping sites should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getOverlappingSitesByInvalidSiebelOptyId() {
//			try {
//				List<VhosSiteOverlap> overLappingSites = sa.getOverlappingSites(invalidOptyId, userId);
//				if(!overLappingSites.isEmpty()) {
//					fail("Expected VhosException when getting overlapping sites with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

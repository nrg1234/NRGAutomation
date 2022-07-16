package Pages.VHOS;
//
//
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import java.util.ArrayList;
//	import java.util.List;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.dto.vhos.HUNeededReceive;
//	import com.nrg.dsp.dto.vhos.HUNeededSite;
//
//	public class GetHUNeededIntegrationTest extends VhosIntegrationTestBase {
//	private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid sites
//		 * should return without error
//		 */
//		@Test
//		public void getHuNeededValidSiteTest()  {
//			List<HUNeededSite> site = new ArrayList<HUNeededSite>();
//			// add valid sites
//			HUNeededSite hns = new HUNeededSite();
//			hns.setEsid(validEsid);
//			site.add(hns);
//		
//			try {
//				HUNeededReceive hnr = sa.getHuNeeded(userId, site);
//				assertTrue(hnr != null);
//			} catch (VhosException e) {
//				fail("VhosException when getting HU needed with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with sites having a size of 0
//		 * should return null
//		 */
//		@Test
//		public void getHuNeededGivenInvalidSiteTest()  {
//			List<HUNeededSite> site = new ArrayList<HUNeededSite>();
//			HUNeededSite hns = new HUNeededSite();
//			
//			try {
//				HUNeededReceive hnr = sa.getHuNeeded(userId, site);
//				if(hnr != null) {
//					fail("Expected VhosException when getting HU needed with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//
//	}
//
//}

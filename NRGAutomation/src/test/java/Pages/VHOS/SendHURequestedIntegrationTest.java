package Pages.VHOS;

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
//	import com.nrg.dsp.dto.vhos.HUNeededSite;
//
//	public class SendHURequestedIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid site
//		 * send HU should be processed successfully
//		 */
//		@Test
//		public void sendHuRequestedValidHUNeededSiteTest() {
//			List<HUNeededSite> sites = new ArrayList<HUNeededSite>();
//			
//			HUNeededSite site = new HUNeededSite();
//			site.setEsid(validEsid);
//			site.setEdc(validEdc);
//			sites.add(site);
//			
//			try {
//				sa.sendHuRequested(userId, sites);
//				assertTrue(true);
//			} catch (VhosException e) {
//				fail("VhosException when sending HU Request with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid edc
//		 * send HU should not be processed successfully, VhosException should be thrown
//		 */
//		@Test
//		public void sendHuRequestedInalidSiteEDCHUNeededSiteTest() {
//			List<HUNeededSite> sites = new ArrayList<HUNeededSite>();
//			// add valid sites
//			HUNeededSite site = new HUNeededSite();
//			site.setEsid(invalidEsid);
//			site.setEdc(invalidEdc);
//			sites.add(site);
//			
//			try {
//				sa.sendHuRequested(userId, sites);
//				fail("Expected VhosException when sending HU Request with invalid fields");
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

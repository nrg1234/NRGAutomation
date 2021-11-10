package Pages.VHOS;
//
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import java.text.ParseException;
//	import java.text.SimpleDateFormat;
//	import java.util.ArrayList;
//	import java.util.Date;
//	import java.util.List;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.domain.Site;
//	import com.nrg.dsp.dto.vhos.VhosOpportunityStaggeredStartsSend;
//	import com.nrg.dsp.dto.vhos.VhosStaggeredStartSiteInfoSend;
//
//	public class UpdateOpportunityStaggeredStartDatesIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid sites info
//		 * should update successfully
//		 */
//		@Test
//		public void updateOpportunityStaggeredStartDatesByValidVOSSSTest() {
//			VhosOpportunityStaggeredStartsSend vosss = new VhosOpportunityStaggeredStartsSend();
//			vosss.setOpportunityId(validOptyPodPairO);
//			
//			List<VhosStaggeredStartSiteInfoSend> staggeredStartSites = new ArrayList<VhosStaggeredStartSiteInfoSend>();
//			
//			VhosStaggeredStartSiteInfoSend vsssis = new VhosStaggeredStartSiteInfoSend();
//			vsssis.setPod(validOptyPodPairP);
//			staggeredStartSites.add(vsssis);
//			vosss.setSites(staggeredStartSites);
//			
//			try {
//				sa.updateOpportunityStaggeredStartDates(vosss);
//				assertTrue(true);
//			} catch (VhosException e) {
//				fail("VhosException when updating opportunity staggered start dates with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid sites
//		 * should not update successfully, VhosException should be thrown
//		 */
//		@Test
//		public void updateOpportunityStaggeredStartDatesByInvalidVOSSSTest() {
//			VhosOpportunityStaggeredStartsSend vosss = new VhosOpportunityStaggeredStartsSend();
//			vosss.setOpportunityId(invalidOptyId);
//			
//			List<VhosStaggeredStartSiteInfoSend> staggeredStartSites = new ArrayList<VhosStaggeredStartSiteInfoSend>();
//			
//			VhosStaggeredStartSiteInfoSend vsssis = new VhosStaggeredStartSiteInfoSend();
//			vsssis.setPod(invalidEsid);
//			staggeredStartSites.add(vsssis);
//			vosss.setSites(staggeredStartSites);
//			
//			try {
//				sa.updateOpportunityStaggeredStartDates(vosss);
//				fail("Expected VhosException when updating opportunity staggered start dates with invalid fields");
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

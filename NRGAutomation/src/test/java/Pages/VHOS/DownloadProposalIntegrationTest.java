package Pages.VHOS;

//
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.config.VhosConfig;
//	import com.nrg.dsp.util.AppLogger;
//	import com.nrg.dsp.util.RequestFactory;
//
//	import lombok.extern.java.Log;
//
//	public class DownloadProposalIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid external opty id
//		 * pricing sheet should be downloaded
//		 */
//		@Test
//		public void downloadProposalValidTest() {
//			byte[] returnVal = null;
//	        try {
//				returnVal = sa.downloadProposal(userId, "1-10C2K3R");
//				assertTrue(true);
//			} catch (VhosException e) {
//				fail("VhosException when downloading proposal with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid external opty id
//		 * pricing sheet should not be downloaded
//		 * returnVal will hold the appLoggerid, but since have no access to repo from this module
//		 * can assume that if null is returned then failed to download
//		 */
//		@Test
//		public void downloadProposalInvalidTest() {
//			try {
//				byte[] returnVal = sa.downloadProposal(userId, "1-10C44K9");
//				if(returnVal != null) {
//					fail("Expected VhosException when downloading proposal with invalid fields");
//				}
//			} catch(Exception e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

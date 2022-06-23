package Pages.VHOS;

//
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
//	import com.nrg.dsp.dto.vhos.VhosSiebelEmm;
//	import com.nrg.dsp.dto.vhos.VhosSiebelEmmSend;
//
//	public class GetEmmListIntegrationTest extends VhosIntegrationTestBase {
//	private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid opportunity id
//		 * emm list should be returned
//		 */
//		@Test
//		public void getEmmListByValidExternalOpportunityid() {
//			VhosSiebelEmmSend vses = new VhosSiebelEmmSend();
//			vses.setOpportunityid(validOptyId);
//			
//			try {
//				List<VhosSiebelEmm> emmList = sa.getEmmListByExternalOpportunityid(vses, userId);
//				assertTrue(!emmList.isEmpty());
//			} catch (VhosException e) {
//				fail("VhosException when getting Emm List with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid opportunity id
//		 * emm list should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getEmmListByInvalidExternalOpportunityid() {
//			VhosSiebelEmmSend vses = new VhosSiebelEmmSend();
//			vses.setOpportunityid(invalidOptyId);
//			
//			try {
//				List<VhosSiebelEmm> emmList = sa.getEmmListByExternalOpportunityid(vses, userId);
//				if(!emmList.isEmpty()) {
//					fail("Expected VhosException when getting Emm List with invalid fields");
//				}
//				assertFalse(!emmList.isEmpty());
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

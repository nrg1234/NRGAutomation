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
//	import com.nrg.dsp.dto.vhos.VhosOptyLastCosted;
//	import com.nrg.dsp.dto.vhos.VhosOptyLastCostedSend;
//
//	public class GetOpportunitiesLastCostedIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//
//		/**
//		 * testing with valid lastCostedDate, market, and opportunity id
//		 * opportunities last costed should be returned
//		 */
//		@Test
//		public void getOpportunitiesLastCostedValidVOLCS() {
//			VhosOptyLastCostedSend volcs = new VhosOptyLastCostedSend();
//			volcs.setLastCostedDate("04-JUN-19");
//			volcs.setMarket("ERCOT");
//			
//			try {
//				List<VhosOptyLastCosted> opportunitiesLastCosted = sa.getOpportunitiesLastCosted(volcs);
//				assertTrue(!opportunitiesLastCosted.isEmpty());
//			} catch (VhosException e) {
//				fail("VhosException when getting opportunities last costed with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		
//		/**
//		 * testing with invalid or non-existing market and invalid last costed date
//		 * opportunities last costed should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getOpportunitiesLastCostedInvalidVOLCS() {
//			VhosOptyLastCostedSend volcs = new VhosOptyLastCostedSend();
//			volcs.setLastCostedDate("invalidLastCostedDate");
//			volcs.setMarket("invalidMarket");
//			
//			try {
//				List<VhosOptyLastCosted> opportunitiesLastCosted = sa.getOpportunitiesLastCosted(volcs);
//				if(!opportunitiesLastCosted.isEmpty()) {
//					fail("Expected VhosException when getting opportunities last costed with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

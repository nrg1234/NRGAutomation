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
//	import com.nrg.dsp.dto.vhos.VhosSiebelActivity;
//	import com.nrg.dsp.dto.vhos.VhosSiebelActivitySend;
//
//	public class GetSiebelActivitiesIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid customer and opportunity id
//		 * siebel activities should be returned
//		 */
//		@Test
//		public void getSiebelActivitiesValidVhosSiebelActivitySendTest() {
//			VhosSiebelActivitySend vsas = new VhosSiebelActivitySend();
//			vsas.setCustomerId(validOptyCustomerPairC);
//			vsas.setOpportunityId(validOptyCustomerPairO);
//			
//			try {
//				List<VhosSiebelActivity> siebelActivities = sa.getSiebelActivities(vsas, userId);
//				assertTrue(!siebelActivities.isEmpty());
//			} catch (VhosException e) {
//				fail("VhosException when getting siebel activities with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid customer and opportunity id
//		 * siebel activities should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getSiebelActivitiesInvalidVhosSiebelActivitySendTest() {
//			VhosSiebelActivitySend vsas = new VhosSiebelActivitySend();
//			vsas.setCustomerId(invalidCustomerId);
//			vsas.setOpportunityId(invalidOptyId);
//			
//			try {
//				List<VhosSiebelActivity> siebelActivities = sa.getSiebelActivities(vsas, userId);
//				if(!siebelActivities.isEmpty()) {
//					fail("Expected VhosException when getting siebel activities with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

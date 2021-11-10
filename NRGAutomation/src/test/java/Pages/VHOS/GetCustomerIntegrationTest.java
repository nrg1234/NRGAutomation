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
//	import com.nrg.dsp.dto.vhos.VhosCustomer;
//	import com.nrg.dsp.dto.vhos.VhosCustomerSend;
//
//	public class GetCustomerIntegrationTest extends VhosIntegrationTestBase {
//	private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//
//		/**
//		 * testing with valid customer num
//		 * customer list should be returned
//		 */
//		@Test
//		public void getCustomerByValidCustomerNum() {
//			VhosCustomerSend vcs = new VhosCustomerSend();
//			vcs.setCustomernum(validCustomerId);
//			
//			try {
//				List<VhosCustomer> customer = sa.getCustomer(vcs, userId);
//				assertTrue(!customer.isEmpty());
//			} catch (VhosException e) {
//				fail("VhosException when getting customer information with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid customer num
//		 * customer list should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getCustomerByInvalidCustomerNum() {
//			VhosCustomerSend vcs = new VhosCustomerSend();
//			vcs.setCustomernum(invalidCustomerId);
//			
//			try {
//				List<VhosCustomer> customer = sa.getCustomer(vcs, userId);
//				if(!customer.isEmpty()) {
//					fail("Expected VhosException when getting customer information with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

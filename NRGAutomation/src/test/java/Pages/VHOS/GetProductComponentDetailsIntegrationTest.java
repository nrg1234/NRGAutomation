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
//	import com.nrg.dsp.dto.vhos.VhosProductComponentDetail;
//	import com.nrg.dsp.dto.vhos.VhosProductComponentSend;
//
//	public class GetProductComponentDetailsIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid product id
//		 * component details of product should be returned
//		 */
//		@Test
//		public void getProductComponentDetailsByValidProductIdTest() {
//			VhosProductComponentSend vpcs = new VhosProductComponentSend();
//			vpcs.setProductid(validProductId);
//			
//			try {
//				List<VhosProductComponentDetail> details = sa.getProductComponentDetailsByProductId(vpcs, userId);
//				assertTrue(!details.isEmpty());
//			} catch(VhosException e) {
//				fail("VhosException when getting product component details with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid product id
//		 * details should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getProductComponentDetailsByInvalidProductIdTest() {
//			VhosProductComponentSend vpcs = new VhosProductComponentSend();
//			vpcs.setProductid(invalidProductId);
//			
//			try {
//				List<VhosProductComponentDetail> details = sa.getProductComponentDetailsByProductId(vpcs, userId);
//				if(!details.isEmpty()) {
//					fail("Expected VhosException when getting product component details with invalid fields");
//				}
//			} catch(VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

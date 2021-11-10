package Pages.VHOS;
//
//
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import java.util.List;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.dto.vhos.VhosDealOptionProducts;
//
//	public class GetDealOptionInfoIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid opty and deal option id
//		 * products list containing only one object should be returned
//		 */
//		@Test
//		public void getDealOptionInfoByValidExternalOptyIdAndDealOptionIdTest() {
//			try {
//				List<VhosDealOptionProducts> products = sa.getDealOptionInfoWithOptyAndDealOptionId(userId, validOptyDealOptionPairO, validOptyDealOptionPairD);
//				for(VhosDealOptionProducts e : products) {
//					System.out.println(e.getSubdealId());
//				}
//				assertTrue(!products.isEmpty() && products.size() == 1);
//			} catch (VhosException e) {
//				e.printStackTrace();
//				fail("VhosException when getting deal option information with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with only a valid opty id
//		 * products list should be returned
//		 */
//		@Test
//		public void getDealOptionInfoByValidExternalOptyId() {
//			try {
//				List<VhosDealOptionProducts> products = sa.getDealOptionInfoWithOptyId(userId, validOptyDealOptionPairO);
//				assertTrue(!products.isEmpty());
//			} catch (VhosException e) {
//				fail("VhosException when getting deal option information with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with only a invalid opty and deal option id
//		 * products list should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getDealOptionInfoByInvalidExternalOptyIdAndDealOptionIdTest() {
//			try {
//				List<VhosDealOptionProducts> products = sa.getDealOptionInfoWithOptyAndDealOptionId(userId, invalidOptyId, invalidDealOptionId);
//				if(!products.isEmpty()) {
//					fail("Expected VhosException when getting deal option information with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//		
//		/**
//		 * testing with only a invalid opty id
//		 * products list should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getDealOptionInfoByInvalidExternalOptyId() {
//			try {
//				List<VhosDealOptionProducts> products = sa.getDealOptionInfoWithOptyId(userId, invalidDealOptionId);
//				if(!products.isEmpty()) {
//					fail("Expected VhosException when getting deal option information with invalid fields");
//				}
//			} catch (VhosException e) {
//				e.printStackTrace();
//				assertTrue(true);
//			}
//		}
//	}
//
//}

package Pages.VHOS;
//
//
//
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import org.junit.Before;
//	import org.junit.Test;
//	import com.nrg.dsp.service.dto.QuoteDTO;
//
//	public class GetQuoteIntegrationTest extends VhosIntegrationTestBase {
//		
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid external opty id
//		 * a quote should be returned
//		 */
//		@Test
//		public void getQuoteValidExternalOptyIDTest()  {
//			try {
//				QuoteDTO quoteLookup = new QuoteDTO();
//				quoteLookup = sa.getQuote(userId, validOptyId);
//				assertTrue(quoteLookup != null);
//			} catch (VhosException e) {
//				fail("VhosException when getting quote information with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid external opty id
//		 * a quote should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getQuoteInvalidExternalOptyIDTest()  {
//			try {
//				QuoteDTO quoteLookup = sa.getQuote(userId, invalidOptyId);
//				if( quoteLookup != null) {
//					fail("Expected VhosException when getting quote information with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

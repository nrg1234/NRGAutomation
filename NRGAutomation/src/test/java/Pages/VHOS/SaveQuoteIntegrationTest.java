package Pages.VHOS;
//
//
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.service.dto.QuoteDTO;
//
//	public class SaveQuoteIntegrationTest extends VhosIntegrationTestBase {
//	private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid external opty id
//		 * a quote should be calculated
//		 */
//		@Test
//		public void saveQuoteValidExternalOptyIDTest()  {
//			try {
//				QuoteDTO quoteLookup = sa.getQuote(userId, validOptyId);
//				QuoteDTO quoteSave = sa.saveQuote(userId, quoteLookup);
//				assertTrue(quoteSave != null);
//			} catch (VhosException e) {
//				fail("VhosException when saving quote with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid external opty id
//		 * a quote should not be calculate, VhosException should be thrown
//		 */
//		@Test
//		public void saveQuoteInvalidExternalOptyIDTest()  {
//			try {
//				QuoteDTO quoteLookup = sa.getQuote(userId, invalidOptyId);
//				QuoteDTO quoteSave = sa.saveQuote(userId, quoteLookup);
//				if(quoteSave != null) {
//					fail("Expected VhosException when saving quote with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

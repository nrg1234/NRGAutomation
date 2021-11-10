package Pages.VHOS;
//
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.service.dto.QuoteDTO;
//
//	public class CalculateQuoteIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
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
//		public void calculateQuoteByValidExternalOptyIDTest()  {
//			try {
//				QuoteDTO quoteLookup = sa.getQuote(userId, validOptyId);
//				QuoteDTO quoteCalculate = sa.calculateQuote(userId, quoteLookup);
//				assertTrue(true);
//			} catch (VhosException e) {
//				fail("VhosException when calculating quote with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/** 
//		 * testing with invalid external opty id
//		 * a quote should not be calculated, VhosException should be thrown
//		 */
//		@Test
//		public void calculateQuoteInvalidExternalOptyIDTest()  {
//			try {
//				QuoteDTO quoteLookup = sa.getQuote(userId, invalidOptyId);
//				QuoteDTO quoteCalculate = sa.calculateQuote(userId, quoteLookup);
//				fail("Expected VhosException when calculating quote with invalid fields");
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

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
//	import com.nrg.dsp.dto.vhos.VhosOptyQuote;
//	import com.nrg.dsp.dto.vhos.VhosOptyQuotesSend;
//
//	public class GetOptyQuotesIntegrationTest extends VhosIntegrationTestBase {
//	private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//
//		/**
//		 * testing with valid opportunity id
//		 * opty quotes list should be returned
//		 */
//		@Test
//		public void getOptyQuotesByValidExternalOpportunityId() {
//			VhosOptyQuotesSend voqs = new VhosOptyQuotesSend();
//			voqs.setOpportunityid(validOptyId);
//			
//			try {
//				List<VhosOptyQuote> optyQuotes = sa.getOptyQuotesByExternalOpportunityId(voqs, userId);
//				assertTrue(!optyQuotes.isEmpty());
//			} catch (VhosException e) {
//				fail("VhosException when getting opportunity quotes with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid opportunity id
//		 * opty quotes list should not be returned, VHosException should be thrown
//		 */
//		@Test
//		public void getOptyQuotesByInvalidExternalOpportunityId() {
//			VhosOptyQuotesSend voqs = new VhosOptyQuotesSend();
//			voqs.setOpportunityid(invalidOptyId);
//			
//			try {
//				List<VhosOptyQuote> optyQuotes = sa.getOptyQuotesByExternalOpportunityId(voqs, userId);
//				if(!optyQuotes.isEmpty()) {
//					fail("Expected VhosException when getting opportunity quotes with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

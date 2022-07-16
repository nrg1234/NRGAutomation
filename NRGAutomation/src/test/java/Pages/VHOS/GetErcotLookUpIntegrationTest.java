package Pages.VHOS;

//
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.dto.site.VhosValidateSiteResponse;
//
//	public class GetErcotLookUpIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid esids
//		 * esid list should contain the input values
//		 */
//		@Test
//		public void getErcotLookupFoundTest() {
//			try {
//				VhosValidateSiteResponse ercotLookup = sa.getErcotLookup(userId, 
//					 new String[] {validEsid});
//				System.out.println(ercotLookup.getEsidList().get(0).getQueryOutput().getResults());
//				boolean missing = false;
//				for(int i = 0; i < ercotLookup.getEsidList().size(); i++) {
//					if(ercotLookup.getEsidList().get(i).getQueryOutput().getResults() == null) {
//						missing = true;
//					}
//				}
//				assertTrue(!missing);
//			} catch (VhosException e) {
//				fail("VhosException when getting Ercot Lookup with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid esids
//		 * missing list should contain the input values
//		 */
//		@Test
//		public void getErcotLookupMissingTest() {
//			try { 
//				VhosValidateSiteResponse ercotLookup = sa.getErcotLookup(userId, 
//					 new String[] {invalidEsid});
//				boolean missing = true;
//				for(int i = 0; i < ercotLookup.getEsidList().size(); i++) {
//					if(!ercotLookup.getEsidList().get(i).getQueryOutput().getError().contains("No Results found")) {
//						missing = false;
//					}
//				}
//					
//				assertTrue(missing);
//			} catch (VhosException e) {
//				fail("VhosException when getting Ercot Lookup with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with valid and invalid esids
//		 * esid list and missing list should contain values
//		 */
//		@Test
//		public void getErcotLookupFoundMissingTest() {
//			try {
//				VhosValidateSiteResponse ercotLookup = sa.getErcotLookup(userId, 
//					new String[] {invalidEsid, validEsid});
//				int found = 0;
//				int missing = 0;
//				for(int i = 0; i < ercotLookup.getEsidList().size(); i++) {
//					if(ercotLookup.getEsidList().get(i).getQueryOutput().getResults() != null){
//						found++;
//					}
//					if(ercotLookup.getEsidList().get(i).getQueryOutput().getResults() == null && ercotLookup.getEsidList().get(i).getQueryOutput().getError().contains("No Results found")) {
//						missing++;
//					}
//				}
//				assertTrue(found == 1 && missing == 1);
//			} catch (VhosException e) {
//				fail("VhosException when getting Ercot Lookup with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//	}
//
//}

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
//	import com.nrg.dsp.dto.vhos.VhosSiebelOpportunity;
//
//	public class GetSiebelOptiesIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid last modified time stamp
//		 * siebel opties list should be returned
//		 */
//		@Test
//		public void getSiebelOptiesByValidModifiedTimestamp() {
//			try {
//				List<VhosSiebelOpportunity> siebelOpties = sa.getSiebelOptiesByModifiedTimestamp("2019-01-29 04:30:12");
//				assertTrue(!siebelOpties.isEmpty());
//			} catch (VhosException e) {
//				fail("VhosException when getting siebel opties with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid last modified time stamp
//		 * siebel opties list should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void getSiebelOptiesByInvalidModifiedTimestamp() {
//			try {
//				List<VhosSiebelOpportunity> siebelOpties = sa.getSiebelOptiesByModifiedTimestamp("bad_lastModifiedTimestamp");
//				if(!siebelOpties.isEmpty()) {
//					fail("Expected VhosException when getting siebel opties with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

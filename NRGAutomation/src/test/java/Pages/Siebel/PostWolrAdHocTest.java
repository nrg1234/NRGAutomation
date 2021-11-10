package Pages.Siebel;
//
//
//	import static org.junit.Assert.*;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.service.dto.WolrDTO;
//
//	import static com.nrg.dsp.service.adapter.siebel.SiebelServiceAdapterIntegrationTestUtils.*;
//
//	/**
//	 * @author adrian.moga
//	 * 
//	 * This class tests the post WOLR functionality of the SiebelServiceAdapter.
//	 */
//	public class PostWolrAdHocTest extends SiebelServiceAdapterIntegrationTestBase {
//		
//		/**
//		 * SiebelServiceAdapter being tested.
//		 */
//		private SiebelServiceAdapter adapter;
//		
//		/**
//		 * Performs initial setup before each test. Creates new SiebelConfig object,
//		 * sets appropriate service URL, and initializes SiebelServiceAdapter to
//		 * be tested.
//		 */
//		@Before
//		public void setup() {
//			adapter = super.initAdapter();
//		}
//		
//		/**
//		 * Positive test for posting WOLRs. Creates a "won" WOLR, then calls
//		 * the adapter's method for posting WOLRs.
//		 */
//		@Test
//		public void postWolrWonWolr() {
//			WolrDTO wonWolr = createWonWolrDTO();
//			try {
//				String wolrId = adapter.postWolr(wonWolr);
//				assertFalse("Posting won WOLR should not return null WOLR ID", wolrId == null);
//				assertFalse("Posting won WOLR should not return empty WOLR ID", wolrId.isEmpty());
//			} catch (SiebelException e) {
//				fail("SiebelException when posting won WOLR | Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * Positive test for posting WOLRs. Creates a "lost" WOLR, then calls
//		 * the adapter's method for posting WOLRs.
//		 */
//		@Test
//		public void postWolrLostWolr() {
//			WolrDTO lostWolr = createLostWolrDTO();
//			try {
//				String wolrId = adapter.postWolr(lostWolr);
//				assertFalse("Posting lost WOLR should not return null WOLR ID", wolrId == null);
//				assertFalse("Posting lost WOLR should not return empty WOLR ID", wolrId.isEmpty());
//			} catch (SiebelException e) {
//				fail("SiebelException when posting lost WOLR | Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * Negative test for posting WOLRs. Creates an empty WOLR by initializing a
//		 * WolrDTO object and initializing all its fields to empty strings, lists,
//		 * etc. Then, posts this blank WOLR, and expects an exception.
//		 */
//		@Test
//		public void postWolrEmptyWolr() {
//			WolrDTO blankWolr = createEmptyWolrDTO();
//			blankWolr.setOpptyId("1-10247VX"); // same as won WOLR opty ID
//			try {
//				String wolrId = adapter.postWolr(blankWolr);
//				assertTrue("WOLR ID should be empty for blank WOLR", wolrId.isEmpty());
//			} catch (SiebelException e) {
//				fail("SiebelException when posting a blank WOLR");
//			}
//		}
//	}
//}

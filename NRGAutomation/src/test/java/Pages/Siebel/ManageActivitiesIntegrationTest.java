package Pages.Siebel;

	import org.junit.Before;
	import org.junit.Test;
	import static org.junit.Assert.*;

//	import com.nrg.dsp.service.dto.SiebelActivityDTO;
//
//	import static com.nrg.dsp.service.adapter.siebel.SiebelServiceAdapterIntegrationTestUtils.*;
	/**
	 * @author adrian.moga
	 * 
	 * This class tests the manage activities functionality of the SiebelServiceAdapter. Specifically,
	 * it tests the ability to create and update an activity.
	 */
//	public class ManageActivitiesIntegrationTest extends SiebelServiceAdapterIntegrationTestBase {
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
//		 * Positive test for creating and updating activities. Creates a valid
//		 * new ActivityDTO with the minimum amount of data for a success.
//		 * Then, passes the activity to the adapter, captures the activity 
//		 * ID, and sets the activity's ID to match the captured value.
//		 * Finally, passes the existing activity to the service, and 
//		 * expects a successful update.
//		 */
//		@Test
//		public void createAndUpdateActivityValidFields() {
//			SiebelActivityDTO activity = createValidNewActivityDTO();
//			String activityId = null; 
//			
//			try {
//				activityId = adapter.createOrUpdateActivity(activity);
//			} catch (SiebelException e) {
//				fail("Create new activity should not fail for valid fields | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			// Ensure activity was created successfully
//			assertFalse("Create new activity should not return null for valid fields", 
//					activityId == null);
//			assertFalse("Create new activity should not return an empty activity ID for valid fields", 
//					activityId.isEmpty()); 
//			
//			activity.setActivityId(activityId); // set activity ID to update activity
//			try {
//				activityId = adapter.createOrUpdateActivity(activity);
//			} catch (SiebelException e) {
//				fail("Update existing activity should not fail for valid activity | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			// Ensure activity was updated successfully
//			assertFalse("Udpate activity should not return null for valid fields", 
//					activityId == null);
//			assertFalse("Update activity should not return an empty activity ID for valid fields", 
//					activityId.isEmpty());
//		}
//		
//		/**
//		 * Negative test case for create activity. Passes an invalid new
//		 * ActivityDTO, i.e. one whose fields are all randomly generated.
//		 * Expects a SiebelError to be thrown.
//		 */
//		@Test
//		public void createActivityInvalidFields() {
//			SiebelActivityDTO activity = createInvalidNewActivityDTO();
//			
//			try {
//				adapter.createOrUpdateActivity(activity);
//				// We expect an error, so we should not get here
//				fail("Create activity should fail for invalid fields");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Negative test case for create activity. Passes an invalid new
//		 * ActivityDTO, i.e. one whose fields are all randomly generated.
//		 * Expects a SiebelError to be thrown.
//		 */
//		@Test
//		public void updateActivityInvalidFields() {
//			SiebelActivityDTO activity = createInvalidNewActivityDTO();
//			activity.setActivityId(StringUtils.randomAlphanumericString(8).toUpperCase());
//			
//			try {
//				adapter.createOrUpdateActivity(activity);
//				// We expect an error, so we should not get here
//				fail("Update activity should fail for invalid fields");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}

	

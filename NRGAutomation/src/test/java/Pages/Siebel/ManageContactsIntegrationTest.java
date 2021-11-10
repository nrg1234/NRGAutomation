package Pages.Siebel;

//	import static org.junit.Assert.*;
//
//	import java.util.List;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.service.dto.ContactDTO;
//	import com.siebel.xml.roe_20dsp_20account_20contact_20query_20io.data.ContactData;
//
//	import static com.nrg.dsp.service.adapter.siebel.SiebelServiceAdapterIntegrationTestUtils.*;
//
//	/**
//	 * @author adrian.moga
//	 * 
//	 * This class tests the manage contacts functionality of the SiebelServiceAdapter.
//	 * Specifically, it tests the ability to create and update a new contact, and to
//	 * fetch contacts.
//	 */
//	public class ManageContactsIntegrationTest extends SiebelServiceAdapterIntegrationTestBase {
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
//		 * Positive test for creating new contact, then updating it. Passes a 
//		 * String representing a valid Siebel customer ID, and a valid ContactDTO. 
//		 * Expects a valid return status String, i.e. the customer's contact ID.
//		 */
//		@Test
//		public void createUpdateAndFetchValidContact() {
//			// Create new customer ID and contact
//			String customerId = "1-47BFBY";
//			ContactDTO contact = createValidNewContactDTO();
//			String contactId = "";
//			
//			try { // try to add new contact first
//				contactId = adapter.createOrUpdateContact(customerId, contact);
//			} catch (SiebelException e) {
//				fail("SiebelException when creating new contact with valid fields | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			// Ensure that contact ID is valid
//			assertFalse("Create new contact should not return a null contact ID", 
//					contactId == null);
//			assertFalse("Create new contact should not return an empty contact ID", 
//					contactId.isEmpty());
//			
//			// Fetch the newly created customer
//			List<ContactData> contactDataList = null;
//			try {
//				contactDataList = adapter.fetchContacts(customerId);
//			} catch (SiebelException e) {
//				fail("SiebelException when fetching newly added valid contact | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			// Ensure that the fetchContacts() result is valid
//			assertFalse("Fetch contacts should not return null for newly created contact", 
//					contactDataList == null);
//			assertFalse("Fetch contacts should not be empty for newly created contact", 
//					contactDataList.isEmpty());
//			boolean containsNewContact = false;
//			for (ContactData contactData: contactDataList) { // search for new contact
//				if (contactData.getContactId().equals(contactId)) {
//					containsNewContact = true;
//				}
//			}
//			assertTrue("Fetch contacts should return newly created contact", containsNewContact);
//			
//			// Update customer DTO to include new contact ID, and change some fields
//			contact.setExternalId(contactId);
//			contact.setFirstName("Newton");
//			contact.setLastName("Namerson");
//			contact.setEmail(""); // remove email
//			
//			try { // try to update contact
//				contactId = adapter.createOrUpdateContact(customerId, contact);
//			} catch (SiebelException e) {
//				fail("SiebelException when updating existing contact with valid fields | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			// Ensure that contact ID is still valid
//			assertFalse("Update existing contact should not return null", 
//					contactId == null);
//			assertFalse("Update existing contact should not return an empty contact ID", 
//					contactId.isEmpty());
//			
//			// Ensure that contact ID can still be fetched
//			try {
//				contactDataList = adapter.fetchContacts(customerId);
//			} catch (SiebelException e) {
//				fail("SiebelException when fetching recently updated valid contact | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			// Ensure that the fetchContacts() result is valid
//			assertFalse("Fetch contacts should not return null for recently upated contact", 
//					contactDataList == null);
//			assertFalse("Fetch contacts should not be empty for recently updated contact", 
//					contactDataList.isEmpty());
//			boolean containsUpdatedContact = false;
//			for (ContactData contactData: contactDataList) { // search for updated contact
//				if (contactData.getContactId().equals(contactId)) {
//					containsUpdatedContact = true;
//				}
//			}
//			assertTrue("Fetch contacts should return recently updated contact", containsUpdatedContact);
//		}
//		
//		/**
//		 * Negative test for updating contacts. Passes a valid customer ID, but
//		 * a ContactDTO with an invalid external ID. Expects a SiebelException
//		 * to be thrown.
//		 */
//		@Test
//		public void updateInvalidContact() {
////			String customerId = "1-47BFBY";
//			String customerId = StringUtils.randomAlphanumericString(8).toUpperCase();
//			ContactDTO contact = createInvalidNewContactDTO();
////			contact.setExternalId(StringUtils.randomAlphanumericString(10).toUpperCase()); // set external ID to invalid value
//			contact.setExternalId("1-96U9TD"); // valid contact ID
//			try {
//				adapter.createOrUpdateContact(customerId, contact);
//				// If we reach this, then there was no exception
//				fail("Expected SiebelException when updating invalid contact");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Negative test for updating contacts. Passes an empty customer ID and
//		 * CustomerDTO, and expects a SiebelException.
//		 */
//		@Test
//		public void updateContactEmptyFields() {
//			String customerId = "";
//			ContactDTO contact = createEmptyContactDTO();
//			try {
//				adapter.createOrUpdateContact(customerId, contact);
//				// If we reach this, then we failed
//				fail("Expected SiebelException when updating empty contact");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Negative test for creating contacts. Passes an invalid customer ID,
//		 * but a valid ContactDTO with valid values and an empty external ID
//		 * (indicating that the contact is to be added). Expects a SiebelException
//		 * to be thrown.
//		 */
//		@Test
//		public void createContactInvalidCustomerId() {
//			String customerId = StringUtils.randomAlphanumericString(7).toUpperCase();
//			ContactDTO contact = createValidNewContactDTO();
//			try {
//				adapter.createOrUpdateContact(customerId, contact);
//				// If we reach this, then there was no exception
//				fail("Expected SiebelException when creating contact with invalid customer ID");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		// TODO add test case for invalid contact - invalid address
//		
//		/**
//		 * Negative test for creating contacts. Passes an empty String as the
//		 * customer ID, and an empty ContactDTO. Expects a SiebelException
//		 * to be thrown.
//		 */
//		@Test
//		public void createContactEmptyFields() {
//			String customerId = "";
//			ContactDTO contact = createEmptyContactDTO();
//			try {
//				adapter.createOrUpdateContact(customerId, contact);
//				// If we reach this, then there was no exception
//				fail("Expected SiebelException when creating contact with empty inputs");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Positive test for fetching contacts. Passes a String representing a valid customer
//		 * ID, and expects a list of CustomerData to be returned.
//		 */
//		@Test
//		public void fetchContactsValidCustomerId() {
//			String customerId = "1-47BFBY";
//			try {
//				List<ContactData> contactDataList = adapter.fetchContacts(customerId);
//				assertFalse("Fetch contacts should not return null for valid cutomer ID", 
//						contactDataList == null);
//				// An empty list is possible for an existing account
//			} catch (SiebelException e) {
//				fail("SiebelException when fetching contacts for a valid customer ID | "
//						+ "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * Negative test for fetching contacts. Passes a String representing an invalid
//		 * customer ID, and expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void fetchContactsInvalidCustomerId() {
//			String customerId = StringUtils.randomAlphanumericString(10).toUpperCase();
//			try {
//				List<ContactData> contactDataList = adapter.fetchContacts(customerId);
//				
//				assertTrue("Fetch contacts should return null for invalid customer ID", 
//						contactDataList == null);
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Negative test for fetching contacts. Passes an empty String as the
//		 * customer ID, and expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void fetchContactsEmptyCustomerId() {
//			String customerId = "";
//			try {
//				List<ContactData> contactDataList = adapter.fetchContacts(customerId);
//				
//				assertTrue("Fetch contacts should return null for empty customer ID", 
//						contactDataList == null);
//			} catch (SiebelException e) {
//				fail("SiebelException when fatching contacts with empty customer ID");
//			}
//		}
//
//	}


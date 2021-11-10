package Pages.Siebel;

//
//	import org.junit.Before;
//	import org.junit.Test;
//	import static org.junit.Assert.*;
//
//	import java.util.List;
//
//	import javax.xml.bind.JAXBException;
//
//	import com.nrg.dsp.service.dto.CustomerDTO;
//
//	import static com.nrg.dsp.service.adapter.siebel.SiebelServiceAdapterIntegrationTestUtils.*;
//
//	/**
//	 * @author adrian.moga
//	 * 
//	 * This class tests the manage customers functionality of the SiebelServiceAdapter. Specifically,
//	 * it tests the ability to create and update customers, as well as to search customers.
//	 */
//	public class ManageCustomersIntegrationTest extends SiebelServiceAdapterIntegrationTestBase {
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
//		 * Positive test for creating and updating customers. Passes a valid CustomerDTO, and 
//		 * expects the customer to be created and a customer ID to be returned. Then, searches
//		 * for the customer, and expects the customer record to be returned. Then, sets the
//		 * customer ID and changes a field, and expects the customer to be updated. Finally,
//		 * searches for the customer again, and expects the customer to be returned, again.
//		 */
//		@Test
//		public void createUpdateAndSearchCustomerValidCustomer() {
//			CustomerDTO customer = createValidCustomerDTO();
//			String customerId = null;
//			
//			try { // try to create the customer
//				customerId = adapter.createCustomer(customer);
//			} catch (SiebelException e) {
//				fail("SiebelException when creating a customer with valid fields | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			assertFalse("Create customer should not return null for valid input", customerId == null);
//			assertFalse("Create customer should not return empty customer ID for valid input", 
//					customerId.isEmpty());
//			
//			customer.setExternalId(customerId); // set customer's external ID
//			
//			List<CustomerDTO> customerSearchResults = null;
//			
//			try { // try to search for created customer
//				customerSearchResults = adapter.searchCustomer(customer);
//			} catch (JAXBException e1) {
//				fail("JAXBExpection when searching for a created customer | "
//						+ "Error: " + e1.getErrorCode());
//			} catch (SiebelException e) {
//				fail("SiebelException when searching for a created customer | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			assertFalse("Search customer should not return null results for created customer", 
//					customerSearchResults == null);
//			assertFalse("Search customer should not return empty results for created customer", 
//					customerSearchResults.isEmpty());
//			boolean containsCustomer = false;
//			for (CustomerDTO customerSearchResult : customerSearchResults) {
//				if (customerSearchResult.getExternalId().equals(customerId)) {
//					containsCustomer = true;
//				}
//			}
//			assertTrue("Search customer should return a created customer", containsCustomer);
//			
//			customer.setBusinessType("Technology"); // change a customer field
//			
//			try { // try to update an existing customer
//				adapter.updateCustomer(customer);
//			} catch (SiebelException e) {
//				fail("SiebelException when updating a valid customer");
//			}
//			
//			try { // try to search for the updated customer
//				customerSearchResults = adapter.searchCustomer(customer);
//			} catch (JAXBException e) {
//				fail("JAXBException when searching for an updated customer | "
//						+ "Error: " + e.getErrorCode());
//			} catch (SiebelException e) {
//				fail("SiebelException when searching for an updated customer | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			assertFalse("Search customer should not return null results for updated customer", 
//					customerSearchResults == null);
//			assertFalse("Search customer should not return empty results for updated customer", 
//					customerSearchResults.isEmpty());
//			containsCustomer = false;
//			for (CustomerDTO customerSearchResult : customerSearchResults) {
//				if (customerSearchResult.getExternalId().equals(customerId)) {
//					containsCustomer = true;
//				}
//			}
//			assertTrue("Search customer should return an updated customer", containsCustomer);
//		}
//		
//		/**
//		 * Negative test for creating a customer. Passes an invalid customer, i.e. a CustomerDTO
//		 * whose fields are all made up, and expects a SiebelException.
//		 */
//		@Test
//		public void createCustomerInvalidCustomer() {
//			CustomerDTO customer = createCustomerDTO("Test Customer", "123 Address St.", "Cityville", "State",
//					"12345", "123-456-7890", "Business Type", "amoga59", "Sales");
//			try {
//				adapter.createCustomer(customer);
//				// If we reach this, then there was no exception
//				fail("Expected SiebelException when creating invalid customer");
//			} catch (SiebelException e) {
//				// Exception expected
//			}
//		}
//		
//		/**
//		 * Negative test for updating a customer. Passes a valid customer with an invalid customer
//		 * ID, i.e. one that is made up. Expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void updateCustomerInvalidCustomerId() {
//			CustomerDTO customer = createCustomerDTO("Adrian Moga", "825 Town and Country Way", 
//					"Houston", "TX", "77024", "(832) 643-9354", "Offices", "kpaturi30", "C&I");
//			String customerId = "dkjfaks";
//			customer.setExternalId(customerId);
//			try {
//				adapter.updateCustomer(customer);
//				// If we reach this, then there was no exception
//				fail("Expected SiebelException when updating a customer with invalid customer ID");
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//		}
//		
//		/**
//		 * Negative test for updating a customer. Passes an invalid customer with an invalid customer
//		 * ID, i.e. all the fields are made up. Expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void updateCustomerInvalidCustomer() {
//			CustomerDTO customer = createCustomerDTO("Test Customer", "123 Address St.", "Cityville", "State",
//					"12345", "123-456-7890", "Business Type", "amoga59", "Sales");
//			String customerId = "kfjalksjdf";
//			customer.setExternalId(customerId);
//			try {
//				adapter.updateCustomer(customer);
//				// If we reach this, then there was no exception
//				fail("Expected SiebelException when updating customer with invalid customer");
//			} catch (SiebelException e) {
//				// Exception expected
//			}
//		}
//		
//		/**
//		 * Negative test for searching customers. Passes an invalid customer, i.e. a CustomerDTO
//		 * with made-up fields. Expects an empty list as the search result.
//		 */
//		@Test
//		public void searchCustomerInvalidCustomer() {
//			CustomerDTO customer = createInvalidCustomerDTO();
//			String customerId = StringUtils.randomAlphanumericString(7).toUpperCase();
//			customer.setExternalId(customerId);
//			List<CustomerDTO> searchResult = null;
//			
//			try {
//				searchResult = adapter.searchCustomer(customer);
//			} catch (JAXBException e) {
//				fail("JAXBException when searching invalid customer | "
//						+ "Error code: " + e.getErrorCode());
//			} catch (SiebelException e) {
//				fail("SiebelException when searching for an invalid customer | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			assertFalse("Search results for invalid customer should not be null", 
//					searchResult == null);
//			assertTrue("Search results for invalid customer should be empty", searchResult.size() == 0);
//		}
//		
//		/**
//		 * Negative test for searching customers. Passes an empty customer, i.e. a CustomerDTO whose
//		 * fields are empty Strings. Expects an empty list as the search result.
//		 */
//		@Test
//		public void searchCustomerEmptyCustomer() {
//			CustomerDTO customer = createCustomerDTO("", "", "", "", "", "", "", "", "");
//			String customerId = "";
//			customer.setExternalId(customerId);
//			List<CustomerDTO> searchResult = null;
//			
//			try {
//				searchResult = adapter.searchCustomer(customer);
//			} catch (JAXBException e) {
//				fail("JAXBException when searching empty customer | "
//						+ "Error code: " + e.getErrorCode());
//			} catch (SiebelException e) {
//				fail("SiebelException when searching for an empty customer | "
//						+ "Error: " + e.getErrorMessage());
//			}
//			
//			assertFalse("Search results for empty customer should not be null", 
//					searchResult == null);
//			assertTrue("Search results for empty customer should be empty", searchResult.size() == 0);
//		}
//	}
//
//}

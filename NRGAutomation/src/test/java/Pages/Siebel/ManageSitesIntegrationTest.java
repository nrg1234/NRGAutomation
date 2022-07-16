package Pages.Siebel;
//
//
//	import static org.junit.Assert.*;
//
//	import java.util.ArrayList;
//	import java.util.Arrays;
//	import java.util.Date;
//	import java.util.List;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.domain.Customer;
//	import com.nrg.dsp.domain.Opportunity;
//	import com.nrg.dsp.service.dto.NewSiteDTO;
//	import com.nrg.dsp.service.dto.ProductContractDTO;
//	import com.nrg.dsp.service.dto.RenewalSiteDTO;
//	import com.siebel.xml.roe_20dsp_20sites_20batch_20result.data.SitesResultData;
//	import com.nrg.dsp.domain.Site;
//
//	import static com.nrg.dsp.service.adapter.siebel.SiebelServiceAdapterIntegrationTestUtils.*;
//
//	/**
//	 * @author adrian.moga
//	 *
//	 * This class tests the functionality of managing sites, i.e. creating new sites,
//	 * adding and/or removing sites from opportunities, and refreshing the site list
//	 * for an opportunity.
//	 */
//
//
//
//	public class ManageSitesIntegrationTest extends SiebelServiceAdapterIntegrationTestBase {
//
//		/**
//		 * SiebelServiceAdapter being tested.
//		 */
//		private SiebelServiceAdapter adapter;
//		private static final String TESTUSERID = "ccollins";
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
//
//
//		/**
//		 * Positive test for creating a site batch. Passes a list of valid sites, and
//		 * expects a valid list of SiteResultData to be returned.
//		 */
//		@Test
//		public void createSiteBatchValidSites() {
//			Site site = createSite("2022 N BROADWAY ST ODLT 1KHPS BUTANE PMP", "BALLINGER",
//					"TX", "768212282", "10204049764592012", "Active", "09", "IDR", "", "",
//					"ERCOT", "WTU_ENERGY", new Date());
//			List<Site> siteList = Arrays.asList(site, site);
//
//			try {
//				List<SitesResultData> sitesResultDataList = adapter.createSiteBatch(siteList,TESTUSERID);
//				
//				assertFalse("Creating a site batch with valid sites should not return null", 
//						sitesResultDataList == null);
//				assertFalse("Creating a site batch with valid sites should not return an empty list",
//						sitesResultDataList.isEmpty());
//				assertTrue("Creating a site batch with valid sites should return sites result data "
//						+ "for each site", sitesResultDataList.size() == 2);
//				// Check sites result data for error messages
//				for (SitesResultData siteResult : sitesResultDataList) {
//					assertTrue("Creating a site batch with valid sites should not result in an error message",
//							siteResult.getErrorMessage().equals("")); // error message not expected
//				}
//			} catch (SiebelException e) {
//				fail("SiebelException when creating a site batch with valid sites | "
//						+ "Error: " + e.getErrorMessage());
//			}
//		}
//
//		/**
//		 * Negative test for creating a site batch. Passes a list of invalid sites, i.e. sites
//		 * whose fields are all made up. Expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void createSiteBatchInvalidSites() {
//			Site site = createSite("123 ADDRESS ST", "CITY", "ST", "770775123", "12345", "ESIDSTATUS", "12345",
//					"YARD", "SMARTMETER", "CONGESTION", "MARKET", "EDC", new Date());
//			List<Site> siteList = Arrays.asList(site, site);
//
//			try {
//				List<SitesResultData> sitesResultDataList = adapter.createSiteBatch(siteList, TESTUSERID);
//				// Ensure there are error messages for the sites
//				assertTrue("Create site batch should return error messages for all invalid sites",
//						sitesResultDataList.size() == 2);
//				for (SitesResultData siteResult : sitesResultDataList) {
//					assertFalse("Creating a site batch with invalid sites should result in an error message",
//							siteResult.getErrorMessage().equals("")); // error message expected
//				}
//			} catch (SiebelException e) {
//				// Exception not unexpected
//			}
//		}
//
//		/**
//		 * Negative test for creating a site batch. Passes a list of empty sites, i.e. sites
//		 * whose fields are all made up. Expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void createSiteBatchListOfEmptySites() {
//			Site site = createSite("", "", "", "", "", "", "", "", "", "", "", "", new Date());
//			List<Site> siteList = Arrays.asList(site, site);
//
//			try {
//				List<SitesResultData> sitesResultDataList = adapter.createSiteBatch(siteList, TESTUSERID);
//				// Ensure there are error messages for the sites
//				assertTrue("Create site batch should return error messages for all empty sites",
//						sitesResultDataList.size() == 2);
//				for (SitesResultData siteResult : sitesResultDataList) {
//					assertFalse("Creating a site batch with invalid sites should result in an error message",
//							siteResult.getErrorMessage().equals("")); // error message expected
//				}
//			} catch (SiebelException e) {
//				// Exception not unexpected
//			}
//		}
//
//		/**
//		 * Negative test for creating a site batch. Passes an empty list as the list of sites,
//		 * and expects a SiebelException to be thrown.
//		 */
//		@Test
//		public void createSiteBatchEmptySitesList() {
//			List<Site> siteList = new ArrayList<Site>();
//
//			try {
//				List<SitesResultData> sitesResultDataList = adapter.createSiteBatch(siteList, TESTUSERID);
//				// Result should be an empty list
//				assertFalse("Create site batch should not return null for empty sites list",
//						sitesResultDataList == null);
//				assertTrue("Create site batch should return an empty list for empty sites list",
//						sitesResultDataList.isEmpty());
//			} catch (SiebelException e) {
//				// Exception not unexpected
//			}
//		}
//
//		/**
//		 * Positive test for adding and removing sites. Passes valid Opportunity
//		 * and Customer objects, along with a String representing a valid site ID.
//		 * Expects a successful return status for adding and removing.
//		 */
//		@Test
//		public void addAndRemoveSiteValidFields() {
//			Opportunity opty = createSimpleOpportunity("1-QPIRXF");
//			opty.setType("New");
//			Customer customer = createCustomer("1-6H3HN");
//			String siteId = "1-7V5AIY-S8";
//			boolean taxExempt = true;
//
//			// Try to add the site
//			String returnStatus = adapter.addSite(opty, customer, siteId, taxExempt);
//
//			assertFalse("Adding a new valid site should not fail", returnStatus.equals("FAIL"));
//
//			// Try to remove the newly added site
//			returnStatus = adapter.removeSite(opty, customer, siteId, taxExempt);
//
//			assertFalse("Removing a valid site should not fail", returnStatus.equals("FAIL"));
//		}
//
//		/**
//		 * Negative test for adding sites. Passes invalid Opportunity and Customer,
//		 * i.e. made-up external IDs, along with a String representing a made-up
//		 * site ID. Expects a failure on the Siebel end.
//		 */
//		@Test
//		public void addSiteInvalidFields() {
//			Opportunity opty = createSimpleOpportunity(StringUtils.randomAlphanumericString(8).toUpperCase());
//			Customer customer = createCustomer(StringUtils.randomAlphanumericString(8).toUpperCase());
//			String siteId = StringUtils.randomAlphanumericString(10).toUpperCase();
//			boolean taxExempt = false;
//
//			String returnStatus = adapter.addSite(opty, customer, siteId, taxExempt);
//
//			assertTrue("Adding a new invalid customer should fail", returnStatus.equals("FAIL"));
//		}
//
//		/**
//		 * Negative test for adding sites. Passes empty Opportunity and Customer
//		 * objects, i.e. no external IDs, as well as an empty String representing
//		 * the site ID. Expects a failure on the Siebel end.
//		 */
//		@Test
//		public void addSiteEmptyFields() {
//			Opportunity opty = createSimpleOpportunity("");
//			Customer customer = createCustomer("");
//			String siteId = "";
//			boolean taxExempt = false;
//
//			String returnStatus = adapter.addSite(opty, customer, siteId, taxExempt);
//
//			assertTrue("Adding a new empty customer should fail", returnStatus.equals("FAIL"));
//		}
//
//		/**
//		 * Negative test for removing sites. Passes invalid Opportunity and
//		 * Customer objects, i.e. the external IDs are made up, as well as a
//		 * String representing a made-up site ID. Expects a failure on the
//		 * Siebel end.
//		 */
//		@Test
//		public void removeSiteInvalidFields() {
//			Opportunity opty = createSimpleOpportunity("0LD-0P7Y");
//			Customer customer = createCustomer("C00574MR");
//			String siteId = "Z1T1L0-VR";
//			boolean taxExempt = false;
//
//			String returnStatus = adapter.removeSite(opty, customer, siteId, taxExempt);
//
//			assertTrue("Removing an invalid customer should fail", returnStatus.equals("FAIL"));
//		}
//
//		/**
//		 * Positive test for refreshing sites list. Passes a String representing a
//		 * valid opty ID, and expects a valid response String representing a positive
//		 * return status.
//		 */
//		@Test
//		public void refreshSitesListValidOptyId() {
//			String optyId = "1-109NRZF";
//			try {
//				String returnStatus = adapter.refreshSitesList(optyId);
//				assertFalse("Site list refresh return status should not be null for valid opty ID",
//						returnStatus == null);
//				assertFalse("Site list refresh return status should not be empty for valid opty ID",
//						returnStatus.isEmpty());
//			} catch (SiebelException e) {
//				fail("Siebel exception when refreshing sites list for valid opty ID | "
//						+ "Error: " + e.getErrorMessage());
//			}
//		}
//
//		/**
//		 * Positive test for new manage site. Passes a valid Opportunity and a list
//		 * of valid NewSiteDTOs, and expects a valid List of Sites.
//		 */
//		@Test
//		public void newManageSiteValidFields() {
//			Opportunity opty = createSimpleOpportunity("1-109NRZF");
//			NewSiteDTO newSite = createNewSiteDTO("1-109NR7T", "1-78A48", true, true);
//			List<NewSiteDTO> newSiteList = Arrays.asList(newSite);
//
//			List<com.siebel.xml.dsp_20oppty_20site.Site> siteList = null;
//
//			try {
//				siteList = adapter.newManageSite(opty, newSiteList, TESTUSERID);
//			} catch (SiebelException e) {
//				fail("New manage site should not fail for valid fields | "
//						+ "Error: " + e.getErrorMessage());
//			}
//
//			assertFalse("New manage site should not return null for valid inputs", siteList == null);
//		}
//
//		/**
//		 * Negative test for new manage site. Passes an invalid Opportunity, but a list of
//		 * valid NewSiteDTOs. Expects a null return value.
//		 */
//		@Test
//		public void newManageSiteInvalidOpty() {
//			Opportunity opty = createSimpleOpportunity(StringUtils.randomAlphanumericString(8).toUpperCase());
//			NewSiteDTO newSite = createNewSiteDTO("1-109NR7T", "1-78A48", true, true);
//			List<NewSiteDTO> newSiteList = Arrays.asList(newSite);
//
//			List<com.siebel.xml.dsp_20oppty_20site.Site> siteList = null;
//
//			try {
//				siteList = adapter.newManageSite(opty, newSiteList, TESTUSERID);
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//
//			assertTrue("New manage site should return null list for invalid opty", siteList == null);
//		}
//
//		/**
//		 * Negative test for new manage site. Passes a valid Opportunity, but a list of
//		 * invalid NewSiteDTOs. Expects a null return value.
//		 */
//		@Test
//		public void newManageSiteInvalidNewSite() {
//			Opportunity opty = createSimpleOpportunity("1-109NRZF");
//			NewSiteDTO newSite = createNewSiteDTO(StringUtils.randomAlphanumericString(8).toUpperCase(),
//					StringUtils.randomAlphanumericString(8).toUpperCase(), true, true);
//			List<NewSiteDTO> newSiteList = Arrays.asList(newSite);
//
//			List<com.siebel.xml.dsp_20oppty_20site.Site> siteList = null;
//
//			try {
//				siteList = adapter.newManageSite(opty, newSiteList, TESTUSERID);
//			} catch (SiebelException e) {
//				// Exception is expected
//			}
//
//			assertTrue("New manage site should return null for invalid site", siteList == null);
//		}
//
//		/**
//		 * Negative test for new manage site. Passes an invalid Opportunity and a list of
//		 * invalid NewSiteDTOs. Expects a null return value.
//		 */
//		@Test
//		public void newManageSiteEmptyFields() {
//			Opportunity opty = createSimpleOpportunity("");
//			NewSiteDTO newSite = createNewSiteDTO("", "", true, true);
//			List<NewSiteDTO> newSiteList = Arrays.asList(newSite);
//
//			List<com.siebel.xml.dsp_20oppty_20site.Site> siteList = null;
//
//			try {
//				siteList = adapter.newManageSite(opty, newSiteList, TESTUSERID);
//			} catch (SiebelException e) {
//				// Exception expected
//			}
//
//			assertTrue("New manage site should return null for empty fields", siteList == null);
//		}
//
//		/**
//		 * Positive test for new manage site renewal. Passes a valid Opportunity, and
//		 * a List of valid RenewalSiteDTOs. Expects a valid List of Sites, i.e.
//		 * the List is not null and not empty.
//		 */
//		@Test
//		public void newManageSiteRenewalValidFields() {
//			Opportunity opty = createSimpleOpportunity("1-109NRZF");
//			ProductContractDTO productContract = createProductContractDTO("1-109OUCS", "291540988662");
//			List<ProductContractDTO> productContractList = Arrays.asList(productContract);
//
//			RenewalSiteDTO renewalSite = createRenewalSiteDTO("1-47BFBY", "1-78A48", true, productContractList);
//			List<RenewalSiteDTO> renewalSiteList = Arrays.asList(renewalSite);
//
//			List<com.siebel.xml.dsp_20oppty_20site.Site> siteList = null;
//
//			try {
//				siteList = adapter.newManageSiteRenewal(opty, renewalSiteList, TESTUSERID);
//			} catch (SiebelException e) {
//				fail("SiebelException when adding new manage site renewal for valid fields | "
//						+ "Error: " + e.getErrorMessage());
//			}
//
//			assertFalse("New manage site renewal should not return null for valid inputs",
//					siteList == null);
//
//			for (com.siebel.xml.dsp_20oppty_20site.Site site : siteList) {
//				assertTrue("New manage site renewal should not have an error message for valid inputs",
//						site.getErrorMessage().isEmpty());
//			}
//		}
//
//		/**
//		 * Negative test for new manage site renewal. Passes an invalid Opportunity and
//		 * an List of invalid RenewalSiteDTOs, i.e. the fields in the objects are made
//		 * up. Expects an invalid List of Sites, i.e. the return should be null.
//		 */
//		@Test
//		public void newManageSiteRenewalInvalidFields() {
//			Opportunity opty = createSimpleOpportunity(StringUtils.randomAlphanumericString(10).toUpperCase());
//
//			ProductContractDTO productContract = createProductContractDTO(
//					StringUtils.randomAlphanumericString(8).toUpperCase(),
//					StringUtils.randomAlphanumericString(8).toUpperCase());
//			List<ProductContractDTO> productContractList = Arrays.asList(productContract);
//
//			RenewalSiteDTO renewalSite = createRenewalSiteDTO("1-C0S7MR", "1-51731D", false, productContractList);
//			List<RenewalSiteDTO> renewalSiteList = Arrays.asList(renewalSite);
//
//			List<com.siebel.xml.dsp_20oppty_20site.Site> siteList = null;
//
//			try {
//				siteList = adapter.newManageSiteRenewal(opty, renewalSiteList, TESTUSERID);
//				// If we reach this, then there was no error
//				fail("New manage site renewal should fail for invalid fields");
//			} catch (SiebelException e) {
//				// Exception expected
//			}
//
//			assertTrue("New namage site renewal should return null for invalid fields", siteList == null);
//		}
//
//	}


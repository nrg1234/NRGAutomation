package Pages.VHOS;
//
//	import static org.junit.Assert.assertFalse;
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import java.text.DateFormat;
//	import java.text.ParseException;
//	import java.text.SimpleDateFormat;
//	import java.util.ArrayList;
//	import java.util.Date;
//	import java.util.LinkedList;
//	import java.util.List;
//	import java.util.UUID;
//
//	import org.apache.commons.lang3.StringUtils;
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.domain.Opportunity;
//	import com.nrg.dsp.domain.Site;
//	import com.nrg.dsp.dto.vhos.VhosOpportunity;
//	import com.nrg.dsp.dto.vhos.VhosOpportunitySite;
//	import com.nrg.dsp.dto.vhos.VhosSiteInfo;
//
//	public class CreateOrUpdateOpportunityIntegrationTest  extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//
//		/**
//		 * testing with valid opportunity and sites
//		 * a vhos opportunity should be returned
//		 */
//		@Test
//		public void createOrUpdateOpportunityByValid() {
//			Opportunity opportunity = new Opportunity();
//			opportunity.setExternalId(validOptyId);
//			UUID id = UUID.randomUUID();
//			opportunity.setId(id);
//
//			opportunity.setName("Example Test");
//			opportunity.setType("New");
//			
//
//	        Date date = new Date();
//			try {
//				date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-01");
//				opportunity.setStartDate(date);
//				
//				date = new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-30");
//				opportunity.setEndDate(date);
//				
//				date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-06-26");
//				opportunity.setDueDate(date);
//				
//			} catch (ParseException e1) {
//
//				e1.printStackTrace();
//			}
//			
//			
//			opportunity.setMarket("ERCOT");
//			opportunity.setMarketSegment("C&I");
//			
//			List<Site> sites = new ArrayList<Site>();
//			Site site = new Site();
//					
//			site.setEsid("10176990000005576");
//			site.setServiceaddress("1256 FM 2972");
//			site.setCity("RUSK");
//			site.setState("TX");
//			site.setZip("757850000");
//			site.setEdc("ONC");
//			site.setCycleNumber("05");
//			site.setStationCode("RSKMN");
//			
//			sites.add(site);
//			
//			try {
//				VhosOpportunity vhosOpportunity = sa.createOrUpdateOpportunity(userId, opportunity, sites, Opportunity.VHOS_OPPORTUNITY_LOAD);
//				assertTrue(true);
//			} catch(VhosException e) {
//				e.printStackTrace();
//				fail("VhosException when creating or updating opportunity with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with valid opportunity and sites
//		 * a vhos opportunity should be returned
//		 */
//		@Test
//		public void updateOpportunity() {
//			Opportunity opportunity = new Opportunity();
//			opportunity.setExternalId(validOptyId);
//			UUID id = UUID.randomUUID();
//			opportunity.setId(id);
//			
//			opportunity.setName("Example Test");
//			opportunity.setType("New");
//			
//	        Date date = new Date();
//			try {
//				date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-01");
//				opportunity.setStartDate(date);
//				
//				date = new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-30");
//				opportunity.setEndDate(date);
//				
//				date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-06-26");
//				opportunity.setDueDate(date);
//				
//			} catch (ParseException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			
//			opportunity.setMarket("ERCOT");
//			opportunity.setMarketSegment("C&I");
//			
//			List<Site> sites = new ArrayList<Site>();
//			Site site = new Site();
//					
//			site.setEsid("10176990000005576");
//			site.setServiceaddress("1256 FM 2972");
//			site.setCity("RUSK");
//			site.setState("TX");
//			site.setZip("757850000");
//			site.setEdc("ONC");
//			site.setCycleNumber("05");
//			site.setStationCode("RSKMN");
//			
//			sites.add(site);
//			
//			try {
//				VhosOpportunity vhosOpportunity = sa.createOrUpdateOpportunity(userId, opportunity, sites, Opportunity.VHOS_OPPORTUNITY_LOAD);
//				String date1 = vhosOpportunity.getDueDate();
//				date = new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-16");
//				opportunity.setDueDate(date);
//				vhosOpportunity = sa.createOrUpdateOpportunity("tester", opportunity, sites, Opportunity.VHOS_OPPORTUNITY_LOAD);
//				String date2 = vhosOpportunity.getDueDate();
//				assertTrue( !date1.equals(date2) && date2.equals("2022-07-16") );
//			} catch(VhosException e) {
//				fail("VhosException when creating or updating opportunity with valid fields\n" + "Error: " + e.getErrorMessage());
//			} catch( ParseException e ) {
//				e.printStackTrace();
//			}
//		}
//		
//		/**
//		 * testing with invalid opportunity external id
//		 * a vhos opportunity should not be returned, VhosException should be thrown
//		 */
//		@Test
//		public void createOrUpdateOpportunityByInvalidOpportunityId() {
//			Opportunity opportunity = new Opportunity();
//			opportunity.setExternalId(invalidOptyId);
//			UUID id = UUID.randomUUID();
//			opportunity.setId(id);
//
//			opportunity.setName("Example Test");
//			opportunity.setType("New");
//			
//
//	        Date date = new Date();
//			try {
//				date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-01");
//				opportunity.setStartDate(date);
//				
//				date = new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-30");
//				opportunity.setEndDate(date);
//				
//				date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-06-26");
//				opportunity.setDueDate(date);
//				
//			} catch (ParseException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			
//			opportunity.setMarket("ERCOT");
//			opportunity.setMarketSegment("C&I");
//			
//			List<Site> sites = new ArrayList<Site>();
//			Site site = new Site();
//					
//			site.setEsid("10176990000005576");
//			site.setServiceaddress("1256 FM 2972");
//			site.setCity("RUSK");
//			site.setState("TX");
//			site.setZip("757850000");
//			site.setEdc("ONC");
//			site.setCycleNumber("05");
//			site.setStationCode("RSKMN");
//			
//			sites.add(site);
//			
//			try {
//				VhosOpportunity vhosOpportunity = sa.createOrUpdateOpportunity(userId, opportunity, sites, Opportunity.VHOS_OPPORTUNITY_LOAD);
//				if(vhosOpportunity != null) {
//					fail("Expected VhosException when creating or updating opportunity with invalid fields");
//				}
//			} catch(VhosException e) {
//				assertTrue(true);
//			}
//		}
//		
//	}
//
//}

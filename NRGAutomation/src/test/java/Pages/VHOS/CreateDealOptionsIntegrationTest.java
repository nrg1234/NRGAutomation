package Pages.VHOS;

//
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import java.text.SimpleDateFormat;
//	import java.util.ArrayList;
//	import java.util.Date;
//	import java.util.HashMap;
//	import java.util.List;
//	import java.util.Map;
//	import java.util.UUID;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.domain.Opportunity;
//	import com.nrg.dsp.domain.doa.DealOption;
//	import com.nrg.dsp.dto.vhos.VhosDealOption;
//	import com.nrg.dsp.service.dto.CreateDealOptionDTO;
//
//	public class CreateDealOptionsIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//
//		/**
//		 * testing with valid opportunity and deal options data
//		 * list of deal options info should be returned
//		 */
//		@Test
//		public void createDealOptionsValid() {
//			Opportunity opportunity = new Opportunity();
//			List<DealOption> dealOptions = new ArrayList<DealOption>();
//			Map<UUID, CreateDealOptionDTO> dealOptionMap = new HashMap<>();
//			DealOption dealOption = new DealOption();
//			
//			opportunity.setExternalId(validOptyId);
//			UUID id = UUID.randomUUID();
//			dealOption.setName("Just Testing");
//			
//			 Date date = new Date();
//			 try {
//				date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-06-27");
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//			id = UUID.randomUUID();
//			dealOption.setId(id);
//			dealOption.setSequenceId("15");
//			dealOption.setStartDate(date);
//			dealOption.setNotionalValue(null);
//			dealOption.setBadDebt(null);
//			dealOption.setOperationalCost(null);
//			dealOption.setUpfrontCost(null);
//			dealOption.setEbitda(null);
//			dealOption.setCreatedBy(userId);
//			dealOption.setLastModifiedBy(userId);
//			
//			VhosDealOption vhosDealOption = new VhosDealOption();
//			vhosDealOption.setAdder(new Float(1.0));
//			vhosDealOption.setAncillaryBundled(true);
//			vhosDealOption.setBadDebt(new Float(1.0));
//			vhosDealOption.setBasisHubzone(true);
//			vhosDealOption.setBrokerFee(new Float(1.0));
//			vhosDealOption.setCollateral(new Float(1.0));
//			vhosDealOption.setContractPrice(new Float(1.0));
//			vhosDealOption.setDoaMargin(new Float(1.0));
//			vhosDealOption.setEbitda(new Float(1.0));
//			vhosDealOption.setIntradayAdjustment(new Float(1.0));
//			vhosDealOption.setLossesBundled(true);
//			vhosDealOption.setMargin(new Float(1.0));
//			vhosDealOption.setName("Test");
//			vhosDealOption.setNotionalValue(new Float(1.0));
//			vhosDealOption.setOperationalCosts(new Float(1.0));
//			vhosDealOption.setPeakLoad(new Float(1.0));
//			vhosDealOption.setProductType("Fixed Price");
//			vhosDealOption.setSequenceId("15");
//			vhosDealOption.setStartDate("11/12/2019");
//			vhosDealOption.setTerm(6);
//			vhosDealOption.setTermLoad(new Float(1.0));
//			vhosDealOption.setTotalCogs(new Float(1.0));
//			vhosDealOption.setUpfrontCosts(new Float(1.0));
//
//			CreateDealOptionDTO createDealOption = new CreateDealOptionDTO();
//			createDealOption.setVhosDealOption(vhosDealOption);
//			
//			dealOptions.add(dealOption);
//			dealOptionMap.put(id, createDealOption);
//			
//			try {
//				sa.createDealOptions(userId, opportunity, dealOptions, dealOptionMap, UUID.randomUUID());
//				assertTrue(true);
//			} catch (VhosException e) {
//				e.printStackTrace();
//				fail("VhosException when creating deal option with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//	}
//
//}

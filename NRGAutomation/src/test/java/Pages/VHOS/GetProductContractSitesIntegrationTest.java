package Pages.VHOS;
//
//
//	import static org.junit.Assert.assertFalse;
//	import static org.junit.Assert.assertTrue;
//	import static org.junit.Assert.fail;
//
//	import java.util.ArrayList;
//	import java.util.List;
//
//	import org.junit.Before;
//	import org.junit.Test;
//
//	import com.nrg.dsp.dto.vhos.VhosCustomerContractSite;
//	import com.nrg.dsp.dto.vhos.VhosCustomerContractSitesSend;
//	import com.nrg.dsp.dto.vhos.VhosProductContractSend;
//	import com.nrg.dsp.dto.vhos.VhosSiteRenewal;
//
//	public class GetProductContractSitesIntegrationTest extends VhosIntegrationTestBase {
//		private VhosServiceAdapter sa;
//		
//		@Before
//		public void setUp() {
//			sa = setupAdapter();
//		}
//		
//		/**
//		 * testing with valid product contracts
//		 * customer contract sites sent list should be returned
//		 */
//		@Test
//		public void getProductContractSitesByValidProductContracts() {
//			VhosCustomerContractSitesSend vccss = new VhosCustomerContractSitesSend();
//			
//			VhosProductContractSend vpcs = new VhosProductContractSend();
//			vpcs.setContractId(validContractProductPairC);
//			vpcs.setProductId(validContractProductPairP);
//			List<VhosProductContractSend> productContracts = new ArrayList<VhosProductContractSend>();
//			productContracts.add(vpcs);
//			
//			vccss.setProductContracts(productContracts);
//			
//			try {
//				List<VhosCustomerContractSite> customerContractsSitesSend = sa.getProductContractSites(vccss, userId);
//				assertTrue(!customerContractsSitesSend.isEmpty());
//			} catch (VhosException e) {
//				fail("VhosException when getting product contract sites with valid fields\n" + "Error: " + e.getErrorMessage());
//			}
//		}
//		
//		/**
//		 * testing with invalid product id
//		 * customer contract sites sent list should not be found, VhosException should be thrown
//		 * does not matter what the contract id is set to, as long as the product id is 	
//		 * 		incorrect the test will fail
//		 */
//		@Test
//		public void getProductContractSitesByInvalidProductContracts() {
//			VhosCustomerContractSitesSend vccss = new VhosCustomerContractSitesSend();
//			
//			VhosProductContractSend vpcs = new VhosProductContractSend();
//			vpcs.setContractId(invalidContractId);
//			vpcs.setProductId(invalidProductId);
//			List<VhosProductContractSend> productContracts = new ArrayList<VhosProductContractSend>();
//			productContracts.add(vpcs);
//			
//			vccss.setProductContracts(productContracts);
//			
//			try {
//				List<VhosCustomerContractSite> customerContractsSitesSend = sa.getProductContractSites(vccss, userId);
//				if(!customerContractsSitesSend.isEmpty()) {
//					fail("Expected VhosException when getting product contract sites with invalid fields");
//				}
//			} catch (VhosException e) {
//				assertTrue(true);
//			}
//		}
//	}
//
//}

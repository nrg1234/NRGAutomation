package Pages.VHOS;
//
//
//	import org.mapstruct.factory.Mappers;
//	import org.springframework.beans.factory.annotation.Autowired;
//	import java.io.FileInputStream;
//	import java.io.FileNotFoundException;
//	import java.io.IOException;
//	import java.util.Properties;
//	import com.nrg.dsp.util.AppLogger;
//
//	import com.nrg.dsp.config.VhosConfig;
//	import com.nrg.dsp.repository.AppLoggerRepository;
//	import com.nrg.dsp.repository.applicationlog.ApplicationLogRepository;
//	import com.nrg.dsp.service.mapper.DtoMapper;
//	import com.nrg.dsp.util.RequestFactory;
//
//
//	public class VhosIntegrationTestBase {
//		
//		@Autowired
//		private DtoMapper dtoMapper = Mappers.getMapper(DtoMapper.class);
//		
//
//		@Autowired
//		private AppLogger appLogger = new AppLogger();
//		
//		protected String userId;
//		protected String validOptyId;
//		protected String invalidOptyId;
//		protected String validOptyContractPairO;
//		protected String validOptyContractPairC;
//		protected String invalidContractId;
//		protected String validCustomerId;
//		protected String invalidCustomerId;
//		protected String validOptyDealOptionPairO;
//		protected String validOptyDealOptionPairD;
//		protected String invalidDealOptionId;
//		protected String validEsid;
//		protected String validEdc;
//		protected String invalidEsid;
//		protected String invalidEdc;
//		protected String validProductId;
//		protected String invalidProductId;
//		protected String validContractProductPairC;
//		protected String validContractProductPairP;
//		protected String validDealOptionId;
//		protected String validOptyCustomerPairO;
//		protected String validOptyCustomerPairC;
//		protected String validOptyPodPairO;
//		protected String validOptyPodPairP;
//		
//		private String getVhosServiceUrl1() {
//			String propertiesRootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//			String appPropertiesPath = propertiesRootPath + "adapter.urls.properties";
//			
//			Properties props = new Properties();
//			try {
//				props.load(new FileInputStream(appPropertiesPath));
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//				System.exit(1);
//			} catch (IOException e) {
//				e.printStackTrace();
//				System.exit(1);
//			}
//			
//			return props.getProperty("vhos.service.url1");
//		}
//		
//		private String getVhosServiceUrl2() {
//			String propertiesRootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//			String appPropertiesPath = propertiesRootPath + "adapter.urls.properties";
//			
//			Properties props = new Properties();
//			try {
//				props.load(new FileInputStream(appPropertiesPath));
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//				System.exit(1);
//			} catch (IOException e) {
//				e.printStackTrace();
//				System.exit(1);
//			}
//			
//			return props.getProperty("vhos.service.url2");
//		}
//		
//		private String getVhosServiceUrl3() {
//			String propertiesRootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//			String appPropertiesPath = propertiesRootPath + "adapter.urls.properties";
//			
//			Properties props = new Properties();
//			try {
//				props.load(new FileInputStream(appPropertiesPath));
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//				System.exit(1);
//			} catch (IOException e) {
//				e.printStackTrace();
//				System.exit(1);
//			}
//			
//			return props.getProperty("vhos.service.url3");
//		}
//
//		public void initializeData() {
//			String propertiesRootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//			String appPropertiesPath = propertiesRootPath + "vhos.data.properties";
//			
//			Properties props = new Properties();
//			try {
//				props.load(new FileInputStream(appPropertiesPath));
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//				System.exit(1);
//			} catch (IOException e) {
//				e.printStackTrace();
//				System.exit(1);
//			}
//			
//			userId = props.getProperty("userId");
//			validOptyId = props.getProperty("valid.optyId");
//			invalidOptyId = props.getProperty("invalid.externalId");
//			validOptyContractPairO = props.getProperty("valid.optyId.contractId.pair.o");
//			validOptyContractPairC = props.getProperty("valid.optyId.contractId.pair.c");
//			invalidContractId = props.getProperty("invalid.externalId");
//			validCustomerId = props.getProperty("valid.customerId");
//			invalidCustomerId = props.getProperty("invalid.externalId");
//			validOptyDealOptionPairO = props.getProperty("valid.optyId.dealOptionId.pair.o");
//			validOptyDealOptionPairD = props.getProperty("valid.optyId.dealOptionId.pair.d");
//			invalidDealOptionId = props.getProperty("invalid.externalId");
//			validEsid = props.getProperty("valid.esid");
//			validEdc = props.getProperty("valid.edc");
//			invalidEsid = props.getProperty("invalid.esid");
//			invalidEdc = props.getProperty("invalid.edc");
//			validProductId = props.getProperty("valid.productId");
//			invalidProductId = props.getProperty("invalid.externalId");
//			validContractProductPairC = props.getProperty("valid.contractId.productId.pair.c");
//			validContractProductPairP = props.getProperty("valid.contractId.productId.pair.p");
//			validDealOptionId = props.getProperty("valid.dealOptionId");
//			validOptyCustomerPairO = props.getProperty("valid.optyId.customerId.pair.o");
//			validOptyCustomerPairC = props.getProperty("valid.optyId.customerId.pair.c");
//			validOptyPodPairO = props.getProperty("valid.optyId.pod.pair.o");
//			validOptyPodPairP = props.getProperty("valid.optyId.pod.pair.p");
//		}
//		
//
//		public VhosServiceAdapter setupAdapter() {
//			VhosConfig config = new VhosConfig();
//	        RequestFactory requestFactory = new RequestFactory();
//	        requestFactory.init();
//	        config.setServiceUrl(getVhosServiceUrl1());
//	        config.setProposalServiceUrl(getVhosServiceUrl3());
//	        VhosServiceAdapter sa = new VhosServiceAdapter(config, requestFactory, dtoMapper, new AppLogger());
//
//	        initializeData();
//
//	        return sa;
//		}
//		
//		public VhosServiceAdapter setupAdapter2() {
//			VhosConfig config = new VhosConfig();
//	        RequestFactory requestFactory = new RequestFactory();
//	        requestFactory.init();
//	        config.setServiceUrl(getVhosServiceUrl2()); 
//	        VhosServiceAdapter sa = new VhosServiceAdapter(config, requestFactory, dtoMapper, new AppLogger());
//	   
//	        return sa;
//		}
//		
//	}
//
//}

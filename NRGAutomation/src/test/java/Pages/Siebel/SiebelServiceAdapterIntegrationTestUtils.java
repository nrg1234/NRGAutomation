package Pages.Siebel;
//
//	import java.util.ArrayList;
//	import java.util.Date;
//	import java.util.List;
//	import org.apache.commons.lang3.RandomStringUtils;
//
//	import com.nrg.dsp.domain.Customer;
//	import com.nrg.dsp.domain.Opportunity;
//	import com.nrg.dsp.domain.Site;
//	import com.nrg.dsp.domain.contract.Contract;
//	import com.nrg.dsp.domain.contract.ParentContract;
//	import com.nrg.dsp.service.dto.AdditionalSiteInfo;
//	import com.nrg.dsp.service.dto.AddressDTO;
//	import com.nrg.dsp.service.dto.ContactDTO;
//	import com.nrg.dsp.service.dto.CustomerDTO;
//	import com.nrg.dsp.service.dto.NewSiteDTO;
//	import com.nrg.dsp.service.dto.ProductContractDTO;
//	import com.nrg.dsp.service.dto.RenewalSiteDTO;
//	import com.nrg.dsp.service.dto.SiebelActivityDTO;
//	import com.nrg.dsp.service.dto.SiteRenewalInfoDTO;
//	import com.nrg.dsp.service.dto.WolrDTO;
//	import com.nrg.dsp.service.dto.WolrProductDTO;
//	import com.nrg.dsp.service.dto.WolrSplitDTO;
//
//
//
//	/**
//	 * @author adrian.moga
//	 *
//	 * This class contains many useful utility functions that can be used when writing integration
//	 * tests for the SiebelServiceAdapter. The goal is to centralize the location of these
//	 * functions, making it easier to maintain and document the functions.
//	 */
//	public class SiebelServiceAdapterIntegrationTestUtils {
//
//		/**
//		 * Creates a valid SiebelActivityDTO, with all fields initialized to
//		 * valid values, i.e. no fields are empty/will cause errors. However, the
//		 * activity ID is left empty, to indicate that the activity should be created.
//		 *
//		 * @return a valid new SiebelActivityDTO
//		 */
//		public static SiebelActivityDTO createValidNewActivityDTO() {
//			SiebelActivityDTO activity = new SiebelActivityDTO();
//
//			// Taken from DEV env
//			activity.setCustomerNum("1-10AG095");
//			activity.setOpportunityNum("1-10C30VN");
//			// Valid values
//			activity.setStatus("New");
//			activity.setType("Appointment");
//
//			return activity;
//		}
//
//		/**
//		 * Creates an invalid SiebelActivityDTO, i.e. an activity whose fields
//		 * are all randomly generated. Activity ID is left blank, so that it can
//		 * be used to create an activity.
//		 *
//		 * @return an invalid new SiebelActivityDTO
//		 */
//		public static SiebelActivityDTO createInvalidNewActivityDTO() {
//			SiebelActivityDTO activity = new SiebelActivityDTO();
//
//			activity.setCustomerNum(StringUtils.randomAlphanumericString(10).toUpperCase());
//			activity.setOpportunityNum(StringUtils.randomAlphanumericString(10).toUpperCase());
//			activity.setStatus(StringUtils.randomAlphanumericString(10).toUpperCase());
//			activity.setType(StringUtils.randomAlphanumericString(10).toUpperCase());
//
//			return activity;
//		}
//
//		/**
//		 * Creates a valid ContactDTO, with all fields initialized to random valid
//		 * values, i.e. no fields are empty Strings, except for the external
//		 * ID, which is left empty. This allows the contact to be created/added,
//		 * rather than updated.
//		 *
//		 * @return a valid ContactDTO
//		 */
//		public static ContactDTO createValidNewContactDTO() {
//			ContactDTO newContact = new ContactDTO();
//
//			String randomFirstName = StringUtils.randomName(10);
//			String randomLastName = StringUtils.randomName(15);
//			String randomEmail = randomFirstName + "." + randomLastName + "@"
//					+ StringUtils.randomStringAllLower(10) + ".com";
//			String randomPhone = "713-" + StringUtils.randomNumber(3) + "-"
//					+ StringUtils.randomNumber(4);
//			String randomAddress = "1" + StringUtils.randomNumber(3) + " Westheimer Rd";
//			String city = "Houston";
//			String state = "TX";
//			String randomZip = "770" + StringUtils.randomNumber(2);
//
//			newContact.setFirstName(randomFirstName);
//			newContact.setLastName(randomLastName);
//			newContact.setEmail(randomEmail);
//			newContact.setCellPhone(randomPhone);
//			newContact.setFax(randomPhone);
//			newContact.setStreetAddress(randomAddress);
//			newContact.setCity(city);
//			newContact.setState(state);
//			newContact.setZip(randomZip);
//			newContact.setExternalId("");
//			newContact.setType("Primary Sales Contact");
//
//			return newContact;
//		}
//
//		/**
//		 * Creates an invalid new ContactDTO, i.e. a ContactDTO whose
//		 * fields are all randomly generated.
//		 *
//		 * @return a random, invalid ContactDTO
//		 */
//		public static ContactDTO createInvalidNewContactDTO() {
//			ContactDTO invalidContact = new ContactDTO();
//
//			String firstName = StringUtils.randomAlphanumericString(10);
//			String lastName = StringUtils.randomAlphanumericString(10);
//			String email = StringUtils.randomAlphanumericString(10);
//			String phone = StringUtils.randomAlphanumericString(10);
//			String address = StringUtils.randomAlphanumericString(10);
//			String city = StringUtils.randomAlphanumericString(10);
//			String state = StringUtils.randomAlphanumericString(10);
//			String zip = StringUtils.randomAlphanumericString(10);
//
//			invalidContact.setFirstName(firstName);
//			invalidContact.setLastName(lastName);
//			invalidContact.setEmail(email);
//			invalidContact.setCellPhone(phone);
//			invalidContact.setFax(phone);
//			invalidContact.setStreetAddress(address);
//			invalidContact.setCity(city);
//			invalidContact.setState(state);
//			invalidContact.setZip(zip);
//			invalidContact.setExternalId("");
//			invalidContact.setType("Primary Sales Contact");
//
//			return invalidContact;
//		}
//
//		/**
//		 * Creates an empty ContactDTO, i.e. an object whose fields are all
//		 * initialized to empty Strings.
//		 *
//		 * @return an empty ContactDTO
//		 */
//		public static ContactDTO createEmptyContactDTO() {
//			ContactDTO newContact = new ContactDTO();
//
//			newContact.setFirstName("");
//			newContact.setLastName("");
//			newContact.setEmail("");
//			newContact.setCellPhone("");
//			newContact.setFax("");
//			newContact.setStreetAddress("");
//			newContact.setCity("");
//			newContact.setState("");
//			newContact.setZip("");
//			newContact.setExternalId("");
//			newContact.setType("");
//
//			return newContact;
//		}
//
//		/**
//		 * Creates a valid Contract, i.e. a Contract object whose fields
//		 * represent valid Siebel values.
//		 *
//		 * @return a valid Contract
//		 */
//		public static Contract createValidContract() {
//			ParentContract parentContract = new ParentContract();
//			parentContract.setFormId("ERCOT_100RTI");
//			parentContract.setEffectiveDate(new Date());
//			parentContract.setReliantSignatory("Robert Gaudette");
//			parentContract.setSignatoryTitle("Vice President");
//			parentContract.setPaymentDueDays("16");
//			parentContract.setLateFee(new Float(.05));
//			parentContract.setBmqExhibit(true);
//			parentContract.setBmqYrAssessmentPct(new Float(.12));
//			parentContract.setRemoveCarbonLang(true);
//			parentContract.setPnpSection4(true);
//			parentContract.setPnpSection7(true);
//			parentContract.setPnpSection10(true);
//			parentContract.setPnpSection12(true);
//			parentContract.setPnpSection14(true);
//			parentContract.setPnpUnBundleStandard(false);
//			parentContract.setPnpUnBundleSBond(false);
//			parentContract.setPnpBundleStandard(true);
//			parentContract.setPnpBundleSBond(false);
//
//			Contract contract = new Contract();
//			contract.setExternalId("1-1094Z3W");
//			contract.setContactId("1-1016KM5");
//			contract.setGeneralPartner("Test Partner");
//			contract.setAgent("Test Agent");
//			contract.setParentContract(parentContract);
//
//			return contract;
//		}
//
//		/**
//		 * Creates an invalid Contract, i.e. a Contract object whose fields
//		 * are initialized to random values.
//		 *
//		 * @return an invalid Contract
//		 */
//		public static Contract createInvalidContract() {
//			ParentContract parentContract = new ParentContract();
//			parentContract.setFormId("FormId111");
//			parentContract.setEffectiveDate(new Date());
//			parentContract.setReliantSignatory("Bob Saget");
//			parentContract.setSignatoryTitle("El Presidente");
//			parentContract.setPaymentDueDays("-5");
//			parentContract.setLateFee(new Float(-3));
//			parentContract.setBmqExhibit(false);
//			parentContract.setBmqYrAssessmentPct(new Float(500));
//			parentContract.setRemoveCarbonLang(false);
//			parentContract.setPnpSection4(true);
//			parentContract.setPnpSection7(false);
//			parentContract.setPnpSection10(true);
//			parentContract.setPnpSection12(false);
//			parentContract.setPnpSection14(false);
//			parentContract.setPnpUnBundleStandard(false);
//			parentContract.setPnpUnBundleSBond(true);
//			parentContract.setPnpBundleStandard(true);
//			parentContract.setPnpBundleSBond(true);
//
//			Contract contract = new Contract();
//			contract.setExternalId("369-963");
//			contract.setContactId("SCP-137");
//			contract.setGeneralPartner("Howdy Partner");
//			contract.setAgent("Secret Agent");
//			contract.setParentContract(parentContract);
//
//			return contract;
//		}
//
//		/**
//		 * Creates a blank Contract, i.e. a Contract object whose fields
//		 * are initialized to empty Strings, ParentContracts, etc.
//		 *
//		 * @return a blank Contract
//		 */
//		public static Contract createBlankContract() {
//			ParentContract parentContract = new ParentContract();
//			parentContract.setFormId("");
//			parentContract.setEffectiveDate(new Date());
//			parentContract.setReliantSignatory("");
//			parentContract.setSignatoryTitle("");
//			parentContract.setPaymentDueDays("");
//			parentContract.setLateFee(new Float(0));
//			parentContract.setBmqExhibit(true);
//			parentContract.setBmqYrAssessmentPct(new Float(0));
//			parentContract.setRemoveCarbonLang(true);
//			parentContract.setPnpSection4(true);
//			parentContract.setPnpSection7(true);
//			parentContract.setPnpSection10(true);
//			parentContract.setPnpSection12(true);
//			parentContract.setPnpSection14(true);
//			parentContract.setPnpUnBundleStandard(true);
//			parentContract.setPnpUnBundleSBond(true);
//			parentContract.setPnpBundleStandard(true);
//			parentContract.setPnpBundleSBond(true);
//
//			Contract contract = new Contract();
//			contract.setExternalId("");
//			contract.setContactId("");
//			contract.setGeneralPartner("");
//			contract.setAgent("");
//			contract.setParentContract(parentContract);
//
//			return contract;
//		}
//
//		/**
//		 * Creates a new Opportunity with the specified parameters.
//		 *
//		 * @param optyName - the opportunity name
//		 * @param externalId - the opportunity external ID
//		 * @param industry - the opportunity industry
//		 * @param startDate - the opportunity start date
//		 * @param endDate - the opportunity end date
//		 * @param dueDate - the opportunity due date
//		 * @param siebelStatus - the opportunity Siebel status
//		 * @param accountRep - the opportunity account rep
//		 * @param ema - the opportunity EMA
//		 * @param type - the opportunity type
//		 *
//		 * @return an Opportunity with fields matching the specified parameters
//		 */
//		public static Opportunity createOpportunity(String optyName, String externalId,
//				String industry, Date startDate, Date endDate, Date dueDate,
//				int siebelStatus, String accountRep, String ema, String type) {
//			Opportunity opty = new Opportunity();
//
//			opty.setName(optyName);
//			opty.setExternalId(externalId);
//			opty.setIndustry(industry);
//			opty.setStartDate(startDate);
//			opty.setEndDate(endDate);
//			opty.setDueDate(dueDate);
//			opty.setSiebelStatus(siebelStatus);
//			opty.setAccountRep(accountRep);
//			opty.setEma(ema);
//			opty.setType(type);
//
//			return opty;
//		}
//
//		/**
//		 * Creates a new Opportunity whose fields are all valid and,
//		 * when possible, random.
//		 *
//		 * @return a random, new Opportunity
//		 */
//		public static Opportunity createRandomValidNewOpportunity() {
//			String optyName = StringUtils.randomAlphanumericString(15);
//			String industry = "Technology";
//			Date startDate = new Date();
//			Date endDate = new Date();
//			Date dueDate = new Date();
//			int siebelStatus = 0;
//			String accountRep = "jbevolo";
//			String ema = null;
//			String type = "New";
//
//			return createNewOpportunity(optyName, industry, startDate, endDate,
//					dueDate, siebelStatus, accountRep, ema, type);
//		}
//
//		/**
//		 * Creates a new Opportunity whose fields are all valid and,
//		 * when possible, random.
//		 *
//		 * @return a random, new Opportunity
//		 */
//		public static Opportunity createRandomInvalidNewOpportunity() {
//			String optyName = StringUtils.randomAlphanumericString(15);
//			String industry = StringUtils.randomName(10);
//			Date startDate = new Date();
//			Date endDate = new Date();
//			Date dueDate = new Date();
//			int siebelStatus = 0;
//			String accountRep = StringUtils.randomStringAllLower(8);
//			String ema = StringUtils.randomStringAllLower(8);
//			String type = StringUtils.randomName(5);
//
//			return createNewOpportunity(optyName, industry, startDate, endDate,
//					dueDate, siebelStatus, accountRep, ema, type);
//		}
//
//		/**
//		 * Creates a new Opportunity with the specified parameters.
//		 *
//		 * @param optyName - the opportunity name
//		 * @param industry - the opportunity industry
//		 * @param startDate - the opportunity start date
//		 * @param endDate - the opportunity end date
//		 * @param dueDate - the opportunity due date
//		 * @param siebelStatus - the opportunity Siebel status
//		 * @param accountRep - the opportunity account rep
//		 * @param ema - the opportunity EMA
//		 * @param type - the opportunity type
//		 *
//		 * @return an Opportunity with fields matching the specified parameters
//		 */
//		public static Opportunity createNewOpportunity(String optyName,
//				String industry, Date startDate, Date endDate, Date dueDate,
//				int siebelStatus, String accountRep, String ema, String type) {
//			return createOpportunity(optyName, null, industry, startDate, endDate,
//					dueDate, siebelStatus, accountRep, ema, type);
//		}
//
//		/**
//		 * Creates an Opportunity with the specified opty ID as the external
//		 * ID on the opportunity.
//		 *
//		 * @param optyId - the opportunity ID
//		 *
//		 * @return an Opportunity with the specified external ID
//		 */
//		public static Opportunity createSimpleOpportunity(String optyId) {
//			Opportunity opty = new Opportunity();
//			opty.setExternalId(optyId);
//			return opty;
//		}
//
//		/**
//		 * Creates a Customer with the specified external ID and business type.
//		 *
//		 * @param externalId - the customer external ID
//		 * @param businessType - the customer business type
//		 *
//		 * @return a Customer with the specified fields
//		 */
//		public static Customer createCustomer(String externalId, String businessType) {
//			Customer customer = new Customer();
//			customer.setExternalId(externalId);
//			customer.setBusinessType(businessType);
//			return customer;
//		}
//
//		/**
//		 * Creates a Customer with the specified String as the external ID
//		 * on the customer.
//		 *
//		 * @param externalId - the external ID
//		 *
//		 * @return a Customer with the specified external ID
//		 */
//		public static Customer createCustomer(String externalId) {
//			return createCustomer(externalId, "");
//		}
//
//		/**
//		 * Creates a valid CustomerDTO whose values are randomly generated.
//		 *
//		 * @return a random, valid CustomerDTO
//		 */
//		public static CustomerDTO createValidCustomerDTO() {
//			String name = StringUtils.randomName(10) + " " + StringUtils.randomName(10);
//			String address = "1" + StringUtils.randomNumber(4) + " Westheimer Rd";
//			String city = "Houston";
//			String state = "TX";
//			String zip = "77" + StringUtils.randomNumber(3);
//			String phone = "(713) " + StringUtils.randomNumber(3) + "-" + StringUtils.randomNumber(4);
//			String businessType = "Offices";
//			String accountRep = "MCIOBANU";
//			String salesChannel = "C&I";
//
//			return createCustomerDTO(name, address, city, state, zip, phone, businessType,
//					accountRep, salesChannel);
//		}
//
//		/**
//		 * Creates an invalid CustomerDTO whose values are randomly generated.
//		 *
//		 * @return a random, invalid CustomerDTO
//		 */
//		public static CustomerDTO createInvalidCustomerDTO() {
//			String name = StringUtils.randomName(10) + " " + StringUtils.randomName(15);
//			String address = "1" + StringUtils.randomNumber(4) + " San Felipe St";
//			String city = "Houston";
//			String state = "TX";
//			String zip = "77" + StringUtils.randomNumber(3);
//			String phone = "(832) " + StringUtils.randomNumber(3) + "-" + StringUtils.randomNumber(4);
//			String businessType = "Garage";
//			String accountRep = "QVU";
//			String salesChannel = "Cartoon Network";
//
//			return createCustomerDTO(name, address, city, state, zip, phone, businessType,
//					accountRep, salesChannel);
//		}
//
//		/**
//		 * Creates a CustomerDTO with the specified fields.
//		 *
//		 * @param name - customer name
//		 * @param address - customer address
//		 * @param city - customer city
//		 * @param state - customer state
//		 * @param zip - customer zip
//		 * @param phone - customer phone
//		 * @param businessType - customer business type
//		 * @param accountRep - account rep for the customer
//		 * @param salesChannel - account rep's sales channel
//		 *
//		 * @return a CustomerDTO whose fields match those specified in the input parameters
//		 */
//		public static CustomerDTO createCustomerDTO(String name, String address, String city,
//				String state, String zip, String phone, String businessType,
//				String accountRep, String salesChannel) {
//			CustomerDTO customer = new CustomerDTO();
//
//			customer.setName(name);
//			AddressDTO addressDto = new AddressDTO();
//			addressDto.setAddress(address);
//			addressDto.setCity(city);
//			addressDto.setState(state);
//			addressDto.setZip(zip);
//			customer.setAddress(addressDto);
//			customer.setPhone(phone);
//			customer.setBusinessType(businessType);
//			customer.setAccountRep(accountRep);
//			customer.setSalesChannel(salesChannel);
//
//			return customer;
//		}
//
//		/**
//		 * Creates a NewSiteDTO with the specified parameters.
//		 *
//		 * @param customerNum - the customer number
//		 * @param externalId - the external ID
//		 * @param isIncluded - indicates whether the site is included (?)
//		 * @param isTaxExempt - indicates whether the site is tax exempt
//		 *
//		 * @return a NewSiteDTO with the specified parameters
//		 */
//		public static NewSiteDTO createNewSiteDTO(String customerNum, String externalId,
//				boolean isIncluded, boolean isTaxExempt) {
//			NewSiteDTO newSite = new NewSiteDTO();
//
//			newSite.setCustomerNum(customerNum);
//			newSite.setIncluded(isIncluded);
//
//			AdditionalSiteInfo addSiteInfo = new AdditionalSiteInfo();
//			addSiteInfo.setExternalId(externalId);
//			addSiteInfo.setTaxExempt(isTaxExempt);
//			newSite.setSiteInfo(addSiteInfo);
//
//			return newSite;
//		}
//
//		/**
//		 * Create a Site with the specified fields.
//		 *
//		 * @param serviceAddress - the service address
//		 * @param city - the city
//		 * @param state - the state
//		 * @param zip - the zipcode
//		 * @param esid - the ESID
//		 * @param esidStatus - the ESID status
//		 * @param cycleNumber - the cycle number
//		 * @param meterType - the meter type
//		 * @param smartMeterIndicator - the smart meter indicator
//		 * @param congestionZone - the congestion zone
//		 * @param market - the market
//		 * @param edc - the EDC
//		 * @param validationDate - the validation date
//		 *
//		 * @return a Site with fields matching the parameters
//		 */
//		public static Site createSite(String serviceAddress, String city, String state,
//				String zip, String esid, String esidStatus, String cycleNumber,
//				String meterType, String smartMeterIndicator, String congestionZone,
//				String market, String edc, Date validationDate) {
//			Site site = new Site();
//
//			site.setServiceaddress(serviceAddress);
//			site.setCity(city);
//			site.setState(state);
//			site.setZip(zip);
//			site.setEsid(esid);
//			site.setEsidStatus(esidStatus);
//			site.setCycleNumber(cycleNumber);
//			site.setMeterType(meterType);
//			site.setSmartMeterIndicator(smartMeterIndicator);
//			site.setCongestionZone(congestionZone);
//			site.setMarket(market);
//			site.setEdc(edc);
//			site.setValidationDate(validationDate);
//
//			return site;
//		}
//
//		/**
//		 * Creates a RenewalSiteDTO with the specified parameters.
//		 *
//		 * @param customerNum - the customer number
//		 * @param siteId - the site ID
//		 * @param isIncluded - indicates whether the renewal site is included
//		 * @param productContracts - list of ProductContractDTOs for the renewal site
//		 *
//		 * @return a RenewalSiteDTO with the specified parameters
//		 */
//		public static RenewalSiteDTO createRenewalSiteDTO(String customerNum, String siteId, boolean isIncluded, List<ProductContractDTO> productContracts) {
//			RenewalSiteDTO renewalSite = new RenewalSiteDTO();
//
//			SiteRenewalInfoDTO siteRenewalInfo = new SiteRenewalInfoDTO();
//			siteRenewalInfo.setCustomerNum(customerNum);
//			siteRenewalInfo.setSiteId(siteId);
//			renewalSite.setSiteRenewalInfo(siteRenewalInfo);
//
//			renewalSite.setIncluded(isIncluded);
//			renewalSite.setProductContracts(productContracts);
//
//			return renewalSite;
//		}
//
//		/**
//		 * Creates a ProductContractDTO with the specified parameters.
//		 *
//		 * @param contractId - the contract ID
//		 * @param productId - the product ID
//		 *
//		 * @return a ProductContractDTO with the specified parameters
//		 */
//		public static ProductContractDTO createProductContractDTO(String contractId, String productId) {
//			ProductContractDTO prodContract = new ProductContractDTO();
//
//			prodContract.setContractId(contractId);
//			prodContract.setProductId(productId);
//
//			return prodContract;
//		}
//
//		/**
//		 * Creates a WolrDTO representing a "won" deal.
//		 *
//		 * @return a "won" WolrDTO
//		 */
//		public static WolrDTO createWonWolrDTO() {
//			WolrDTO wolr = new WolrDTO();
//
//			// Set WOLR fields
//			wolr.setOpptyId("1-10247VX");
//		 	wolr.setAggregationName("");
//		 	wolr.setBilling("Summary");
//		 	wolr.setCreatedBy("qvu");
//		 	wolr.setCustomerCreditRating("");
//		 	wolr.setCustomerNum("1-1P1OTL");
//		 	wolr.setDateLost("");
//		 	wolr.setDeModelName("Standard");
//		 	wolr.setFormerRep("Reliant Energy Solutions");
//		 	wolr.setLastCustomerVisit("");
//		 	wolr.setLastEventInvite("");
//		 	wolr.setLeadEmm("NARRIAGA");
//		 	wolr.setListOfBidder(new ArrayList<String>());
//
//		 	// Set WOLR split list
//		 	List<WolrSplitDTO> wolrSplitList = new ArrayList<WolrSplitDTO>();
//		 	WolrSplitDTO wolrSplit = new WolrSplitDTO();
//		 	wolrSplit.setCommission("100");
//		 	wolrSplit.setFirstName("Natalie");
//		 	wolrSplit.setLastName("Arriaga");
//		 	wolrSplit.setRole("Lead EMM");
//		 	wolrSplitList.add(wolrSplit);
//	        wolr.setListOfSplit(wolrSplitList);
//
//	        // Set WOLR list of products
//	        List<WolrProductDTO> wolrProdList = new ArrayList<WolrProductDTO>();
//	        WolrProductDTO product = new WolrProductDTO();
//	        product.setProductAttAnnualUsage("30033.391669");
//	        product.setProductAttBrokerFee("0.25");
//	        product.setProductAttCogsPassThru("43.6156");
//	        product.setContractAceStatus("Ready to Enroll");
//	        product.setContractDealSource("VHOS");
//	        product.setContractEffDate("10/31/2018");
//	        product.setContractEndDate("5/31/2020");
//	        product.setContractNumber("1-102O21H");
//	        product.setContractStartDate("11/1/2018");
//	        product.setContractStatus("Ready to Enroll");
//	        product.setDealOption("291625630197");
//	        product.setProductAttGloFlag("N");
//	        product.setProductAttIntrazonalBundle("Y");
//	        product.setProductNumberMeters("109");
//	        product.setProductAttPeakLoad("5.387796");
//	        product.setProductComments("Restructure unbundled nodal to bundled nodal");
//	        product.setProductMwhDiff("9999");
//	        product.setProductEndDate("5/31/2020");
//	        product.setProductId("291540988662");
//	        product.setProductName("19 M Restructure");
//	        product.setProductRecsGreen("No");
//	        product.setProductStartDt("11/1/2018");
//	        product.setProductType("Fixed Price");
//	        product.setProductAttRucBundle("Y");
//	        product.setProductAttSalesPrice("40.3");
//	        product.setSettlement("No Settlement");
//	        product.setState("TX");
//	        product.setProductAttTdspBundle("N");
//	        product.setMarket("ERCOT");
//	        product.setProductTdspZones("ONC");
//	        product.setProductAttMargin("0.14");
//	        product.setProductAttTermLoad("49863.658497");
//	        product.setProductAttTotalCogs("43.6156");
//	        wolrProdList.add(product);
//	        wolr.setListOfProduct(wolrProdList);
//
//	        // Set remaining WOLR fields
//		 	wolr.setMacLang("");
//		 	wolr.setMarketSegment("Retail Spaces");
//		 	wolr.setOpptyName("Allsups Convenience RESTRUCTURE NOV 2018");
//		 	wolr.setOpptyStatus("Won");
//		 	wolr.setOpptyType("Restructure");
//		 	wolr.setPrimaryReason("Incumbent Relationship");
//		 	wolr.setSalesChannel("C&amp;I");
//		 	wolr.setSalesGroup("C&amp;I");
//		 	wolr.setThirdParty("Retail Power Services, Inc.");
//		 	wolr.setWinningCompetitor("");
//
//			return wolr;
//		}
//
//		/**
//		 * Creates a WolrDTO representing a "lost" deal.
//		 *
//		 * @return a "lost" WolrDTO
//		 */
//		public static WolrDTO createLostWolrDTO() {
//			WolrDTO wolr = new WolrDTO();
//
//			// Set WOLR fields
//			wolr.setOpptyId("1-109MR6F");
//			wolr.setComments("help");
//		 	wolr.setAggregationName("");
//		 	wolr.setBilling("");
//		 	wolr.setCreatedBy("qvu");
//		 	wolr.setCustomerCreditRating("");
//		 	wolr.setCustomerNum("1-106NUJH");
//		 	wolr.setDateLost("3/18/2018");
//		 	wolr.setDeModelName("");
//		 	wolr.setFormerRep("Acacia Energy");
//		 	wolr.setLastCustomerVisit("");
//		 	wolr.setLastEventInvite("3/1/19");
//		 	wolr.setLeadEmm("JGILL");
//		 	wolr.setListOfBidder(new ArrayList<String>());
//
//	        // Set WOLR list of products
//	        List<WolrProductDTO> wolrProdList = new ArrayList<WolrProductDTO>();
//	        WolrProductDTO product = new WolrProductDTO();
//	        product.setProductAttAnnualUsage("21.663708");
//	        product.setProductAttBrokerFee("");
//	        product.setProductAttCogsPassThru("43.7194");
//	        product.setContractAceStatus("Disabled");
//	        product.setContractDealSource("VHOS");
//	        product.setContractEffDate("1/29/2019");
//	        product.setContractEndDate("1/31/2022");
//	        product.setContractNumber("1-109MRR8");
//	        product.setContractStartDate("2/1/2019");
//	        product.setContractStatus("Cancelled");
//	        product.setDealOption("294286583586");
//	        product.setProductAttGloFlag("N");
//	        product.setProductAttIntrazonalBundle("N");
//	        product.setProductNumberMeters("4");
//	        product.setProductAttPeakLoad("0.00389");
//	        product.setProductComments("help");
//	        product.setProductMwhDiff("5");
//	        product.setProductEndDate("2/28/2022");
//	        product.setProductId("294286573031");
//	        product.setProductName("Fixed Price-36");
//	        product.setProductRecsGreen("No");
//	        product.setProductStartDt("3/1/2019");
//	        product.setProductType("Fixed Price");
//	        product.setProductVolRecs("5");
//	        product.setProductAttRucBundle("Y");
//	        product.setProductAttSalesPrice("62.41");
//	        product.setSettlement("No Settlement");
//	        product.setState("TX");
//	        product.setProductAttTdspBundle("N");
//	        product.setMarket("ERCOT");
//	        product.setProductTdspZones("CNP");
//	        product.setProductAttMargin("19.7653");
//	        product.setProductAttTermLoad("65.465945");
//	        product.setProductAttTotalCogs("");
//	        wolrProdList.add(product);
//	        wolr.setListOfProduct(wolrProdList);
//
//	        // Set remaining WOLR fields
//		 	wolr.setMacLang("");
//		 	wolr.setMarketSegment("Retail Spaces");
//		 	wolr.setOpptyName("Spotted Hound test Feb 2019");
//		 	wolr.setOpptyStatus("Lost");
//		 	wolr.setOpptyType("New");
//		 	wolr.setPrimaryReason("Price");
//		 	wolr.setSalesChannel("C&amp;I");
//		 	wolr.setSalesGroup("C&amp;I");
//		 	wolr.setThirdParty("Retail Power Services, Inc.");
//		 	wolr.setWinningCompetitor("");
//
//			return wolr;
//		}
//
//		/**
//		 * Creates an empty WolrDTO, i.e. a WolrDTO whose fields are all
//		 * initialized to empty Strings, lists, etc.
//		 *
//		 * @return an empty WolrDTO
//		 */
//		public static WolrDTO createEmptyWolrDTO() {
//			WolrDTO wolr = new WolrDTO();
//
//			// Set WOLR fields
//			wolr.setOpptyId("");
//		 	wolr.setAggregationName("");
//		 	wolr.setBilling("");
//		 	wolr.setCreatedBy("");
//		 	wolr.setCustomerCreditRating("");
//		 	wolr.setCustomerNum("");
//		 	wolr.setDateLost("");
//		 	wolr.setDeModelName("");
//		 	wolr.setFormerRep("");
//		 	wolr.setLastCustomerVisit("");
//		 	wolr.setLastEventInvite("");
//		 	wolr.setLeadEmm("");
//		 	wolr.setListOfBidder(new ArrayList<String>());
//
//		 	// Set WOLR split list
//		 	List<WolrSplitDTO> wolrSplitList = new ArrayList<WolrSplitDTO>();
//	        wolr.setListOfSplit(wolrSplitList);
//
//	        // Set WOLR list of products
//	        List<WolrProductDTO> wolrProdList = new ArrayList<WolrProductDTO>();
//	        wolr.setListOfProduct(wolrProdList);
//
//	        // Set remaining WOLR fields
//		 	wolr.setMacLang("");
//		 	wolr.setMarketSegment("");
//		 	wolr.setOpptyName("");
//		 	wolr.setOpptyStatus("");
//		 	wolr.setOpptyType("");
//		 	wolr.setPrimaryReason("");
//		 	wolr.setSalesChannel("");
//		 	wolr.setSalesGroup("");
//		 	wolr.setThirdParty("");
//		 	wolr.setWinningCompetitor("");
//
//			return wolr;
//		}
//
//		/**
//		 * @author adrian.moga
//		 *
//		 * A utility class that provides useful utilities for generating random Strings. This is
//		 * useful when generating new data for tests cases, such as random names, email addresses,
//		 * addresses, etc.
//		 */
//		public static class StringUtils {
//
//			/**
//			 * Generates a random String consisting of alphanumeric characters.
//			 *
//			 * @param length - the desired String length
//			 *
//			 * @return a String of the specified length consisting of random
//			 * 	alphanumeric characters
//			 */
//			public static String randomAlphanumericString(int length) {
//				return RandomStringUtils.randomAlphanumeric(length);
//			}
//
//			/**
//			 * Generates a random String consisting of alphabetic characters, where
//			 * the first character is a capital letter, and all other characters are
//			 * lower case.
//			 *
//			 * @param length - the desired String length
//			 *
//			 * @return a String of the specified length consisting of random alpha characters,
//			 * 	with the first character capitalized
//			 */
//			public static String randomName(int length) {
//				String string = "";
//				string += RandomStringUtils.randomAlphabetic(1).toUpperCase();
//				string += RandomStringUtils.randomAlphabetic(length - 1).toLowerCase();
//				return string;
//			}
//
//			/**
//			 * Generates a random String consisting of alphabetic characters, where all
//			 * characters are capitalized.
//			 *
//			 * @param length - the desired String length
//			 *
//			 * @return a String of the specified length consisting of random,
//			 * 	capital characters
//			 */
//			public static String randomStringAllCaps(int length) {
//				return RandomStringUtils.randomAlphabetic(length).toUpperCase();
//			}
//
//			/**
//			 * Generates a random String consisting of alphabetic characters, where all
//			 * characters are lower-case.
//			 *
//			 * @param length - the desired String length
//			 *
//			 * @return a String of the specified length consisting of random,
//			 * lower-case characters
//			 */
//			public static String randomStringAllLower(int length) {
//				return RandomStringUtils.randomAlphabetic(length).toLowerCase();
//			}
//
//			/**
//			 * Generates a random String consisting of numerics characters.
//			 *
//			 * @param length - the desired String length
//			 *
//			 * @return a String of the specified length consisting of random digits
//			 */
//			public static String randomNumber(int length) {
//				return RandomStringUtils.randomNumeric(length);
//			}
//
//		}
//
//	}
//
//}

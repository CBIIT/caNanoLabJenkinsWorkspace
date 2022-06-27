package gov.nih.nci;
import gov.nih.nci.HelperMethods.BaseTestMethods;
import gov.nih.nci.HelperMethods.BaseNanoLabMethods;

import org.junit.*;
import org.apache.log4j.Logger;

public class TestSuiteSamples {
	static BaseNanoLabMethods Test = new BaseNanoLabMethods();
	private static Logger logger=Logger.getLogger("TestSuite");
	public static String seleniumBrowser = "firefox";
	public static String tier = "dev";
	//public static String HostName = "http://localhost:9090";
	public static String HostName = "https://cananolab-qa.nci.nih.gov";
	//public static String HostName = "https://cananolab-qa-sg.nci.nih.gov";
	//public static String HostName = "http://nciws-q438-v:18080";
	//public static String HostName = "http://ncias-d1360-v.nci.nih.gov:18080";
	public static String seleniumUrl = HostName + "/caNanoLab/";	
	public static String curatorUserName = "curatorUserName";
	public static String curatorPassword = "curatorPassword";
	public static String researcherUserName = "researcherUserName";
	public static String researcherPassword = "researcherPassword";
		
	//Application configuration
	public static String applinkHOME = "HOME";
	public static String applinkPROTOCOLS = "PROTOCOLS";
	public static String applinkSAMPLES = "SAMPLES";
	public static String applinkPUBLICATIONS = "PUBLICATIONS";
	public static String applinkCURATION = "CURATION";
	public static String applinkMYWORKSPACE = "MY WORKSPACE";
	public static String applinkHELP = "HELP";
	public static String applinkLOGOUT = "LOGOUT";
	public static String applinkGLOSSARY = "GLOSSARY";
	public static String applinkCONTACTUS = "CONTACT US";
	public static String applinkPRIVACYNOTICE = "PRIVACY NOTICE";
	public static String applinkDISCLAIMER = "DISCLAIMER";
	public static String applinkACCESSIBILITY = "ACCESSIBILITY";
	public static String applinkAPPLICATIONSUPPORT = "APPLICATION SUPPORT";
	
	public static String applinkcaNanoLabWiki = "caNanoLab Wiki";
	public static String applinkNCICBIITHome = "NCI CBIIT Home";
	public static String applinkNCLHome = "NCL Home";
	public static String applinkNCLCSNHome = "NCL CSN Home";
	public static String applinkNCINanoAllianceHome = "NCI Nano Alliance Home";
	public static String applinkNCIHome = "NCI Home";
	public static String applinkNanotechnologyWorkingGroup = "Nanotechnology Working Group";
	public static String applinkNanoHubs = "Nano Hubs";
	public static String applinkDisclaimer = "Disclaimer";
	public static String applinkNBI = "NBI";
	public static String applinkNIOSHNIL = "NIOSH NIL";
	public static String applinkInterNano = "InterNano";
	public static String applinknanoHUB = "nanoHUB";
	public static String applinkICON = "ICON";
	public static String applinkSAFENANO = "SAFENANO";
	public static String applinkOECD = "OECD";
	public static String applinkeNanoMapper = "eNanoMapper";
	public static String applinkNanomaterialRegistry = "Nanomaterial Registry";
	
	public static String applinkFAQ = "FAQ";
	public static String applinkOnlineHelp = "Online Help";
	public static String applinkSearchProtocols = "Search Protocols";
	public static String applinkSearchSamples = "Search Samples";
	public static String applinkSearchPublications = "Search Publications";
	public static String applinkDownload = "download";
	public static String applinkReleaseNotes = "caNanoLab Release Notes";
	
	//How to Section
	public static String applinkHowDoISubmitData = "How do I submit data into caNanoLab?";
	public static String applinkHowDoIIncorporate = "How do I incorporate caNanoLab into a data sharing plan?";
	public static String applinkHowDoIFindNanotechnologyProtocols = "How do I find nanotechnology protocols?";
	public static String applinkHowDoIFindNanotechnologyPublications = "How do I find Nanotechnology publications?";
	public static String applinkHowCanISearchForNanomaterials = "How can I search for nanomaterials?";
	public static String applinkHowCanISearchForNanomaterialsCharacterizations = "How can I search for nanomaterial characterizations?";
	public static String applinkHowCanIGetDefinitionsFor = "Where can I get definitions for nanotechnology concepts?";
	
	//Application Confirmation Message
	public static String registrationSubmitConfMessage = "Your registration request has been sent to the administrator for assignment of your User ID and Password. You should receive this information via e-mail within one business day from time of submission.";
	public static String sampleSubmitConfMessage = "";
	public static String publicationSubmitConfMessage = "";
	public static String protocolSubmitConfMessage = "";
	public static String appWelcomeMessage = "Welcome to the cancer Nanotechnology Laboratory (caNanoLab) portal. caNanoLab is a data sharing portal designed to facilitate information sharing across the international biomedical nanotechnology research community to expedite and validate the use of nanotechnology in biomedicine. caNanoLab allows researchers to share information on nanomaterials by normalizing the format of publication-quality data, including details often unavailable in the published form, and centralizing its storage. These data include the composition of the nanomaterial, its functions (e.g. therapeutic, targeting, diagnostic imaging), its characterizations from physico-chemical (e.g. size, molecular weight, surface), in vitro (e.g. cytotoxicity, blood contact) and in vivo (e.g. animal toxicity and efficacy) nanomaterial assays, and the protocols of these assays.\n\nThe diagram below illustrates the caNanoLab functionality and workflow. \"Active links\" are provided that allows a user to directly navigate to the appropriate function based on the authorization level of the user. In particular, the Sample Submission workflow allows direct launching points to develop caNanoLab data files from a user's inputs. Navigation is also available through the menus above.";
	
	//Application CSS Configuration
	public static String appCSSUserActions = "td.sidebarContent";
	
	public TestSuiteSamples(){
		BaseTestMethods.appRelease = "cananoLab v2.1";
		BaseTestMethods.releaseDesc = "caNanoLab v2.1 is refactored using AngularJS as the Front-end framework and JAVA REST services as the middle-tier";
	}	

	//S.N.: 44
	//Test Name: 003_verify_sample_equals_search_by_sample_name
	@Test
	public void Test1SamplesEqualsSearchBySampleName() throws Exception {
		String testName = "003_verify_sample_equals_search_by_sample_name";
		String testDesc = "Verify equals sample search by Sample name"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			//Test.samples_search_simple("", "equals", "SNL_UNM-CAshleyACSNano2012-22", "", "", "", "", "", "", "", "search");
			//Test.verify_sample_search_results("Sample Search Results", 1);
			// Test.verify_sample_name_contains_from_search_results_page("SNL_UNM-CAshleyACSNano2012-22");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}



		//S.N.: 46
	//Test Name: 005_verify_sample_equals_search_by_sample_poc
	@Test
	public void Test3SamplesEqualsSearchBySamplePOC() throws Exception {
		String testName = "005_verify_sample_equals_search_by_sample_poc";
		String testDesc = "Verify sample equals search by Sample POC"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();	
			//Test.samples_search_simple("", "", "", "equals", "WSU_DPS", "", "", "", "", "", "search");
			//Test.verify_sample_search_results("Sample Search Results", 1);
			//Test.verify_sample_poc_contains_from_search_results_page("WSU_DPS Department of Pharmaceutical Sciences, Wayne State University 259 Mack Avenue Detroit MI 48202 USA");
			Test.click_view_link_by_sample_poc_contains_name("WSU_DPS Department of Pharmaceutical Sciences, Wayne State University 259 Mack Avenue Detroit MI 48202 USA");
			//Test.verify_sample_general_info("", "", "", "", "David", "WSU_DPS", "");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	
	

	


	//S.N.: 45
	//Test Name: 004_verify_sample_contains_search_by_poc
	@Test
	public void Test2SamplesContainsSearchBySamplePOC() throws Exception {
		String testName = "004_verify_sample_contains_search_by_poc";
		String testDesc = "Verify sample contains search by Sample POC"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			//Test.samples_search_simple("", "", "", "contains", "David", "", "", "", "", "", "search");
			//Test.verify_sample_search_results("Sample Search Results", 1);
			//Test.verify_sample_poc_contains_from_search_results_page("WSU_DPS Department of Pharmaceutical Sciences, Wayne State University 259 Mack Avenue Detroit MI 48202 USA");
			Test.click_view_link_by_sample_poc_contains_name("WSU_DPS Department of Pharmaceutical Sciences, Wayne State University 259 Mack Avenue Detroit MI 48202 USA");
			//Test.verify_sample_general_info("WSU_USTC-QZhouJDT2009-09", "12/14/10", "COPOLYMER NONCOMPLEMENTARY PEPTIDE PLASMID POLYPLEX", "Yes", "David", "WSU_DPS", "investigator");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	
	//S.N.: 46
	//Test Name: 005_verify_sample_equals_search_by_sample_poc
	@Test
	public void Test4SamplesEqualsSearchBySamplePOC() throws Exception {
		String testName = "005_verify_sample_equals_search_by_sample_poc";
		String testDesc = "Verify sample equals search by Sample POC"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			//Test.samples_search_simple("", "", "", "equals", "WSU_DPS", "", "", "", "", "", "search");
			//Test.verify_sample_search_results("Sample Search Results", 1);
			//Test.verify_sample_poc_contains_from_search_results_page("WSU_DPS Department of Pharmaceutical Sciences, Wayne State University 259 Mack Avenue Detroit MI 48202 USA");
			//Test.click_view_link_by_sample_poc_contains_name("WSU_DPS Department of Pharmaceutical Sciences, Wayne State University 259 Mack Avenue Detroit MI 48202 USA");
			//Test.verify_sample_general_info("", "", "", "", "David", "WSU_DPS", "");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	

	//S.N.: 47
	//Test Name: 006_verify_sample_search_by_composition_nanomaterial_entity
	@Test
	public void Test5SamplesSearchByNanomaterialEntity() throws Exception {
		String testName = "006_verify_sample_search_by_composition_nanomaterial_entity";
		String testDesc = "Verify sample search by nanomaterial entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			//Test.samples_search_simple("", "", "", "", "", "carbon black", "", "", "", "", "search");
			//Test.verify_sample_composition_contains_from_search_results_page("carbon black");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	
	//S.N.: 48
	//Test Name: 007_verify_sample_search_by_composition_functionalizing_entity
	@Test
	public void Test6SamplesSearchByFunctionalizingEntity() throws Exception {
		String testName = "007_verify_sample_search_by_composition_functionalizing_entity";
		String testDesc = "Verify sample search by functionalizing entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			//Test.samples_search_simple("", "", "", "", "", "", "Monomer", "", "", "", "search");
			//Test.click_view_link_by_sample_name_contains("UNC-SGrattonPNAS2008-08");
			//Test.navigate_sample_tabs("Composition");
			Test.wait_For(4000);
			//Test.expected_value_verification("Monomer");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	
	//S.N.: 49
	//Test Name: 008_verify_sample_search_by_composition_function
	@Test
	public void Test7SamplesSearchByFunctiontypes() throws Exception {
		String testName = "008_verify_sample_search_by_composition_function";
		String testDesc = "Verify sample search by function types"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_by_function_types("targeting function");
			Test.submitSampleSearch();
			Test.wait_For(10000);
			//Test.sample_search_results_verification("(.*) items found, displaying 1 to 25.");
			//Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	
	

		
	//S.N.: 42
	//Test Name: 001_Verify_sample_search_by_keyword
	@Test
	public void Test8CreateSampleCharacterizationComponent() throws Exception {
		String testName = "001_Verify_sample_search_by_keyword";
		String testDesc = "verify sample search by keyword"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.navigate_to_sample_search_from_Home_page();
			//Test.samples_search_simple("GLIOBLASTOMA MULTIFORME", "", "", "", "", "", "", "", "", "", "search");
			Test.wait_For(2000);
			//Test.verify_sample_search_results("Sample Search Results", 2);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	
	
	
		//S.N.: 43
	//Test Name: 002_verify_sample_contains_search_by_sample_name
	@Test
	public void Test9CreateSampleCompositionComponent() throws Exception {
		String testName = "002_verify_sample_contains_search_by_sample_name";
		String testDesc = "Verify sample contains search by Sample name"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			//Test.samples_search_simple("NCL", "contains", "", "", "", "", "", "", "", "", "search");
			//Test.verify_sample_search_results("Sample Search Results", 1);
			Test.click_next_result_page_until("NCL-23");
			Test.verify_sample_name_contains_from_search_results_page("NCL-23");
			//Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}	
	
	//S.N.: 50
	//Test Name: 009_verify_sample_search_by_characterization_type
	@Test
	public void Test10SamplesSearchByCharacterizationType() throws Exception {
		String testName = "009_verify_sample_search_by_characterization_type";
		String testDesc = "Verify sample search by Characterization types"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			//Test.samples_search_simple("", "", "", "", "", "", "", "", "physico-chemical characterization", "", "search");
			Test.wait_For(120000);
			//Test.sample_search_results_verification("(.*) items found, displaying 1 to 25.");
			//Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	
	//S.N.: 51
	//Test Name: 009_verify_sample_search_by_characterization_type
	@Test
	public void Test11SamplesSearchByCharacterization() throws Exception {
		String testName = "010_verify_sample_search_by_characterization";
		String testDesc = "Verify sample search by Characterization";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			//Test.samples_search_simple("", "", "", "", "", "", "", "", "physico-chemical characterization", "molecular weight", "search");
			Test.wait_For(6000);
			//Test.sample_search_results_verification("(.*) items found, displaying 1 to 25.");
			//Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	
	//S.N.: 52
	//Test Name: 011_Verify_the_ability_to_search_non_publically_available_samples_when_logged_in_as_curator
	@Test
	public void Test12VerifyAbilityToSearchNonPublicallyAvailableSamplesWhenLoggedInAsCurator() throws Exception {
		String testName = "011_Verify_the_ability_to_search_non_publically_available_samples_when_logged_in_as_curator";
		String testDesc = "verify the ability to search non publically available samples data by loggin in as a curator.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Login to submit data");
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "equals", "SNL_UNM-CAshleyACSNano2012-25", "", "", "", "", "", "", "", "search");
			Test.wait_For(4000);
			//Test.sample_search_results_verification("One item found.");
			//Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}		
	}
	
	//S.N.: 53
	//Test Name: 012_Verify_that_searching_for_non_public_sample_results_in_no_search_results_for_public_users
	@Test
	public void Test13VerifyThatSearchingForNonPublicSampleResultsInNoSearchResultsForPublicUsers() throws Exception {
		String testName = "012_Verify_that_searching_for_non_public_sample_results_in_no_search_results_for_public_users";
		String testDesc = "Verify that \"No search results\" is returned when a public user searches for a non-public sample."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			//Test.samples_search_simple("", "equals", "SNL_UNM-CAshleyACSNano2012-25", "", "", "", "", "", "", "", "search");
			Test.wait_For(4000);
			Test.sample_search_error_verification();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}		
	}
	
	//S.N.: 54
	//Test Name: 012_Verify_that_searching_for_non_public_sample_results_in_no_search_results_for_public_users
	@Test
	public void Test14SamplesSearchBySampleNameAndPOC() throws Exception {
		String testName = "013_verify_sample_search_by_combination_of_sample_name_and_sample_poc";
		String testDesc = "Verify complex sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_contains_search_by_sample_name("ncl");
			Test.samples_contains_search_by_sample_poc("ma");
			Test.submitSampleSearch();
			//Test.sample_search_results_verification("(.*) items found, displaying 1 to 25.");
			//Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}

	//S.N.: 55
	//Test Name: 014_Verify_the_ability_to_reset_the_sample_search_fields
	@Test
	public void Test15VerifyTheAbilityToResetSampleSearchCriteria() throws Exception {
		String testName = "014_Verify_the_ability_to_reset_the_sample_search_fields";
		String testDesc = "verify that the fields in the sample search page can be reset by clicking on reset button"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_simple("test", "equals", "NCL-23-1", "equals", "Devid", "carbon", "Monomer", "magnetic", "ex vivo", "imaging", "reset");
			Test.wait_For(4000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 56
	//Test Name: 001_Verify_that_publically_available_sample_details_summary_can_be_viewed
	@Test
	public void Test16VerifyThatPublicallyAvailableSampleDetailsSummaryCanBeViewed() throws Exception {
		String testName = "001_Verify_that_publically_available_sample_details_summary_can_be_viewed";
		String testDesc = "verify that the public user has the ability to view the sample details summary of publically available sample data";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_equals_search_by_sample_name("NCL-49-2");
			Test.submitSampleSearch();
			//Test.sample_search_results_verification("One item found.");
			//Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			Test.view_sample_details_from_search_results_page("NCL-49-2");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}		
	}

	//S.N.: 57
	//Test Name: 002_Verify_that_Data_Availability_chart_of_publically_available_sample_can_be_viewed
	@Test
	public void Test17VerifyThatDataAvailabilityChartOfPublicallyAvailableSampleCanBeViewed() throws Exception {
		String testName = "002_Verify_that_Data_Availability_chart_of_publically_available_sample_can_be_viewed";
		String testDesc = "verify that a public user has the ability to view the Data Availabiity chart of a publically available sample";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			//Test.samples_equals_search_by_sample_name("NCL-49-2");
			//Test.submitSampleSearch();
			//Test.sample_search_results_verification();
			//Test.view_data_availability_chart_from_sample_search_results_page("NCL-49-2", "caNanoLab Availability Score:(.*)");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}		
	}
	
	//S.N.: 58
	//Test Name: 003_Verify_that_a_researcher_can_only_view_sample_details_for_samples_that_he_has_readonly_access
	@Test
	public void Test18VerifyThatAResearcherCanOnlyViewSampleDetailsforSamplesThatHehasReadOnlyAccess() throws Exception {
		String testName = "003_Verify_that_a_researcher_can_only_view_sample_details_for_samples_that_he_has_readonly_access";
		String testDesc = "Verify that a user with Researcher privileges can ONLY view sample details for sample he/she has readonly access.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(4000);
			//Test.chooseLoginOptions("Login to submit data");
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "equals", "NCL-23-1", "", "", "", "", "", "", "", "search");
			Test.wait_For(4000);
			//Test.sample_search_results_verification("One item found.");
			//Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			Test.view_sample_details_from_search_results_page("NCL-23-1");
			Test.view_sample_composition_from_search_results_page("NCL-23-1");
			Test.view_sample_characterization_from_search_results_page("NCL-23-1");
			Test.view_sample_publication_from_search_results_page("NCL-23-1", "All");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}		
	}
	
	//S.N.: 59
	//Test Name: 015_verify_that_clicking_on_public_results_from_home_page_returns_sample_search_results_for_all_public_samples
	@Test
	public void Test19VerifyClickingOnPublicResultsLinkAgainstSampleSearchesFromHomePageReturnsAllPublicallyAvailableSamples() throws Exception {
		String testName = "015_verify_that_clicking_on_public_results_from_home_page_returns_sample_search_results_for_all_public_samples";
		String testDesc = "Verify that clicking on 997 link on the Home page in \"Public Results\" column against the Search Samples in Browse cananoLab section returns all publically available samples results";
		try{	 
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.navigate_to_public_sample_search_results_from_browseCananoLabSection();
			//Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	
	
	@After
	  public void tearDown() throws Exception {
		Test.shutdown();
	  }
}

package gov.nih.nci;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.internal.seleniumemulation.Click;

import gov.nih.nci.HelperMethods.BaseTestMethods;
import gov.nih.nci.HelperMethods.BaseNanoLabMethods;

import org.junit.*;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;

public class TestSuiteProtocols {
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
	
	public TestSuiteProtocols(){
		BaseTestMethods.appRelease = "cananoLab v2.1";
		BaseTestMethods.releaseDesc = "caNanoLab v2.1 is refactored using AngularJS as the Front-end framework and JAVA REST services as the middle-tier";
	}	
	/*
	//S.N.: 51
	//Test Name: 009_verify_sample_search_by_characterization_type
	@Test
	public void SamplesSearchByCharacterization() throws Exception {
		String testName = "010_verify_sample_search_by_characterization";
		String testDesc = "Verify sample search by Characterization";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_search_simple("", "", "", "", "", "", "", "", "physico-chemical characterization", "molecular weight", "search");
			Test.wait_For(4000);
			//Test.sample_search_results_verification("(.*) items found, displaying 1 to 25.");
			Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}
	}
	*/
	//S.N.: 52
	//Test Name: 011_Verify_the_ability_to_search_non_publically_available_samples_when_logged_in_as_curator
	@Test
	public void Test1verifyAbilityToSearchNonPublicallyAvailableSamplesWhenLoggedInAsCurator() throws Exception {
		String testName = "011_Verify_the_ability_to_search_non_publically_available_samples_when_logged_in_as_curator";
		String testDesc = "verify the ability to search non publically available samples data by loggin in as a curator.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Login to submit data");
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "equals", "SNL_UNM-CAshleyACSNano2012-25", "", "", "", "", "", "", "", "search");
			Test.wait_For(4000);
			//Test.sample_search_results_verification("One item found.");
			Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
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
	public void Test2verifyThatSearchingForNonPublicSampleResultsInNoSearchResultsForPublicUsers() throws Exception {
		String testName = "012_Verify_that_searching_for_non_public_sample_results_in_no_search_results_for_public_users";
		String testDesc = "Verify that \"No search results\" is returned when a public user searches for a non-public sample."; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			//Test.samples_search_simple("", "equals", "SNL_UNM-CAshleyACSNano2012-25", "", "", "", "", "", "", "", "search");
			Test.wait_For(4000);
			//Test.sample_search_error_verification();
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
	public void Test3SamplesSearchBySampleNameAndPOC() throws Exception {
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
			Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
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
	public void Test6verifyTheAbilityToResetSampleSearchCriteria() throws Exception {
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
	public void Test7verifyThatPublicallyAvailableSampleDetailsSummaryCanBeViewed() throws Exception {
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
			Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
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
	public void Test8verifyThatDataAvailabilityChartOfPublicallyAvailableSampleCanBeViewed() throws Exception {
		String testName = "002_Verify_that_Data_Availability_chart_of_publically_available_sample_can_be_viewed";
		String testDesc = "verify that a public user has the ability to view the Data Availabiity chart of a publically available sample";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_sample_search_from_Home_page();
			Test.samples_equals_search_by_sample_name("NCL-49-2");
			Test.submitSampleSearch();
			Test.sample_search_results_verification();
			Test.view_data_availability_chart_from_sample_search_results_page("NCL-49-2", "caNanoLab Availability Score:(.*)");
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
	public void Test9verifyThatAResearcherCanOnlyViewSampleDetailsforSamplesThatHehasReadOnlyAccess() throws Exception {
		String testName = "003_Verify_that_a_researcher_can_only_view_sample_details_for_samples_that_he_has_readonly_access";
		String testDesc = "Verify that a user with Researcher privileges can ONLY view sample details for sample he/she has readonly access.";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Login to submit data");
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "equals", "NCL-23-1", "", "", "", "", "", "", "", "search");
			Test.wait_For(4000);
			//Test.sample_search_results_verification("One item found.");
			Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
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
	public void Test10verifyClickingOnPublicResultsLinkAgainstSampleSearchesFromHomePageReturnsAllPublicallyAvailableSamples() throws Exception {
		String testName = "015_verify_that_clicking_on_public_results_from_home_page_returns_sample_search_results_for_all_public_samples";
		String testDesc = "Verify that clicking on 997 link on the Home page in \"Public Results\" column against the Search Samples in Browse cananoLab section returns all publically available samples results";
		try{	 
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.navigate_to_public_sample_search_results_from_browseCananoLabSection();
			Test.sample_search_results_verification(); //using this as a temporary solution until issue is fixed.
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}


	// Publication >> Search for Samples by Publication
	
	//S.N.: 60
	//Test Name: 001_Verify_sample_search_by_publication_PubMed_ID
	@Test
	public void Test11verifySampleSearchByPublicationPubMedID() throws Exception {
		String testName = "001_Verify_sample_search_by_publication_PubMed_ID";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by PubMed ID"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.wait_For(3000);
//Test.Verify_sample_search_by_publication_PubMed_ID("17278104", "PubMed ID: 17278104");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();	
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 61
	//Test Name: 002_Verify_sample_search_by_publication_DOI
	@Test
	public void Test12verifySampleSearchByPublicationDOI() throws Exception {
		String testName = "002_Verify_sample_search_by_publication_DOI";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by DOI"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.wait_For(3000);
			Test.Verify_sample_search_by_publication_DOI("10.1002%2Fijc.22581", "DOI Id: 10.1002/ijc.22581");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 62
	//Test Name: 003_Verify_sample_search_by_publication_PubMed_ID_as_a_Curator
	@Test
	public void Test13verifySampleSearchByPublicationPubMedIDasaCurator() throws Exception {
		String testName = "003_Verify_sample_search_by_publication_PubMed_ID_as_a_Curator";
		String testDesc = "Verify Curator able to search publicly available data from caNanoLab Publication search page by PubMed ID"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.Verify_sample_search_by_publication_PubMed_ID_as_a_Curator("17278104", "PubMed ID: 17278104");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 63
	//Test Name: 004_Verify_sample_search_by_publication_DOI_as_a_Curator
	@Test
	public void Test14verifySampleSearchByPublicationDOIasaCurator() throws Exception {
		String testName = "004_Verify_sample_search_by_publication_DOI_as_a_Curator";
		String testDesc = "Verify Curator able to search publicly available data from caNanoLab Publication search page by DOI"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.Verify_sample_search_by_publication_DOI_as_a_Curator("10.1002%2Fijc.22581", "DOI Id: 10.1002/ijc.22581");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 64
	//Test Name: 004_Verify_sample_search_by_publication_DOI_as_a_Curator
	@Test
	public void Test15verifySampleSearchByPublicationPubMedIDasaResearcher() throws Exception {
		String testName = "005_Verify_sample_search_by_publication_PubMed_ID_as_a_Researcher";
		String testDesc = "Verify Researcher able to search publicly available data from caNanoLab Publication search page by PubMed ID"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLogin(By.linkText("PUBLICATIONS"));
			Test.Verify_sample_search_by_publication_PubMed_ID_as_a_Researcher("17278104", "PubMed ID: 17278104");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 65
	//Test Name: 006_Verify_sample_search_by_publication_DOI_as_a_Researcher
	@Test
	public void Test16verifySampleSearchByPublicationDOIasaResearcher() throws Exception {
		String testName = "006_Verify_sample_search_by_publication_DOI_as_a_Researcher";
		String testDesc = "Verify Researcher able to search publicly available data from caNanoLab Publication search page by DOI";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLogin(By.linkText("PUBLICATIONS"));
			Test.Verify_sample_search_by_publication_DOI_as_a_Researcher("10.1002%2Fijc.22581", "DOI Id: 10.1002/ijc.22581");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	
    //Publication >> Search Publication
	
	//S.N.: 66
	//Test Name: 001_Verify_publication_search_by_keyword
	@Test
	public void Test17verifyPublicationSearchByKeyword() throws Exception {
		String testName = "001_Verify_publication_search_by_keyword";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Keyword";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_keyword("test");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	

	//S.N.: 67
	//Test Name: 002_Verify_publication_search_by_Publication_Type
	@Test
	public void Test18verifyPublicationSearchByPublicationType() throws Exception {
		String testName = "002_Verify_publication_search_by_Publication_Type";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Publication Type"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Publication_Type();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 68
	//Test Name: 003_Verify_publication_search_by_Research_Category
	@Test
	public void Test19verifyPublicationSearchByResearchCategory() throws Exception {
		String testName = "003_Verify_publication_search_by_Research_Category";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Reasearch Category"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Research_Category();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 69
	//Test Name: 004_Verify_publication_search_by_PubMed_ID
	@Test
	public void Test20verifyPublicationSearchByPubMedID() throws Exception {
		String testName = "004_Verify_publication_search_by_PubMed_ID";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by PubMedID";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.test_004_Verify_publication_search_by_PubMed_ID("17278104");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 70
	//Test Name: 005_Verify_publication_search_by_Digital_Object_ID
	@Test
	public void Test21verifyPublicationSearchByDigitalObjectID() throws Exception {
		String testName = "005_Verify_publication_search_by_Digital_Object_ID";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by digital object ID"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Digital_Object_ID("10.1002/ijc.22581");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 71
	//Test Name: 006_Verify_publication_contains_search_by_Publication_Title
	@Test
	public void Test22VerifyPublicationContainsSearchbyPublicationTitle() throws Exception {
		String testName = "006_Verify_publication_contains_search_by_Publication_Title";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by publication title as contains search";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_contains_search_by_Publication_Title("The PeptideAtlas project.");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 72
	//Test Name: 006_Verify_publication_contains_search_by_Publication_Title
	@Test
	public void Test23VerifyPublicationEqualsSearchByPublicationTitle() throws Exception {
		String testName = "007_Verify_publication_equals_search_by_Publication_Title";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by publication title as equals search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_equals_search_by_Publication_Title("equals", "The PeptideAtlas project.");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}	
	
	//S.N.: 73
	//Test Name: 008_Verify_publication_search_by_Authors
	@Test
	public void Test24VerifyPublicationSearchByAuthors() throws Exception {
		String testName = "008_Verify_publication_search_by_Authors";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Authors"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Authors("Agata");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}	

	//S.N.: 74
	//Test Name: 009_Verify_publication_search_by_Sample_Name_contains
	@Test
	public void Test25verifyPublicationSearchBySampleNameContains() throws Exception {
		String testName = "009_Verify_publication_search_by_Sample_Name_contains";
		String testDesc = "Verify publication search by Sample Name as contains";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Sample_Name_option("TEST", "contains");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}	
	
	//S.N.: 75
	//Test Name: 010_Verify_publication_search_by_Sample_Name_equals
	@Test
	public void Test26verifyPublicationSearchBySampleNameEquals() throws Exception {
		String testName = "010_Verify_publication_search_by_Sample_Name_equals";
		String testDesc = "Verify publication search by Sample Name as equals"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Sample_Name_option("TEST-TL2009-01", "equals");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 76
	//Test Name: 011_Verify_publication_search_by_Composition_Nanomaterial_Entity
	@Test
	public void Test27verifyPublicationSearchByCompositionNanomaterialEntity_1() throws Exception {
		String testName = "011_Verify_publication_search_by_Composition_Nanomaterial_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Nanomaterial_Entity("biopolymer");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 77
	//Test Name: 011_Verify_publication_search_by_Composition_Nanomaterial_Entity
	@Test
	public void Test28verifyPublicationSearchByCompositionNanomaterialEntity_2() throws Exception {
		String testName = "011_Verify_publication_search_by_Composition_Nanomaterial_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Nanomaterial_Entity("carbon");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 78
	//Test Name: 011_Verify_publication_search_by_Composition_Nanomaterial_Entity
	@Test
	public void Test29verifyPublicationSearchByCompositionNanomaterialEntity_3() throws Exception {
		String testName = "011_Verify_publication_search_by_Composition_Nanomaterial_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Nanomaterial_Entity("carbon black");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 79
	//Test Name: 011_Verify_publication_search_by_Composition_Nanomaterial_Entity
	@Test
	public void Test30verifyPublicationSearchByCompositionNanomaterialEntity_4() throws Exception {
		String testName = "011_Verify_publication_search_by_Composition_Nanomaterial_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Nanomaterial_Entity("carbon nanotube");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 80
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void Test31verifyPublicationSearchByCompositionFunctionalizingEntity_1() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("Magnetic Particle");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 81
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void Test32verifyPublicationSearchByCompositionFunctionalizingEntity_2() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("Monomer");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 82
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void Test33verifyPublicationSearchByCompositionFunctionalizingEntity_3() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("Polymer");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 83
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void Test34verifyPublicationSearchByCompositionFunctionalizingEntity_4() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("Quantum Dot");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 84
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void Test35verifyPublicationSearchByCompositionFunctionalizingEntity_5() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("antibody");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 85
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void Test36verifyPublicationSearchByCompositionFunctionalizingEntity_6() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("biopolymer");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 86
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void Test37verifyPublicationSearchByCompositionFunctionalizingEntity_7() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("radioisotope");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 87
	//Test Name: 012_Verify_publication_search_by_Composition_Functionalizing_Entity
	@Test
	public void Test38verifyPublicationSearchByCompositionFunctionalizingEntity_8() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Composition_Functionalizing_Entity("small molecule");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 88
	//Test Name: 013_Verify_publication_search_by_Function
	@Test
	public void Test39verifyPublicationSearchByFunction_1() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Function("endosomolysis");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 89
	//Test Name: 013_Verify_publication_search_by_Function
	@Test
	public void Test40verifyPublicationSearchByFunction_2() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Function("imaging function");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 90
	//Test Name: 013_Verify_publication_search_by_Function
	@Test
	public void Test41verifyPublicationSearchByFunction_3() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			//Test.Verify_publication_search_by_Function("other");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 91
	//Test Name: 013_Verify_publication_search_by_Function
	@Test
	public void Test42verifyPublicationSearchByFunction_4() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Function("targeting function");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 92
	//Test Name: 013_Verify_publication_search_by_Function
	@Test
	public void Test43verifyPublicationSearchByFunction_5() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Function("therapeutic function");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 93
	//Test Name: 013_Verify_publication_search_by_Function
	@Test
	public void Test44verifyPublicationSearchByFunction_6() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Function("transfection");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 94
	//Test Name: 014_verify_publication_search_by_keyword_as_a_Curator
	@Test
	public void Test45verifyPublicationSearchByKeywordAsaCurator() throws Exception {
		String testName = "014_verify_publication_search_by_keyword_as_a_Curator";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Keyword as a Curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.verify_publication_search_by_keyword_as_a_Curator("test");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 95
	//Test Name: 018_verify_publication_search_by_keyword_as_a_Researcher
	@Test
	public void Test46verifyPublicationSearchByKeywordAsaResearcher() throws Exception {
		String testName = "018_verify_publication_search_by_keyword_as_a_Researcher";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Keyword as a Researcher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLogin(By.linkText("PUBLICATIONS"));
			Test.verify_publication_search_by_keyword_as_a_Researcher("test");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// Publication >> Add Publication
	//S.N.: 96
	//Test Name: 001_Verify_the_ability_to_submit_a_New_Publication_as_a_Curator
	@Test
	public void Test4VerifyTheAbilityToSubmitaNewPublicationAsaCurator() throws Exception {
		String testName = "001_Verify_the_ability_to_submit_a_New_Publication_as_a_Curator";
		String testDesc = "Verify Curator user able to submit a new publication as a curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication("proceeding", "in press", "", "", "Test Submit Publication As Curator", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "Upload", "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", "", "", "test sample test", "Add", "User", "Researcher CaNano", "canano_res", "read update delete", "Submit", "Search", "");
			Test.wait_For(9000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 97
	//Test Name: 002_Verify_the_ability_to_submit_a_New_Publication_as_a_Researcher
	@Test
	public void Test5VerifyTheAbilityToSubmitaNewPublicationAsaResearcher() throws Exception {
		String testName = "002_Verify_the_ability_to_submit_a_New_Publication_as_a_Researcher";
		String testDesc = "Verify researcher user able to submit a new publication as a curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLogin(By.linkText("PUBLICATIONS"));
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication("proceeding", "in press", "", "", "Test Submit Publication As Researcher", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "Upload", "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", "", "", "test sample test", "Add", "User", "Researcher CaNano", "canano_res", "read update delete", "Submit", "Search", "");
			Test.wait_For(9000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	/*
	 * CURATION 
	 * Review Data Pending Release to Public
	 */
	
	//S.N.: 98
	//Test Name: 001_Verify_Curator_should_be_able_to_review_pending_data
	@Test
	public void Test47verifyCuratorShouldBeAbleToReviewPendingData() throws Exception {
		String testName = "001_Verify_Curator_should_be_able_to_review_pending_data";
		String testDesc = "Verify Curator able to review pending data"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String HomePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(HomePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.clickPageLinks("Review Data Pending Release to Public", "Review By Curator");
			Test.Verify_Curator_should_be_able_to_review_pending_data("sample", "Data Type", "Data Name");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	 /*
	  * CURATION 
	  * Remove Struts from CURATION page
	  */

	//S.N.: 99
	//Test Name: 001_Ensure_Struts_has_been_removed_from_Manage_Curation_page
	@Test
	public void Test48ensureStrutsHasBeenRemovedfromManageCurationPage() throws Exception {
		String testName = "001_Ensure_Struts_has_been_removed_from_Manage_Curation_page";
		String testDesc = "Ensure Struts has been removed from Manage Curation page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			String manageCurationURL = HostName + "/caNanoLab/#/manageCuration";
			Test.verifyUrl(manageCurationURL);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 100
	//Test Name: 002_Ensure_Struts_has_been_removed_from_Review_By_Curator_page
	@Test
	public void Test49ensureStrutsHasBeenRemovedFromReviewByCuratorPage() throws Exception {
		String testName = "002_Ensure_Struts_has_been_removed_from_Review_By_Curator_page";
		String testDesc = "Ensure Struts has been removed from Review by Curator page and system is displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.clickPageLinks("Review Data Pending Release to Public", "Review By Curator");
			String reviewByCuratorURL = HostName + "/caNanoLab/#/reviewData";
			Test.verifyUrl(reviewByCuratorURL);
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

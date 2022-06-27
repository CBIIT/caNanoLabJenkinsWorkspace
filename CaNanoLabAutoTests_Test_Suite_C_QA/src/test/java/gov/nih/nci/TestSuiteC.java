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

public class TestSuiteC {
	static BaseNanoLabMethods Test = new BaseNanoLabMethods();
	private static Logger logger=Logger.getLogger("TestSuite");
	public static String seleniumBrowser = "firefox";
	public static String tier = "dev";
	//public static String HostName = "http://localhost:9090";
	//public static String HostName = "https://cananolab-stage-sg.nci.nih.gov";
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
	
	public TestSuiteC(){
		BaseTestMethods.appRelease = "cananoLab v2.1";
		BaseTestMethods.releaseDesc = "caNanoLab v2.1 is refactored using AngularJS as the Front-end framework and JAVA REST services as the middle-tier";
	}	
	
	//S.N.: 101
	//Test Name: ensureStrutsHasBeenRemovedFromManageBatchDataAvailabilityPage
	@Test
	public void Test1EnsureStrutsHasBeenRemovedFromManageBatchDataAvailabilityPage() throws Exception {
		String testName = "003_Ensure_Struts_has_been_removed_from_Manage_Batch_Data_Availability_page";
		String testDesc = "Ensure Struts has been removed from Manage batch data avilability page and system is displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.clickPageLinks("Manage Batch Data Availability", "Manage Batch Data Availability");
			String manageBatchDataAvailabilityURL = HostName + "/caNanoLab/#/batchDataAvailability";
			Test.verifyUrl(manageBatchDataAvailabilityURL);
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
	* MANAGE CURATION page
	*/
	
	//S.N.: 102
	//Test Name: 001_Verify_Manage_Curation_page_title_exists
	@Test
	public void Test2verifyManageCurationPageTitleExists() throws Exception {
		String testName = "001_Verify_Manage_Curation_page_title_exists";
		String testDesc = "Verify Manage curation title exists under Curation page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String HomePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(HomePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.verifyPage(By.cssSelector(".contentTitle tbody tr th"), "Manage Curation");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 103
	//Test Name: 002_Verify_Review_Data_Pending_Release_to_Public_link_Exists
	@Test
	public void Test3verifyReviewDataPendingReleaseToPublicLinkExists() throws Exception {
		String testName = "002_Verify_Review_Data_Pending_Release_to_Public_link_Exists";
		String testDesc = "Verify Review Data Pending Release to Public link exists under Curation page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String HomePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(HomePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.verifyLink(By.linkText("Review Data Pending Release to Public"));
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 104
	//Test Name: 003_Verify_Manage_Batch_Data_Availability_link_Exists
	@Test
	public void Test4verifyManageBatchDataAvailabilityLinkExists() throws Exception {
		String testName = "003_Verify_Manage_Batch_Data_Availability_link_Exists";
		String testDesc = "Verify Manage Batch Data Avialability link exists under Curation page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			String HomePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(HomePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.verifyLink(By.linkText("Manage Batch Data Availability"));
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
	 * Manage Batch Data Availability
	 */

	//S.N.: 105
	//Test Name: 001_Verify_user_able_to_submit_generate_data_availability_for_all_samples_search
	@Test
	public void Test5verifyUserAbleToSubmitGenerateDataAvailabilityForAllSamplesSearch() throws Exception {
		String testName = "001_Verify_user_able_to_submit_generate_data_availability_for_all_samples_search";
		String testDesc = "Verify user able to submit generate data availability for all samples serach. Depend upon data avilability system may take a while to generate matrics for available samples";
		try{	 
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String HomePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(HomePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Curation");
			Test.verify_user_able_to_submit_generate_data_availability_for_all_samples_search();
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
	 * My Workspace
	 */
	
	//S.N.: 106
	//Test Name: 001_Verify_Curator_user_can_view_My_Worksapce
	@Test
	public void Test6verifyCuratorUserCanViewMyWorksapce() throws Exception {
		String testName = "001_Verify_Curator_user_can_view_My_Worksapce";
		String testDesc = "Verifying My worksapce is visible to the Curator user when user logged into the system"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_user_can_view_My_Worksapce();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 107
	//Test Name: 002_Verify_Researcher_user_can_view_My_Worksapce
	@Test
	public void Test7verifyResearcherUserCanViewMyWorksapce() throws Exception {
		String testName = "002_Verify_Researcher_user_can_view_My_Worksapce";
		String testDesc = "Verifying My worksapce is visible to the Researcher user when user logged into the system";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLogin(By.linkText("MY WORKSPACE"));
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Researcher_user_can_view_My_Worksapce();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 108
	//Test Name: 003_Verify_User_can_uncheck_Samples_from_My_Workspace
	@Test
	public void Test8verifyUserCanUncheckSamplesFromMyWorkspace() throws Exception {
		String testName = "003_Verify_User_can_uncheck_Samples_from_My_Workspace";
		String testDesc = "User should be able to uncheck My Samples and system should display My Protocols and My Publications sections only";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_User_can_uncheck_Samples_from_My_Workspace();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 109
	//Test Name: 004_Verify_User_can_Uncheck_protocols_from_My_Workspace
	@Test
	public void Test9verifyUserCanUncheckProtocolsFromMyWorkspace() throws Exception {
		String testName = "004_Verify_User_can_Uncheck_protocols_from_My_Workspace";
		String testDesc = "User should be able to uncheck My Samples and system should display My Protocols and My Publications sections only";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_User_can_Uncheck_protocols_from_My_Workspace();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 110
	//Test Name: 005_Verify_User_can_uncheck_Publications_from_My_Workspace_page
	@Test
	public void Test10verifyUserCanUncheckPublicationsFromMyWorkspacePage() throws Exception {
		String testName = "005_Verify_User_can_uncheck_Publications_from_My_Workspace_page";
		String testDesc = "User should be able to uncheck My Publications and system should display My samples and My Protoclos sections only"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_User_can_uncheck_Publications_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 111
	//Test Name: 006_Verify_Curator_User_can_View_samples_from_My_Workspace_page
	@Test
	public void Test11verifyCuratorUserCanViewSamplesFromMyWorkspacePage() throws Exception {
		String testName = "006_Verify_Curator_User_can_View_samples_from_My_Workspace_page";
		String testDesc = "User should be able to view My Samples and system should display My samples General info page";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("MY WORKSPACE"));
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_User_can_View_samples_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	

	//112
	//Test Name: 007_Verify_Curator_User_can_Edit_samples_from_My_Workspace_page
	@Test
	public void Test12verifyCuratorUserCanEditSamplesFromMyWorkspacePage() throws Exception {
		String testName = "007_Verify_Curator_User_can_Edit_samples_from_My_Workspace_page";
		String testDesc = "User should be able to Edit My Samples and system should display My samples Edit General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_User_can_Edit_samples_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//113
	//Test Name: 008_Verify_Researcher_User_can_View_samples_from_My_Workspace_page
	@Test
	public void Test13verifyResearcherUserCanViewSamplesFromMyWorkspacePage() throws Exception {
		String testName = "008_Verify_Researcher_User_can_View_samples_from_My_Workspace_page";
		String testDesc = "Researcher User should be able to view My Samples and system should display My samples General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Researcher_User_can_View_samples_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//114
	//Test Name: 009_Verify_Researcher_User_can_Edit_samples_from_My_Workspace_page
	@Test
	public void Test14verifyResearcherUserCanEditSamplesFromMyWorkspacePage() throws Exception {
		String testName = "009_Verify_Researcher_User_can_Edit_samples_from_My_Workspace_page";
		String testDesc = "Researchcer User should be able to Edit My Samples and system should display My samples Edit General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Researcher_User_can_Edit_samples_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//115
	//Test Name: 010_Verify_Curator_User_can_View_My_Protocols_from_My_Workspace_page
	@Test
	public void Test15verifyCuratorUserCanViewMyProtocolsFromMyWorkspacePage() throws Exception {
		String testName = "010_Verify_Curator_User_can_View_My_Protocols_from_My_Workspace_page";
		String testDesc = "User should be able to view My Samples and system should display My samples General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_User_can_View_My_Protocols_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//116
	//Test Name: 011_Verify_Researcher_User_can_View_My_Protocols_from_My_Workspace_page
	@Test
	public void Test16verifyResearcherUserCanViewMyProtocolsFromMyWorkspacePage() throws Exception {
		String testName = "011_Verify_Researcher_User_can_View_My_Protocols_from_My_Workspace_page";
		String testDesc = "User should be able to view My Samples and system should display My samples General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Researcher_User_can_View_My_Protocols_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	
	//117
	//Test Name: 012_Verify_Curator_User_can_Edit_My_Protocols_from_My_Workspace_page
	@Test
	public void Test17VerifyCuratorUserCanEditMyProtocolsFromMyWorkspacePage() throws Exception {
		String testName = "012_Verify_Curator_User_can_Edit_My_Protocols_from_My_Workspace_page";
		String testDesc = "User should be able to view My Samples and system should display My samples General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_User_can_Edit_My_Protocols_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//118
	//Test Name: 013_Verify_Reseracher_User_can_Edit_My_Protocols_from_My_Workspace_page
	@Test
	public void Test18VerifyReseracherUserCanEditMyProtocolsFromMyWorkspacePage() throws Exception {
		String testName = "013_Verify_Reseracher_User_can_Edit_My_Protocols_from_My_Workspace_page";
		String testDesc = "User should be able to view My Samples and system should display My samples General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Reseracher_User_can_Edit_My_Protocols_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//119
	//Test Name: 014_Verify_Curator_User_can_View_My_Publications_from_My_Workspace_page
	@Test
	public void Test19verifyCuratorUserCanViewMyPublicationsFromMyWorkspacePage() throws Exception {
		String testName = "014_Verify_Curator_User_can_View_My_Publications_from_My_Workspace_page";
		String testDesc = "Curator User should be able to view My Publications and system should display My Publication page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_User_can_View_My_Publications_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//120
	//Test Name: 015_Verify_Researcher_User_can_View_My_publications_from_My_Workspace_page
	@Test
	public void Test20verifyResearcherUserCanViewMyPublicationsFromMyWorkspacePage() throws Exception {
		String testName = "015_Verify_Researcher_User_can_View_My_publications_from_My_Workspace_page";
		String testDesc = "Researcher User should be able to view My Publications and system should display My Publication page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Researcher_User_can_View_My_publications_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//121
	//Test Name: 016_Verify_Curator_User_can_Edit_My_Publications_from_My_Workspace_page
	@Test
	public void Test21verifyCuratorUserCanEditMyPublicationsFromMyWorkspacePage() throws Exception {
		String testName = "016_Verify_Curator_User_can_Edit_My_Publications_from_My_Workspace_page";
		String testDesc = "Curator User should be able to Edit My Samples and system should display My Publications Edit page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Curator_User_can_Edit_My_Publications_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
			
		}			
	}
	
	//122
	//Test Name: 017_Verify_Researcher_User_can_Edit_My_Publications_from_My_Workspace_page
	@Test
	public void Test22verifyResearcherUserCanEditMyPublicationsFromMyWorkspacePage() throws Exception {
		String testName = "017_Verify_Researcher_User_can_Edit_My_Publications_from_My_Workspace_page";
		String testDesc = "Researcher User should be able to Edit My Publication and system should display My Publication edit page";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Verify_Researcher_User_can_Edit_My_Publications_from_My_Workspace_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//123
	//Test Name: 018_Ensure_User_can_view_samples_protocols_and_publications_and_use_back_button_from_view_page
	@Test
	public void Test23ensureUsercanViewSamplesProtocolsAndPublicationsAndUseBackButtonFromViewPage() throws Exception {
		String testName = "018_Ensure_User_can_view_samples_protocols_and_publications_and_use_back_button_from_view_page";
		String testDesc = "User should be able to view My Samples and system should display My samples General info page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.Ensure_User_can_view_samples_protocols_and_publications_and_use_back_button_from_view_page();
			String samplePageURL = HostName + "/caNanoLab/#/myWorkspace";
			Test.verifyUrl(samplePageURL);		
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// Remove Struts from Publication page
	
	//S.N.: 124
	//Test Name: 003_Ensure Struts has been removed from Manage Publication Page
	@Test
	public void Test24ensureStrutsHasBeenRemovedFromManagePublicationPage() throws Exception {
		String testName = "003_Ensure Struts has been removed from Manage Publication Page";
		String testDesc = "Ensure Struts has been removed from Manage Publication Search Page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("PUBLICATIONS", "Manage Publications");
			String publicationSearchURL = HostName + "/caNanoLab/#/managePublications";
			Test.verifyUrl(publicationSearchURL);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 125
	//Test Name: 001_Ensure Struts has been removed from Publication Search Page
	@Test
	public void Test25ensureStrutsHasBeenRemovedFromPublicationSearchPage() throws Exception {
		String testName = "001_Ensure Struts has been removed from Publication Search Page";
		String testDesc = "Ensure Struts has been removed from Publication Search Page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("PUBLICATIONS", "Manage Publications");
			Test.clickPageLinks("Search Existing Publications", "Publication Search");
			String publicationSearchURL = HostName + "/caNanoLab/#/searchPublication";
			Test.verifyUrl(publicationSearchURL);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 126
	//Test Name: 001_Ensure Struts has been removed from Publication Submission Page
	@Test
	public void Test26ensureStrutsHasBeenRemovedFromPublicationSubmissionPage() throws Exception {
		String testName = "001_Ensure Struts has been removed from Publication Submission Page";
		String testDesc = "Ensure Struts has been removed from Publication Submission Page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.clickMenubarLinks("PUBLICATIONS", "Manage Publications");
			Test.clickPageLinks("Submit a New Publication", "Submit Publication");
			String publicationSearchURL = HostName + "/caNanoLab/#/submitPublication";
			Test.verifyUrl(publicationSearchURL);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 127
	//Test Name: 001_Ensure Struts has been removed from Search for Samples by Publication Page
	@Test
	public void Test27ensureStrutsHasBeenRemovedFromSearchForSamplesByPublicationPage() throws Exception {
		String testName = "001_Ensure Struts has been removed from Search for Samples by Publication Page";
		String testDesc = "Ensure Struts has been removed from search for samples by Publication Page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.clickMenubarLinks("PUBLICATIONS", "Manage Publications");
			Test.clickPageLinks("Search for Samples by Publication", "Sample Search by Publication");
			String publicationSearchURL = HostName + "/caNanoLab/#/searchSamplesByPublication";
			Test.verifyUrl(publicationSearchURL);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	// Delete Publication
	
	//S.N.: 128
	//Test Name: 001_Verify_that_a_curator_can_remove_submited_publication
	@Test
	public void Test28verifyThatACuratorCanRemoveSampleFromPublication() throws Exception {
		String testName = "001_Verify_that_a_curator_can_remove_submited_publication";
		String testDesc = "Verify Curator user able to submit a new publication as a curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication("proceeding", "in press", "", "", "Test Submit Publication As Curator", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "Upload", "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", "", "", "test sample test", "Add", "User", "Researcher CaNano", "canano_res", "read update delete", "Submit", "Search", "Edit");
			Test.wait_For(9000);
			Test.delete_publication("OK");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
			
		}			
	}
	
	//S.N.: 129
	//Test Name: 002_Verify_that_a_researcher_able_to_remove_sample_from_publication_for_publication_that_user_have_delete_access
	@Test
	public void Test29verifyThatAResearcherAbleToRemoveSampleFromPublicationForPublicationThatUserHaveDeleteAccess() throws Exception {
		String testName = "002_Verify_that_a_researcher_able_to_remove_sample_from_publication_for_publication_that_user_have_delete_access";
		String testDesc = "Verify researcher use able to remove sumited publication that user have delete access"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication("proceeding", "in press", "", "", "Test Submit Publication As Researcher", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "Upload", "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", "", "", "test sample test", "Add", "User", "Researcher CaNano", "canano_res", "read update delete", "Submit", "Search", "Edit");
			Test.wait_For(9000);
			Test.delete_publication("OK");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// Edit Publication
	
	//S.N.: 130
	//Test Name: 001_Verify_that_a_researcher_can_edit_publication_for_publication_that_user_has_update_or_edit_access
	@Test
	public void Test30verifyThatAResearcherCanEditPublicationForPublicationThatUserHasUpdateOrEditAccess() throws Exception {
		String testName = "001_Verify_that_a_researcher_can_edit_publication_for_publication_that_user_has_update_or_edit_access";
		String testDesc = "Verify researcher use able to remove sumited publication that user have delete access"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication("proceeding", "in press", "", "", "Test Submit Publication As Researcher", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "Upload", "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", "", "", "test sample test", "Add", "User", "Researcher CaNano", "canano_res", "read update delete", "Submit", "Search", "Edit");
			Test.wait_For(9000);
			Test.submit_a_new_publication("", "", "", "", "Test Submit Publication As Researcher Update", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "", "", "", "", "test sample test", "", "", "", "", "", "Update", "Search", "Edit");
			Test.wait_For(9000);
			Test.delete_publication("OK");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 131
	//Test Name: 003_Verify_that_a_curator_can_edit_publication
	@Test
	public void Test31verifyThatACuratorCanEditPublication() throws Exception {
		String testName = "003_Verify_that_a_curator_can_edit_publication";
		String testDesc = "Verify Curator user able to submit a new publication as a curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication("proceeding", "in press", "", "", "Test Submit Publication As Curator", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "Upload", "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", "", "", "test sample test", "Add", "User", "Researcher CaNano", "canano_res", "read update delete", "Submit", "Search", "Edit");
			Test.wait_For(9000);
			Test.submit_a_new_publication("", "", "", "", "Test Submit Publication As Curator Update", "Test Journal", "", "1", "1", "99", "Auto", "FirstName", "LastName", "FL", "QA\nTest\nValidation\nPublication", "Test Description for Publication", "characterization", "", "", "", "", "test sample test", "", "", "", "", "", "Update", "Search", "Edit");
			Test.wait_For(9000);
			Test.delete_publication("OK");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// Submit Samples
	
	//S.N.: 132 ---
	//Test Name: 001_Verify_the_ability_to_add_a_new_sample_as_a_Curator
	@Test
	public void Test32VerifyTheAbilityToAddANewSampleAsACurator() throws Exception {
		String testName = "001_Verify_the_ability_to_add_a_new_sample_as_a_Curator";
		String testDesc = "Verify Curator user able to submit a new Samples as a curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			//Submit Sample
			Test.submit_new_sample("Test Submit Sample As Curator", "Submit");
			Test.Verify_the_ability_to_submit_a_New_Samples_general_info("Test Submit Sample As Curator", "BB_SH_DFCI_WCMC_BWH_MIT", "investigator", "Researcher CaNano", "canano_res");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 133 ---
	//Test Name: 002_Verify_the_ability_to_add_a_new_sample_as_a_Researcher
	@Test
	public void Test33VerifyTheAbilityToAddANewSampleAsAResearcher() throws Exception {
		String testName = "002_Verify_the_ability_to_add_a_new_sample_as_a_Researcher";
		String testDesc = "Verify Curator user able to submit a new Samples as a Researcher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLogin(By.linkText("MY WORKSPACE"));
			Test.Verify_the_ability_to_submit_a_New_Samples_general_info("Test Submit Sample As Researcher", "BB_SH_DFCI_WCMC_BWH_MIT", "investigator", "Guest Guest", "canano_guest");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 134 ---
	//Test Name: 005_Verify_the_ability_to_add_a_Sample_Composition_Naomaterial_Entity_as_Curator
	@Test
	public void Test44verifyTheAbilityToDeleteASampleCompositionNaomaterialEntityAsCurator() throws Exception {
		String testName = "005_Verify_the_ability_to_add_a_Sample_Composition_Naomaterial_Entity_as_Curator";
		String testDesc = "Verify Curator user able to submit a new Samples composition nanomaterial entity as a curator";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.Verify_the_ability_to_submit_a_New_Samples_general_info("Test Submit Sample As Curator", "BB_SH_DFCI_WCMC_BWH_MIT", "investigator", "Researcher CaNano", "canano_res");
			Test.Verify_the_ability_to_add_a_Sample_Composition_Naomaterial_Entity_as_Curator();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 135 ---
	//Test Name: 006_Verify_the_ability_to_add_a_Sample_Composition_Functionalizing_Entity_as_Curator
	@Test
	public void Test45verifyTheAbilityToDeleteASampleCompositionFunctionalizingEntityAsCurator() throws Exception {
		String testName = "006_Verify_the_ability_to_add_a_Sample_Composition_Functionalizing_Entity_as_Curator";
		String testDesc = "Verify Curator user able to submit a new Samples composition fucntionalizing entity as a curator";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			//Test.Search_Samples__For_Composition_Naomaterial_Entity("Test Submit Sample As Curator14213528");
			Test.Verify_the_ability_to_submit_a_New_Samples_general_info("Test Submit Sample As Curator", "BB_SH_DFCI_WCMC_BWH_MIT", "investigator", "Researcher CaNano", "canano_res");
			Test.Verify_the_ability_to_add_a_Sample_Composition_Functionalizing_Entity_as_Curator();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	
	//Submit Protocols
	
	//S.N.: 136 ---
	//Test Name: 006_Verify_the_ability_to_add_a_Sample_Composition_Functionalizing_Entity_as_Curator
	@Test
	public void Test34VerifyTheAbilityToSubmitANewProtocolsAsACurator() throws Exception {
		String testName = "001_Verify_the_ability_to_submit_a_New_Protocols_as_a_Curator";
		String testDesc = "Verify Curator user able to submit a new Protocol";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.submit_a_New_Protocols("AsynthesisB", "Test Submit Protocol As Curator ", "Test Protocol Abbreviation", "Test Protocol Version 1", "external1", "http://www.test.com", "Test File Title", "Test Description", "Researcher CaNano", "canano_res");			
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}

	//S.N.: 137 ---
	//Test Name: 002_Verify_the_ability_to_submit_a_New_Protocols_as_a_Researcher
	@Test
	public void Test35VerifyTheAbilityToSubmitANewProtocolsAsAResearcher() throws Exception {
		String testName = "002_Verify_the_ability_to_submit_a_New_Protocols_as_a_Researcher";
		String testDesc = "Verify Researcher user able to submit a new Protocol"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.submit_a_New_Protocols("AsynthesisB", "Test Submit Protocol As Researcher ", "Test Protocol Abbreviation", "Test Protocol Version 1", "external1", "http://www.test.com", "Test File Title", "Test Description", "Guest Guest", "canano_guest");			
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	
	// Protocol 
	// Remove Struts from Protocol page
	
	//S.N.: 138 ---
	//Test Name: 002_Verify_the_ability_to_submit_a_New_Protocols_as_a_Researcher
	@Test
	public void Test36ensureStrutsHasBeenRemovedFromManageProtocolPage() throws Exception {
		String testName = "001_Ensure_Struts_has_been_removed_from_Manage_Protocol_page";
		String testDesc = "Ensure Struts has been removed from Manage Protocol page and the system is displaying the new framework URL";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("PROTOCOLS", "Manage Protocols");
			String manageCurationURL = HostName + "/caNanoLab/#/manageProtocols";
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
	
	//S.N.: 139 ---
	//Test Name: 002_Ensure_Struts_has_been_removed_from_Submit_a_New_Protocol_page
	@Test
	public void Test37ensureStrutsHasBeenRemovedFromSubmitANewProtocolpage() throws Exception {
		String testName = "002_Ensure_Struts_has_been_removed_from_Submit_a_New_Protocol_page";
		String testDesc = "Ensure Struts has been removed from Submit Protocol page and the system is displaying the new framework URL";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("PROTOCOLS", "Manage Protocols");
			Test.clickPageLinks("Submit a New Protocol", "Submit Protocol");
			String manageCurationURL = HostName + "/caNanoLab/#/submitProtocol";
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
	
	//S.N.: 140 ---
	//Test Name: 003_Ensure_Struts_has_been_removed_from_Search_Existing_Protocols_page
	@Test
	public void Test38ensureStrutsHasBeenRemovedFromSearchExistingProtocolsPage() throws Exception {
		String testName = "003_Ensure_Struts_has_been_removed_from_Search_Existing_Protocols_page";
		String testDesc = "Ensure Struts has been removed from Search existing Protocol page and the system is displaying the new framework URL";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/home";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("PROTOCOLS", "Manage Protocols");
			Test.clickPageLinks("Search Existing Protocols", "Protocol Search");
			String manageCurationURL = HostName + "/caNanoLab/#/searchProtocol";
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
	
	
	// Search Protocols
	
	//S.N.: 141 ---
	//Test Name: 001_Verify_the_ability_to_Search_Protocols_as_a_Curator
	@Test
	public void Test39verifyTheAbilityToSearchProtocolsAsACurator() throws Exception {
		String testName = "001_Verify_the_ability_to_Search_Protocols_as_a_Curator";
		String testDesc = "Ensure Curator user able to serach existing protocols"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.clickMenubarLinks("PROTOCOLS", "Manage Protocols");
			Test.clickPageLinks("Search Existing Protocols", "Protocol Search");
			Test.search_Existing_Protocols("search", "", "contains", "", "contains", "", "contains","");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 142 ---
	//Test Name: 001_Verify_the_ability_to_Search_Protocols_as_a_Curator
	@Test
	public void Test40verifyTheAbilityToSearchProtocolsAsACurator1() throws Exception {
		String testName = "001_Verify_the_ability_to_Search_Protocols_as_a_Curator";
		String testDesc = "Ensure Curator user able to serach existing protocols"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.clickMenubarLinks("PROTOCOLS", "Manage Protocols");
			Test.clickPageLinks("Search Existing Protocols", "Protocol Search");
			Test.search_Existing_Protocols("search", "AsynthesisB", "contains", "Test Submit", "contains", "", "contains","");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// Sample page verification
	
	//S.N.: 143 ---
	//Test Name: 001_Verify_the_ability_to_Search_Protocols_as_a_Curator
	@Test
	public void Test41VerifySampleSubmitPage() throws Exception {
		String testName = "001_Verify_the_ability_to_Search_Protocols_as_a_Curator";
		String testDesc = "Ensure Curator user able to serach existing protocols"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			Test.clickMenubarLinks("SAMPLES", "Manage Samples");
			Test.clickPageLinks("Copy an Existing Sample", "Submit Sample");
			Test.verify_Sample_Submit_page();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	
	// Advanced Search
	
	//Sample Criteria - Curator
	
	//S.N.: 144
	//Test Name: 001_Curator User should be able to add sample criteria with sample name and contains filter to the Advanced sample search
	@Test
	public void Test42curatorUserShouldBeAbleToAddSampleCriteriaWithSampleNameAndContainsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "001_Curator User should be able to add sample criteria with sample name and contains filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add sample criteria with sample name and contains filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"sample name"/*getSampleORPOCName*/, 
				"contains"/*getSampCriContainsOrEqual*/, 
				"NCL-23"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				""/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				""/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                "Yes"/*verifySearchSampleValYesOrNo*/, 
                "contains"/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 145
	//Test Name: 002_Curator User should be able to add sample criteria with sample name and equals filter to the Advanced sample search
	@Test
	public void Test43curatorUserShouldBeAbleToAddSampleCriteriaWithSampleNameAndEqualsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "002_Curator User should be able to add sample criteria with sample name and equals filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add sample criteria with sample name and equals filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"sample name"/*getSampleORPOCName*/, 
				"equals"/*getSampCriContainsOrEqual*/, 
				"NCL-23-1"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				""/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				""/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                "Yes"/*verifySearchSampleValYesOrNo*/, 
                "equals"/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 146
	//Test Name: 003_Curator User should be able to perform Advanced sample search by sample criteria with point of contact name and contains filter
	@Test
	public void Test46curatorUserShouldBeAbleToPefromAdvancedSampleSearchBySampleCriteriaWithPointOfContactNameAndContainsFilter() throws Exception {
		String testName = "003_Curator User should be able to perform Advanced sample search by sample criteria with point of contact name and contains filter";
		String testDesc = "Ensure Curator User should be able to perform Advanced sample search by sample criteria with point of contact name and contains filter"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"point of contact name"/*getSampleORPOCName*/, 
				"contains"/*getSampCriContainsOrEqual*/, 
				"David"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				""/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				""/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                ""/*verifySearchSampleValYesOrNo*/, 
                ""/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 147
	//Test Name: 004_Curator User should be able to perform Advanced sample search by sample criteria with point of contact name and equals filter
	@Test
	public void Test47curatorUserShouldBeAbleToPefromAdvancedSampleSearchBySampleCriteriaWithPointOfContactNameAndEqualsFilter() throws Exception {
		String testName = "004_Curator User should be able to perform Advanced sample search by sample criteria with point of contact name and equals filter";
		String testDesc = "Ensure Curator User should be able to perform Advanced sample search by sample criteria with point of contact name and equals filter"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"point of contact name"/*getSampleORPOCName*/, 
				"equals"/*getSampCriContainsOrEqual*/, 
				"David A Scheinberg"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				""/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				""/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                ""/*verifySearchSampleValYesOrNo*/, 
                ""/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 147
	//Test Name: 005_Ensure Curator user able to Reset sample criteria from adavanced sample search page
	@Test
	public void Test48ensureCuratorUserAbleToResetSampleCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "005_Ensure Curator user able to Reset sample criteria from adavanced sample search page";
		String testDesc = "Ensure Curator user able to Reset sample criteria from adavanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"point of contact name"/*getSampleORPOCName*/, 
				"equals"/*getSampCriContainsOrEqual*/, 
				"David A Scheinberg"/*getSampleCriteriaName*/, 
				"Reset"/*getSampCriAddOrReset*/, 
				""/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				""/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                ""/*getSearchOrReset*/, 
                ""/*verifySearchSampleValYesOrNo*/, 
                ""/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			//Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 148
	//Test Name: 006_Ensure Curator user able to Remove sample criteria from adavanced sample search page
	@Test
	public void Test49ensureCuratorUserAbleToRemoveSampleCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "006_Ensure Curator user able to Remove sample criteria from adavanced sample search page";
		String testDesc = "Ensure Curator user able to Remove sample criteria from adavanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"sample name"/*getSampleORPOCName*/, 
				"equals"/*getSampCriContainsOrEqual*/, 
				"NCL-23-1"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				"Edit"/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				"Remove"/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                ""/*verifySearchSampleValYesOrNo*/, 
                ""/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			//Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 149
	//Test Name: 007_Ensure Curator user able to Edit sample criteria from adavanced sample search page
	@Test
	public void Test50EnsureCuratorUserAbleToEditSampleCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "007_Ensure Curator user able to Edit sample criteria from adavanced sample search page";
		String testDesc = "Ensure Curator user able to Edit sample criteria from adavanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(
				"sample name"/*getSampleORPOCName*/, 
				"equals"/*getSampCriContainsOrEqual*/, 
				"NCL-23-1"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				"Edit"/*getSampleCriteriaEdit*/, 
				"point of contact name"/*getSampleORPOCNameEdit*/, 
				"contains"/*getSampCriContainsOrEqualEdit*/, 
				"David"/*getSampleCriteriaNameEdit*/, 
				"Add"/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                ""/*verifySearchSampleValYesOrNo*/, 
                ""/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
			//Test.verify_advanced_sample_search_result_count();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//Sample Criteria - Researcher
	
	//S.N.: 150
	//Test Name: 001_Researcher User should be able to add sample criteria with sample name and contains filter to the Advanced sample search
	@Test
	public void Test51researcherUserShouldBeAbleToAddSampleCriteriaWithSampleNameAndContainsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "001_Researcher User should be able to add sample criteria with sample name and contains filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add sample criteria with sample name and contains filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(	
				"sample name"/*getSampleORPOCName*/, 
				"contains"/*getSampCriContainsOrEqual*/, 
				"NCL-23"/*getSampleCriteriaName*/, 
				"Add"/*getSampCriAddOrReset*/, 
				""/*getSampleCriteriaEdit*/, 
				""/*getSampleORPOCNameEdit*/, 
				""/*getSampCriContainsOrEqualEdit*/, 
				""/*getSampleCriteriaNameEdit*/, 
				""/*getSampCriAddOrResetOrRemoveEdit*/, 
                ""/*getCompositionCriteriaFilterA*/, 
                ""/*getCompositionCriteriaFilterB*/, 
                ""/*getCompositionCriteriaContainsOrEqual*/, 
                ""/*getCompositionCriteriaName*/, 
                ""/*getCompositionCriteriaAddOrReset*/, 
                ""/*getCompositionCriteriaAEdit*/, 
                ""/*getCompositionCriteriaFilterAEdit*/, 
                ""/*getCompositionCriteriaFilterBEdit*/, 
                ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
                ""/*getCompositionCriteriaNameEdit*/, 
                ""/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
                ""/*getCharacterizationCriteriaFilterA*/, 
                ""/*getCharacterizationCriteriaFilterB*/, 
                ""/*getCharacterizationCriteriaFilterC*/, 
                ""/*getCharacterizationCriteriaFilterD*/, 
                ""/*getCharacterizationCriteriaFilterE*/, 
                ""/*getCharacterizationCriteriaFilterF*/, 
                ""/*getCharacterizationCriteriaAddOrReset*/, 
                ""/*getCharacterizationCriteriaEdit*/, 
                ""/*getCharacterizationCriteriaFilterAEdit*/, 
                ""/*getCharacterizationCriteriaFilterBEdit*/, 
                ""/*getCharacterizationCriteriaFilterCEdit*/, 
                ""/*getCharacterizationCriteriaFilterDEdit*/, 
                ""/*getCharacterizationCriteriaFilterEEdit*/, 
                ""/*getCharacterizationCriteriaFilterFEdit*/, 
                ""/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
                "Search"/*getSearchOrReset*/, 
                "Yes"/*verifySearchSampleValYesOrNo*/, 
                "contains"/*getContainsOrEqual*/, 
                ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(5000);
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

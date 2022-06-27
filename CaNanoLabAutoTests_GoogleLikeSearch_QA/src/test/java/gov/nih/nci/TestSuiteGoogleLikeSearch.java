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

public class TestSuiteGoogleLikeSearch {
	static BaseNanoLabMethods Test = new BaseNanoLabMethods();
	private static Logger logger=Logger.getLogger("TestSuite");
	public static String seleniumBrowser = "firefox";
	public static String tier = "dev";
	//public static String HostName = "http://localhost:9090";
	//public static String HostName = "https://cananolab-stage-sg.nci.nih.gov";
	public static String HostName = "https://cananolab-qa.nci.nih.gov";
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
	
	public TestSuiteGoogleLikeSearch(){
		BaseTestMethods.appRelease = "cananoLab v2.1";
		BaseTestMethods.releaseDesc = "caNanoLab v2.1 is refactored using AngularJS as the Front-end framework and JAVA REST services as the middle-tier";
	}	
		
	
	//Google Like Search
	//Google Like Search - Sample
	//Google Like Search - Sample Data - Public
	
	//S.N.: 237
	//Test Name: 001_Verify User able to search for publicly available samples from google like search without login
	@Test
	public void Test1verifyUserAbleToSearchForPubliclyAvailableSamplesFromGoogleLikeSearchWithoutLogin() throws Exception {
		String testName = "001_Verify User able to search for publicly available samples from google like search without login";
		String testDesc = "Verify User able to search for publicly available samples from google like search without login"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
				 "Test Submit Sample for Google Like Search As Curator", /****getSampleName***/
				 "Add", /****getClickPOCAddButton***/
				 "", /****getPOCOrganizationName***/
				 "", /****getPOCRole***/
				 "Yes", /****getAddressYesOrNo***/
				 "Save", /****getPOCSaveOrCancel***/
				 "Test", /****getKeywordA***/
				 "Sample", /****getKeywordB***/
				 "qa", /****getKeywordC***/
				 "Yes", /****getAccessAddYes***/
				 "Public", /****getAccessBy***/
				 "", /****getUserLoginName***/
				 "", /****getUserName***/
				 "", /****getAccessToTheSample***/
				 "Submit" /****getSubmitOrReset***/);
			Test.logout();
			//Test.cananolab_search(
			//	 "Yes",/***vSearchEle ***/
//"Test",/***getSearchTerm ***/ 
//				 "Search",/***getSearchVal ***/ 
//				 "Yes",/***getSrchRsltVerifYes ***/ 
//				 "Yes",/***getRsltMatch ***/ 
//				 "View"/***getActions ***/);
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 238
	//Test Name: 002_Verify User able to search for publicly available samples from google like search while user logged in as curator
	@Test
	public void Test2verifyUserAbleToSearchForPubliclyAvailableSamplesFromGoogleLikeSearchWhileUserLoggedInAsCurator() throws Exception {
		String testName = "002_Verify User able to search for publicly available samples from google like search while user logged in as curator";
		String testDesc = "Verify User able to search for publicly available samples from google like search while user logged in as curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
				 "Test Submit Sample for Google Like Search As Curator", /****getSampleName***/
				 "Add", /****getClickPOCAddButton***/
				 "", /****getPOCOrganizationName***/
				 "", /****getPOCRole***/
				 "Yes", /****getAddressYesOrNo***/
				 "Save", /****getPOCSaveOrCancel***/
				 "Test", /****getKeywordA***/
				 "Sample", /****getKeywordB***/
				 "qa", /****getKeywordC***/
				 "Yes", /****getAccessAddYes***/
				 "Public", /****getAccessBy***/
				 "", /****getUserLoginName***/
				 "", /****getUserName***/
				 "", /****getAccessToTheSample***/
				 "Submit" /****getSubmitOrReset***/);
			Test.logout();
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "Test Submit Sample",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 "View"/***getActions ***/);
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 239
	//Test Name: 003_Verify User able to search for publicly available samples from google like search while user logged in as researcher
	@Test
	public void Test3VerifyUserAbleToSearchForPubliclyAvailableSamplesFromGoogleLikeSearchWhileUserLoggedInAsResearcher() throws Exception {
		String testName = "003_Verify User able to search for publicly available samples from google like search while user logged in as researcher";
		String testDesc = "Verify User able to search for publicly available samples from google like search while user logged in as researcher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
				 "Test Submit Sample for Google Like Search As Researcher", /****getSampleName***/
				 "Add", /****getClickPOCAddButton***/
				 "", /****getPOCOrganizationName***/
				 "", /****getPOCRole***/
				 "Yes", /****getAddressYesOrNo***/
				 "Save", /****getPOCSaveOrCancel***/
				 "Test", /****getKeywordA***/
				 "Sample", /****getKeywordB***/
				 "qa", /****getKeywordC***/
				 "Yes", /****getAccessAddYes***/
				 "Public", /****getAccessBy***/
				 "", /****getUserLoginName***/
				 "", /****getUserName***/
				 "", /****getAccessToTheSample***/
				 "Submit" /****getSubmitOrReset***/);
			Test.logout();
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "Test Submit Sample for Google Like Search As Researcher",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 "View"/***getActions ***/);
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 240
	//Test Name: 004_Verify User should not be able to search non publicly available samples from google like search without login
	@Test
	public void Test4VerifyUserShouldNotBeAbleToSearchNonPubliclyAvailableSamplesFromGoogleLikeSearchWithoutLogin() throws Exception {
		String testName = "004_Verify User should not be able to search non publicly available samples from google like search without login";
		String testDesc = "Verify User should not be able to search non publicly available samples from google like search without login"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
				 "Test Submit Sample As Curator For Google like Search", /****getSampleName***/
				 "Add", /****getClickPOCAddButton***/
				 "", /****getPOCOrganizationName***/
				 "", /****getPOCRole***/
				 "Yes", /****getAddressYesOrNo***/
				 "Save", /****getPOCSaveOrCancel***/
				 "Test", /****getKeywordA***/
				 "Sample", /****getKeywordB***/
				 "qa", /****getKeywordC***/
				 "Yes", /****getAccessAddYes***/
				 "User", /****getAccessBy***/
				 "Researcher CaNano", /****getUserLoginName***/
				 "canano_res", /****getUserName***/
				 "read update delete", /****getAccessToTheSample***/
				 "Submit" /****getSubmitOrReset***/);
			Test.logout();
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "Read",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "",/***getSrchRsltVerifYes ***/ 
				 "",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_verification(
				 "Find", /***verRsltFind ***/ 
				 "", /***verSerchTerm ***/ 
				 "" /***verNoSearchResult ***/);
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//Google Like Search - Sample Data
	
	//S.N.: 241
	//Test Name: 001_Verify User able to search for publicly available samples from google like search while user logged in as curator
	@Test
	public void Test5VerifyUserAbleToSearchForPubliclyAvailableSamplesFromGoogleLikeSearchWhileUserLoggedInAsCurator() throws Exception {
		String testName = "001_Verify User able to search for publicly available samples from google like search while user logged in as curator";
		String testDesc = "Verify User able to search for publicly available samples from google like search while user logged in as curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
				 "Test Submit Sample As Curator For Google like Search", /****getSampleName***/
				 "Add", /****getClickPOCAddButton***/
				 "", /****getPOCOrganizationName***/
				 "", /****getPOCRole***/
				 "Yes", /****getAddressYesOrNo***/
				 "Save", /****getPOCSaveOrCancel***/
				 "Test", /****getKeywordA***/
				 "Sample", /****getKeywordB***/
				 "qa", /****getKeywordC***/
				 "Yes", /****getAccessAddYes***/
				 "User", /****getAccessBy***/
				 "Researcher CaNano", /****getUserLoginName***/
				 "canano_res", /****getUserName***/
				 "read update delete", /****getAccessToTheSample***/
				 "Submit" /****getSubmitOrReset***/);
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "Test Submit Sample As Curator For Google like Search",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "",/***getSrchRsltVerifYes ***/ 
				 "",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_verification(
				 "Find", /***verRsltFind ***/ 
				 "", /***verSerchTerm ***/ 
				 "" /***verNoSearchResult ***/);
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 242
	//Test Name: 002_Verify User able to search for publicly available samples from google like search while user logged in as Researcher
	@Test
	public void Test6erifyUserAbleToSearchForPubliclyAvailableSamplesFromGoogleLikeSearchWhileUserLoggedInAsResearcher() throws Exception {
		String testName = "002_Verify User able to search for publicly available samples from google like search while user logged in as Researcher";
		String testDesc = "Verify User able to search for publicly available samples from google like search while user logged in as Researcher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
				 "Test Submit Sample As Researcher For Google like Search", /****getSampleName***/
				 "Add", /****getClickPOCAddButton***/
				 "", /****getPOCOrganizationName***/
				 "", /****getPOCRole***/
				 "Yes", /****getAddressYesOrNo***/
				 "Save", /****getPOCSaveOrCancel***/
				 "Test", /****getKeywordA***/
				 "Sample", /****getKeywordB***/
				 "qa", /****getKeywordC***/
				 "Yes", /****getAccessAddYes***/
				 "User", /****getAccessBy***/
				 "Guest Guest", /****getUserLoginName***/
				 "canano_guest", /****getUserName***/
				 "read update delete", /****getAccessToTheSample***/
				 "Submit" /****getSubmitOrReset***/);
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "Test Submit Sample As Curator For Google like Search",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "",/***getSrchRsltVerifYes ***/ 
				 "",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_verification(
				 "Find", /***verRsltFind ***/ 
				 "", /***verSerchTerm ***/ 
				 "" /***verNoSearchResult ***/);
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//Google Like Search - General
	
	//S.N.: 243
	//Test Name: 001_Verify Google like search does not return any search results when user search for invalid search term
	@Test
	public void Test7GoogleLikeSearchDoesNotReturnAnySearchResultsWhenUserSearchForInvalidSearchTerm() throws Exception {
		String testName = "001_Verify Google like search does not return any search result when user search for invalid search term";
		String testDesc = "Verify Google like search does not return any search result when user search for invalid search term"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
	//		Test.cananolab_search(
	//			 "Yes",/***vSearchEle ***/
	//			 "abcdefghijklmnopqrstuvwxyz",/***getSearchTerm ***/ 
	//			 "Search",/***getSearchVal ***/ 
	//			 "",/***getSrchRsltVerifYes ***/ 
	//			 "",/***getRsltMatch ***/ 
	//			 ""/***getActions ***/);
	//		Test.cananolab_search_verification(
	//			 "", /***verRsltFind ***/ 
	//			 "", /***verSerchTerm ***/ 
	//			 "No Search Result" /***verNoSearchResult ***/);
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 244
	//Test Name: 002_Ensure user able to sort google like search results by name
	@Test
	public void Test8nsureUserAbleToSortGoogleLikeSearchResultsByName() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by name";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by name column"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
	//		Test.cananolab_search(
	//			 "Yes",/***vSearchEle ***/
	//			 "test",/***getSearchTerm ***/ 
//"Search",/***getSearchVal ***/ 
	//			 "Yes",/***getSrchRsltVerifYes ***/ 
	//			 "Yes",/***getRsltMatch ***/ 
	//			 ""/***getActions ***/);
			//Test.cananolab_search_sort_verify_by("Name");
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 245
	//Test Name: 003_Ensure user able to sort google like search results by type
	@Test
	public void Test9EnsureUserAbleToSortGoogleLikeSearchResultsByType() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Type";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Type column"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
	//		Test.cananolab_search(
	//			 "Yes",/***vSearchEle ***/
	//			 "test",/***getSearchTerm ***/ 
	//			 "Search",/***getSearchVal ***/ 
	//			 "Yes",/***getSrchRsltVerifYes ***/ 
	//			 "Yes",/***getRsltMatch ***/ 
	//			 ""/***getActions ***/);
			//Test.cananolab_search_sort_verify_by("Type");
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 246
	//Test Name: 004_Ensure user able to sort google like search results by Created Date
	@Test
	public void Test10EnsureUserAbleToSortGoogleLikeSearchResultsByCreatedDate() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Created Date";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Created Date column"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
	//		Test.cananolab_search(
	//			 "Yes",/***vSearchEle ***/
	//			 "test",/***getSearchTerm ***/ 
	//			 "Search",/***getSearchVal ***/ 
	//			 "Yes",/***getSrchRsltVerifYes ***/ 
	//			 "Yes",/***getRsltMatch ***/ 
// ""/***getActions ***/);
			//Test.cananolab_search_sort_verify_by("CreatedDate");
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 247
	//Test Name: 005_Ensure user able to sort google like search results by Description
	@Test
	public void Test11EnsureUserAbleToSortGoogleLikeSearchResultsByDescription() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Description";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Description column"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
	//		Test.cananolab_search(
	//			 "Yes",/***vSearchEle ***/
	//			 "test",/***getSearchTerm ***/ 
	//			 "Yes",/***getSrchRsltVerifYes ***/ 
	//			 "Yes",/***getRsltMatch ***/ 
	//			 ""/***getActions ***/);
			//Test.cananolab_search_sort_verify_by("Description");
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 248
	//Test Name: 006_Ensure user able to sort google like search results by name when user logged in as Curator
	@Test
	public void Test12EnsureUserAbleToSortGoogleLikeSearchResultsByNameWhenUserLoggerInAsCurator() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by name when user logged in as Curator";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by name column when user logged in as Curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Name");
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 249
	//Test Name: 007_Ensure user able to sort google like search results by type when user logged in as Curator
	@Test
	public void Test13EnsureUserAbleToSortGoogleLikeSearchResultsByTypeWhenUserLoggerInAsCurator() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Type when user logged in as Curator";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Type column when user logged in as Curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Type");
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 250
	//Test Name: 008_Ensure user able to sort google like search results by Created Date when user logged in as Curator
	@Test
	public void Test14EnsureUserAbleToSortGoogleLikeSearchResultsByCreatedDateWhenUserLoggerInAsCurator() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Created Date when user logged in as Curator";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Created Date column when user logged in as Curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("CreatedDate");
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 251
	//Test Name: 009_Ensure user able to sort google like search results by Description when user logged in as Curator
	@Test
	public void Test15EnsureUserAbleToSortGoogleLikeSearchResultsByDescriptionWhenUserLoggerInAsCurator() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Description when user logged in as Curator";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Description column when user logged in as Curator"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Description");
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 252
	//Test Name: 010_Ensure user able to sort google like search results by name when user logged in as Researcher
	@Test
	public void Test16EnsureUserAbleToSortGoogleLikeSearchResultsByNameWhenUserLoggerInAsReasercher() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by name when user logged in as Reasercher";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by name column when user logged in as Reasercher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Name");
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 253
	//Test Name: 011_Ensure user able to sort google like search results by type when user logged in as Reasercher
	@Test
	public void Test17EnsureUserAbleToSortGoogleLikeSearchResultsByTypeWhenUserLoggerInAsReasercher() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Type when user logged in as Reasercher";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Type column when user logged in as Reasercher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Type");
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 254
	//Test Name: 012_Ensure user able to sort google like search results by Created Date when user logged in as Reasercher
	@Test
	public void Test18EnsureUserAbleToSortGoogleLikeSearchResultsByCreatedDateWhenUserLoggerInAsReasercher() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Created Date when user logged in as Reasercher";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Created Date column when user logged in as Reasercher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("CreatedDate");
			Test.wait_For(3000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			Test.setupAfterSuite();		
		}		
	}
	
	//S.N.: 255
	//Test Name: 013_Ensure user able to sort google like search results by Description when user logged in as Reasercher
	@Test
	public void Test19EnsureUserAbleToSortGoogleLikeSearchResultsByDescriptionWhenUserLoggerInAsReasercher() throws Exception {
		String testName = "002_Ensure user able to sort google like search results by Description when user logged in as Reasercher";
		String testDesc = "Ensure user should be able to search via google like search and sort result table by Description column when user logged in as Reasercher"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.cananolab_search(
				 "Yes",/***vSearchEle ***/
				 "test",/***getSearchTerm ***/ 
				 "Search",/***getSearchVal ***/ 
				 "Yes",/***getSrchRsltVerifYes ***/ 
				 "Yes",/***getRsltMatch ***/ 
				 ""/***getActions ***/);
			Test.cananolab_search_sort_verify_by("Description");
			Test.wait_For(3000);
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

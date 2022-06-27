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

public class TestSuiteE {
	static BaseNanoLabMethods Test = new BaseNanoLabMethods();
	private static Logger logger=Logger.getLogger("TestSuite");
	public static String seleniumBrowser = "firefox";
	public static String tier = "dev";
	//public static String HostName = "http://localhost:9090";
	//public static String HostName = "https://cananolab-stage-sg.nci.nih.gov";
	public static String HostName = "https://cananolab-qa.nci.nih.gov";
	//public static String HostName = "https://cananolab-stage-sg.nci.nih.gov";
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
	
	public TestSuiteE(){
		BaseTestMethods.appRelease = "cananoLab v2.1";
		BaseTestMethods.releaseDesc = "caNanoLab v2.1 is refactored using AngularJS as the Front-end framework and JAVA REST services as the middle-tier";
	}	
	
	//My Favorites
	//Edit
	
	//S.N.: 201
	//Test Name: 001_Ensure Curator user able to add a Sample to the Favorites list and edit the added sample from my favorites page
	@Test
	public void Test1EnsureCuratorUserAbleToAddASampleToTheFavoritesListAndEditTheAddedSampleFromMyFavoritesPage() throws Exception {
		String testName = "001_Ensure Curator user able to add a Sample to the Favorites list and edit the added sample from my favorites page";
		String testDesc = "Ensure Curator user able to add a Sample to the Favorites list and edit the added sample from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Test Submit Sample As", "", "", "", "", "", "", "", "search");
			Test.wait_until_search_samples_table_data_load();
			Test.sample_add_to_favorites("Test Submit Sample", "yes", "edit");
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

	//S.N.: 202
	//Test Name: 002_Ensure Curator user able to add a Protocol to the Favorites list and edit the added protocol from my favorites page
	@Test
	public void Test2ensureCuratorUserAbleToAddAProtocolToTheFavoritesListAndEditTheAddedProtocolFromMyFavoritesPage() throws Exception {
		String testName = "002_Ensure Curator user able to add a Protocol to the Favorites list and edit the added protocol from my favorites page";
		String testDesc = "Ensure Curator user able to add a Protocol to the Favorites list and edit the added protocol from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "Test Submit Protocol", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("Test Submit Protocol", "yes", "edit");
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

	//S.N.: 203
	//Test Name: 003_Ensure Curator user able to add a publication to the Favorites list and edit the added publication from my favorites page
	@Test
	public void Test3EnsureCuratorUserAbleToAddAPublicationToTheFavoritesListAndEditTheAddedPublicationFromMyFavoritesPage() throws Exception {
		String testName = "003_Ensure Curator user able to add a publication to the Favorites list and edit the added publication from my favorites page";
		String testDesc = "Ensure Curator user able to add a publication to the Favorites list and edit the added publication from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_publication_all();
			Test.navigate_to_publication_search_page();
			Test.publication_search("", "", "", "", "contains", "Test Submit publication", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("Test Submit Publication", "yes", "edit");
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

	//My Favorites
	//remove

	//S.N.: 204
	//Test Name: 001_Ensure Curator user able to add a Sample to the Favorites list and remove the added sample from my favorites page
	@Test
	public void Test4EnsureCuratorUserAbleToAddASampleToTheFavoritesListAndRemoveTheAddedSampleFromMyFavoritesPage() throws Exception {
		String testName = "001_Ensure Curator user able to add a Sample to the Favorites list and remove the added sample from my favorites page";
		String testDesc = "Ensure Curator user able to add a Sample to the Favorites list and remove the added sample from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Test Submit Sample As", "", "", "", "", "", "", "", "search");
			Test.wait_until_search_samples_table_data_load();
			Test.sample_add_to_favorites("Test Submit Sample", "yes", "remove");
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

	//S.N.: 205
	//Test Name: 002_Ensure Curator user able to add a Protocol to the Favorites list and remove the added protocol from my favorites page
	@Test
	public void Test5ensureCuratorUserAbleToAddAProtocolToTheFavoritesListAndRemoveTheAddedProtocolFromMyFavoritesPage() throws Exception {
		String testName = "002_Ensure Curator user able to add a Protocol to the Favorites list and remove the added protocol from my favorites page";
		String testDesc = "Ensure Curator user able to add a Protocol to the Favorites list and remove the added protocol from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "Test Submit Protocol", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("Test Submit Protocol", "yes", "remove");
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

	//S.N.: 206
	//Test Name: 003_Ensure Curator user able to add a publication to the Favorites list and remove the added publication from my favorites page
	@Test
	public void Test6EnsureCuratorUserAbleToAddAPublicationToTheFavoritesListAndRemoveTheAddedPublicationFromMyFavoritesPage() throws Exception {
		String testName = "003_Ensure Curator user able to add a publication to the Favorites list and remove the added publication from my favorites page";
		String testDesc = "Ensure Curator user able to add a publication to the Favorites list and remove the added publication from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_publication_all();
			Test.navigate_to_publication_search_page();
			Test.publication_search("", "", "", "", "contains", "Test Submit publication", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("Test Submit Publication", "yes", "remove");
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

	// Favorites
	// Researcher

	//S.N.: 207
	//Test Name: 001_Ensure researcher user able to add a Sample to the Favorites list
	@Test
	public void Test7EnsureresearcherUserAbleToAddASampleToTheFavoritesList() throws Exception {
		String testName = "001_Ensure researcher user able to add a Sample to the Favorites list";
		String testDesc = "Ensure researcher user able to add a Sample from sample search results page to the my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			//Test.samples_search_simple("", "contains", "Test Submit Sample As", "", "", "", "", "", "", "", "search");
			//Test.wait_until_search_samples_table_data_load();
			//Test.sample_add_to_favorites("Test Submit Sample", "yes", "");
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

	//S.N.: 208
	//Test Name: 002_Ensure researcher user able to add a Protocol to the Favorites list
	@Test
	public void Test8EnsureresearcherUserAbleToAddAProtocolToTheFavoritesList() throws Exception {
		String testName = "002_Ensure researcher user able to add a Protocol to the Favorites list";
		String testDesc = "Ensure researcher user able to add a Protocol from Protocol search results page to the my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "ASYN_B00005_PROT1", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("ASYN_B00005_PROT1", "yes", "");
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

	//S.N.: 209
	//Test Name: 003_Ensure researcher user able to add a Publication to the Favorites list
	@Test
	public void Test9EnsureresearcherUserAbleToAddAPublicationToTheFavoritesList() throws Exception {
		String testName = "003_Ensure researcher user able to add a Publication to the Favorites list";
		String testDesc = "Ensure researcher user able to add a Publication from Publication search results page to the my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_publication_all();
			Test.navigate_to_publication_search_page();
			Test.publication_search("", "", "", "", "contains", "Test Submit publication", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("Test Submit Publication", "yes", "");
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

	//My Favorites
	//Researcher
	//View

	//S.N.: 210
	//Test Name: 001_Ensure researcher user able to add a Sample to the Favorites list and view the added sample from my favorites page
	@Test
	public void Test10EnsureresearcherUserAbleToAddASampleToTheFavoritesListAndViewTheAddedSampleFromMyFavoritesPage() throws Exception {
		String testName = "001_Ensure researcher user able to add a Sample to the Favorites list and view the added sample from my favorites page";
		String testDesc = "Ensure researcher user able to add a Sample to the Favorites list and view the added sample from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Test Submit Sample", "", "", "", "", "", "", "", "search");
			Test.wait_until_search_samples_table_data_load();
			Test.sample_add_to_favorites("Test Submit Sample", "yes", "view");
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

	//S.N.: 211
	//Test Name: 002_Ensure researcher user able to add a Protocol to the Favorites list and view the added protocol from my favorites page
	@Test
	public void Test11ensureresearcherUserAbleToAddAProtocolToTheFavoritesListAndViewTheAddedProtocolFromMyFavoritesPage() throws Exception {
		String testName = "002_Ensure researcher user able to add a Protocol to the Favorites list and view the added protocol from my favorites page";
		String testDesc = "Ensure researcher user able to add a Protocol to the Favorites list and view the added protocol from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "Test Submit Protocol", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("Test Submit Protocol", "yes", "view");
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

	//S.N.: 212
	//Test Name: 003_Ensure researcher user able to add a publication to the Favorites list and view the added publication from my favorites page
	@Test
	public void Test12EnsureresearcherUserAbleToAddAPublicationToTheFavoritesListAndViewTheAddedPublicationFromMyFavoritesPage() throws Exception {
		String testName = "003_Ensure researcher user able to add a publication to the Favorites list and view the added publication from my favorites page";
		String testDesc = "Ensure researcher user able to add a publication to the Favorites list and view the added publication from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_publication_all();
			Test.navigate_to_publication_search_page();
			Test.publication_search("", "", "", "", "contains", "doped nanoshells", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("doped nanoshells", "yes", "view");
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

	//My Favorites
	//Researcher
	//Edit

	//S.N.: 213
	//Test Name: 001_Ensure researcher user able to add a Sample to the Favorites list and edit the added sample from my favorites page
	@Test
	public void Test13EnsureresearcherUserAbleToAddASampleToTheFavoritesListAndEditTheAddedSampleFromMyFavoritesPage() throws Exception {
		String testName = "001_Ensure researcher user able to add a Sample to the Favorites list and edit the added sample from my favorites page";
		String testDesc = "Ensure researcher user able to add a Sample to the Favorites list and edit the added sample from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Test Submit Sample As Researcher", "", "", "", "", "", "", "", "search");
			Test.wait_until_search_samples_table_data_load();
			Test.sample_add_to_favorites("Test Submit Sample As Researcher", "yes", "edit");
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

	//S.N.: 214
	//Test Name: 002_Ensure researcher user able to add a Protocol to the Favorites list and edit the added protocol from my favorites page
	@Test
	public void Test14ensureResearcherUserAbleToAddAProtocolToTheFavoritesListAndEditTheAddedProtocolFromMyFavoritesPage() throws Exception {
		String testName = "002_Ensure researcher user able to add a Protocol to the Favorites list and edit the added protocol from my favorites page";
		String testDesc = "Ensure researcher user able to add a Protocol to the Favorites list and edit the added protocol from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "Test Submit Protocol", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("Test Submit Protocol", "yes", "edit");
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

	//S.N.: 215
	//Test Name: 003_Ensure researcher user able to add a publication to the Favorites list and edit the added publication from my favorites page
	@Test
	public void Test15EnsureresearcherUserAbleToAddAPublicationToTheFavoritesListAndEditTheAddedPublicationFromMyFavoritesPage() throws Exception {
		String testName = "003_Ensure researcher user able to add a publication to the Favorites list and edit the added publication from my favorites page";
		String testDesc = "Ensure researcher user able to add a publication to the Favorites list and edit the added publication from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_publication_all();
			Test.navigate_to_publication_search_page();
			Test.publication_search("", "", "", "", "contains", "doped nanoshells", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("doped nanoshells ", "yes", "edit");
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

	//My Favorites
	//Researcher
	//remove

	//S.N.: 216
	//Test Name: 001_Ensure researcher user able to add a Sample to the Favorites list and remove the added sample from my favorites page
	@Test
	public void Test16EnsureResearcherUserAbleToAddASampleToTheFavoritesListAndRemoveTheAddedSampleFromMyFavoritesPage() throws Exception {
		String testName = "001_Ensure researcher user able to add a Sample to the Favorites list and remove the added sample from my favorites page";
		String testDesc = "Ensure researcher user able to add a Sample to the Favorites list and remove the added sample from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Sample", "", "", "", "", "", "", "", "search");
			Test.wait_until_search_samples_table_data_load();
			Test.sample_add_to_favorites("Test Submit Sample", "yes", "remove");
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

	//S.N.: 217
	//Test Name: 002_Ensure researcher user able to add a Protocol to the Favorites list and remove the added protocol from my favorites page
	@Test
	public void Test17ensureResearcherUserAbleToAddAProtocolToTheFavoritesListAndRemoveTheAddedProtocolFromMyFavoritesPage() throws Exception {
		String testName = "002_Ensure researcher user able to add a Protocol to the Favorites list and remove the added protocol from my favorites page";
		String testDesc = "Ensure researcher user able to add a Protocol to the Favorites list and remove the added protocol from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "ASYN_B00005_PROT1", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("Test Submit Protocol", "yes", "remove");
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

	//S.N.: 218
	//Test Name: 003_Ensure researcher user able to add a publication to the Favorites list and remove the added publication from my favorites page
	@Test
	public void Test18EnsureResearcherUserAbleToAddAPublicationToTheFavoritesListAndRemoveTheAddedPublicationFromMyFavoritesPage() throws Exception {
		String testName = "003_Ensure researcher user able to add a publication to the Favorites list and remove the added publication from my favorites page";
		String testDesc = "Ensure researcher user able to add a publication to the Favorites list and remove the added publication from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.remove_my_favorites_publication_all();
			Test.navigate_to_publication_search_page();
			Test.publication_search("", "", "", "", "contains", "nonpalpable tumors", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("Test Submit Publication", "yes", "remove");
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

	// Sample Submit - Curator

	//S.N.: 219
	//Test Name: 001_Ensure Curator User able to submit a sample
	@Test
	public void Test19EnsureCuratorUserAbleToSubmitASample() throws Exception {
		String testName = "001_Ensure Curator User able to submit a sample";
		String testDesc = "Verify curator user able to login to the system as curator and submit a sample successfully"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample As Curator", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
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

	//S.N.: 220
	//Test Name: 002_Ensure Curator User able to submit a Nanomaterial entity to the sample 
	@Test
	public void Test21ensureCuratorUserAbleToSubmitANanomaterialEntityToTheSample() throws Exception {
		String testName = "002_Ensure Curator User able to submit a Nanomaterial entity to the sample";
		String testDesc = "Ensure Curator User able to submit a Nanomaterial entity to the sample "; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Nanomaterial Entity As Curator", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_nanomaterial_entity();
			Test.submit_a_sample_composition_nanomaterrial(
					"biopolymer", /****getNanomaterialEntityType***/
					"Test Submit Sample Nanomaterial Entity", /****getDescription ***/ 
					"arabino-hezulose", /****getBiopolymerName ***/
					"peptide", /**** getBiopolymerType ***/ 
					"test arabino-hezulose", /****getBiopolymerSequence ***/ 
					"coat", /****getCompEleType ***/
					"Acetaminophen", /****getCompEleChemicalName ***/
					"Substance", /****getCompElePubChemDataSource ***/
					"random", /****getCompElePubChemId ***/
					"0.1", /****getCompEleAmount ***/
					"%", /****getCompEleAmountUnit ***/
					"Hill", /****getCompEleMolecularFormulaType ***/
					"Acetaminophen", /****getMolecularFormula ***/
					"Acetaminophen (paracetamol, N-acetyl-p-aminophenol, 4-hydroxyacetanilide) is a widely used analgesic and antipyretic", /****getComEleDescription ***/
					"Add", /****getCompEleInherentFunctionAdd ***/
					"endosomolysis", /****getComEleInherentFunctionType ***/
					"endosomolysis description", /****getComEleInherentDescription ***/
					"Save", /****getInherentFunctionSaveOrCancelOrRemove ***/
					"Save", /****getCompositionElementSaveOrCancel ***/
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/);
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

	//S.N.: 221
	//Test Name: 003_Ensure Curator User able to submit a Functionalzing entity to the sample 
	@Test
	public void Test22ensureCuratorUserAbleToSubmitAFunctionalizingEntityToTheSample() throws Exception {
		String testName = "003_Ensure Curator User able to submit a Functionalzing entity to the sample";
		String testDesc = "Ensure Curator User able to submit a Functionalzing entity to the sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Functionalizing Entity As Curator", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_functionalizing_entity();
			Test.submit_a_sample_composition_functionalizing(
					"Magnetic Particle", /***getFunctionalizingEntityType***/
					"Chromate and dichromate",
					"BioAssay",
					"random",
					"5",
					"%",
					"Hill",
					"Test Molecular Formula",
					"enzymatic cleavage",
					"Test Activation Effect",
					"Description",
					"", /***getInherentFunctionAdd***/
					"endosomolysis",
					"Inherent Function Description",
					"Save",
					"",
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/
					);
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

	//S.N.: 222
	//Test Name: 004_Ensure Curator User able to submit a Chemical Association to the sample 
	@Test
	public void Test23ensureCuratorUserAbleToSubmitAChemicalAssociationToTheSample() throws Exception {
		String testName = "004_Ensure Curator User able to submit a Chemical Association to the sample";
		String testDesc = "Ensure Curator User able to submit a Chemical Association to the sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Chemical Association As Curator", /****getSampleName***/
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
					"canano_res", /****getUserLoginName***/
					"canano_res", /****getUserName***/
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_nanomaterial_entity();
			Test.submit_a_sample_composition_nanomaterrial(
					"biopolymer", /****getNanomaterialEntityType***/
					"Test Submit Sample Nanomaterial Entity", /****getDescription ***/ 
					"arabino-hezulose", /****getBiopolymerName ***/
					"peptide", /**** getBiopolymerType ***/ 
					"test arabino-hezulose", /****getBiopolymerSequence ***/ 
					"coat", /****getCompEleType ***/
					"Acetaminophen", /****getCompEleChemicalName ***/
					"Substance", /****getCompElePubChemDataSource ***/
					"random", /****getCompElePubChemId ***/
					"0.1", /****getCompEleAmount ***/
					"%", /****getCompEleAmountUnit ***/
					"Hill", /****getCompEleMolecularFormulaType ***/
					"Acetaminophen", /****getMolecularFormula ***/
					"Acetaminophen (paracetamol, N-acetyl-p-aminophenol, 4-hydroxyacetanilide) is a widely used analgesic and antipyretic", /****getComEleDescription ***/
					"Add", /****getCompEleInherentFunctionAdd ***/
					"endosomolysis", /****getComEleInherentFunctionType ***/
					"endosomolysis description", /****getComEleInherentDescription ***/
					"Save", /****getInherentFunctionSaveOrCancelOrRemove ***/
					"Save", /****getCompositionElementSaveOrCancel ***/
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/);
			Test.wait_For(5000);
			Test.navigate_to_sample_composition_functionalizing_entity();
			Test.submit_a_sample_composition_functionalizing(
					"Magnetic Particle", /***getFunctionalizingEntityType***/
					"Chromate and dichromate",
					"BioAssay",
					"random",
					"5",
					"%",
					"Hill",
					"Test Molecular Formula",
					"enzymatic cleavage",
					"Test Activation Effect",
					"Description",
					"", /***getInherentFunctionAdd***/
					"endosomolysis",
					"Inherent Function Description",
					"Save",
					"",
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/
					);
			Test.wait_For(5000);
			Test.navigate_to_sample_composition_chamical_association();
			Test.submit_a_sample_composition_chemical_association(
					"Association", /****getAssociationType***/
					"Test Submit Chemical Association", /****getDescription***/
					"nanomaterial entity", /****getElementSelectA***/
					"functionalizing entity", /****getElementSelectB***/
					"biopolymer", /****getEelementSelectAA***/
					"Magnetic Particle", /****getEelementSelectBB***/
					"coat (name: Acetaminophen)", /****getEelementSelectAAA***/
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"Submit" /****getSubmitOrReset ***/
					);
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

	//S.N.: 223
	//Test Name: 005_Ensure Curator User able to submit a Composition File to the sample 
	//@Test
	public void Test20EnsureCuratorUserAbleToSubmitACompositionFileToTheSample() throws Exception {
		String testName = "005_Ensure Curator User able to submit a Composition File to the sample";
		String testDesc = "Ensure Curator User able to submit a Composition File to the sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Composition File As Curator", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.wait_For(5000);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_file();
			Test.submit_a_sample_composition_file(
					"File", /****getFileAdd***/
					"Upload", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"SamplesFile", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"image", /****getFileType***/
					"Test Sample Image", /****getFileTitle***/
					"Test Image", /****getFileKeywords***/
					"Test Image Description", /****getFileDescription***/
					"Submit" /****getSubmitOrReset ***/
					);	
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

	//Submit Sample - Researcher

	//S.N.: 224
	//Test Name: 001_Ensure Researcher User able to submit a sample
	@Test
	public void Test24EnsureResearcherUserAbleToSubmitASample() throws Exception {
		String testName = "001_Ensure Researcher User able to submit a sample";
		String testDesc = "Verify Researcher user able to login to the system as Researcher and submit a sample successfully"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample As Researcher", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
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

	//S.N.: 225
	//Test Name: 002_Ensure Researcher User able to submit a Nanomaterial entity to the sample 
	@Test
	public void Test25ensureResearcherUserAbleToSubmitANanomaterialEntityToTheSample() throws Exception {
		String testName = "002_Ensure Researcher User able to submit a Nanomaterial entity to the sample";
		String testDesc = "Ensure Researcher User able to submit a Nanomaterial entity to the sample "; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Nanomaterial Entity As Researcher", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_nanomaterial_entity();
			Test.submit_a_sample_composition_nanomaterrial(
					"biopolymer", /****getNanomaterialEntityType***/
					"Test Submit Sample Nanomaterial Entity", /****getDescription ***/ 
					"arabino-hezulose", /****getBiopolymerName ***/
					"peptide", /**** getBiopolymerType ***/ 
					"test arabino-hezulose", /****getBiopolymerSequence ***/ 
					"coat", /****getCompEleType ***/
					"Acetaminophen", /****getCompEleChemicalName ***/
					"Substance", /****getCompElePubChemDataSource ***/
					"random", /****getCompElePubChemId ***/
					"0.1", /****getCompEleAmount ***/
					"%", /****getCompEleAmountUnit ***/
					"Hill", /****getCompEleMolecularFormulaType ***/
					"Acetaminophen", /****getMolecularFormula ***/
					"Acetaminophen (paracetamol, N-acetyl-p-aminophenol, 4-hydroxyacetanilide) is a widely used analgesic and antipyretic", /****getComEleDescription ***/
					"Add", /****getCompEleInherentFunctionAdd ***/
					"endosomolysis", /****getComEleInherentFunctionType ***/
					"endosomolysis description", /****getComEleInherentDescription ***/
					"Save", /****getInherentFunctionSaveOrCancelOrRemove ***/
					"Save", /****getCompositionElementSaveOrCancel ***/
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/);
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

	//S.N.: 226
	//Test Name: 003_Ensure Researcher User able to submit a Functionalzing entity to the sample 
	@Test
	public void Test26ensureResearcherUserAbleToSubmitAFunctionalizingEntityToTheSample() throws Exception {
		String testName = "003_Ensure Researcher User able to submit a Functionalzing entity to the sample";
		String testDesc = "Ensure Researcher User able to submit a Functionalzing entity to the sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Functionalizing Entity As Researcher", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_functionalizing_entity();
			Test.submit_a_sample_composition_functionalizing(
					"Magnetic Particle", /***getFunctionalizingEntityType***/
					"Chromate and dichromate",
					"BioAssay",
					"random",
					"5",
					"%",
					"Hill",
					"Test Molecular Formula",
					"enzymatic cleavage",
					"Test Activation Effect",
					"Description",
					"", /***getInherentFunctionAdd***/
					"endosomolysis",
					"Inherent Function Description",
					"Save",
					"",
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/
					);
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

	//S.N.: 227
	//Test Name: 004_Ensure Researcher User able to submit a Chemical Association to the sample 
	@Test
	public void Test27ensureResearcherUserAbleToSubmitAChemicalAssociationToTheSample() throws Exception {
		String testName = "004_Ensure Researcher User able to submit a Chemical Association to the sample";
		String testDesc = "Ensure Researcher User able to submit a Chemical Association to the sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Chemical Association As Researcher", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_nanomaterial_entity();
			Test.submit_a_sample_composition_nanomaterrial(
					"biopolymer", /****getNanomaterialEntityType***/
					"Test Submit Sample Nanomaterial Entity", /****getDescription ***/ 
					"arabino-hezulose", /****getBiopolymerName ***/
					"peptide", /**** getBiopolymerType ***/ 
					"test arabino-hezulose", /****getBiopolymerSequence ***/ 
					"coat", /****getCompEleType ***/
					"Acetaminophen", /****getCompEleChemicalName ***/
					"Substance", /****getCompElePubChemDataSource ***/
					"random", /****getCompElePubChemId ***/
					"0.1", /****getCompEleAmount ***/
					"%", /****getCompEleAmountUnit ***/
					"Hill", /****getCompEleMolecularFormulaType ***/
					"Acetaminophen", /****getMolecularFormula ***/
					"Acetaminophen (paracetamol, N-acetyl-p-aminophenol, 4-hydroxyacetanilide) is a widely used analgesic and antipyretic", /****getComEleDescription ***/
					"Add", /****getCompEleInherentFunctionAdd ***/
					"endosomolysis", /****getComEleInherentFunctionType ***/
					"endosomolysis description", /****getComEleInherentDescription ***/
					"Save", /****getInherentFunctionSaveOrCancelOrRemove ***/
					"Save", /****getCompositionElementSaveOrCancel ***/
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"", /****getCopyToTheOtherSample ***/
					"Submit" /****getSubmitOrReset ***/);
			Test.wait_For(5000);
			Test.navigate_to_sample_composition_functionalizing_entity();
			Test.submit_a_sample_composition_functionalizing(
				 "Magnetic Particle", /***getFunctionalizingEntityType**/
				 "Chromate and dichromate",
				 "BioAssay",
				 "random",
				 "5",
				 "%",
				 "Hill",
				 "Test Molecular Formula",
				 "enzymatic cleavage",
				 "Test Activation Effect",
				 "Description",
				 "", /***getInherentFunctionAdd***/
				 "endosomolysis",
				 "Inherent Function Description",
				 "Save",
				 "",
			     "", /****getFileAdd***/
			     "", /****getFileUpload***/
			     "", /****getFileEnterFileURL***/
			     "", /****getFileUploadBrowse***/
			     "", /****getFileEnterFileURLAddress***/
			     "", /****getFileType***/
			     "", /****getFileTitle***/
			     "", /****getFileKeywords***/
			     "", /****getFileDescription***/
			     "", /****getFileSaveOrCancel***/
			     "", /****getCopyToTheOtherSample ***/
			     "Submit" /****getSubmitOrReset ***/
				 );
			Test.wait_For(5000);
			Test.navigate_to_sample_composition_chamical_association();
			Test.submit_a_sample_composition_chemical_association(
					"Association", /****getAssociationType***/
					"Test Submit Chemical Association", /****getDescription***/
					"nanomaterial entity", /****getElementSelectA***/
					"functionalizing entity", /****getElementSelectB***/
					"biopolymer", /****getEelementSelectAA***/
					"Magnetic Particle", /****getEelementSelectBB***/
					"coat (name: Acetaminophen)", /****getEelementSelectAAA***/
					"", /****getFileAdd***/
					"", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"", /****getFileType***/
					"", /****getFileTitle***/
					"", /****getFileKeywords***/
					"", /****getFileDescription***/
					"", /****getFileSaveOrCancel***/
					"Submit" /****getSubmitOrReset ***/
					);
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

	//S.N.: 228
	//Test Name: 005_Ensure Researcher User able to submit a Composition File to the sample 
	@Test
	public void Test28ensureResearcherUserAbleToSubmitACompositionFileToTheSample() throws Exception {
		String testName = "005_Ensure Researcher User able to submit a Composition File to the sample";
		String testDesc = "Ensure Researcher User able to submit a Composition File to the sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_submit_a_new_sample_page();
			Test.submit_a_new_sample(
					"Test Submit Sample with Composition File As Researcher", /****getSampleName***/
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
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
			Test.wait_For(5000);
			Test.navigate_to_sample_composition();
			Test.navigate_to_sample_composition_file();
			Test.submit_a_sample_composition_file(
					"File", /****getFileAdd***/
					"Upload", /****getFileUpload***/
					"", /****getFileEnterFileURL***/
					"SamplesFile", /****getFileUploadBrowse***/
					"", /****getFileEnterFileURLAddress***/
					"image", /****getFileType***/
					"Test Sample Image", /****getFileTitle***/
					"Test Image", /****getFileKeywords***/
					"Test Image Description", /****getFileDescription***/
					"Submit" /****getSubmitOrReset ***/
					);	
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

	//Group

	//S.N.: 256
	//Test Name: 001_Ensure Only Curator user able to Add a groups to the collaboration Groups
	@Test
	public void Test29EnsureOnlyCuratorUserAbleToAddAGroupsToTheCollaborationGroups() throws Exception {
		String testName = "001_Ensure Only Curator user able to Add a groups to the collaboration Groups";
		String testDesc = "Ensure only curator user able to create a collaboration groups and add to the manage community"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.verifyLinkNotPresentOnThePage(By.linkText("GROUPS"));
			Test.logout();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLinkOnThePage(By.linkText("GROUPS"));
			Test.navigate_to_groups_page();
			Test.navigate_to_manage_collaboration_groups_page();
			Test.add_new_collaboration_group("Add", "", "", "Add", "", "Submit");
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

	//S.N.: 257
	//Test Name: 002_Ensure user should be able to submit a protocol and associate a collaboration group
	@Test
	public void Test30EnsureUserShouldBeAbleToSubmitAProtocolAndAssociateACollaborationGroup() throws Exception {
		String testName = "002_Ensure user should be able to submit a protocol and associate a collaboration group";
		String testDesc = "Ensure user should be able to submit a protocol and associate a collaboration group"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLinkOnThePage(By.linkText("GROUPS"));
			Test.navigate_to_groups_page();
			Test.navigate_to_manage_collaboration_groups_page();
			Test.add_new_collaboration_group("Add", "", "", "Add", "", "Submit");
			Test.goHome();
			Test.submit_a_New_Protocols(
					"AsynthesisB", 
					"Test Submit Protocol As Curator ", 
					"Test Protocol Abbreviation", 
					"Test Protocol Version 1", 
					"external1", 
					"http://www.test.com", 
					"Test File Title", 
					"Test Description", 
					"", 
					"collaboration");			
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

	//S.N.: 258
	//Test Name: 003_Ensure user should be able to submit a publication and associate a collaboration group
	@Test
	public void Test31EnsureUserShouldBeAbleToSubmitAPublicationAndAssociateACollaborationGroup() throws Exception {
		String testName = "003_Ensure user should be able to submit a publication and associate a collaboration group";
		String testDesc = "Ensure user should be able to submit a publication and associate a collaboration group"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLinkOnThePage(By.linkText("GROUPS"));
			Test.navigate_to_groups_page();
			Test.navigate_to_manage_collaboration_groups_page();
			Test.add_new_collaboration_group("Add", "", "", "Add", "", "Submit");
			Test.goHome();
			Test.navigate_to_submit_to_new_publication_page();
			Test.submit_a_new_publication(
					"proceeding",/*** getpbType***/ 
					"in press", /***getpbStatus ***/
					"", /***getPubmedID ***/
					"", /*** getDOI***/
					"Test Submit Publication As Curator", /***getTitle ***/
					"Test Journal",/***getJournal ***/ 
					"", /*** getYear***/
					"1", /*** getVolume***/
					"1", /*** getStartPage***/
					"99", /*** getEndPage***/
					"Auto", /*** getAuthors***/
					"FirstName", /*** getAuthFirstName***/
					"LastName", /*** getAuthLastName***/
					"FL", /*** getAuthInitials***/
					"QA\nTest\nValidation\nPublication", /*** getKeywords***/
					"Test Description for Publication", /***getDescription ***/
					"characterization", /*** getResearchCategory***/
					"", /*** getUpload***/
					"", /***getUploadPath ***/ 
					"", /*** getEnterFileURL***/
					"", /*** getEnterFileURLPath***/
					"test sample test", /*** getSampleName***/
					"Add", /*** getAccessToThePublication***/
					"Collaboration", /***getAccessBy ***/
					"Researcher CaNano", /***getUserLoginName ***/
					"canano_res", /***getUserName ***/
					"READ WRITE DELETE", /*** getAccessToTheRole***/
					"Submit", /***getSubmitOrResetOrUpdate ***/
					"", /*** getSearchPublication***/
					""); /*** getEditAndAddToFavorites***/
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

	//S.N.: 259
	//Test Name: 004_Ensure user should be able to submit a sample and associate a collaboration group
	@Test
	public void Test32EnsureUserShouldBeAbleToSubmitASampleAndAssociateACollaborationGroup() throws Exception {
		String testName = "004_Ensure user should be able to submit a sample and associate a collaboration group";
		String testDesc = "Ensure user should be able to submit a sample and associate a collaboration group"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLinkOnThePage(By.linkText("GROUPS"));
			Test.navigate_to_groups_page();
			Test.navigate_to_manage_collaboration_groups_page();
			Test.add_new_collaboration_group("Add", "", "", "Add", "", "Submit");
			Test.goHome();
			Test.wait_For(3000);
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
					"Collaboration", /****getAccessBy***/
					"Guest Guest", /****getUserLoginName***/
					"canano_guest", /****getUserName***/
					"READ WRITE DELETE", /****getAccessToTheSample***/
					"Submit" /****getSubmitOrReset***/);
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

	
	
	@After
	  public void tearDown() throws Exception {
		Test.shutdown();
	  }
}

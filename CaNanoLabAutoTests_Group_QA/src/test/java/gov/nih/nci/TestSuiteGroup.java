package gov.nih.nci;
import org.openqa.selenium.By;
import gov.nih.nci.HelperMethods.BaseTestMethods;
import gov.nih.nci.HelperMethods.BaseNanoLabMethods;

import org.junit.*;
import org.apache.log4j.Logger;

public class TestSuiteGroup {
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
	
	public TestSuiteGroup(){
		BaseTestMethods.appRelease = "cananoLab v2.1";
		BaseTestMethods.releaseDesc = "caNanoLab v2.1 is refactored using AngularJS as the Front-end framework and JAVA REST services as the middle-tier";
	}	
		
	
	//Group
	
	//S.N.: 256
	//Test Name: 001_Ensure Only Curator user able to Add a groups to the collaboration Groups
	@Test
	public void Test1EnsureOnlyCuratorUserAbleToAddAGroupsToTheCollaborationGroups() throws Exception {
		String testName = "001_Ensure Only Curator user able to Add a groups to the collaboration Groups";
		String testDesc = "Ensure only curator user able to create a collaboration groups and add to the manage community"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
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
	public void Test2EnsureUserShouldBeAbleToSubmitAProtocolAndAssociateACollaborationGroup() throws Exception {
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
	public void Test3EnsureUserShouldBeAbleToSubmitAPublicationAndAssociateACollaborationGroup() throws Exception {
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
				 "Upload", /*** getUpload***/
				 "C:\\My Frameworks\\WebDriver\\Application\\caNanoLab\\UploadFile\\publicationl sample.txt", /***getUploadPath ***/ 
				 "", /*** getEnterFileURL***/
				 "", /*** getEnterFileURLPath***/
				 "test sample test", /*** getSampleName***/
				 "Add", /*** getAccessToThePublication***/
				 "Collaboration", /***getAccessBy ***/
				 "Researcher CaNano", /***getUserLoginName ***/
				 "canano_res", /***getUserName ***/
				 "read update delete", /*** getAccessToTheRole***/
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
	public void Test4EnsureUserShouldBeAbleToSubmitASampleAndAssociateACollaborationGroup() throws Exception {
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
				 "read update delete", /****getAccessToTheSample***/
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

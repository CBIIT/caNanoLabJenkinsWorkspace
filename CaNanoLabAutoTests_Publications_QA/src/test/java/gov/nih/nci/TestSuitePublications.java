package gov.nih.nci;
import org.openqa.selenium.By;
import gov.nih.nci.HelperMethods.BaseTestMethods;
import gov.nih.nci.HelperMethods.BaseNanoLabMethods;

import org.junit.*;
import org.apache.log4j.Logger;

public class TestSuitePublications {
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
	
	public TestSuitePublications(){
		BaseTestMethods.appRelease = "cananoLab v2.1";
		BaseTestMethods.releaseDesc = "caNanoLab v2.1 is refactored using AngularJS as the Front-end framework and JAVA REST services as the middle-tier";
	}	

	// Publication >> Search for Samples by Publication
	
	//S.N.: 60
	//Test Name: 001_Verify_sample_search_by_publication_PubMed_ID
	@Test
	public void Test1verifySampleSearchByPublicationPubMedID() throws Exception {
		String testName = "001_Verify_sample_search_by_publication_PubMed_ID";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by PubMed ID"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
			Test.wait_For(3000);
			Test.Verify_sample_search_by_publication_PubMed_ID("17278104", "PubMed ID: 17278104");
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
	public void Test2verifySampleSearchByPublicationDOI() throws Exception {
		String testName = "002_Verify_sample_search_by_publication_DOI";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by DOI"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test3verifySampleSearchByPublicationPubMedIDasaCurator() throws Exception {
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
	public void Test6verifySampleSearchByPublicationDOIasaCurator() throws Exception {
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
	public void Test7verifySampleSearchByPublicationPubMedIDasaResearcher() throws Exception {
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
	public void Test8verifySampleSearchByPublicationDOIasaResearcher() throws Exception {
		String testName = "006_Verify_sample_search_by_publication_DOI_as_a_Researcher";
		String testDesc = "Verify Researcher able to search publicly available data from caNanoLab Publication search page by DOI";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
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
	public void Test9verifyPublicationSearchByKeyword() throws Exception {
		String testName = "001_Verify_publication_search_by_keyword";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Keyword";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test10verifyPublicationSearchByPublicationType() throws Exception {
		String testName = "002_Verify_publication_search_by_Publication_Type";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Publication Type"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test11verifyPublicationSearchByResearchCategory() throws Exception {
		String testName = "003_Verify_publication_search_by_Research_Category";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Reasearch Category"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test12verifyPublicationSearchByPubMedID() throws Exception {
		String testName = "004_Verify_publication_search_by_PubMed_ID";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by PubMedID";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test13verifyPublicationSearchByDigitalObjectID() throws Exception {
		String testName = "005_Verify_publication_search_by_Digital_Object_ID";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by digital object ID"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test14VerifyPublicationContainsSearchbyPublicationTitle() throws Exception {
		String testName = "006_Verify_publication_contains_search_by_Publication_Title";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by publication title as contains search";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test15VerifyPublicationEqualsSearchByPublicationTitle() throws Exception {
		String testName = "007_Verify_publication_equals_search_by_Publication_Title";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by publication title as equals search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test16VerifyPublicationSearchByAuthors() throws Exception {
		String testName = "008_Verify_publication_search_by_Authors";
		String testDesc = "Verify user able to search publicly available data from caNanoLab Publication search page by Authors"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test17verifyPublicationSearchBySampleNameContains() throws Exception {
		String testName = "009_Verify_publication_search_by_Sample_Name_contains";
		String testDesc = "Verify publication search by Sample Name as contains";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test18verifyPublicationSearchBySampleNameEquals() throws Exception {
		String testName = "010_Verify_publication_search_by_Sample_Name_equals";
		String testDesc = "Verify publication search by Sample Name as equals"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test19verifyPublicationSearchByCompositionNanomaterialEntity_1() throws Exception {
		String testName = "011_Verify_publication_search_by_Composition_Nanomaterial_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test20verifyPublicationSearchByCompositionNanomaterialEntity_2() throws Exception {
		String testName = "011_Verify_publication_search_by_Composition_Nanomaterial_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test21verifyPublicationSearchByCompositionNanomaterialEntity_3() throws Exception {
		String testName = "011_Verify_publication_search_by_Composition_Nanomaterial_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test22verifyPublicationSearchByCompositionNanomaterialEntity_4() throws Exception {
		String testName = "011_Verify_publication_search_by_Composition_Nanomaterial_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test23verifyPublicationSearchByCompositionFunctionalizingEntity_1() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test24verifyPublicationSearchByCompositionFunctionalizingEntity_2() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test25verifyPublicationSearchByCompositionFunctionalizingEntity_3() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test26verifyPublicationSearchByCompositionFunctionalizingEntity_4() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test27verifyPublicationSearchByCompositionFunctionalizingEntity_5() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test28verifyPublicationSearchByCompositionFunctionalizingEntity_6() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test29verifyPublicationSearchByCompositionFunctionalizingEntity_7() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test30verifyPublicationSearchByCompositionFunctionalizingEntity_8() throws Exception {
		String testName = "012_Verify_publication_search_by_Composition_Functionalizing_Entity";
		String testDesc = "Verify publication search by Composition Nanomaterial Entity";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test32verifyPublicationSearchByFunction_1() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test33verifyPublicationSearchByFunction_2() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
			//Test.Verify_publication_search_by_Function("imaging function");
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
	public void Test34verifyPublicationSearchByFunction_3() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
			Test.Verify_publication_search_by_Function("other");
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
	public void Test35verifyPublicationSearchByFunction_4() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test37verifyPublicationSearchByFunction_5() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function";
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test38verifyPublicationSearchByFunction_6() throws Exception {
		String testName = "013_Verify_publication_search_by_Function";
		String testDesc = "Verify publication search by Function"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.wait_For(2000);
			Test.clickLink(By.linkText("Search Publications"));
			//Test.chooseLoginOptions("Browse publically available data");
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
	public void Test39verifyPublicationSearchByKeywordAsaCurator() throws Exception {
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
	public void Test40verifyPublicationSearchByKeywordAsaResearcher() throws Exception {
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
	public void Test41verifyCuratorShouldBeAbleToReviewPendingData() throws Exception {
		String testName = "001_Verify_Curator_should_be_able_to_review_pending_data";
		String testDesc = "Verify Curator able to review pending data"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String HomePageURL = HostName + "/caNanoLab/#/";
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
	public void Test42ensureStrutsHasBeenRemovedfromManageCurationPage() throws Exception {
		String testName = "001_Ensure_Struts_has_been_removed_from_Manage_Curation_page";
		String testDesc = "Ensure Struts has been removed from Manage Curation page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/";
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
	public void Test43ensureStrutsHasBeenRemovedFromReviewByCuratorPage() throws Exception {
		String testName = "002_Ensure_Struts_has_been_removed_from_Review_By_Curator_page";
		String testDesc = "Ensure Struts has been removed from Review by Curator page and system is displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/";
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
	
	//S.N.: 101
	//Test Name: ensureStrutsHasBeenRemovedFromManageBatchDataAvailabilityPage
	@Test
	public void Test44ensureStrutsHasBeenRemovedFromManageBatchDataAvailabilityPage() throws Exception {
		String testName = "003_Ensure_Struts_has_been_removed_from_Manage_Batch_Data_Availability_page";
		String testDesc = "Ensure Struts has been removed from Manage batch data avilability page and system is displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/";
			Test.verifyUrl(homePageURL);
			Test.clickMenubarLinks("CURATION", "Manage Batch Data Availability ");
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
	
	// Remove Struts from Publication page
	
	//S.N.: 124
	//Test Name: 003_Ensure Struts has been removed from Manage Publication Page
	@Test
	public void Test45ensureStrutsHasBeenRemovedFromManagePublicationPage() throws Exception {
		String testName = "003_Ensure Struts has been removed from Manage Publication Page";
		String testDesc = "Ensure Struts has been removed from Manage Publication Search Page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/";
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
	public void Test46ensureStrutsHasBeenRemovedFromPublicationSearchPage() throws Exception {
		String testName = "001_Ensure Struts has been removed from Publication Search Page";
		String testDesc = "Ensure Struts has been removed from Publication Search Page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.verifyLogin(By.linkText("CURATION"));
			String homePageURL = HostName + "/caNanoLab/#/";
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
	public void Test47ensureStrutsHasBeenRemovedFromPublicationSubmissionPage() throws Exception {
		String testName = "001_Ensure Struts has been removed from Publication Submission Page";
		String testDesc = "Ensure Struts has been removed from Publication Submission Page and system displying new framework URL"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.clickMenubarLinks("PUBLICATIONS", "Manage Publications");
			Test.clickPageLinks("Create a New Publication", "Create Publication");
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
	public void Test48ensureStrutsHasBeenRemovedFromSearchForSamplesByPublicationPage() throws Exception {
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
	public void Test49verifyThatACuratorCanRemoveSampleFromPublication() throws Exception {
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
	public void Test50verifyThatAResearcherAbleToRemoveSampleFromPublicationForPublicationThatUserHaveDeleteAccess() throws Exception {
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
	public void Test31verifyThatAResearcherCanEditPublicationForPublicationThatUserHasUpdateOrEditAccess() throws Exception {
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
	public void Test36verifyThatACuratorCanEditPublication() throws Exception {
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
	
	@After
	  public void tearDown() throws Exception {
		Test.shutdown();
	  }
}

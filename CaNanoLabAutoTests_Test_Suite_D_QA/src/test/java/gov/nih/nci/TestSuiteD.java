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

public class TestSuiteD {
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
	
	public TestSuiteD(){
		BaseTestMethods.appRelease = "cananoLab v2.1";
		BaseTestMethods.releaseDesc = "caNanoLab v2.1 is refactored using AngularJS as the Front-end framework and JAVA REST services as the middle-tier";
	}	
	
	//S.N.: 151
	//Test Name: 002_Researcher User should be able to add sample criteria with sample name and equals filter to the Advanced sample search
	@Test
	public void Test1researcherUserShouldBeAbleToAddSampleCriteriaWithSampleNameAndEqualsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "002_Researcher User should be able to add sample criteria with sample name and equals filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add sample criteria with sample name and equals filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
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
	
	//S.N.: 152
	//Test Name: 003_Researcher User should be able to perform Advanced sample search by sample criteria with point of contact name and contains filter
	@Test
	public void Test2researcherUserShouldBeAbleToPefromAdvancedSampleSearchBySampleCriteriaWithPointOfContactNameAndContainsFilter() throws Exception {
		String testName = "003_Researcher User should be able to perform Advanced sample search by sample criteria with point of contact name and contains filter";
		String testDesc = "Ensure Researcher User should be able to perform Advanced sample search by sample criteria with point of contact name and contains filter"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("point of contact name"/*getSampleORPOCName*/, 
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
	
	//S.N.: 153
	//Test Name: 004_Researcher User should be able to perform Advanced sample search by sample criteria with point of contact name and equals filter
	@Test
	public void Test3researcherUserShouldBeAbleToPefromAdvancedSampleSearchBySampleCriteriaWithPointOfContactNameAndEqualsFilter() throws Exception {
		String testName = "004_Researcher User should be able to perform Advanced sample search by sample criteria with point of contact name and equals filter";
		String testDesc = "Ensure Researcher User should be able to perform Advanced sample search by sample criteria with point of contact name and equals filter"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("point of contact name"/*getSampleORPOCName*/, 
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
	
	//S.N.: 154
	//Test Name: 005_Ensure Researcher user able to Reset sample criteria from advanced sample search page
	@Test
	public void Test4ensureResearcherUserAbleToResetSampleCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "005_Ensure Researcher user able to Reset sample criteria from advanced sample search page";
		String testDesc = "Ensure Researcher user able to Reset sample criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("point of contact name"/*getSampleORPOCName*/, 
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
	
	//S.N.: 155
	//Test Name: 006_Ensure Researcher user able to Remove sample criteria from advanced sample search page
	@Test
	public void Test5ensureResearcherUserAbleToRemoveSampleCriteriaFromAdvancedSampleSearchPage() throws Exception {
		String testName = "006_Ensure Researcher user able to Remove sample criteria from advanced sample search page";
		String testDesc = "Ensure Researcher user able to Remove sample criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
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
	
	//S.N.: 156
	//Test Name: 007_Ensure Researcher user able to Edit sample criteria from advanced sample search page
	@Test
	public void Test6ensureResearcherUserAbleToEditSampleCriteriaFromAdvancedSampleSearchPage() throws Exception {
		String testName = "007_Ensure Researcher user able to Edit sample criteria from advanced sample search page";
		String testDesc = "Ensure Researcher user able to Edit sample criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
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
	
	//Composition Criteria - Curator
	
	//S.N.: 157
	//Test Name: 001_Curator User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name contains filter to the Advanced sample search
	@Test
	public void Test12curatorUserShouldBeAbleToAddCompositionCriteriaWithNanomaterialEntityAndBiopolymerAndChemicalNameContainsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "001_Curator User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name contains filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name contains filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL-23"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/, 
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "nanomaterial entity"/*getCompositionCriteriaFilterA*/, 
					                    "dendrimer"/*getCompositionCriteriaFilterB*/, 
					                    "contains"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Diaminobutane"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
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
	
	//S.N.: 158
	//Test Name: 002_Curator User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name equals filter to the Advanced sample search
	@Test
	public void Test13curatorUserShouldBeAbleToAddCompositionCriteriaWithNanomaterialEntityAndBiopolymerAndChemicalNameEqualsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "002_Curator User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name equals filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name equals filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL-23"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "nanomaterial entity"/*getCompositionCriteriaFilterA*/, 
					                    "dendrimer"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Diaminobutane (DAB)"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
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
	
	//S.N.: 159
	//Test Name: 003_Curator User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name contains filter to the Advanced sample search
	@Test
	public void Test14curatorUserShouldBeAbleToAddCompositionCriteriaWithFunctionalizingEntityAndAntibodyAndChemicalNameContainsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "003_Curator User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name contains filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name contains filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL-23"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "contains"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
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
	
	//S.N.: 160
	//Test Name: 004_Curator User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name with the equals filter to the Advanced sample search
	@Test
	public void Test15curatorUserShouldBeAbleToAddCompositionCriteriaWithFunctionalizingEntityAndAntibodyAndChemicalNameEqualsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "004_Curator User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name equals filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name with the equals filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
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
	
	//S.N.: 161
	//Test Name: 005_Curator User should be able to add Composition Criteria with Function and Imaging Function filter to the Advanced sample search
	@Test
	public void Test16curatorUserShouldBeAbleToAddCompositionCriteriaWithFunctionAndImagingFunctionFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "005_Curator User should be able to add Composition Criteria with Function and Imaging Function filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add Composition Criteria with Function and Imaging Function filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "function"/*getCompositionCriteriaFilterA*/, 
					                    "imaging function"/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
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
			Test.verify_advanced_sample_search_result_function();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 162
	//Test Name: 006_Curator User should be able to add Composition Criteria with Function and Targeting Function filter to the Advanced sample search
	@Test
	public void Test17curatorUserShouldBeAbleToAddCompositionCriteriaWithFunctionAndTargetingFunctionFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "006_Curator User should be able to add Composition Criteria with Function and Targeting Function filter to the Advanced sample search";
		String testDesc = "Ensure Curator User should be able to add Composition Criteria with Function and Targeting Function filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "function"/*getCompositionCriteriaFilterA*/, 
					                    "targeting function"/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
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
			Test.verify_advanced_sample_search_result_function();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 163
	//Test Name: 007_Ensure Curator user able to Reset Composition Criteria from advanced sample search page
	@Test
	public void Test7EnsureCuratorUserAbleToResetCompositionCriteriaFromAdvancedSampleSearchPage() throws Exception {
		String testName = "007_Ensure curator user able to Reset Composition Criteria from advanced sample search page";
		String testDesc = "Ensure curator user able to Reset Composition Criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Reset"/*getCompositionCriteriaAddOrReset*/, 
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
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 164
	//Test Name: 008_Ensure Curator user able to Remove Composition Criteria from advanced sample search page
	@Test
	public void Test8ensureCuratorUserAbleToRemoveCompositionCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "008_Ensure Curator user able to Remove Composition Criteria from advanced sample search page";
		String testDesc = "Ensure Curator user able to Remove Composition Criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    "Edit"/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    "Remove"/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
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
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 165
	//Test Name: 009_Ensure Curator user able to Edit Composition Criteria from advanced sample search page
	@Test
	public void Test9ensureCuratorUserAbleToEditCompositionCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "009_Ensure Curator user able to Edit Composition Criteria from advanced sample search page";
		String testDesc = "Ensure Curator user able to Edit Composition Criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    "Edit"/*getCompositionCriteriaAEdit*/, 
					                    "nanomaterial entity"/*getCompositionCriteriaFilterAEdit*/, 
					                    "carbon nanotube"/*getCompositionCriteriaFilterBEdit*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    "Magnevist Edit Test"/*getCompositionCriteriaNameEdit*/, 
					                    "Add"/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
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
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//Composition Criteria - Researcher
	
	//S.N.: 166
	//Test Name: 001_Researcher User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name contains filter to the Advanced sample search
	@Test
	public void Test18researcherUserShouldBeAbleToAddCompositionCriteriaWithNanomaterialEntityAndBiopolymerAndChemicalNameContainsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "001_Researcher User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name contains filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name contains filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL-23"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/, 
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "nanomaterial entity"/*getCompositionCriteriaFilterA*/, 
					                    "dendrimer"/*getCompositionCriteriaFilterB*/, 
					                    "contains"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Diaminobutane"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
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
	
	//S.N.: 167
	//Test Name: 002_Researcher User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name equals filter to the Advanced sample search
	@Test
	public void Test19ResearcherUserShouldBeAbleToAddCompositionCriteriaWithNanomaterialEntityAndBiopolymerAndChemicalNameEqualsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "002_Researcher User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name equals filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add Composition Criteria with Nanomaterial Entity and Biopolymer and Chemical name equals filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL-23"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "nanomaterial entity"/*getCompositionCriteriaFilterA*/, 
					                    "dendrimer"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Diaminobutane (DAB)"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
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
	
	//S.N.: 168
	//Test Name: 003_Researcher User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name contains filter to the Advanced sample search
	@Test
	public void Test20ResearcherUserShouldBeAbleToAddCompositionCriteriaWithFunctionalizingEntityAndAntibodyAndChemicalNameContainsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "003_Researcher User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name contains filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name contains filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL-23"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "contains"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
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
	
	//S.N.: 169
	//Test Name: 004_Researcher User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name equals filter to the Advanced sample search
	@Test
	public void Test21ResearcherUserShouldBeAbleToAddCompositionCriteriaWithFunctionalizingEntityAndAntibodyAndChemicalNameEqualsFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "004_Researcher User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name equals filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add Composition Criteria with Functionalizing Entity and Antibody and Chemical name with the equals filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
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
	
	//S.N.: 170
	//Test Name: 005_Researcher User should be able to add Composition Criteria with Function and Imaging Function filter to the Advanced sample search
	@Test
	public void Test25ResearcherUserShouldBeAbleToAddCompositionCriteriaWithFunctionAndImagingFunctionFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "005_Researcher User should be able to add Composition Criteria with Function and Imaging Function filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add Composition Criteria with Function and Imaging Function filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "function"/*getCompositionCriteriaFilterA*/, 
					                    "imaging function"/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
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
			Test.verify_advanced_sample_search_result_function();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 171
	//Test Name: 006_Curator User should be able to add Composition Criteria with Function and Targeting Function filter to the Advanced sample search
	@Test
	public void Test35ResearcherUserShouldBeAbleToAddCompositionCriteriaWithFunctionAndTargetingFunctionFilterToTheAdvancedSampleSearch() throws Exception {
		String testName = "006_Researcher User should be able to add Composition Criteria with Function and Targeting Function filter to the Advanced sample search";
		String testDesc = "Ensure Researcher User should be able to add Composition Criteria with Function and Targeting Function filter to the Advanced sample search"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "function"/*getCompositionCriteriaFilterA*/, 
					                    "targeting function"/*getCompositionCriteriaFilterB*/, 
					                    ""/*getCompositionCriteriaContainsOrEqual*/, 
					                    ""/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
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
			Test.verify_advanced_sample_search_result_function();
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 172
	//Test Name: 007_Ensure Researcher user able to Reset Composition Criteria from advanced sample search page
	@Test
	public void Test10EnsureResearcherUserAbleToResetCompositionCriteriaFromAdvancedSampleSearchPage() throws Exception {
		String testName = "007_Ensure Researcher user able to Reset Composition Criteria from advanced sample search page";
		String testDesc = "Ensure Researcher user able to Reset Composition Criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Reset"/*getCompositionCriteriaAddOrReset*/, 
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
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 173
	//Test Name: 008_Ensure Researcher user able to Remove Composition Criteria from advanced sample search page
	@Test
	public void Test48ensureResearcherUserAbleToRemoveCompositionCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "008_Ensure Researcher user able to Remove Composition Criteria from advanced sample search page";
		String testDesc = "Ensure Researcher user able to Remove Composition Criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    "Edit"/*getCompositionCriteriaAEdit*/, 
					                    ""/*getCompositionCriteriaFilterAEdit*/, 
					                    ""/*getCompositionCriteriaFilterBEdit*/, 
					                    ""/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    ""/*getCompositionCriteriaNameEdit*/, 
					                    "Remove"/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
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
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 174
	//Test Name: 009_Ensure Researcher user able to Edit Composition Criteria from advanced sample search page
	@Test
	public void Test11ensureResearcherUserAbleToEditCompositionCriteriaFromAdavancedSampleSearchPage() throws Exception {
		String testName = "009_Ensure Researcher user able to Edit Composition Criteria from advanced sample search page";
		String testDesc = "Ensure Researcher user able to Edit Composition Criteria from advanced sample search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search("sample name"/*getSampleORPOCName*/, 
										"contains"/*getSampCriContainsOrEqual*/, 
										"NCL"/*getSampleCriteriaName*/, 
										"Add"/*getSampCriAddOrReset*/,  
										""/*getSampleCriteriaEdit*/, 
										""/*getSampleORPOCNameEdit*/, 
										""/*getSampCriContainsOrEqualEdit*/, 
										""/*getSampleCriteriaNameEdit*/, 
										""/*getSampCriAddOrResetOrRemoveEdit*/, 
					                    "functionalizing entity"/*getCompositionCriteriaFilterA*/, 
					                    "small molecule"/*getCompositionCriteriaFilterB*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqual*/, 
					                    "Magnevist"/*getCompositionCriteriaName*/, 
					                    "Add"/*getCompositionCriteriaAddOrReset*/, 
					                    "Edit"/*getCompositionCriteriaAEdit*/, 
					                    "nanomaterial entity"/*getCompositionCriteriaFilterAEdit*/, 
					                    "carbon nanotube"/*getCompositionCriteriaFilterBEdit*/, 
					                    "equals"/*getCompositionCriteriaContainsOrEqualEdit*/, 
					                    "Magnevist Edit Test"/*getCompositionCriteriaNameEdit*/, 
					                    "Add"/*getCompositionCriteriaAddOrResetOrRemoveEdit*/, 
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
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// Characterization Criteria - Curator
	
	//S.N.: 175
	//Test Name: 01_Ensure Curator user able to search with phyico chemical characterization filters from advanced search page
	@Test
	public void Test22ensureCuratorUserAbleToSearchWithPhyicoChemicalCharacterizationFiltersFromAdvancedSearchPage() throws Exception {
		String testName = "01_Ensure Curator user able to search with phyico chemical characterization filters from advanced search page";
		String testDesc = "Ensure Curator user able to search with phyico chemical characterization filters from advanced search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
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
					                    "physico-chemical characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "size"/*getCharacterizationCriteriaFilterB*/, 
					                    "size"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "1"/*getCharacterizationCriteriaFilterE*/, 
					                    "microm"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
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
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("physico-chemical characterization", " size", " size");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 176
	//Test Name: 02_Ensure Curator user able to search with in vitro characterization filters from advanced search page
	@Test
	public void Test23ensureCuratorUserAbleToSearchWithInVitroCharacterizationFiltersFromAdvancedSearchPage() throws Exception {
		String testName = "02_Ensure Curator user able to search with in vitro characterization filters from advanced search page";
		String testDesc = "Ensure Curator user able to search with in vitro characterization filters from advanced search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
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
					                    "in vitro characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "blood contact"/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
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
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("in vitro characterization", "", "");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 177
	//Test Name: 03_Ensure Curator user able to search with in vivo characterization filters from advanced search page
	@Test
	public void Test24EnsureCuratorUserAbleToSearchWithInVivoCharacterizationFiltersFromAdvancedSearchPage() throws Exception {
		String testName = "03_Ensure Curator user able to search with in vivo characterization filters from advanced search page";
		String testDesc = "Ensure Curator user able to search with in vivo characterization filters from advanced search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
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
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[Cmax]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
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
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("in vivo characterization", " pharmacokinetics", " Cmax");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 178
	//Test Name: 04_Ensure Curator user able to edit characterization advanced search query
	@Test
	public void Test26EnsureCuratorUserAbleToEditCharacterizationAdvnacedSearchQuery() throws Exception {
		String testName = "04_Ensure Curator user able to edit characterization advanced search query";
		String testDesc = "Ensure Curator user able to edit characterization advanced search query"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
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
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[AUC]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "h x ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    "Edit"/*getCharacterizationCriteriaEdit*/, 
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterAEdit*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterBEdit*/, 
					                    "[Cmax]"/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ">"/*getCharacterizationCriteriaFilterDEdit*/, 
					                    "1000"/*getCharacterizationCriteriaFilterEEdit*/, 
					                    "ng/mL"/*getCharacterizationCriteriaFilterFEdit*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("in vivo characterization", " pharmacokinetics", " Cmax");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 179
	//Test Name: 05_Ensure Curator user able to Remove characterization advanced search query
	@Test
	public void Test27ensureCuratorUserAbleToRemoveCharacterizationAdvancedSearchQuery() throws Exception {
		String testName = "05_Ensure Curator user able to Remove characterization advanced search query";
		String testDesc = "Ensure Curator user able to Remove characterization advanced search query"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
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
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[AUC]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "h x ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    "Edit"/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    "Remove"/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 180
	//Test Name: 06_Ensure Curator user able to Reset characterization advanced search query
	@Test
	public void Test28EnsureCuratorUserAbleToResetCharacterizationAdvancedSearchQuery() throws Exception {
		String testName = "06_Ensure Curator user able to Reset characterization advanced search query";
		String testDesc = "Ensure Curator user able to Reset characterization advanced search query"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
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
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[AUC]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "h x ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Reset"/*getCharacterizationCriteriaAddOrReset*/, 
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
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// Characterization Criteria - Researcher
	
	//S.N.: 181
	//Test Name: 01_Ensure Researcher user able to search with phyico chemical characterization filters from advanced search page
	@Test
	public void Test29ensureResearcherrUserAbleToSearchWithPhyicoChemicalCharacterizationFiltersFromAdvancedSearchPage() throws Exception {
		String testName = "01_Ensure Researcher user able to search with phyico chemical characterization filters from advanced search page";
		String testDesc = "Ensure Researcher user able to search with phyico chemical characterization filters from advanced search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
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
					                    "physico-chemical characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "size"/*getCharacterizationCriteriaFilterB*/, 
					                    "size"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "1"/*getCharacterizationCriteriaFilterE*/, 
					                    "microm"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
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
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("physico-chemical characterization", " size", " size");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 182
	//Test Name: 02_Ensure Researcher user able to search with in vitro characterization filters from advanced search page
	@Test
	public void Test30ensureResearcherUserAbleToSearchWithInVitroCharacterizationFiltersFromAdvancedSearchPage() throws Exception {
		String testName = "02_Ensure Researcher user able to search with in vitro characterization filters from advanced search page";
		String testDesc = "Ensure Researcher user able to search with in vitro characterization filters from advanced search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
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
					                    "in vitro characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "blood contact"/*getCharacterizationCriteriaFilterB*/, 
					                    ""/*getCharacterizationCriteriaFilterC*/, 
					                    ""/*getCharacterizationCriteriaFilterD*/, 
					                    ""/*getCharacterizationCriteriaFilterE*/, 
					                    ""/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
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
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("in vitro characterization", "", "");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 183
	//Test Name: 03_Ensure Researcher user able to search with in vivo characterization filters from advanced search page
	@Test
	public void Test31EnsureResearcherUserAbleToSearchWithInVivoCharacterizationFiltersFromAdvancedSearchPage() throws Exception {
		String testName = "03_Ensure Researcher user able to search with in vivo characterization filters from advanced search page";
		String testDesc = "Ensure Researcher user able to search with in vivo characterization filters from advanced search page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
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
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[Cmax]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
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
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("in vivo characterization", " pharmacokinetics", " Cmax");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 184
	//Test Name: 04_Ensure Researcher user able to edit characterization advanced search query
	@Test
	public void Test32EnsureResearcherUserAbleToEditCharacterizationAdvnacedSearchQuery() throws Exception {
		String testName = "04_Ensure Researcher user able to edit characterization advanced search query";
		String testDesc = "Ensure Researcher user able to edit characterization advanced search query"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
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
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[AUC]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "h x ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    "Edit"/*getCharacterizationCriteriaEdit*/, 
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterAEdit*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterBEdit*/, 
					                    "[Cmax]"/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ">"/*getCharacterizationCriteriaFilterDEdit*/, 
					                    "1000"/*getCharacterizationCriteriaFilterEEdit*/, 
					                    "ng/mL"/*getCharacterizationCriteriaFilterFEdit*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			Test.verify_advanced_sample_search_result_characterization("in vivo characterization", " pharmacokinetics", " Cmax");
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 185
	//Test Name: 05_Ensure Researcher user able to Remove characterization advanced search query
	@Test
	public void Test33ensureResearcherUserAbleToRemoveCharacterizationAdvancedSearchQuery() throws Exception {
		String testName = "05_Ensure Researcher user able to Remove characterization advanced search query";
		String testDesc = "Ensure Researcher user able to Remove characterization advanced search query"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
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
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[AUC]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "h x ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Add"/*getCharacterizationCriteriaAddOrReset*/, 
					                    "Edit"/*getCharacterizationCriteriaEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterAEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterBEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterCEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterDEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterEEdit*/, 
					                    ""/*getCharacterizationCriteriaFilterFEdit*/, 
					                    "Remove"/*getCharacterizationCriteriaAddOrResetOrRemove*/, 
					                    "Search"/*getSearchOrReset*/, 
					                    ""/*verifySearchSampleValYesOrNo*/, 
					                    ""/*getContainsOrEqual*/, 
					                    ""/*selectSearchSampleValYesOrNo*/);
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 180
	//Test Name: 06_Ensure Researcher user able to Reset characterization advanced search query
	@Test
	public void Test34EnsureResearcherUserAbleToResetCharacterizationAdvancedSearchQuery() throws Exception {
		String testName = "06_Ensure Researcher user able to Reset characterization advanced search query";
		String testDesc = "Ensure Researcher user able to Reset characterization advanced search query"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_samples_page();
			Test.navigate_to_advanced_sample_search_page();
			Test.advanced_sample_search(""/*getSampleORPOCName*/, 
										""/*getSampCriContainsOrEqual*/, 
										""/*getSampleCriteriaName*/, 
										""/*getSampCriAddOrReset*/,  
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
					                    "in vivo characterization"/*getCharacterizationCriteriaFilterA*/, 
					                    "pharmacokinetics"/*getCharacterizationCriteriaFilterB*/, 
					                    "[AUC]"/*getCharacterizationCriteriaFilterC*/, 
					                    ">"/*getCharacterizationCriteriaFilterD*/, 
					                    "5000"/*getCharacterizationCriteriaFilterE*/, 
					                    "h x ng/mL"/*getCharacterizationCriteriaFilterF*/, 
					                    "Reset"/*getCharacterizationCriteriaAddOrReset*/, 
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
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// My Workspace
	// My Samples
	
	//S.N.: 181
	//Test Name: 019_Ensure Curator user able to delete a sample from my workspace
	@Test
	public void Test36ensureCuratorUserAbleToDeleteASampleFromMyWorksapce() throws Exception {
		String testName = "019_Ensure Curator user able to delete a sample from my workspace";
		String testDesc = "Ensure curator user should be able to view my workspace page and delete a sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.delete_my_workspace_samples("Test Submit Sample As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 182
	//Test Name: 020_Ensure Researcher user able to delete a sample from my workspace
	@Test
	public void Test37ensureResearcherUserAbleToDeleteASampleFromMyWorksapce() throws Exception {
		String testName = "020_Ensure Researcher user able to delete a sample from my workspace";
		String testDesc = "Ensure Researcher user should be able to view my workspace page and delete a sample"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.delete_my_workspace_samples("Test Submit Sample As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 183
	//Test Name: 021_Ensure Curator user able to edit a sample from my worksapce
	@Test
	public void Test58ensureCuratorUserAbleToEditASampleFromMyWorksapce() throws Exception {
		String testName = "021_Ensure Curator user able to edit a sample from my worksapce";
		String testDesc = "Ensure Curator user able to edit a sample from my worksapce"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.edit_my_workspace_samples("Test Submit Sample As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 184
	//Test Name: 022_Ensure Researcher user able to edit a sample from my workspace
	@Test
	public void Test38ensureResearcherUserAbleToEditASampleFromMyWorksapce() throws Exception {
		String testName = "022_Ensure researcher user able to edit a sample from my worksapce";
		String testDesc = "Ensure researcher user able to edit a sample from my worksapce"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.edit_my_workspace_samples("Test Submit Sample As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 185
	//Test Name: 023_Ensure Curator user able to view a sample from my worksapce
	@Test
	public void Test39ensureCuratorUserAbleToViewASampleFromMyWorksapce() throws Exception {
		String testName = "021_Ensure Curator user able to view a sample from my worksapce";
		String testDesc = "Ensure Curator user able to view a sample from my worksapce"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.view_my_workspace_samples("Test Submit Sample As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 186
	//Test Name: 024_Ensure Researcher user able to view a sample from my worksapce
	@Test
	public void Test40ensureResearcherUserAbleToViewASampleFromMyWorksapce() throws Exception {
		String testName = "024_Ensure Researcher user able to view a sample from my worksapce";
		String testDesc = "Ensure Researcher user able to view a sample from my worksapce"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.view_my_workspace_samples("Test Submit Sample As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	// My Workspace
	// My Protocols
	
	//S.N.: 187
	//Test Name: 025_Ensure Curator user able to delete a Protocol from my workspace
	@Test
	public void Test41ensureCuratorUserAbleToDeleteAProtocolFromMyWorkspace() throws Exception {
		String testName = "025_Ensure Curator user able to delete a Protocol from my workspace";
		String testDesc = "Ensure Curator user able to view my workspace and also able to delete a Protocol from my workspace protocol list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.delete_my_workspace_protocols("Test Submit Protocl As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 188
	//Test Name: 026_Ensure Researcher user able to delete a Protocol from my workspace
	@Test
	public void Test42ensureResearcherUserAbleToDeleteAProtocolFromMyWorkspace() throws Exception {
		String testName = "025_Ensure Researcher user able to delete a Protocol from my workspace";
		String testDesc = "Ensure Researcher user able to view my workspace and also able to delete a Protocol from my workspace protocol list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.delete_my_workspace_protocols("Test Submit Protocl As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 187
	//Test Name: 027_Ensure Curator user able to edit a Protocol from my workspace
	@Test
	public void Test43ensureCuratorUserAbleToEditAProtocolFromMyWorkspace() throws Exception {
		String testName = "027_Ensure Curator user able to edit a Protocol from my workspace";
		String testDesc = "Ensure Curator user able view my workspace and also able to Edit a Protocol from my workspace protocol list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.edit_my_workspace_protocol("Test Submit Protocl As");
			Test.switchToChildBrowser();
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 188
	//Test Name: 028_Ensure Researcher user able to edit a Protocol from my workspace
	@Test
	public void Test44ensureResearcherUserAbleToEditAProtocolFromMyWorkspace() throws Exception {
		String testName = "028_Ensure Researcher user able to edit a Protocol from my workspace";
		String testDesc = "Ensure Researcher user able to view my workspace and also able to Edit a Protocol from my workspace protocol list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.edit_my_workspace_protocol("Test Submit Protocl As");
			Test.switchToChildBrowser();
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 189
	//Test Name: 029_Ensure Curator user able to view a Protocol from my workspace
	@Test
	public void Test45ensureCuratorUserAbleToViewAProtocolFromMyWorkspace() throws Exception {
		String testName = "029_Ensure Curator user able to view a Protocol from my workspace";
		String testDesc = "Ensure Curator user able to view my workspace and also able to View a Protocol from my workspace protocol list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			//Test.wait_until_my_publications_table_data_load();
			Test.view_my_workspace_protocol("Test Submit Protocl As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 190
	//Test Name: 030_Ensure Researcher user able to view a Protocol from my workspace
	@Test
	public void Test46ensureResearcherUserAbleToViewAProtocolFromMyWorkspace() throws Exception {
		String testName = "030_Ensure Researcher user able to view a Protocol from my workspace";
		String testDesc = "Ensure Researcher user able to view my workspace and also able to View a Protocol from my workspace protocol list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			//Test.wait_until_my_publications_table_data_load();
			Test.view_my_workspace_protocol("Test Submit Protocl As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 191
	//Test Name: 031_Ensure Curator user able to Delete a Publication from my workspace
	@Test
	public void Test47ensureCuratorUserAbleToDeleteAPublicationFromMyWorkspace() throws Exception {
		String testName = "031_Ensure Curator user able to Delete a Publication from my workspace";
		String testDesc = "Ensure Curator user able to view my workspace and also able to Delete a Publication from my workspace Publications list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.delete_my_workspace_publication("Test Submit Publication As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 192
	//Test Name: 032_Ensure Researcher user able to Delete a Publication from my workspace
	@Test
	public void Test49ensureResearcherUserAbleToDeleteAPublicationFromMyWorkspace() throws Exception {
		String testName = "032_Ensure Researcher user able to Delete a Publication from my workspace";
		String testDesc = "Ensure Researcher user able to view my workspace and also able to Delete a Publication from my workspace Publications list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.delete_my_workspace_publication("Test Submit Publication As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 193
	//Test Name: 033_Ensure Curator user able to Edit a Publication from my workspace
	@Test
	public void Test50ensureCuratorUserAbleToEditAPublicationFromMyWorkspace() throws Exception {
		String testName = "033_Ensure Curator user able to Edit a Publication from my workspace";
		String testDesc = "Ensure Curator user able to view my workspace and also able to Edit a Publication from my workspace Publications list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.edit_my_workspace_publication("Test Submit Publication As");
			Test.wait_For(1000);
			logger.info("---------------End of Test "+ testName + "--------------------------------------");
			logger.info("Test "+testName+ " Passed");
			Test.setupAfterSuite();
		}catch(Exception e){
			logger.error("Test "+testName+" failed. Error: -"+e.getMessage());
			logger.info("---------------End of Test "+ testName + "--------------------------------------");	
			Test.setupAfterSuite();
		}			
	}
	
	//S.N.: 194
	//Test Name: 034_Ensure Researcher user able to Edit a Publication from my workspace
	@Test
	public void Test51ensureResearcherUserAbleToEditAPublicationFromMyWorkspace() throws Exception {
		String testName = "034_Ensure Researcher user able to Edit a Publication from my workspace";
		String testDesc = "Ensure Researcher user able to view my workspace and also able to Edit a Publication from my workspace Publications list"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(researcherUserName, researcherPassword, "pass");
			Test.navigate_to_myworksapce_page();
			Test.wait_until_my_samples_table_data_load();
			Test.wait_until_my_protocols_table_data_load();
			Test.wait_until_my_publications_table_data_load();
			Test.edit_my_workspace_publication("Test Submit Publication As");
			Test.wait_For(1000);
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
	
	//S.N.: 195
	//Test Name: 001_Ensure Curator user able to add a Sample to the Favorites list
	@Test
	public void Test52EnsureCuratorUserAbleToAddASampleToTheFavoritesList() throws Exception {
		String testName = "001_Ensure Curator user able to add a Sample to the Favorites list";
		String testDesc = "Ensure curator user able to add a Sample from sample search results page to the my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Test Submit Sample As", "", "", "", "", "", "", "", "search");
			Test.wait_until_search_samples_table_data_load();
			Test.sample_add_to_favorites("Test Submit Sample", "yes", "");
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
	
	//S.N.: 196
	//Test Name: 002_Ensure Curator user able to add a Protocol to the Favorites list
	@Test
	public void Test53EnsureCuratorUserAbleToAddAProtocolToTheFavoritesList() throws Exception {
		String testName = "002_Ensure Curator user able to add a Protocol to the Favorites list";
		String testDesc = "Ensure curator user able to add a Protocol from Protocol search results page to the my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_protocol_all();
			Test.navigate_to_protocol_search_page();
			Test.protocol_search("", "contains", "Test Submit Protocol", "", "", "", "", "search", "yes");
			Test.protocol_add_to_favorites("Test Submit Protocol", "yes", "");
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
	
	//S.N.: 197
	//Test Name: 003_Ensure Curator user able to add a Publication to the Favorites list
	@Test
	public void Test54EnsureCuratorUserAbleToAddAPublicationToTheFavoritesList() throws Exception {
		String testName = "003_Ensure Curator user able to add a Publication to the Favorites list";
		String testDesc = "Ensure curator user able to add a Publication from Publication search results page to the my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
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
	//View
	
	//S.N.: 198
	//Test Name: 001_Ensure Curator user able to add a Sample to the Favorites list and view the added sample from my favorites page
	@Test
	public void Test55EnsureCuratorUserAbleToAddASampleToTheFavoritesListAndViewTheAddedSampleFromMyFavoritesPage() throws Exception {
		String testName = "001_Ensure Curator user able to add a Sample to the Favorites list and view the added sample from my favorites page";
		String testDesc = "Ensure Curator user able to add a Sample to the Favorites list and view the added sample from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_sample_all();
			Test.navigate_to_sample_search_page();
			Test.samples_search_simple("", "contains", "Test Submit Sample As", "", "", "", "", "", "", "", "search");
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
	
	//S.N.: 199
	//Test Name: 002_Ensure Curator user able to add a Protocol to the Favorites list and view the added protocol from my favorites page
	@Test
	public void Test56ensureCuratorUserAbleToAddAProtocolToTheFavoritesListAndViewTheAddedProtocolFromMyFavoritesPage() throws Exception {
		String testName = "002_Ensure Curator user able to add a Protocol to the Favorites list and view the added protocol from my favorites page";
		String testDesc = "Ensure Curator user able to add a Protocol to the Favorites list and view the added protocol from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
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
	
	//S.N.: 200
	//Test Name: 003_Ensure Curator user able to add a publication to the Favorites list and view the added publication from my favorites page
	@Test
	public void Test57EnsureCuratorUserAbleToAddAPublicationToTheFavoritesListAndViewTheAddedPublicationFromMyFavoritesPage() throws Exception {
		String testName = "003_Ensure Curator user able to add a publication to the Favorites list and view the added publication from my favorites page";
		String testDesc = "Ensure Curator user able to add a publication to the Favorites list and view the added publication from my favorites page"; 
		try{
			logger.info("---------------Begin Test case: " + testName + "--------------");
			Test.setupBeforeSuite(seleniumBrowser , seleniumUrl, testName, testDesc);
			Test.launchSite();
			Test.login(curatorUserName, curatorPassword, "pass");
			Test.remove_my_favorites_publication_all();
			Test.navigate_to_publication_search_page();
			Test.publication_search("", "", "", "", "contains", "Test Submit publication", "", "", "", "", "", "", "", "search", "yes");
			Test.publication_add_to_favorites("Test Submit Publication", "yes", "view");
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

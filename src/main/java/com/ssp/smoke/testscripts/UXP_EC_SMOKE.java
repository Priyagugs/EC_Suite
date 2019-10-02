package com.ssp.smoke.testscripts;

import java.io.IOException;
//import java.sql.ResultSet;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.uxp_pages.*;
import com.ssp.wj_pages.BusinessDetails;
import com.ssp.wj_pages.ConfirmationOfPayment;
import com.ssp.wj_pages.Contacts;
import com.ssp.wj_pages.GeneralInformation;
import com.ssp.wj_pages.ImportantStatements;
import com.ssp.wj_pages.InterestedParties;
import com.ssp.wj_pages.Payment;
import com.ssp.wj_pages.PaymentDetails;
import com.ssp.wj_pages.PaymentInformation;
import com.ssp.wj_pages.People;
import com.ssp.wj_pages.PreviousLoss;
import com.ssp.wj_pages.PublicLiability;
import com.ssp.wj_pages.YourBusiness;
import com.ssp.wj_pages.YourDetails;
import com.ssp.wj_pages.YourQuote;

import com.ssp.Ec_pages.Contact;

import com.ssp.Ec_pages.CustomerDashboard;


import com.ssp.Ec_pages.LoginDetails;
import com.ssp.Ec_pages.MyDashboardDetails;



import com.ssp.Ec_pages.SearchDashboard;



//import org.testng.annotations.BeforeTest;
import com.ssp.support.*;
import com.ssp.utils.*;

@Listeners(EmailReport.class)
public class UXP_EC_SMOKE extends BaseTest {

	private String webSite;
	public String monthlywebSite;
	private HashMap<String, String> customerDetails2 = new HashMap<String, String>();

	@BeforeMethod
	public void init(ITestContext context) throws IOException {
		webSite = System.getProperty("webSite") != null ? System.getProperty("webSite")
				: context.getCurrentXmlTest().getParameter("webSite");
		monthlywebSite = System.getProperty("monthlywebSite") != null ? System.getProperty("monthlywebSite")
				: context.getCurrentXmlTest().getParameter("monthlywebSite");
	}

	public ExtentTest addTestInfo(String testCaseId, String testDesc) {

		String browserwithos = null;
		String test = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getName();

		String browsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("browser");
		String browserversion = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("browser_version");
		String os = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("os").substring(0,
				1);
		String osversion = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("os_version");
		browserwithos = os + osversion + "_" + browsername + browserversion;

		return Log.testCaseInfo(testCaseId + " [" + test + "]",
				testCaseId + " - " + testDesc + " [" + browserwithos + "]", test);
	}

	public HashMap<String, String> getTestData(String testcaseId) {
		String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
		String className = "UXP_EC_Demo_" + env;
		return DataUtils.testDatabyID(testcaseId, className);
	}

	@Test(description = "DLG - EC Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM012345(String browser) throws Exception {

		String tcId = "PM012345";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
	//	String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
	   Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			LoginDetails ld=new LoginDetails(driver, webSite,extentedReport);
			ld.openURL();
			ld.EnterUsername(testData.get("username"), extentedReport);
			ld.EnterPassword(testData.get("password"), extentedReport);
			
			
			MyDashboardDetails md=ld.clickLogin(extentedReport);
			
			
			SearchDashboard sd=md.Click_Task(testData.get("Task"), extentedReport);
			sd.Click_Create_NewCustomer(extentedReport);
			sd.SelectCustomerType(testData.get("CustomerType"), extentedReport);
			sd.EnterCorp_BusinessName(testData.get("CorpBusinessName"), extentedReport);
			sd.SeletAddressType(testData.get("AddressType"), extentedReport);
			sd.EnterCorp_BuildingNo(testData.get("BuildingNo"),extentedReport);
			sd.SelectCountry(testData.get("Country"), extentedReport);
			sd.EnterCorp_PostCode(testData.get("CorpPostCode"), extentedReport);
			sd.Click_btnCorpFindAddress(extentedReport);
			sd.EnterCorp_BusinessphoneNo(testData.get("BusinessphoneNo"), extentedReport);
			sd.EnterCorp_BusinessHomeNo(testData.get("BusinessHomeNo"), extentedReport);
			sd.EnterCorp_BusinessMobileNo(testData.get("BusinessMobileNo"), extentedReport);
			sd.EnterCorp_BusinessEmail(testData.get("BusinessEmail"), extentedReport);
			sd.EnterCorp_TradingAs(testData.get("TradingAs"), extentedReport);
			sd.SelectContactSuffix(testData.get("ContactSuffix"), extentedReport);
			sd.SelectAuthorized_ContactTitle(testData.get("Authorized_ContactTitle"), extentedReport);
			sd.EnterCorp_ContactFirstName(testData.get("ContactFirstName"), extentedReport);
			sd.EnterCorp_ContactLastName(testData.get("ContactLastName"), extentedReport);
			sd.SelectContactSuffix(testData.get("ContactSuffix"), extentedReport);
			sd.EnterCorp_ContactHomeNo(testData.get("ContactHomeNo"), extentedReport);
			sd.EnterCorp_ContactWorkNo(testData.get("ContactWorkNo"), extentedReport);
			sd.EnterCorp_ContactMobileNo(testData.get("ContactMobileNo"), extentedReport);
			sd.EnterCorp_ContactEmail(testData.get("ContactEmail"), extentedReport);
			sd.SelectbtnCorpMarketing_Preference(testData.get("CorpMarketing_Preference"), extentedReport);
			sd.SelectbtnCommunication_Preference(testData.get("Communication_Preference"), extentedReport);
	
	//	sd.Click_btnCorpSave(extentedReport);
			
			
			
			Contact c=sd.Click_btnCorpSave(extentedReport);
			c.Click_ManageAuthorizeContactDetails(extentedReport);
			c.Click_EditAddress(extentedReport);
			c.enterHouseNo(testData.get("HouseNo"), extentedReport);
			c.enterPostCode(testData.get("PostCode"), extentedReport);
			c.Click_FindAddress(extentedReport);
			c.Click_Save(extentedReport);
			c.SelectEditContactType(testData.get("ContactType"), extentedReport);
			c.Click_EditPhoneEmail(extentedReport);
			c.enterEditEmail(extentedReport);
			c.Click_EditPhoneSave(extentedReport);
			c.Click_Close(extentedReport);
			
			c.Click_CollapsePreferences(extentedReport);
			c.Click_EditPreferencesDetails(extentedReport);
			//c.SelectEditCorrespondence_Preference(btnEditCorrespondence_Preference, extentedReport);
		//	c.selectImpairmentConsiderations(impairmentconsideration, extentedReport);
		//	c.SelectEditMarketing_Preference(btnHeatingList, extentedReport);
		//	c.Click_SaveEditPreferences(extentedReport);
			
			Log.testCaseResult(extentedReport);
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		}
		finally {
			Log.endTestCase(extentedReport);
			//driver.quit();
		}
	}	



@Test(description = "DLG - EC Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
public void PM023(String browser) throws Exception {

	String tcId = "PM023";
	final WebDriver driver = WebDriverFactory.get(browser);
	HashMap<String, String> testData = getTestData(tcId);
//	String securityKey = testData.get("SecurityKey");
	String description = testData.get("Description");
   Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
	ExtentTest extentedReport = addTestInfo(tcId, description);
	try {
		// Navigate to Login Page
		LoginDetails ld=new LoginDetails(driver, webSite,extentedReport);
		ld.openURL();
		ld.EnterUsername(testData.get("username"), extentedReport);
		ld.EnterPassword(testData.get("password"), extentedReport);
		
		
		MyDashboardDetails md=ld.clickLogin(extentedReport);
		
		
		SearchDashboard sd=md.Click_Task(testData.get("Task"), extentedReport);
		sd.EnterlastName(testData.get("SearchLastName"), extentedReport);
		sd.Click_Search(extentedReport);
		sd.Click_Search(extentedReport);
		sd.Click_ContactsResults(extentedReport);
		sd.Click_AuthorizedContact(extentedReport);
		
		CustomerDashboard cd	=sd.Click_PolicytoVerify(extentedReport);

		
		Log.testCaseResult(extentedReport);
	}
	catch (Exception e) {
		Log.exception(e, driver, extentedReport);
	}
	finally {
		Log.endTestCase(extentedReport);
		//driver.quit();
	}
}

@Test(description = "DLG - EC Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
public void Complaint(String browser) throws Exception {

	String tcId = "Complaint";
	final WebDriver driver = WebDriverFactory.get(browser);
	HashMap<String, String> testData = getTestData(tcId);
//	String securityKey = testData.get("SecurityKey");
	String description = testData.get("Description");
   Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
	ExtentTest extentedReport = addTestInfo(tcId, description);
	try {
		// Navigate to Login Page
		LoginDetails ld = new LoginDetails(driver, webSite,extentedReport);
		ld.openURL();
		ld.EnterUsername(testData.get("username"), extentedReport);
		ld.EnterPassword(testData.get("password"), extentedReport);
		
		
		MyDashboardDetails md = ld.clickLogin(extentedReport);
		
		SearchDashboard sd = md.Click_Task(testData.get("Task"), extentedReport);
		sd.EnterlastName(testData.get("SearchLastName"), extentedReport);
		sd.Click_Search(extentedReport);
		sd.Click_Search(extentedReport);
		sd.Click_ContactsResults(extentedReport);
		sd.Click_AuthorizedContact(extentedReport);
		
		CustomerDashboard cd = sd.Click_PolicytoVerify(extentedReport);
		cd.addNewComplaint(testData.get("ComplaintReportedDate"), 
						   testData.get("TCFCategory"), 
						   testData.get("TCFDescription"), 
						   testData.get("ComplaintAgainst"), 
						   testData.get("ComplaintReason"), 
						   testData.get("ComplaintType"), 
						   testData.get("RespondWithin"), 
						   testData.get("Claim"), 
						   testData.get("Intermediary"), 
						   testData.get("Description"), extentedReport);
		
		cd.addNewComplaintFinal(testData.get("ComplaintConfirmStatus"), 
								testData.get("ComplaintConfirmReason"), extentedReport);

		Log.testCaseResult(extentedReport);
	}
	catch (Exception e) {
		Log.exception(e, driver, extentedReport);
	}
	finally {
		Log.endTestCase(extentedReport);
		//driver.quit();
	}
}

@Test(description = "DLG - EC Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
public void Notes(String browser) throws Exception {

	String tcId = "Notes";
	final WebDriver driver = WebDriverFactory.get(browser);
	HashMap<String, String> testData = getTestData(tcId);
//	String securityKey = testData.get("SecurityKey");
	String description = testData.get("Description");
   Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
	ExtentTest extentedReport = addTestInfo(tcId, description);
	try {
		// Navigate to Login Page
		LoginDetails ld = new LoginDetails(driver, webSite,extentedReport);
		ld.openURL();
		ld.EnterUsername(testData.get("username"), extentedReport);
		ld.EnterPassword(testData.get("password"), extentedReport);
		
		
		MyDashboardDetails md = ld.clickLogin(extentedReport);
		
		SearchDashboard sd = md.Click_Task(testData.get("Task"), extentedReport);
		sd.EnterlastName(testData.get("SearchLastName"), extentedReport);
		sd.Click_Search(extentedReport);
		sd.Click_Search(extentedReport);
		sd.Click_ContactsResults(extentedReport);
		sd.Click_AuthorizedContact(extentedReport);
		
		CustomerDashboard cd = sd.Click_PolicytoVerify(extentedReport);
		cd.addNotes(testData.get("NoteTitle"), 
					testData.get("NoteDescription"), extentedReport);
		
		Log.testCaseResult(extentedReport);
	}
	catch (Exception e) {
		Log.exception(e, driver, extentedReport);
	}
	finally {
		Log.endTestCase(extentedReport);
		//driver.quit();
	}
}

@Test(description = "DLG - EC Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
public void Finance(String browser) throws Exception {

	String tcId = "Finance";
	final WebDriver driver = WebDriverFactory.get(browser);
	HashMap<String, String> testData = getTestData(tcId);
//	String securityKey = testData.get("SecurityKey");
	String description = testData.get("Description");
   Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
	ExtentTest extentedReport = addTestInfo(tcId, description);
	try {
		// Navigate to Login Page
		LoginDetails ld = new LoginDetails(driver, webSite,extentedReport);
		ld.openURL();
		ld.EnterUsername(testData.get("username"), extentedReport);
		ld.EnterPassword(testData.get("password"), extentedReport);
		
		
		MyDashboardDetails md = ld.clickLogin(extentedReport);
		
		SearchDashboard sd = md.Click_Task(testData.get("Task"), extentedReport);
		sd.EnterlastName(testData.get("SearchLastName"), extentedReport);
		sd.Click_Search(extentedReport);
		sd.Click_Search(extentedReport);
		sd.Click_ContactsResults(extentedReport);
		sd.Click_AuthorizedContact(extentedReport);
		
		CustomerDashboard cd = sd.Click_PolicytoVerify(extentedReport);
		cd.Finance(extentedReport);
		
		Log.testCaseResult(extentedReport);
	}
	catch (Exception e) {
		Log.exception(e, driver, extentedReport);
	}
	finally {
		Log.endTestCase(extentedReport);
		//driver.quit();
	}
}

@Test(description = "DLG - EC Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
public void ECJourney(String browser) throws Exception {

	String tcId = "ECJourney";
	final WebDriver driver = WebDriverFactory.get(browser);
	HashMap<String, String> testData = getTestData(tcId);
//	String securityKey = testData.get("SecurityKey");
	String description = testData.get("Description");
   Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
	ExtentTest extentedReport = addTestInfo(tcId, description);
	try {
		// Navigate to Login Page
		LoginDetails ld=new LoginDetails(driver, webSite,extentedReport);
		ld.openURL();
		ld.EnterUsername(testData.get("username"), extentedReport);
		ld.EnterPassword(testData.get("password"), extentedReport);
		
		
		MyDashboardDetails md=ld.clickLogin(extentedReport);
		
		
		SearchDashboard sd=md.Click_Task(testData.get("Task"), extentedReport);
		sd.Click_Create_NewCustomer(extentedReport);
		sd.SelectCustomerType(testData.get("CustomerType"), extentedReport);
		sd.EnterCorp_BusinessName(testData.get("CorpBusinessName"), extentedReport);
		sd.SeletAddressType(testData.get("AddressType"), extentedReport);
		sd.EnterCorp_BuildingNo(testData.get("BuildingNo"),extentedReport);
		sd.SelectCountry(testData.get("Country"), extentedReport);
		sd.EnterCorp_PostCode(testData.get("CorpPostCode"), extentedReport);
		sd.Click_btnCorpFindAddress(extentedReport);
		sd.EnterCorp_BusinessphoneNo(testData.get("BusinessphoneNo"), extentedReport);
		sd.EnterCorp_BusinessHomeNo(testData.get("BusinessHomeNo"), extentedReport);
		sd.EnterCorp_BusinessMobileNo(testData.get("BusinessMobileNo"), extentedReport);
		sd.EnterCorp_BusinessEmail(testData.get("BusinessEmail"), extentedReport);
		sd.EnterCorp_TradingAs(testData.get("TradingAs"), extentedReport);
		sd.SelectContactSuffix(testData.get("ContactSuffix"), extentedReport);
		sd.SelectAuthorized_ContactTitle(testData.get("Authorized_ContactTitle"), extentedReport);
		sd.EnterCorp_ContactFirstName(testData.get("ContactFirstName"), extentedReport);
		sd.EnterCorp_ContactLastName(testData.get("ContactLastName"), extentedReport);
		sd.SelectContactSuffix(testData.get("ContactSuffix"), extentedReport);
		sd.EnterCorp_ContactHomeNo(testData.get("ContactHomeNo"), extentedReport);
		sd.EnterCorp_ContactWorkNo(testData.get("ContactWorkNo"), extentedReport);
		sd.EnterCorp_ContactMobileNo(testData.get("ContactMobileNo"), extentedReport);
		sd.EnterCorp_ContactEmail(testData.get("ContactEmail"), extentedReport);
		sd.SelectbtnCorpMarketing_Preference(testData.get("CorpMarketing_Preference"), extentedReport);
		sd.SelectbtnCommunication_Preference(testData.get("Communication_Preference"), extentedReport);

//	sd.Click_btnCorpSave(extentedReport);
		
		
		
		Contact c=sd.Click_btnCorpSave(extentedReport);
		
		
		BusinessDetails bd= c.Click_NewQuote(extentedReport);
		
		bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
		bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
		bd.BusinessRunNext(extentedReport);
		bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
		bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
		

	   GeneralInformation gi= bd.clickContinue(extentedReport);
	//	gi.enterEmail(extentedReport);
		gi.clickFindAddress(extentedReport);
		gi.ClickSelectYourAddress(extentedReport);
		
		YourBusiness yb = gi.clickNext(extentedReport);
		yb.AnotherBusinessOccupation(testData.get("OtherBusinessOccupation"), extentedReport);
		yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
		yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
		yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
		yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
		
		People p = yb.clickNext(extentedReport);
		
		PublicLiability pl = p.clickNext(extentedReport);
		pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
		pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
		
		ImportantStatements is = pl.clickNext(extentedReport);
		is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);
		
		PreviousLoss pl2 = is.clickNext(extentedReport);
		pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
		
		YourQuote yq = pl2.clickGetQuote(extentedReport);
		yq.SelectlumpsumPremium(extentedReport);
		
		
		YourDetails yd = yq.ClickNext(extentedReport);
		
		InterestedParties ip = yd.clickNext(extentedReport);
		ip.LikeToAddInterestedParties(testData.get("LikeToAddInterestedParties"), extentedReport);
		
		Contacts cnts = ip.Click_Next(extentedReport);
		cnts.AnyoneMakeChanges(testData.get("AnyoneMakeChanges1"), extentedReport);	
		
		
		Payment p1 = cnts.Click_CheckOut(extentedReport);
		p1.selectConditions(testData.get("TermsAndConditions"), extentedReport);
		
		PaymentInformation pi = p1.Click_Next(extentedReport);
		pi.selectCardBelongTo(testData.get("CardBelongTo"), extentedReport);
		pi.selectPermission(testData.get("Permission"), extentedReport);
		pi.enterCardHolderName(testData.get("CardHolderName"), extentedReport);
		pi.selectBilling(testData.get("Billing"), extentedReport);
		
		
		PaymentDetails pd = pi.Click_Next(extentedReport);
		pd.enterCardNo(testData.get("CardNo"), extentedReport);
		pd.enterExpiryMonth(testData.get("ExpiryMonth"), extentedReport);
		pd.enterExpiryYear(testData.get("ExpiryYear"), extentedReport);
		pd.enterSecurityCode(testData.get("SecurityCode"), extentedReport);
		
		ConfirmationOfPayment cop = pd.Click_MakePayment(extentedReport);
		cop.printPolicyNumber(extentedReport);
		Log.testCaseResult(extentedReport);
	}
	catch (Exception e) {
		Log.exception(e, driver, extentedReport);
	}
	finally {
		Log.endTestCase(extentedReport);
		//driver.quit();
	}
}
}

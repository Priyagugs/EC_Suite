package com.ssp.smoke.testscripts;

import java.io.IOException;
//import java.sql.ResultSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.uxp_pages.*;
import com.ssp.wj_pages.BusinessDetails;
import com.ssp.wj_pages.BusinessPremises;
import com.ssp.wj_pages.BusinessProperty;
import com.ssp.wj_pages.ConfirmationOfPayment;
import com.ssp.wj_pages.Contacts;
import com.ssp.wj_pages.DeclinedPage;
import com.ssp.wj_pages.EmployersLiability;
import com.ssp.wj_pages.GeneralInformation;
import com.ssp.wj_pages.ImportantStatements;
import com.ssp.wj_pages.InterestedParties;
import com.ssp.wj_pages.MonthlyPaymentDetails;
import com.ssp.wj_pages.Partners;
import com.ssp.wj_pages.Payment;
import com.ssp.wj_pages.PaymentDetails;
import com.ssp.wj_pages.PaymentInformation;
import com.ssp.wj_pages.People;
import com.ssp.wj_pages.PreviousLoss;
import com.ssp.wj_pages.PropertyAwayFromThePremises;
import com.ssp.wj_pages.PublicLiability;
import com.ssp.wj_pages.SeasonalStockIncrease;
import com.ssp.wj_pages.SecurityCheck;
import com.ssp.wj_pages.TreatmentsProvidedByYourBusiness;
import com.ssp.wj_pages.YourBusiness;
import com.ssp.wj_pages.YourDetails;
import com.ssp.wj_pages.YourQuote;
import com.ssp.Ec_pages.LoginDetails;
import com.ssp.Ec_pages.MyDashboardDetails;
import com.ssp.Ec_pages.SearchDashboard;
//import org.testng.annotations.BeforeTest;
import com.ssp.support.*;
import com.ssp.utils.*;

@Listeners(EmailReport.class)
public class WJ_SMOKE extends BaseTest {

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
		String className = "UXP_WJ_Demo_" + env;
		return DataUtils.testDatabyID(testcaseId, className);
	}

	@Test(description = "DLG - Web Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM050496(String browser) throws Exception {

		String tcId = "PM050496";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
			
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
			yq.clickReviewConfirm(extentedReport);
			yq.selectTitle(testData.get("Title"), extentedReport);
			yq.enterConfirmEmail(extentedReport);
			yq.clickTelephoneNumber(extentedReport);
			yq.clickContinue(extentedReport);
			
			YourDetails yd = yq.Click_OK(extentedReport);
			
			InterestedParties ip = yd.clickNext(extentedReport);
			ip.LikeToAddInterestedParties(testData.get("LikeToAddInterestedParties"), extentedReport);
			
			Contacts c = ip.Click_Next(extentedReport);
			c.AnyoneMakeChanges(testData.get("AnyoneMakeChanges1"), extentedReport);
			c.CheckOutEnabled(extentedReport);
			c.AnyoneMakeChanges(testData.get("AnyoneMakeChanges2"), extentedReport);
			c.CheckOutEnabled(extentedReport);
			c.AddContact(extentedReport);
			c.enterNewContactTitle(testData.get("NewContactTitle"), extentedReport);
			c.enterNewContactFirstName(testData.get("NewContactFirstName"), extentedReport);
			c.enterNewContactLastName(testData.get("NewContactLastName"), extentedReport);
			c.enterRelationshipToBusiness(testData.get("RelationshipToBusiness"), extentedReport);
			c.Click_BtnAdd(extentedReport);
			c.BtnAddAnotherContactEnabled(extentedReport);
			c.BtnDeleteEnabled(extentedReport);
			c.CheckOutEnabled(extentedReport);
			c.Click_BtnDelete(extentedReport);
			c.CheckOutEnabled(extentedReport);
			c.Click_CheckOut(extentedReport);
			c.ErrorMsgDisplayed(extentedReport);
			c.AnyoneMakeChanges(testData.get("AnyoneMakeChanges1"), extentedReport);
			c.CheckOutEnabled(extentedReport);
						
			Payment p1 = c.Click_CheckOut(extentedReport);

			Log.testCaseResult(extentedReport);
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		}
		finally {
			Log.endTestCase(extentedReport);
			driver.quit();
		}
	}		
	
	@Test(description = "DLG - Web Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM050089_PM050498(String browser) throws Exception {

		String tcId = "PM050089_PM050498";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom2"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken2"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
			
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
			
			BusinessPremises bp = pl.clickNext2(extentedReport);
			bp.AnyBusinesspremises(testData.get("BusinessPremises"), extentedReport);
			bp.BusinessPremisesAddress(testData.get("BusinessPremisesAddress"), extentedReport);
			bp.PremisesType(testData.get("PremisesType"), extentedReport);
			bp.PremisesOccupied(testData.get("PremisesOccupied"), extentedReport);
			bp.BusinessApplies(testData.get("BusinessApplies"), extentedReport);
			bp.AnyOutbuildingCovers(testData.get("AnyOutbuildingCovers"), extentedReport);
			bp.AddBuildingCover(testData.get("BuildingCoverAmount"), extentedReport);
			bp.AddBusinessContentCover(testData.get("BusinessContentCoverAmount"), extentedReport);
			bp.BuildingType(testData.get("BuildingType"), extentedReport);
			bp.PropertyBuiltYear(testData.get("PropertyBuiltYear"), extentedReport);
			bp.Grade1Premises(testData.get("Grade1Premises"), extentedReport);
			bp.WallMaterial(testData.get("WallMaterial"), extentedReport);
			bp.RoofMaterial(testData.get("RoofMaterial"), extentedReport);
			bp.HeatingList(testData.get("HeatingList"), extentedReport);
			bp.SubsidenceCover(testData.get("SubsidenceCover"), extentedReport);
			
			PropertyAwayFromThePremises pwftp = bp.clickNext(extentedReport);
			pwftp.PropertyAwayFromPremises(testData.get("PropertyAwayFromPremises"), extentedReport);
			pwftp.MaximumTakeAwayValue(testData.get("MaximumTakeAwayValue"), extentedReport);
			pwftp.ItemMoreThanWorth2500(testData.get("ItemMoreThanWorth2500"), extentedReport);
			
			ImportantStatements is = pwftp.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			
			yq.NamedItems(extentedReport);
			yq.AddItem(extentedReport);
			yq.RequiredItemGroup(extentedReport);
			yq.RequiredItemType(extentedReport);
			yq.RequiredItemValue(extentedReport);
			yq.RequiredItemDescription(extentedReport);
			yq.selectItemGroup(testData.get("ItemGroup"), extentedReport);
			yq.selectItemType(testData.get("ItemType1"), extentedReport);
			yq.ValueOfItem(testData.get("ValueOfItem"), extentedReport);
			yq.AddItem(extentedReport);
			yq.RequiredItemDescription(extentedReport);
			yq.ItemDescription(testData.get("ItemDescription"), extentedReport);
			yq.AddItem(extentedReport);
			yq.AddItem(extentedReport);
			yq.HeadersDisplayed(extentedReport);
			yq.AddAnotherItem(extentedReport);
			yq.selectItemGroup(testData.get("ItemGroup"), extentedReport);
			yq.selectItemType(testData.get("ItemType2"), extentedReport);
			yq.ValueOfItem(testData.get("ValueOfItem"), extentedReport);
			yq.AddItem(extentedReport);
			yq.RequiredItemDescription(extentedReport);
			yq.ItemDescription(testData.get("ItemDescription"), extentedReport);
			yq.AddItem(extentedReport);
			yq.AddItem(extentedReport);
			yq.HeadersDisplayed(extentedReport);
				
			Log.testCaseResult(extentedReport);
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		}
		finally {
			Log.endTestCase(extentedReport);
			driver.quit();
		}}
	

	@Test(description = "DLG - Web Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM051635(String browser) throws Exception {

		String tcId = "PM051635";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.EmployersLiabilityCover(testData.get("EmployersLiabilityCover"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken2"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
			
			YourBusiness yb = gi.clickNext(extentedReport);
			yb.AnotherBusinessOccupation(testData.get("OtherBusinessOccupation"), extentedReport);
			yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
			yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
			yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
			yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
			
			People p = yb.clickNext(extentedReport);
			p.EmployeesInBusiness(testData.get("EmployeesInBusiness"), extentedReport);
			p.AdministrativeEmployees(testData.get("AdministrativeEmployees"), extentedReport);
			p.PremisesUsedByEmployees(testData.get("PremisesUsedByEmployees"), extentedReport);
			p.NumberOfEmployeesUsedPremises(testData.get("NumberOfEmployeesUsedPremises"), extentedReport);
			
			PublicLiability pl = p.clickNext(extentedReport);
			pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
			pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
			
			BusinessPremises bp = pl.clickNext2(extentedReport);
			bp.AnyBusinesspremises(testData.get("BusinessPremises"), extentedReport);
			bp.BusinessPremisesAddress(testData.get("BusinessPremisesAddress"), extentedReport);
			bp.PremisesType(testData.get("PremisesType"), extentedReport);
			bp.PremisesOccupied(testData.get("PremisesOccupied"), extentedReport);
			bp.BusinessApplies(testData.get("BusinessApplies"), extentedReport);
			bp.PremisesATM(testData.get("PremisesATM"), extentedReport);
			bp.AddBusinessContentCover(testData.get("BusinessContentCoverAmount"), extentedReport);
			bp.WallMaterial(testData.get("WallMaterial"), extentedReport);
			bp.RoofMaterial(testData.get("RoofMaterial"), extentedReport);
			bp.HeatingList(testData.get("HeatingList"), extentedReport);
			bp.SubsidenceCover(testData.get("SubsidenceCover"), extentedReport);
			
			PropertyAwayFromThePremises pwftp = bp.clickNext(extentedReport);
			pwftp.PropertyAwayFromPremises(testData.get("PropertyAwayFromPremises"), extentedReport);
			
			ImportantStatements is = pwftp.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			yq.clickBack(extentedReport);
			
			gi.clickNext(extentedReport);
			
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom2"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			
			yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
			yb.clickNext(extentedReport);
			
			p.QuestionNumberOfEmployeesUsedPremises(extentedReport);
			
			Log.testCaseResult(extentedReport);
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		}
		finally {
			Log.endTestCase(extentedReport);
			driver.quit();
		}}
	
	@Test(description = "DLG - Web Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM050921(String browser) throws Exception {

		String tcId = "PM050921";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterDifferentEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
			
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
			yq.clickReviewConfirm(extentedReport);
			yq.selectTitle(testData.get("Title"), extentedReport);
			yq.enterConfirmEmail(extentedReport);
			yq.clickTelephoneNumber(extentedReport);
			yq.clickContinue(extentedReport);
			
			YourDetails yd = yq.Click_OK(extentedReport);
			
			InterestedParties ip = yd.clickNext(extentedReport);
			ip.LikeToAddInterestedParties(testData.get("LikeToAddInterestedParties"), extentedReport);
			
			Contacts c = ip.Click_Next(extentedReport);
			c.AnyoneMakeChanges(testData.get("AnyoneMakeChanges1"), extentedReport);			
						
			Payment p1 = c.Click_CheckOut(extentedReport);
			p1.selectPaymentMethod(testData.get("PaymentMethod"), extentedReport);
			p1.selectConditions(testData.get("Conditions"), extentedReport);
			
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
			driver.quit();
		}
	}		
	
	@Test(description = "DLG - Web Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM051400(String browser) throws Exception {

		String tcId = "PM051400";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
			
			YourBusiness yb = gi.clickNext(extentedReport);
			yb.ChangeLink(extentedReport);
			yb.ChangeProfession(testData.get("ChangeProfession"), extentedReport);
			yb.ErrorMsgOnChangedProfession(extentedReport);
			yb.ChangeProfession(testData.get("Profession"), extentedReport);
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
			yq.clickReviewConfirm(extentedReport);
			yq.selectTitle(testData.get("Title"), extentedReport);
			yq.enterConfirmEmail(extentedReport);
			yq.clickTelephoneNumber(extentedReport);
			yq.clickContinue(extentedReport);
			
			YourDetails yd = yq.Click_OK(extentedReport);
			
			InterestedParties ip = yd.clickNext(extentedReport);
			ip.LikeToAddInterestedParties(testData.get("LikeToAddInterestedParties"), extentedReport);
			
			Contacts c = ip.Click_Next(extentedReport);
			c.AnyoneMakeChanges(testData.get("AnyoneMakeChanges1"), extentedReport);			
						
			Payment p1 = c.Click_CheckOut(extentedReport);
			p1.selectPaymentMethod(testData.get("PaymentMethod"), extentedReport);
			p1.selectConditions(testData.get("Conditions"), extentedReport);
			
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
			driver.quit();
		}
	}	
	
	@Test(description = "DLG Under certain conditions it is possible to purchase a backdated policy", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM050091(String browser) throws Exception {

		String tcId = "PM050091";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom2"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
		    		
			YourBusiness yb = gi.clickNext(extentedReport);
			yb.AnotherBusinessOccupation(testData.get("OtherBusinessOccupation"), extentedReport);
			yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
			yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
			yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
			yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
			
			People p = yb.clickNext(extentedReport);
			p.BusinessEmployees(testData.get("EmployeesInBusiness"), extentedReport);
			
			PublicLiability pl = p.clickNext(extentedReport);
			pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
			pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
			
			ImportantStatements is = pl.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);	
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			yq.SelectlumpsumPremium(extentedReport);
			yq.Click_Next(extentedReport);
			//yq.clickReviewConfirm(extentedReport);
			yq.selectTitle(testData.get("Title"), extentedReport);
			yq.enterConfirmEmail(extentedReport);
			yq.clickTelephoneNumber(extentedReport);
			
			yq.clickContinue(extentedReport);
			
			YourDetails yd = yq.Click_OK(extentedReport);
			 yd.enterCoverStartDate(testData.get("coverStartDate"), extentedReport);
            yd.ClickNextForSamePage(extentedReport);
            yd.VerifyDateBeforeTodayValidation(extentedReport);

			Log.testCaseResult(extentedReport);
		} // try 
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} // catch
		finally {
			Log.endTestCase(extentedReport);
		//driver.quit();
		}
	}		
	
	@Test(description = "Home question not applicable", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM052578(String browser) throws Exception {


		String tcId = "PM052578";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken2"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken3"), extentedReport);
			
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
		    gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
		    
			
			YourBusiness yb = gi.clickNext(extentedReport);
			yb.AnotherBusinessOccupation(testData.get("OtherBusinessOccupation"), extentedReport);
			yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
			yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
			yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
			yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
			
			People p = yb.clickNext(extentedReport);
			p.BusinessEmployees(testData.get("EmployeesInBusiness"), extentedReport);
			
			PublicLiability pl = p.clickNext(extentedReport);
			pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
			pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
			
			TreatmentsProvidedByYourBusiness Tr=pl.clickNext_TreatmentsPage(extentedReport);
			Tr.DoYouProvideAnyTreatmentsExceptTheseOnes(testData.get("doYouProvideAnyTreatmentsExceptTheseOnes"), extentedReport);
			Tr.DoYouHaveAdequateQualifications(testData.get("doYouHaveAdequateQualifications"), extentedReport);
			
			
			BusinessPremises bp=Tr.Click_Next(extentedReport);
			bp.AnyBusinesspremises(testData.get("BusinessPremises"), extentedReport);
			bp.BusinessPremisesAddress(testData.get("BusinessPremisesAddress"), extentedReport);
			bp.PremisesType(testData.get("PremisesType"), extentedReport);
			bp.PremisesOccupied(testData.get("PremisesOccupied"), extentedReport);
	       bp.BusinessApplies(testData.get("BusinessApplies"), extentedReport);
	       bp.AnyOutbuildingCovers(testData.get("AnyOutbuildingCovers"), extentedReport);
	       bp.AddBuildingCover(testData.get("BuildingCoverAmount"), extentedReport);
			bp.AddBusinessContentCover(testData.get("BusinessContentCoverAmount"), extentedReport);
			bp.AddMainBuildingHousholdContents(testData.get("MainBuildingHousholdContents"), extentedReport);
			bp.AddMainBuildingYourStock(testData.get("MainBuildingYourStock"), extentedReport);
			bp.BuildingType(testData.get("BuildingType"), extentedReport);
			bp.DoYouHaveItemMoreThan2500£(testData.get("ItemMoreThanWorth2500"), extentedReport);
			bp.PropertyBuiltYear(testData.get("PropertyBuiltYear"), extentedReport);
			bp.Grade1Premises(testData.get("Grade1Premises"), extentedReport);
			bp.WallMaterial(testData.get("WallMaterial"), extentedReport);
			bp.RoofMaterial(testData.get("RoofMaterial"), extentedReport);
			bp.HeatingList(testData.get("HeatingList"), extentedReport);
			bp.SelectSecurityFeatures(testData.get("SecurityFeatures"), extentedReport);
			bp.SubsidenceCover(testData.get("SubsidenceCover"), extentedReport);
			
			
			PropertyAwayFromThePremises pa = bp.clickNext(extentedReport);
			pa.PropertyAwayFromPremises(testData.get("PropertyAwayFromPremises"), extentedReport);
			pa.DoYouLikeToInsurePersonalBelongigs(testData.get("LiketoInsurePersonalbelongigns"), extentedReport);
			pa.DoYouLikeToInsureYourStock(testData.get("Liketoinsureyourstock"), extentedReport);
			pa.DoYouLikeToInsureYourStockInTransit(testData.get("LikeToInsureYourStockInTransit"), extentedReport);
				
		
		
			ImportantStatements is = pa.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);
			
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			yq.clickReviewConfirm(extentedReport);
			yq.selectTitle(testData.get("Title"), extentedReport);
			yq.enterConfirmEmail(extentedReport);
			yq.clickTelephoneNumber(extentedReport);
			yq.clickContinue(extentedReport);
			
			YourDetails yd = yq.Click_OK(extentedReport);
			
			InterestedParties ip = yd.clickNext(extentedReport);
			ip.LikeToAddInterestedParties(testData.get("LikeToAddInterestedParties"), extentedReport);
			
			Contacts c = ip.Click_Next(extentedReport);
			c.AnyoneMakeChanges(testData.get("AnyoneMakeChanges1"), extentedReport);
			
			SeasonalStockIncrease ss=c.Click_Next(extentedReport);
			ss.SelectFirstMonthChoice(testData.get("firstMonthChoice"), extentedReport);
			ss.SelectSecondMonthChoice(testData.get("secondMonthChoice"), extentedReport);
		 
			Payment pyt=ss.click_GoToCheckOut(extentedReport);
		
			
			GeneralInformation gi1 = pyt.Click_YourBusinessBreadcrumb(extentedReport);
			YourBusiness yb1 = gi.clickNext(extentedReport);
			
			
			yb1.BusinesRunFrom(testData.get("RunYourBusinessFrom2"), extentedReport);
			yb1.BusinesRunFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			yb1.Click_Yes_Warning_Message(extentedReport);
			yb1.WhereYourBusinessWork(testData.get("BusinessWorkFrom1"), extentedReport);
		
			
			People p2 = yb1.clickNext(extentedReport);
			
			PublicLiability pl3 = p2.clickNext(extentedReport);
			
			TreatmentsProvidedByYourBusiness Tr1=pl3.clickNext_TreatmentsPage(extentedReport);
			
			BusinessProperty bpr=Tr1.Click_Next_BusinessProperty(extentedReport);
			bpr.VerifyLabelLiketoInsureYourBelongings(extentedReport);
			
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
	
	@Test(description = "DLG UXP Issue - Treatment Field validation not clearing as expected in Chrome", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM049959(String browser) throws Exception {

		String tcId = "PM049959";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom2"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken2"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken3"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken4"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken5"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken6"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken7"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken8"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
		    
			
			YourBusiness yb = gi.clickNext(extentedReport);
			yb.AnotherBusinessOccupation(testData.get("OtherBusinessOccupation"), extentedReport);
			yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
			yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
			yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
			yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
			
			People p = yb.clickNext(extentedReport);
			p.BusinessEmployees(testData.get("EmployeesInBusiness"), extentedReport);
			
			PublicLiability pl = p.clickNext(extentedReport);
			pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
			pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
			
			TreatmentsProvidedByYourBusiness Tr=pl.clickNext_TreatmentsPage(extentedReport);
			Tr.DoYouProvideAnyTreatmentsExceptTheseOnes(testData.get("doYouProvideAnyTreatmentsExceptTheseOnes"), extentedReport);
			Tr.DoYouHaveAdequateQualifications(testData.get("doYouHaveAdequateQualifications"), extentedReport);
			Tr.ClickNext_SamePage(extentedReport);
			Tr.VerifyErrorProvideAnotherTreatment(extentedReport);
			Tr.ClickAddTreatment(extentedReport);
			Tr.selectTreatment(testData.get("TreatmentType"), extentedReport);
			Tr.ClickAddTreatmentOnSelectTreatmentPage(extentedReport);
			Tr.VerifyTreatmentAdded(extentedReport);
			Tr.VerifyValidationafterAddingTreatment(extentedReport);
			
			
			BusinessPremises bp=Tr.Click_Next(extentedReport);
			
           
			
			Log.testCaseResult(extentedReport);
		} // try 
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} // catch
		finally {
			Log.endTestCase(extentedReport);
			driver.quit();
		}
	}		
	
	@Test(description = "DLG A cover section is auto-included when property away from premises is selected under certain conditions", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM050647(String browser) throws Exception {

		String tcId = "PM050647";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken2"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
		    
			
			YourBusiness yb = gi.clickNext(extentedReport);
			yb.AnotherBusinessOccupation(testData.get("OtherBusinessOccupation"), extentedReport);
			yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
			yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
			yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
			yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
			
			People p = yb.clickNext(extentedReport);
			p.BusinessEmployees(testData.get("EmployeesInBusiness"), extentedReport);
			
			PublicLiability pl = p.clickNext(extentedReport);
			pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
			pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
			
			TreatmentsProvidedByYourBusiness Tr=pl.clickNext_TreatmentsPage(extentedReport);
			Tr.DoYouProvideAnyTreatmentsExceptTheseOnes(testData.get("doYouProvideAnyTreatmentsExceptTheseOnes"), extentedReport);
			Tr.DoYouHaveAdequateQualifications(testData.get("doYouHaveAdequateQualifications"), extentedReport);
			
			
			BusinessPremises bp=Tr.Click_Next(extentedReport);
			bp.AnyBusinesspremises(testData.get("BusinessPremises"), extentedReport);
			bp.BusinessPremisesAddress(testData.get("BusinessPremisesAddress"), extentedReport);
			bp.PremisesType(testData.get("PremisesType"), extentedReport);
			bp.PremisesOccupied(testData.get("PremisesOccupied"), extentedReport);
           bp.BusinessApplies(testData.get("BusinessApplies"), extentedReport);
           bp.AnyOutbuildingCovers(testData.get("AnyOutbuildingCovers"), extentedReport);
           bp.AddBuildingCover(testData.get("BuildingCoverAmount"), extentedReport);
			bp.AddBusinessContentCover(testData.get("BusinessContentCoverAmount"), extentedReport);
			bp.BuildingType(testData.get("BuildingType"), extentedReport);
			bp.PropertyBuiltYear(testData.get("PropertyBuiltYear"), extentedReport);
			bp.Grade1Premises(testData.get("Grade1Premises"), extentedReport);
			bp.WallMaterial(testData.get("WallMaterial"), extentedReport);
			bp.RoofMaterial(testData.get("RoofMaterial"), extentedReport);
			bp.HeatingList(testData.get("HeatingList"), extentedReport);
			bp.SubsidenceCover(testData.get("SubsidenceCover"), extentedReport);
			
			
			PropertyAwayFromThePremises pa = bp.clickNext(extentedReport);
			pa.PropertyAwayFromPremises(testData.get("PropertyAwayFromPremises"), extentedReport);
		
			ImportantStatements is = pa.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);
			
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			yq.EnterBusinessToolsandEquipments(testData.get("BusinessToolsandEquipments"), extentedReport);
			yq.AddBusinessToolsandEquipments(extentedReport);
			yq.VerifyCoverAutoIncluded(extentedReport);
			
			Log.testCaseResult(extentedReport);
		} // try 
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} // catch
		finally {
			Log.endTestCase(extentedReport);
			driver.quit();
		}
	}	
	

	@Test(description = "Error message is displayed in UXP after removing cover sections from the quote screens.", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM051419(String browser) throws Exception {


		String tcId = "PM051419";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken2"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken3"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken4"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken5"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
		    gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
		    
			
			YourBusiness yb = gi.clickNext(extentedReport);
			yb.AnotherBusinessOccupation(testData.get("OtherBusinessOccupation"), extentedReport);
			yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
			yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
			yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
			yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
			
			People p = yb.clickNext(extentedReport);
			p.BusinessEmployees(testData.get("EmployeesInBusiness"), extentedReport);
			
			PublicLiability pl = p.clickNext(extentedReport);
			pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
			pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
			
			TreatmentsProvidedByYourBusiness Tr=pl.clickNext_TreatmentsPage(extentedReport);
			Tr.DoYouProvideAnyTreatmentsExceptTheseOnes(testData.get("doYouProvideAnyTreatmentsExceptTheseOnes"), extentedReport);
			Tr.DoYouHaveAdequateQualifications(testData.get("doYouHaveAdequateQualifications"), extentedReport);
			
			
			BusinessPremises bp=Tr.Click_Next(extentedReport);
			bp.AnyBusinesspremises(testData.get("BusinessPremises"), extentedReport);
			bp.BusinessPremisesAddress(testData.get("BusinessPremisesAddress"), extentedReport);
			bp.PremisesType(testData.get("PremisesType"), extentedReport);
			bp.PremisesOccupied(testData.get("PremisesOccupied"), extentedReport);
           bp.BusinessApplies(testData.get("BusinessApplies"), extentedReport);
           bp.AnyOutbuildingCovers(testData.get("AnyOutbuildingCovers"), extentedReport);
           bp.AddBuildingCover(testData.get("BuildingCoverAmount"), extentedReport);
			bp.AddBusinessContentCover(testData.get("BusinessContentCoverAmount"), extentedReport);
			bp.AddMainBuildingHousholdContents(testData.get("MainBuildingHousholdContents"), extentedReport);
			bp.AddMainBuildingYourStock(testData.get("MainBuildingYourStock"), extentedReport);
			bp.AddOutstandingBuildingCover(testData.get("OutbuildingsBuildingCover"), extentedReport);
			bp.AddOutbuilidngsBusinessContents(testData.get("OutbuilidngsBusinessContents"), extentedReport);
			bp.AddOutbuildingsYourStock(testData.get("OutbuildingsYourStock"), extentedReport);
			bp.AddOutbuildingsHousholdContents(testData.get("OutbuildingsHousholdContents"), extentedReport);
			bp.DoYouHaveItemMoreThan2500£(testData.get("ItemMoreThanWorth2500"), extentedReport);
			bp.ClickAddItemMoreThan2500£(extentedReport);
			bp.SelectTypeofIem(testData.get("TypeOfItem"), extentedReport);
			bp.EnterValueOfItem(testData.get("ValueOfItem"), extentedReport);
			bp.EnterItemDescription(testData.get("ItemDescription"), extentedReport);
			bp.KeptNamedItemAt(testData.get("KeptNamedItemAt"), extentedReport);
			bp.AddNamedItems(extentedReport);
			bp.BuildingType(testData.get("BuildingType"), extentedReport);
			bp.PropertyBuiltYear(testData.get("PropertyBuiltYear"), extentedReport);
			bp.Grade1Premises(testData.get("Grade1Premises"), extentedReport);
			bp.WallMaterial(testData.get("WallMaterial"), extentedReport);
			bp.RoofMaterial(testData.get("RoofMaterial"), extentedReport);
			bp.HeatingList(testData.get("HeatingList"), extentedReport);
			bp.SelectSecurityFeatures(testData.get("SecurityFeatures"), extentedReport);
			
			bp.SelectOutbuildingsHeatingList(testData.get("OutbuildingsHeatingList"), extentedReport);
			bp.SubsidenceCover(testData.get("SubsidenceCover"), extentedReport);
			
			
			PropertyAwayFromThePremises pa = bp.clickNext(extentedReport);
			pa.PropertyAwayFromPremises(testData.get("PropertyAwayFromPremises"), extentedReport);
			pa.DoYouLikeToInsurePersonalBelongigs(testData.get("LiketoInsurePersonalbelongigns"), extentedReport);
			pa.DoYouLikeToInsureYourStock(testData.get("Liketoinsureyourstock"), extentedReport);
			pa.DoYouLikeToInsureYourStockInTransit(testData.get("LikeToInsureYourStockInTransit"), extentedReport);
				
		
		
			ImportantStatements is = pa.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);
			
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			
			GeneralInformation gi1 = yq.ClickGoBackandEdiMyQuote(extentedReport);
			YourBusiness yb1 = gi1.clickNext(extentedReport);
			People p1 = yb1.clickNext(extentedReport);
			PublicLiability pl1 = p1.clickNext(extentedReport);
			TreatmentsProvidedByYourBusiness Tr1=pl1.clickNext_TreatmentsPage(extentedReport);
			BusinessPremises bp1=Tr1.Click_Next(extentedReport);
			bp1.AnyOutbuildingCovers(testData.get("AnyOutbuildingCovers1"), extentedReport);
			bp1.ClickRemoveBuildingCover(extentedReport);
			bp1.ClickRemoveBusinessContentsCover(extentedReport);
			bp1.ClickRemoveYourStockCover(extentedReport);
			bp1.ClickRemoveHousholdContentsCover(extentedReport);
			bp1.clickNextForSamePage(extentedReport);
			bp1.VerifyBuildingHasAmountForContentsValidationMessage(extentedReport);
			bp1.AddBusinessContentCover(testData.get("BusinessContentCoverAmount"), extentedReport);
			
			PropertyAwayFromThePremises pa1 = bp.clickNext(extentedReport);
			
			ImportantStatements is1 = pa.clickNext(extentedReport);
			
			PreviousLoss pl21 = is.clickNext(extentedReport);
			
			YourQuote yq1 = pl2.clickGetQuote(extentedReport);
			yq1.VerifyReviewConfirmDisplayed(extentedReport);
			
			Log.testCaseResult(extentedReport);
		} 
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} 
		finally {
			Log.endTestCase(extentedReport);
		driver.quit();
		}
	}	
	
@Test(description = "DLG - Web Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void BAndBQuoteAndBuy(String browser) throws Exception {

		String tcId = "BAndBQuoteAndBuy";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
			
			YourBusiness yb = gi.clickNext(extentedReport);

			yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
			yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
			yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
			
			People p = yb.clickNext(extentedReport);
			
			PublicLiability pl = p.clickNext(extentedReport);
			pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
			pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
			
			BusinessPremises bp = pl.clickNext2(extentedReport);
			bp.BusinessPremisesAddress(testData.get("BusinessPremisesAddress"), extentedReport);
			bp.AnyOtherActivities(testData.get("AnyOtherActivities"), extentedReport);
			bp.AlcoholLicensedAtPremises(testData.get("AlcoholLicensedAtPremises"), extentedReport);
			bp.BusinessApplies(testData.get("BusinessApplies"), extentedReport);
			bp.PremisesATM(testData.get("PremisesATM"), extentedReport);
			bp.AnyOutbuildingCovers(testData.get("AnyOutbuildingCovers"), extentedReport);
			bp.AddBusinessContentCoverAmount(testData.get("BusinessContentCoverAmount"), extentedReport);
			bp.BuildingUsedFor(testData.get("BuildingUsedFor"), extentedReport);
			bp.BedroomsNumber(testData.get("BedroomsNumber"), extentedReport);
			bp.SelfCateringFacilities(testData.get("SelfCateringFacilities"), extentedReport);
			bp.Grade1Premises(testData.get("Grade1Premises"), extentedReport); 			
			bp.WallMaterial(testData.get("WallMaterial"), extentedReport);
			bp.RoofMaterial(testData.get("RoofMaterial"), extentedReport);
			bp.HeatingList(testData.get("HeatingList"), extentedReport);
			bp.SubsidenceCover(testData.get("SubsidenceCover"), extentedReport);
			
			PropertyAwayFromThePremises pa = bp.clickNext(extentedReport);
			pa.PropertyAwayFromPremises(testData.get("PropertyAwayFromPremises"), extentedReport);
			
			ImportantStatements is = pa.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			yq.clickReviewConfirm(extentedReport);
			yq.selectTitle(testData.get("Title"), extentedReport);
			yq.enterConfirmEmail(extentedReport);
			yq.clickTelephoneNumber(extentedReport);
			yq.clickContinue(extentedReport);
			
			YourDetails yd = yq.Click_OK(extentedReport);
			
			InterestedParties ip = yd.clickNext(extentedReport);
			ip.LikeToAddInterestedParties(testData.get("LikeToAddInterestedParties"), extentedReport);
			
			Contacts c = ip.Click_Next(extentedReport);
			c.AnyoneMakeChanges(testData.get("AnyoneMakeChanges1"), extentedReport);
						
			Payment p1 = c.Click_CheckOut(extentedReport);
			p1.selectPaymentMethod(testData.get("PaymentMethod"), extentedReport);
			p1.AcceptMonthlyCondition(extentedReport);
			p1.selectConditions(testData.get("Conditions"), extentedReport);
			
			MonthlyPaymentDetails mpd = p1.Click_Next2(extentedReport);
			mpd.SameAccountName(testData.get("SameAccountName"), extentedReport);
			mpd.SortCode(testData.get("SortCode"), extentedReport);
			mpd.AccountNumber(testData.get("AccountNumber"), extentedReport);
			mpd.InstallmentDayOfMonth(testData.get("InstallmentDayOfMonth"), extentedReport);
			
			PaymentInformation pi = mpd.Click_Next(extentedReport);
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
			driver.quit();
		}
	}	
	
	@Test(description = "DLG - Web Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void HAndBQuoteAndBuy(String browser) throws Exception {

		String tcId = "HAndBQuoteAndBuy";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom2"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
		    		
			YourBusiness yb = gi.clickNext(extentedReport);
			yb.AnotherBusinessOccupation(testData.get("OtherBusinessOccupation"), extentedReport);
			yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
			yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
			yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
			yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
			
			People p = yb.clickNext(extentedReport);
			p.BusinessEmployees(testData.get("EmployeesInBusiness"), extentedReport);
			
			PublicLiability pl = p.clickNext(extentedReport);
			pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
			pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
			
			ImportantStatements is = pl.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);		
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			yq.clickReviewConfirm(extentedReport);
			yq.selectTitle(testData.get("Title"), extentedReport);
			yq.enterConfirmEmail(extentedReport);
			yq.clickTelephoneNumber(extentedReport);
			
			yq.clickContinue(extentedReport);
			
			YourDetails yd = yq.Click_OK(extentedReport);
			
			InterestedParties ip = yd.clickNext(extentedReport);
			ip.LikeToAddInterestedParties(testData.get("LikeToAddInterestedParties"), extentedReport);
			
			Contacts c = ip.Click_Next(extentedReport);
			c.AnyoneMakeChanges(testData.get("AnyoneMakeChanges1"), extentedReport);			
						
			Payment p1 = c.Click_CheckOut(extentedReport);
			p1.selectPaymentMethod(testData.get("PaymentMethod"), extentedReport);
			p1.selectConditions(testData.get("Conditions"), extentedReport);
			
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
		} // try 
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} // catch
		finally {
			Log.endTestCase(extentedReport);
		driver.quit();
		}
	}
	
	@Test(description = "SSP EVO error when taking payments", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM052481(String browser) throws Exception {

		String tcId = "PM052481";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom2"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
		    		
			YourBusiness yb = gi.clickNext(extentedReport);
			yb.AnotherBusinessOccupation(testData.get("OtherBusinessOccupation"), extentedReport);
			yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
			yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
			yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
			yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
			
			People p = yb.clickNext(extentedReport);
			p.BusinessEmployees(testData.get("EmployeesInBusiness"), extentedReport);
			
			PublicLiability pl = p.clickNext(extentedReport);
			pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
			pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
			
			ImportantStatements is = pl.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);	
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			yq.clickReviewConfirm(extentedReport);
			yq.selectTitle(testData.get("Title"), extentedReport);
			yq.enterConfirmEmail(extentedReport);
			yq.clickTelephoneNumber(extentedReport);
			
			yq.clickContinue(extentedReport);
			
			YourDetails yd = yq.Click_OK(extentedReport);
			
			InterestedParties ip = yd.clickNext(extentedReport);
			ip.LikeToAddInterestedParties(testData.get("LikeToAddInterestedParties"), extentedReport);
			
			Contacts c = ip.Click_Next(extentedReport);
			c.AnyoneMakeChanges(testData.get("AnyoneMakeChanges1"), extentedReport);			
						
			Payment p1 = c.Click_CheckOut(extentedReport);
			p1.selectPaymentMethod(testData.get("PaymentMethod"), extentedReport);
			p1.selectConditions(testData.get("Conditions"), extentedReport);
			
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
			cop.VerifyPolicyNumberDisplayed(extentedReport);
			

			Log.testCaseResult(extentedReport);
		} // try 
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} // catch
		finally {
			Log.endTestCase(extentedReport);
		driver.quit();
		}
	}
	@Test(description = "DLG - Web Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void DeclinedToQuote(String browser) throws Exception {

		String tcId = "DeclinedToQuote";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom2"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken2"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
			
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
			
			BusinessPremises bp = pl.clickNext2(extentedReport);
			bp.AnyBusinesspremises(testData.get("BusinessPremises"), extentedReport);
			bp.BusinessPremisesAddress(testData.get("BusinessPremisesAddress"), extentedReport);
			bp.PremisesType(testData.get("PremisesType"), extentedReport);
			bp.PremisesOccupied(testData.get("PremisesOccupied"), extentedReport);
			bp.BusinessApplies(testData.get("BusinessApplies"), extentedReport);
			bp.AnyOutbuildingCovers(testData.get("AnyOutbuildingCovers"), extentedReport);
			bp.AddBuildingCover(testData.get("BuildingCoverAmount"), extentedReport);
			bp.AddBusinessContentCover(testData.get("BusinessContentCoverAmount"), extentedReport);
			bp.BuildingType(testData.get("BuildingType"), extentedReport);
			bp.PropertyBuiltYear(testData.get("PropertyBuiltYear"), extentedReport);
			bp.Grade1Premises(testData.get("Grade1Premises"), extentedReport);
			bp.WallMaterial(testData.get("WallMaterial"), extentedReport);
			bp.RoofMaterial(testData.get("RoofMaterial"), extentedReport);
			bp.HeatingList(testData.get("HeatingList"), extentedReport);
			bp.SubsidenceCover(testData.get("SubsidenceCover"), extentedReport);
			
			PropertyAwayFromThePremises pwftp = bp.clickNext(extentedReport);
			pwftp.PropertyAwayFromPremises(testData.get("PropertyAwayFromPremises"), extentedReport);
			
			ImportantStatements is = pwftp.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			DeclinedPage dp = pl2.clickGetQuote2(extentedReport);
			dp.DeclinedQuote(extentedReport);
			
			gi = dp.click_GoBackAndEditMyQuote(extentedReport);
			yb = gi.clickNext(extentedReport);
			p = yb.clickNext(extentedReport);
			pl = p.clickNext(extentedReport);
			bp = pl.clickNext2(extentedReport);
			bp.Grade1Premises(testData.get("Grade1Premises2"), extentedReport);
			pwftp = bp.clickNext(extentedReport);
			is = pwftp.clickNext(extentedReport);
			pl2 = is.clickNext(extentedReport);
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			yq.PremiumAmount(extentedReport);
			
			Log.testCaseResult(extentedReport);
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		}
		finally {
			Log.endTestCase(extentedReport);
			driver.quit();
		}
	}		
	
	
	@Test(description = "Create Referral Policy - Re-edit & quote", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void ReferredToQuote(String browser) throws Exception {

		String tcId = "ReferredToQuote";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom2"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
		    		
			YourBusiness yb = gi.clickNext(extentedReport);
			yb.AnotherBusinessOccupation(testData.get("OtherBusinessOccupation"), extentedReport);
			yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
			yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
			yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
			yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
			
			People p = yb.clickNext(extentedReport);
			p.BusinessEmployees(testData.get("EmployeesInBusiness"), extentedReport);
			
			PublicLiability pl = p.clickNext(extentedReport);
			pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
			pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
			
			ImportantStatements is = pl.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);	
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			
			GeneralInformation gi1 = yq.ClickGoBackandEdiMyQuote(extentedReport);
			
			YourBusiness yb1 = gi1.clickNext(extentedReport);
			
			People p1 = yb1.clickNext(extentedReport);
			
			PublicLiability pl1 = p1.clickNext(extentedReport);
			pl1.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount1"), extentedReport);
			
			ImportantStatements is1 = pl1.clickNext(extentedReport);
			
			PreviousLoss pl3 = is1.clickNext(extentedReport);
			
			YourQuote yq1 = pl3.clickGetQuote(extentedReport);

			yq1.clickReviewConfirm(extentedReport);
			yq1.selectTitle(testData.get("Title"), extentedReport);
			yq1.enterConfirmEmail(extentedReport);
			yq1.clickTelephoneNumber(extentedReport);
			
			yq1.clickContinue(extentedReport);
			
			YourDetails yd = yq1.Click_OK(extentedReport);
			
			InterestedParties ip = yd.clickNext(extentedReport);
			ip.LikeToAddInterestedParties(testData.get("LikeToAddInterestedParties"), extentedReport);
			
			Contacts c = ip.Click_Next(extentedReport);
			c.AnyoneMakeChanges(testData.get("AnyoneMakeChanges1"), extentedReport);			
						
			Payment pyt1 = c.Click_CheckOut(extentedReport);
			pyt1.selectPaymentMethod(testData.get("PaymentMethod"), extentedReport);
			pyt1.selectConditions(testData.get("Conditions"), extentedReport);
			
			PaymentInformation pi = pyt1.Click_Next(extentedReport);
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
		} // try 
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} // catch
		finally {
			Log.endTestCase(extentedReport);
		driver.quit();
		}
	}
	
	
		
	@Test(description = "Mobile Business/Seasonal Stock Error", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM052138(String browser) throws Exception {


		String tcId = "PM052138";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken2"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken3"), extentedReport);
			
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
		    gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
		    
			
			YourBusiness yb = gi.clickNext(extentedReport);
			yb.AnotherBusinessOccupation(testData.get("OtherBusinessOccupation"), extentedReport);
			yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
			yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
			yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
			yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
			
			People p = yb.clickNext(extentedReport);
			p.BusinessEmployees(testData.get("EmployeesInBusiness"), extentedReport);
			p.PremisesUsedByEmployees(testData.get("PremisesUsedByEmployees"), extentedReport);
			
			PublicLiability pl = p.clickNext(extentedReport);
			pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
			pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
			
			TreatmentsProvidedByYourBusiness Tr=pl.clickNext_TreatmentsPage(extentedReport);
			Tr.DoYouProvideAnyTreatmentsExceptTheseOnes(testData.get("doYouProvideAnyTreatmentsExceptTheseOnes"), extentedReport);
			Tr.DoYouHaveAdequateQualifications(testData.get("doYouHaveAdequateQualifications"), extentedReport);
			
			
			BusinessPremises bp=Tr.Click_Next(extentedReport);
			bp.BusinessPremisesAddress(testData.get("BusinessPremisesAddress"), extentedReport);
			bp.PremisesType(testData.get("PremisesType"), extentedReport);
			bp.PremisesOccupied(testData.get("PremisesOccupied"), extentedReport);
	       bp.BusinessApplies(testData.get("BusinessApplies"), extentedReport);
	       bp.AnyOutbuildingCovers(testData.get("AnyOutbuildingCovers"), extentedReport);
	   //    bp.AddBuildingCover(testData.get("BuildingCoverAmount"), extentedReport);
			bp.AddBusinessContentCover(testData.get("BusinessContentCoverAmount"), extentedReport);
		//	bp.AddMainBuildingHousholdContents(testData.get("MainBuildingHousholdContents"), extentedReport);
			bp.AddMainBuildingYourStock(testData.get("MainBuildingYourStock"), extentedReport);
			bp.BuildingType(testData.get("BuildingType"), extentedReport);
		bp.SelectOthertthanFireplaceHeatingList(testData.get("HeatingListotherthanfireplace"), extentedReport);
		bp.SubsidenceCover(testData.get("SubsidenceCover"), extentedReport);
			bp.SelectTermsandConditions(testData.get("TermsAndConditions"), extentedReport);
			
			
			PropertyAwayFromThePremises pa = bp.clickNext(extentedReport);
			pa.PropertyAwayFromPremises(testData.get("PropertyAwayFromPremises"), extentedReport);
			pa.MaximumTakeAwayValue(testData.get("MaximumTakeAwayValue"), extentedReport);
		   //pa.DoYouLikeToInsurePersonalBelongigs(testData.get("LiketoInsurePersonalbelongigns"), extentedReport);
			pa.DoYouLikeToInsureYourStock(testData.get("Liketoinsureyourstock"), extentedReport);
			pa.StockMaximumTakeAwayValue(testData.get("StockMaximumTakeAwayValue"), extentedReport);
			pa.DoYouLikeToInsureYourStockInTransit(testData.get("LikeToInsureYourStockInTransit"), extentedReport);
				
		
		
			ImportantStatements is = pa.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);
			
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			yq.clickReviewConfirm(extentedReport);
			yq.selectTitle(testData.get("Title"), extentedReport);
			yq.enterConfirmEmail(extentedReport);
			yq.clickTelephoneNumber(extentedReport);
			yq.clickContinue(extentedReport);
			
			YourDetails yd = yq.Click_OK(extentedReport);
			
			InterestedParties ip = yd.clickNext(extentedReport);
			ip.LikeToAddInterestedParties(testData.get("LikeToAddInterestedParties"), extentedReport);
			
			Contacts c = ip.Click_Next(extentedReport);
			c.AnyoneMakeChanges(testData.get("AnyoneMakeChanges1"), extentedReport);
			
			SeasonalStockIncrease ss=c.Click_Next(extentedReport);
			ss.SelectFirstMonthChoice(testData.get("firstMonthChoice"), extentedReport);
			ss.SelectSecondMonthChoice(testData.get("secondMonthChoice"), extentedReport);
		 
			Payment pyt=ss.click_GoToCheckOut(extentedReport);
		
			
			GeneralInformation gi1 = pyt.Click_YourBusinessBreadcrumb(extentedReport);
			YourBusiness yb1 = gi.clickNext(extentedReport);
			
			
			yb1.BusinesRunFrom(testData.get("RunYourBusinessFrom2"), extentedReport);
			yb1.BusinesRunFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			yb1.Click_Yes_Warning_Message(extentedReport);
			yb1.WhereYourBusinessWork(testData.get("BusinessWorkFrom1"), extentedReport);
		
			
			People p2 = yb1.clickNext(extentedReport);
			
			PublicLiability pl3 = p2.clickNext(extentedReport);
			
			TreatmentsProvidedByYourBusiness Tr1=pl3.clickNext_TreatmentsPage(extentedReport);
			
			BusinessProperty bpr1=Tr1.Click_Next_BusinessProperty(extentedReport);
			bpr1.DoYouLikeToInsureTools(testData.get("PropertyAwayFromPremises"), extentedReport);
			bpr1.ToolsMaximumTakeAwayValue(testData.get("MaximumTakeAwayValue"), extentedReport);
			bpr1.DoYouLikeToInsureYourStock(testData.get("Liketoinsureyourstock"), extentedReport);
			bpr1.StockMaximumTakeAwayValue(testData.get("StockMaximumTakeAwayValue"), extentedReport);
			bpr1.DoYouLikeToInsureYourStockInTransit(testData.get("LikeToInsureYourStockInTransit"), extentedReport);
		
			
			
			ImportantStatements is1 = pa.clickNext(extentedReport);
			
			
			PreviousLoss pl4 = is1.clickNext(extentedReport);
		
			
			YourQuote yq1 = pl4.clickGetQuote(extentedReport);
			
			
			YourDetails yd1 = yq1.clickReviewConfirm_YourDetailsPage(extentedReport);
			
			InterestedParties ip1 = yd1.clickNext(extentedReport);
			
			
			Contacts c1 = ip.Click_Next(extentedReport);
			
			
			SeasonalStockIncrease ss1=c.Click_Next(extentedReport);
			ss1.VerifyPageDisplaying(extentedReport);
		 
			
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
	
		@Test(description = "DLG - Web Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM051402(String browser) throws Exception {

		String tcId = "PM051402";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
			
			YourBusiness yb = gi.clickNext(extentedReport);

			yb.AnotherBusinessOccupation(testData.get("OtherBusinessOccupation"), extentedReport);
			yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
			yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
			yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
			yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
			
			People p = yb.clickNext(extentedReport);
			p.BusinessEmployees(testData.get("EmployeesInBusiness"), extentedReport);
			p.DirectorsOrPartnersInBusiness(testData.get("DirectorsOrPartnersInBusiness"), extentedReport);
			p.DirectorsOrPartnersDoAdministrativeWork(testData.get("DirectorsOrPartnersDoAdministrativeWork"), extentedReport);
			p.PartnersInjuryCover(testData.get("PartnersInjuryCover"), extentedReport);
			p.PartnersInjuryCover(testData.get("PartnersInjuryCover"), extentedReport);
			
			PublicLiability pl = p.clickNext(extentedReport);
			pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
			pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
			
			ImportantStatements is = pl.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			yq.clickReviewConfirm(extentedReport);
			yq.selectTitle(testData.get("Title"), extentedReport);
			yq.enterConfirmEmail(extentedReport);
			yq.clickTelephoneNumber(extentedReport);
			yq.clickContinue(extentedReport);
			
			YourDetails yd = yq.Click_OK(extentedReport);
			
			EmployersLiability el = yd.clickNext2(extentedReport);
			
			el.RegisteredOfficeAddress(testData.get("SameRegisteredOfficeAddress"), extentedReport);
			el.ExemptFromHoldingCERN(testData.get("ExemptFromHoldingCERN"), extentedReport);
			
			Partners partner = el.clickNext(extentedReport);
			partner.AddPartners(extentedReport);
			partner.selectPartnersTitle(testData.get("PartnersTitle"), extentedReport);
			partner.PartnersFirstName(testData.get("PartnersFirstName"), extentedReport);
			partner.PartnersLastName(testData.get("PartnersLastName"), extentedReport);
			partner.AddDetails(extentedReport);
			partner.AddAnotherPartner(extentedReport);
			partner.selectPartnersTitle(testData.get("PartnersTitle"), extentedReport);
			partner.PartnersFirstName(testData.get("PartnersFirstName"), extentedReport);
			partner.PartnersLastName(testData.get("PartnersLastName2"), extentedReport);
			partner.AddDetails(extentedReport);			
			
			InterestedParties ip = partner.Click_Next(extentedReport);
			ip.LikeToAddInterestedParties(testData.get("LikeToAddInterestedParties"), extentedReport);
			
			Contacts c = ip.Click_Next(extentedReport);
			c.AnyoneMakeChanges(testData.get("AnyoneMakeChanges1"), extentedReport);
			
			yq = c.Click_BackToQuote(extentedReport);
			
			gi = yq.clickBack(extentedReport);
						
			yb = gi.clickNext(extentedReport);
			yb.TypeOfBusiness(testData.get("TypeOfBusiness2"), extentedReport);
			
			p = yb.clickNext(extentedReport);
			p.BusinessEmployees(testData.get("EmployeesInBusiness"), extentedReport);
			p.EmployersLiabilityCover(testData.get("EmployersLiabilityCover"), extentedReport);
			p.DirectorsOrPartnersInBusiness(testData.get("DirectorsOrPartnersInBusiness"), extentedReport);
			p.DirectorsOrPartnersDoAdministrativeWork(testData.get("DirectorsOrPartnersDoAdministrativeWork"), extentedReport);
			
			p.clickNext(extentedReport);
			p.clickNext(extentedReport);
			is = pl.clickNext(extentedReport);
			pl2 = is.clickNext(extentedReport);
			yq = pl2.clickGetQuote(extentedReport);
			yq.clickReviewConfirm(extentedReport);
			el = yd.clickNext2(extentedReport);
			el.clickNext(extentedReport);
			c = ip.Click_Next(extentedReport);
			c.AnyoneMakeChanges(testData.get("AnyoneMakeChanges1"), extentedReport);
			
			Payment p1 = c.Click_CheckOut(extentedReport);
			p1.selectPaymentMethod(testData.get("PaymentMethod"), extentedReport);
			p1.AcceptMonthlyCondition(extentedReport);
			p1.selectConditions(testData.get("Conditions"), extentedReport);
			
			MonthlyPaymentDetails mpd = p1.Click_Next2(extentedReport);
			mpd.SameAccountName(testData.get("SameAccountName"), extentedReport);
			mpd.SortCode(testData.get("SortCode"), extentedReport);
			mpd.AccountNumber(testData.get("AccountNumber"), extentedReport);
			mpd.InstallmentDayOfMonth(testData.get("InstallmentDayOfMonth"), extentedReport);
			
			PaymentInformation pi = mpd.Click_Next(extentedReport);
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
			driver.quit();
		}
	}	
	
	@Test(description = "DLG - Web Journey", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void PM052084(String browser) throws Exception {

		String tcId = "PM052084";
		final WebDriver driver = WebDriverFactory.get(browser);
		HashMap<String, String> testData = getTestData(tcId);
		String securityKey = testData.get("SecurityKey");
		String description = testData.get("Description");
		Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, description);
		try {
			// Navigate to Login Page
			SecurityCheck sc = new SecurityCheck(driver, webSite,extentedReport);
			sc.openURL();
			sc.enterSecurityKey(securityKey, extentedReport);
			
			BusinessDetails bd = sc.clickProceed(extentedReport);
			bd.WhatDoYouDo(testData.get("Profession"), extentedReport);
			bd.whereDoYouRunYourBusinessFrom(testData.get("RunYourBusinessFrom1"), extentedReport);
			bd.BusinessRunNext(extentedReport);
			bd.DoYouHaveAnyEmployees(testData.get("AnyEmployees"), extentedReport);
			bd.EmployersLiabilityCover(testData.get("EmployersLiabilityCover"), extentedReport);
			bd.WhichOfTheseWouldYouLikeCoverFor(testData.get("CoverTaken1"), extentedReport);
			
			GeneralInformation gi = bd.clickContinue(extentedReport);
			gi.enterbusinessName(testData.get("BusinessName"), extentedReport);
			gi.enterFirstName(testData.get("FirstName"), extentedReport);
			gi.enterLastName(testData.get("LastName"), extentedReport);
			gi.enterEmail(extentedReport);
			gi.enterTelephone(testData.get("Telephone"), extentedReport);
			gi.enterPostcode(testData.get("Postcode"), extentedReport);
			gi.clickFindAddress(extentedReport);
			gi.ClickSelectYourAddress(extentedReport);
			gi.selectEmail(extentedReport);
			
			YourBusiness yb = gi.clickNext(extentedReport);

			yb.AnotherBusinessOccupation(testData.get("OtherBusinessOccupation"), extentedReport);
			yb.TypeOfBusiness(testData.get("TypeOfBusiness"), extentedReport);
			yb.BusinesshaveAnySubsidiaries(testData.get("AnyBusinessSubsidiaries"), extentedReport);
			yb.BusinessYearsOfTrading(testData.get("BusinessYearsInTrading"), extentedReport);
			yb.WhereYourBusinessWork(testData.get("BusinessWorkFrom"), extentedReport);
			
			People p = yb.clickNext(extentedReport);
			p.EmployersLiabilityCover(testData.get("EmployersLiabilityCover"), extentedReport);
			p.EmployeesInBusiness(testData.get("EmployeesInBusiness"), extentedReport);
			p.AdministrativeEmployees(testData.get("AdministrativeEmployees"), extentedReport);
			p.PremisesUsedByEmployees(testData.get("PremisesUsedByEmployees"), extentedReport);
			
			PublicLiability pl = p.clickNext(extentedReport);
			pl.PublicLiabilityCoverAmount(testData.get("PublicLiabilityCoverAmount"), extentedReport);
			pl.SellProductOutsideUK(testData.get("SellProductOutsideUK"), extentedReport);
		
			BusinessPremises bp = pl.clickNext2(extentedReport);
			bp.BusinessPremisesAddress(testData.get("BusinessPremisesAddress"), extentedReport);
			bp.PremisesType(testData.get("PremisesType"), extentedReport);
			bp.PremisesOccupied(testData.get("PremisesOccupied"), extentedReport);
			bp.BusinessApplies(testData.get("BusinessApplies"), extentedReport);
			bp.PremisesATM(testData.get("PremisesATM"), extentedReport);
			bp.AddBusinessContentCover(testData.get("BusinessContentCoverAmount"), extentedReport);		
			bp.WallMaterial(testData.get("WallMaterial"), extentedReport);
			bp.RoofMaterial(testData.get("RoofMaterial"), extentedReport);
			bp.HeatingList(testData.get("HeatingList"), extentedReport);
			bp.SubsidenceCover(testData.get("SubsidenceCover"), extentedReport);
			
			PropertyAwayFromThePremises pa = bp.clickNext(extentedReport);
			pa.PropertyAwayFromPremises(testData.get("PropertyAwayFromPremises"), extentedReport);
			
			ImportantStatements is = pa.clickNext(extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);
			is.TermsAndConditions(testData.get("TermsAndConditions"), extentedReport);
			
			PreviousLoss pl2 = is.clickNext(extentedReport);
			pl2.AnyPreviousClaims(testData.get("AnyPreviousClaims"), extentedReport);
			
			YourQuote yq = pl2.clickGetQuote(extentedReport);
			yq.PremiumAmount(extentedReport);
			yq.RemoveEmployersLiabilityCover(extentedReport);
			yq.SureToRemoveELCover(testData.get("SureToRemoveELCover"), extentedReport);
			yq.PremiumAmount(extentedReport);
			
			gi = yq.clickBack(extentedReport);
		
			yb = gi.clickNext(extentedReport);
						
			p = yb.clickNext(extentedReport);
			p.ErrorMsgOnELCoverDisplayed(extentedReport);
			
			Log.testCaseResult(extentedReport);
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		}
		finally {
			Log.endTestCase(extentedReport);
			driver.quit();
		}
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
			ld.EnterUsername(testData.get("username"), extentedReport);
			ld.EnterPassword(testData.get("password"), extentedReport);
			
			
			MyDashboardDetails md=ld.clickLogin(extentedReport);
			
			
			SearchDashboard sd=md.Click_Task(testData.get("Task"), extentedReport);
			sd.Click_Create_NewCustomer(extentedReport);
			
			
			
			
			Log.testCaseResult(extentedReport);
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		}
		finally {
			Log.endTestCase(extentedReport);
			driver.quit();
		}
	}	



}
package com.ssp.wj_pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.xpath.operations.Or;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.support.StopWatch;
import com.ssp.utils.ElementLayer;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;

public class TreatmentsProvidedByYourBusiness extends LoadableComponent<InterestedParties> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Interested Parties screen objects

	
	@FindBy(css = "#C6__BUT_5847B0D83AF0F962263931,#C7__BUT_5847B0D83AF0F962263931")
	WebElement btnNext;
	
	
	@FindAll({
	@FindBy(xpath = "//*[@id='radio_C6__provideOtherTreatmentList']/label/span[contains(text(),'Yes')]"),
	@FindBy(xpath = "//*[@id='radio_C6__provideOtherTreatmentList']/label/span[contains(text(),'No')]"),
	@FindBy(xpath = "//*[@id='radio_C7__provideOtherTreatmentList']/label/span[contains(text(),'Yes')]"),
	@FindBy(xpath = "//*[@id='radio_C7__provideOtherTreatmentList']/label/span[contains(text(),'No')]")
	})
	List<WebElement> BtnDoYouProvideAnyTreatmentsExceptTheseOnes;
	
	@FindAll({
		@FindBy(xpath = "//*[@id='radio_C6__QUE_5847B0D83AF0F962263921']/label/span[contains(text(),'Yes')]"),
		@FindBy(xpath = "//*[@id='radio_C6__QUE_5847B0D83AF0F962263921']/label/span[contains(text(),'No')]"),
		@FindBy(xpath = "//*[@id='radio_C7__QUE_5847B0D83AF0F962263921']/label/span[contains(text(),'Yes')]"),
		@FindBy(xpath = "//*[@id='radio_C7__QUE_5847B0D83AF0F962263921']/label/span[contains(text(),'No')]")
		})
		List<WebElement> BtnDoYouHaveAdequateQualifications;
	
	@FindBy(css = "#C6__BUT_5847B0D83AF0F962263914,#C7__BUT_5847B0D83AF0F962263914")
	WebElement btnAddTreatment;
	
	@FindBy(css = "#C6__QUE_C8F3E8A0E3C242A2684128,#C7__QUE_C8F3E8A0E3C242A2684128")
	WebElement btnSelectTreatment;
	
	@FindBy(css = "#C6__BUT_C8F3E8A0E3C242A2684185,#C7__BUT_C8F3E8A0E3C242A2684185")
	WebElement btnAddTreatmentonSelectTreatment;
	
	@FindBy(css = "#C6__BUT_5847B0D83AF0F962263911_R1,#C7__BUT_5847B0D83AF0F962263911_R1")
	WebElement btnDeleteTreatment;
	
	@FindBy(css = "#C6__BUT_5847B0D83AF0F962263917,#C7__BUT_5847B0D83AF0F962263917")
	WebElement btnAddAnotherTreatment;
	
	@FindBy(css = "#C6__TXT_7CD52B7137FB1AFE1134263 > div > div > div:nth-child(1),#C7__TXT_7CD52B7137FB1AFE1134263 > div > div > div:nth-child(1)")
	WebElement txtTreatment;
	
	@FindBy(css = "#C6__provideOtherTreatmentList_ERRORMESSAGE,#C7__provideOtherTreatmentList_ERRORMESSAGE")
	WebElement ErrorProvideTreatment;
	
	
	
	public TreatmentsProvidedByYourBusiness(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public TreatmentsProvidedByYourBusiness(WebDriver driver, ExtentTest report) {
		this.driver = driver;
		this.extentedReport = report;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		isPageLoaded = true;
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		if (!isPageLoaded) {
			Assert.fail();
		}
	}
	
/*	public void openURL(){
		driver.get(sspURL);
	}
	*/
	public void DoYouHaveAdequateQualifications(String doYouHaveAdequateQualifications, ExtentTest extentedReport) throws Exception {
		
		try{
			WaitUtils.waitForListElement(driver, BtnDoYouHaveAdequateQualifications, 30);
			Thread.sleep(4000);
			ElementLayer.clickExpectedValue(BtnDoYouHaveAdequateQualifications, doYouHaveAdequateQualifications, extentedReport, driver);
			Log.message("Click DoYouHaveAdequateQualifications : " + doYouHaveAdequateQualifications, driver, extentedReport);
		
		}catch (Exception e) {
			throw new Exception("Error while entering DoYouHaveAdequateQualifications detail : " + e);
		}
	}
	
public void DoYouProvideAnyTreatmentsExceptTheseOnes(String doYouProvideAnyTreatmentsExceptTheseOnes, ExtentTest extentedReport) throws Exception {
		
		try{
			WaitUtils.waitForListElement(driver, BtnDoYouProvideAnyTreatmentsExceptTheseOnes, 10);
			ElementLayer.clickExpectedValue(BtnDoYouProvideAnyTreatmentsExceptTheseOnes, doYouProvideAnyTreatmentsExceptTheseOnes, extentedReport, driver);
			Log.message("Click DoYouProvideAnyTreatmentsExceptTheseOnes : " + doYouProvideAnyTreatmentsExceptTheseOnes, driver, extentedReport);
		
		}catch (Exception e) {
			throw new Exception("Error while entering DoYouProvideAnyTreatmentsExceptTheseOnes detail : " + e);
		}
	}
	
public void ClickAddTreatment(ExtentTest extentedReport) throws Exception {
	
	try {
		
		WaitUtils.waitForElement(driver, btnAddTreatment);
		btnAddTreatment.click();
		Log.message("Clicked Add Treatment button", driver, extentedReport);
		
	} catch (Exception e) {
		throw new Exception("Error while clicking Add Treatment Button : " + e);
	}
}
public void selectTreatment(String Treatment, ExtentTest extentedReport) throws Exception {
	try {
		WaitUtils.waitForElement(driver, btnSelectTreatment);
		Thread.sleep(5000);
		new Select(btnSelectTreatment).selectByVisibleText(Treatment);
		Log.message("Entered Treatment : " + Treatment, driver, extentedReport);
	} catch (Exception e) {
		throw new Exception("Error while entering Treatment : " + e);
	}
}

public void ClickAddTreatmentOnSelectTreatmentPage(ExtentTest extentedReport) throws Exception {
	
	try {
		
		WaitUtils.waitForElement(driver, btnAddTreatmentonSelectTreatment);
		Thread.sleep(8000);
		Actions actions = new Actions(driver);
		actions.moveToElement(btnAddTreatmentonSelectTreatment).click().perform();
		//btnAddTreatmentonSelectTreatment.click();
		Log.message("Clicked Add Treatment button on select Treatment Page", driver, extentedReport);
		
	} catch (Exception e) {
		throw new Exception("Error while clicking Add Treatment Button on select Treatment Page : " + e);
	}
}

public void DeleteTreatment(ExtentTest extentedReport) throws Exception {
	
	try {
		
		WaitUtils.waitForElement(driver, btnDeleteTreatment);
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(btnDeleteTreatment).click().perform();
		//btnDeleteTreatment.click();
		Log.message("Clicked Delete Treatment button", driver, extentedReport);
		
	} catch (Exception e) {
		throw new Exception("Error while clicking Delete Treatment Button : " + e);
	}
}

public void VerifyTreatmentAdded(ExtentTest extentedReport)throws Exception {
	// TODO Auto-generated method stub
	try {
		WaitUtils.waitForElement(driver, btnAddAnotherTreatment);
		if(btnAddAnotherTreatment.isDisplayed())
		{
			Log.message("Verified Treatment is adding successfully", driver, extentedReport);
		}
			else{
				Log.message("Error while adding Treatment", driver, extentedReport);
				throw new Exception("Failed");
				}
			
		} catch (Exception e) {
		throw new Exception("Error while Adding Treatment : " + e);
	}
}

public void VerifyValidationafterAddingTreatment(ExtentTest extentedReport)throws Exception {
	// TODO Auto-generated method stub
	try {
		
		WaitUtils.waitForElement(driver, ErrorProvideTreatment);
		if(!ErrorProvideTreatment.isDisplayed())
		{
		Log.message("Verified Error Provide another Treatment is not displaying now", driver, extentedReport);
		}
		else
		{Log.message("Error Provide another Treatment is still displaying", driver, extentedReport);
		throw new Exception("Failed");
		}
		
	} catch (Exception e) {
		throw new Exception("Error while Deleting Treatment : " + e);
	}
}

public void VerifyErrorProvideAnotherTreatment(ExtentTest extentedReport)throws Exception {
	// TODO Auto-generated method stub
	try {
		
		WaitUtils.waitForElement(driver, ErrorProvideTreatment);
		if(ErrorProvideTreatment.isDisplayed())
		{
		Log.message("Verified Error Provide another Treatment is correctly displaying", driver, extentedReport);
		}
		else
		{Log.message("Error Provide another Treatment is not displaying", driver, extentedReport);
		throw new Exception("Failed");
		}
		
		
		
	} catch (Exception e) {
		throw new Exception("Error Provide another Treatment is not displaying : " + e);
	}
}

public void ClickNext_SamePage(ExtentTest extentedReport) throws Exception {
	
	try {
		
		WaitUtils.waitForElement(driver, btnNext);
		btnNext.click();
		Log.message("Clicked Next button", driver, extentedReport);
		
	} catch (Exception e) {
		throw new Exception("Error while clicking Next Button : " + e);
	}
}
	public BusinessPremises Click_Next(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnNext);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnNext);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Next button", driver, extentedReport);
			Log.event("Clicked Next button", StopWatch.elapsedTime(startTime));
			return new BusinessPremises(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Next button: " + e);
		}
	}
	
	public BusinessProperty Click_Next_BusinessProperty(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnNext);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnNext);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Next button", driver, extentedReport);
			Log.event("Clicked Next button", StopWatch.elapsedTime(startTime));
			return new BusinessProperty(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Next button: " + e);
		}
	}
	
}
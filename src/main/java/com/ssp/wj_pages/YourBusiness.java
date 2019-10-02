package com.ssp.wj_pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class YourBusiness extends LoadableComponent<YourBusiness> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Your Business screen objects
	@FindBy(css = "#C2__BUT_FAE554C988A5F3933135_R1")
	WebElement ChangeLink;
	
	@FindBy(css = "#auto-C2__QUE_2B7DF87E3EF81F6A3815_R1")
	WebElement TxtChangeProfession;
	
	@FindBy(xpath = "//*[@id='C2__TXT_43DCC4A7EBA0A286613073_R1']//label")
	WebElement ErrorMsgOnChangedProfession;
	
	@FindAll({
		@FindBy(xpath = "//div[@id='radio_C2__anythingElse']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id='radio_C2__anythingElse']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnOtherOccupation;
	
	@FindBy(xpath = "//*[@id='C2__QUE_9BFD06CAFB494FB61947']")
	WebElement BusinessType;
	
	@FindAll({
		@FindBy(xpath = "//*[@id='radio_C2__QUE_9E87048F6CFBCA01515980']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//*[@id='radio_C2__QUE_9E87048F6CFBCA01515980']//span[contains(text(), 'No')]")
		})
	//	WebElement BtnBusinesshaveAnySubsidiaries;
	List<WebElement> BtnBusinesshaveAnySubsidiaries;
	
	@FindAll({
		@FindBy(xpath = "//*[@id='checkbox_C2__QUE_FAE554C988A5F3934165']//span[contains(text(), 'I rent a chair or a space from a salon')]"),
		@FindBy(xpath = "//*[@id='checkbox_C2__QUE_FAE554C988A5F3934165']//span[contains(text(), 'From my own salon')]"),
		@FindBy(xpath = "//*[@id='checkbox_C2__QUE_FAE554C988A5F3934165']//span[contains(text(), 'Mobile business')]"),
		@FindBy(xpath = "//*[@id='checkbox_C2__QUE_FAE554C988A5F3934165']//span[contains(text(), 'I work from home')]")
		})
	
	List<WebElement> BtnBusinesRunFrom;
	
	@FindBy(xpath = "//*[@id='C2__QUE_FAE554C988A5F3933901']")
	WebElement BusinessYearsOfTrading;
	
	@FindBy(xpath = "//*[@id='C2__work']")
	WebElement WhereYourBusinessWork;
	
	@FindBy(xpath = "//*[@id='C2__p4_BUT_391E4BE220C07767120915']//button")
	WebElement BtnNext;
	
	@FindBy(css = "#C2__BUT_9106E0B183C83828768538")
	WebElement BtnYesWarningMessage;
	
	public YourBusiness(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public YourBusiness(WebDriver driver, ExtentTest report) {
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
	
	
	public void ChangeLink(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, ChangeLink);
			ChangeLink.click();
			Log.message("Clicked ChangeLink", driver, extentedReport);
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while clicking ChangeLink" + e);
		}
	}
	public void ErrorMsgOnChangedProfession(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, ErrorMsgOnChangedProfession);
			if(ErrorMsgOnChangedProfession.isDisplayed()){	
			Log.message("Checked ErrorMsgOnChangedProfession is displaying", driver, extentedReport);
			}else{
			Log.message("Checked ErrorMsgOnChangedProfession is not displaying", driver, extentedReport);
			throw new Exception("Failed");
			}
		}catch (Exception e) {
			throw new Exception("Error while checking ErrorMsgOnChangedProfession: " + e);
		}
	}
	
	public void ChangeProfession(String txtChangeProfession, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtChangeProfession);
			TxtChangeProfession.clear();
			TxtChangeProfession.sendKeys(txtChangeProfession, "\t");
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered TxtChangeProfession : " + txtChangeProfession, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering TxtChangeProfession : " + e);
		}
	}
	

	public void AnotherBusinessOccupation(String btnOtherOccupation, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnOtherOccupation, 5);
			ElementLayer.clickExpectedValue(BtnOtherOccupation, btnOtherOccupation, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected OccupationType : " + btnOtherOccupation, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting AnotherBusinessOccupation detail : " + e);
		}
		
	}

	
	public void TypeOfBusiness(String businessType, ExtentTest extentedReport) throws Exception {
		try {
			//WaitUtils.waitForElement(driver, BusinessType, 2);
//			new Select(driver.findElement(By.xpath(OR.getProperty(objectInfo)))).selectByVisibleText(value);
			new Select(BusinessType).selectByVisibleText(businessType);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BusinessType : " + businessType, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting TypeOfBusiness detail : " + e);
		}
	}


	public void BusinesshaveAnySubsidiaries(String btnBusinesshaveAnySubsidiaries, ExtentTest extentedReport) throws Exception {
		try {
			//WaitUtils.waitForListElement(driver, BtnBusinesshaveAnySubsidiaries, 2);
			//Actions actions = new Actions(driver);			
			//BtnBusinesshaveAnySubsidiaries = driver.findElement(By.xpath("//*[@id='radio_C2__QUE_9E87048F6CFBCA01515980']//span[contains(text(), '" +btnBusinesshaveAnySubsidiaries +"')]"));
			//BtnBusinesshaveAnySubsidiaries.click();
		
			//actions.moveToElement(
			ElementLayer.clickExpectedValue(BtnBusinesshaveAnySubsidiaries, btnBusinesshaveAnySubsidiaries, extentedReport, driver);
			Log.message("Selected AnySubsidiaries : " + btnBusinesshaveAnySubsidiaries, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting option for BusinesshaveAnySubsidiaries detail : " + e);
		}
	}

	public void BusinessYearsOfTrading(String businessYearsOfTrading, ExtentTest extentedReport) throws Exception {
		try {
			//WaitUtils.waitForElement(driver, BusinessYearsOfTrading, 2);
			//Thread.sleep(5000);
			new Select(BusinessYearsOfTrading).selectByVisibleText(businessYearsOfTrading);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected YearsOfTrading : " + businessYearsOfTrading, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BusinessYearsOfTrading detail : " + e);
		}
	}

	
	public void WhereYourBusinessWork(String whereYourBusinessWork, ExtentTest extentedReport) throws Exception {
		try {
			//WaitUtils.waitForElement(driver, WhereYourBusinessWork, 5);
			new Select(WhereYourBusinessWork).selectByVisibleText(whereYourBusinessWork);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected whereYourBusinessWork : " + whereYourBusinessWork, driver, extentedReport);	
		} catch (Exception e) {
			throw new Exception("Error while selecting whereYourBusinessWork detail : " + e);
		}
	}
	
	public void BusinesRunFrom(String businesRunFrom, ExtentTest extentedReport) throws Exception {
	
			try {
				WaitUtils.waitForListElement(driver, BtnBusinesRunFrom, 5);
				ElementLayer.clickExpectedValue(BtnBusinesRunFrom, businesRunFrom, extentedReport, driver);
				WaitUtils.waitForSpinner(driver);
				Log.message("Selected BtnBusinesRunFrom : " + businesRunFrom, driver, extentedReport);
			} catch (Exception e) {
				throw new Exception("Error while selecting BtnBusinesRunFrom detail : " + e);
			}
			
	}
	public void Click_Yes_Warning_Message(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnYesWarningMessage);
			BtnYesWarningMessage.click();
			Log.message("Clicked BtnYesWarningMessage", driver, extentedReport);
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnYesWarningMessage" + e);
		}
	}

	
	public People clickNext(ExtentTest extentedReport) throws Exception {
		try {
			//final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, BtnNext);
			//JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("arguments[0].click();", BtnNext);
			BtnNext.click();
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked next button", driver, extentedReport);
			//Log.event("Log - Clicked next button", StopWatch.elapsedTime(startTime));
			return new People(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Next button: " + e);
		}
	}
}
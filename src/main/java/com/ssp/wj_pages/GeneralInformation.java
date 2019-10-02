package com.ssp.wj_pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.support.StopWatch;
import com.ssp.utils.DataUtils;
import com.ssp.utils.ElementLayer;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;

public class GeneralInformation extends LoadableComponent<GeneralInformation> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//General Information screen objects


	@FindBy(css = "#C1__businessName")
	WebElement txtbusinessName;
	
	@FindBy(css = "#C1__QUE_8AE91352B238E1201662661")
	WebElement txtFirstName;
	
	@FindBy(css = "#C1__QUE_8AE91352B238E1201662670")
	WebElement txtLastName;
	
	@FindBy(css = "#C1__QUE_E5F86F3600E59B451665324")
	WebElement txtEmail;
	
	@FindBy(css = "#C1__QUE_E5F86F3600E59B451665329")
	WebElement txtTelephone;
	
	@FindBy(css = "#C1__C1__QUE_CC6AE75C0AD6F1E6924015")
	WebElement txtPostcode;
	

	@FindBy(css = "#C1__C1__BUT_CC6AE75C0AD6F1E6928020")
	WebElement btnFindAddress;
	
	@FindBy(css = "#C1__QUE_E5F86F3600E59B451665319_2")
	WebElement checkEmail;
	
	@FindAll({
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Letter')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Telephone')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Email')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'SMS')]")
	})
	List<WebElement> BtnPreferNotToReceiveUpdates;
	
	
	
	@FindBy(xpath ="//*[@id='C1__C1__QUE_CC6AE75C0AD6F1E6924030']/option[2]")
	WebElement AddressLookup;
	
	
	@FindBy(css = "#C1__BUT_391E4BE220C07767120915")
	WebElement btnNext;
	
	
	
	
	/*public GeneralInformation(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	*/
	
	public GeneralInformation(WebDriver driver, ExtentTest report) {
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
	
	public void openURL(){
		driver.get(sspURL);
	}
	
	public void enterbusinessName(String businessName, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtbusinessName);
			txtbusinessName.clear();
			txtbusinessName.sendKeys(businessName);
			Log.message("Entered businessName : " + businessName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering businessName : " + e);
		}
	}
	
	public void enterFirstName(String FirstName, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtFirstName);
			txtFirstName.clear();
			txtFirstName.sendKeys(FirstName);
			Log.message("Entered FirstName : " + FirstName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering FirstName; : " + e);
		}
	}
	
	public void enterLastName(String LastName, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtLastName);
			txtLastName.clear();

			txtLastName.sendKeys(LastName);
			Log.message("Entered LastName : " + LastName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering LastName : " + e);
		}
	}
	
	
	public void enterEmail(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtEmail);
			txtEmail.clear();
			String email = DataUtils.getEmail();
			txtEmail.sendKeys(email);
			Log.message("Entered Email : " + email, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Email : " + e);
		}
	}

	public void enterDifferentEmail(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtEmail);
			txtEmail.clear();
			String email = DataUtils.getDifferentEmail();
			txtEmail.sendKeys(email);
			Log.message("Entered Email : " + email, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Email : " + e);
		}
	}

	
	
	public void enterTelephone(String Telephone, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtTelephone);
			txtTelephone.clear();
			txtTelephone.sendKeys(Telephone);
			Log.message("Entered Telephone : " + Telephone, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Telephone : " + e);
		}
	}
	
	public void enterPostcode(String Postcode, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtPostcode);
			txtPostcode.clear();
			txtPostcode.sendKeys(Postcode);
			Log.message("Entered Postcode : " + Postcode, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Postcode : " + e);
		}
	}
	

	
/*	public void PreferNotToReceiveUpdates(String btnPreferNotToReceiveUpdates, ExtentTest extentedReport) throws Exception{
		try{
			WaitUtils.waitForListElement(driver, BtnPreferNotToReceiveUpdates, 10);
			ElementLayer.clickExpectedValue(BtnPreferNotToReceiveUpdates, btnPreferNotToReceiveUpdates, extentedReport, driver);
			Log.message("Entered the description : " + btnPreferNotToReceiveUpdates, driver, extentedReport);
			
		}catch (Exception e) {
			throw new Exception("Error while entering PreferNotToReceiveUpdates detail : " + e);
		}
	}*/
	
	public void selectEmail(ExtentTest extentedReport) throws Exception {
		try {
			checkEmail.click();
			Log.message("Selected Email", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking sEmail button : " + e);
		}
	}
	public void clickFindAddress(ExtentTest extentedReport) throws Exception {
		
		try {
			
			WaitUtils.waitForElement(driver, btnFindAddress);
			btnFindAddress.click();
			Log.message("Clicked Find Address button", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering Find Address detail : " + e);
		}
	}
	
	public void ClickSelectYourAddress(ExtentTest extentedReport) throws Exception {
		
			try {
				
				WaitUtils.waitForElement(driver, AddressLookup);
				AddressLookup.click();
				Log.message("Clicked AddressLookup button", driver, extentedReport);
				WaitUtils.waitForSpinner(driver);
			} catch (Exception e) {
				throw new Exception("Error while entering WhatDoYouDo detail : " + e);
			}
	}
	public YourBusiness clickNext(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnNext);
			btnNext.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Next button", driver, extentedReport);
			return new YourBusiness(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking btnNext button: " + e);
		}
	}
}
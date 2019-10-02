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

public class BusinessDetails extends LoadableComponent<BusinessDetails> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";
	
	//Business Details screen objects
	@FindBy(css = "#what")
	WebElement Profession;

        @FindAll({
	@FindBy(xpath = "//div[@id='business']//div[@class= 'formrow ']//span[contains(text(), 'From my own salon')]"),
	@FindBy(xpath = "//div[@id='business']//div[@class= 'formrow ']//span[contains(text(), 'I rent a chair or a space from a salon')]"),
	@FindBy(xpath = "//div[@id='business']//div[@class= 'formrow ']//span[contains(text(), 'Mobile business')]"),
	@FindBy(xpath = "//div[@id='business']//div[@class= 'formrow ']//span[contains(text(), 'I work from home')]"),
	@FindBy(xpath = "//div[@id='business']//div[@class= 'formrow ']//span[contains(text(), 'Yes')]"),
	@FindBy(xpath = "//div[@id='business']//div[@class= 'formrow ']//span[contains(text(), 'No')]"),
	@FindBy(xpath = "//*[@id='checkbox_C2__QUE_FAE554C988A5F3934165']//span[contains(text(), 'From my own salon')]"),
	@FindBy(xpath = "//*[@id='checkbox_C2__QUE_FAE554C988A5F3934165']//span[contains(text(), 'I rent a chair or a space from a salon')]"),
	@FindBy(xpath = "//*[@id='checkbox_C2__QUE_FAE554C988A5F3934165']//span[contains(text(), 'Mobile business')]"),
	@FindBy(xpath = "//*[@id='checkbox_C2__QUE_FAE554C988A5F3934165']//span[contains(text(), 'I work from home')]")
	})
	List<WebElement> BtnwhereDoYouRunYourBusinessFrom;

	
	@FindBy(xpath = "//*[@id='business']//button[@class= 'next']")
	WebElement BtnBusinessRunNext;
	
	@FindAll({
	@FindBy(xpath = "//div[@id='employee']//div[@class= 'formrow ']//span[contains(text(), 'No')]"),
	@FindBy(xpath = "//div[@id='employee']//div[@class= 'formrow ']//span[contains(text(), 'Temporary employee(s)')]"),
	@FindBy(xpath = "//div[@id='employee']//div[@class= 'formrow ']//span[contains(text(), 'Permanent employee(s)')]"),
	@FindBy(xpath = "//div[@id='employee']//div[@class= 'formrow ']//span[contains(text(), 'Permanent and temporary employee(s)')]")
	})
	List<WebElement> BtnDoYouHaveAnyEmployees;
	
	@FindAll({
		@FindBy(xpath = "//div[@id='elcover']//div[@class= 'formrow ']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id='elcover']//div[@class= 'formrow ']//span[contains(text(), 'No')]")
	})
	List<WebElement> BtnEmployersLiabilityCover;
	
	@FindAll({
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Hair and beauty treatments liability')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Business contents')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Business tools and equipment')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Business stock')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Your salon (the building)')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Your home (the building)')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Your household contents')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Business interruption')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Theft of takings')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Legal expenses')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'Your premises (the building)')]"),
	@FindBy(xpath = "//div[@id='covers']//div[@class= 'formrow ']//span[contains(text(), 'None')]")
		})
	List<WebElement> BtnWhichOfTheseWouldYouLikeCoverFor;

	
	@FindBy(xpath = "//div[@class='continue']/button")
	WebElement BtnContinue;
	
	public BusinessDetails(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public BusinessDetails(WebDriver driver, ExtentTest report) {
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
	
	/*public void openURL(){
		driver.get(sspURL);
	}*/
	
	
	public void WhatDoYouDo(String profession, ExtentTest extentedReport) throws Exception {
		try {
			driver.switchTo().frame("sagepay");
			WaitUtils.waitForElement(driver, Profession);
			Profession.clear();
			Profession.sendKeys(profession, "\t");
			Log.message("Entered Profession : " + profession, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering WhatDoYouDo detail : " + e);
		}
	}
	
	public void whereDoYouRunYourBusinessFrom(String btnwhereDoYouRunYourBusinessFrom, ExtentTest extentedReport) throws Exception{
		try{
		WaitUtils.waitForListElement(driver, BtnwhereDoYouRunYourBusinessFrom, 5);
		ElementLayer.clickExpectedValue(BtnwhereDoYouRunYourBusinessFrom, btnwhereDoYouRunYourBusinessFrom, extentedReport, driver);
		WaitUtils.waitForSpinner(driver);
		Log.message("Selected RunYourBusinessFrom : " + btnwhereDoYouRunYourBusinessFrom, driver, extentedReport);	
		}catch (Exception e) {
		throw new Exception("Error while entering whereDoYouRunYourBusinessFrom detail : " + e);
		}

	}

	public void BusinessRunNext(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnBusinessRunNext);
			BtnBusinessRunNext.click();
						
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnBusinessRunNext : " + e);
		}

	}
	public void DoYouHaveAnyEmployees(String btnDoYouHaveAnyEmployees, ExtentTest extentedReport) throws Exception{
		try{
			WaitUtils.waitForListElement(driver, BtnDoYouHaveAnyEmployees, 10);
			ElementLayer.clickExpectedValue(BtnDoYouHaveAnyEmployees, btnDoYouHaveAnyEmployees, extentedReport, driver);
			Log.message("Selected No. of employees : " + btnDoYouHaveAnyEmployees, driver, extentedReport);
			
		}catch (Exception e) {
			throw new Exception("Error while selecting DoYouHaveAnyEmployees detail : " + e);
		}

}
	public void EmployersLiabilityCover(String btnEmployersLiabilityCover, ExtentTest extentedReport) throws Exception{
		try{
			WaitUtils.waitForListElement(driver, BtnEmployersLiabilityCover, 20);
			ElementLayer.clickExpectedValue(BtnEmployersLiabilityCover, btnEmployersLiabilityCover, extentedReport, driver);
			Log.message("Selected btnEmployersLiabilityCover : " + btnEmployersLiabilityCover, driver, extentedReport);
		
		}catch (Exception e) {
			throw new Exception("Error while selecting btnEmployersLiabilityCover : " + e);
		}
	}
	
	public void WhichOfTheseWouldYouLikeCoverFor(String btnWhichOfTheseWouldYouLikeCoverFor, ExtentTest extentedReport) throws Exception{
		try{
			WaitUtils.waitForListElement(driver, BtnWhichOfTheseWouldYouLikeCoverFor, 5);
			ElementLayer.clickExpectedValue(BtnWhichOfTheseWouldYouLikeCoverFor, btnWhichOfTheseWouldYouLikeCoverFor, extentedReport, driver);
Log.message("Selected Cover : " + btnWhichOfTheseWouldYouLikeCoverFor, driver, extentedReport);
			
		}catch (Exception e) {
			throw new Exception("Error while selecting WhichOfTheseWouldYouLikeCoverFor detail : " + e);
		}

	}
	
	public GeneralInformation clickContinue(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, BtnContinue);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", BtnContinue);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked continue button", driver, extentedReport);
			Log.event("Log - Clicked continue button", StopWatch.elapsedTime(startTime));
			return new GeneralInformation(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking continue button: " + e);
		}
	
	}
	
	public void VerifyProfession(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, Profession);
			
			Assert.assertFalse(Profession.isDisplayed());
			
				Log.message("Verified correct BuildingHasAmountForContentsValidationMessage has been displayed ", driver, extentedReport);
					  }
			//Log.message("Clicked btnAddBusinessTools", driver, extentedReport);
		catch (Exception e) {
			throw new Exception("Error while Verifying BuildingHasAmountForContentsValidationMessage  : " + e);
		}
}
}
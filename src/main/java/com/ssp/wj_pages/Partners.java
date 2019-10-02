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
import com.ssp.utils.DataUtils;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;

public class Partners extends LoadableComponent<Partners> {
	

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Partners screen objects
	@FindBy(css = "#C1__BUT_D304421B4A30AE94573230")
	WebElement BtnAddPartners;
	
	@FindBy(css = "#C1__QUE_48BDF1EEA3569326405358")
	WebElement PartnersTitle;
	
	@FindBy(css = "#C1__QUE_48BDF1EEA3569326405361")
	WebElement TxtPartnersFirstName;
	
	@FindBy(css = "#C1__QUE_EFE281AF6E39A131169832")
	WebElement TxtPartnersLastName;	

	@FindBy(css = "#C1__BUT_E9B4CF71BABEB218517288")
	WebElement BtnAdd;

	@FindBy(css ="#C1__BUT_D304421B4A30AE94573853")
	WebElement BtnAddAnotherPartner;
	
	@FindBy(css = "#C1__BUT_55E5AE0A984C2873500525")
	WebElement BtnNext;
			
	public Partners(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public Partners(WebDriver driver, ExtentTest report) {
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
	
	public void selectPartnersTitle(String partnersTitle, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, PartnersTitle);
			new Select(PartnersTitle).selectByVisibleText(partnersTitle);
			Log.message("Selected PartnersTitle : " + partnersTitle, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting PartnersTitle : " + e);
		}
	}
	
	public void PartnersFirstName(String txtPartnersFirstName, ExtentTest extentedReport) throws Exception {
		try {
			
			WaitUtils.waitForElement(driver, TxtPartnersFirstName);
			TxtPartnersFirstName.clear();
			TxtPartnersFirstName.sendKeys(txtPartnersFirstName);
			Log.message("Entered TxtPartnersFirstName : " + txtPartnersFirstName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering TxtPartnersFirstName : " + e);
		}
	}
	
	public void PartnersLastName(String txtPartnersLastName, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtPartnersLastName);
			TxtPartnersLastName.clear();
			TxtPartnersLastName.sendKeys(txtPartnersLastName);
			Log.message("Entered TxtPartnersLastName : " + txtPartnersLastName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering TxtPartnersLastName : " + e);
		}
	}
	
	public void AddDetails(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAdd);
			BtnAdd.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnAdd", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAdd : " + e);
		}
	}
	
	public void AddPartners(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddPartners);
			BtnAddPartners.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnAddPartners", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAddPartners : " + e);
		}
	}
	
	public void AddAnotherPartner(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddAnotherPartner);
			BtnAddAnotherPartner.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnAddAnotherPartner", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAddAnotherPartner : " + e);
		}
	}
	
	public InterestedParties Click_Next(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnNext);
			//JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("arguments[0].click();", btnOk);
			BtnNext.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnNext ", driver, extentedReport);
			return new InterestedParties(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnNext : " + e);
		}
	}

	
	
}
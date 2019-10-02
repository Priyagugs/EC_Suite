package com.ssp.Ec_pages;

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
import com.ssp.wj_pages.BusinessDetails;
import com.ssp.wj_pages.GeneralInformation;


public class LoginDetails extends LoadableComponent<LoginDetails> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";
	
	//Login Details screen objects
	@FindBy(css = "#C2__QUE_ED508ADA5C44080859323")
	WebElement txtUsername;
	
	@FindBy(css = "#C2__QUE_ED508ADA5C44080859331")
	WebElement txtPassword;

    @FindBy(css="#C2__BUT_ED508ADA5C44080859357")
	WebElement BtnLogin;
	
	
	
	public LoginDetails(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public LoginDetails(WebDriver driver, ExtentTest report) {
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
	
	
	public void EnterUsername(String username, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtUsername);
			txtUsername.clear();
			txtUsername.sendKeys(username, "\t");
			Log.message("Entered Username : " + username, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering Username: " + e);
		}
	}
	
	public void EnterPassword(String password, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtPassword);
			txtPassword.clear();
			txtPassword.sendKeys(password, "\t");
			Log.message("Entered password : " + password, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering password: " + e);
		}
	}
	
	

	
	public MyDashboardDetails clickLogin(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, BtnLogin);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", BtnLogin);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked BtnLogin button", driver, extentedReport);
			Log.event("Log - Clicked BtnLogin button", StopWatch.elapsedTime(startTime));
			return new MyDashboardDetails(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnLogin button: " + e);
		}
	
	}
	
	
}
package com.ssp.wj_pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

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

public class Payment extends LoadableComponent<Payment> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Payment screen objects
	
    @FindAll({
			@FindBy(xpath = "//*[@id='C1__FMT_E1230592B2C261042955']//span[contains(text(),'as a lump sum')]"),
			@FindBy(xpath = "//*[@id='C1__FMT_E1230592B2C261042955']//span[contains(text(),'per month')]"),
			@FindBy(css = "#C1__BUT_9615B35FDA83C0DA3957"),
			@FindBy(css = "#C1__BUT_9615B35FDA83C0DA3963")
			})
	List<WebElement> BtnselectPaymentMethod;
    
    @FindBy(css = "#C1__QUE_9615B35FDA83C0DA3719_0")
	WebElement btnAcceptMonthlyCondition;
	
	@FindBy(css = "#C1__BUT_CA5B92658FB254951978")
	WebElement btnBack;
	
	@FindBy(css = "#C1__BUT_CA5B92658FB254951983")
	WebElement btnNext;
	
	@FindBy(xpath = "//*[@id='C1__p4_QUE_9615B35FDA83C0DA3836']//span[contains(text(), 'read and understood the information and conditions above.')]")
	WebElement selectConditions;
	
	@FindBy(css = "#STP_1")
	WebElement YourBusinessBreadcrumb;
	
	
	
	
	public Payment(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;	
	}	
	
	public Payment(WebDriver driver, ExtentTest report) {
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

	public void selectPaymentMethod(String PaymentMethod, ExtentTest extentedReport) throws Exception {
		
		try{
			WaitUtils.waitForListElement(driver, BtnselectPaymentMethod, 10);
			ElementLayer.clickExpectedValue(BtnselectPaymentMethod, PaymentMethod, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered PaymentMethod : " + PaymentMethod, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking PaymentMethod button : " + e);
		}
	}
	
	public void selectConditions(String Conditions, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, selectConditions);
			Actions actions = new Actions(driver);
			actions.moveToElement(selectConditions).click().perform();
			WaitUtils.waitForSpinner(driver);
			Log.message("Accepting Conditions : " +Conditions, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Conditions button : " + e);
		}
	}
	
	public void AcceptMonthlyCondition(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnAcceptMonthlyCondition);
			Actions actions = new Actions(driver);
			actions.moveToElement(btnAcceptMonthlyCondition).click().perform();
			WaitUtils.waitForSpinner(driver);
			Log.message("Accepted Monthly Conditions. ", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while accepting monthly Conditions button : " + e);
		}
	}
	
	public PaymentInformation Click_Next(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnNext);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnNext);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Next button", driver, extentedReport);
			Log.event("Clicked Next button", StopWatch.elapsedTime(startTime));
			return new PaymentInformation(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Next button: " + e);
		}
	}
	
	public MonthlyPaymentDetails Click_Next2(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnNext);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnNext);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Next button", driver, extentedReport);
			Log.event("Clicked Next button", StopWatch.elapsedTime(startTime));
			return new MonthlyPaymentDetails(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Next button: " + e);
		}
	}
	
	public GeneralInformation Click_YourBusinessBreadcrumb(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, YourBusinessBreadcrumb);
			Thread.sleep(3000);
			Actions actions = new Actions(driver);
			actions.moveToElement(YourBusinessBreadcrumb).click().perform();
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked btnCheckOut button", driver, extentedReport);
		
			return new GeneralInformation(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking btnCheckOut button: " + e);
		}
	}
}
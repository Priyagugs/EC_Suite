package com.ssp.wj_pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;

public class YourDetails extends LoadableComponent<YourDetails> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//Your Details screen objects
	@FindBy(css = "#C1__BUT_55E5AE0A984C2873498711")
	WebElement btnNext;
	
	@FindBy(css = "#C1__QUE_CDAB5AE71362F2141912827")
	WebElement txtCoverStartDate;
	
	@FindBy(css = "#C1__QUE_CDAB5AE71362F2141912827_ERRORMESSAGE")
	WebElement ErrorMessage;
	
	@FindBy(css = "#C1__BUT_48BDF1EEA3569326413916")
	WebElement btnGoToCheckOut;
	
	@FindBy(css = "#C1__QUE_CDAB5AE71362F2141912827_ERRORMESSAGE")
	WebElement btnCantStartBeforeToday;
	

	public YourDetails(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public YourDetails(WebDriver driver, ExtentTest report) {
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
	
	
	public InterestedParties clickNext(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnNext);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnNext);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked next button", driver, extentedReport);
			Log.event("Log - Clicked next button", StopWatch.elapsedTime(startTime));
			return new InterestedParties(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking next button: " + e);
		}
	}
	
	public EmployersLiability clickNext2(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnNext);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnNext);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked next button", driver, extentedReport);
			Log.event("Log - Clicked next button", StopWatch.elapsedTime(startTime));
			return new EmployersLiability(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking next button: " + e);
		}
	}
	
	public Partners clickNext3(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnNext);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnNext);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked next button", driver, extentedReport);
			Log.event("Log - Clicked next button", StopWatch.elapsedTime(startTime));
			return new Partners(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking next button: " + e);
		}
	}
	public void ClickNextForSamePage(ExtentTest extentedReport) throws Exception {
		
		try {
			
			WaitUtils.waitForElement(driver, btnNext);
			btnNext.click();
			Log.message("Clicked Next button", driver, extentedReport);
				
		} catch (Exception e) {
			throw new Exception("Error while Clicking Next detail : " + e);
		}
}

	public void enterCoverStartDate(String coverStartDate, ExtentTest extentedReport)throws Exception {
		// TODO Auto-generated method stub
		try {
			WaitUtils.waitForElement(driver, txtCoverStartDate);
			txtCoverStartDate.clear();
			Thread.sleep(3000);
			txtCoverStartDate.sendKeys(coverStartDate);
			Log.message("Entered CoverStartDate : " + coverStartDate, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering CoverStartDate : " + e);
		}
	}
	
	public void VerifyDateBeforeTodayValidation(ExtentTest extentedReport)throws Exception {
		// TODO Auto-generated method stub
		try {
			WaitUtils.waitForelementToBeClickable(driver, btnCantStartBeforeToday, "Not Found VerifyDateBeforeTodayValidation");
			String actual_msg=btnCantStartBeforeToday.getText();
			String expect="Your cover can't start before today.";
			if (actual_msg.equals(expect))
			{
			Log.message("Verified 'Your cover can not start before today' Validation message displays correctly ", driver, extentedReport);
			}
			else{
				Log.message("Expecting Error message is not displaying", driver, extentedReport);
				
				throw new Exception("Failed");
				}
		} catch (Exception e) {
			throw new Exception("Error while verifying DateBeforeTodayValidation Message,Expecting Error Message is not dispalying: " + e);
		}
	}

}
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
import com.ssp.wj_pages.PublicLiability;


public class MyDashboardDetails extends LoadableComponent<MyDashboardDetails> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";
	
	//MyDashboard Details screen objects
	@FindAll({
		@FindBy(xpath = "//*[@id='C2__FMT_8A211A5516D895E938548']/div/div/div//span[contains(text(), 'Take Call')]"),
		@FindBy(xpath = "//*[@id='C2__FMT_8A211A5516D895E938548']/div/div/div//span[contains(text(), 'Make call')]"),
		@FindBy(xpath = "//*[@id='C2__FMT_8A211A5516D895E938548']/div/div/div//span[contains(text(), 'Admin Task')]")
	})
	List<WebElement> BtnSelectTask;
	

	public MyDashboardDetails(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public MyDashboardDetails(WebDriver driver, ExtentTest report) {
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
	
	
public SearchDashboard Click_Task(String btnSelectTask, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnSelectTask, 2);
			ElementLayer.clickExpectedValue(BtnSelectTask, btnSelectTask, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnSelectTask : " + btnSelectTask, driver, extentedReport);
			return new SearchDashboard(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnSelectTask : " + e);
		}
	}
	
	
}
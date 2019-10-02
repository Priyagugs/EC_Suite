package com.ssp.wj_pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

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

public class Contacts extends LoadableComponent<Contacts> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";
	
	//Contacts screen objects

    @FindAll({
		@FindBy(xpath = "//*[@id='radio_C1__QUE_48BDF1EEA3569326409122']//span[contains(text(),'Yes')]"),
		@FindBy(xpath = "//*[@id='radio_C1__QUE_48BDF1EEA3569326409122']//span[contains(text(),'No')]")
		})
		List<WebElement> BtnAnyoneMakeChanges;

	@FindBy(css = "#C1__BUT_1999EF46744176C3526924")
	WebElement BtnAddContact;
	
	@FindBy(css = "#C1__QUE_EFE281AF6E39A131148934")
	WebElement NewContactTitle;
	
	@FindBy(css = "#C1__QUE_48BDF1EEA3569326410216")
	WebElement NewContactFirstName;
	
	@FindBy(css = "#C1__QUE_EFE281AF6E39A131148922")
	WebElement NewContactLastName;
	
	@FindBy(css = "#C1__QUE_48BDF1EEA3569326410219")
	WebElement RelationshipToBusiness;
	
	@FindBy(css = "#C1__BUT_1999EF46744176C3529282")
	WebElement BtnAdd;
	
	@FindBy(css = "#C1__BUT_1999EF46744176C3524574_R1")
	WebElement BtnDelete;
	
	@FindBy(css = "#C1__BUT_1999EF46744176C3526930")
	WebElement BtnAddAnotherContact;
	
	@FindBy(css = "#C1__QUE_48BDF1EEA3569326409122_ERRORMESSAGE")
	WebElement ErrorMsg;
	
	@FindBy(css = "#C1__BUT_48BDF1EEA3569326413916")
	WebElement btnCheckout;
	
	@FindBy(css = "#C1__BUT_55E5AE0A984C2873500535")
	WebElement btnNext;
	@FindBy(css = "#C1__backtoQuote")
	WebElement btnBackToQuote;
	
	public Contacts(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public Contacts(WebDriver driver, ExtentTest report) {
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
	
	public void AnyoneMakeChanges(String AnyoneMakeChanges, ExtentTest extentedReport) throws Exception {
		
		try{
			WaitUtils.waitForListElement(driver, BtnAnyoneMakeChanges, 2);
			ElementLayer.clickExpectedValue(BtnAnyoneMakeChanges, AnyoneMakeChanges, extentedReport, driver);
			Log.message("Selected MakeChanges : " + AnyoneMakeChanges, driver, extentedReport);
		
		}catch (Exception e) {
			throw new Exception("Error while selecting AnyoneMakeChanges button : " + e);
		}
	}
	

	public void AddContact(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddContact);
			BtnAddContact.click();
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while clicking AddContact button : " + e);
		}
	}
	
	public void enterNewContactTitle(String newContactTitle, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, NewContactTitle);
			new Select(NewContactTitle).selectByVisibleText(newContactTitle);
			Log.message("Selected NewContactTitle : " + newContactTitle, driver, extentedReport);			
		} catch (Exception e) {
			throw new Exception("Error while entering NewContactTitle detail : " + e);
		}
	}
	
	public void enterNewContactFirstName(String newContactFirstName, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, NewContactFirstName);
			NewContactFirstName.sendKeys(newContactFirstName);
			Log.message("Entered NewContactFirstName : " + newContactFirstName, driver, extentedReport);			
		} catch (Exception e) {
			throw new Exception("Error while entering NewContactFirstName detail : " + e);
		}
	}
	
	public void enterNewContactLastName(String newContactLastName, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, NewContactLastName);
			NewContactLastName.sendKeys(newContactLastName);
			Log.message("Entered NewContactLastName : " + newContactLastName, driver, extentedReport);			
		} catch (Exception e) {
			throw new Exception("Error while entering NewContactLastName detail : " + e);
		}
	}
	
	public void enterRelationshipToBusiness(String relationshipToBusiness, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, RelationshipToBusiness);
			RelationshipToBusiness.sendKeys(relationshipToBusiness);
			Log.message("Entered RelationshipToBusiness : " + relationshipToBusiness, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering RelationshipToBusiness detail : " + e);
		}
	}
	
	public void Click_BtnAdd(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAdd);
			Actions action = new Actions(driver);
			action.moveToElement(BtnAdd).click().perform();
			//BtnAdd.click();
			WaitUtils.waitForSpinner(driver);	
			Log.message("Clicked Add button", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnAdd: " + e);
		}
	}
	
	public void BtnDeleteEnabled(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnDelete);
			BtnDelete.isEnabled();
			Log.message("Checking Delete button", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while checking BtnDelete is enabled: " + e);
		}
	}
	
	public void Click_BtnDelete(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnDelete);
			BtnDelete.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Delete button", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnDelete: " + e);
		}
	}
	
	public void BtnAddAnotherContactEnabled(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddAnotherContact);
			BtnAddAnotherContact.isEnabled();
			Log.message("Checking AddAnotherContact button", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while checking BtnAddAnotherContact is enabled: " + e);
		}
	}
	
		public void ErrorMsgDisplayed(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, ErrorMsg);
			if(ErrorMsg.isDisplayed()){
			Log.message("ErrorMsg is displaying", driver, extentedReport);
			}else{
			Log.message("ErrorMsg is not displaying", driver, extentedReport);
			throw new Exception("Failed");
			}
		}catch (Exception e) {
			throw new Exception("Error while checking ErrorMsg is displayed: " + e);
		}
	}
	
	public void Click_BtnAddAnotherContact(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddAnotherContact);
			BtnAddAnotherContact.click();
			Log.message("Clicked AddAnotherContact button", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnAddAnotherContact: " + e);
		}
	}
	
	
	public void CheckOutEnabled(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnCheckout);
			btnCheckout.isEnabled();			
		}catch (Exception e) {
			throw new Exception("Error while checking CheckOut button is enabled: " + e);
		}
	}
	
	public Payment Click_CheckOut(ExtentTest extentedReport) throws Exception {
		try {
			//final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnCheckout);
			Actions action = new Actions(driver);
			action.moveToElement(btnCheckout).click().perform();
			//btnCheckout.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked CheckOut button", driver, extentedReport);
			//Log.event("Clicked CheckOut button", StopWatch.elapsedTime(startTime));
			return new Payment(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking CheckOut button: " + e);
		}
	}
		
	public YourQuote Click_BackToQuote(ExtentTest extentedReport) throws Exception {
			try {
				WaitUtils.waitForElement(driver, btnBackToQuote);
				btnBackToQuote.click();
				WaitUtils.waitForSpinner(driver);
				Log.message("Clicked BackToQuote button", driver, extentedReport);
				return new YourQuote(driver, extentedReport);
			} catch (Exception e) {
				throw new Exception("Error while clicking btnBackToQuote : " + e);
			}
		}
	
	public Payment SeasonalStockIncrease_CheckOut(ExtentTest extentedReport) throws Exception {
		try {
			//final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnCheckout);
			Actions action = new Actions(driver);
			action.moveToElement(btnCheckout).click().perform();
			//btnCheckout.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked CheckOut button", driver, extentedReport);
			//Log.event("Clicked CheckOut button", StopWatch.elapsedTime(startTime));
			return new Payment(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking CheckOut button: " + e);
		}
	}
	
	public SeasonalStockIncrease Click_Next(ExtentTest extentedReport) throws Exception {
		try {
			//final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnNext);
			Actions action = new Actions(driver);
			action.moveToElement(btnNext).click().perform();
			//btnCheckout.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnNext button", driver, extentedReport);
			//Log.event("Clicked CheckOut button", StopWatch.elapsedTime(startTime));
			return new SeasonalStockIncrease(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking btnNext button: " + e);
		}
	}
	
}
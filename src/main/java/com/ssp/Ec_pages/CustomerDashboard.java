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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.support.StopWatch;
import com.ssp.utils.DataUtils;
import com.ssp.utils.ElementLayer;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;
import com.ssp.wj_pages.BusinessDetails;
import com.ssp.wj_pages.GeneralInformation;
import com.ssp.wj_pages.PublicLiability;
import com.ssp.wj_pages.YourDetails;

public class CustomerDashboard extends LoadableComponent<CustomerDashboard> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";
	
	//Customer Dashboard Details screen objects
		
	@FindBy(xpath = "//*[@id='C2__C6__row_navdrop']//a[contains(text(), 'Complaints')]")
	WebElement TabComplaints;
	
	@FindBy(xpath = "//a[contains(text(), 'New Complaint')]")
	WebElement newComplaint;
	
	@FindBy(xpath = "//*[@id='date-picker-C2__QUE_7A9224CB87C05DCB250840']")
	WebElement TxtComplaintReportedDate;
	
	@FindBy(xpath = "//*[@id='C2__FS_QUE_7A9224CB87C05DCB250854']//label[contains(text(), 'Non-verbal')]")
	WebElement radioSourceOfComplaint;
	
	@FindBy(css="#C2__QUE_7A9224CB87C05DCB250842")
   	WebElement SelectTCFCategory;
	
	@FindBy(css="#C2__QUE_7A9224CB87C05DCB250856")
   	WebElement SelectTCFDescription;
	
	@FindBy(css="#C2__QUE_7A9224CB87C05DCB250858")
   	WebElement SelectComplaintAgainst;
	
	@FindBy(css="#C2__QUE_7A9224CB87C05DCB250846")
   	WebElement SelectComplaintReason;
	
	@FindBy(css="#C2__QUE_7A9224CB87C05DCB250860")
   	WebElement SelectComplaintType;
	
	@FindBy(css="#C2__QUE_7A9224CB87C05DCB250848")
   	WebElement SelectRespondWithin;
	
	@FindBy(css="#C2__QUE_7A9224CB87C05DCB250862")
   	WebElement TxtClaim;
	
	@FindBy(css="#C2__QUE_7A9224CB87C05DCB250850")
   	WebElement SelectIntermediary;
	
	@FindBy(css="#C2__BUT_7A9224CB87C05DCB2050669")
 	WebElement ButtonSearchHandler;
	
	@FindBy(css="#C2__BUT_7A9224CB87C05DCB2188246_R1")
 	WebElement ButtonSelectHandler;
	
	@FindBy(css="#C2__QUE_7A9224CB87C05DCB250866")
	WebElement TxtDescription;
	
	@FindBy(css="#C2__Complaint-Save")
	WebElement ButtonSave;
	
	@FindBy(css="#C2__QUE_D6C1283CCDB227E91158808")
 	WebElement SelectComplaintConfirmStatus;
	
	@FindBy(css="#C2__QUE_D6C1283CCDB227E91158811")
	WebElement SelectComplaintConfirmReason;
	
	@FindBy(css="#C2__BUT_4F6C7E1EA3A0DE0E11114")
	WebElement ButtonConfirm;
	
	@FindBy(css="#retrieve-complaints")
	WebElement RetrieveComplaints;
	
	@FindBy(css="#C2__QUE_7A9224CB87C05DCB250784")
	WebElement ComplaintRefrence;
	
	@FindBy(xpath="//div[contains(text(), 'Finance')]")
	WebElement TabFinance;
	
	@FindBy(css="#C2__C6__p4_QUE_89ED8F82775D82BB1163895")
	WebElement TxtOutstandingPayment;
	
	@FindBy(xpath="//*[@id = 'Unreconciled_R1']//input")
	WebElement CheckboxOutstandingPayment;
	
	@FindBy(xpath="//button[contains(text(), 'Take Payment')]")
	WebElement ButtonTakePayment;
	
	@FindBy(xpath="//button[contains(text(), 'Take a Payment')]")
	WebElement ButtonTakeAPayment;
	
	@FindBy(css="#main")
	WebElement FramePayment;
	
	@FindBy(css="#C2__C6__QUE_5D69B1F797D9E483296377")
	WebElement TxtNameOnCard;
	
	@FindBy(css="#cardNumber")
	WebElement TxtCardNumber;
	
	@FindBy(css="#expiryMonth")
	WebElement TxtExpiryMonth;
	
	@FindBy(css="#expiryYear")
	WebElement TxtExpiryYear;
	
	@FindBy(css="#securityCode")
	WebElement TxtSecurityCode;
	
	@FindBy(xpath="//input[@id='submitButton']")
	WebElement ButtonMakePayment;
	
	@FindBy(xpath="//div[@id = 'C1__p4_BUT_5866E32A0412B1F922976']//button[contains(text(), 'Close')]")
	WebElement ButtonClose;
	
	@FindBy(xpath="//a[contains(text(), 'Cancel Policy ')]")
	WebElement TabCancelPolicy;
	
	@FindBy(xpath="//div[contains(text(), 'Standard Cancellation')]")
	WebElement StandardCancellation;
	
	@FindBy(css="#date-picker-C2__C6__QUE_8D734F2AC91F8FEB325795")
	WebElement TxtEffectiveDate;
	
	@FindBy(css="#C2__C6__QUE_99ADFDA008E513D23696576")
	WebElement SelectReason;
	
	@FindBy(css="#C2__C6__QUE_99ADFDA008E513D23844242")
	WebElement SelectReturnPremiumType;
	
	@FindBy(xpath="//button[contains(text(), 'Calculate')]")
	WebElement ButtonCalculate;
	
	@FindBy(xpath="//span[contains(text(), 'Add Note')]")
	WebElement ButtonAddNote;
	
	@FindBy(css="#C2__C6__QUE_6626AE11CA31B27E731132")
	WebElement TxtTitle;
	
	@FindBy(css="#C2__C6__QUE_6626AE11CA31B27E731135")
	WebElement TxtNoteDescription;
	
	@FindBy(css="#C2__C6__BUT_6626AE11CA31B27E731273")
	WebElement ButtonNoteSave;
	
	@FindBy(css="#accordian_collapseNine")
	WebElement ViewPolicyNotesExpand;
	
	@FindBy(css="#C2__C5__View-Policy-Notes_R1")
	WebElement ButtonViewNote;
	
	@FindBy(css="#C2__C5__QUE_E64E1567A89655C6560502_R1")
	WebElement CreatedDateOfAddedNote;
	
	@FindBy(css="#C2__C5__QUE_E64E1567A89655C6560506_R1")
	WebElement TitleOfAddedNote;
	
	@FindBy(css="#C2__C5__QUE_E64E1567A89655C6560510_R1")
	WebElement UserIdOfAddedNote;
	
	@FindBy(css="#C2__C5__QUE_BFB16C4031DCD31D95748_R1")
	WebElement DescriptionOfAddedNote;
	
	@FindBy(css="#C2__C5__View-Policy-Notes_R1")
	WebElement ButtonCloseNote;
	
	@FindBy(css="#C2__C5__BUT_8917F8AE6C60014B1257760")
	WebElement ButtonCloseAllNotes;
	
	@FindBy(css="#C2__C6__content")
	WebElement NoteWindow;
	
	@FindBy(xpath="//div[@id='C2__p4_BUT_DB4A6646C4C5D63933681']//button[contains(text(), 'New Quote')]")
	WebElement ButtonNewQuote;
	
	public CustomerDashboard(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public CustomerDashboard(WebDriver driver, ExtentTest report) {
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
	
	public void addNewComplaint(String txtComplaintReportedDate, String selectTCFCategory, String selectTCFDescription, String selectComplaintAgainst, String selectComplaintReason, 
			String selectComplaintType, String selectRespondWithin, String txtClaim, String selectIntermediary, String txtDescription, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TabComplaints);
			TabComplaints.click();
			newComplaint.click();
			WaitUtils.waitForSpinner(driver);
			radioSourceOfComplaint.click();
			ButtonSearchHandler.click();
			WaitUtils.waitForSpinner(driver);
			ButtonSelectHandler.click();
			TxtComplaintReportedDate.sendKeys(txtComplaintReportedDate);
			new Select(SelectTCFCategory).selectByVisibleText(selectTCFCategory);
			WaitUtils.waitForSpinner(driver);
			new Select(SelectTCFDescription).selectByVisibleText(selectTCFDescription);
			new Select(SelectComplaintAgainst).selectByVisibleText(selectComplaintAgainst);
			new Select(SelectComplaintReason).selectByVisibleText(selectComplaintReason);
			new Select(SelectComplaintType).selectByVisibleText(selectComplaintType);
			new Select(SelectRespondWithin).selectByVisibleText(selectRespondWithin);
			TxtClaim.sendKeys(txtClaim);
			new Select(SelectIntermediary).selectByVisibleText(selectIntermediary);
			TxtDescription.sendKeys(txtDescription);
			
			
			Log.message("Complaint details filled " , driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering complaint details: " + e);
		}
	}
	
	public void addNewComplaintFinal(String selectComplaintConfirmStatus, String selectComplaintConfirmReason, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, ButtonSave);
			ButtonSave.click();
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForElement(driver, SelectComplaintConfirmStatus);
			new Select(SelectComplaintConfirmStatus).selectByVisibleText(selectComplaintConfirmStatus);
			new Select(SelectComplaintConfirmReason).selectByVisibleText(selectComplaintConfirmReason);
			ButtonConfirm.click();
			WaitUtils.waitForSpinner(driver);
			TabComplaints.click();
			RetrieveComplaints.click();
			
			Log.message("Complaint created successfully" , driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while confirming complaint details: " + e);
		}
	}
	
	/*public void openURL(){
		driver.get(sspURL);
	}*/
	
	public void addNotes(String txtTitle, String txtNoteDescription, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, ButtonAddNote);
			ButtonAddNote.click();
			WaitUtils.waitForElement(driver, NoteWindow);
			TxtTitle.sendKeys(txtTitle);
			TxtNoteDescription.sendKeys(txtNoteDescription);
			ButtonNoteSave.click();
			WaitUtils.waitForSpinner(driver);
			ViewPolicyNotesExpand.click();
			WaitUtils.waitForSpinner(driver);
			ButtonViewNote.click();
			WaitUtils.waitForElement(driver, DescriptionOfAddedNote);
			String a = TitleOfAddedNote.getText().trim();
			String b = DescriptionOfAddedNote.getText().trim();
			if(a.equals(txtTitle)){
				System.out.println("Added Title is " +a);
				Log.message("Added Title is correct" , driver, extentedReport);
			}
			if(b.equals(txtNoteDescription)){
				System.out.println("Added Desription is " +b);
				Log.message("Added description is correct" , driver, extentedReport);
			}
			
			Log.message("Note created successfully" , driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while confirming note details: " + e);
		}
	}
	
	/*public void openURL(){
	driver.get(sspURL);
}*/
	
	public void NewQuote(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, ButtonNewQuote);
			ButtonNewQuote.click();
			WaitUtils.waitForSpinner(driver);
			
			Log.message("New Quote clicked successfully" , driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking New Quote button: " + e);
		}
	}
	
	/*public void openURL(){
	driver.get(sspURL);
}*/
	
	public void Finance(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TabFinance);
			TabFinance.click();
			WaitUtils.waitForSpinner(driver);
			String a = TxtOutstandingPayment.getText().trim();
			System.out.println("Outstanding Payment is " +a);
			CheckboxOutstandingPayment.click();
			ButtonTakePayment.click();
			WaitUtils.waitForElement(driver, TxtNameOnCard);
			TxtNameOnCard.sendKeys("abc");
			Thread.sleep(5000);
			ButtonTakeAPayment.click();
			Thread.sleep(10000);
			driver.switchTo().frame("wp-cl-custom-html-iframe");
			TxtCardNumber.sendKeys("4444333322221111");
			TxtExpiryMonth.sendKeys("05", "\t");
			TxtExpiryYear.sendKeys("28");
			TxtSecurityCode.sendKeys("128");
			ButtonMakePayment.click();
			Thread.sleep(10000);
			//driver.switchTo().defaultContent();
			//Actions actions = new Actions(driver);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			String bc = "ButtonClose.click()";
			jse.executeScript(bc);
			//actions.moveToElement(ButtonClose).click().perform();
			//WaitUtils.waitForSpinner(driver);
			System.out.println("Updated Outstanding payment is " +a);
			
			Log.message("Take Payment processed successfully" , driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while processing Take Payment: " + e);
		}
	}
	
	/*public void openURL(){
	driver.get(sspURL);
}*/
}
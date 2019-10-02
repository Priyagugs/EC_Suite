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
import com.ssp.utils.DataUtils;
import com.ssp.utils.ElementLayer;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;
import com.ssp.wj_pages.BusinessDetails;
import com.ssp.wj_pages.GeneralInformation;
import com.ssp.wj_pages.PublicLiability;
import com.ssp.wj_pages.YourDetails;


public class SearchDashboard extends LoadableComponent<SearchDashboard> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";
	
	//Search Dashboard Details screen objects
	
	@FindBy(css = "#C2__QUE_57179A1244E6618013741")
	WebElement txtPolicyNo;
	
	@FindBy(css = "#C2__QUE_57179A1244E6618013747")
	WebElement txtExternalQuote;

    @FindBy(css="#C2__BUT_F449F8C15BC15FF9784873")
	WebElement BtnComplete;
    
    @FindBy(css = "#C2__QUE_57179A1244E6618013753")
	WebElement txtLastName;
	
	@FindBy(css = "#C2__QUE_57179A1244E6618013759")
	WebElement txtFirstName;

    @FindBy(css="#C2__QUE_3EEBD499DACB35483315854")
	WebElement txtBusinessName;
    
    @FindBy(css = "#C2__QUE_57179A1244E6618019335")
	WebElement txtPostCode;

    @FindBy(css="#date-picker-C2__QUE_57179A1244E6618019347")
	WebElement txtDateOfBirth;
    
    @FindBy(css="#C2__BUT_57179A1244E6618013765")
   	WebElement btnSearch;
    
    @FindBy(xpath="//*[@id='C2__p0_TBL_5D046CA9B13A360C790789_R1']")
    WebElement BtnAutorizedContacts;
    
    @FindBy(xpath="//button[contains(text(), 'Passed Verification')]")
    WebElement BntSelectPolicytoVerify;
    
    @FindBy(xpath="//*[@id='C2__p0_TBL_9C3BD3DB194DC120259818_R1']")
    WebElement BtnClickContactResults;
 
    
    @FindBy(css="#C2__BUT_57179A1244E6618013773")
   	WebElement btnClearSearch;
    
    @FindBy(css="#C2__BUT_075AC4DA2E63D42D841547")
   	WebElement btnCreateNewCustomer;
	
    @FindBy(css="#C2__BUT_F449F8C15BC15FF9784873")
   	WebElement btnComplete;
    
    //CreateNewCustomer Screen objects
    
    @FindAll({
		@FindBy(xpath = "//*[@id='C2__C1__TXT_65369060E37BB4AE5406638']/div/ul/li/a[contains(text(), 'Personal')]"),
		@FindBy(xpath = "//*[@id='C2__C1__TXT_65369060E37BB4AE5406638']/div/ul/li/a[contains(text(), 'Corporate')]")
		})
	List<WebElement> BtnSelectCustomer;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217316")
   	WebElement selectTitle;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217318")
   	WebElement txt_Personal_FirstName;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217320")
   	WebElement txtMiddleName;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217324")
   	WebElement txt_Personal_LastName;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217324")
   	WebElement SelectSuffix;
	
    @FindBy(css="#date-picker-C2__C1__QUE_B5F37DDFDCE76BB21217326")
   	WebElement txt_DateOfBirth;
    
    @FindAll({
		@FindBy(xpath = "//*[@id='C2__C1__FS_QUE_B5F37DDFDCE76BB21217328']/div//label[contains(text(), 'Male')]"),
		@FindBy(xpath = "//*[@id='C2__C1__FS_QUE_B5F37DDFDCE76BB21217328']/div//label[contains(text(), 'Female')]")
		})
	List<WebElement> BtnSelectGender;
    
    @FindAll({
		@FindBy(xpath = "//*[@id='C2__C1__FS_QUE_B5F37DDFDCE76BB21217334']/div//label[contains(text(), 'Post')]"),
		@FindBy(xpath = "//*[@id='C2__C1__FS_QUE_B5F37DDFDCE76BB21217334']/div//label[contains(text(), 'Email')]"),
		@FindBy(xpath = "//*[@id='C2__C1__FS_QUE_B5F37DDFDCE76BB21217334']/div//label[contains(text(), 'SMS')]")
		})
	List<WebElement> BtnCorrespondence_Preference;
    
    @FindAll({
		@FindBy(xpath = "//*[@id='C2__C1__FS_QUE_B5F37DDFDCE76BB21217342']/div//label[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//*[@id='C2__C1__FS_QUE_B5F37DDFDCE76BB21217342']/div//label[contains(text(), 'No')]")
		})
	List<WebElement> BtnMarketing_Preference;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217360")
   	WebElement txt_Personal_HouseNo;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217362")
   	WebElement txt_Personal_PostCode;
    
    @FindBy(css="#C2__C1__BUT_B5F37DDFDCE76BB21217366")
   	WebElement btnFindAddress;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217382")
   	WebElement txt_Personal_HomeNo;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217384")
   	WebElement txt_Personal_MobileNo;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217384#C2__C1__QUE_B5F37DDFDCE76BB21217386")
   	WebElement txt_Personal_WorkNo;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217390")
   	WebElement txt_Personal_Email;
    
    @FindBy(css="#C2__C1__SaveBtn_Create_New_Personal_Contact")
   	WebElement btnPersonalSave;
    
    @FindBy(css="#C2__C1__CloseBtn_Create_New_Personal_Contact")
   	WebElement btnPersonalCancel;
    
    //Create New Corporate Screen objects
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217400")
   	WebElement txtCorp_businessname;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217402")
   	WebElement txtTradingas;
    
    //Business details objects
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217412")
   	WebElement SeletAddressType;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217414")
   	WebElement txtBuildingNo;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217416")
   	WebElement SelectCountry;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217418")
   	WebElement txtPostcode;
    
    @FindBy(css="#C2__C1__BUT_B5F37DDFDCE76BB21217422")
   	WebElement btnCorpFindAddress;
    
    @FindBy(css="#C2__C1__BUT_B5F37DDFDCE76BB21217424")
   	WebElement btnEnterAddress;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217442")
   	WebElement txtBusinessphoneNo;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217444")
   	WebElement txtBusinessHomeNo;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217446")
   	WebElement txtBusinessMobileNo;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217452")
   	WebElement txtBusinessEmail;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217454")
   	WebElement txtWebsiteAddress;
    
    @FindBy(xpath="//*[@id='C2__C1__QUE_B5F37DDFDCE76BB21217470']")
   	WebElement SelectAuthorized_ContactTitle;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217472")
   	WebElement txtContactFirstName;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217474")
   	WebElement txtContactLastName;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217476")
   	WebElement txtContactMiddleName;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217478")
   	WebElement SelectContactSuffix;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217484")
   	WebElement txtContactHomeNo;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217486")
   	WebElement txtContactWorkNo;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217488")
   	WebElement txtContactMobileNo;
    
    @FindBy(css="#C2__C1__QUE_B5F37DDFDCE76BB21217488")
   	WebElement txtContactEmail;
    
    @FindAll({
		@FindBy(xpath = "//*[@id='C2__C1__row_QUE_B5F37DDFDCE76BB21217496']/div//label[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//*[@id='C2__C1__row_QUE_B5F37DDFDCE76BB21217496']/div//label[contains(text(), 'No')]")
		})
	List<WebElement> BtnCorpMarketing_Preference;
    
    @FindAll({
  		@FindBy(xpath = "//*[@id='C2__C1__FS_QUE_B5F37DDFDCE76BB21217510']/div//label[contains(text(), 'Correspondence by post')]"),
  		@FindBy(xpath = "//*[@id='C2__C1__FS_QUE_B5F37DDFDCE76BB21217510']/div//label[contains(text(), 'Correspondence by email')]")
  		})
  	List<WebElement> BtnCommunication_Preference;
    
    @FindBy(css="#C2__C1__FS_QUE_AE3BD4516663C76F871083")
   	WebElement btnSMSCommunication_Preference;
    
    @FindBy(css="#C2__C1__SaveBtn_Create_New_Corporate_Contact")
   	WebElement btnCorpSave;
    
    @FindBy(css="#C2__C1__CloseBtn_Create_New_Corporate_Contact")
   	WebElement btnCorpCancel;
  
	public SearchDashboard(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public SearchDashboard(WebDriver driver, ExtentTest report) {
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
	
	public void EnterPolicyNumber(String policyno, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtPolicyNo);
			txtPolicyNo.clear();
			txtPolicyNo.sendKeys(policyno, "\t");
			Log.message("Entered Policyno : " + policyno, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering Username: " + e);
		}
	}
	
	public void EnterExternalQuoteRef(String quoteref, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtExternalQuote);
			txtExternalQuote.clear();
			txtExternalQuote.sendKeys(quoteref, "\t");
			Log.message("Entered quoteref : " + quoteref, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering quoteref: " + e);
		}
	}
	
	public void EnterlastName(String lastname, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtLastName);
			txtLastName.clear();
			txtLastName.sendKeys(lastname, "\t");
			Log.message("Entered LastName : " + lastname, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering lastname: " + e);
		}
	}
	
	public void EnterFirstName(String firstname, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtFirstName);
			txtFirstName.clear();
			txtFirstName.sendKeys(firstname, "\t");
			Log.message("Entered Firstname : " + firstname, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering Firstname: " + e);
		}
	}
	
	public void EnterBusinessName(String businessname, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtBusinessName);
			txtBusinessName.clear();
			txtBusinessName.sendKeys(businessname, "\t");
			Log.message("Entered Businessname : " + businessname, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering Businessname: " + e);
		}
	}
	
	public void EnterPostCode(String postcode, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtPostCode);
			txtPostCode.clear();
			txtPostCode.sendKeys(postcode, "\t");
			Log.message("Entered Postcode : " + postcode, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering Postcode: " + e);
		}
	}
	
	public void EnterDateOfBirth(String dateofbirth, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtDateOfBirth);
			txtDateOfBirth.clear();
			txtDateOfBirth.sendKeys(dateofbirth, "\t");
			Log.message("Entered DateOfBirth : " + dateofbirth, driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while entering dateofbirth: " + e);
		}
	}
	
	public void Click_Search(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnSearch,20);
			btnSearch.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnSearch", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnSearch : " + e);
		}
	}
	
	public void Click_ClearSearch(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnClearSearch);
			btnClearSearch.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnClearSearch", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnClearSearch : " + e);
		}
	}
	
	public void Click_Complete(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnComplete);
			btnComplete.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnComplete", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnComplete : " + e);
		}
	}
	
	public void Click_Create_NewCustomer(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnCreateNewCustomer);
			btnCreateNewCustomer.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnCreateNewCustomer", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnCreateNewCustomer : " + e);
		}
	}
	
	public void SelectGender(String btnPersonalGender, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnSelectGender, 2);
			ElementLayer.clickExpectedValue(BtnSelectGender, btnPersonalGender, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnSelectGender; : " + btnPersonalGender, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnSelectGender; : " + e);
		}
	}
	
	public void SelectCustomerType(String btnSelectCustomer, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnSelectCustomer, 2);
			ElementLayer.clickExpectedValue(BtnSelectCustomer, btnSelectCustomer, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnSelectCustomer : " + btnSelectCustomer, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnSelectCustomer : " + e);
		}
	}
	
	public void Select_Correspondence_Preference(String btnCorrespondence_Preference, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnCorrespondence_Preference, 2);
			ElementLayer.clickExpectedValue(BtnCorrespondence_Preference, btnCorrespondence_Preference, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnCorrespondence_Preference : " + btnCorrespondence_Preference, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnCorrespondence_Preference : " + e);
		}
	}
	
	public void Select_Marketing_Preference(String btnMarketing_preference, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnMarketing_Preference, 2);
			ElementLayer.clickExpectedValue(BtnMarketing_Preference, btnMarketing_preference, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnMarketing_Preference : " + btnMarketing_preference, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnMarketing_Preference : " + e);
		}
	}
	
	public void Enter_Personal_FirstName(String PersonalFirstName, ExtentTest extentedReport)throws Exception {
		// TODO Auto-generated method stub
		try {
			WaitUtils.waitForElement(driver, txt_Personal_FirstName);
			txt_Personal_FirstName.clear();
			txt_Personal_FirstName.sendKeys(PersonalFirstName);
			Log.message("Entered CoverStartDate : " + PersonalFirstName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Personal Contact first Name : " + e);
		}
	}
	
	public void Enter_Personal_MiddleName(String MiddleName, ExtentTest extentedReport)throws Exception {
		// TODO Auto-generated method stub
		try {
			WaitUtils.waitForElement(driver, txtMiddleName);
			txtMiddleName.clear();
			txtMiddleName.sendKeys(MiddleName);
			Log.message("Entered txtMiddleName : " + MiddleName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering txtMiddleName : " + e);
		}
	}
	
	public void Enter_Personal_LastName(String PersonalLastName, ExtentTest extentedReport)throws Exception {
		// TODO Auto-generated method stub
		try {
			WaitUtils.waitForElement(driver, txt_Personal_LastName);
			txt_Personal_LastName.clear();
			txt_Personal_LastName.sendKeys(PersonalLastName);
			Log.message("Entered Personal contact LastName : " + PersonalLastName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Personal contact LastName : " + e);
		}
	}
	
	public void Enter_Personal_DateOfBirth(String PersonalDOB, ExtentTest extentedReport)throws Exception {
		// TODO Auto-generated method stub
		try {
			WaitUtils.waitForElement(driver, txt_DateOfBirth);
			txt_DateOfBirth.clear();
			txt_DateOfBirth.sendKeys(PersonalDOB);
			Log.message("Entered Personal DOB : " + PersonalDOB, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Personal DOB : " + e);
		}
	}
	
	public void Enter_Personal_HouseNo(String PersonalHouseNo, ExtentTest extentedReport)throws Exception {
		// TODO Auto-generated method stub
		try {
			WaitUtils.waitForElement(driver, txt_Personal_HouseNo);
			txt_Personal_HouseNo.clear();
			txt_Personal_HouseNo.sendKeys(PersonalHouseNo);
			Log.message("Entered Personal HouseNo : " + PersonalHouseNo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Personal HouseNo : " + e);
		}
	}
	
	public void Enter_Personal_HomeNo(String PersonalHomeNo, ExtentTest extentedReport)throws Exception {
		// TODO Auto-generated method stub
		try {
			WaitUtils.waitForElement(driver, txt_Personal_HomeNo);
			txt_Personal_HomeNo.clear();
			txt_Personal_HomeNo.sendKeys(PersonalHomeNo);
			Log.message("Entered Personal HomeNo : " + PersonalHomeNo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Personal HomeNo : " + e);
		}
	}
	
	public void Enter_Personal_PostCode(String PersonalPostCode, ExtentTest extentedReport)throws Exception {
		// TODO Auto-generated method stub
		try {
			WaitUtils.waitForElement(driver, txt_Personal_PostCode);
			txt_Personal_PostCode.clear();
			txt_Personal_PostCode.sendKeys(PersonalPostCode);
			Log.message("Entered Personal PostCode : " + PersonalPostCode, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Personal PostCode : " + e);
		}
	}
	
	public void Enter_Personal_MobileNo(String PersonalMobileNo, ExtentTest extentedReport)throws Exception {
		// TODO Auto-generated method stub
		try {
			WaitUtils.waitForElement(driver, txt_Personal_MobileNo);
			txt_Personal_MobileNo.clear();
			txt_Personal_MobileNo.sendKeys(PersonalMobileNo);
			Log.message("Entered Personal MobileNo : " + PersonalMobileNo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Personal MobileNo : " + e);
		}
	}
	
	public void Enter_Personal_WorkNo(String PersonalWorkNo, ExtentTest extentedReport)throws Exception {
		// TODO Auto-generated method stub
		try {
			WaitUtils.waitForElement(driver, txt_Personal_WorkNo);
			txt_Personal_WorkNo.clear();
			txt_Personal_WorkNo.sendKeys(PersonalWorkNo);
			Log.message("Entered Personal WorkNo : " + PersonalWorkNo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Personal WorkNo : " + e);
		}
	}
	
	public void Enter_Personal_Email(String PersonalEmail, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txt_Personal_Email);
			txt_Personal_Email.clear();
			txt_Personal_Email.sendKeys(PersonalEmail);
			Log.message("Entered Personal Email : " + PersonalEmail, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Personal Email : " + e);
		}
	}
	
	public void Click_Personal_Save(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnPersonalSave);
			btnPersonalSave.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnPersonalSave", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnPersonalSave : " + e);
		}
	}
	
	public void Click_Personal_Cancel(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnPersonalCancel);
			btnPersonalCancel.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnPersonalCancel", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnPersonalCancel : " + e);
		}
	}
	
	public void Click_AuthorizedContact(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAutorizedContacts);
			BtnAutorizedContacts.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnAutorizedContacts", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnAutorizedContacts : " + e);
		}
	}
	
	
	
	public void Click_ContactsResults(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnClickContactResults);
			BtnClickContactResults.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnClickContactResults", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnClickContactResults : " + e);
		}
	}
	
	public CustomerDashboard Click_PolicytoVerify(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BntSelectPolicytoVerify);
			BntSelectPolicytoVerify.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BntSelectPolicytoVerify", driver, extentedReport);
			return new CustomerDashboard(driver,extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BntSelectPolicytoVerify : " + e);
		}
		
	}
	
	public void EnterCorp_BusinessName(String CorpBusinessName, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtCorp_businessname);
			txtCorp_businessname.clear();
			txtCorp_businessname.sendKeys(CorpBusinessName);
			Log.message("Entered Corporate Business Name : " + CorpBusinessName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Corporate Business Name: " + e);
		}
	}
	
	public void EnterCorp_TradingAs(String txtTradingAs, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtTradingas);
			txtTradingas.clear();
			txtTradingas.sendKeys(txtTradingAs);
			Log.message("Entered Corporate TradingAs : " + txtTradingAs, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Corporate TradingAs : " + e);
		}
	}
	
	public void EnterCorp_BuildingNo(String BuildingNo, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtBuildingNo);
			txtBuildingNo.clear();
			txtBuildingNo.sendKeys(BuildingNo);
			Log.message("Entered Corporate BuildingNo : " + BuildingNo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Corporate BuildingNo : " + e);
		}
	}
	
	public void EnterCorp_PostCode(String corp_postcode, ExtentTest extentedReport)throws Exception {
	
		try {
			WaitUtils.waitForElement(driver, txtPostcode);
			txtPostcode.clear();
			txtPostcode.sendKeys(corp_postcode);
			Log.message("Entered corporate txtPostcode : " + corp_postcode, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering corporate txtPostcode : " + e);
		}
	}
	
	public void EnterCorp_BusinessphoneNo(String BusinessphoneNo, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtBusinessphoneNo);
			txtBusinessphoneNo.clear();
			txtBusinessphoneNo.sendKeys(BusinessphoneNo);
			Log.message("Entered corporate BusinessphoneNo : " + BusinessphoneNo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering corporate BusinessphoneNo : " + e);
		}
	}
	
	public void EnterCorp_BusinessHomeNo(String BusinessHomeNo, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtBusinessHomeNo);
			txtBusinessHomeNo.clear();
			txtBusinessHomeNo.sendKeys(BusinessHomeNo);
			Log.message("Entered corporate BusinessHomeNo : " + BusinessHomeNo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering corporate BusinessHomeNo : " + e);
		}
	}
	
	public void EnterCorp_BusinessMobileNo(String BusinessMobileNo, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtBusinessMobileNo);
			txtBusinessMobileNo.clear();
			txtBusinessMobileNo.sendKeys(BusinessMobileNo);
			Log.message("Entered corporate BusinessMobileNo : " + BusinessMobileNo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering corporate BusinessMobileNo : " + e);
		}
	}
	
	public void EnterCorp_BusinessEmail(String BusinessEmail, ExtentTest extentedReport)throws Exception {
		
		try {
			WaitUtils.waitForElement(driver, txtBusinessEmail);
			txtBusinessEmail.clear();
			String corpemail = DataUtils.getEmail();
			txtBusinessEmail.sendKeys(corpemail);
			Log.message("Entered txtBusinessEmail : " + corpemail, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering txtBusinessEmail : " + e);
		}
	}
	
	
	
	public void EnterCorp_WebsiteAddress(String WebsiteAddress, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtWebsiteAddress);
			txtWebsiteAddress.clear();
			txtWebsiteAddress.sendKeys(WebsiteAddress);
			Log.message("Entered corporate WebsiteAddress : " + WebsiteAddress, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering corporate WebsiteAddress : " + e);
		}
	}
	
	public void EnterCorp_ContactFirstName(String ContactFirstName, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtContactFirstName);
			txtContactFirstName.clear();
			txtContactFirstName.sendKeys(ContactFirstName);
			Log.message("Entered corporate ContactFirstName : " + ContactFirstName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering corporate ContactFirstName : " + e);
		}
	}
	
	public void EnterCorp_ContactLastName(String ContactLastName, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtContactLastName);
			txtContactLastName.clear();
			txtContactLastName.sendKeys(ContactLastName);
			Log.message("Entered corporate ContactLastName : " + ContactLastName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering corporate ContactLastName : " + e);
		}
	}
	
	public void EnterCorp_ContactMiddleName(String ContactMiddleName, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtContactMiddleName);
			txtContactMiddleName.clear();
			txtContactMiddleName.sendKeys(ContactMiddleName);
			Log.message("Entered corporate ContactMiddleName : " + ContactMiddleName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering corporate ContactMiddleName : " + e);
		}
	}
	
	public void EnterCorp_ContactHomeNo(String ContactHomeNo, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtContactHomeNo);
			txtContactHomeNo.clear();
			txtContactHomeNo.sendKeys(ContactHomeNo);
			Log.message("Entered corporate ContactHomeNo : " + ContactHomeNo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering corporate ContactHomeNo : " + e);
		}
	}
	
	public void EnterCorp_ContactWorkNo(String ContactWorkNo, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtContactWorkNo);
			txtContactWorkNo.clear();
			txtContactWorkNo.sendKeys(ContactWorkNo);
			Log.message("Entered corporate ContactWorkNo : " + ContactWorkNo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering corporate ContactWorkNo : " + e);
		}
	}
	
	public void EnterCorp_ContactMobileNo(String ContactMobileNo, ExtentTest extentedReport)throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtContactMobileNo);
			txtContactMobileNo.clear();
			txtContactMobileNo.sendKeys(ContactMobileNo);
			Log.message("Entered corporate ContactMobileNo : " + ContactMobileNo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering corporate ContactMobileNo : " + e);
		}
	}
	
	public void EnterCorp_ContactEmail(String ContactEmail, ExtentTest extentedReport)throws Exception {
		
		try {
			WaitUtils.waitForElement(driver, txtContactEmail);
			txtContactEmail.clear();
			String contactemail = DataUtils.getEmail();
			txtContactEmail.sendKeys(contactemail);
			Log.message("Entered txtContactEmail : " + contactemail, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering txtContactEmail : " + e);
		}
		
	
	}
	public void ClickSMSCommunication_Preference(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnSMSCommunication_Preference);
			btnSMSCommunication_Preference.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnSMSCommunication_Preference", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnSMSCommunication_Preference : " + e);
		}
	}
	
	public Contact Click_btnCorpSave(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnCorpSave);
			btnCorpSave.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnCorpSave", driver, extentedReport);
			return new Contact(driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnCorpSave : " + e);
		}
	}
	
	public void Click_btnCorpCancel(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnCorpCancel);
			btnCorpCancel.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnCorpCancel", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnCorpCancel : " + e);
		}
	}
	
	public void Click_btnEnterAddress(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnEnterAddress);
			btnEnterAddress.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnEnterAddress", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnEnterAddress : " + e);
		}
	}
	
	public void Click_btnCorpFindAddress(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnCorpFindAddress);
			btnCorpFindAddress.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnCorpFindAddress", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnCorpFindAddress : " + e);
		}
	}
	
	public void Click_btnFindAddress(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnFindAddress);
			btnFindAddress.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnFindAddress", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking btnFindAddress : " + e);
		}
	}
	
	public void SelectbtnCorpMarketing_Preference(String btnCorpMarketing_Preference, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnCorpMarketing_Preference, 2);
			ElementLayer.clickExpectedValue(BtnCorpMarketing_Preference, btnCorpMarketing_Preference, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected btnCorpMarketing_Preference : " + btnCorpMarketing_Preference, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnMarketing_Preference : " + e);
		}
	}
	
	public void SelectbtnCommunication_Preference(String btnCommunication_Preference, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnCommunication_Preference, 2);
			ElementLayer.clickExpectedValue(BtnCommunication_Preference, btnCommunication_Preference, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected btnCommunication_Preference : " + btnCommunication_Preference, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting btnCommunication_Preference : " + e);
		}
	}
	
	public void SeletAddressType(String AddressType, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, SeletAddressType);
			new Select(SeletAddressType).selectByVisibleText(AddressType);
			Log.message("Selected AddressType : " + AddressType, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting AddressType : " + e);
		}
	}
	
	public void SelectCountry(String Country, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, SelectCountry);
			new Select(SelectCountry).selectByVisibleText(Country);
			Log.message("Selected Country : " + Country, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting Country : " + e);
		}
	}
	
	public void SelectAuthorized_ContactTitle(String Authorized_ContactTitle, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, SelectAuthorized_ContactTitle,20);
			new Select(SelectAuthorized_ContactTitle).selectByVisibleText(Authorized_ContactTitle);
			Log.message("Selected Authorized_ContactTitle : " + Authorized_ContactTitle, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting Authorized_ContactTitle : " + e);
		}
	}
	
	public void SelectContactSuffix(String ContactSuffix, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, SelectContactSuffix);
			new Select(SelectContactSuffix).selectByVisibleText(ContactSuffix);
			Log.message("Selected ContactSuffix : " + ContactSuffix, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting ContactSuffix : " + e);
		}
	}
	
	public void SelectPersonalSuffix(String Suffix, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, SelectSuffix);
			new Select(SelectSuffix).selectByVisibleText(Suffix);
			Log.message("Selected Suffix : " + Suffix, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting ContactSuffix : " + e);
		}
	}
/*public SearchDashboard Click_Task(String btnSelectTask, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnSelectTask, 2);
			ElementLayer.clickExpectedValue(BtnSelectTask, btnSelectTask, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnSelectTask : " + btnSelectTask, driver, extentedReport);
			return new SearchDashboard(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnSelectTask : " + e);
		}
	}*/
	
	
}
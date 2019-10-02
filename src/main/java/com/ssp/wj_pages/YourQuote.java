package com.ssp.wj_pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.xpath.operations.Or;
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
import com.ssp.utils.ElementLayer;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;

public class YourQuote extends LoadableComponent<YourQuote> {
	

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	//YourQuote screen objects
	@FindBy(css = "#C12__BUT_0B05D8BDF306C9A5532617")
	WebElement btnBack;
	
	@FindBy(css = "#BUT_76F22A8DDE588273708348 > li > a")
	WebElement btnPremiumLumpsum;
	
	/*@FindBy(css = "#C13__BUT_E8AE1FC2C8F53163909220")
	WebElement btnNext;*/
	
	@FindBy(xpath = "//*[@id='C13__BUT_E8AE1FC2C8F53163909211']")
	WebElement btnNext;
	

	@FindBy(css = "#LPMcloseButton-1555319950675-3")
	WebElement btnDiscountClose;
	

	
	/*@FindBy(css = "#C13__BUT_E8AE1FC2C8F53163909220")
	WebElement btnNext;*/
	
	@FindBy(xpath = "//*[@id='C12__p4_BUT_E8AE1FC2C8F53163909220']//button[contains(text(), 'Save & Exit')]")
	WebElement btnSaveExit;
	
	@FindBy(xpath = "//button[contains(text(), 'Review & Confirm')]")
	WebElement btnReviewConfirm;
	
	
	@FindBy(css="#C12__BUT_E8AE1FC2C8F53163909211")
	WebElement btnReviewConfirm1;
	
	@FindBy(xpath = "//*[@id='C12__TXT_E2827522B56174171472276']/div")
	WebElement TxtPremiumAmount;
	
	@FindBy(xpath = "//*[@id='C4__BUT_965BD2C07905F7003509104']")
	WebElement BtnRemoveEmployersLiabilityCover;
	
	@FindAll({
		@FindBy(xpath = "//*[@id='information']//button[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//*[@id='information']//button[contains(text(), 'No')]")
		})
	List<WebElement> BtnSureToRemoveELCover;
	
	//Review & Confirm screen objects
	@FindBy(xpath ="//*[@id='QUE_879C6A11B52E18631000835']")
	WebElement txtEmail;

	@FindBy(xpath ="//*[@id='QUE_5277738F0A35FCEB1667854']")
	WebElement selectTitle;
	
	@FindBy(css = "#QUE_879C6A11B52E18631000853")
	WebElement txtConfirmEmail;
	
	@FindBy(css = "#QUE_879C6A11B52E18631000859")
	WebElement Telephone;
	
	@FindBy(css = "#BUT_879C6A11B52E18633458448")
	WebElement btnContinue;
	
	@FindBy(css = "#BUT_EE05BDDBF71401831310110")
	WebElement btnOk;
	
	@FindBy(xpath = "//*[@id='C11__BUT_99A2BF20ED976E671699479']//span")
	WebElement BtnNamedItems;
	
	@FindBy(css = "#C11__BUT_24D9276FBA6E19C58823888")
	WebElement BtnAddNamedItem;
	
	@FindBy(css = "#C11__QUE_24D9276FBA6E19C58823860")
	WebElement ItemGroup;
	
	@FindBy(css = "#C11__QUE_24D9276FBA6E19C58823862")
	WebElement ItemType;
	
	@FindBy(css = "#C11__QUE_24D9276FBA6E19C58823866")
	WebElement TxtValueOfItem;
	
	@FindBy(css = "#C11__QUE_24D9276FBA6E19C58823868")
	WebElement TxtItemDescription;
	
	@FindBy(css = "#C11__BUT_24D9276FBA6E19C58823872")
	WebElement BtnAddItem;
	
	@FindBy(css = "#C11__QUE_24D9276FBA6E19C58823860_ERRORMESSAGE")
	WebElement ErrorMsgRequiredItemGroup;
	
	@FindBy(css = "#C11__QUE_24D9276FBA6E19C58823862_ERRORMESSAGE")
	WebElement ErrorMsgRequiredItemType;
	
	@FindBy(css = "#C11__QUE_24D9276FBA6E19C58823866_ERRORMESSAGE")
	WebElement ErrorMsgRequiredItemValue;
	
	@FindBy(css = "#C11__QUE_24D9276FBA6E19C58823868_ERRORMESSAGE")
	WebElement ErrorMsgRequiredItemDescription;
	
	@FindBy(xpath = "//*[@id='C11__TXT_39E14F922347226D567804']//div[contains(text(), 'Item')]")
	WebElement HeaderItem;
	
	@FindBy(xpath = "//*[@id='C11__TXT_39E14F922347226D567804']//div[contains(text(), 'Value')]")
	WebElement HeaderValue;
	
	@FindBy(xpath = "//*[@id='C11__TXT_39E14F922347226D567804']//div[contains(text(), 'Excess')]")
	WebElement HeaderExcess;

	
	@FindBy(css = "#C11__BUT_99A2BF20ED976E674072284")
	WebElement BtnAddAnotherItem;
	
	@FindBy(css = "#C11__QUE_99A2BF20ED976E671699251")
	WebElement txtBusinessTools;
	
	
	@FindBy(xpath = "//*[@id='C11__BUT_99A2BF20ED976E671699270']/span")
	WebElement btnAddBusinessTools;
	
	@FindBy(xpath = "//*[@id='C11__propertyAway']/div//div/p[contains(text(), 'Named items with a value over £2,500')]")
	WebElement AutoIncludeCover;
	
	@FindBy(xpath = "//*[@id='C11__QUE_99A2BF20ED976E671699454']/p[contains(text(), 'Named items with a value over £2,500')]")
	WebElement NamedItemwithvalue;
	
	
	@FindBy(xpath = "//*[@id='C11__TXT_B27861E7D1B6D9CA2755374']/div/div/strong")
	WebElement txtLiketoinsureYourAddress;
	
	@FindBy(css = "#C1__BUT_2913A5FDBA5243B93675222")
	WebElement BtnGobackandeditmyquote;
		
	@FindBy(css = "#C1__p1_HEAD_2913A5FDBA5243B92097405 > div")
	WebElement txtReferalGenearted;
	
	public YourQuote(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public YourQuote(WebDriver driver, ExtentTest report) {
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
	
	public void PremiumAmount(ExtentTest extentedReport) throws Exception {
		
		try{
			WaitUtils.waitForElement(driver, TxtPremiumAmount, 8);
			Thread.sleep(5000);
			Log.message("Premium Amount : " + TxtPremiumAmount.getText(), driver, extentedReport);
		
		}catch (Exception e) {
			throw new Exception("Error while capturing TxtPremiumAmount : " + e);
		}
	}
	
	public void RemoveEmployersLiabilityCover(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnRemoveEmployersLiabilityCover);
			BtnRemoveEmployersLiabilityCover.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnRemoveEmployersLiabilityCover", driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while clicking BtnRemoveEmployersLiabilityCover : " + e);
		}
	}
	
	public void SureToRemoveELCover(String btnSureToRemoveELCover, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnSureToRemoveELCover, 2);
			ElementLayer.clickExpectedValue(BtnSureToRemoveELCover, btnSureToRemoveELCover, extentedReport, driver);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected BtnSureToRemoveELCover : " + btnSureToRemoveELCover, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnSureToRemoveELCover : " + e);
		}
	}
	
	public void selectTitle(String Title, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, selectTitle);
			new Select(selectTitle).selectByVisibleText(Title);
			Log.message("Selected Title : " + Title, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting Title : " + e);
		}
	}
	
		public void enterConfirmEmail(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtConfirmEmail);
			txtConfirmEmail.clear();
			String email = (txtEmail.getAttribute("value"));
			txtConfirmEmail.sendKeys(email);
			Log.message("Entered txtConfirmEmail : " + email, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering ConfirmEmail : " + e);
		}
	}
	
	public void NamedItems(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnNamedItems);
			BtnNamedItems.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnNamedItems", driver, extentedReport);
			
			WaitUtils.waitForElement(driver, BtnAddNamedItem);
			BtnAddNamedItem.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnAddNamedItem", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnNameItems : " + e);
		}
	}
	
	public void selectItemGroup(String itemGroup, ExtentTest extentedReport) throws Exception {
		try {
			
			WaitUtils.waitForElement(driver, ItemGroup);
		    new Select(ItemGroup).selectByVisibleText(itemGroup);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected ItemGroup : " + itemGroup, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting ItemGroup : " + e);
		}
	}
	
	public void selectItemType(String itemType, ExtentTest extentedReport) throws Exception {
		try {
			
			WaitUtils.waitForElement(driver, ItemType);
			new Select(ItemType).selectByVisibleText(itemType);
			WaitUtils.waitForSpinner(driver);
			Log.message("Selected ItemType : " + itemType, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting ItemType : " + e);
		}
	}
	
	public void ValueOfItem(String txtValueOfItem, ExtentTest extentedReport) throws Exception {
		try {
			
			WaitUtils.waitForElement(driver, TxtValueOfItem);
			TxtValueOfItem.clear();
			TxtValueOfItem.sendKeys(txtValueOfItem);
			Log.message("Entered ValueOfItem : " + txtValueOfItem, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering ValueOfItem : " + e);
		}
	}
	
	public void ItemDescription(String txtItemDescription, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForElement(driver, TxtItemDescription);
			TxtItemDescription.clear();
			TxtItemDescription.sendKeys(txtItemDescription);
			Log.message("Entered ItemDescription : " + txtItemDescription, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering ItemDescription : " + e);
		}
	}
	
	public void AddItem(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddItem);
			BtnAddItem.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnAddItem", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAddItem : " + e);
		}
	}
	
	public void RequiredItemGroup(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, ErrorMsgRequiredItemGroup);
			if(ErrorMsgRequiredItemGroup.isDisplayed()){
			Log.message("Checked ItemGroup Required error msg is displaying", driver, extentedReport);	
			}else{
			Log.message("Checked ItemGroup Required error msg is not displaying", driver, extentedReport);
			throw new Exception("Failed");
			}
		}catch (Exception e) {
			throw new Exception("Error while checking ItemGroup Required error msg: " + e);
		}
	}
	
	public void RequiredItemType(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, ErrorMsgRequiredItemType);
			if(ErrorMsgRequiredItemType.isDisplayed()){
			Log.message("Checked ItemType Required error msg is displaying", driver, extentedReport);	
			}else{
			Log.message("Checked ItemType Required error msg is not displaying", driver, extentedReport);
			throw new Exception("Failed");
			}
		}catch (Exception e) {
			throw new Exception("Error while checking ItemType Required error msg: " + e);
		}
	}
	
	public void RequiredItemValue(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, ErrorMsgRequiredItemValue);
			if(ErrorMsgRequiredItemValue.isDisplayed()){			
			Log.message("Checked ItemValue Required error msg is displaying", driver, extentedReport);
			}else{
			Log.message("Checked ItemValue Required error msg is not displaying", driver, extentedReport);	
			throw new Exception("Failed");
			}
		}catch (Exception e) {
			throw new Exception("Error while checking ItemValue Required error msg: " + e);
		}
	}
	
	public void RequiredItemDescription(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, ErrorMsgRequiredItemDescription);
			if(ErrorMsgRequiredItemDescription.isDisplayed()){
			Log.message("Checked ItemDescription Required error msg is displaying", driver, extentedReport);
			}else{
			Log.message("Checked ItemDescription Required error msg is not displaying", driver, extentedReport);	
			throw new Exception("Failed");
			}
		}catch (Exception e) {
			throw new Exception("Error while checking ItemDescription Required error msg: " + e);
		}
	}
	
public void HeadersDisplayed(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, HeaderItem);
			if(HeaderItem.isDisplayed() & HeaderValue.isDisplayed() & HeaderExcess.isDisplayed()){			
			Log.message("Checked Headers are displaying", driver, extentedReport);
			}else{
			Log.message("Checked Headers are not displaying", driver, extentedReport);
			throw new Exception("Failed");
			}
		}catch (Exception e) {
			throw new Exception("Error while checking Headers " + e);
		}
	}
	
	public void AddAnotherItem(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddAnotherItem);
			BtnAddAnotherItem.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnAddAnotherItem", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAddAnotherItem : " + e);
		}
	}
	
		public GeneralInformation clickBack(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnBack);
			btnBack.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Back button", driver, extentedReport);
			return new GeneralInformation(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Back button: " + e);
		}
	}
	
	public void EnterBusinessToolsandEquipments(String BusinessToolsandEquipments , ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtBusinessTools);
			txtBusinessTools.clear();
			txtBusinessTools.sendKeys(BusinessToolsandEquipments);
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForElement(driver, txtLiketoinsureYourAddress);
			txtLiketoinsureYourAddress.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered BusinessToolsandEquipments : " + BusinessToolsandEquipments, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering BusinessToolsandEquipments : " + e);
		}
	}
	
	public void AddBusinessToolsandEquipments(ExtentTest extentedReport) throws Exception {
		try {
		
			
			WaitUtils.waitForElement(driver, btnAddBusinessTools);
			btnAddBusinessTools.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnAddBusinessTools", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking btnAddBusinessTools : " + e);
		}
	}
	
	public void VerifyCoverAutoIncluded(ExtentTest extentedReport) throws Exception {
		try {
			
			WaitUtils.waitForElement(driver, NamedItemwithvalue);
			if(NamedItemwithvalue.isDisplayed())
			{
				Log.message("Verified Named items with a value over £2,500 has not been auto included", driver, extentedReport);
			}
			else{
				Log.message("Error while Verifying Named items", driver, extentedReport);
				throw new Exception("Failed");
				}
			 }
			
		catch (Exception e) {
			throw new Exception("Error while Verifying Named items : " + e);
		}

	}
	
	public void VerifyReviewConfirmDisplayed(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnReviewConfirm);
			if(btnReviewConfirm.isDisplayed())
			{
				Log.message("Verified Correct Error message is displayed in UXP after removing cover sections from the quote screens. ", driver, extentedReport);
			}
			else
			{Log.message("rror while Verfying Error message is displayed in UXP after removing cover sections from the quote screens.", driver, extentedReport);
			throw new Exception("Failed");
				
			}
			}
			
		catch (Exception e) {
			throw new Exception("Error while Verfying Error message is displayed in UXP after removing cover sections from the quote screens. : " + e);
		}

	}
	public void clickTelephoneNumber(ExtentTest extentedReport) throws Exception {
		try {
			
			WaitUtils.waitForElement(driver, Telephone);
			Telephone.click();
			Log.message("Clicked Telephone", driver, extentedReport);
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while clicking Telephone: " + e);
		}
	}
	
	public void clickSaveExit(ExtentTest extentedReport) throws Exception {
		try {
			
			WaitUtils.waitForElement(driver, btnSaveExit);
			btnSaveExit.click();
			Log.message("Clicked Save & Exit button", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking Save & Exit button: " + e);
		}
	}
	
	public void SelectlumpsumPremium(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnPremiumLumpsum);
			btnPremiumLumpsum.click();
			Log.message("Clicked btnPremiumLumpsum button", driver, extentedReport);
			WaitUtils.waitForSpinner(driver);		
		} catch (Exception e) {
			throw new Exception("Error while clicking btnPremiumLumpsum : " + e);
		}
		
	}
	
	public void Click_Next(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnNext);
			btnNext.click();
			Log.message("Clicked btnNext button", driver, extentedReport);
			WaitUtils.waitForSpinner(driver);		
		} catch (Exception e) {
			throw new Exception("Error while clicking btnNext : " + e);
		}
		
	}
	
	public void clickReviewConfirm(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnReviewConfirm);
			btnReviewConfirm.click();
			Log.message("Clicked Review & Confirm button", driver, extentedReport);
			WaitUtils.waitForSpinner(driver);		
		} catch (Exception e) {
			throw new Exception("Error while clicking Review & Confirm button: " + e);
		}
		
	}
	public void clickContinue(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnContinue);
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.moveToElement(btnContinue).click().perform();
			//btnContinue.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Continue button", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking Continue button: " + e);
		}
	}
	
	public YourDetails Click_OK(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnOk);
			//JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("arguments[0].click();", btnOk);
			btnOk.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Ok button", driver, extentedReport);
			return new YourDetails(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Ok button: " + e);
		}
		
	}
	
	public void VerifyReferalGenerated(ExtentTest extentedReport) throws Exception {
		try {
			String referal_text="We need a few more details - please call us about your Hair and beauty therapist Insurance";
			WaitUtils.waitForElement(driver, txtReferalGenearted);
			if(txtReferalGenearted.isDisplayed())
			{
				if(txtReferalGenearted.getText().equalsIgnoreCase(referal_text))
				{
				Log.message("Verified Referal is getting generated", driver, extentedReport);
				}
			}
			else{
				Log.message("Error while Verifying Referal generating", driver, extentedReport);
				throw new Exception("Failed");
				}
			 }
			
		catch (Exception e) {
			throw new Exception("Error while Verifying Referal generating : " + e);
		}

	}
	
	public GeneralInformation ClickGoBackandEdiMyQuote(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnGobackandeditmyquote);
			//JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("arguments[0].click();", btnOk);
			BtnGobackandeditmyquote.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked GoBackandEdiMyQuote button", driver, extentedReport);
			return new GeneralInformation(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking GoBackandEdiMyQuote button: " + e);
		}
	}
	
	public YourDetails clickReviewConfirm_YourDetailsPage(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnReviewConfirm1,30);
			//JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("arguments[0].click();", btnOk);
			btnReviewConfirm1.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnReviewConfirm button", driver, extentedReport);
			return new YourDetails(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking btnReviewConfirm button: " + e);
		}
	}
	
	/*public YourDetails ClickNext(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForElement(driver, btnNext,50);
			//JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("arguments[0].click();", btnOk);
			btnNext.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnNext button", driver, extentedReport);
			return new YourDetails(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking btnNext button: " + e);
		}
	}*/
	
	public void Click_Discount_Close(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnDiscountClose);
			Actions actions = new Actions(driver);
			actions.moveToElement(btnDiscountClose).click().perform();
			//btnDiscountClose.click();
			Log.message("Clicked btnDiscountClose button", driver, extentedReport);
			WaitUtils.waitForSpinner(driver);		
		} catch (Exception e) {
			throw new Exception("Error while clicking btnDiscountClose : " + e);
		}
		
	}

	public YourDetails ClickNext(ExtentTest extentedReport) throws Exception {
		try {
			
			WaitUtils.waitForElement(driver, btnNext,50);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", btnNext);
		//	Actions actions = new Actions(driver);
			//actions.moveToElement(btnNext).click().perform();
		//	btnNext.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked btnNext button", driver, extentedReport);
			return new YourDetails(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking btnNext button: " + e);
		}
	}

	

	
	
}
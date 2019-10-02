package com.ssp.wj_pages;

import java.util.List;
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

public class BusinessPremises extends LoadableComponent<BusinessPremises> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";
	
	//Business Premises screen objects
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_BAF1DDD82A6337E92573404']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_BAF1DDD82A6337E92573404']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_BAF1DDD82A6337E92573404']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_BAF1DDD82A6337E92573404']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnAnyBusinessPremises;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_B4117896CA807EC2759450_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_B4117896CA807EC2759450_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_B4117896CA807EC2759450_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_B4117896CA807EC2759450_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnBusinessPremisesAddress;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_ADFA26B138E8374B565428_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_ADFA26B138E8374B565428_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_ADFA26B138E8374B565428_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_ADFA26B138E8374B565428_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnAnyOtherActivites;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_C52562CE2C2637941591450_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_C52562CE2C2637941591450_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_C52562CE2C2637941591450_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_C52562CE2C2637941591450_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnAlcoholLicensedAtPremises;
	
	@FindBy(css = "#C8__QUE_487C210376DC00A33351376_R1,#C9__QUE_487C210376DC00A33351376_R1")
	WebElement PremisesType;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_487C210376DC00A33351407_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_487C210376DC00A33351407_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_487C210376DC00A33351404_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_487C210376DC00A33351404_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_487C210376DC00A33351407_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_487C210376DC00A33351407_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_487C210376DC00A33351404_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_487C210376DC00A33351404_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnPremisesOccupied;
	
	@FindAll({
	@FindBy(xpath = "//*[@id='checkbox_C8__QUE_487C210376DC00A33351418_R1']//span[contains(text(), 'I will not be trading at the premises from the start date of my policy')]"),
	@FindBy(xpath = "//*[@id='checkbox_C8__QUE_487C210376DC00A33351418_R1']//span[contains(text(), 'The premises will be unoccupied when the policy starts')]"),
	@FindBy(xpath = "//*[@id='checkbox_C8__QUE_487C210376DC00A33351418_R1']//span[contains(text(), 'During the year, the premises will be unoccupied for more than 30 consecutive days')]"),
	@FindBy(xpath = "//*[@id='checkbox_C8__QUE_487C210376DC00A33351418_R1']//span[contains(text(), 'None of the above')]"),
	@FindBy(xpath = "//*[@id='checkbox_C9__QUE_487C210376DC00A33351418_R1']//span[contains(text(), 'I will not be trading at the premises from the start date of my policy')]"),
	@FindBy(xpath = "//*[@id='checkbox_C9__QUE_487C210376DC00A33351418_R1']//span[contains(text(), 'The premises will be unoccupied when the policy starts')]"),
	@FindBy(xpath = "//*[@id='checkbox_C9__QUE_487C210376DC00A33351418_R1']//span[contains(text(), 'During the year, the premises will be unoccupied for more than 30 consecutive days')]"),
	@FindBy(xpath = "//*[@id='checkbox_C9__QUE_487C210376DC00A33351418_R1']//span[contains(text(), 'None of the above')]")
		})
	List<WebElement> BusinessApplies;
	
	@FindBy(css = "#C8__QUE_487C210376DC00A33351421_R1,#C9__QUE_487C210376DC00A33351421_R1")
	WebElement BtnPremisesATM;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_487C210376DC00A33351423_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_487C210376DC00A33351423_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_487C210376DC00A33351423_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_487C210376DC00A33351423_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnAnyOutbuildingCovers;
	
	@FindBy(css = "#C8__QUE_1AD6973D247511431021240_R1,#C8__QUE_1AD6973D247511431021240_R1")
	WebElement BuildingUsedFor;
	
	@FindBy(css = "#C8__QUE_986DDA71FAE05BED355864_R1,#C8__QUE_986DDA71FAE05BED355864_R1")
	WebElement BedroomsNumber;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_F5A203272682B5E7508551_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_F5A203272682B5E7508551_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_F5A203272682B5E7508551_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_F5A203272682B5E7508551_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnSelfCateringFacilities;
	
	@FindBy(css = "#C8__BUT_487C210376DC00A33351450_R1,#C9__BUT_487C210376DC00A33351450_R1")
	WebElement BtnAddBuildingCover;
	
	@FindBy(css = "#C8__QUE_487C210376DC00A33351442_R1,#C9__QUE_487C210376DC00A33351442_R1")
	WebElement TxtAddBuildingCover;
	
	
	@FindBy(css = "#C8__BUT_487C210376DC00A33351584_R1,#C9__BUT_487C210376DC00A33351584_R1")
	WebElement BtnAddBusinessContentCover;
	
	@FindBy(css = "#C8__QUE_487C210376DC00A33351576_R1,#C9__QUE_487C210376DC00A33351576_R1")
	WebElement TxtAddBusinessContentCover;
	
	@FindBy(css = "#C8__QUE_487C210376DC00A33351721_R1,#C9__QUE_487C210376DC00A33351721_R1")
	WebElement BuildingType;
	
	@FindBy(css = "#C8__QUE_487C210376DC00A33351723_R1,#C9__QUE_487C210376DC00A33351723_R1")
	WebElement PropertyBuiltYear;
	
	@FindBy(css = "#C8__BUT_487C210376DC00A33351514_R1,#C9__BUT_487C210376DC00A33351514_R1")
	WebElement BtnAddOutbuildingsBuildingCover;
	
	@FindBy(css = "#C8__BUT_487C210376DC00A33351648_R1,#C9__BUT_487C210376DC00A33351648_R1")
	WebElement BtnAddOutbuilidngsBusinessContents;
	
	@FindBy(css = "#C8__BUT_487C210376DC00A33351604_R1,#C9__BUT_487C210376DC00A33351604_R1")
	WebElement BtnMainBuildingYourStock;
	
	@FindBy(css = "#C8__BUT_487C210376DC00A33351624_R1,#C9__BUT_487C210376DC00A33351624_R1")
	WebElement BtnAddMainBuildingHousholdContents;
	
	@FindBy(css = "#C8__BUT_487C210376DC00A33351668_R1,#C9__BUT_487C210376DC00A33351668_R1")
	WebElement BtnAddOutbuildingsYourStock;
	
	@FindBy(css = "#C8__BUT_487C210376DC00A33351688_R1,#C9__BUT_487C210376DC00A33351688_R1")
	WebElement BtnAddOutbuildingsHousholdContents;
	
	@FindBy(css = "#C8__QUE_487C210376DC00A33351506_R1,#C9__QUE_487C210376DC00A33351506_R1")
	WebElement txtOutbuildingsBuildingCover;
	
	@FindBy(css = "#C8__QUE_487C210376DC00A33351640_R1,#C9__QUE_487C210376DC00A33351640_R1")
	WebElement txtOutbuilidngsBusinessContents;
	
	@FindBy(css = "#C8__QUE_487C210376DC00A33351596_R1,#C9__QUE_487C210376DC00A33351596_R1")
	WebElement txtMainBuildingYourStock;
	
	@FindBy(css = "#C8__main_household_content_R1,#C9__main_household_content_R1")
	WebElement txtMainBuildingHousholdContents;
	
	@FindBy(css = "#C8__QUE_487C210376DC00A33351660_R1,#C9__QUE_487C210376DC00A33351660_R1")
	WebElement txtOutbuildingsYourStock;
	
	@FindBy(css = "#C8__outter_household_content_R1,#C9__outter_household_content_R1")
	WebElement txtOutbuildingsHousholdContents;
	
	@FindBy(css = "#C8__BUT_880160F8F183EC16836993_R1,#C9__BUT_880160F8F183EC16836993_R1")
	WebElement BtnAddItemMoreThan2500£;
	
	@FindBy(css = "#C8__QUE_880160F8F183EC16674655,#C9__QUE_880160F8F183EC16674655")
	WebElement SelectTypeofIem;
	
	@FindBy(css = "#C8__QUE_880160F8F183EC16674665,#C9__QUE_880160F8F183EC16674665")
	WebElement txtValueofItem;
	
	@FindBy(css = "#C8__QUE_880160F8F183EC16674670,#C9__QUE_880160F8F183EC16674670")
	WebElement txtItemDescription;
	
	@FindBy(css = "#C8__BUT_880160F8F183EC16674764,#C9__BUT_880160F8F183EC16674764")
	WebElement BtnAddNamedItems;
	
	@FindBy(css = "#C8__BUT_487C210376DC00A33351446_R1,#C9__BUT_487C210376DC00A33351446_R1")
	WebElement BtnRemoveBuildingCover;
	
	@FindBy(css = "#C8__BUT_487C210376DC00A33351580_R1,#C9__BUT_487C210376DC00A33351580_R1")
	WebElement BtnRemoveBusinessContentsCover;
	
	@FindBy(css = "#C8__BUT_487C210376DC00A33351600_R1,#C9__BUT_487C210376DC00A33351600_R1")
	WebElement BtnRemoveYourStockCover;
	
	@FindBy(css = "#C8__BUT_487C210376DC00A33351620_R1,#C9__BUT_487C210376DC00A33351620_R1")
	WebElement BtnRemoveHousholdContentsCover;

	
	@FindBy(xpath = "//*[@id='p4_QUE_F1AFB36AC27BEA642943621_R1']/div")
	WebElement BuildingHasAmountForContentsValidationMessage;	
	
	@FindAll({
		@FindBy(xpath = "//*[@id='C8__row_namedItem_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//*[@id='C8__row_namedItem_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//*[@id='C9__row_namedItem_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//*[@id='C9__row_namedItem_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnItemMoreThan2500£;
	
	@FindAll({
		@FindBy(xpath = "//*[@id='C8__row_QUE_FC0945D6732BAE231299027']//span[contains(text(), 'Main Buildin')]"),
		@FindBy(xpath = "//*[@id='C8__row_QUE_FC0945D6732BAE231299027']//span[contains(text(), 'Outbuildings')]"),
		@FindBy(xpath = "//*[@id='C9__row_QUE_FC0945D6732BAE231299027']//span[contains(text(), 'Main Buildin')]"),
		@FindBy(xpath = "//*[@id='C9__row_QUE_FC0945D6732BAE231299027']//span[contains(text(), 'Outbuildings')]")
		})
	List<WebElement> BtnKeptNamedItemAt;
	
	
	@FindAll({
		@FindBy(xpath = "//*[@id='C8__row_QUE_2C52FB4E7723E7D53616194_R1']//span[contains(text(), 'CCTV with 24 hour recording')]"),
		@FindBy(xpath = "//*[@id='C8__row_QUE_2C52FB4E7723E7D53616194_R1']//span[contains(text(), 'Burglar alarm')]"),
		@FindBy(xpath = "//*[@id='C8__row_QUE_2C52FB4E7723E7D53616194_R1']//span[contains(text(), 'None of the above')]"),
		@FindBy(xpath = "//*[@id='C9__row_QUE_2C52FB4E7723E7D53616194_R1']//span[contains(text(), 'CCTV with 24 hour recording')]"),
		@FindBy(xpath = "//*[@id='C9__row_QUE_2C52FB4E7723E7D53616194_R1']//span[contains(text(), 'Burglar alarm')]"),
		@FindBy(xpath = "//*[@id='C9__row_QUE_2C52FB4E7723E7D53616194_R1']//span[contains(text(), 'None of the above')]")
		})
	List<WebElement> BtnSecurityFeatures;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'C8__row_QUE_487C210376DC00A33351835_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C8__row_QUE_487C210376DC00A33351835_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'C9__row_QUE_487C210376DC00A33351835_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C9__row_QUE_487C210376DC00A33351835_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnOutbuildingsGrade1Premises;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__wallMaterialTimberOB_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__wallMaterialTimberOB_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__wallMaterialTimberOB_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__wallMaterialTimberOB_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnOutbuilidingsWallMaterial;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'C8__row_roofMaterialOB_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C8__row_roofMaterialOB_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'C9__row_roofMaterialOB_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C9__row_roofMaterialOB_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnOutbuildingsRoofMaterial;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'C8__row_heatingList3_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C8__row_heatingList3_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'C8__row_heatingList3_R1']//span[contains(text(), 'Not heated')]"),
		@FindBy(xpath = "//div[@id = 'C9__row_heatingList3_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C9__row_heatingList3_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'C9__row_heatingList3_R1']//span[contains(text(), 'Not heated')]")
		})
	List<WebElement> BtnOutbuildingsHeatingList;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'C8__row_heatingList_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C8__row_heatingList_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'C8__row_heatingList_R1 ']//span[contains(text(), 'Not heated')]"),
		@FindBy(xpath = "//div[@id = 'C9__row_heatingList_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'C9__row_heatingList_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'C9__row_heatingList_R1 ']//span[contains(text(), 'Not heated')]")
		})
	List<WebElement> BtnOtherthanFireplaceHeatingList;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_487C210376DC00A33351725_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_487C210376DC00A33351725_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_487C210376DC00A33351725_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_487C210376DC00A33351725_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnGrade1Premises;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__wallMaterialTimber_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__wallMaterialTimber_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__wallMaterial_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__wallMaterial_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__wallMaterialTimber_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__wallMaterialTimber_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__wallMaterial_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__wallMaterial_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnWallMaterial;

	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__roofMaterial_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__roofMaterial_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__roofMaterial_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__roofMaterial_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnRoofMaterial;
	
@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__heatingList_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__heatingList_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__heatingList_R1']//span[contains(text(), 'Not heated')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__heatingList2_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__heatingList2_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__heatingList2_R1']//span[contains(text(), 'Not heated')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__heatingList_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__heatingList_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__heatingList_R1']//span[contains(text(), 'Not heated')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__heatingList2_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__heatingList2_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__heatingList2_R1']//span[contains(text(), 'Not heated')]")
		})
	List<WebElement> BtnHeatingList;

	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_487C210376DC00A33351804_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_487C210376DC00A33351804_R1']//span[contains(text(), 'No')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_487C210376DC00A33351804_R1']//span[contains(text(), 'Yes')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_487C210376DC00A33351804_R1']//span[contains(text(), 'No')]")
		})
	List<WebElement> BtnSubsidenceCover;
	
	@FindAll({
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_081B7A67BC5B17F91541469_R1']//p[contains(text(), 'I agree')]"),
		@FindBy(xpath = "//div[@id = 'radio_C8__QUE_081B7A67BC5B17F91541469_R1']//p[contains(text(), 'I disagree')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_081B7A67BC5B17F91541469_R1']//p[contains(text(), 'I agree')]"),
		@FindBy(xpath = "//div[@id = 'radio_C9__QUE_081B7A67BC5B17F91541469_R1']//p[contains(text(), 'I disagree')]")
		})
	List<WebElement> BtnTermsandConditions;
	
	//*[@id="radio_C9__QUE_081B7A67BC5B17F91541469_R1"]//p[contains(text(), 'I disagree')]
	
	@FindBy(css = "#C8__btntest-click,#C9__btntest-click")
	WebElement BtnNext;
	
	
	public BusinessPremises(WebDriver driver, String url, ExtentTest report) {
		this(driver, report);
		sspURL = url;
		
	}	
	
	public BusinessPremises(WebDriver driver, ExtentTest report) {
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
	
	
	public void AnyBusinesspremises(String btnAnyBusinessPremises, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnAnyBusinessPremises, 5);
			ElementLayer.clickExpectedValue(BtnAnyBusinessPremises, btnAnyBusinessPremises, extentedReport, driver);
			Log.message("Selected BtnAnyBusinessPremises : " + btnAnyBusinessPremises, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnAnyBusinessPremises : " + e);
		}
	}
	
	public void BusinessPremisesAddress(String btnBusinessPremisesAddress, ExtentTest extentedReport) throws Exception{
		try{
		WaitUtils.waitForListElement(driver, BtnBusinessPremisesAddress, 5);
		ElementLayer.clickExpectedValue(BtnBusinessPremisesAddress, btnBusinessPremisesAddress, extentedReport, driver);
		Log.message("Selected BtnBusinessPremisesAddress : " + btnBusinessPremisesAddress, driver, extentedReport);	
		WaitUtils.waitForSpinner(driver);
		}catch (Exception e) {
		throw new Exception("Error while selecting BtnBusinessPremisesAddress : " + e);
		}
	}
	
	public void AnyOtherActivities(String btnAnyOtherActivities, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnAnyOtherActivites, 3);
			ElementLayer.clickExpectedValue(BtnAnyOtherActivites, btnAnyOtherActivities, extentedReport, driver);
			Log.message("Selected BtnAnyOtherActivites : " + btnAnyOtherActivities, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnAnyOtherActivites : " + e);
		}
	}
	
	public void AlcoholLicensedAtPremises(String btnAlcoholLicensedAtPremises, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnAlcoholLicensedAtPremises, 3);
			ElementLayer.clickExpectedValue(BtnAlcoholLicensedAtPremises, btnAlcoholLicensedAtPremises, extentedReport, driver);
			Log.message("Selected BtnAlcoholLicensedAtPremises : " + btnAlcoholLicensedAtPremises, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnAlcoholLicensedAtPremises : " + e);
		}
	}

	public void PremisesType(String premisesType, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, PremisesType);
			new Select(PremisesType).selectByVisibleText(premisesType);
			Log.message("Selected PremisesType : " + premisesType, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnBusinessRunNext : " + e);
		}
	}
	
	public void PremisesOccupied(String btnPremisesOccupied, ExtentTest extentedReport) throws Exception{
		try{
			WaitUtils.waitForListElement(driver, BtnPremisesOccupied, 3);
			ElementLayer.clickExpectedValue(BtnPremisesOccupied, btnPremisesOccupied, extentedReport, driver);
			Log.message("Selected PremisesOccupied : " + btnPremisesOccupied, driver, extentedReport);
			WaitUtils.waitForSpinner(driver);
		}catch (Exception e) {
			throw new Exception("Error while selecting BtnPremisesOccupied detail : " + e);
		}
	}
	
	public void BusinessApplies(String businessApplies, ExtentTest extentedReport) throws Exception{
		try{
			WaitUtils.waitForListElement(driver, BusinessApplies, 2);
			ElementLayer.clickExpectedValue(BusinessApplies, businessApplies, extentedReport, driver);
			Log.message("Selected BusinessApplies : " + businessApplies, driver, extentedReport);
		}catch (Exception e) {
			throw new Exception("Error while selecting BusinessApplies : " + e);
}
					}
	
	public void PremisesATM(String btnPremisesATM, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnPremisesATM);
			new Select(BtnPremisesATM).selectByVisibleText(btnPremisesATM);
			Log.message("Selected BtnPremisesATM : " + btnPremisesATM, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnPremisesATM : " + e);
		}
	}
	
	public void AnyOutbuildingCovers(String btnAnyOutbuildingCovers, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnAnyBusinessPremises, 2);
			ElementLayer.clickExpectedValue(BtnAnyOutbuildingCovers, btnAnyOutbuildingCovers, extentedReport, driver);
			Log.message("Selected BtnAnyOutbuildingCovers : " + btnAnyOutbuildingCovers, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnAnyOutbuildingCovers : " + e);
		}
	}
	
	public void BuildingUsedFor(String buildingUsedFor, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BuildingUsedFor);
			new Select(BuildingUsedFor).selectByVisibleText(buildingUsedFor);
			Log.message("Selected BuildingUsedFor : " + buildingUsedFor, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BuildingUsedFor : " + e);
		}
	}
			
	public void SelfCateringFacilities(String btnSelfCateringFacilities, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnSelfCateringFacilities, 2);
			ElementLayer.clickExpectedValue(BtnSelfCateringFacilities, btnSelfCateringFacilities, extentedReport, driver);
			Log.message("Selected BtnSelfCateringFacilities : " + btnSelfCateringFacilities, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnSelfCateringFacilities : " + e);
		}
	}
	
	public void BedroomsNumber(String bedroomsNumber, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BedroomsNumber);
			new Select(BedroomsNumber).selectByVisibleText(bedroomsNumber);
			Log.message("Selected BedroomsNumber : " + bedroomsNumber, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BedroomsNumber : " + e);
		}
	}
	
	public void AddBuildingCover(String txtAddBuildingCover, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddBuildingCover);
			BtnAddBuildingCover.click();
			Thread.sleep(2000);
			Log.message("Clicked BtnAddBuildingCover. ", driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
			WaitUtils.waitForElement(driver, TxtAddBuildingCover);
			TxtAddBuildingCover.sendKeys(txtAddBuildingCover, "\t");
			Log.message("Entered TxtAddBuildingCover : " + txtAddBuildingCover, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAddBuildingCover : " + e);
		}
	}
	
	public void AddBusinessContentCover(String txtAddBusinessContentCover, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddBusinessContentCover);
			BtnAddBusinessContentCover.click();
			Log.message("Clicked BtnAddBusinessContentCover. ", driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
			WaitUtils.waitForElement(driver, TxtAddBusinessContentCover);
			TxtAddBusinessContentCover.sendKeys(txtAddBusinessContentCover, "\t");
			Log.message("Entered TxtAddBusinessContentCover : " + txtAddBusinessContentCover, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAddBusinessContentCover : " + e);
		}
	}

	public void AddBusinessContentCoverAmount(String txtAddBusinessContentCover, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, TxtAddBusinessContentCover);
			TxtAddBusinessContentCover.sendKeys(txtAddBusinessContentCover, "\t");
			Log.message("Entered TxtAddBusinessContentCover : " + txtAddBusinessContentCover, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);	
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAddBuildingCover : " + e);
		}
	}
	
	
	public void BuildingType(String buildingType, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BuildingType);
			new Select(BuildingType).selectByVisibleText(buildingType);
			Log.message("Selected BuildingType : " + buildingType, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BuildingType : " + e);
		}
	}
	
	public void PropertyBuiltYear(String propertyBuiltYear, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, PropertyBuiltYear);
			new Select(PropertyBuiltYear).selectByVisibleText(propertyBuiltYear);
			Log.message("Selected PropertyBuiltYear : " + propertyBuiltYear, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting PropertyBuiltYear : " + e);
		}
	}
	
	public void Grade1Premises(String btnGrade1Premises, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnGrade1Premises, 2);
			ElementLayer.clickExpectedValue(BtnGrade1Premises, btnGrade1Premises, extentedReport, driver);
			Log.message("Selected BtnGrade1Premises : " + btnGrade1Premises, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnGrade1Premises : " + e);
		}
	}
	
	public void WallMaterial(String btnWallMaterial, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnWallMaterial, 2);
			ElementLayer.clickExpectedValue(BtnWallMaterial, btnWallMaterial, extentedReport, driver);
			Log.message("Selected BtnWallMaterial : " + btnWallMaterial, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnWallMaterial : " + e);
		}
	}
	
	public void RoofMaterial(String btnRoofMaterial, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnRoofMaterial, 2);
			ElementLayer.clickExpectedValue(BtnRoofMaterial, btnRoofMaterial, extentedReport, driver);
			Log.message("Selected BtnRoofMaterial : " + btnRoofMaterial, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnRoofMaterial : " + e);
		}
	}
	
	public void HeatingList(String btnHeatingList, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnHeatingList, 2);
			ElementLayer.clickExpectedValue(BtnHeatingList, btnHeatingList, extentedReport, driver);
			Log.message("Selected BtnHeatingList : " + btnHeatingList, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnHeatingList : " + e);
		}
	}
	
	public void SubsidenceCover(String btnSubsidenceCover, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnSubsidenceCover, 2);
			ElementLayer.clickExpectedValue(BtnSubsidenceCover, btnSubsidenceCover, extentedReport, driver);
			Log.message("Selected BtnSubsidenceCover : " + btnSubsidenceCover, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnSubsidenceCover : " + e);
		}
	}
	
	public PropertyAwayFromThePremises clickNext(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForElement(driver, BtnNext);
			Thread.sleep(2000);
			BtnNext.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked Next button", driver, extentedReport);
			return new PropertyAwayFromThePremises(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Next button: " + e);
		}
	}
	
	public void clickNextForSamePage(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnNext);
			BtnNext.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Message - Clicked Next button", driver, extentedReport);
		
		} catch (Exception e) {
			throw new Exception("Error while clicking Next button: " + e);
		}
	}
	
	public void AddOutstandingBuildingCover(String OutbuildingsBuildingCover, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddOutbuildingsBuildingCover);
			BtnAddOutbuildingsBuildingCover.click();
			Thread.sleep(2000);
			Log.message("Clicked BtnAddOutbuildingsBuildingCover;. ", driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
			WaitUtils.waitForElement(driver, txtOutbuildingsBuildingCover);
			txtOutbuildingsBuildingCover.sendKeys(OutbuildingsBuildingCover, "\t");
			Log.message("Entered txtOutbuildingsBuildingCover : " + OutbuildingsBuildingCover, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAddOutbuildingsBuildingCover : " + e);
		}
	}
	
	
	public void AddOutbuilidngsBusinessContents(String OutbuilidngsBusinessContents, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddOutbuilidngsBusinessContents);
			BtnAddOutbuilidngsBusinessContents.click();
			Thread.sleep(2000);
			Log.message("Clicked BtnAddOutbuilidngsBusinessContents;. ", driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
			WaitUtils.waitForElement(driver, txtOutbuilidngsBusinessContents);
			txtOutbuilidngsBusinessContents.sendKeys(OutbuilidngsBusinessContents, "\t");
			Log.message("Entered OutbuilidngsBusinessContents : " + OutbuilidngsBusinessContents, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAddOutbuilidngsBusinessContents : " + e);
		}
	}
	
	public void AddMainBuildingYourStock(String MainBuildingYourStock, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnMainBuildingYourStock);
			BtnMainBuildingYourStock.click();
			Thread.sleep(2000);
			Log.message("Clicked BtnMainBuildingYourStock;. ", driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
			WaitUtils.waitForElement(driver, txtMainBuildingYourStock);
			txtMainBuildingYourStock.sendKeys(MainBuildingYourStock, "\t");
			Log.message("Entered MainBuildingYourStock : " + MainBuildingYourStock, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnMainBuildingYourStock : " + e);
		}
	}
	
	
	public void AddMainBuildingHousholdContents(String MainBuildingHousholdContents, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddMainBuildingHousholdContents);
			BtnAddMainBuildingHousholdContents.click();
			Thread.sleep(2000);
			Log.message("Clicked BtnAddMainBuildingHousholdContents;. ", driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
			WaitUtils.waitForElement(driver, txtMainBuildingHousholdContents);
			txtMainBuildingHousholdContents.sendKeys(MainBuildingHousholdContents, "\t");
			Log.message("Entered MainBuildingHousholdContents : " + MainBuildingHousholdContents, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAddMainBuildingHousholdContents : " + e);
		}
	}
	
	public void AddOutbuildingsYourStock(String OutbuildingsYourStock, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddOutbuildingsYourStock);
			BtnAddOutbuildingsYourStock.click();
			Thread.sleep(2000);
			Log.message("Clicked BtnAddOutbuildingsYourStock;. ", driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
			WaitUtils.waitForElement(driver, txtOutbuildingsYourStock);
			txtOutbuildingsYourStock.sendKeys(OutbuildingsYourStock, "\t");
			Log.message("Entered OutbuildingsYourStock : " + OutbuildingsYourStock, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAddOutbuildingsYourStock : " + e);
		}
	}
	
	public void AddOutbuildingsHousholdContents(String OutbuildingsHousholdContents, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddOutbuildingsHousholdContents);
			BtnAddOutbuildingsHousholdContents.click();
			Thread.sleep(2000);
			Log.message("Clicked BtnAddOutbuildingsHousholdContents;. ", driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
			WaitUtils.waitForElement(driver, txtOutbuildingsHousholdContents);
			txtOutbuildingsHousholdContents.sendKeys(OutbuildingsHousholdContents, "\t");
			Log.message("Entered OutbuildingsHousholdContents : " + OutbuildingsHousholdContents, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAddOutbuildingsHousholdContents : " + e);
		}
	}
	
	public void ClickAddItemMoreThan2500£(ExtentTest extentedReport) throws Exception {
		
		try {
			
			WaitUtils.waitForElement(driver, BtnAddItemMoreThan2500£);
			BtnAddItemMoreThan2500£.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Add BtnAddItemMoreThan2500£ button", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking AddItemMoreThan2500£ Button : " + e);
		}
	}
	
	public void SelectTypeofIem(String TypeOfItem, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForElement(driver, SelectTypeofIem);
			Thread.sleep(8000);
			new Select(SelectTypeofIem).selectByVisibleText(TypeOfItem);
			Log.message("Selected TypeOfItem : " + TypeOfItem, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while selecting TypeOfItem : " + e);
		}
	}
	
	public void EnterValueOfItem(String ValueOfItem, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForElement(driver, txtValueofItem);
			txtValueofItem.clear();
			txtValueofItem.sendKeys(ValueOfItem);
			Log.message("Entered ValueOfItem : " + ValueOfItem, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering ValueOfItem : " + e);
		}
	}
	
	public void EnterItemDescription(String ItemDescription, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForElement(driver, txtItemDescription);
			txtItemDescription.clear();
			txtItemDescription.sendKeys(ItemDescription);
			Log.message("Entered ItemDescription : " + ItemDescription, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering ItemDescription : " + e);
		}
	}
	public void AddNamedItems(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, BtnAddNamedItems);
			BtnAddNamedItems.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked BtnAddNamedItems", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnAddNamedItems : " + e);
		}
	}
	
	public void DoYouHaveItemMoreThan2500£(String ItemMoreThan2500£, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnItemMoreThan2500£, 2);
			ElementLayer.clickExpectedValue(BtnItemMoreThan2500£, ItemMoreThan2500£, extentedReport, driver);
			Log.message("Selected BtnGrade1Premises : " + ItemMoreThan2500£, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting ItemMoreThan2500£ : " + e);
		}
	}
	
	public void KeptNamedItemAt(String KeptNamedItemAt, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnKeptNamedItemAt, 2);
			ElementLayer.clickExpectedValue(BtnKeptNamedItemAt, KeptNamedItemAt, extentedReport, driver);
			Log.message("Selected KeptNamedItemAt : " + KeptNamedItemAt, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting KeptNamedItemAt : " + e);
		}
	}
	
	
	public void SelectSecurityFeatures(String SecurityFeatures, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnSecurityFeatures, 2);
			ElementLayer.clickExpectedValue(BtnSecurityFeatures, SecurityFeatures, extentedReport, driver);
			Log.message("Selected BtnSecurityFeatures : " + SecurityFeatures, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnSecurityFeatures : " + e);
		}
	}
	
	public void SelectOutbuildingsGrade1Premises(String OutbuildingsGrade1Premises, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnOutbuildingsGrade1Premises, 2);
			ElementLayer.clickExpectedValue(BtnOutbuildingsGrade1Premises, OutbuildingsGrade1Premises, extentedReport, driver);
			Log.message("Selected BtnOutbuildingsGrade1Premises : " + OutbuildingsGrade1Premises, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnOutbuildingsGrade1Premises : " + e);
		}
	}
	
	public void SelectOutbuilidingsWallMaterial(String OutbuilidingsWallMaterial, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnOutbuilidingsWallMaterial, 2);
			ElementLayer.clickExpectedValue(BtnOutbuilidingsWallMaterial, OutbuilidingsWallMaterial, extentedReport, driver);
			Log.message("Selected OutbuilidingsWallMaterial : " + OutbuilidingsWallMaterial, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting OutbuilidingsWallMaterial : " + e);
		}
	}

	public void SelectOutbuildingsRoofMaterial(String OutbuildingsRoofMaterial, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnOutbuildingsRoofMaterial, 2);
			ElementLayer.clickExpectedValue(BtnOutbuildingsRoofMaterial, OutbuildingsRoofMaterial, extentedReport, driver);
			Log.message("Selected BtnOutbuildingsRoofMaterial : " + OutbuildingsRoofMaterial, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnOutbuildingsRoofMaterial : " + e);
		}
	}
	
	public void SelectOutbuildingsHeatingList(String OutbuildingsHeatingList, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnOutbuildingsHeatingList, 2);
			ElementLayer.clickExpectedValue(BtnOutbuildingsHeatingList, OutbuildingsHeatingList, extentedReport, driver);
			Log.message("Selected BtnOutbuildingsHeatingList : " + OutbuildingsHeatingList, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnOutbuildingsHeatingList : " + e);
		}
	}
	
	public void SelectOthertthanFireplaceHeatingList(String HeatingListotherthanfireplace, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnOtherthanFireplaceHeatingList, 2);
			ElementLayer.clickExpectedValue(BtnOtherthanFireplaceHeatingList, HeatingListotherthanfireplace, extentedReport, driver);
			Log.message("Selected BtnOtherthanFireplaceHeatingList : " + HeatingListotherthanfireplace, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnOtherthanFireplaceHeatingList : " + e);
		}
	}
	
	public void SelectTermsandConditions(String termsandConditions, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForListElement(driver, BtnTermsandConditions, 2);
			ElementLayer.clickExpectedValue(BtnTermsandConditions, termsandConditions, extentedReport, driver);
			Log.message("Selected BtnTermsandConditions : " + termsandConditions, driver, extentedReport);	
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while selecting BtnTermsandConditions : " + e);
		}
	}
public void ClickRemoveBuildingCover(ExtentTest extentedReport) throws Exception {
		
		try {
			
			WaitUtils.waitForElement(driver, BtnRemoveBuildingCover);
			BtnRemoveBuildingCover.click();
			Log.message("Clicked Add BtnRemoveBuildingCover button", driver, extentedReport);
			WaitUtils.waitForSpinner(driver);
		} catch (Exception e) {
			throw new Exception("Error while clicking BtnRemoveBuildingCover Button : " + e);
		}
	}

public void ClickRemoveYourStockCover(ExtentTest extentedReport) throws Exception {
	
	try {
		
		WaitUtils.waitForElement(driver, BtnRemoveYourStockCover);
		BtnRemoveYourStockCover.click();
		Log.message("Clicked Add BtnRemoveYourStockCover button", driver, extentedReport);
		WaitUtils.waitForSpinner(driver);
	} catch (Exception e) {
		throw new Exception("Error while clicking BtnRemoveYourStockCover Button : " + e);
	}
}

public void ClickRemoveHousholdContentsCover(ExtentTest extentedReport) throws Exception {
	
	try {
		
		WaitUtils.waitForElement(driver, BtnRemoveHousholdContentsCover);
		BtnRemoveHousholdContentsCover.click();
		Log.message("Clicked Add BtnRemoveHousholdContentsCover button", driver, extentedReport);
		WaitUtils.waitForSpinner(driver);
	} catch (Exception e) {
		throw new Exception("Error while clicking BtnRemoveHousholdContentsCover Button : " + e);
	}
}

public void ClickRemoveBusinessContentsCover(ExtentTest extentedReport) throws Exception {
	
	try {
		
		WaitUtils.waitForElement(driver, BtnRemoveBusinessContentsCover);
		BtnRemoveBusinessContentsCover.click();
		Log.message("Clicked Add BtnRemoveBusinessContentsCover button", driver, extentedReport);
		WaitUtils.waitForSpinner(driver);
	} catch (Exception e) {
		throw new Exception("Error while clicking BtnRemoveBusinessContentsCover Button : " + e);
	}
}

public void VerifyBuildingHasAmountForContentsValidationMessage(ExtentTest extentedReport) throws Exception {
	try {
		WaitUtils.waitForElement(driver, BuildingHasAmountForContentsValidationMessage);
		Assert.assertEquals(true, BuildingHasAmountForContentsValidationMessage.isDisplayed());
		Log.message("Verified correct BuildingHasAmountForContentsValidationMessage has been displayed ", driver, extentedReport);
			  }
		
	catch (Exception e) {
		throw new Exception("Error while Verifying BuildingHasAmountForContentsValidationMessage  : " + e);
	}

}
	
	
}

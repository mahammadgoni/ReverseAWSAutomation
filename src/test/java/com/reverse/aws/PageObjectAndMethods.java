package com.reverse.aws;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageObjectAndMethods {

	protected final AppiumDriver driver;
	
	
	public PageObjectAndMethods(AppiumDriver driver){
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver,30,TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter your username']")
	public MobileElement userName;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter your password']")
	public MobileElement passWord;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Login']")
	public MobileElement loginBtn;
	
//	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.nuvoex.nuvoreverseapp.staging:id/logout']")
//	public MobileElement logoutBtn;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.view.ViewGroup[1]/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.TextView[1]")
	public MobileElement logoutBtn;
	
	@AndroidFindBy(xpath=".//*[@text='Confirm']")
	public MobileElement confirmBtn;
	
	@AndroidFindBy(xpath=".//*[@text='Retry']")
	public MobileElement retryBtn;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.nuvoex.nuvoreverseapp.staging:id/card_container']")
	public List<MobileElement> getAwbList;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[position()=1 and @resource-id='com.nuvoex.nuvoreverseapp.staging:id/card_container']")
	public MobileElement clickOnAwb;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Update']")
	public MobileElement clickOnUpdate;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Complete Pickup']")
	public MobileElement completePickUp;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.nuvoex.nuvoreverseapp.staging:id/iv_take_pic']")
	public WebElement takePhoto;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[4]/android.widget.ImageView[2]")
	public MobileElement captureImg;

	// @AndroidFindBy(xpath=".//*[@resource-id='com.android.camera:id/shutter_button']")
	// public WebElement captureImg;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.nuvoex.nuvoreverseapp.staging:id/iv_btn_save']")
	public MobileElement saveImg;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.nuvoex.nuvoreverseapp.staging:id/iv_btn_retake']")
	public MobileElement retakeImg;

	@AndroidFindBy(xpath = ".//*[@resource-id='com.android.camera:id/btn_cancel']")
	public MobileElement cancleImg;

	@AndroidFindBy(xpath = ".//*[@text='NEXT']")
	public MobileElement clikcOnNext;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='yes']")
	public MobileElement pressYes;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='no']")
	public MobileElement pressNo;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter number here']")
	public MobileElement enterNoOfProudct;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='done']")
	public MobileElement clickOnDone;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Submit']")
	public MobileElement clickOnSubimit;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='restart']")
	public MobileElement clickOnRestart;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Comment here']")
	public MobileElement enterComment;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Proceed']")
	public MobileElement clickOnProceed;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.nuvoex.nuvoreverseapp.staging:id/review_instruction']")
	public MobileElement qcReviewMessage;

	@AndroidFindBy(xpath = ".//*[@resource-id='com.nuvoex.nuvoreverseapp.staging:id/signature_pad']")
	public MobileElement signIn;

	@AndroidFindBy(xpath = ".//*[@resource-id='com.nuvoex.nuvoreverseapp.staging:id/clear_btn']")
	public MobileElement clearBtn;

	@AndroidFindBy(xpath = ".//*[@resource-id='com.nuvoex.nuvoreverseapp.staging:id/next_btn']")
	public MobileElement proceedBtn;

	@AndroidFindBy(xpath = ".//*[@resource-id='com.nuvoex.nuvoreverseapp.staging:id/qrCodeValue']")
	public MobileElement enterQrCode;

	@AndroidFindBy(xpath = ".//*[@resource-id='com.nuvoex.nuvoreverseapp.staging:id/bt_updateStatus']")
	public MobileElement updateStatus;

	@AndroidFindBy(xpath = ".//*[@resource-id='com.nuvoex.nuvoreverseapp.staging:id/done']")
	public MobileElement deliveredDone;
	
	
	
	public void loginToAccount(String feName,String password){	
		
		userName.sendKeys(feName+"\n");
		passWord.sendKeys(password+"\n");
		loginBtn.click();	
		
	}
	
	public void retryLogin(){
		retryBtn.click();
	}
	public void logoutFromAccount(){
		logoutBtn.click();
		confirmBtn.click();
	}
	
	// Select on Awb method
		public void select1stAwbAndUpdate() {
			clickOnAwb.click();
			clickOnUpdate.click();
	}
	
		// Select on Complete Pick Up Radio Button
		public void selectCompletePick() {
			completePickUp.click();
		}

		// Take an Image and save it method
		public void takeAnImg() {
			boolean saveBtn = takePhoto.isDisplayed();
			if (saveBtn == true) {
				takePhoto.click();	
				saveImg.click();
			}else {
				saveImg.click();
			}
//			takePhoto.click();
//			captureImg.click();
			
		}

		// Refresh the image or cancel image
		public void refreshImg() {
			boolean refrsBtn = retakeImg.isDisplayed();
			if (refrsBtn == true) {
				retakeImg.click();
				takeAnImg();
				
			}
//			retakeImg.click();
//			captureImg.click();
//			saveImg.click();

		}

		// Click on NEXT after save the Image
		public void nextStep() {
			clikcOnNext.click();
		}

		// Press yes method for question
		public void pressYes() {
			pressYes.click();
		}

		// Press no method for question
		public void pressNo() {
			pressNo.click();
		}

		// Enter No of Product to be picked
		public void enterNoOfProduct(String no) {
			enterNoOfProudct.sendKeys(no);
			clickOnDone.click();
		}

		// Click On Submit method
		public void clickOnSubmit() {
			clickOnSubimit.click();

		}

		// Click On Submit method
		public void clickOnRestart() {
			clickOnRestart.click();

		}

		// Click On Submit method
		public void enterCommentAndProceed(String commnt) {
			enterComment.sendKeys(commnt);
			driver.hideKeyboard();
			clickOnProceed.click();
			System.out.println(qcReviewMessage.getText());
			clickOnProceed.click();

		}

		// Sign In and Click on Proceed method
		public void signInAndProceed() {
			signIn.click();
			proceedBtn.click();

		}

		// Enter QR code and Update the status
		public void enterQrAndUpdateStatus(String code) {
			enterQrCode.sendKeys(code);
			driver.hideKeyboard();
			updateStatus.click();
			deliveredDone.click();
		}	

}

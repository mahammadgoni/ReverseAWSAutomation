package com.reverse.awsTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.reverse.aws.PageObjectAndMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SampleTest {

	// private static RemoteWebDriver driver = null;

	protected AppiumDriver<MobileElement> driver;

	// AppiumDriverLocalService service =
	// AppiumDriverLocalService.buildDefaultService();

	// Setting desire capabilities for your devices test

	public boolean takeScreenShot(final String name) {
		String screenshotDirectory = System.getProperty("appium.screenshots.dir",
				System.getProperty("java.io.tmpdir", ""));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
	}

	@BeforeSuite
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appium-version", "1.0");
		////
		capabilities.setCapability("platformName", "Android");
		////
		capabilities.setCapability("platformVersion", "6.0.1");
		////
	//	capabilities.setCapability("deviceName", "Google Nexus 5");
		////
		capabilities.setCapability("deviceName", "Micromax AQ4501");
		////
		////
		capabilities.setCapability("app", "/Users/eshan/Documents/Goni_important/apks/app-staging-release.apk");
		////
		capabilities.setCapability("appPackage", "com.nuvoex.nuvoreverseapp.staging");
		//
		capabilities.setCapability("appActivity", "com.nuvoex.nuvoreverseapp.LoginActivity");

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

	}

	// Login to your account test
	@Test(priority = 0)
	public void loginTest() {

		PageObjectAndMethods obj = new PageObjectAndMethods(driver);

		obj.loginToAccount("parvaz_fe", "parvaz");

		String screenShot1 = null;

		takeScreenShot(screenShot1);

		// Select Complete Pickup Test

		PageObjectAndMethods awb = new PageObjectAndMethods(driver);

		String screenShot13 = null;
		takeScreenShot(screenShot13);

		awb.select1stAwbAndUpdate();

		PageObjectAndMethods com = new PageObjectAndMethods(driver);

		String screenShot14 = null;
		takeScreenShot(screenShot14);

		com.selectCompletePick();

		// Tack an Image and click On save Test

		PageObjectAndMethods img = new PageObjectAndMethods(driver);
		String screenShot15 = null;
		takeScreenShot(screenShot15);

		img.takeAnImg();

		// Click on Yes for 1st question

		PageObjectAndMethods cot = new PageObjectAndMethods(driver);
		String screenShot16 = null;
		takeScreenShot(screenShot16);
		cot.pressYes();

		// Click on Yes for 2nd question

		String screenShot17 = null;
		takeScreenShot(screenShot17);
		cot.enterNoOfProduct("1");
		driver.hideKeyboard();

		// Click on Yes for 3rd question
		PageObjectAndMethods cot1 = new PageObjectAndMethods(driver);
		cot1.pressYes();
		String screenShot18 = null;
		takeScreenShot(screenShot18);

		// Click on Submit Test
		PageObjectAndMethods cot2 = new PageObjectAndMethods(driver);
		String screenShot21 = null;
		takeScreenShot(screenShot21);
		cot2.clickOnSubmit();

		// Enter comment for Remarks and print QC review test
		PageObjectAndMethods cot3 = new PageObjectAndMethods(driver);
		String screenShot22 = null;
		takeScreenShot(screenShot22);
		cot3.enterCommentAndProceed("Automation Test");

		// Signature Test

		PageObjectAndMethods sign = new PageObjectAndMethods(driver);
		String screenShot23 = null;
		takeScreenShot(screenShot23);
		sign.signInAndProceed();

		// Enter QR Code Test

		PageObjectAndMethods code = new PageObjectAndMethods(driver);
		String screenShot24 = null;
		takeScreenShot(screenShot24);
		code.enterQrAndUpdateStatus("Auto007");

		// Logout from your account Test

		PageObjectAndMethods obj1 = new PageObjectAndMethods(driver);
		String screenShot25 = null;
		takeScreenShot(screenShot25);
		obj1.logoutFromAccount();

	}

	// Select Complete Pickup Test
	// @Test(priority = 1)
	// public void selectCompleteTest() {
	// PageObjectAndMethods awb = new PageObjectAndMethods(driver);
	//
	// String screenShot13 = null;
	// takeScreenShot(screenShot13);
	//
	// awb.select1stAwbAndUpdate();
	//
	// PageObjectAndMethods com = new PageObjectAndMethods(driver);
	//
	// String screenShot14 = null;
	// takeScreenShot(screenShot14);
	//
	// com.selectCompletePick();
	//
	// }
	//
	// // Tack an Image and click On save Test
	// @Test(priority = 2)
	// public void takeAnImgTest() throws InterruptedException {
	// PageObjectAndMethods img = new PageObjectAndMethods(driver);
	// String screenShot15 = null;
	// takeScreenShot(screenShot15);
	//
	// img.takeAnImg();
	//
	// }
	//
	// // Click on Yes for 1st question
	// @Test(priority = 3)
	// public void firstQuestionTest() {
	// PageObjectAndMethods cot = new PageObjectAndMethods(driver);
	// String screenShot16 = null;
	// takeScreenShot(screenShot16);
	// cot.pressYes();
	//
	// }
	//
	// // Click on Yes for 2nd question
	// @Test(priority = 4)
	// public void seccondQuestionTest() {
	// PageObjectAndMethods cot = new PageObjectAndMethods(driver);
	// String screenShot17 = null;
	// takeScreenShot(screenShot17);
	// cot.enterNoOfProduct("1");
	// driver.hideKeyboard();
	//
	// }
	//
	// // // Click on Yes for 3rd question
	// // @Test(priority = 5)
	// // public void thirdQuestionTest() {
	// // PageObjectAndMethods cot = new PageObjectAndMethods(driver);
	// // cot.pressYes();
	// // String screenShot18 = null;
	// // takeScreenShot(screenShot18);
	// // }
	// //
	// // // Click on Yes for 4th question
	// // @Test(priority = 6)
	// // public void fouthQuestionTest() {
	// // PageObjectAndMethods cot = new PageObjectAndMethods(driver);
	// // cot.pressYes();
	// // String screenShot19 = null;
	// // takeScreenShot(screenShot19);
	// // }
	// //
	// // // Click on Yes for 5th question
	// // @Test(priority = 7)
	// // public void fifthQuestionTest() {
	// // PageObjectAndMethods cot = new PageObjectAndMethods(driver);
	// // cot.pressYes();
	// // String screenShot20 = null;
	// // takeScreenShot(screenShot20);
	// // }
	//
	// // Click on Submit Test
	// @Test(priority = 5)
	// public void clickOnSubmitTest() {
	// PageObjectAndMethods cot = new PageObjectAndMethods(driver);
	// String screenShot21 = null;
	// takeScreenShot(screenShot21);
	// cot.clickOnSubmit();
	//
	// }
	//
	// // Enter comment for Remarks and print QC review test
	// @Test(priority = 6)
	// public void enterRemarksTest() {
	// PageObjectAndMethods cot = new PageObjectAndMethods(driver);
	// String screenShot22 = null;
	// takeScreenShot(screenShot22);
	// cot.enterCommentAndProceed("Automation Test");
	//
	// }
	//
	// // Signature Test
	// @Test(priority = 7)
	// public void signatureTest() {
	// PageObjectAndMethods sign = new PageObjectAndMethods(driver);
	// String screenShot23 = null;
	// takeScreenShot(screenShot23);
	// sign.signInAndProceed();
	//
	// }
	//
	// // Enter QR Code Test
	// @Test(priority = 8)
	// public void enterQRCodeTest() {
	// PageObjectAndMethods code = new PageObjectAndMethods(driver);
	// String screenShot24 = null;
	// takeScreenShot(screenShot24);
	// code.enterQrAndUpdateStatus("Auto007");
	//
	// }
	//
	// // Logout from your account Test
	// @Test(priority = 9)
	// public void logoutTest() throws InterruptedException {
	// PageObjectAndMethods obj = new PageObjectAndMethods(driver);
	// String screenShot25 = null;
	// takeScreenShot(screenShot25);
	// obj.logoutFromAccount();
	//
	// }

	// Close your app Test
	@AfterSuite
	public void tearDown() {
		driver.close();

	}

}

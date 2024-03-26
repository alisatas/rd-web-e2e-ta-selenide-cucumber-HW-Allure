package tests;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.log4testng.Logger;
import org.testng.annotations.*;
import common.PageManager;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.testng.ScreenShooter;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;


@Listeners({ScreenShooter.class})
public class BaseTest {
    static final Logger logger = Logger.getLogger(BaseTest.class);
    protected PageManager pageManager;

    @BeforeSuite
    public void setUp() {
        logger.info("Testler Balşıyor....");
        pageManager = new PageManager();
        ScreenShooter.captureSuccessfulTests = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
         .screenshots(true)
         .savePageSource(false)
        );
    }

    @BeforeMethod
    public void openDriver() {
        logger.info("Browser açılıyor.");
        Selenide.open();
    }

    @AfterClass
    public void clearCookies() throws IOException {
        logger.info("Cookieler temizleniyor ve Browser kapatılıyor...");
        DriverFactory.clearCookies();

        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }

    @After
    public void tearDown( Scenario scenario) {
        if (scenario.isFailed()) // scenario failed take screenshot to allure report
            Allure.addAttachment("Screenshot", new ByteArrayInputStream (((TakesScreenshot) DriverFactory.currentDriver()).getScreenshotAs( OutputType.BYTES)));
        System.out.println("Closed");
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.close();
    }
}
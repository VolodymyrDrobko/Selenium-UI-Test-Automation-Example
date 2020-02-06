package core;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static utils.Constants.DEFAULT_URL;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp(ITestContext iTestContext) {
        WebDriver driver = DriverFactory
                .createDriverInstance(Optional.ofNullable(Configuration.getBrowser())
                        .orElse(iTestContext.getCurrentXmlTest().getParameter("browserName")));
        DriverManager.setDriver(driver);
        driver.get(Optional.ofNullable(Configuration.getURL()).orElse(DEFAULT_URL));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        DriverManager.getDriver().quit();
    }
}

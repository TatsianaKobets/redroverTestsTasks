package org.example.redoverteststask.jenkins.runner;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({FilterForTests.class})
public abstract class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod(Method method) {
        ProjectUtils.logf("Run %s.%s", this.getClass().getName(), method.getName());

        ProjectUtils.log("Clear data");
        JenkinsUtils.clearData();

        ProjectUtils.log("Browser open");
        driver = ProjectUtils.createDriver();

        ProjectUtils.log("Get web page");
        ProjectUtils.get(driver);

        ProjectUtils.log("Login");
        JenkinsUtils.login(driver);
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult testResult) {

        final String screenshotsDir = System.getProperty("user.dir") + "/screenshots";

        if (!testResult.isSuccess()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destinationPath = new File(screenshotsDir, testResult.getName() + ".png");

            try {
                if (!destinationPath.getParentFile().exists()) {
                    Files.createDirectories(Paths.get(screenshotsDir));
                }
                FileUtils.copyFile(screenshot, destinationPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (ProjectUtils.isServerRun() || testResult.isSuccess() || ProjectUtils.closeBrowserIfError()) {
            try {
                JenkinsUtils.logout(driver);
            } catch (Exception ignore) {
            }
            driver.quit();
            ProjectUtils.log("Browser closed");
        }

        ProjectUtils.logf(
                "Execution time is %.3f sec",
                (testResult.getEndMillis() - testResult.getStartMillis()) / 1000.0);

    }

    protected WebDriver getDriver() {
        return driver;
    }
}

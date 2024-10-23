import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {

  WebDriver driver = new ChromeDriver();

  @BeforeMethod
  public void baseURL() {
    driver.get("https://www.google.com/");
    driver.manage().window().fullscreen();
  }

  @Test
  public void testChromeDriver() {
//    WebDriver driver = new ChromeDriver();
//    driver.get("https://www.google.com/");
//    driver.quit();
  }

  @Test
  public void testWithChromeFirefox() {
//    WebDriver driver = new FirefoxDriver();
//    driver.get("https://www.google.com/");
    String pageTitle = driver.getTitle();
    pageTitle.equals("Google");
//    driver.quit();
  }

  @Test
  public void testWithChromeFirefox2() {
//    WebDriver driver = new FirefoxDriver();
//    driver.get("https://www.google.com/");
    String pageTitle = driver.getTitle();
    assertEquals("Google", pageTitle);
    Assert.assertEquals(pageTitle, "Google");//традиционный и явный способ
    assertEquals(pageTitle,
        "Google");//В JUnit 4 и более поздних версиях, метод assertEquals является статическим и может быть вызван без создания экземпляра класса Assert
//    driver.quit();
  }

  @AfterMethod
  public void closeBrowser() {
    driver.quit();
  }
}

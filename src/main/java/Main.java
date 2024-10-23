import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");
     testChromeDriver();
    testWithChromeFirefox();
  }

  public static void testChromeDriver() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com/");
    System.out.println("testChromeDriver выполнен");
    driver.quit();

  }

  public static void testWithChromeFirefox() {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://www.google.com/");
    String pageTitle = driver.getTitle();
    System.out.println("Page title is: " + pageTitle);

    System.out.println(pageTitle.equals("Google"));
    System.out.println("testWithChromeFirefox выполнен");
     driver.quit();
  }
}

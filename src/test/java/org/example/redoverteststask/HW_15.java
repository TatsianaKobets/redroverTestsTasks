package org.example.redoverteststask;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HW_15 {

  @Test
  public void testPageTitle() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    String expectedTitle = "Web form";
    String actualTitle = driver.getTitle();
    System.out.println("Expected title: " + expectedTitle);
    System.out.println("Actual title: " + actualTitle);
    driver.quit();
  }

  @Test
  public void testFormSubmission() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    WebElement textBox = driver.findElement(By.name("my-text"));
    textBox.sendKeys("Selenium");
    WebElement submitButton = driver.findElement(By.cssSelector("button"));
    submitButton.click();
    WebElement message = driver.findElement(By.id("message"));
    String expectedMessage = "Received!";
    String actualMessage = message.getText();
    System.out.println("Expected message: " + expectedMessage);
    System.out.println("Actual message: " + actualMessage);
    driver.quit();
  }

  @Test
  public void testTextBoxValue() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    WebElement textBox = driver.findElement(By.name("my-text"));
    textBox.sendKeys("Selenium");
    String expectedValue = "Selenium";
    String actualValue = textBox.getAttribute("value");
    System.out.println("Expected value: " + expectedValue);
    System.out.println("Actual value: " + actualValue);
    driver.quit();
  }

  @Test
  public void testButtonEnabled() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    WebElement submitButton = driver.findElement(By.cssSelector("button"));
    boolean isEnabled = submitButton.isEnabled();
    System.out.println("Is button enabled: " + isEnabled);
    driver.quit();
  }
}

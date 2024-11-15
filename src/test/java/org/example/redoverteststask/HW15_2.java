package org.example.redoverteststask;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HW15_2 {

  @Test
  public void testWB() throws InterruptedException {
    //ChromeOptions options = new ChromeOptions();
    //options.addArguments("--no-sandbox");

    WebDriver driver = new ChromeDriver();

    driver.get("https://www.wildberries.by");

    //WebElement textBox = driver.findElement(By.xpath("//*[@id=\"mobileSearchInput\"]"));
    WebElement textBox = driver.findElement(By.xpath("//input[@aria-label='product search']"));
        textBox.sendKeys("Куртка");
    textBox.sendKeys(Keys.ENTER);
    Thread.sleep(1000);

  }
}

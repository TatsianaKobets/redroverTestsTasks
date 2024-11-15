package org.example.redoverteststask.jenkins;

import org.example.redoverteststask.jenkins.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckVersionTest extends BaseTest {

  @Test
  public void testCheckVersion() {
    getDriver().findElement(By.xpath("//*[@id='jenkins']/footer/div/div[2]/button")).click();
    getDriver().findElement(By.xpath("//*[@id='tippy-1']/div/div/div/a[1]")).click();

    Assert.assertEquals(getDriver().findElement(By
        .xpath("//*[@id='main-panel']/div[2]/div[1]/p")).getText(), "Version 2.462.3");
  }


}

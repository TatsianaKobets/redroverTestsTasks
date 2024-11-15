package org.example.redoverteststask.jenkins;

import org.example.redoverteststask.jenkins.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WelcomeJenkinsTest extends BaseTest {
  @Test
  public void testWelcome() {
    String welcomeStr = getDriver().findElement(By.cssSelector(".empty-state-block > h1")).getText();

    //Assert.assertEquals(welcomeStr, "Welcome to Jenkins!");
    Assert.assertEquals(welcomeStr, "Добро пожаловать в Jenkins!");
  }
}

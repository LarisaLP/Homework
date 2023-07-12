package org.example.seleniumHomework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class SeleniumHomework {

    @Test
    public void emptyFieldsTest() {
        System.setProperty("web-driver.chrome.driver", "./lib/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://siit.epizy.com/index.php?route=account/register");
        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.of(10, SECONDS));

        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        continueButton.click();

        WebElement warningMessage = driver.findElement(By.cssSelector("#account-register > div.alert.alert-danger.alert-dismissible"));
        Assert.assertEquals("Warning: You must agree to the Privacy Policy!", warningMessage.getText());

        driver.quit();
    }

    @Test
    public void passwordTest() {
        System.setProperty("web-driver.chrome.driver", "./lib/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://siit.epizy.com/index.php?route=account/register");
        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.of(10, SECONDS));

        WebElement passwordBox = driver.findElement(By.id("input-password"));
        passwordBox.sendKeys("zxc");

        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        continueButton.click();

        WebElement warningMessage = driver.findElement(By.cssSelector("#content > form > fieldset:nth-child(2) > div:nth-child(2) > div > div"));
        Assert.assertEquals("Password must be between 4 and 20 characters!", warningMessage.getText());

        driver.quit();
    }
}

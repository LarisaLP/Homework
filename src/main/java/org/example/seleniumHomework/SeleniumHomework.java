package org.example.seleniumHomework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
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
    public void longFirstName(){
        System.setProperty("web-driver.chrome.driver", "./lib/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://siit.epizy.com/index.php?route=account/register");
        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.of(10, SECONDS));

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Johnathan McDaniel Forest Gump Humbert");

        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        continueButton.click();

        WebElement warningMessage = driver.findElement(By.cssSelector("#account > div:nth-child(3) > div > div"));
        Assert.assertEquals("First Name must be between 1 and 32 characters!", warningMessage.getText());

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

    @Test
    public void privacyPolicy() {
        System.setProperty("web-driver.chrome.driver", "./lib/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://siit.epizy.com/index.php?route=account/register");
        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.of(10, SECONDS));

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Johnathan");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Smith");

        WebElement emailAddress = driver.findElement(By.id("input-email"));
        emailAddress.sendKeys("johns@gmail.com");

        WebElement telephoneNr = driver.findElement(By.id("input-telephone"));
        telephoneNr.sendKeys("0746895321");

        WebElement passwordBox = driver.findElement(By.id("input-password"));
        passwordBox.sendKeys("asdasd");

        WebElement confirmPass = driver.findElement(By.id("input-confirm"));
        confirmPass.sendKeys("asdasd");

        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        continueButton.click();

        WebElement warningMessage = driver.findElement(By.cssSelector("#account-register > div.alert.alert-danger.alert-dismissible"));
        Assert.assertEquals("Warning: You must agree to the Privacy Policy!", warningMessage.getText());

        driver.quit();

    }
}

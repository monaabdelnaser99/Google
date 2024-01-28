package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class WaitType {
    WebDriver driver;
    @BeforeTest
    public void openUrl () {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");

    }
    @Test
    public void waitss() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement el =driver.findElement(By.id("APjFqb"));
        el.clear();
        el.sendKeys("automation step by step");
        el.submit();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
       WebElement myLink= wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText
                ("Automation Step by Step: NEVER STOP LEARNING")));
       myLink.click();
       //fluent wait

        Wait<WebDriver> fluentWait =new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.elementToBeSelected(By.xpath("")));


    }
}


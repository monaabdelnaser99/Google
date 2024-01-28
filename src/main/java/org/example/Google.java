package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;


public class Google {
   WebDriver driver;
    @Test
    public void testGoogleScreenshot () throws IOException {
        driver =new ChromeDriver();
        driver.navigate().to("https://www.google.com");
       File Scrshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(Scrshot,new File("./image1.png"));
        WebElement go =driver.findElement(By.className("lnXdpd"));
        File Scrshot1 = go.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(Scrshot1,new File("./image2.png"));
        TakesScreenshot ts = (TakesScreenshot) driver;

        JavascriptExecutor js =(JavascriptExecutor) driver;
        WebElement btn=driver.findElement(By.name("btnK"));
        js.executeScript("console.log('hello world')");
        js.executeScript("arguments[0].click();",btn);


        }
    @AfterTest
    public void closeUrl(){
        //driver.quit();
    }

}

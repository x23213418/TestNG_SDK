package org.example;

//package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class GoogleSearchTest {

    public WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup(); // Automatically handles ChromeDriver
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void searchSeleniumOnGoogle() {
        //locate the element
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        message.getText();
        Assert.assertEquals(message.getText(), "Received!");


    }


    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

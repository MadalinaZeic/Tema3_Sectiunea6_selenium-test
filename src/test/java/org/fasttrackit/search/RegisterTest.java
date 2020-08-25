package org.fasttrackit.search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest {
    @Test
    public void simpleSearchWithOneKeyword() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.cart2quote.com");
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[5]/a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Alexa");
        driver.findElement(By.id("lastname")).sendKeys("Pop");
        driver.findElement(By.name("email")).sendKeys("alexa@yahoo.com");
        driver.findElement(By.name("password")).sendKeys("var321VAR");
        driver.findElement(By.id("confirmation")).sendKeys("var321VAR");
        WebElement checkBox = driver.findElement(By.className("checkbox"));
        checkBox.click();

        driver.quit();
    }
}


package org.fasttrackit.search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CartTest {

    @Test
    public void simpleSearchWithOneKeyword() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.cart2quote.com/accessories/eyewear.html");

        driver.findElement(By.linkText("SALE")).click();
        driver.findElement(By.id("product-collection-image-423")).click();

        //there is no wishlist button or section in this site, so I made it for Add to Cart button
        Select Purple = new Select(driver.findElement(By.id("attribute92")));
        Purple.selectByVisibleText("Purple");

        Select Size = new Select(driver.findElement(By.id("attribute180")));
        Size.selectByVisibleText("L");

        driver.findElement(By.xpath("//*[@id=\"product_addtocart_form\"]/div[3]/div[6]/div[2]/div[2]/button")).click();

        driver.quit();
    }
}

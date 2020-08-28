package org.fasttrackit.search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Section6H6 {

    WebDriver driver;

    @Test
    public void findSpecificProduct() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();

        //find specific product
        driver.findElement(By.id("search")).sendKeys("PEARL STUD EARRINGS" + Keys.ENTER);
        List<WebElement> productNames = driver.findElements(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > h2 > a"));
        productNames.get(0).click();
    }

    @Test
    public void findSimilarProducts() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("shirts" + Keys.ENTER);

        //todo insert check
    }

    @Test
    public void addToCartButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("JEWELRY" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/ul/li/div/div[2]/button/span/span")).click();
    }

    @Test
    public void emptyCartButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("JEWELRY" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/ul/li/div/div[2]/button/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"empty_cart_button\"]")).click();
    }

    @Test
    public void removeCartButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("JEWELRY" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/ul/li/div/div[2]/button/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[6]/a")).click();
    }

    @Test
    public void sortByButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.get("https://demo.cart2quote.com/accessories/jewelry.html");
        Select sortBy = new Select(driver.findElement(By.cssSelector(".category-products > .toolbar > .sorter select")));
        sortBy.selectByValue("https://demo.cart2quote.com/accessories/jewelry.html?dir=asc&order=price");
    }

    @Test
    public void checkBoxButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[5]/a")).click();
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
    }

    @Test
    public void CreateAccountButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[5]/a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Alexa");
        driver.findElement(By.id("lastname")).sendKeys("Pop");
        driver.findElement(By.name("email")).sendKeys("alexa@yahoo.com");
        driver.findElement(By.name("password")).sendKeys("var321VAR");
        driver.findElement(By.id("confirmation")).sendKeys("var321VAR");
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
    }

    @Test
    public void backButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[5]/a")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > p > a")).click();
    }

    @Test
    public void saleButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.linkText("SALE")).click();
    }

    private void startTest() {
        driver.get("https://demo.cart2quote.com");
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/button")).click();
    }


}


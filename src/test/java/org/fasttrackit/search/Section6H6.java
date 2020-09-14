package org.fasttrackit.search;

import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Section6H6 {

    WebDriver driver;

    @Test
    public void findSpecificProduct() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();

        driver.findElement(By.id("search")).sendKeys("PEARL STUD EARRINGS" + Keys.ENTER);
        List<WebElement> productNames = driver.findElements(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul"));

        for (WebElement productName : productNames) {
            assertThat("The product does not appear in list.", productName.getText(), (containsString("PEARL STUD EARRINGS")));
        }
    }

    @Test
    public void findSimilarProducts() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("vase" + Keys.ENTER);
        List<WebElement> productNames = driver.findElements(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products"));

        for (WebElement productName : productNames) {
            assertThat("Some of the products' names do not contain the searched keyword.", productName.getText(), (containsString("VASE")));
        }
    }

    @Test
    public void addToCartButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("JEWELRY" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/ul/li/div/div[2]/button/span/span")).click();
        assertThat("Add to cart button leads to the wrong page.", driver.getCurrentUrl(), is("https://demo.cart2quote.com/checkout/cart/"));
    }

    @Test
    public void emptyCartButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("JEWELRY" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/ul/li/div/div[2]/button/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"empty_cart_button\"]")).click();
        WebElement emptyCart = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        assertThat("The Empty cart button leads to the wrong page.", emptyCart.getText(), containsString("SHOPPING CART IS EMPTY"));
    }

    @Test
    public void removeCartButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("JEWELRY" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/ul/li/div/div[2]/button/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[6]/a")).click();
        WebElement emptyCart = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        assertThat("The Empty cart button leads to the wrong page.", emptyCart.getText(), containsString("SHOPPING CART IS EMPTY"));
    }

    @Test
    public void sortByButton() { //li[@class='uwa-tab clauses']/a[@href='#clauses']
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.get("https://demo.cart2quote.com/accessories/jewelry.html");
        Select sortBy = new Select(driver.findElement(By.cssSelector(".category-products > .toolbar > .sorter select")));
        sortBy.selectByValue("https://demo.cart2quote.com/accessories/jewelry.html?dir=asc&order=price");
        List<WebElement> productNames = driver.findElements(By.cssSelector("span[id*='product-price'],[id*='product-minimal-price']"));

        List<Double> prices = new ArrayList<>();
        for (WebElement productPrice : productNames) {
            double price = Double.parseDouble(productPrice.getText().substring(1));

            prices.add(price);
        }

        System.out.println("Product prices: " + prices);
        assertThat("Items not sorted", Ordering.natural().isOrdered(prices));
    }

    @Test
    public void checkBoxButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[5]/a")).click();
        WebElement checkBox = driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label"));
        checkBox.click();
        checkBox.isSelected();
    }

    @Test
    public void createAccountButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[5]/a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Ana");
        driver.findElement(By.id("lastname")).sendKeys("Pop");
        driver.findElement(By.name("email")).sendKeys("ana@yahoo.com");
        driver.findElement(By.name("password")).sendKeys("var3876VAR");
        driver.findElement(By.id("confirmation")).sendKeys("var3876VAR");
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        assertThat("The button doesn't lead to the right page.", driver.getCurrentUrl(), is("https://demo.cart2quote.com/customer/account/index/"));
    }

    @Test
    public void backButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[5]/a")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > p > a")).click();
        assertThat("The button doesn't lead to the right page.", driver.getCurrentUrl(), is("https://demo.cart2quote.com/customer/account/login/"));
    }

    @Test
    public void saleButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        startTest();
        driver.findElement(By.linkText("SALE")).click();
        assertThat("The button doesn't lead to the right page.", driver.getCurrentUrl(), is("https://demo.cart2quote.com/sale.html"));
    }

    private void startTest() {
        driver.get("https://demo.cart2quote.com");
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/button")).click();
    }
}


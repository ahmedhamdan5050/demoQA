import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class bookstest1 {
    WebDriver driver;
    booktestUtils book=new booktestUtils();

    @BeforeClass
    void setup() throws InterruptedException {
        driver = baseUtils.getWebDriver();
        driver.get("https://demoqa.com/login");
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        WebElement usernameEl = driver.findElement(By.cssSelector("#userName"));
        String username = baseUtils.initializeProperties().getProperty("username");
        usernameEl.sendKeys(username);
        Thread.sleep(1000);

        WebElement passwordEl = driver.findElement(By.cssSelector("#password"));
        String password = baseUtils.initializeProperties().getProperty("password");
        passwordEl.sendKeys(password);
        Thread.sleep(1000);

        baseUtils.scrollAndClick(driver, By.cssSelector("#login"));
        Thread.sleep(2000);
        baseUtils.scroll(driver, By.cssSelector("#gotoStore"));
        driver.findElement(By.cssSelector("#gotoStore")).click();
        Thread.sleep(2000);

    }

    @Test()
    void addtocart() throws InterruptedException {
        baseUtils.scroll(driver,book.bookstore);
        driver.findElement(book.bookstore).click();
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        baseUtils.scroll(driver, (book.addToCollection));
        Thread.sleep(2000);
        driver.findElement((book.addToCollection)).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        driver.get("https://demoqa.com/profile");
        Thread.sleep(2000);

        WebElement cart = driver.findElement((book.cart));
        Thread.sleep(2000);
        Assert.assertTrue(cart.getText().contains("Addy Osmani"));
    }
    @AfterClass
    void Quit() {
        driver.quit();
    }
}

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

public class bookStoreManualLoginTest {
    WebDriver driver;
    @BeforeClass
    void setup() {
        driver = baseUtils.getWebDriver();
        driver.get("https://demoqa.com/login");
        baseUtils.scroll(driver, By.cssSelector("#userName"));
    }
    @Test
    void login() throws InterruptedException {
        WebElement usernameEl=driver.findElement(By.cssSelector("#userName"));
        String username=baseUtils.initializeProperties().getProperty("username");
        usernameEl.sendKeys(username);
        Thread.sleep(1000);

        WebElement passwordEl=driver.findElement(By.cssSelector("#password"));
        String password=baseUtils.initializeProperties().getProperty("password");
        passwordEl.sendKeys(password);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(2000);

       WebElement exists= driver.findElement(By.cssSelector("#userName-value"));
        Assert.assertTrue(exists.getText().contains("hamdan2205"));
        Thread.sleep(3000);

    }
    @AfterClass
    void quit(){
        driver.quit();
    }
}

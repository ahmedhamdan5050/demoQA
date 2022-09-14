import io.github.bonigarcia.wdm.WebDriverManager;
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


public class testHellowWorld {
    static WebDriver Driver;

    @BeforeClass
    void setup() {
        baseUtils.setChromePath();
        Driver = WebDriverManager.chromedriver().create();
        Driver.get("http://the-internet.herokuapp.com/dynamic_loading");
        Driver.findElement(By.cssSelector("#content > div > a:nth-child(5)")).click();
        Driver.findElement(By.cssSelector("#start > button")).click();
    }

    @Test(priority = 1)
    void testElementClickable() throws InterruptedException {

        WebDriverWait Wait = (new WebDriverWait(Driver, Duration.ofSeconds(15)));
        Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish")));
        WebElement hellowWorld = Driver.findElement(By.cssSelector("div#finish"));
        Assert.assertTrue(hellowWorld.getText().contains("Hello World!"));
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    void Test2() throws InterruptedException {
        Driver.get("http://the-internet.herokuapp.com/dynamic_loading");
        Thread.sleep(1000);
        Driver.findElement(By.cssSelector("#content > div > a:nth-child(8)")).click();
        Driver.findElement(By.cssSelector("#start > button")).click();
        WebDriverWait Wait = (new WebDriverWait(Driver, Duration.ofSeconds(15)));
        Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish > h4")));
        WebElement hellowWorld = Driver.findElement(By.cssSelector("#finish > h4"));
        Thread.sleep(2000);
        Assert.assertTrue(hellowWorld.getText().contains("Hello World!"));
    }

    @AfterClass
    void WarpUp() {
        Driver.quit();
    }

}



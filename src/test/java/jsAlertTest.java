import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class jsAlertTest {
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver=baseUtils.getWebDriver();
        driver.get("http://demoqa.com/alerts");
    }
    @Test
    void aleartboxtest() throws InterruptedException {
        //click on first Alert
        driver.findElement(By.cssSelector("#alertButton")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);


        //click on Second Alert
        driver.findElement(By.cssSelector("#timerAlertButton")).click();
        WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(15000));
        w.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //click Third Alert Box-click cancel
        driver.findElement(By.cssSelector("#confirmButton")).click();
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.cssSelector("#confirmResult")).getText().contains("Cancel"));
       Thread.sleep(2000);

       //click Fourth Alert Box
        driver.findElement(By.cssSelector("#promtButton")).click();
        driver.switchTo().alert().sendKeys("Hello");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.cssSelector("#promptResult")).getText().contains("Hello"));
    }
    @AfterClass
    void Quit(){
        driver.quit();
    }
}

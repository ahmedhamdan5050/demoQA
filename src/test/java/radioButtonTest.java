import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class radioButtonTest {
    WebDriver driver;
    radioButtonOOP radUtil = new radioButtonOOP();

    @BeforeClass
    void setUp() {
        driver = WebDriverManager.chromedriver().create();
        driver.get(radUtil.url);
    }

    @Test(priority = 1)
    void click() throws InterruptedException {
        driver.findElement(radUtil.yes).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(radUtil.success).getText().contains("Yes"));

        driver.findElement(radUtil.impressive).click();
        Assert.assertTrue(driver.findElement(radUtil.success).getText().contains("Impressive"));

    }

    @Test(priority = 2)
    void Assert() {
        WebElement noRadio = driver.findElement(radUtil.no);
        Assert.assertFalse(noRadio.isEnabled());
    }

    @AfterClass
    void Quit() {
        driver.quit();
    }
}

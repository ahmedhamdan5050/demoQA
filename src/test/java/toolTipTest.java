import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class toolTipTest {
    WebDriver driver;
    widget_toolTipPage toolTipPage;
    @BeforeClass
    void setup() throws InterruptedException {
        driver= WebDriverManager.chromedriver().create();
        toolTipPage=new widget_toolTipPage();
        driver.get(toolTipPage.pageUrl);
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(toolTipPage.conterary));
        driver.findElement(toolTipPage.conterary);
        Thread.sleep(3000);

    }
    @Test
    void testTooltip() throws InterruptedException {
        Thread.sleep(2000);
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(toolTipPage.tooltiphover));
        action.click().build().perform();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(toolTipPage.text));



        WebElement tooltipElement=driver.findElement(toolTipPage.text);
        Assert.assertEquals(tooltipElement.getText(),"You hovered over the 1.10.32");
        Thread.sleep(3000);
    }
    @AfterClass
    void quit(){
        driver.quit();
    }
}

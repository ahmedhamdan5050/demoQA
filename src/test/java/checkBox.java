import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class checkBox {
    static WebDriver Driver;
    @BeforeClass
    void setup() throws InterruptedException {

        Driver =baseUtils.getWebDriver();
        Driver.get("https://demoqa.com/checkbox");
        Thread.sleep(2000);
    }
    @Test
    void Checkbox() throws InterruptedException {
        WebElement firstErrow = Driver.findElement(By.cssSelector("#tree-node > ol > li > span > button > svg"));
        firstErrow.click();
        Thread.sleep(1000);
        WebElement SecondErrow=Driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > button > svg"));
        SecondErrow.click();
        WebElement ThirdErrow=Driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > span > button > svg"));
        ThirdErrow.click();
        WebElement fourthErrow=Driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(1) > span > button > svg"));
        fourthErrow.click();
        WebElement CheckMark=Driver.findElement(By.cssSelector("#tree-node > ol > li > span > label > span.rct-checkbox > svg"));
        CheckMark.click();
        Thread.sleep(1000);
    }
    @AfterClass
    void Quit(){
        Driver.quit();
    }
}

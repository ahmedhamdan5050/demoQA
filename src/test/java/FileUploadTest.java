import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver=baseUtils.getWebDriver();
        driver.get("http://the-internet.herokuapp.com/upload");
    }
    @Test
    void fileuploadTest() throws InterruptedException {
        WebElement fileUpload=driver.findElement(By.cssSelector("#file-upload"));
        String absulutepath=baseUtils.initializeProperties().getProperty("projectPath");
        fileUpload.sendKeys(absulutepath);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#file-submit")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.cssSelector("#uploaded-files")).getText().contains("IMG_7979.heic"));
        Thread.sleep(2000);
        driver.quit();
    }
}

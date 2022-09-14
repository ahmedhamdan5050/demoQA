import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class fileDownloadTest {
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver=baseUtils.getWebDriver();
        driver.get("http://the-internet.herokuapp.com/download");
    }
    @Test
    void testdownload() throws InterruptedException {
        WebElement filelink=driver.findElement(By.cssSelector("#content > div > a:nth-child(4)"));
        filelink.click();
        Thread.sleep(5000);
        String fileName=filelink.getText();
        String downloadedFilePath=baseUtils.initializeProperties().getProperty("downloadFolder")+fileName;
        File downloadedFile=new File(downloadedFilePath);
        Thread.sleep(2000);
        Assert.assertTrue(downloadedFile.exists());
        Thread.sleep(2000);
        downloadedFile.delete();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class logINWithCapchaTest {
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver=baseUtils.getWebDriver();
        driver.get("https://demoqa.com/login");
        baseUtils.scroll(driver,By.cssSelector("#userName"));
        driver.findElement(By.cssSelector("#newUser")).click();
        baseUtils.scroll(driver,By.cssSelector("#firstname"));
    }
    @Test
    void invalidLogin() throws InterruptedException {
        driver.findElement(By.cssSelector("#register")).click();
        WebElement Firstname=driver.findElement(By.cssSelector("#firstname"));
        Thread.sleep(1000);
        Assert.assertTrue(Firstname.getAttribute("class").contains("invalid"));
        Thread.sleep(1000);


        WebElement Lastname=driver.findElement(By.cssSelector("#lastname"));
        Thread.sleep(1000);
        Assert.assertTrue(Lastname.getAttribute("class").contains("invalid"));
        Thread.sleep(1000);


        WebElement username=driver.findElement(By.cssSelector("#userName"));
        Thread.sleep(1000);
        Assert.assertTrue(username.getAttribute("class").contains("invalid"));
        Thread.sleep(1000);



        WebElement Password=driver.findElement(By.cssSelector("#password"));
        Thread.sleep(1000);
        Assert.assertTrue(Password.getAttribute("class").contains("invalid"));
        Thread.sleep(1000);
    }
    @AfterClass
    void quit(){
        driver.quit();
    }
}

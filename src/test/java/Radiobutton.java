import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Radiobutton {
    static WebDriver Driver;
    @BeforeClass
    void setup() throws InterruptedException {
        baseUtils.setChromePath();
        Driver = new ChromeDriver();
        Driver.get("https://demoqa.com");
        Thread.sleep(2000);
        ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);",Driver.findElement(By.cssSelector("div.home-body > div > :nth-child(1)")));
        Driver.findElement(By.cssSelector("div.home-body > div > :nth-child(1)")).click();
        Thread.sleep(1000);
        Driver.findElement(By.cssSelector("#item-2 > span")).click();
        Thread.sleep(1000);
    }

    @Test
    void yesRadioTest(){

        Driver.findElement(By.cssSelector("div:nth-child(2) > label")).click();
        WebElement resultbox = Driver.findElement(By.cssSelector("div:nth-child(2) > p"));
        Assert.assertTrue(resultbox.getText().contains("You have selected Yes"));


    }
    @Test
    void impressiveRadioTest() throws InterruptedException {
        Driver.findElement(By.cssSelector("div:nth-child(3) > label")).click();
        Thread.sleep(1000);
        WebElement Result =Driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > p"));
        Assert.assertTrue(Result.getText().contains("You have selected Impressive"));
        Thread.sleep(1000);


    }
    @Test
    void disableRadioTest(){
        WebElement noRadio=Driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(noRadio.isEnabled());

    }
    @AfterClass
    void quit(){
        Driver.quit();}



    }


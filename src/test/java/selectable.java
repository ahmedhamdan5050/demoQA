import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class selectable {
    static WebDriver Driver;

    @BeforeClass
    void setup() throws InterruptedException {
        baseUtils.setChromePath();
        Driver = WebDriverManager.chromedriver().create();
        Driver.get("https://demoqa.com");
        Thread.sleep(2000);
     baseUtils.scrollAndClick(Driver, By.cssSelector("div.home-body > div > :nth-child(1)"));
        Thread.sleep(1000);
        Driver.findElement(By.cssSelector("g > path:nth-child(2)")).click();
        Thread.sleep(1000);
        baseUtils.scrollAndClick(Driver,By.cssSelector(" div:nth-child(5) > span > div"));
        Thread.sleep(1000);
       baseUtils.scrollAndClick(Driver,By.cssSelector(".element-group:nth-child(5) #item-1"));
        Thread.sleep(1000);
        Driver.findElement(By.cssSelector("#demo-tab-grid")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 1)
    void testASingleGrid() throws InterruptedException {
        TestGrid("#row1 li:nth-child(1)");
        TestGrid("#row1 li:nth-child(2)");
        TestGrid("#row1 li:nth-child(3)");
        ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);",Driver.findElement(By.cssSelector("#row2 li:nth-child(1)")));

        TestGrid("#row2 li:nth-child(1)");
        TestGrid("#row2 li:nth-child(2)");
        TestGrid("#row2 li:nth-child(3)");
        ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);",Driver.findElement(By.cssSelector("#row3 li:nth-child(1)")));

        TestGrid("#row3 li:nth-child(1)");
        TestGrid("#row3 li:nth-child(2)");
        TestGrid("#row3 li:nth-child(3)");
    }



    @Test(priority = 2)


    void listTest() throws InterruptedException {
    Driver.findElement(By.cssSelector("#demo-tab-list")).click();
        Testlist("#verticalListContainer > li:nth-child(1)");
        Testlist("#verticalListContainer > li:nth-child(2)");
        Testlist("#verticalListContainer > li:nth-child(3)");
        Testlist("#verticalListContainer > li:nth-child(4)");
    }


    void TestGrid(String selector) throws InterruptedException {
        WebElement box=Driver.findElement(By.cssSelector(selector));
        box.click();
        Thread.sleep(1000);
//        System.out.println(box.getAttribute("class"));
        Assert.assertTrue(box.getAttribute("class").contains("active"));
        Thread.sleep(1000);
        box.click();
        Assert.assertFalse(box.getAttribute("class").contains("active"));
        Thread.sleep(1000);
    }
    void ClickList(String selector) throws InterruptedException {
        WebElement listClick=Driver.findElement(By.cssSelector(selector));
        listClick.click();
        Thread.sleep(1000);
    }
    void Testlist(String selector) throws InterruptedException {
        WebElement list=Driver.findElement(By.cssSelector(selector));
        list.click();
        Thread.sleep(1000);
        Assert.assertTrue(list.getAttribute("class").contains("active"));
        Thread.sleep(1000);
        list.click();
        Assert.assertFalse(list.getAttribute("class").contains("active"));
        Thread.sleep(1000);
    }

    @AfterClass
    void Quit(){
        Driver.quit();
    }

    }

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class textBoxUtils {
    public By userName=new By.ByCssSelector("#userName");
    public By userEmail=new By.ByCssSelector("#userEmail");
    public By currentAddress=new By.ByCssSelector("#currentAddress");
    public By PermanentAddress=new By.ByCssSelector("#permanentAddress");
    public By submitButton=new By.ByCssSelector("#submit");
    public By output=new By.ByCssSelector("#output");
    public String url="https://demoqa.com/text-box";
    public void populateFromAndClick(WebDriver driver, String name, String email, String currAdd, String perAdd){
        driver.findElement(userName).sendKeys(name);
        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(currentAddress).sendKeys(currAdd);
        driver.findElement(PermanentAddress).sendKeys(perAdd);
        baseUtils.scrollAndClick(driver,submitButton);

    }
}

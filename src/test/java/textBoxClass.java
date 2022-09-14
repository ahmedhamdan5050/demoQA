import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class textBoxClass {
    WebDriver driver;
    textBoxUtils textbox =new textBoxUtils();
    @BeforeClass
    void setup(){
        driver= WebDriverManager.chromedriver().create();
      driver.get(textbox.url);
    }
    @Test
    void testform(){
        Faker faker=new Faker();
        String name=faker.name().name();
        String email=faker.name().username()+"@gmail.com";
        String currAddress=faker.address().fullAddress();
        String permanentAddress=faker.address().fullAddress();
        textbox.populateFromAndClick(driver,name,email,currAddress,permanentAddress);
        Assert.assertTrue(driver.findElement(textbox.output).getText().contains(name));

    }



    @AfterClass
    void Quit(){
        driver.quit();
    }
}

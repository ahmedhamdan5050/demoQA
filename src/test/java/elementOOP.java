import org.openqa.selenium.By;

public class elementOOP {
    public By Elements=new By.ByCssSelector("#app > div > div > div.home-body > div > div:nth-child(1)");
    public By textBox=new By.ByCssSelector("#item-0 > span");
    public By CheckBox=new By.ByCssSelector("#item-1 > span");
    public By radioButton=new By.ByCssSelector("#item-2 > span");
    public By WebTables=new By.ByCssSelector("#item-3 > span");
    public By Button=new By.ByCssSelector("#item-4 > span");
    public By links=new By.ByCssSelector("#item-5 > span");
    public By brokenlinks=new By.ByCssSelector("#item-6 > span");
    public By uploadAndDownload=new By.ByCssSelector("#item-7 > span");
    public By DynamicProject=new By.ByCssSelector("#item-8 > span");
    public String url ="https://demoqa.com/elements";
}

import org.openqa.selenium.By;

public class widget_toolTipPage {
    public String pageUrl="https://demoqa.com/tool-tips";
    public By tooltiphover=new By.ByCssSelector("#texToolTopContainer > a:nth-child(2)");
    public By link=new By.ByCssSelector("#texToolTopContainer > a:nth-child(2)");
    public By conterary=new By.ByCssSelector("#texToolTopContainer > a:nth-child(1)");
    public By text=new By.ByCssSelector("#sectionToolTip > div.tooltip-inner");
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OnlinerTest {
    private WebDriver driver;

    @BeforeTest
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void findElementBy() {
        driver.get("https://www.onliner.by/");
        driver.findElement(By.id("fast-search"));
        driver.findElement(By.name("viewport"));
        driver.findElement(By.className("responsive-layout"));
        driver.findElement(By.tagName("div"));
        driver.findElement(By.linkText("Форум"));
        driver.findElement(By.partialLinkText("Форум"));

        driver.findElement(By.cssSelector(".onliner_logo"));
        driver.findElement(By.cssSelector(".b-top-actions .g-top-i"));
        driver.findElement(By.cssSelector("#container"));
        driver.findElement(By.cssSelector("*"));
        driver.findElement(By.cssSelector("div"));
        driver.findElement(By.cssSelector("div.g-middle"));
        driver.findElement(By.cssSelector("div header"));
        driver.findElement(By.cssSelector("div > a"));
        driver.findElement(By.cssSelector("div+ul"));
        driver.findElement(By.cssSelector("div ~ p"));
        driver.findElement(By.cssSelector("[id]"));
        driver.findElement(By.cssSelector("[id = navigation-sidebar]"));
        driver.findElement(By.cssSelector("[title~=\"Onliner\"]"));
        driver.findElement(By.cssSelector("[title|=RSS]"));
        driver.findElement(By.cssSelector("a[href^=\"https\"]"));
        driver.findElement(By.cssSelector("div[id$=\"bar\"]"));
        driver.findElement(By.cssSelector("a[href*=\"people\"]"));


        driver.findElement(By.xpath("//ancestor::ul/li"));
        driver.findElement(By.xpath("//ancestor-or-self::div"));
        driver.findElement(By.xpath("//ul[@id]"));
        driver.findElement(By.xpath("//div/child::script"));
        driver.findElement(By.xpath("//descendant::li"));
        driver.findElement(By.xpath("//div/descendant::li"));
        driver.findElement(By.xpath("//div/following::div"));
        driver.findElement(By.xpath("//ul/following-sibling::a"));
        driver.findElement(By.xpath("//img/.."));
        driver.findElement(By.xpath("//img[@alt =\'Onliner\']/preceding::a"));
        driver.findElement(By.xpath("//div[@id='container']//preceding-sibling::ul"));
        driver.findElement(By.xpath("//div[@id='container']//self::*"));

    }
}

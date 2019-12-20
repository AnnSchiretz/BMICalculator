import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class BMICalculatorTest {
    @Test
    public void calculateKgCms(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        /*

         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("67");
        driver.findElement(By.name("ht")).sendKeys("186");
        driver.findElement(By.name("cc")).click();
        String result = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(result, "Your category is Normal", "Категория веса не совпадает с ожидаемой");
        driver.quit();
    }


}

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class BMICalculatorTest {
    private WebDriver driver;

    @BeforeTest
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void calculateKgCms(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("67");
        driver.findElement(By.name("ht")).sendKeys("186");
        driver.findElement(By.name("cc")).click();
        String normalResult = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(normalResult, "Your category is Normal", "Категория веса не совпадает с ожидаемой");
        driver.navigate().refresh();
        driver.findElement(By.name("wg")).sendKeys("123");
        driver.findElement(By.name("ht")).sendKeys("169");
        driver.findElement(By.name("cc")).click();
        String obeseResult = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(obeseResult, "Your category is Obese", "Категория веса не совпадает с ожидаемой");
        driver.navigate().refresh();
        driver.findElement(By.name("wg")).sendKeys("45");
        driver.findElement(By.name("ht")).sendKeys("182");
        driver.findElement(By.name("cc")).click();
        String starvationResult= driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(starvationResult, "Your category is Starvation", "Категория веса не совпадает с ожидаемой");
        driver.quit();
    }

    @Test
    public void calculatePounds (){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("67");
        new Select(driver.findElement(By.name("opt1"))).selectByValue("pounds");
        new Select(driver.findElement(By.name("opt2"))).selectByValue("6");
        new Select(driver.findElement(By.name("opt3"))).selectByValue("1");
        driver.findElement(By.name("cc")).click();
        String normalResult = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(normalResult, "Your category is Normal", "Категория веса не совпадает с ожидаемой");
        driver.findElement(By.name("wg")).sendKeys("123");
        new Select(driver.findElement(By.name("opt1"))).selectByValue("pounds");
        new Select(driver.findElement(By.name("opt2"))).selectByValue("5");
        new Select(driver.findElement(By.name("opt3"))).selectByValue("6");
        driver.findElement(By.name("cc")).click();
        String obeseResult = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(obeseResult, "Your category is Obese", "Категория веса не совпадает с ожидаемой");
        driver.findElement(By.name("wg")).sendKeys("45");
        new Select(driver.findElement(By.name("opt1"))).selectByValue("pounds");
        new Select(driver.findElement(By.name("opt2"))).selectByValue("6");
        driver.findElement(By.name("cc")).click();
        String starvationResult = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(starvationResult, "Your category is Starvation", "Категория веса не совпадает с ожидаемой");
        driver.quit();
    }

    @Test
    public void  compareResultKgAndPounds(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("67");
        driver.findElement(By.name("ht")).sendKeys("186");
        driver.findElement(By.name("cc")).click();
        String resultKg = driver.findElement(By.name("desc")).getAttribute("value");
        driver.navigate().refresh();
        driver.findElement(By.name("wg")).sendKeys("67");
        new Select(driver.findElement(By.name("opt1"))).selectByValue("pounds");
        new Select (driver.findElement(By.name("opt2"))).selectByValue("6");
        new Select (driver.findElement(By.name("opt3"))).selectByValue("1");
        driver.findElement(By.name("cc")).click();
        String resultPounds = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(resultKg, resultPounds, "Категории не совпадают с одинаковыми данными");
        driver.quit();
    }
    @Test
    public void calculateWeightMinBoundaryValue(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("9");
        driver.findElement(By.name("cc")).click();
        Alert alertOK = driver.switchTo().alert();
        String alertResult = alertOK.getText();
        assertEquals(alertResult, "Weight should be greater than 10kgs", "Неверное сообщение в аллерте");
        alertOK.accept();
        driver.quit();
    }

    @Test
    public void calculationWithLetters(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("myName");
        driver.findElement(By.name("ht")).sendKeys("myName");
        driver.findElement(By.name("cc")).click();
        Alert alertOK = driver.switchTo().alert();
    }

    @Test
    public void calculationWithSymbol(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("<!>$^#");
        driver.findElement(By.name("ht")).sendKeys("<!>$^#");
        driver.findElement(By.name("cc")).click();
        Alert alertOK = driver.switchTo().alert();
    }
    @Test
    public void calculateEmptyInput(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("cc")).click();
        Alert alertOK = driver.switchTo().alert();
        String alertResult = alertOK.getText();
        assertEquals(alertResult, "Enter the value for weight", "Неверное сообщение в аллерте");
        alertOK.accept();
        driver.quit();
    }
    @Test
    public void calculateBigData(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("8000");
        driver.findElement(By.name("ht")).sendKeys("8000");
        driver.findElement(By.name("cc")).click();
        Alert alertOK = driver.switchTo().alert();
    }
    @Test
    public void calculateHeightMinBoundaryValue(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("11");
        driver.findElement(By.name("ht")).sendKeys("32");
        driver.findElement(By.name("cc")).click();
        Alert alertOK = driver.switchTo().alert();
        String alertResult = alertOK.getText();
        assertEquals(alertResult,"Height should be taller than 33cms", "Неверное сообщение об ошибке");
        alertOK.accept();
        driver.quit();
    }


}

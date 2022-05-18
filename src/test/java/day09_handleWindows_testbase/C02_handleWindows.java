package day09_handleWindows_testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void tets01() {
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // 2- url'in  amazon icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        String ilkSayfaHandleDeger = driver.getWindowHandle();

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaHandle=driver.getWindowHandle();

        // 4- title'in BestBuy icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        // 5- ilk sayfaya donup sayfada Java aratalim
        driver.switchTo().window(ilkSayfaHandleDeger);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

        // 6- arama sonuclarinin Java icerdigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).
                getText().contains("Java"));

        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaHandle);

        // 8- logonun gorundugunu test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());


    }
}

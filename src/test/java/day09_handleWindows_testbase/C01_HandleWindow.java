package day09_handleWindows_testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindow {

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
        //driver.quit();
    }

    @Test
    public void tets01() {
        /*
        amazon ana sayfaya gidin
        nutella icin arama yaptirin
         */
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDeger = driver.getWindowHandle();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        /*
        sout ile hash code aliyoruz yani sayfanin unique hash kodudur
        Selenium sayfalar arasi geciste bu window handle degerini kullanir.

        eger sayfalar arasinda driver'imizi gezdiriyorsak ve her hangi bir sayfadan
        suanda bulundugumuz sayfaya gecmek istiyorsak

        driver.switchTo().window(souttan aldigimiz cikti)
        yani driver.getWindowHandle ile adligimiz degeri parantez icerisine yazariz
         */

        //ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkUrunResmi = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        bu komutu kullandigimizda driver otomatik olarak olusturuolan
        new Tab'a gecer

        yeni Tab'da gorevi gerceklestirmek icin adimlari bastan almamiz gerekir
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        /*
        String url =driver.getCurrentUrl();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
         */


        //yeni tah'da acilan urunun basligini yazdiralim
        System.out.println(driver.findElement(By.xpath("//span[@id='productTitle']")).getText());

        //ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(ilkSayfaHandleDeger);
        System.out.println(driver.getCurrentUrl());
    }

}

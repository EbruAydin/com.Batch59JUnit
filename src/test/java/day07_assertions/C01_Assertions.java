package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {

    /*
    amazon ana sayfaya gidin
    3 farkli test methodu olusturarak asagidaki gorevleri yapin:
    1- Url'in amazon icerdigini test edin (olumlu ifade yani Assert.assertTrue)
    2-Title'in facebook icermedigini test edin(olumsuz ifade yani Assert.assertFalse)
    3- sol ust kosede amazon logosunun gorundugunu test edin
     */

    /*
    eger bir task ayni sayfa icerisinde devam ediyorsa,
    gorevler birbirinin devami ise beforeclass ve afterclass daha mantikli
    gorevler birbirinden bagimsiz ise before ve after kullanmak mantikli
     */

    WebDriver driver;

    @Before
    public void setUp(){
        //her methoddan once bu dort satirin calismasini istiyoruz
        //bunun icin methodun uzerine @Before getiriyoruz
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @After//bu classlar static run edicek methdolarin static olmasi gerekir
    public void tearDown(){
        //methodlardan sonra calismasi icin @After getiririz
        driver.close();
    }

    @Test
    public void test1(){
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
    }

    @Test
    public void test2(){
        Assert.assertFalse(driver.getTitle().contains("facebook"));
    }
    @Test
    public void test3(){
        Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());


    }

}

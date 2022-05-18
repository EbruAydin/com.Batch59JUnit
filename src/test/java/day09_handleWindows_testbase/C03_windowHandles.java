package day09_handleWindows_testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_windowHandles {
    /*
    ● Tests package’inda yeni bir class olusturun: WindowHandle2
● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */

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

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows ");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertEquals("Opening a new window",driver.findElement(By.xpath("//h3")).getText());

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals("The Internet",driver.getTitle());

        /*
        eger kontrolsuz acilan bir tab ya da window varsa o zaman sayfalarin window handle degerlerini
        elde etmek gerekir

        oncelikle ikinci sayfa acilmadan once ilk sayfanin window handle degerini bir String'e atayalim
         */

        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //driver.findElement(By.linktext("Click here").click();

        /*
        switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
        biz driver'a yeni sayfaya gec demedikce driver eski sayfada kalir
        ve yeni sayfa ile ilgili hicbir islem yapamaz
        yeni sayfa da driver'i calistirmak isterseniz once driver'i yeni sayfaya yollamalisiniz
         */

        /*ikinci defa windowHandle yapsak bile burada ikinci sayfanin handle degerini getirmez cunku oraya gecemiyoruz
        bunun icin de windowHandles() methodunu kullanarak acik olan tum sayfalarin handle degerlerini alip bir set'e atariz

        ilk sayfanin degerini zaten biliyoruz, ikinci sayfayi da esit olmayan deger uzerinden atama yapariz
         */

        Set<String> windowHandle=driver.getWindowHandles();
        System.out.println(windowHandle);//set olarak dondurur bu degerleri

        String ikinciSayfaWindowHandleDegeri="";

        for (String each:windowHandle) {
            if(!each.equals(ilkSayfaWindowHandleDegeri)) {
                 ikinciSayfaWindowHandleDegeri = each;
            }
        }

        //ikinci sayfaya gecis yapacaz
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window", driver.getTitle());

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        Assert.assertEquals("New Window", driver.findElement(By.xpath("//h3")).getText());

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        Assert.assertEquals("The Internet", driver.getTitle());

    }
}

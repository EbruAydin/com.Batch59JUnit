package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C02_DropDownMenu {
    /*
    Amazona gidip
    dropdown'dan books secenegini secip
    Java aratalim
    ve arama sonucunda Java oldugunu test edelim
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test

    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");
        /*
        dropdown'dan bir option secmek icin 3 adim vardir
        1-dropdown'i locate edelim
         */

        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2-bir select obj'si olusturup bir onceki adimda olusturdugumuz WebElementi
        //parametre olarak gonderelim
        Select select=new Select(dropDownMenu);

        //3-Dropdown'da var olan optionlardan istedigimiz bir taneyi seceleim

        /*
        select inspectinde her zaman value attribute'u vardir selectByValue icin kullanilabilir

        visibleTest denilen de mesele books, Automotive, Arts&Crafs gibi select yapacagimiz zaman gorunen
        metinlerdir

        index konusu da sudur: 0 olan her zaman All Departments gibi (amazon sitesinde mesela) gordugumuzdur.
        digerileri de sirayiyla gelen neyse. bu soruda books 5 mesela. dropdown konusunda index 0'dan baslar


         */

        select.selectByVisibleText("Books");
       // select.selectByValue("search-alias=stripbooks-intl-ship");
        //select.selectByIndex(5);

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        Thread.sleep(3000);

        //WebElement sonuc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        //String sonuc2=sonuc.getText();

        String sonuc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String arananKelime="Java";

        Assert.assertTrue(sonuc.contains(arananKelime));


    }
}

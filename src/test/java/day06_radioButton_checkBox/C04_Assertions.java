package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {

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
        driver.close();
    }

    @Test

    public void test01(){
        driver.get("htpps://www.amazon.com");
        /*
        eger testleri if ile yaparsak test failed olsa bile kodlar problemsiz calistigi iicin kod calismasi bittiginde
        ekranin sol alt kisminda test passed yazacaktir

        JUnit ile birlikte if else konusunu kapatiyoruz. cunku bir test failed oldugu zaman onun bize dondurulmasini
        istiyoruz.Bunun icin asagidakini yapiyoruz:

         */

        String expectedUrl="https://www.facebook.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("url beklenenden farkli",expectedUrl,actualUrl);//bu mesaj sadece failed olursa cikiyor
    }


}

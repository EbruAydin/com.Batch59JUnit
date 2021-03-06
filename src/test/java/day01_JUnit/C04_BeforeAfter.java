package day01_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfter {

    WebDriver driver;

    @Before
    public void setUp(){
        //her methoddan once bu dort satirin calismasini istiyoruz
        //bunun icin methodun uzerine @Before getiriyoruz
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        //methodlardan sonra calismasi icin @After getiririz
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02(){
        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void test03(){
        driver.get("https://www.facebook.com");
    }
}

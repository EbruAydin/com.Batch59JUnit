package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {

    WebDriver driver;
    @Before
    public void setup(){
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
    public void test01(){

        /*
        her hangi bir websitesine gidince veya bir websitesinde her hangi bir islem yaptigimizda
        ortaya cikan uyarilara alert diyoruz.

        Eger bir alert inspect yapilabiliyorsa o alert otomasyon ile kullanilabilir
        bu tur alertlere HTML alert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur.
        Tum webelementler gibi locate edip, istedigimiz islemleri yapabiliriz.
        driver.get("https://www.facebook.com")'de cikan alert buna ornektir

        //https://the-internet.herokuapp.com/javascript_alerts bu siteye gittik
        HTML alertlerin yaninda bir de java script alertler var
        bunlari locate edemeyiz ancak selenium ile handle edebiliriz
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();

        //result kisminda "You successfully clicked an alert" yazdigini test edin

        //Assert.assertEquals("You successfully clicked an alert",driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")));

        //2.yol
        WebElement result=driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String actualresult=result.getText();
        String expectedresult="You successfully clicked an alert";

        Assert.assertEquals(expectedresult,actualresult);
    }

}

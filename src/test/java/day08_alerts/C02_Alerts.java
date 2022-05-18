package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    //● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //      “You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //      “successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //      OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void acceptAlert(){

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        WebElement result=driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String actualresult=result.getText();
        String expectedresult="You successfully clicked an alert";

        Assert.assertEquals(expectedresult,actualresult);
    }

    @Test
    public void dismissAlert(){

        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //    //      “successfuly” icermedigini test edin.

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        WebElement result=driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actualresult=result.getText();
        String arananKelime="successfuly";


        Assert.assertFalse(actualresult.contains(arananKelime));


    }

    @Test
    public void sendKeysAlert(){
        //● Bir metod olusturun: sendKeysAlert
        //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        //      OK butonuna     tıklayın ve result mesajında isminizin görüntülen diğini doğrulayın.

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Ebru Aydin");
        driver.switchTo().alert().accept();

        WebElement result=driver.findElement(By.id("result"));
        String actualResult=result.getText();
        String arananKelime="Ebru Aydin";

        Assert.assertTrue(actualResult.contains(arananKelime));
    }

}

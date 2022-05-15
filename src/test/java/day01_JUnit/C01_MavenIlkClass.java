package day01_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlkClass {
    public static void main(String[] args) {
        /*
        1-http://zero.webappsecurity.com sayfasina gidin
        2-Signin butonuna basin
        3-Login alanina "username" yazdirin
        4-Password alanina "password" yazdirin
        5-Sign in butonuna tiklayin
        6-Pay Bills sayfasina gidin
        7-amount kismina yatirmak istediginiz miktari yazdirin
        8-tarih kismina "2020-09-10" yazdirin
        9-Pay butonuna tiklayin
        10-"The payment was successufully submitted' mesajinin ciktigini control edin
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-http://zero.webappsecurity.com sayfasina gidin

        driver.get("http://zero.webappsecurity.com");
        //        2-Signin butonuna basin
        WebElement signInButonu=driver.findElement(By.xpath("//button[@id='signin_button']"));
        signInButonu.click();
        //        3-Login alanina "username" yazdirin
        WebElement logIn=driver.findElement(By.xpath("//input[@id='user_login']"));
        logIn.sendKeys("username");
        //        4-Password alanina "password" yazdirin
        WebElement password= driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");
        //        5-Sign in butonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        driver.navigate().back();

        //        6-Pay Bills sayfasina gidin
       driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //        7-amount kismina yatirmak istediginiz miktari yazdirin
        WebElement amountElement=driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amountElement.sendKeys("2000");

        //        8-tarih kismina "2020-09-10" yazdirin
        WebElement tarih=driver.findElement(By.xpath("//input[@id='sp_date']"));
        tarih.sendKeys("2020-09-10");

        //        9-Pay butonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //        10-"The payment was successufully submitted' mesajinin ciktigini control edin
        WebElement paymentGosterildiMi=driver.findElement(By.xpath("//span[@title='$ 2000 payed to payee sprint']"));
        if (paymentGosterildiMi.isDisplayed()) {
            System.out.println("The payment was successufully submitted PASSED");
        } else System.out.println("Test FAILED");

        driver.close();
    }
}

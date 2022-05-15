package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {

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
    public void radioButton() throws InterruptedException {
        //-https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //-Cookies’i kabul edin
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();
        Thread.sleep(3000);
        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        //-“radio buttons” elementlerini locate edin
        WebElement kadin=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement erkek=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement ozel=driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
        //-Secili degilse cinsiyet butonundan size uygun olani secin

        Thread.sleep(3000);
        if(!ozel.isSelected())
            ozel.click();
    }

}

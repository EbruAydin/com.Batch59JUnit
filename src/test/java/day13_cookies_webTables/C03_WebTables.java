package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {

    @Test
    public void dinamikYazici(){
        //onceki class'taki adrese gidip
        //girisYap methodunu kullanarak anasayfaya giris yapin
        //input olarak verilen satir sayisi ve sutun sayisina sahip
        //cell'deki texti yazdirin

        int satir=3;
        int sutun=5;

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();

        //            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        WebElement arananCell =
                driver.findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(arananCell.getText());

    }


}

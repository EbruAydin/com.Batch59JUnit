package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_HotelWebTable extends TestBase {
    //● Bir class oluşturun : C02_WebTables
    //● login( ) metodun oluşturun ve oturum açın.
    //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
    //            ○ Username : manager
    //            ○ Password : Manager1!
    //● table( ) metodu oluşturun
    //            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    //            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    //● printRows( ) metodu oluşturun //tr
    //            ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    //            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //            ○ 4.satirdaki(row) elementleri konsolda yazdırın.

    @Test
    public void test01(){
        login();


        //            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBasliklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun Sayisi : " + sutunBasliklarListesi.size());

        //            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        /*
        Tum body'i bir String olarak yazdirmak isterseniz body WebElementini locate edip
        getText() method'u ile yazdirabiliriz
         */
        //● printRows( ) metodu oluşturun //tr
        //            ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi :" +satirlarListesi.size());

        /*
        //tbody//tr
        burada //tbody/td yaparsak icerisindeki grandchild'lari almiyor bunun icin  //tbody//tr olmasi gerekir
        //tbody/tr child'ini verir biz tabloadaki butun sayirlara ulasmak istersek //tbody//tr kullaniriz
         */
        //            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

        for (WebElement each:satirlarListesi) {
            System.out.println(each.getText());
        }
        //            ○ 4.satirdaki(row) elementleri konsolda yazdırın.

        List<WebElement> cellList=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        cellList.stream().forEach(t-> System.out.println(t.getText()));

        //          Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < basliklarListesi.size() ; i++) {
            if (basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }
        List<WebElement> emailSutunListesi=
                driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each: emailSutunListesi) {
            System.out.println(each.getText());
        }

    }

    public void login() {
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

    }


}

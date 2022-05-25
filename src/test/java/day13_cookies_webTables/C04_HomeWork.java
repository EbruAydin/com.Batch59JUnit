package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


import java.util.List;

public class C04_HomeWork extends TestBase {
    //1. “https://demoqa.com/webtables” sayfasina gidin
    //2. Headers da bulunan department isimlerini yazdirin
    //3. sutunun basligini yazdirin
    //4. Tablodaki tum datalari yazdirin
    //5. Tabloda kac cell (data) oldugunu yazdirin
    //6. Tablodaki satir sayisini yazdirin
    //7. Tablodaki sutun sayisini yazdirin
    //8. Tablodaki 3.kolonu yazdirin
    //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
    //girdigimde bana datayi yazdirsin


    @Test
    public void test01() {

        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan department isimlerini yazdirin
        List<WebElement> satirListesi = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        List<WebElement> baslikListesi = driver.findElements(By.xpath("//div[@class='rt-tr']//div[@role='columnheader']"));
        /*
        //div[@class='rt-tr'] bu parca total satiri veriyor icine ulasmak icin child'a ulasmak lazim. Bunun icin de
        childlarin divlerini ekleriz. // bu bizim child almamizi saglar. Derste hoca deginmisti. Child html kodu //div[@role='columnheader']"
        ikisini birlestirince //div[@class='rt-tr']//div[@role='columnheader'] icerideki basliklara ulasmis oluyoruz.

         */

        int departmentNo = 0;
        for (int i = 0; i < baslikListesi.size(); i++) {
            if (baslikListesi.get(i).getText().equals("Department")) ;
            departmentNo = i;
        }

        List<WebElement> departmantBilgileri = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])//div[" + departmentNo + "]"));

        /*
        (//div[@class='rt-tr-group'])//div[" + departmentNo + "]"
        burada da (//div[@class='rt-tr-group']) burasi butun satiri verir, biz bunun icerisindeki ilgilere ulasmak icin
        //div["  "] yaparak girmis oluyoruz.

        normal html kodu ile yazilmis olsaydi //tbody//td["+(departmentNo+1)+"]" seklinde yapardik mesela
        buradaki td-->div'e denk geliyor

         */

        for (WebElement each: departmantBilgileri) {
            if(!each.getText().equals(" "))
            System.out.println(each.getText());
        }


        //3. sutunun basligini yazdirin

        System.out.println("=====3. Sutundaki baslik======");
        System.out.println(baslikListesi.get(2).getText());

        //4. Tablodaki tum datalari yazdirin

        System.out.println("==========Tablodaki Tum bilgiler=========");
        WebElement tumTableWebElement = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println(tumTableWebElement.getText());


        //5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("=====Tablodaki cell sayisi ============");
        List<WebElement> cellSayisi = driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println("Cell Sayisi : " + cellSayisi.size());

        //6. Tablodaki satir sayisini yazdirin
        System.out.println("======Tablodaki Satir Sayisi============");
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("satir sayisi : " + satirSayisi.size());

        //7. Tablodaki sutun sayisini yazdirin
        //sutun sayisi baslik sayisi ile ayni oldugundan burada baslikListesi variable'i kullanildi

        System.out.println("=====Tablodaki sutun sayisi========");
        System.out.println("Sutun sayisi : " + baslikListesi.size());


        //8. Tablodaki 3.kolonu yazdirin
        //(//div[@class='rt-tr-group'])[1]//div[3]

        System.out.println("======Tablodaki 3. kolon bilgileri====");
        List<WebElement> ucuncuKolonElementleriList=driver.findElements(By.xpath("//div[@role='rowgroup']//div[3]"));
        for (WebElement each:ucuncuKolonElementleriList) {
            //System.out.println(each.getText());//burasi olunca sadece bosluklar da geliyor. Onu engellemk icin bir sonraki adim gerekli
           if (!each.getText().equals(" ")){
              System.out.println(each.getText());
           }
        }

            //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        //BU KALDI

            //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
            //girdigimde bana datayi yazdirsin


            satirSutunYazdir();
        }


    private void satirSutunYazdir() {
        int satir = 3;
        int sutun = 2;
        System.out.println("=====10. Soru=========");
        WebElement hucre = driver.findElement(By.xpath("(//div[@class='rt-tr-group'][" + satir + "][" + sutun + "]"));
        System.out.print("satir. " + satir + " sutun. " + sutun + " : " + hucre.getText() + "      ");
    }
}
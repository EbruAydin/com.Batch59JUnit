package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    //1.Tests packagenin altina bir class oluşturun : C05_UploadFile
    //2.https://the-internet.herokuapp.com/upload adresine gidelim
    //3.chooseFile butonuna basalim
    //4.Yuklemek istediginiz dosyayi secelim.
    //5.Upload butonuna basalim.
    //6.“File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        /*
        dosya upload etmeyi selenium ile yapamayiz
        sendKeys methodu imdadimiza yetisir burada
        eger chooseFile butonuna var olan bir dosya yolunu yollarsak
        secme islemini otomatik olarak yapariz
         */

        //1.adim
        WebElement dosyaSec=driver.findElement(By.id("file-upload"));

        //2.adim
        //yuklenecek adimin dosya yolunu da yukleyelim

        String farkliKisim= System.getProperty("user.home");
        String ortakKisim = "\\OneDrive\\Desktop\\Yeni Metin Belgesi.txt";

        String yuklenecekDosyaYolu= farkliKisim+ortakKisim;

        //C:\Users\aydnn\OneDrive\Desktop\Yeni Metin Belgesi.txt

        //3.adim
        //send.Keys ile dosya yolunu secme butonuna yollayalim
        dosyaSec.sendKeys(yuklenecekDosyaYolu);

        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();

        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
    }


}

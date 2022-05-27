package day15_writeExcel_screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_TumSayfaScreenShot extends TestBase {

    @Test

    public void tumSayfa() throws IOException {

        //amazon sayfasina gidip tum sayfanin fotografini cekelim

        /*
        asafidaki dort adimi takip ediyoruz bunun icin
         */

        driver.get("https://www.amazon.com");

        LocalDateTime date=LocalDateTime.now();
        System.out.println(date);
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMDDHHmmss");

        TakesScreenshot ts = (TakesScreenshot) driver;
        String tarih=date.format(dtf);
        File tumSayfaResim = new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg");
        //bu amacimiz farkli
        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya, tumSayfaResim);
    }

}

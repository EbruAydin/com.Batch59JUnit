package day15_writeExcel_screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementSS extends TestBase {

    @Test
    public void test() throws IOException {

        //amazonda nutella aratin
        //ve arama sayisinin oldugu web elementinin fotografini cekelim

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        File sonucYazisiElementiSS=new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");
        File temp=sonucYazisiElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,sonucYazisiElementiSS);


    }

}

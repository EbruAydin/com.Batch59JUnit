package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class HeroKuappDropDownTesti {
    /*
    ● Bir class oluşturun: DropDown
● https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown optionlari yazdırın
    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test

    public void test01() {
        /*
        https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown optionlari yazdırın
    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
         */

        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropDownElement=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select obj=new Select(dropDownElement);

        obj.selectByIndex(1);
        System.out.println(obj.getFirstSelectedOption().getText());//getfirstselectedoption bize WebElement dondurgu iicin getText kullanmaliyiz yazdirmak icin

        obj.selectByValue("2");
        System.out.println(obj.getFirstSelectedOption().getText());

        obj.selectByVisibleText("Option 1");
        System.out.println(obj.getFirstSelectedOption().getText());

        //4.adim
        List<WebElement> allOptions=obj.getOptions();
        allOptions.stream().map(WebElement::getText).forEach(System.out::println);

        //5.adom
        System.out.println(allOptions.size());

        int dropDownBoyut= allOptions.size();
        //Assert.assertNotEquals(4,dropDownBoyut);

        if(dropDownBoyut==4)
            System.out.println("True");
        else System.out.println("False");
    }
}

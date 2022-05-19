package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //amazon anasayfa'ya gidin
        //account menusunden create a list linkine tiklayin

        driver.get("https://www.amazon.com");
       Actions actions=new Actions(driver);
       WebElement accountlink= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
       actions.moveToElement(accountlink).perform();

       driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        Thread.sleep(3000);

    }


}

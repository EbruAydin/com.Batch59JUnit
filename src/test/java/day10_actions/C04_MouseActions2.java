package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_MouseActions2 extends TestBase {
    /*
    Yeni bir class olusturalim: MouseActions2
1- https://demoqa.com/droppable adresine gidelim
2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */

    @Test
    public void test() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable ");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions action=new Actions(driver);
        WebElement dragMe=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        action.dragAndDrop(dragMe,dropHere).perform();
        Thread.sleep(3000);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectedYazi="Dropped!";
        String actualYazi=sonucYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }
}

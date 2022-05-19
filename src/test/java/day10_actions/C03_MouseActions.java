package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;
import java.util.stream.Collectors;

public class C03_MouseActions extends TestBase {

    /*
    1- Yeni bir class olusturalim: MouseActions1
2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
3- Cizili alan uzerinde sag click yapalim
4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    test edelim.
5- Tamam diyerek alert’i kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/context_menu ");

        //System.out.println(firstWindowId);
        //3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlan);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        //driver.switchTo().window(firstWindowId);
        //String expectedText="You selected a context menu";
        //String actualText=driver.switchTo().alert().getText();
        // Assert.assertEquals(expectedText,actualText);


        //5- Tamam diyerek alert’i kapatalim
        //driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String firstWindowId = driver.getWindowHandle();
        System.out.println(firstWindowId);
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        Set<String> handleList = driver.getWindowHandles();
        System.out.println(handleList);

        String secondWindowHandleID = handleList.stream().
                filter(t -> !t.equals(firstWindowId)).
                collect(Collectors.toList()).
                get(0);
        System.out.println(secondWindowHandleID);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(secondWindowHandleID);
        Assert.assertEquals("Elemental Selenium", driver.findElement(By.xpath("//h1")).getText());

    }
}

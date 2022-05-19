package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));

        //once arama kutusuna click yapin
        //sonra harf harf Nutella yazdirin
        //sonra da ENTER tusuna basalim

        Actions actions=new Actions(driver);
        /*
        actions.click(searchBox).perform();
        actions.keyDown(Keys.SHIFT).perform();//bu kaldirilana kadar shift uzerinde kalmaya devam eder
        actions.sendKeys("n").perform();
         */

        actions.click(searchBox).
                keyDown(Keys.SHIFT)
                .sendKeys("n")
                .keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER)
                .perform();
    }
}

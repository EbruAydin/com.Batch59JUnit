package day13_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    //1- Amazon anasayfaya gidin
    //2- tum cookie’leri listeleyin
    //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
    //6- eklediginiz cookie’nin sayfaya eklendigini test edin
    //7- ismi skin olan cookie’yi silin ve silindigini test edin
    //8- tum cookie’leri silin ve silindigini test edin

    @Test
    public void test(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> CookiesSet=driver.manage().getCookies();
        System.out.println(CookiesSet);
        int sayac=1;
        for (Cookie each:CookiesSet) {
            System.out.println(sayac+ " .ci cookie : " +each);
            System.out.println("name :" + each.getName());
            System.out.println("value : " + each.getValue());
            sayac++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        Assert.assertTrue(CookiesSet.size()>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        for (Cookie each: CookiesSet
        ) {
            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD", each.getValue());
            }
        }
        /*
        Expected :USD
        Actual   :"L5Z9:SE"
         */

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin

        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        sayac=1;
        CookiesSet=driver.manage().getCookies();
        for (Cookie each:CookiesSet) {
            System.out.println(sayac+ " .ci cookie : " +each);
            sayac++;
        }
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(CookiesSet.contains(cookie));

        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(CookiesSet.contains("skin"));

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        CookiesSet=driver.manage().getCookies();
        Assert.assertTrue(CookiesSet.isEmpty());
    }

}

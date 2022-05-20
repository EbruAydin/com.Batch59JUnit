package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01() {

        System.out.println(System.getProperty("user.dir"));//C:\Users\aydnn\IdeaProjects\com.Batch59JUnit
        //bana icinde oldugum projenin dosya yolunu/path verir

        System.out.println(System.getProperty("user.home"));//C:\Users\aydnn
        //benim bilgisayarimin bana ozel kismini verir

        //herhangi bir dosyada sagtus copy path yaparbilirsiniz

        //C:\Users\aydnn\OneDrive\Desktop\Yeni Metin Belgesi.txt
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\text.txt";

        System.out.println(dosyaYolu);
        /*
        bilgisayarimizdaki bir dosyanin varligini test etmek icin
        once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna yani path'e ihtiyac vardir
        Her bilgisayarin kullanici adi farkli oldugundan masaustu dosya yolu da
        birbirindan farkli olacakir
        Testlerimizden tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz

        bunun icin
        her bilgisayarin birbirinden farkli olan yolunu bulmak icin
        String farkliKisim=System.getproperty("user.home")

        herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim="\\Desktop\\text.txt";
         */

        String farkliKisim=System.getProperty("user.home");
       // String ortakKisim="\\Desktop\\text.txt";
        String ortakKisim="\\OneDrive\\Desktop\\Yeni Metin Belgesi.txt";
        String masaustuDosyaYolu=farkliKisim+ortakKisim;

        System.out .println(Files.exists(Paths.get(masaustuDosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));
    }
}

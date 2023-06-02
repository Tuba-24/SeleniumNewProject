package techproed.day05_Xpath_CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CssSelector {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);


        //Add Element butonuna basin
        driver.findElement(By.cssSelector("button[onclick ='addElement()']")).click();
        Thread.sleep(2000);

        //Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.cssSelector("button[class='added-manually']"));
        if(deleteButonu.isDisplayed()){
            System.out.println("Delete butonu gorunur");
        }else System.out.println("Delete butonu gorunur degil");
        Thread.sleep(2000);

        //Bu sekilde de olabilir
        //System.out.println("Delete butonu görünür mü? = " + deleteButonu.isDisplayed());



        //Delete butonuna basin
        deleteButonu.click();
        Thread.sleep(2000);


        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
        WebElement addRemoveElemenet = driver.findElement(By.cssSelector("h3"));
        if(addRemoveElemenet.isDisplayed()){
            System.out.println("Add/Remove Element Yazisi Gorunur");
        }else System.out.println("Add/Remove Element Yazisi Gorunur Degil");
        Thread.sleep(2000);



        //Sayfayı kapatın
        driver.close();

        /*

        Xpath ve cssSelector arasındaki farklar:

        - Xpath text ile calısır.
        - cssSelector text ile calısmaz
        - Xpath index'e göre arama yapabilir.Daha fazla kombinasyona sahiptir.
        - cssSelector index'e göre arama yapamaz. Daha hızlı calısır

         */

    }
}

package techproed.day05_Xpath_CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_Nt_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        /*
        Benzer ozelliklere sahip webelementler icin relative locator kullanabiliriz.
        SYNTAX;
        driver.findElement(with(By.tagname).below().above().to_left_of().to_right_of().near())
        gibi methodlarla benzer ozelliklere sahip webelementleri location almadan o web elemente ulasabiliriz.
         */
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //Amazona gidelim
        driver.get("https://amazon.com");


        //city bike aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);


        //relative locator kullanarak hybrid bikes altindaki elemente tiklayalim
        WebElement hybridBikes = driver.findElement(By.xpath("//span[text()='Hybrid Bikes']"));
        WebElement electiricBike = driver.findElement(with(By.tagName("a")).below(hybridBikes));
        WebElement completeBike = driver.findElement(with(By.tagName("a")).below(electiricBike));
        completeBike.click();

        //Sayfayi kapatiniz

        driver.close();
    }
}

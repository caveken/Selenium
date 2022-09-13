package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Odev {
    public static void main(String[] args) throws InterruptedException {
        /*
1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
2- Add Element butonuna basin
3- Delete butonu'nun gorunur oldugunu test edin
4- Delete tusuna basin
5- "Add/Remove Elements" yazisinin gorunur oldugunu test edin
 */

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();

        //3- Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteB = driver.findElement(By.xpath("//*[@onclick='deleteElement()']"));

        if (deleteB.isDisplayed()) {
            System.out.println("Delete Butonu gorunurlugu PASSED");
        } else System.out.println("Delete Butonu gorunurlugu FAILED");

        //4- Delete tusuna basin
        Thread.sleep(2000);
        deleteB.click();
        //5- "Add/Remove Elements" yazisinin gorunur oldugunu test edin
        WebElement addButon = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        if (addButon.isDisplayed()) {
            System.out.println("Add Butonu gorunurlugu PASSED");
        } else System.out.println("Add Butonu gorunurlugu FAILED");

        driver.quit();
    }
}

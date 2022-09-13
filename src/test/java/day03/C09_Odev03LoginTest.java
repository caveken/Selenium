package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.security.auth.kerberos.KeyTab;
import java.time.Duration;
import java.util.List;

public class C09_Odev03LoginTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //        a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        //Thread.sleep(3000);

        //b. Sign in butonuna basin
        driver.findElement(By.xpath("//a[@data-test='sign-in']")).click();
        //Thread.sleep(3000);// bu olmazsa calismiyor
        //c. email textbox,password textbox, and signin button elementlerini locate
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement signButon = driver.findElement(By.xpath("//input[@value='Sign in']"));


        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //i. Username :
        //testtechproed@gmail.com
        email.sendKeys("testtechproed@gmail.com");

        //ii. Password : Test1234!
        password.sendKeys("Test1234!");
        signButon.click();
        //e. Expected user id nin
        //testtechproed@gmail.com oldugunu dogrulayin(verify).
        //Thread.sleep(3000);
        WebElement userId = driver.findElement(By.className("navbar-text"));
        System.out.println(userId);
        String actualId = userId.getText();
        if (actualId.equals("testtechproed@gmail.com")){
            System.out.println("UserId test PASSED");
        }else System.out.println("UserId test FAILED");
        System.out.println(actualId);
        //f. "Addresses" ve "Sign Out" textlerinin görüntülendiğini(displayed) doğrulayin(verify).
        //Thread.sleep(3000);
        WebElement adress = driver.findElement(By.xpath("//a[@data-test='addresses']"));

        String actualadres = adress.getText();
        if (actualadres.equals("Addresses")){
            System.out.println("adres test PASSED");
        }else System.out.println("adres test FAILED");
        System.out.println(actualadres);


        //Thread.sleep(3000);
        WebElement signout = driver.findElement(By.xpath("//a[@data-test='sign-out']"));
        String actualsignout = signout.getText();
        if (actualsignout.equals("Sign Out")){
            System.out.println("sign Out test PASSED");
        }else System.out.println("sign Out test FAILED");
        System.out.println(actualsignout);

        //3. Sayfada kac tane link oldugunu bulun.
/*
        List<WebElement> tags = driver.findElements(By.tagName("a"));
        System.out.println("Link sayisi: "+tags.size());
*/
        driver.findElements(By.tagName("a")).
                stream().
                forEach(t-> System.out.println(t.getText()));
        System.out.println("Link adedi : "+driver.
                findElements(By.tagName("a")).
                stream().
                count());

        driver.close();
/*
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        olarak thread.sleep olamadan kullandıgımızda
        hatasız calısıyor ama SocketException: Connection reset hatası fırlatıyor

        thread.sleep ile calıstırınca exc. fırlatmıyor
 */


    }
}

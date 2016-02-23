import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Marchenko on 23.02.2016.
 */
public class MyTest {
    public static String Angel (WebDriver h, String master, String site){
        h.findElement(By.name("master")).sendKeys(master);
        h.findElement(By.name("site")).sendKeys(site);
        h.findElement(By.name("site")).sendKeys(Keys.ENTER);
        h.findElement(By.name("password")).getAttribute("value");
        String s=h.findElement(By.name("password")).getAttribute("value");
        return s;
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:/Course/chromedriver_win32/chromedriver.exe");
        WebDriver h = new ChromeDriver();
        h.manage().window().maximize();
        h.get("http://angel.net/~nic/passwd.sha1.1a.html");
        compare(Angel(h, "12345678", "missile2013@yandex.ru"), "nVQiy+y71a");

        System.out.println(Angel(h, "12345678", "missile2013@yandex.ru"));

        Thread.sleep(5000);
        h.quit();

    }
    public static void compare(String real, String unreal) {
        if (real == unreal) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test failed");
        }
    }

}


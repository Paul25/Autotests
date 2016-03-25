import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

/**
 * Created by Marchenko on 29.02.2016.
 */
public class ForPractice {




    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Marchenko/Documents/My Received Files/WorkDoc/Installed programms/My Settings/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        driver.findElement(By.xpath("//input[@id='mailbox__login']")).sendKeys("p.a.marchenko");
        Select dropdown = new Select(driver.findElement(By.id("mailbox__login__domain")));

        dropdown.selectByVisibleText("@inbox.ru");

        driver.findElement(By.id("mailbox__password")).sendKeys("VjqNtcn1");
        driver.findElement(By.id("mailbox__auth__button")).click();

    }
}

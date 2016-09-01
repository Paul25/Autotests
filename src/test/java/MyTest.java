import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MyTest {


   /* public static String login(WebDriver driver, String Username,String password){
        driver.findElement(By.id("gwt-uid-3")).sendKeys("dealer1");
        driver.findElement(By.id("gwt-uid-5")).sendKeys("dealer1");
        WebElement logIn = driver.findElement(By.xpath("//div[ contains(@class, 'v-button')]"));
        logIn.click();

        String result=driver.findElement(By.id("gwt-uid-5")).getCssValue("");
        return result;
    }*/

    public static void main(String[] args)  {
        //    throws InterruptedException

        /*System.setProperty("webdriver.chrome.driver", "C:/Users/Marchenko/Documents/My Received Files/WorkDoc/Installed programms/My Settings/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://192.168.2.211:8080/baikonur/#!spreadsSheetImportView");
        compare(login(driver, "dealer1","dealer1"),"dealer1");
        System.out.println(login(driver,"dealer1","dealer1"));
        Thread.sleep(5000);
        driver.quit();*/
        //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());



       /* DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));*/

        long timeMs=System.currentTimeMillis();
        Date current=new Date();
        System.out.println(current);

        String test="Hello, my dear frienD.";
        String test1="Hello, my dear friend.";
        test.equals(test1);
        System.out.println(test.compareTo(test1));



    }
  /*  public static void compare(String real, String unreal) {
        if (real == unreal) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test failed");
        }
    }*/

}


import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marchenko on 29.02.2016.
 */
public class ForPractice {
    WebDriver driverBaikonur;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/Marchenko/Documents/My Received Files/WorkDoc/Installed programms/My Settings/chromedriver_win32/chromedriver.exe");
        WebDriver driverBaikonur = new ChromeDriver();
        driverBaikonur.manage().window().maximize();
        driverBaikonur.get("http://192.168.2.211:8080/baikonur/");
        Thread.sleep(10000);
        checkBuildNumberIsPresent(driverBaikonur);
        incorectLoginName(driverBaikonur);
        loginToBaikonur(driverBaikonur);
         // instrumentTable(driverBaikonur);
        logoutFromBaikonur(driverBaikonur);

       /* System.setProperty("webdriver.chrome.driver", "C:/Users/Marchenko/Documents/My Received Files/WorkDoc/Installed programms/My Settings/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        loginToMail(driver);
        deleteMail(driver);
        forLogoutAndClose(driver);*/
    }

    public static void instrumentTable(WebDriver driverBaikonur) {

        driverBaikonur.findElement(By.xpath("//div[@id='instrumentsMenuButton']//span[@class='valo-menu-item-caption']")).click();
        driverBaikonur.findElement(By.xpath("//div[@id='instrumentView']//input[@class='v-textfield v-widget gridcellfilter v-textfield-gridcellfilter tiny v-textfield-tiny v-has-width'][1]")).sendKeys("FOREX");
    }

    public static void checkBuildNumberIsPresent(WebDriver driverBaikonur) {
        String buildReal = "1.12.1";
        WebElement buildNumber = driverBaikonur.findElement(By.xpath("//div[contains(text(),'Build: 1.12.1:[384:e8fa2f7]:2')]"));
        String buildNumberText = buildNumber.getText();

        System.out.println(buildNumberText);
        if (buildNumber.isDisplayed()) {
            if (buildNumberText.contains(buildReal)) {
                System.out.print("Build number is present");
                System.out.println(" and it is " + buildReal);
            } else System.out.println("Build number is not correct");
        } else System.out.println("Build number is absent");

    }

    public static void logoutFromBaikonur(WebDriver driverBaikonur) {
        driverBaikonur.findElement(By.xpath("//div[@id='settingsMenuBar']//span[@class='v-menubar-menuitem-caption']")).click();
        driverBaikonur.findElement(By.xpath("//div[@id='baikonur-2001441315-overlays']//span[@class='v-menubar-menuitem-caption']")).click();
        driverBaikonur.quit();
    }

    public static void loginToBaikonur(WebDriver driverBaikonur) throws InterruptedException {
        driverBaikonur.findElement(By.id("usernameInputField")).clear();
        driverBaikonur.findElement(By.id("passwordInputField")).clear();
        driverBaikonur.findElement(By.id("usernameInputField")).sendKeys("dealer1");
        driverBaikonur.findElement(By.id("passwordInputField")).sendKeys("dealer1");
        driverBaikonur.findElement(By.id("signinButton")).click();
        Thread.sleep(10000);
    }

    public static void incorectLoginName(WebDriver driverBaikonur) throws InterruptedException {
        driverBaikonur.findElement(By.id("usernameInputField")).clear();
        driverBaikonur.findElement(By.id("passwordInputField")).clear();
        driverBaikonur.findElement(By.id("usernameInputField")).sendKeys("dealer");
        driverBaikonur.findElement(By.id("passwordInputField")).sendKeys("dealer1");
        driverBaikonur.findElement(By.id("signinButton")).click();
        waitForConditions();
        Thread.sleep(10000);
    }

    public static void waitForConditions() throws InterruptedException {
        WebElement alert;
        WebDriver driverBaikonur=null;
        alert = driverBaikonur.findElement(By.xpath("//div[@id='baikonur-2001441315-overlays']//div[@class='v-Notification error v-Notification-error']"));
        // WebDriverWait waitAlert = new WebDriverWait(driverBaikonur, 10000, 10000);
        if (alert.isDisplayed()) {
            WebDriverWait waitAlert = (WebDriverWait) ExpectedConditions.visibilityOfElementLocated((By) alert);
            Thread.sleep(10000);
        }else
            loginToBaikonur(driverBaikonur);
    }



/*

    public static void forLogoutAndClose(WebDriver driver) {
driverBaikonur.findElement(By.id("PH_logoutLink")).click();
        */
/*driver.close();*//*

    }

    public static void deleteMail(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='b-nav__item js-href b-nav__item_active b-nav__item_unread']")).click();
        Thread.sleep(3000);
        WebElement mailCheckBox = driver.findElement(By.xpath("//div[@class='b-datalist__body']//div[@class='b-datalist__item js-datalist-item b-datalist__item_unread'][1]"));
        List<WebElement> elements = new ArrayList<WebElement>();
        for (int i = 0; i < 10000; i++) {
            elements.add(mailCheckBox);
        }
        if (!elements.isEmpty()) {

            driver.findElement(By.xpath("//div[@id='b-toolbar__right']//div[@class='b-checkbox__box']")).click();
            driver.findElement(By.xpath("//div[@id='b-toolbar__right']//div[@class='b-toolbar__btn b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_adaptive b-toolbar__btn_adaptive_msgl-high b-toolbar__btn_grouped b-toolbar__btn_grouped_first js-shortcut']")).click();
            Thread.sleep(5000);
        } else forLogoutAndClose(driver);
    }

    public static void loginToMail(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='mailbox__login']")).sendKeys("p.a.marchenko");
        Select dropdown = new Select(driver.findElement(By.id("mailbox__login__domain")));
        dropdown.selectByVisibleText("@inbox.ru");
        driver.findElement(By.id("mailbox__password")).sendKeys("VjqNtcn1");
        driver.findElement(By.id("mailbox__auth__button")).click();
        Thread.sleep(10000);
    }
*/

}



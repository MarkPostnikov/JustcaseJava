import java.util.Arrays;
import java.util.List;
import java.util.Set;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



class WindowHandle_Demo {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver() {
        };
        driver.get("https://two.jcdev.ru/cases/open/milspec");
        driver.manage().window().maximize();
        driver.findElement(By.className("case-item__steam-btn")).click();
        String MainWindow=driver.getWindowHandle();
        Set<String> s1=driver.getWindowHandles();

        for (String ChildWindow : s1) {
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                driver.findElement(By.id("steamAccountName")).sendKeys("markaqa");

                                driver.findElement(By.id("steamPassword")).sendKeys("test322justcase");
                                driver.findElement(By.id("imageLogin")).click();
                                Thread.sleep(7000);

            }
        }

        driver.switchTo().window(MainWindow);
        driver.findElement(By.className("case-item__open-case-fast-btn")).click();
        Thread.sleep(3000);
        String element = driver.findElement(By.className(("case-win-block__type"))).getText();
        List <String> avt = Arrays.asList("AK-47", "AUG", "CZ75-Auto", "Desert Eagle", "Dual Berettas", "Five-SeveN", "FAMAS", "G3SG1", "Galil AR", "Glock-18", "M249", "M4A1-S", "MAC-10", "MAG-7", "Negev", "Nova", "P2000",
                "P250", "P90", "PP-Bizon", "R8 Revolver", "Sawed-Off", "SCAR-20", "SG 553", "SSG 08", "Tec-9", "UMP-45", "USP-S", "XM1014", "AWP", "MP7", "MP5-SD", "M4A4", "SG 553");


        Assert.assertTrue(avt.contains(element));

        driver.close();

            }
        }



package AutomationIntro.SeleniumProjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class ResolutionAndScreenShot {

    WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Chrome driver\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\eclipse work\\SeleniumProjects\\Resource\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    @DataProvider(name = "resolutions")
    public Object[][] resolutions() {
        return new Object[][] {
            { new Dimension(1920, 1080), "Desktop_1920x1080" },
            { new Dimension(1366, 768), "Desktop_1366x768" },
            { new Dimension(1536, 864), "Desktop_1536x864" },
            { new Dimension(360, 640), "Mobile_360x640" },
            { new Dimension(414, 896), "Mobile_414x896" },
            { new Dimension(375, 667), "Mobile_375x667" }
        };
    }

    @Test(dataProvider = "resolutions")
    public void captureScreenshots(Dimension resolution, String name) throws IOException {
        driver.get("https://www.getcalley.com/page-sitemap.xml");
     
        // Links to navigate
        String[] links = {
            "https://www.getcalley.com/",
            "https://www.getcalley.com/calley-lifetime-offer/",
            "https://www.getcalley.com/see-a-demo/",
            "https://www.getcalley.com/calley-teams-features/",
            "https://www.getcalley.com/calley-pro-features/"
        };

        for (String link : links) {
            driver.findElement(By.linkText(link)).click();

            driver.manage().window().setSize(resolution);
            // Wait for the page to adjust to the new resolution
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String fileName = name + "_" + timestamp;
            String folderPath = "C:\\DealsDray Assesment Test\\ScreenShot\\" + name + "\\" + resolution.width + "x" + resolution.height;
            new File(folderPath).mkdirs(); 
            Shutterbug.shootPage(driver, Capture.FULL, true).withName(fileName).save(folderPath);

            // Navigate back to the sitemap
            driver.navigate().back();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

package Tasks2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Task1 {
        private WebDriver driver;
        @BeforeClass
        public void setUp() {
            driver = new ChromeDriver();
        }
        @Test
        public void testFacebook() {
            driver.navigate().to("https://www.facebook.com");
        }

        @Test(dependsOnMethods = "testFacebook")
        public void testGoogle() {
            driver.get("https://www.google.com");
        }

        @Test(dependsOnMethods = "testGoogle")
        public void testAmazon() {
            driver.get("https://www.amazon.com");
        }
        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }


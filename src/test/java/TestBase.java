import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestBase {

    static final String siteMainURL = "https://www.sberbank.ru/ru/person";
    static WebDriver driver;
    static WebDriverWait wait;

        @BeforeEach
        public void start() {

//            //mvn clean integration-test -Dbrowser=opera
//            String browser = System.getProperties().getProperty("browser");
//        switch (browser) {
//            case "chrome": {
//                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//                driver = new ChromeDriver();
//                break;
//            }
//            case "opera": {
//                System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
//                driver = new OperaDriver();
//                break;
//            }
//        }
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 20);

        }


    public void isElementDisplayed(By elementBy) {
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());

    }

    public static void goTo() {
        driver.get(siteMainURL);
    }

    public static void waitClicability(By elementBy) {
        WebElement element = driver.findElement(elementBy);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }


    public static void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public static void enter(By elementBy, String text) {
            WebElement we = driver.findElement(elementBy);
        wait.until(ExpectedConditions.visibilityOf(we));
        driver.findElement(elementBy).sendKeys(text);
    }

    public static void checkFields(By field, String value) {
            assertTrue(driver.findElement(field).getAttribute("value").equals(value), value);
    }


    public void click(By elementBy) {
        waitClicability(elementBy);
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

//    static Stream<Arguments> parametrsForTest() {
//        return Stream.of(
//                arguments("Ivanov", "Ivan", "26.05.2000", "Иванов", "Иван", "Иванович", "26.05.1990", "M", "1485", "123456", "25.02.2005", "Кем-то"),
//                arguments("Ivanova", "Anna", "22.03.2001", "Иванова", "Анна", "Алексеевна", "22.03.19911", "F", "1421", "123451", "25.02.2006", "Кем-то2"),
//                arguments("Ivanov", "Serg", "26.05.2000", "Иванов", "Серж", "Иванович", "21.01.2010", "M", "1485", "123459", "25.02.2020", "Кем-то3"));
//    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}



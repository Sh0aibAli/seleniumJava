package utilities;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.xml.sax.Locator;
import tech.grasshopper.pdf.section.details.executable.LogMessageDisplay;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Properties;

public class BaseFunctions {
    public static String browser;
    private DriverFactory driverFactory;
    protected static WebDriver driver;
    Properties prop;

    protected void hardwait(int sec) {
        try {
            Thread.sleep(sec * 500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private By getBy(String locatorType, String locatorValue) {
        switch (Locators.valueOf(locatorType)) {
            case id:
                return By.id(locatorValue);
            case xpath:
                return By.xpath(locatorValue);
            case css:
            case cssSelector:
                return By.name(locatorValue);
            case classname:
                return By.className(locatorValue);
            case linktext:
                return By.linkText(locatorValue);
            default:
                return By.id(locatorValue);
        }
    }

    protected By getLocator(By elementToken, String replacement) {
        if (!replacement.isEmpty()) {
            String loc = elementToken.toString().replaceAll("\'", "\\\"");
            String type = loc.split(":", 2)[0].split("\\.")[1];
            String variable = loc.split(":", 2)[1].replaceAll("\\$\\{.+?\\}", replacement);
            return getBy(type, variable);
        } else
            return elementToken;
    }

    protected WebElement element(By elementToken) {
        hardwait(1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",
                driver.findElement(getLocator(elementToken, "")));
        hardwait(1);
        js.executeScript("arguments[0].setAttribute('style', '');", driver.findElement(getLocator(elementToken, "")));
        return driver.findElement(getLocator(elementToken, ""));
    }

    protected void scrollIntoElement(By elem)
    {
    WebElement element = element(elem);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    protected void scrollIntoElement(WebElement elem)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); ",elem);
    }
    protected WebElement element(By elementToken, String replacement)
    {
        return driver.findElement(getLocator(elementToken, replacement));
    }
    public void initializeSession() {
        logMessage("*********************** Session Started ****************************");
        new PropFileHandler();
        String browserName = PropFileHandler.readProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_Driver(browserName);
        logMessage("Browser is: " + browserName.toUpperCase());
        driver.manage().window().maximize();
    }

    public static void closeSession() {
        if (driver != null) {
            driver.quit();
            logMessage("*********************** Session closed *****************************");
        }
    }

    public void launchApplication(String url) {
        initializeSession();
        driver.get(url);
    }

    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void logMessage(String msg) {
        Reporter.log(msg, true);
    }
    public void waitForElementToBeVisible(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void vk_TAB(int times) throws AWTException, InterruptedException
    {
        Robot robot = new Robot();
        for (int i=0; i<times; i++)
        {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
    }

    public static void vk_Enter(int times) throws AWTException, InterruptedException
    {
        Robot robot = new Robot();
        for (int i=0; i<times; i++)
        {
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }
}

package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus
     * subclases
     */
    protected static WebDriver driver;
    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando
     * el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    Actions action = new Actions(driver);
    /*
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el
     * driver del navegador
     */
    static {
        WebDriverManager.chromedriver().setup();
        // Inicializa la variable estática 'driver' con una instancia de ChromeDriver
        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void goToLinkText(String pageNumber) {
        driver.findElement(By.linkText(pageNumber)).click();
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public String textFromElement(String locator) {
        return find(locator).getText();
    }

    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        find(locator).click();
    }

    public void write(String locator, String keysToSend) {
        find(locator).clear();
        find(locator).sendKeys(keysToSend);
    }

    public void selectFromDropdownByValue(String locator, String value) {
        Select dropdown = new Select(find(locator));

        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(String locator, Integer index) {
        Select dropdown = new Select(find(locator));

        dropdown.selectByIndex(index);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));

        dropdown.selectByValue(valueToSelect);
    }

    public void hoverOverElement(String locator) {
        action.moveToElement(find(locator));
    }

    public void doubleClick(String locator) {
        action.doubleClick(find(locator));
    }

    public void rightClick(String locator) {
        action.contextClick(find(locator));
    }

    public int dropDownSize(String locator) {
        Select dropdown = new Select(find(locator));

        List<WebElement> droptDownOptions = dropdown.getOptions();

        return droptDownOptions.size();
    }

    public List<String> getDropDownValues(String locator) {
        Select dropdown = new Select(find(locator));

        List<WebElement> dropDownOptions = dropdown.getOptions();
        List<String> dropDownValues = new ArrayList<String>();

        for (WebElement option : dropDownOptions) {
            dropDownValues.add(option.getText());
        }

        return dropDownValues;
    }
}

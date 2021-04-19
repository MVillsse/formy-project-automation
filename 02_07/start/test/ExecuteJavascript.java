import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class ExecuteJavascript {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/Miri/Documents/Driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/modal");

        WebElement modalButton = driver.findElement(By.id("modal-button"));
        modalButton.click();

        WebElement closeButton = driver.findElement(By.id("close-button"));
        JavascriptExecutor js = (JavascriptExecutor)driver; //se crea objeto js con clase JavascriptExecutor
        //puedo usar este objeto js  para ejecutar un script.
        js.executeScript("arguments[0].click();", closeButton);//usaré executeScript en esta situación,
        // en lugar de executeAsyncScript,
        //se hará clic en el botón modal . Una vez que el modal está abierto,
        // el JavascriptExecutor ejecutará un script simple para presionar el
        // botón de cerrar, y luego el controlador se cerrará
        driver.quit();
    }
}

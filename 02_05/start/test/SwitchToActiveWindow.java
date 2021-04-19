import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToActiveWindow {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/Miri/Documents/Driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/switch-window");
        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click(); //se hace click en el boton de nueva pestaña para abrir la segunda pestaña
        //hay 2 pestañas abiertas, se quiere obtener la key de las 2 ventanas abiertas y luego
        //cambiar a la ventana que ya está abierta, para esto se usa el metodo getWindowHandle
        //aca se define una nueva variable originalHandle
        String originalHandle = driver.getWindowHandle(); //aca se indica al driver que busque la ventana ya abierta
        //con el bucle se itera a través de los 2 identificadores de las ventanas y volver
        //a la pestaña que se abrió originalmente
        //getWindowHandles obtiene 2 identificadores de ventana
        for(String handle1: driver.getWindowHandles()) {
            driver.switchTo().window(handle1); //se agrega una llave driver.swithTo.window, especificando handle1
        }

        driver.switchTo().window(originalHandle); //aca se vuelve a la ventana original
        driver.quit();
    }
}

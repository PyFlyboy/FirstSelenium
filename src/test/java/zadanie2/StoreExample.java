package zadanie2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;
public class StoreExample {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("https://prod-kurs.coderslab.pl");
    }
    @Test
    public void testProductSearch() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy

        String [] products = {"mug", "t-shirt", "notebook", "sweater", "poster","cushion", "vector", "graphics", "pack"};
        Random random = new Random();
        //losuje liczby z przedziału 0 - 49
        int randomInteger = random.nextInt(50);
        int wynikdzielenia = randomInteger % products.length;
        // Wpisz informacje do wyszukania

        WebElement element = driver.findElement(By.name("s"));
        // Wyczyść teskst zapisany w elemencie
        element.clear();

        // Wpisz informacje do wyszukania
        element.sendKeys(products[wynikdzielenia]);

        // Prześlij formularz
        element.submit();
    }
    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        driver.quit();
    }













}

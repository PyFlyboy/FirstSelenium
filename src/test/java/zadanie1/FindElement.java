package zadanie1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;


public class FindElement {

           private WebDriver driver;

        @Before
        public void setUp() {
            // Uruchom nowy egzemplarz przeglądarki Chrome
            System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/ChromeDriver/chromedriver.exe");
            driver = new ChromeDriver();

            // Zmaksymalizuj okno przeglądarki
            driver.manage().window().maximize();
            // Przejdź do Google
            driver.get("http://www.bing.com");
        }
        @Test
        public void testGoogleSearch() {
            // Znajdź element wprowadzania tekstu na podstawie jego nazwy
            WebElement element = driver.findElement(By.name("q"));
            // Wyczyść teskst zapisany w elemencie
            element.clear();

            // Wpisz informacje do wyszukania
            element.sendKeys("Mistrzostwa Swiata w pilce noznej 2018");

            // Prześlij formularz
            element.submit();
        }
        @After
        public void tearDown() throws Exception {
            // Zamknij przeglądarkę
            driver.quit();
        }
    }


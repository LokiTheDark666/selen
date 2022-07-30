package ru.netology;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CallBackTest {

    private WebDriver driver;


    @BeforeAll
    static void SetUpAll() {
        System.setProperty("webdriver.chrome.driver", "driver/win/chromedriver.exe");

    }

    @BeforeEach
    void SetUp() {
        driver = new ChromeDriver();
    }

    @Test
    void test() {
        driver.get("http://localhost:9999/");
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        elements.get(0).sendKeys("Вася Пупкин");
        elements.get(1).sendKeys("+89996664545");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.className("Success_successBlock__2L3Cw")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }


    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }


}


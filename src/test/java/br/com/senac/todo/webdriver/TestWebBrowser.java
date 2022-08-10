package br.com.senac.todo.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class TestWebBrowser {

    private WebDriver driver;
    private WebElement searchBox;
    private WebElement searchResults;

    @BeforeEach
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void closeBrowser() {
        //driver.quit();
    }

    @Test
    void search(){
        driver.get("https://www.google.com.br");

        searchBox = driver.findElement(By.cssSelector("[name='q']"));
        searchBox.sendKeys("Senac RJ");

        driver.manage().window().maximize();
        searchBox.submit();

        searchResults = driver.findElement(By.cssSelector("#search"));

        assertTrue(searchResults.isDisplayed());
        assertThat(driver.getTitle().startsWith("Senac Rio"));
    }


    @Test
    void searchSenacRJ(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.rj.senac.br/");
        driver.manage().window().maximize();

        searchBox = driver.findElement(By.id("bt-opensearch"));
        searchBox.click();

        searchBox = driver.findElement(By.cssSelector("[name='s']"));
        searchBox.sendKeys("Técnico em Informática");
        searchBox.submit();

        searchBox = driver.findElement(By.className("thumb-busca"));
        searchBox.click();

        searchResults = driver.findElement(By.className("turma-item"));

        assertTrue(searchResults.isDisplayed());
        assertThat(driver.getTitle().startsWith("Turma 2022.3"));
    }
}

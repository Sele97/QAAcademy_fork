package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlujoTestContinuo {
    private ChromeDriver driver;

    String chromeDriverPath = "C:\\Users\\SeleneFigueroa\\OneDrive - Kopius\\Desktop\\Automation\\chromedriver-win64\\chromedriver.exe";
    String formPath = "file:///C:/Users/SeleneFigueroa/IdeaProjects/QAAcademy/src/main/resources/TorneoHTML/registro.html";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private List<Usuarios> obtenerusuarios() {
        List<Usuarios> listausuarios = new ArrayList<>();
        listausuarios.add(new Usuarios("Andres Dalmau", "1122435678", "axdny@hotmail.com", "axndy#1337", "axdny", "85", "TOP", "JUNGLA", "Argentina"));
        listausuarios.add(new Usuarios("Manuel Varea", "1122785432", "manu.varea@hotmail.com", "", "ManuV", "78", "SOPORTE", "", "Argentina"));
        listausuarios.add(new Usuarios("Selene Figueroa", "1122985346", "sele97@hotmail.com", "", "SeleBF", "82", "MID", "", "Argentina"));
        listausuarios.add(new Usuarios("Ivan Gomez", "1167349712", "ivang@hotmail.com", "mau97", "mauu25", "75", "TOP", "JUNGLA", "Argentina"));
        listausuarios.add(new Usuarios("Christian Zamora", "1122774307", "chris.zamora@hotmail.com", "", "ChrisZ", "75", "JUNGLA", "", "Argentina"));
        return listausuarios;
    }

    @Test
    public void flujocontinuo() {
        List<Usuarios> listausuarios = obtenerusuarios();

        for (Usuarios obtenerUsuarios : listausuarios) {

            driver.manage().window().maximize();
            driver.get(formPath);

            WebElement nombre = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[1]/input"));
            nombre.sendKeys(obtenerUsuarios.getNombre());

            WebElement telefono = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[2]/input"));
            telefono.sendKeys(obtenerUsuarios.getTelefono());

            WebElement email = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[3]/input"));
            email.sendKeys(obtenerUsuarios.getEmail());

            WebElement discord = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[4]/input"));
            discord.sendKeys(obtenerUsuarios.getDiscord());

            WebElement ign = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[5]/input"));
            ign.sendKeys(obtenerUsuarios.getIgn());

            WebElement nivel = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[6]/input"));
            nivel.sendKeys(obtenerUsuarios.getNivel());

            WebElement dropdownRolprincipal = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[7]/select"));
            Select select = new Select(dropdownRolprincipal);
            select.selectByVisibleText(obtenerUsuarios.getRolprincipal());

            WebElement dropdownRolsecundario = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[8]/select"));
            Select select1 = new Select(dropdownRolsecundario);
            select1.selectByVisibleText(obtenerUsuarios.getRolsecundario());

            WebElement dropdownpais = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[9]/select"));
            Select select2 = new Select(dropdownpais);
            select2.selectByVisibleText(obtenerUsuarios.getPais());

            Select selectPrincipal = new Select(driver.findElement(By.xpath("//*[@id='registroForm']/label[7]/select")));
            selectPrincipal.selectByVisibleText(obtenerUsuarios.getRolprincipal());

            Select selectSecundario = new Select(driver.findElement(By.xpath("//*[@id='registroForm']/label[8]/select")));
            selectSecundario.selectByVisibleText(obtenerUsuarios.getRolsecundario());

            Select selectPais = new Select(driver.findElement(By.xpath("//*[@id='registroForm']/label[9]/select")));
            selectPais.selectByVisibleText(obtenerUsuarios.getPais());

            WebElement registrar = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/button[1]"));
            registrar.click();

            Alert alerta = driver.switchTo().alert();
            String alertaText = alerta.getText();

            assertEquals("Formulario enviado con éxito. ¡Gracias por registrarte!", alertaText); //el assert equals, el primer argumento es lo que deberia aparecer y el segundo es lo que aparece

            alerta.accept();
        }
        sleep(1);

        driver.get("file:///C:/Users/SeleneFigueroa/IdeaProjects/QAAcademy/src/main/resources/TorneoHTML/Homepage.html");
        sleep(1);

        WebElement Equipos = driver.findElement(By.xpath("/html/body/nav/div/ul[1]/li[3]/a"));
        Equipos.click();
        sleep(1);

        driver.get("file:///C:/Users/SeleneFigueroa/IdeaProjects/QAAcademy/src/main/resources/TorneoHTML/Homepage.html");
        sleep(1);
        driver.get("file:///C:/Users/SeleneFigueroa/IdeaProjects/QAAcademy/src/main/resources/TorneoHTML/nombre_equipo.html");
        WebElement boton_nombre = driver.findElement(By.name("nombre_equipo"));
        sleep(1);
        boton_nombre.sendKeys("LosQA");
        sleep(3);

        WebElement guardar = driver.findElement(By.xpath("//*[@id=\"equipoForm\"]/button[1]"));
        guardar.click();
        sleep(2);

        Alert alerta = driver.switchTo().alert();
        String alertaText = alerta.getText();

        assertEquals("Nombre del equipo guardado correctamente.", alertaText);
        alerta.accept();
        sleep(2);

        driver.get("file:///C:/Users/SeleneFigueroa/IdeaProjects/QAAcademy/src/main/resources/TorneoHTML/mail_equipo_creado.html");
        WebElement botonVolver = driver.findElement(By.xpath("/html/body/div/div/div/div/dl/button/a"));
        botonVolver.click();
    }

    private static void sleep(int segundos) {

        int ms = segundos * 1000;

        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


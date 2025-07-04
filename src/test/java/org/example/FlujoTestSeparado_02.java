package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)


public class FlujoTestSeparado_02 {
    private WebDriver driver;
    private final String chromeDriverPath = "C:\\Users\\SeleneFigueroa\\OneDrive - Kopius\\Desktop\\Automation\\chromedriver-win64\\chromedriver.exe";
    private String formPath;

    {
        try {
            formPath = getClass().getClassLoader().getResource("TorneoHTML/").toURI().toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }

    @AfterAll
    public void destroy() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    public void cargaUsuariosTest() {

        List<Usuarios> usuarios = obtenerUsuarios();
        driver.get(formPath + "HomePage.html");
        driver.findElement(By.xpath("(//a[normalize-space()='Registro de Jugador'])[1]")).click();

        for (Usuarios usuario : usuarios) {

            WebElement nombre = driver.findElement(By.xpath("(//input[@name='nombre'])[1]"));
            nombre.sendKeys(usuario.getNombre());

            WebElement telefono = driver.findElement(By.xpath("(//input[@name='telefono'])[1]"));
            telefono.sendKeys(usuario.getTelefono());

            WebElement email = driver.findElement(By.xpath("(//input[@name='email'])[1]"));
            email.sendKeys(usuario.getEmail());

            WebElement discord = driver.findElement(By.xpath("(//input[@name='discord'])[1]"));
            discord.sendKeys(usuario.getDiscord());

            WebElement ign = driver.findElement(By.xpath("(//input[@name='ign'])[1]"));
            ign.sendKeys(usuario.getIgn());

            WebElement nivel = driver.findElement(By.xpath("(//input[@name='nivel'])[1]"));
            nivel.sendKeys(usuario.getNivel());

            WebElement dropdownRolprincipal = driver.findElement(By.xpath("(//select[@name='rol_principal'])[1]"));
            dropdownRolprincipal.sendKeys(usuario.getRolprincipal());

            WebElement dropdownRolsecundario = driver.findElement(By.xpath("(//select[@name='rol_secundario'])[1]"));
            dropdownRolsecundario.sendKeys(usuario.getRolsecundario());

            WebElement pais = driver.findElement(By.xpath("(//select[@name='pais'])[1]"));
            pais.sendKeys(usuario.getPais());

            WebElement registrar = driver.findElement(By.xpath("(//button[normalize-space()='Registrarse'])[1]"));
            registrar.click();

            Alert alerta = driver.switchTo().alert();
            String alertaText = alerta.getText();

            assertEquals("Formulario enviado con éxito. ¡Gracias por registrarte!", alertaText);

            alerta.accept();
        }
        sleep(2);
        driver.findElement(By.xpath("(//a[normalize-space()='Equipos asignados'])[1]")).click();
        sleep(2);
    }

    @Test
    @Order(2)
    public void equiposYnombreTest() {
        driver.get(formPath + "equipos.html");

        WebElement dropDown = driver.findElement(By.xpath("(//a[normalize-space()='Welcome QA Trainee'])[1]"));
        dropDown.click();

        WebElement boton_Nombre = driver.findElement(By.xpath("(//a[normalize-space()='Nombre Equipo'])[1]"));
        boton_Nombre.click();

        WebElement inputNombre = driver.findElement(By.xpath("(//input[@name='nombre_equipo'])[1]"));
        inputNombre.sendKeys("LosQA");
        sleep(2);

        WebElement guardar = driver.findElement(By.xpath("(//button[normalize-space()='Guardar Nombre'])[1]"));
        guardar.click();

        Alert alerta = driver.switchTo().alert();
        String alertaText = alerta.getText();
        sleep(2);

        assertEquals("Nombre del equipo guardado correctamente.", alertaText);

        alerta.accept();

    }

    private List<Usuarios> obtenerUsuarios() {

        List<Usuarios> usuarios = new ArrayList<>();

        usuarios.add(new Usuarios("Andres", "1122227788", "andres@test.com", "axndy#1337",
                "axdny", "85", "Top", "", "Argentina"));
        usuarios.add(new Usuarios("Chris", "1122227188", "chris@test.com", "",
                "ChrisZ", "75", "Jungla", "", "Argentina"));
        usuarios.add(new Usuarios("Sele", "1122227299", "sele@test.com", "",
                "SeleBF", "82", "Mid", "", "Argentina"));
        usuarios.add(new Usuarios("Ivan", "1122261788", "ivan@test.com", "",
                "IvanGG", "70", "ADC", "", "Argentina"));
        usuarios.add(new Usuarios("Manu", "1133227788", "manu@test.com", "",
                "ManuV", "78", "Soporte", "", "Argentina"));

        return usuarios;

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










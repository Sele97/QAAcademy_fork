package org.example;
import com.google.common.annotations.VisibleForTesting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private final String chromeDriverPath = "C:\\Users\\SeleneFigueroa\\OneDrive - Kopius\\Desktop\\Automation\\chromedriver-win64\\chromedriver.exe";
    private final String formPath = "file:///C:/Users/SeleneFigueroa/IdeaProjects/QAAcademy/src/main/resources/TorneoHTML/registro.html";
    /*
    @Test
    public void testRegistroExitoso() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        // Lista de usuarios
        Usuarios usuario1 = new Usuarios("Selene Figueroa", "1122435678", "sele.figueroa@hotmail.com", "sele97", "sele222", "35", "TOP", "JUNGLA", "Argentina");
        Usuarios usuario2 = new Usuarios("Manuel Varea", "1122785432", "manu.varea@hotmail.com", "manuuu20", "sele222", "25", "TOP", "JUNGLA", "Argentina");
        Usuarios usuario3 = new Usuarios("Yael Pilar", "1122985346", "yae97@hotmail.com", "yae25", "ypilar", "35", "TOP", "JUNGLA", "Argentina");
        Usuarios usuario4 = new Usuarios("Mauro Repetto", "1167349712", "maurepe@hotmail.com", "mau97", "mauu25", "75", "TOP", "JUNGLA", "Argentina");
        Usuarios usuario5 = new Usuarios("Manuel Fedyna", "1122774307", "manu25@hotmail.com", "manu", "manuu", "98", "TOP", "JUNGLA", "Argentina");

        List<Usuarios> listausuarios = new ArrayList<>();

        listausuarios.add(usuario1);
        listausuarios.add(usuario2);
        listausuarios.add(usuario3);
        listausuarios.add(usuario4);
        listausuarios.add(usuario5);

        for (Usuarios usuarios : listausuarios) {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(formPath);

            // Llenar el formulario
            WebElement nombre = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[1]/input"));
            nombre.sendKeys(usuarios.getNombre());

            WebElement telefono = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[2]/input"));
            telefono.sendKeys(usuarios.getTelefono());

            WebElement email = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[3]/input"));
            email.sendKeys(usuarios.getEmail());

            WebElement nombre_usuario = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[4]/input"));
            nombre_usuario.sendKeys(usuarios.getNombre_usuario());

            WebElement ign = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[5]/input"));
            ign.sendKeys(usuarios.getIgn());

            WebElement nivel = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[6]/input"));
            nivel.sendKeys(usuarios.getNivel());

            WebElement dropdownRolprincipal = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[7]/select"));
            Select select = new Select(dropdownRolprincipal);
            select.selectByVisibleText(usuarios.getRolprincipal());

            WebElement dropdownRolsecundario = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[8]/select"));
            Select select1 = new Select(dropdownRolsecundario);
            select1.selectByVisibleText(usuarios.getRolsecundario());

            WebElement dropdownpais = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[9]/select"));
            Select select2 = new Select(dropdownpais);
            select2.selectByVisibleText(usuarios.getPais());

            Select selectPrincipal = new Select(driver.findElement(By.xpath("//*[@id='registroForm']/label[7]/select")));
            selectPrincipal.selectByVisibleText(usuarios.getRolprincipal());

            Select selectSecundario = new Select(driver.findElement(By.xpath("//*[@id='registroForm']/label[8]/select")));
            selectSecundario.selectByVisibleText(usuarios.getRolsecundario());

            Select selectPais = new Select(driver.findElement(By.xpath("//*[@id='registroForm']/label[9]/select")));
            selectPais.selectByVisibleText(usuarios.getPais());

            WebElement registrar = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/button[1]"));
            registrar.click();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Verificar mensaje de éxito
            Alert alerta = driver.switchTo().alert(); //aca cambias el 'focus' del driver a la alerta, en vez de a la pagina en general
            String alertaText = alerta.getText(); // de aca sacas el texto de la alerta

            assertEquals("Formulario enviado con éxito. ¡Gracias por registrarte!", alertaText); //el assert equals, el primer argumento es lo que deberia aparecer y el segundo es lo que aparece

            alerta.accept(); // este metodo lo que hace es como si clickeases aceptar en la alerta, y podes seguir testeando normal


            driver.quit();

     */

    @Test
    public void testNombrevacio() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        Usuarios usuario1 = new Usuarios("Selene Figueroa", "1122435678", "sele.figueroa@hotmail.com", "sele97", "sele222", "35", "TOP", "JUNGLA", "Argentina");
        Usuarios usuario2 = new Usuarios("Manuel Varea", "1122785432", "manu.varea@hotmail.com", "manuuu20", "sele222", "25", "TOP", "JUNGLA", "Argentina");
        Usuarios usuario3 = new Usuarios("Yael Pilar", "1122985346", "yae97@hotmail.com", "yae25", "ypilar", "35", "TOP", "JUNGLA", "Argentina");
        Usuarios usuario4 = new Usuarios("Mauro Repetto", "1167349712", "maurepe@hotmail.com", "mau97", "mauu25", "75", "TOP", "JUNGLA", "Argentina");
        Usuarios usuario5 = new Usuarios("", "1122774307", "jugomez@hotmail.com", "", "juu", "21", "TOP", "JUNGLA", "Argentina");
        Usuarios usuario6 = new Usuarios("Manuel Fedyna", "1122774307", "manu25@hotmail.com", "manu", "manuu", "98", "TOP", "JUNGLA", "Argentina");

        List<Usuarios> listausuarios = new ArrayList<>();

        listausuarios.add(usuario1);
        listausuarios.add(usuario2);
        listausuarios.add(usuario3);
        listausuarios.add(usuario4);
        listausuarios.add(usuario5);
        listausuarios.add(usuario6);

        for (Usuarios usuarios : listausuarios) {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(formPath);

            WebElement nombre = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[1]/input"));
            nombre.sendKeys(usuarios.getNombre());

            WebElement telefono = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[2]/input"));
            telefono.sendKeys(usuarios.getTelefono());

            WebElement email = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[3]/input"));
            email.sendKeys(usuarios.getEmail());

            WebElement discord = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[4]/input"));
            discord.sendKeys(usuarios.getDiscord());

            WebElement ign = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[5]/input"));
            ign.sendKeys(usuarios.getIgn());

            WebElement nivel = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[6]/input"));
            nivel.sendKeys(usuarios.getNivel());

            WebElement dropdownRolprincipal = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[7]/select"));
            Select select = new Select(dropdownRolprincipal);
            select.selectByVisibleText(usuarios.getRolprincipal());

            WebElement dropdownRolsecundario = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[8]/select"));
            Select select1 = new Select(dropdownRolsecundario);
            select1.selectByVisibleText(usuarios.getRolsecundario());

            WebElement dropdownpais = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[9]/select"));
            Select select2 = new Select(dropdownpais);
            select2.selectByVisibleText(usuarios.getPais());

            Select selectPrincipal = new Select(driver.findElement(By.xpath("//*[@id='registroForm']/label[7]/select")));
            selectPrincipal.selectByVisibleText(usuarios.getRolprincipal());

            Select selectSecundario = new Select(driver.findElement(By.xpath("//*[@id='registroForm']/label[8]/select")));
            selectSecundario.selectByVisibleText(usuarios.getRolsecundario());

            Select selectPais = new Select(driver.findElement(By.xpath("//*[@id='registroForm']/label[9]/select")));
            selectPais.selectByVisibleText(usuarios.getPais());

            WebElement registrar = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/button[1]"));
            registrar.click();

                   /*
                    Corta la ejecucion cuando encuentra un usuario con el nombre vacio.
                    try {
                        Alert alerta = driver.switchTo().alert();
                        if (usuarios.getNombre_usuario().isEmpty()) {
                            alerta.accept();
                            driver.quit();
                            throw new AssertionError("El formulario se envió con un nombre de usuario vacío.");
                        } else {
                            String alertaText = alerta.getText();
                            assertEquals("Formulario enviado con éxito. ¡Gracias por registrarte!", alertaText);
                            alerta.accept();
                        }
                    } catch (Exception e) {
                        System.out.println("No apareció la alerta. Puede ser porque el nombre de usuario estaba vacío.");
                    }

                    */

            //Sigue la ejecucion auque encuentre un usuario con el nombre vacio.

            try {

                Alert alerta = driver.switchTo().alert();
                if (usuarios.getNombre().isEmpty()) {
                    alerta.accept();
                    System.out.println("El formulario no se puede enviar ya que tiene el Nombre vacio.");
                } else {
                    String alertaText = alerta.getText();
                    assertEquals("Formulario enviado con éxito. ¡Gracias por registrarte!", alertaText);
                    alerta.accept();
                    System.out.println("Usuario registrado correctamente: " + usuarios.getNombre());
                }

            } catch (Exception e) {
                System.out.println("No apareció la alerta. Puede ser porque el Nombre estaba vacío.");
            } finally {
                driver.quit();
            }







        }
    }
}
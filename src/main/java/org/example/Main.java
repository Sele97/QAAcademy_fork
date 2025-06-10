package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

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
            System.out.println("Completando formulario para: " + usuarios.getNombre());
            completarFormulario(usuarios);
        }
    }

    public static void completarFormulario ( Usuarios usuarios) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SeleneFigueroa\\OneDrive - Kopius\\Desktop\\Automation\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\SeleneFigueroa\\IdeaProjects\\QAAcademy\\src\\main\\resources\\TorneoHTML\\registro.html");

        driver.manage().window().maximize();

        WebElement nombre = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[1]/input"));
        nombre.sendKeys(usuarios.getNombre());

        WebElement telefono = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[2]/input"));
        telefono.sendKeys(usuarios.getTelefono());

        WebElement email = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[3]/input"));
        email.sendKeys(usuarios.getEmail());

        WebElement discord= driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[4]/input"));
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

        WebElement registrar = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/button[1]"));
        registrar.click();

        try {
            Thread.sleep(3000); // para que se vea la acción antes de cerrar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();


    }



}


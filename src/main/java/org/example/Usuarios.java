package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Usuarios {
    private String nombre;
    private String telefono;
    private String email;
    private String discord;
    private String ign;
    private String nivel;
    private String rolprincipal;
    private String rolsecundario;
    private String pais;

    public Usuarios (String nombre, String telefono, String email, String discord, String ign, String nivel, String rolprincipal, String rolsecundario, String pais){
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.discord  = discord;
        this.ign = ign;
        this.nivel = nivel;
        this.rolprincipal = rolprincipal;
        this.rolsecundario = rolsecundario;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDiscord() {
        return discord;
    }

    public String getIgn() {
        return ign;
    }

    public String getNivel() {
        return nivel;
    }

    public String getRolprincipal(){
        return rolprincipal;
    }
    public String getRolsecundario(){
        return rolsecundario;
    }

    public void setRolprincipal( String rolprincipal) {
        this.rolprincipal = rolprincipal;
    }

    public void setRolsecundario( String rolsecundario) {
        this.rolsecundario = rolsecundario;
    }

    public String getPais () {
        return pais;
    }

    public void setPais( String pais) {
        this.pais = pais;
    }





}


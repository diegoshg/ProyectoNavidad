/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alumno
 */
public class Usuarios {
    private int id;
    private String usename;
    private String contraseña;
    private String email;

    public Usuarios() {
    }

    public Usuarios(int id, String usename, String contraseña, String email) {
        this.id = id;
        this.usename = usename;
        this.contraseña = contraseña;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsename() {
        return usename;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", usename=" + usename + ", contrase\u00f1a=" + contraseña + ", email=" + email + '}';
    }
    
    
}

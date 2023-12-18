/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Diego Sanchez Gandara
 */
public class Juegos {
    private int id_Juego;
    private String nombre_juego;
    private String plataforma;
    private double precio;

    public Juegos() {
    }

    public Juegos(int id_Juego, String nombre_juego, String plataforma, double precio) {
        this.id_Juego = id_Juego;
        this.nombre_juego = nombre_juego;
        this.plataforma = plataforma;
        this.precio = precio;
    }

    public int getId_Juego() {
        return id_Juego;
    }

    public String getNombre_juego() {
        return nombre_juego;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId_Juego(int id_Juego) {
        this.id_Juego = id_Juego;
    }

    public void setNombre_juego(String nombre_juego) {
        this.nombre_juego = nombre_juego;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Juegos{" + "id_Juego=" + id_Juego + ", nombre_juego=" + nombre_juego + ", plataforma=" + plataforma + ", precio=" + precio + '}';
    }
    
    
}

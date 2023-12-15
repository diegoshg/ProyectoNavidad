/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alumno
 */
public class Clientes {
    private int id_cliente;
    private String nombre_cliente;

    public Clientes() {
    }

    public Clientes(int id_cliente, String nombre_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    @Override
    public String toString() {
        return "Clientes{" + "id_cliente=" + id_cliente + ", nombre_cliente=" + nombre_cliente + '}';
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Alumno
 */
public class Ventas {
    private int id_juego;
    private int id_cliente;
    private double precio_venta;
    private Date fecha_venta;

    public Ventas() {
    }

    public Ventas(int id_juego, int id_cliente, double precio_venta, Date fecha_venta) {
        this.id_juego = id_juego;
        this.id_cliente = id_cliente;
        this.precio_venta = precio_venta;
        this.fecha_venta = fecha_venta;
    }

    public int getId_juego() {
        return id_juego;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    @Override
    public String toString() {
        return "Ventas{" + "id_juego=" + id_juego + ", id_cliente=" + id_cliente + ", precio_venta=" + precio_venta + ", fecha_venta=" + fecha_venta + '}';
    }
    
    
}

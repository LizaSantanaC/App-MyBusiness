package com.example.mybusiness.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "productos")
public class Product {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String codigo;
    private String nombre;
    private int categoria;
    private int cantidad;
    private int cantidaReserva;
    private Double precioCompra;
    private Double precioVenta;
    private String fechaCaducidad;
    private String descripcion;

    public Product() {
    }

    public Product(String codigo, String nombre, int categoria, int cantidad, int cantidaReserva, Double precioCompra, Double precioVenta, String fechaCaducidad, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.cantidaReserva = cantidaReserva;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.fechaCaducidad = fechaCaducidad;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidaReserva() {
        return cantidaReserva;
    }

    public void setCantidaReserva(int cantidaReserva) {
        this.cantidaReserva = cantidaReserva;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

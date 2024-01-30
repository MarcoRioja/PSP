package Empleados;

import java.io.Serializable;

public class Empleados implements Serializable {
    private final String nombre;
    private double sueldo;

    public Empleados(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }
}
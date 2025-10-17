/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author 9spot
 */

public abstract class Figura {
    protected double x1;
    protected double y1;
    
    public Figura(double x1, double y1) {
        this.x1 = x1;
        this.y1 = y1;
    }
    
    public abstract double calcularArea();
    
    public abstract String obtenerNombre();
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author 9spot
 */
public class Rectangulo extends Figura {
    private double x2;
    private double y2;
    
    public Rectangulo(double x1, double y1, double x2, double y2) {
        super(x1, y1); 
        this.x2 = x2;
        this.y2 = y2;
    }
    
    @Override
    public double calcularArea() {
        double base = Math.abs(x2 - x1);
        double altura = Math.abs(y2 - y1);
        return base * altura;
    }
    
    @Override
    public String obtenerNombre() {
        return "Rectángulo";
    }
    
    public void cambiarEscala(double factor) {
        double diferenciaX = x2 - x1;
        double diferenciaY = y2 - y1;
        
        x2 = x1 + (diferenciaX * factor);
        y2 = y1 + (diferenciaY * factor);
    }
    
    public boolean puntoEstaDentro(double x, double y) {
        double minX = Math.min(x1, x2);
        double maxX = Math.max(x1, x2);
        double minY = Math.min(y1, y2);
        double maxY = Math.max(y1, y2);
        
        return (x >= minX && x <= maxX && y >= minY && y <= maxY);
    }
    
    public void mover(double unidades, String direccion) {
        switch (direccion.toLowerCase()) {
            case "horizontal":
                x1 += unidades;
                x2 += unidades;
                break;
            case "vertical":
                y1 += unidades;
                y2 += unidades;
                break;
            default:
                System.out.println("Dirección no válida");
        }
    }
    
    public void mover(double unidades) {
        mover(unidades, "horizontal");
    }
    
    @Override
    public String toString() {
        return "Rectángulo:\n" +
               "Vértice 1: (" + x1 + ", " + y1 + ")\n" +
               "Vértice 2: (" + x2 + ", " + y2 + ")\n" +
               "Área: " + calcularArea();
    }
    
    public double getX2() {
        return x2;
    }
    
    public void setX2(double x2) {
        this.x2 = x2;
    }
    
    public double getY2() {
        return y2;
    }
    
    public void setY2(double y2) {
        this.y2 = y2;
    }
}
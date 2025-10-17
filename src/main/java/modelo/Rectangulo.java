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
    
    public Rectangulo(double x1, double y1, double ancho, double alto, boolean usarDimensiones) {
        super(x1, y1);
        
        if (usarDimensiones) {
            if (ancho > 0) {
                if (alto > 0) {
                    this.x2 = x1 + ancho;
                    this.y2 = y1 + alto;
                } else {
                    this.x2 = x1 + ancho;
                    this.y2 = y1 + ancho;
                }
            } else {
                if (alto > 0) {
                    this.x2 = x1 + alto;
                    this.y2 = y1 + alto;
                } else {
                    this.x2 = x1 + 10;
                    this.y2 = y1 + 10;
                }
            }
        } else {
            this.x2 = ancho;
            this.y2 = alto;
        }
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
    
    public void cambiarEscala(double factorX, double factorY) {
        double diferenciaX = x2 - x1;
        double diferenciaY = y2 - y1;
        
        x2 = x1 + (diferenciaX * factorX);
        y2 = y1 + (diferenciaY * factorY);
    }
    
    public void cambiarEscala(double factor, boolean validar) {
        if (validar) {
            if (factor > 0) {
                if (factor <= 10) {
                    cambiarEscala(factor);
                } else {
                    cambiarEscala(10.0);
                }
            } else {
                System.out.println("Factor inválido, no se aplica cambios");
            }
        } else {
            cambiarEscala(factor);
        }
    }
}
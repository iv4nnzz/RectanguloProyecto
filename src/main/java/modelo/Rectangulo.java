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
}
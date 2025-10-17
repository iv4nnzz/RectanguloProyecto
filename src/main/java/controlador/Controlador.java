/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Rectangulo;
import vista.Vista;
/**
 *
 * @author 9spot
 */
public class Controlador {
    private Rectangulo rectangulo;
    private Vista vista;
    
    public Controlador(Vista vista) {
        this.vista = vista;
        this.rectangulo = null;
    }
}
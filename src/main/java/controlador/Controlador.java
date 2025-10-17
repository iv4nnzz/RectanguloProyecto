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

    private void crearRectangulo() {
        double[] coords = vista.pedirCoordenadas();
        
        if (coords != null) {
            rectangulo = new Rectangulo(coords[0], coords[1], coords[2], coords[3]);
            vista.mostrarMensaje("Rectángulo creado exitosamente!");
        }
    }
    
}
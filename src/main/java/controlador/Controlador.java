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
    
    public void iniciar() {
        boolean continuar = true;
        
        vista.mostrarMensaje("Bienvenido al Sistema de Rectángulos");
        
        while (continuar) {
            int opcion = vista.mostrarMenu();
            
            if (rectangulo == null && opcion != 1 && opcion != 7) {
                vista.mostrarError("Primero debe crear un rectángulo (Opción 1)");
                continue;
            }
            
            procesarOpcion(opcion);
            
            if (opcion == 7) {
                continuar = false;
            }
        }
    }
    
    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearRectangulo();
                break;
                
            case 2:
                calcularArea();
                break;
                
            case 3:
                cambiarEscala();
                break;
                
            case 4:
                verificarPunto();
                break;
                
            case 5:
                moverRectangulo();
                break;
                
            case 6:
                mostrarInformacion();
                break;
                
            case 7:
                vista.mostrarMensaje("Gracias por usar el sistema");
                break;
                
            default:
                vista.mostrarError("Opción no válida");
        }
    }
    
    private void crearRectangulo() {
        double[] coords = vista.pedirCoordenadas();
        
        if (coords != null) {
            rectangulo = new Rectangulo(coords[0], coords[1], coords[2], coords[3]);
            vista.mostrarMensaje("Rectángulo creado exitosamente!");
        }
    }
    
    private void calcularArea() {
        if (rectangulo != null) {
            double area = rectangulo.calcularArea();
            vista.mostrarMensaje("El área del rectángulo es: " + area + " unidades²");
        }
    }
    
    private void cambiarEscala() {
        if (rectangulo != null) {
            double factor = vista.pedirFactor();
            
            if (factor > 0) {
                rectangulo.cambiarEscala(factor, true);
                vista.mostrarMensaje("Escala cambiada exitosamente!\n" + "Factor aplicado: " + factor);
            } else {
                vista.mostrarError("El factor debe ser mayor que 0");
            }
        }
    }
    
    private void verificarPunto() {
        if (rectangulo != null) {
            double[] punto = vista.pedirPunto();
            
            if (punto != null) {
                boolean estaDentro = rectangulo.puntoEstaDentro(punto[0], punto[1]);
                
                if (estaDentro) {
                    vista.mostrarMensaje("El punto (" + punto[0] + ", " + punto[1] + ") SÍ está dentro del rectángulo");
                } else {
                    vista.mostrarMensaje("El punto (" + punto[0] + ", " + punto[1] + ") NO está dentro del rectángulo");
                }
            }
        }
    }
    
    private void moverRectangulo() {
        if (rectangulo != null) {
            Object[] movimiento = vista.pedirMovimiento();
            
            if (movimiento != null) {
                double unidades = (Double) movimiento[0];
                String direccion = (String) movimiento[1];
                
                rectangulo.mover(unidades, direccion);
                
                String sentido = "";
                if (direccion.equals("Horizontal")) {
                    sentido = (unidades > 0) ? "derecha" : "izquierda";
                } else {
                    sentido = (unidades > 0) ? "arriba" : "abajo";
                }
                
                vista.mostrarMensaje("Rectángulo movido " + Math.abs(unidades) + " unidades hacia " + sentido);
            }
        }
    }
    
    private void mostrarInformacion() {
        if (rectangulo != null) {
            vista.mostrarMensaje(rectangulo.toString());
        }
    }
}
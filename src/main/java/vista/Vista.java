/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import javax.swing.JOptionPane;
/**
 *
 * @author 9spot
 */
public class Vista {
        public int mostrarMenu() {
        String menu = "=== SISTEMA DE RECTÁNGULOS ===\n\n" +
                     "1. Crear nuevo rectángulo\n" +
                     "2. Calcular área\n" +
                     "3. Cambiar escala\n" +
                     "4. Verificar si un punto está dentro\n" +
                     "5. Mover rectángulo\n" +
                     "6. Mostrar información del rectángulo\n" +
                     "7. Salir\n\n" +
                     "Seleccione una opción:";
        
        String opcion = JOptionPane.showInputDialog(null, menu, "Menú Principal", JOptionPane.QUESTION_MESSAGE);
        
        if (opcion == null || opcion.isEmpty()) {
            return 7; 
        }
        
        try {
            return Integer.parseInt(opcion);
        } catch (NumberFormatException e) {
            mostrarMensaje("Opción no válida. Intente de nuevo.");
            return 0;
        }
    }
        
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, 
                                     "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(null, error, 
                                     "Error", JOptionPane.ERROR_MESSAGE);
    }
}
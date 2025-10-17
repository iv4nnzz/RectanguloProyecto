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
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, 
                                     "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(null, error, 
                                     "Error", JOptionPane.ERROR_MESSAGE);
    }
}
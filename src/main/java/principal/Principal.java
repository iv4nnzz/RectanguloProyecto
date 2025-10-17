/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;
import controlador.Controlador;
import vista.Vista;

/**
 *
 * @author 9spot
 */
public class Principal {
    
    public static void main(String[] args) {
        Vista vista = new Vista();
        
        Controlador controlador = new Controlador(vista);
        controlador.iniciar();
    }
}
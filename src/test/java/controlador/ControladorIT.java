/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controlador;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 9spot
 */
import modelo.Rectangulo;
import vista.Vista;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ControladorIT {

    static class TestVista extends Vista {
        private Deque<Integer> menuQueue = new ArrayDeque<>();
        private Deque<Object> responseQueue = new ArrayDeque<>();
        private List<String> mensajes = new ArrayList<>();

        public void pushMenu(int opcion) { menuQueue.addLast(opcion); }
        public void pushCoordenadas(double[] coords) { responseQueue.addLast(coords); }
        public void pushFactor(double f) { responseQueue.addLast(f); }
        public void pushPunto(double[] p) { responseQueue.addLast(p); }
        public void pushMovimiento(Object[] mov) { responseQueue.addLast(mov); }

        public List<String> getMensajes() { return mensajes; }

        @Override
        public int mostrarMenu() {
            if (menuQueue.isEmpty()) return 7;
            return menuQueue.removeFirst();
        }

        @Override
        public double[] pedirCoordenadas() {
            Object o = responseQueue.pollFirst();
            return (o instanceof double[]) ? (double[]) o : null;
        }

        @Override
        public double pedirFactor() {
            Object o = responseQueue.pollFirst();
            return (o instanceof Double) ? (Double) o : 1.0;
        }

        @Override
        public double[] pedirPunto() {
            Object o = responseQueue.pollFirst();
            return (o instanceof double[]) ? (double[]) o : null;
        }

        @Override
        public Object[] pedirMovimiento() {
            Object o = responseQueue.pollFirst();
            return (o instanceof Object[]) ? (Object[]) o : null;
        }

        @Override
        public void mostrarMensaje(String mensaje) {
            mensajes.add(mensaje);
        }

        @Override
        public void mostrarError(String error) {
            mensajes.add("ERROR: " + error);
        }
    }

    @Test
    public void testFlujoCompletoControlador() {
        TestVista vista = new TestVista();

        vista.pushMenu(1);
        vista.pushMenu(2);
        vista.pushMenu(3);
        vista.pushMenu(4);
        vista.pushMenu(5);
        vista.pushMenu(6);
        vista.pushMenu(7);

        vista.pushCoordenadas(new double[] {0.0, 0.0, 10.0, 5.0});
        vista.pushFactor(2.0); 
        vista.pushPunto(new double[] {1.0, 1.0});
        vista.pushMovimiento(new Object[] {5.0, "Horizontal"});

        Controlador controlador = new Controlador(vista);
        controlador.iniciar(); 

        List<String> msgs = vista.getMensajes();
        String combined = String.join("\n", msgs);

        assertTrue(combined.contains("El área del rectángulo es") , "Debe mostrar el cálculo del área");
        assertTrue(combined.contains("Escala cambiada exitosamente") , "Debe mostrar mensaje de escala aplicada");
        assertTrue(combined.contains("SÍ está dentro") || combined.contains("SÍ está dentro".replace('Í','I')), "Debe indicar que el punto está dentro");
        assertTrue(combined.contains("Rectángulo movido"), "Debe mostrar que el rectángulo fue movido");
        assertTrue(combined.matches("(?s).*Área:.*") , "Debe contener la sección 'Área' en la información final");
    }
}

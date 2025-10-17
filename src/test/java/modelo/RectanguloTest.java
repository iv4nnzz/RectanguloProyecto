/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

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
public class RectanguloTest {

    @Test
    public void testConstructorYCalcularArea() {
        Rectangulo r = new Rectangulo(0, 0, 10, 5);
        assertEquals(10.0 * 5.0, r.calcularArea(), 1e-9);
    }

    @Test
    public void testConstructorSobrecargaConDimensiones() {
        Rectangulo r = new Rectangulo(1, 1, 4, 3, true);
        assertEquals(4.0 * 3.0, r.calcularArea(), 1e-9);
    }

    @Test
    public void testCambiarEscalaFactorSimple() {
        Rectangulo r = new Rectangulo(0, 0, 10, 5);
        r.cambiarEscala(2.0); 
        assertEquals(10.0 * 2.0 * 5.0 * 2.0, r.calcularArea(), 1e-9);
    }

    @Test
    public void testCambiarEscalaDistintosFactores() {
        Rectangulo r = new Rectangulo(0, 0, 10, 5);
        r.cambiarEscala(2.0, 3.0);
        assertEquals(10.0 * 2.0 * 5.0 * 3.0, r.calcularArea(), 1e-9);
    }

    @Test
    public void testCambiarEscalaValidacionLimitaFactorMayorA10() {
        Rectangulo r = new Rectangulo(0, 0, 1, 1);
        r.cambiarEscala(20.0, true);
        assertEquals(100.0, r.calcularArea(), 1e-9);
    }

    @Test
    public void testPuntoEstaDentroYFuera() {
        Rectangulo r = new Rectangulo(-1, -1, 3, 2);
        assertTrue(r.puntoEstaDentro(0, 0));  
        assertTrue(r.puntoEstaDentro(3, 2)); 
        assertFalse(r.puntoEstaDentro(4.1, 0)); 
    }

    @Test
    public void testMoverHorizontalYVertical() {
        Rectangulo r = new Rectangulo(0, 0, 2, 2);
        r.mover(3.0); 
        assertEquals(3.0, r.getX1(), 1e-9);
        assertEquals(5.0, r.getX2(), 1e-9);

        r.mover(-1.0, "vertical");
        assertEquals(-1.0, r.getY1(), 1e-9);
        assertEquals(1.0, r.getY2(), 1e-9);
    }

    @Test
    public void testToStringContieneInformacionEsperada() {
        Rectangulo r = new Rectangulo(0, 0, 3, 4);
        String s = r.toString();
        assertTrue(s.contains("Figura") || s.contains("Rectángulo"));
        assertTrue(s.contains("Punto final"));
        assertTrue(s.contains("Área"));
    }
}
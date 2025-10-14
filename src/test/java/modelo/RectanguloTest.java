package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectanguloTest {

    @Test
    void testCalcularArea_PositiveCoords() {
        Rectangulo r = new Rectangulo(0, 0, 2, 3);
        assertEquals(6.0, r.calcularArea(), 1e-9);
    }

    @Test
    void testCalcularArea_NegativeCoords() {
        Rectangulo r = new Rectangulo(-2, -3, 2, 1);
        assertEquals(16.0, r.calcularArea(), 1e-9);
    }

    @Test
    void testCambiarEscala() {
        Rectangulo r = new Rectangulo(0, 0, 2, 3);
        r.cambiarEscala(2.0);
        assertEquals(4.0, r.getX2(), 1e-9);
        assertEquals(6.0, r.getY2(), 1e-9);
        assertEquals(24.0, r.calcularArea(), 1e-9);
    }

    @Test
    void testPuntoEstaDentro_BoundaryAndInsideOutside() {
        Rectangulo r = new Rectangulo(0, 0, 2, 3);
        assertTrue(r.puntoEstaDentro(1.0, 1.0));
        assertTrue(r.puntoEstaDentro(0.0, 0.0));
        assertTrue(r.puntoEstaDentro(2.0, 3.0));
        assertFalse(r.puntoEstaDentro(2.1, 3.0));
        assertFalse(r.puntoEstaDentro(-0.1, 1.0));
    }

    @Test
    void testMoverHorizontalAndVertical() {
        Rectangulo r = new Rectangulo(1, 1, 3, 4);
        r.mover(2.0, "horizontal");
        assertEquals(3.0, r.getX1(), 1e-9);
        assertEquals(5.0, r.getX2(), 1e-9);
        r.mover(-1.5, "vertical");
        assertEquals(-0.5, r.getY1(), 1e-9);
        assertEquals(2.5, r.getY2(), 1e-9);
    }

    @Test
    void testMoverDefaultUsesHorizontal() {
        Rectangulo r = new Rectangulo(0, 0, 1, 1);
        r.mover(5.0); 
        assertEquals(5.0, r.getX1(), 1e-9);
        assertEquals(6.0, r.getX2(), 1e-9);
    }

    @Test
    void testToStringContainsAreaAndVertices() {
        Rectangulo r = new Rectangulo(0, 0, 2, 3);
        String s = r.toString();
        assertTrue(s.contains("Vértice 1"));
        assertTrue(s.contains("Vértice 2"));
        assertTrue(s.contains("Área"));
        assertTrue(s.contains(Double.toString(r.calcularArea())));
    }
}

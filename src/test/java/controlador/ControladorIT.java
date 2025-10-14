package controlador;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class ControladorIT {

    static class VistaMinima extends vista.Vista {
        private final int[] menuSeq;
        private int idx = 0;
        private final double[] coords;
        List<String> mensajes = new ArrayList<>();
        List<String> errores = new ArrayList<>();

        VistaMinima(int[] menuSeq, double[] coords) {
            this.menuSeq = menuSeq;
            this.coords = coords;
        }

        @Override
        public int mostrarMenu() {
            if (idx < menuSeq.length) return menuSeq[idx++];
            return 7;
        }

        @Override
        public double[] pedirCoordenadas() {
            return coords;
        }

        @Override
        public void mostrarMensaje(String mensaje) {
            mensajes.add(mensaje);
        }

        @Override
        public void mostrarError(String error) {
            errores.add(error);
        }
    }

    @Test
    void integracionMinima_crearYSale() {
        int[] seq = {1, 7};
        double[] coords = {0.0, 0.0, 2.0, 3.0};

        VistaMinima vista = new VistaMinima(seq, coords);
        Controlador controlador = new Controlador(vista);

        controlador.iniciar(); 

        assertTrue(vista.errores.isEmpty(), "No debe haber errores en el flujo básico");
        boolean creado = vista.mensajes.stream().anyMatch(m -> m.toLowerCase().contains("rectángulo creado") || m.toLowerCase().contains("rectangulo creado"));
        assertTrue(creado, "Debió mostrarse el mensaje de 'Rectángulo creado exitosamente!'");
    }
}

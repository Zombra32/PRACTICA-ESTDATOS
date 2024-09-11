package ESTDATOS;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;

public class TJOption {

    public static int leerInt(String msje) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, msje, "[int]", JOptionPane.QUESTION_MESSAGE));
    }

    public static long leerLong(String msje) {
        while (true) {
            try {
                return Long.parseLong(JOptionPane.showInputDialog(null, msje, "[long]", JOptionPane.QUESTION_MESSAGE));
            } catch (NumberFormatException e) {
                imprimeError("Solo se admiten enteros en el rango " + Long.MIN_VALUE + " y " + Long.MAX_VALUE);
            }
        }
    }

    public static float leerFloat(String msje) {
        while (true) {
            try {
                return Float.parseFloat(JOptionPane.showInputDialog(null, msje, "[float]", JOptionPane.QUESTION_MESSAGE));
            } catch (NumberFormatException e) {
                imprimeError("Solo se admiten números en el rango " + Float.MIN_VALUE + " y " + Float.MAX_VALUE);
            }
        }
    }

    public static String leerString(String msje) {
        return JOptionPane.showInputDialog(null, msje, "[String]", JOptionPane.QUESTION_MESSAGE);
    }

    public static double leerDouble(String msje) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(null, msje, "[double]", JOptionPane.QUESTION_MESSAGE));
            } catch (NumberFormatException e) {
                imprimeError("Solo se admiten números en el rango " + Double.MIN_VALUE + " y " + Double.MAX_VALUE);
            }
        }
    }

    public static void imprimePantalla(String msje) {
        JOptionPane.showMessageDialog(null, msje, "Salida", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void imprimeError(String msje) {
        JOptionPane.showMessageDialog(null, msje, "¡¡¡ERROR!!!", JOptionPane.ERROR_MESSAGE);
    }

    public static void panelScroll(String cad) {
        JTextArea areaSalida = new JTextArea(10, 4);
        JScrollPane scroller = new JScrollPane(areaSalida);
        Font font = new Font("Arial", Font.BOLD, 15);
        areaSalida.setFont(font);
        areaSalida.setForeground(Color.black);
        areaSalida.setBackground(Color.WHITE);
        areaSalida.append(" " + cad);
        JOptionPane.showMessageDialog(null, scroller, "Datos: ", JOptionPane.PLAIN_MESSAGE);
    }

    public static String boton(String menu) {
        String[] valores = menu.split(",");
        int n = JOptionPane.showOptionDialog(null, "SELECCIONA DANDO CLICK", "M E N U", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);
        return valores[n];
    }

    public static int GeneradorID() {
        Random random = new Random();
        return random.nextInt(90000) + 10000;
    }

    public static String desplegablePlanet(String menu) {
        String[] valores = menu.split(",");
        return (String) JOptionPane.showInputDialog(null, "P U E S T O S", "Selecciona un puesto: ", JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);
    }

    public static String menuPuestosA(String menu) {
        String sel;
        boolean seleccionado = false;
        String[] puestosValidos = {
            "Director General (CEO)",
            "Director Financiero (CFO)",
            "Director de Recursos Humanos",
            "Director de Marketing",
            "Gerente",
            "Supervisor"
        };

        do {
            sel = desplegablePlanet(menu);
            if (esPuestoValido(sel, puestosValidos)) {
                seleccionado = true;
            } else {
                imprimeError("Selecciona un puesto válido. Opciones válidas: " + String.join(", ", puestosValidos));
            }
        } while (!seleccionado);
        return sel;
    }

    private static boolean esPuestoValido(String seleccion, String[] puestosValidos) {
        for (String puesto : puestosValidos) {
            if (puesto.equals(seleccion)) {
                return true;
            }
        }
        return false;
    }
}
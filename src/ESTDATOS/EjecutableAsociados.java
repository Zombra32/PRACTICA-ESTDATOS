package ESTDATOS;
import javax.swing.JOptionPane;

public class EjecutableAsociados {
    public static void main(String[] args) {
        menu2("Agregar Asociado,Imprime Reporte Asociados Naturales,Imprime Reporte Asociados Directivos,Actualizar aportación A.Natural,Salir");
    }

    public static String desplegable(String menu) {
        String valores[] = menu.split(",");
        return (String) JOptionPane.showInputDialog(null, "M E N U", "Selecciona una opción: ", JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);
    }

    public static void menu2(String menu) {
        String sel;
        ArrayAsociado uwu = new ArrayAsociado((byte) 50);
        do {
            sel = desplegable(menu);
            switch (sel) {
                case "Agregar Asociado": uwu.agregarAsociado(); break;
                case "Imprime Reporte Asociados Naturales":
                    if (uwu.arrayVacioN()) {
                        TJOption.imprimePantalla("No se puede buscar a ningun asociado, la lista esta vacia");
                    } else uwu.imprimeDatosNat(); break;
                case "Imprime Reporte Asociados Directivos":
                    if (uwu.arrayVacioD()) {
                        TJOption.imprimePantalla("No se puede buscar a ningun asociado, la lista esta vacia");
                    } else uwu.imprimeDatosDirec(); break;
                case "Actualizar aportación A.Natural":
                    try {
                        int id = Integer.parseInt(TJOption.leerString("Ingrese el ID del Asociado"));
                        double monto = Double.parseDouble(TJOption.leerString("Ingrese el monto de la aportación"));
                        uwu.registrarPago(id, monto);
                    } catch (NumberFormatException e) {
                        TJOption.imprimeError("ID o monto ingresado no es válido\nVuelva a Intentarlo");
                    }
                    break;
                case "Salir": TJOption.imprimePantalla("Saliendo del programa"); break;
            }
        } while (!sel.equals("Salir"));
    }
}
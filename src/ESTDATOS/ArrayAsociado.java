package ESTDATOS;
import java.time.LocalDate;

public class ArrayAsociado {
    private Naturales[] listaNat;
    private Directivos[] listaDirec;
    private int j;
    private int k;

    public ArrayAsociado(int tam) {
        listaNat = new Naturales[tam];
        listaDirec = new Directivos[tam];
        j = -1;
        k = -1;
    }

    public boolean arrayVacioN() {
        return (j == -1);
    }

    public boolean arrayVacioD() {
        return (k == -1);
    }

    public boolean espacioArrayN() {
        return (j < listaNat.length-1);
    }

    public boolean espacioArrayD() {
        return (k < listaDirec.length-1);
    }


    public void agregarAsociado() {
        if (espacioArrayD() || espacioArrayN()) {
            String cad = TJOption.boton("Asociado Directivo,Asociado Natural");
            if (cad.equalsIgnoreCase("Asociado Directivo")) {
                if (espacioArrayD()) { 
                    k++;
                    listaDirec[k] = agregarDirectivo();
                } else {
                    TJOption.imprimeError("ERROR\nNo hay espacio para agregar más Asociados Directivos");
                }
            } else {
                if (espacioArrayN()) {
                    j++;
                    listaNat[j] = agregarNatural();
                } else {
                    TJOption.imprimeError("ERROR\nNo hay espacio para agregar más Asociados Naturales");
                }
            }
        } else {
            TJOption.imprimeError("ERROR\nYa no hay espacio para agregar más asociados");
        }
    }

    public Directivos agregarDirectivo() {
        Directivos uwu = new Directivos();
        uwu.setNomb(TJOption.leerString("Ingrese el nombre del Asociado"));
        uwu.setIdSocio(TJOption.GeneradorID());
        uwu.setTelefono(TJOption.leerLong("Ingrese su numero telefonico"));
        uwu.setFechaIngreso(LocalDate.now());
        uwu.setTomaPoses(LocalDate.now());
        String cargo = seleccionarCargo();
        uwu.setCargo(cargo);
        return uwu;
    }

    private String seleccionarCargo() {
        String[] cargosDisponibles = {"Director General (CEO)","Director Financiero (CFO)","Director de Recursos Humanos","Director de Marketing","Gerente","Supervisor"};        
        String cargoSeleccionado;
        boolean cargoValido = false;
        do {
            cargoSeleccionado = TJOption.desplegablePlanet(String.join(",", cargosDisponibles));
            if (!cargoYaAsignado(cargoSeleccionado)) {
                cargoValido = true;
            } else {
                TJOption.imprimeError("El cargo seleccionado ya está asignado a otro directivo. Por favor, selecciona otro.");            
            }
        } while (!cargoValido);
        return cargoSeleccionado;
    }

    private boolean cargoYaAsignado(String cargo) {
        for (int i = 0; i <= k; i++) {
            if (listaDirec[i] != null && listaDirec[i].getCargo().equals(cargo)) {
                return true;
            }
        }
        return false;
    }

    public Naturales agregarNatural() {
        Naturales owo = new Naturales();
        owo.setIdSocio(TJOption.GeneradorID());
        owo.setNomb(TJOption.leerString("Ingrese el nombre del Asociado"));
        owo.setTelefono(TJOption.leerLong("Ingrese su numero telefonico"));
        owo.setFechaIngreso(LocalDate.now());
        owo.setCantAport(1);
        owo.setMontoTotalAport(2500);
        owo.setUltimaAport(LocalDate.now());
        TJOption.imprimePantalla("Al darse de alta, usted acepto dar $2500 de aporte voluntario\nGracias bonito dia");
        return owo;
    }

    public byte buscarNatural(int id) {
        for (byte i = 0; i <= j; i++) {
            if (listaNat[i] != null && listaNat[i].getIdSocio() == id) {
                return i;
            }
        }
        return -2;
    }

    public void registrarPago(int id, double monto) {
        byte index = buscarNatural(id);
        if (index != -2) {
            Naturales asociado = (Naturales) listaNat[index];
            asociado.registrarPago(monto);
            TJOption.imprimePantalla("Aportación actualizada para el asociado ID " + id);
        } else {
            TJOption.imprimeError("El asociado con ID " + id + " no está registrado.");
        }
    }

    public void imprimeDatosDirec() {
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i <= k; i++) {
            cad.append((i + 1)).append(") ").append(listaDirec[i].toString()).append("\n");
        }
        TJOption.panelScroll("Asociados Capturados\n" + cad);
    }

    public void imprimeDatosNat() {
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i <= j; i++) {
            cad.append((i + 1)).append(") ").append(listaNat[i].toString()).append("\n");
        }
        TJOption.panelScroll("Asociados Capturados\n" + cad);
    }
}
package ESTDATOS;
import java.time.LocalDate;

public class Naturales extends Asociados{
    
    private double montoTotalAport;
    private int cantAport;
    private LocalDate ultimaAport;

    public Naturales() {
    }

    public Naturales(int idSocio, String nomb, LocalDate fechaIngreso, long telefono, double montoTotalAport, int cantAport, LocalDate ultimaAport) {
        super(idSocio, nomb, fechaIngreso, telefono);
        this.montoTotalAport = montoTotalAport;
        this.cantAport = 1;
        this.ultimaAport = ultimaAport;
    }

    public double getMontoTotalAport() {
        return montoTotalAport;
    }

    public void setMontoTotalAport(double montoTotalAport) {
        this.montoTotalAport = montoTotalAport;
    }

    public int getCantAport() {
        return 1;
    }

    public void setCantAport(int cantAport) {
        this.cantAport = cantAport;
    }

    public LocalDate getUltimaAport() {
        return ultimaAport;
    }

    public void setUltimaAport(LocalDate ultimaAport) {
        this.ultimaAport = ultimaAport;
    }

    public void registrarPago(double monto) {
        this.montoTotalAport += monto;
        this.cantAport++;
        this.ultimaAport = LocalDate.now();
    }

    @Override
    public String toString() {
        return super.toString() + "\nMonto Total de Aportaciones: " + montoTotalAport + "\nNo. de Aportaciones: " + cantAport+ "\nFecha de la Ultima Aportación: " + ultimaAport;
    }
}
package ESTDATOS;
import java.time.LocalDate;

public class Asociados {
    
    private int idSocio;
    private String nomb;
    private LocalDate fechaIngreso;
    private long telefono;
    
    public Asociados() {
    }

    public Asociados(int idSocio, String nomb, LocalDate fechaIngreso, long telefono) {
        this.idSocio = idSocio;
        this.nomb = nomb;
        this.fechaIngreso = fechaIngreso;
        this.telefono = telefono;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
    
    public int getIdSocio() {
        return idSocio;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: "+nomb+"\nID: " + idSocio + "\nFecha Ingreso: " + fechaIngreso + "\nTelefono: "+ telefono;
    }
}
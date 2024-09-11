package ESTDATOS;
import java.time.LocalDate;

public class Directivos extends Asociados{
    private String cargo;
    private LocalDate tomaPoses;

    public Directivos() {
    }

    public Directivos(int idSocio, String nomb, LocalDate fechaIngreso, long telefono, String cargo, LocalDate tomaPoses) {
        super(idSocio, nomb, fechaIngreso, telefono);
        this.cargo = cargo;
        this.tomaPoses = tomaPoses;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getTomaPoses() {
        return tomaPoses;
    }

    public void setTomaPoses(LocalDate tomaPoses) {
        this.tomaPoses = tomaPoses;
    }

    @Override
    public String toString() {
        return super.toString()+"\nCargo: " + cargo + "\nFecha de Toma de Posesión: " + tomaPoses;
    }
}
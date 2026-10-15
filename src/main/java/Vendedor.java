import java.time.LocalDate;
import java.util.ArrayList;

public class Vendedor extends Persona{
    private String codigoEmpleado;
    private LocalDate fechaContratacion;
    private double salarioBasico;
    private ArrayList<Venta> listaVentas;

    public Vendedor(String documento, String nombreCompleto, String correo, String telefono, String codigoEmpleado, LocalDate fechaContratacion, double salarioBasico, ArrayList<Venta> listaVentas) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;
        this.listaVentas = listaVentas;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(double salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "codigoEmpleado='" + codigoEmpleado + '\'' +
                ", fechaContratacion=" + fechaContratacion +
                ", salarioBasico=" + salarioBasico +
                ", listaVentas=" + listaVentas +
                '}';
    }
}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona {

    private String codigoEmpleado;
    private LocalDate fechaContratacion;
    private double salarioBasico;
    private List<Venta> ventas;

    public Vendedor(String documento, String nombreCompleto, String correo, String telefono,
                    String codigoEmpleado, LocalDate fechaContratacion, double salarioBasico) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;
        this.ventas = new ArrayList<>();
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

    public List<Venta> consultarVentas() {
        return ventas;
    }
}
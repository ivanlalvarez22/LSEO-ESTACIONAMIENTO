package paqueteLSEO;

import java.util.Date;

/**
 *
 * @author ivan_
 */
public class Ticket {

    private String nombre;
    private String apellido;
    private int dni;
    private Moto moto = new Moto();
    private float saldo;
    private Date fecha = new Date();

    public Ticket() {
    }

    public Ticket(String nombre, String apellido, int dni, Moto moto, float saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.moto = moto;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void generarTicket(float montoAcreditado, int numComp) {
        System.out.println("*****************TICKET*********************");
        System.out.println("Nro comprobante: " + numComp);
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Apellido: " + this.getApellido());
        System.out.println("DNI: " + this.getDni());
        System.out.println("MOTO: " + this.getMoto().toString());
        System.out.println("Monto acreditado: " + montoAcreditado);
        System.out.println("Saldo actual: " + this.saldo);
        System.out.println("Fecha: " + this.fecha);
        Consola.pausa();
    }

}

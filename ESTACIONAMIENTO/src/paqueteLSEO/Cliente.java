package paqueteLSEO;

/**
 *
 * @author ivan_
 */
public class Cliente {

    private String apellido;
    private String nombre;
    private int dni;
    private float monto;
    private Moto moto = new Moto();

    public Cliente() {
    }

    public Cliente(String apellido, String nombre, int dni, float monto, Moto moto) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.monto = monto;
        this.moto = moto;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public void ingresarDatos() {
        System.out.println("Ingrese el apellido: ");
        this.apellido = Consola.readLine();
        System.out.println("Ingrese el nombre: ");
        this.nombre = Consola.readLine();
        System.out.println("Ingrese el dni: ");
        this.dni = Consola.readInt();
        System.out.println("Ingrese el monto: ");
        this.monto = Consola.readFloat();
        this.moto.cargarDatos();
    }

    @Override
    public String toString() {
        return "Cliente{" + "apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + ", monto=" + monto + ", moto=" + moto.toString() + '}';
    }

}

package paqueteLSEO;

/**
 *
 * @author ivan_
 */
public class Moto {

    private String marca;
    private int modelo;
    private int patente;

    public Moto() {
    }

    public Moto(String marca, int modelo, int patente) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getPatente() {
        return patente;
    }

    public void setPatente(int patente) {
        this.patente = patente;
    }
    
    public void cargarDatos() {
        System.out.println("Ingrese la marca: ");
        this.marca = Consola.readLine();
        System.out.println("Ingrese el modelo (año): ");
        this.modelo = Consola.readInt();
        System.out.println("Ingrese la patente: ");
        this.patente = Consola.readInt();
    }
    
    public void actualizarDatos() {
        System.out.println("Ingrese la nueva marca: ");
        this.marca = Consola.readLine();
        System.out.println("Ingrese el modelo: ");
        this.modelo = Consola.readInt();
    }

    @Override
    public String toString() {
        return "Moto{" + "marca=" + marca + ", modelo=" + modelo + ", patente=" + patente + '}';
    }

}

package paqueteLSEO;

/**
 *
 * @author ivan_
 */
public class Nodo {

    private Cliente dato;
    private Nodo ps;

    public Nodo(Cliente dato) {
        this.dato = dato;
        this.ps = null;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }

}

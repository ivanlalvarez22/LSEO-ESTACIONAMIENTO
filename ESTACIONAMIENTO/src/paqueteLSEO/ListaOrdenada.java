package paqueteLSEO;

/**
 *
 * @author ivan_
 */
public class ListaOrdenada extends Lista {

    public ListaOrdenada() {
        super();
    }

    public void insertarMedio(Nodo p, Nodo ant, Nodo x) {
        x.setPs(p);
        ant.setPs(x);
    }

    public void insertarFin(Nodo ant, Nodo x) {
        ant.setPs(x);
    }

    public void insertar(Cliente c) {
        Nodo p = inicio();
        Nodo ant = null;
        int b = 0;
        while (p != null && b == 0) {
            if (p.getDato().getDni() > c.getDni()) {
                b = 1;
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        Nodo x = new Nodo(c);
        if (b == 1) {
            if (p == inicio()) {
                insertarPri(x);
            } else {
                insertarMedio(p, ant, x);
            }
        } else {
            if (ant == null) {
                list = x;
            } else {
                insertarFin(ant, x);
            }
        }
    }

}

package paqueteLSEO;

/**
 *
 * @author ivan_
 */
public class Lista {
    
    protected Nodo list;
    
    public Lista() {
        this.list = null;
    }
    
    public Nodo inicio() {
        return list;
    }
    
    public boolean listaVacia() {
        return list == null;
    }
    
    public void insertarPri(Nodo x) {
        x.setPs(list);
        list = x;
    }
    
    public Nodo quitar(Nodo p, Nodo ant) {
        Nodo x = p;
        if (p == inicio()) {
            list = p.getPs();
        } else {
            ant.setPs(p.getPs());
        }
        return x;
    }
    
    public Nodo eliminar(int entrada) {
        Nodo p = inicio();
        Nodo ant = null;
        int b = 0;
        Nodo x = null;
        while (p != null && b == 0) {
            if (p.getDato().getDni() == entrada) {
                x = quitar(p, ant);
                b = 1;
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        return x;
    }
    
    public void visualizar() {
        Nodo p = inicio();
        if (p != null) {
            while (p != null) {
                System.out.println("Elemento " + p.getDato().toString());
                p = p.getPs();
            }
        } else {
            System.out.println("Lista vacía!");
        }
        Consola.pausa();
    }
    
    public boolean existe(int entrada) {
        Nodo p = inicio();
        while (p != null) {
            if (p.getDato().getDni() == entrada) {
                return true;
            } else {
                p = p.getPs();
            }
        }
        return false;
    }
    
    public boolean existePatente(int entrada) {
        Nodo p = inicio();
        while (p != null) {
            if (p.getDato().getMoto().getPatente() == entrada) {
                return true;
            } else {
                p = p.getPs();
            }
        }
        return false;
    }
}

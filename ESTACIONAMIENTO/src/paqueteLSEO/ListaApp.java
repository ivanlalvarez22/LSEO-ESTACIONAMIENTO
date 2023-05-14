/*
Identificar la estructura de datos más adecuada para resolver el problema que se 
plantea a continuación. Debe poder fundamentar la razón por la cual seleccionó dicha 
estructura.

Problema: Estacionamiento de motos.
Se describe a continuación el funcionamiento de la playa de estacionamiento de motos 
de la Universidad Nacional - que se encuentra a cargo de un concesionario - y del 
sistema de información que le da soporte.

    * No se asignan lugares específicos para las motos; las personas que ingresan al 
estacionamiento deberán ubicar su moto en algún lugar que se encuentre disponible.
    * Los interesados pueden comprar una bono de estacionamiento que se paga 
anticipadamente, con un valor de cada estacionamiento más económico.
    * Si es la primera vez que estaciona, debe registrar sus datos personales 
(apellido, nombre, dni, monto), y los datos de la moto (marca, modelo, patente), con 
los cuales desea ingresar a la playa de estacionamiento.
    * Una vez registrado el propietario de la moto, cada vez que necesite acreditar 
dinero, informa su DNI y la cantidad de dinero y se le cobra entregándole un comprobante 
donde consta: apellido y nombre, dni, fecha de la transacción, monto acreditado y 
monto disponible en su cuenta.
    * El comprobante (ticket) que se entrega como constancia del cobro de 
estacionamiento tiene los siguientes datos: apellido y nombre del propietario, dni, 
fecha y hora de la transacción, monto acreditado y monto disponible en su cuenta - en 
caso de que haya realizado el pago anticipado - y un número único de identificación del 
comprobante.
    * La persona puede en cualquier momento cambiar la moto con la que ingresará 
a la playa de estacionamiento.
    * Si la moto no está registrada se guarda en el ingreso el número de patente de 
la moto y se informa como observación que no está registrada.
 */
package paqueteLSEO;

/**
 *
 * @author ivan_
 */
public class ListaApp {

    ListaOrdenada miLo;
    int numComp = 0;

    public ListaApp() {
        this.miLo = new ListaOrdenada();
    }

    public void generar() {
        char op = 's';
        while (op != 'n') {
            Cliente c = new Cliente();
            c.ingresarDatos();
            Nodo p = miLo.inicio();
            if (!miLo.existe(c.getDni()) && !miLo.existePatente(c.getMoto().getPatente())) {
                miLo.insertar(c);
                System.out.println("La moto " + c.getMoto().toString() + " No estaba registrada");
            } else {
                System.out.println("El elemento ya existe");
            }
            System.out.println("Desea continuar? (s/n): ");
            op = Consola.readChar();
        }
    }

    public void imprimir() {
        System.out.println("ESTACIONAMIENTO DE MOTOS - Imprimir");
        miLo.visualizar();
    }

    public void borrar() {
        char op = 's';
        while (op != 'n') {
            System.out.println("Ingrese el dni del cliente a borrar: ");
            int elem = Consola.readInt();
            if (!miLo.listaVacia()) {
                if (miLo.existe(elem)) {
                    Nodo x = miLo.eliminar(elem);
                    System.out.println(x.getDato() + " Fue eliminado");
                } else {
                    System.out.println("Elemento inexistente");
                }
            } else {
                System.out.println("Lista vacía..");
            }
            System.out.println("Desea continuar? (s/n): ");
            op = Consola.readChar();
        }
    }

    public void acreditar() {
        if (!miLo.listaVacia()) {
            System.out.println("Ingrese el dni: ");
            int dni = Consola.readInt();
            Nodo p = miLo.inicio();
            while (p != null) {
                if (p.getDato().getDni() == dni) {
                    numComp++;
                    System.out.println("Ingrese el monto a acreditar: ");
                    float monto = Consola.readFloat();
                    p.getDato().setMonto(p.getDato().getMonto() - monto);
                    Ticket t = new Ticket(p.getDato().getNombre(), p.getDato().getApellido(),
                            p.getDato().getDni(), p.getDato().getMoto(), p.getDato().getMonto());
                    t.generarTicket(monto, numComp);
                    return;
                } else {
                    p = p.getPs();
                }
            }
            System.out.println("Cliente inexistente");
            Consola.pausa();
        } else {
            System.out.println("Lista vacía!");
        }
    }

    public void cambiarMoto() {
        if (!miLo.listaVacia()) {
            System.out.println("Ingresar el dni: ");
            int dni = Consola.readInt();
            Nodo p = miLo.inicio();
            while (p != null) {
                if (p.getDato().getDni() == dni) {
                    System.out.println("Ingrese la nueva patente: ");
                    int patente = Consola.readInt();
                    if (!miLo.existePatente(patente)) {
                        p.getDato().getMoto().setPatente(patente);
                        p.getDato().getMoto().actualizarDatos();
                        System.out.println("Los datos se actualizaron correctamente");
                        Consola.pausa();
                    } else {
                        System.out.println("La moto ya existe");
                        Consola.pausa();
                    }
                    return;
                } else {
                    p = p.getPs();
                }
            }
            System.out.println("Cliente inexistente");
            Consola.pausa();
        } else {
            System.out.println("Lista vacía..");
        }
    }

    public void mostrarOpciones() {
        System.out.println("Listas Simples Enlazadas Ordenadas - ESTACIONAMIENTO DE MOTOS");
        System.out.println("1.- Generar");
        System.out.println("2.- Imprimir");
        System.out.println("3.- Borrar");
        System.out.println("4.- Acreditar");
        System.out.println("5.- Cambiar moto");
        System.out.println("0.- Salir");
        System.out.println("Ingrese una opción para continuar: ");
    }

    public void menu() {
        int op;
        do {
            mostrarOpciones();
            op = Consola.readInt();
            switch (op) {
                case 1:
                    generar();
                    break;
                case 2:
                    imprimir();
                    break;
                case 3:
                    borrar();
                    break;
                case 4:
                    acreditar();
                    break;
                case 5:
                    cambiarMoto();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (op != 0);

    }

    public static void main(String[] args) {
        ListaApp miListaApp = new ListaApp();
        miListaApp.menu();
    }
}

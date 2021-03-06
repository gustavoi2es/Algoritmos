package obligatorio;

import obligatorio.IListaAbonado;

public class ListaAbonado implements IListaAbonado {

    private NodoListaAbonado inicio;
    private NodoListaAbonado fin;
    private int cantelementos;

    //Constructor
    public void ListaAbonado() {
        this.inicio = null;
        this.fin = null;
        this.cantelementos = 0;
    }

    //Inicio
    public void setInicio(NodoListaAbonado i) {
        inicio = i;
    }

    public NodoListaAbonado getInicio() {
        return inicio;
    }

    //Fin
    public void setFin(NodoListaAbonado f) {
        fin = f;
    }

    public NodoListaAbonado getFin() {
        return fin;
    }

    public int getCantelementos() {
        return cantelementos;
    }

    public void setCantelementos(int cantelementos) {
        this.cantelementos = cantelementos;
    }

    /**
     * ************Métodos Básicos******************
     */
    /**
     * ********************************************
     */
    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    public boolean esVacia() {
        return (this.inicio == null);
    }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    public void agregarInicio(int dato, String abonadoNombre, String abonadoDireccion, String abonadoTel) {
        NodoListaAbonado nuevo = new NodoListaAbonado(dato, abonadoNombre, abonadoDireccion, abonadoTel);
        nuevo.setSig(inicio);
        this.inicio = nuevo;
        if (this.fin == null)//estoy insertando el primer nodo
        {
            this.fin = nuevo;
        }

        this.cantelementos = this.cantelementos + 1;
    }

    //PRE:
    //POS: Borra el primer nodo
    public void borrarInicio() {
        if (!this.esVacia()) {
            this.inicio = this.inicio.getSig();
            this.cantelementos = this.cantelementos - 1;
        }
    }
    //PRE:
    //POS: elimina todos los nodos de una lista dada

    public void vaciar() {
        this.inicio = null;
        this.fin = null;
        this.cantelementos = 0;
    }

    //PRE:
    //POS: Recorre y muestra los datos de lista
    public void mostrar() {
        if (this.esVacia()) {
            System.out.println("Lista es vacía");
        } else {
            NodoListaAbonado aux = this.inicio;
            while (aux != null) {
                System.out.println(aux.getAbonadoID() + aux.getAbonadoNombre() + aux.getAbonadoDireccion() + aux.getAbonadoTel());
                aux = aux.getSig();
            }
        }
    }

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public void agregarFinal(int dato, String abonadoNombre, String abonadoDireccion, String abonadoTel) {
        //NodoLista nuevo= new NodoLista(n);
        if (this.esVacia()) {
            this.agregarInicio(dato, abonadoNombre, abonadoDireccion, abonadoTel); // el agregar inicio suma 1 a cantelementos
        } else {
            NodoListaAbonado nuevo = new NodoListaAbonado(dato, abonadoNombre, abonadoDireccion, abonadoTel);
            fin.setSig(nuevo);
            fin = nuevo;
            this.cantelementos = this.cantelementos + 1;
        }

    }

    //PRE:
    //POS: Borra el último nodo
    public void borrarFin() {
        if (!this.esVacia()) {
            if (this.inicio == this.fin) {
                this.borrarInicio();  // actualiza canelementos
            } else {
                NodoListaAbonado aux = this.inicio;
                while (aux.getSig().getSig() != null) {
                    aux = aux.getSig();
                }
                this.fin = aux;
                this.fin.setSig(null);
                this.cantelementos = this.cantelementos - 1;
            }
        }
    }

    //PRE:
    //POS: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(int dato) {
        NodoListaAbonado anterior = this.getInicio(), aux = this.getInicio();

        if (aux.getAbonadoID() == dato) {
            borrarInicio();
        } else if (this.getFin().getAbonadoID() == dato) {
            borrarFin();
        } else {
            while (aux != null && aux.getAbonadoID() != dato) {
                anterior = aux;
                aux = aux.getSig();
            }
            if (aux != null) {
                anterior.setSig(aux.getSig());
            }
        }
    }

    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos() {
        return this.cantelementos;
    }

    //PRE: //POS:
    //PRE: //POS:
    public NodoListaAbonado obtenerElemento(int dato) {
        NodoListaAbonado aux = this.inicio;
        while (aux != null && aux.getAbonadoID() != dato) {
            aux = aux.getSig();
        }
        //encontrÃ© dato o lleguÃ© al final
        return aux;
    }

    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoListaChofer l) {
        if (l != null) {
            System.out.println(l.getCedula());
            mostrarREC(l.getSiguiente());

        }
    }

}

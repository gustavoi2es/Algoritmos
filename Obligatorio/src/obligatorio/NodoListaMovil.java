package obligatorio;

import obligatorio.ListaChofer;

public class NodoListaMovil {

    private Object dato;
    private NodoListaMovil sig;
    private boolean Estado;
    private ListaChofer lch;

    public NodoListaMovil(Object dato) {
        this.dato = dato;
        this.sig = null;
        this.Estado = true;
        this.lch = new ListaChofer();
    }

    public ListaChofer getLch() {
        return lch;
    }

    public void setCh(ListaChofer lch) {
        this.lch = lch;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoListaMovil getSig() {
        return sig;
    }

    public void setSig(NodoListaMovil sig) {
        this.sig = sig;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

}

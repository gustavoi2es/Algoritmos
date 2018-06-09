package obligatorio;

public class metodos {

    //AGREGA UN MOVIL EN UNA ZONA
    //Asumimos que existe la zona
    public static void agregarMovilAZona(ListaZona lz, String Zona, String movil) {
        NodoListaZona unazona = lz.obtenerElemento(Zona);
        unazona.getLm().agregarOrd(movil);
    }

    //se asume que existen todos los datos
    public static void viaje(ListaZona lz, String zonaOrigen, String zonaDestino, String movil) {
        agregarMovilAZona(lz, zonaDestino, movil);
        lz.obtenerElemento(zonaOrigen).getLm().borrarElemento(movil);
    }

    //se asume que existen todos los datos
    public static void cambiarUbicacionZona(ListaZona lz, String zonaDestino, String movil) {
        NodoListaZona origen = lz.obtenerElemento(buscarZonaPorMovil(lz, movil));
        NodoListaMovil pmovil = origen.getLm().obtenerElemento(movil);
        lz.obtenerElemento(zonaDestino).getLm().getFin().setSig(pmovil);
        lz.obtenerElemento(zonaDestino).getLm().setFin(pmovil);

        NodoListaMovil aux = origen.getLm().getInicio();
        while (aux.getSig() != pmovil) {
            aux = aux.getSig();
            aux.setSig(pmovil.getSig());
            lz.obtenerElemento(zonaDestino).getLm().getFin().setSig(null);
        }
    }

    //se asume que existen todos los datos
    public static void borrarMovil(ListaZona lz, String movil) {
        NodoListaZona origen = lz.obtenerElemento(buscarZonaPorMovil(lz, movil).getDato());
        NodoListaMovil pmovil = origen.getLm().obtenerElemento(movil);

        ListaMovil aux = origen.getLm();
        if (aux.getInicio() == pmovil) {
            aux.borrarInicio();
        } else if (aux.getFin() == pmovil) {
            aux.borrarFin();
        } else {
            aux.borrarElemento(movil);
        }
    }
    //se asume que existen todos los datos
    public static void borrarAbonado(ListaZona lz, Object abonadoId) {
        NodoListaZona origen = lz.obtenerElemento(buscarZonaPorAbonado(lz, abonadoId).getDato());
        NodoListaAbonado pabonado = origen.getLa().obtenerElemento(abonadoId);

        ListaAbonado aux = origen.getLa();
        if (aux.getFin() == pabonado) {
            aux.desencolar();
        } else {
            aux.borrarElemento(abonadoId);
        }
    }

    //se asume que existen todos los datos
    public static NodoListaZona buscarZonaPorMovil(ListaZona lz, String movil) {
        NodoListaZona aux = lz.getInicio();

        while (aux != null) {
            if (aux.getLm().obtenerElemento(movil) != null) {
                return aux;
            }
            aux = aux.getSig();
        }
        return null;
    }
    //se asume que existen todos los datos
    public static NodoListaZona buscarZonaPorAbonado(ListaZona lz, Object abonadoID) {
        NodoListaZona aux = lz.getInicio();

        while (aux != null) {
            if (aux.getLa().obtenerElemento(abonadoID) != null) {
                return aux;
            }
            aux = aux.getSig();
        }
        return null;
    }

    public static void mostrarZonasCompleto(ListaZona lz) {
        NodoListaZona aux = lz.getInicio();

        while (aux != null) {
            System.out.println("\n" + aux.getDato());
            aux.getLm().mostrar();

//            NodoListaMovil aux2 = aux.getLm().getInicio();
//            if (aux2.getLch() != null) {
//                while (aux2 != null) {
//                    System.out.println("\n" + aux2.getDato());
//                    aux2.getLch().mostrar();
//                    aux2 = aux2.getSig();
//                }
//            }
            aux = aux.getSig();
        }
    }
    public static void mostrarAbonados(ListaZona lz) {
        NodoListaZona aux = lz.getInicio();

        while (aux != null) {
            System.out.println("\n" + aux.getDato());
//            aux.getLm().mostrar();

            NodoListaAbonado aux2 = aux.getLa().getInicio();
//            if (aux2.getLch() != null) {
                while (aux2 != null) {
                    System.out.println("\n" + aux2.getAbonadoID());
//                    aux2.getLch().mostrar();
                    aux2 = aux2.getSig();
                }
//            }
            aux = aux.getSig();
        }
    }
}
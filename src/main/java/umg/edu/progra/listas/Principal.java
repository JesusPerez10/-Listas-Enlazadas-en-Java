package umg.edu.progra.listas;


class Node {
    int dato;
    Nodo siguiente;

    public Node(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class lista {
    private Nodo cabeza;

    public lista() {
        cabeza = null;
    }

    public void insertarCabezaLista(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public void visualizar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public int leerPrimero() {
        return (cabeza != null) ? cabeza.dato : -1;
    }

    public void eliminar(int dato) {
        if (cabeza == null) return;
        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.dato != dato) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    public Nodo buscarLista(int dato) {
        Nodo actual = cabeza;
        while (actual != null && actual.dato != dato) {
            actual = actual.siguiente;
        }
        return actual;
    }

    public void insertarLista(Nodo referencia, int dato) {
        if (referencia == null) return;
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = referencia.siguiente;
        referencia.siguiente = nuevo;
    }

    public void ordenarLista() {
        if (cabeza == null || cabeza.siguiente == null) return;
        Nodo actual, siguiente;
        boolean cambiado;
        do {
            cambiado = false;
            actual = cabeza;
            while (actual.siguiente != null) {
                siguiente = actual.siguiente;
                if (actual.dato > siguiente.dato) {
                    int temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    cambiado = true;
                }
                actual = actual.siguiente;
            }
        } while (cambiado);
    }

    public void unirListas(Lista otraLista) {
        if (cabeza == null) {
            cabeza = otraLista.cabeza;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = otraLista.cabeza;
    }

    public void separarParesImpares(Lista listaPares, Lista listaImpares) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato % 2 == 0) {
                listaPares.insertarCabezaLista(actual.dato);
            } else {
                listaImpares.insertarCabezaLista(actual.dato);
            }
            actual = actual.siguiente;
        }
    }
}
public class Principal {

    public static void main(String[] args) {

        Lista lista = new Lista();
        lista.insertarCabezaLista(1);
        lista.insertarCabezaLista(2);
        lista.insertarCabezaLista(3);
        lista.insertarCabezaLista(4);
        lista.insertarCabezaLista(5);
        lista.insertarCabezaLista(6);

        System.out.println("Lista original:");
        lista.visualizar();

        System.out.println("\nPrimero: " + lista.leerPrimero());

        lista.eliminar(3);
        System.out.println("Lista después de eliminar 3:");
        lista.visualizar();

        Nodo dato = lista.buscarLista(4);
        System.out.println("Dato encontrado: " + ((dato != null) ? dato.dato : "No encontrado"));

        lista.insertarLista(dato, 10);
        System.out.println("Lista después de insertar 10 después de 4:");
        lista.visualizar();

        dato = lista.buscarLista(5);
        System.out.println("Dato encontrado: " + ((dato != null) ? dato.dato : "No encontrado"));

        lista.insertarLista(dato, 600);
        System.out.println("Lista después de insertar 600 después de 5:");
        lista.visualizar();

        lista.ordenarLista();
        System.out.println("Lista ordenada de forma ascendente:");
        lista.visualizar();

        Lista lista2 = new Lista();
        lista2.insertarCabezaLista(8);
        lista2.insertarCabezaLista(9);

        lista.unirListas(lista2);
        System.out.println("Lista después de unir otra lista:");
        lista.visualizar();

        Lista listaPares = new Lista();
        Lista listaImpares = new Lista();
        lista.separarParesImpares(listaPares, listaImpares);

        System.out.println("Lista de pares:");
        listaPares.visualizar();
        System.out.println("Lista de impares:");
        listaImpares.visualizar();
    }
}



/**
 * Resolver lo que se solicita a continuacion
 * Ejercicio 1: Ordernar la lista de forma ascendente
 * Ejercicio 2: Unir dos listas enlazadas
 * Ejercicio 3: Separa numeros pares e impares en dos listas enlazadas diferentes
 */
        




package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Lista {

    public Nodo cabeza;
    private Nodo primero;

    @Override
    public String toString() {

        return "=>" + primero;
    }

    /**
     * Constructor para inicializar una lista
     */
    public Lista() {

        primero = null;
    }

    /**
     * Devuelve el nodo inicial
     *
     * @return
     */
    public Nodo leerPrimero() {

        return primero;
    }

    /**
     * Inserta valores a la lista
     *
     * @param entrada
     */
    public void insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;

    }

    /**
     * inserta un elemento a partir de anterior
     *
     * @param anterior
     * @param entrada
     */
    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;

    }


    /**
     * elimina el elemento entrada
     *
     * @param entrada
     */
    public void eliminar(int entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        actual = primero;
        anterior = null;
        encontrado = false;
        // Bucle de búsqueda
        while ((actual != null) && !(actual.dato == entrada)) {
            if (!(actual.dato == entrada)) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        if (actual != null) {
            // Se distingue entre que el nodo sea el cabecera
            // o del resto de la lista
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
    }

    /**
     * busca el elemento destino
     *
     * @param destino
     * @return
     */
    public Nodo buscarLista(int destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (indice.dato == destino) {
                return indice;
            }
        }
        return null;
    }

    /**
     * recorre la lista y muestra cada dato
     */
    public void visualizar() {
        Nodo n;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
    }

    /**
     * Método para invertir la lista enlazada
     */
    public void invertirLista() {
        Nodo prev = null, actual = primero, siguiente;
        while (actual != null) {
            siguiente = actual.enlace;
            actual.enlace = prev;
            prev = actual;
            actual = siguiente;
        }
        primero = prev;
    }

    /**
     * Método para obtener el elemento en la posición n desde el final
     */
    public int obtenerDesdeFinal(int n) {
        Nodo primeroPtr = primero, segundoPtr = primero;
        for (int i = 0; i < n; i++) {
            if (segundoPtr == null) return -1;
            segundoPtr = segundoPtr.enlace;
        }
        while (segundoPtr != null) {
            primeroPtr = primeroPtr.enlace;
            segundoPtr = segundoPtr.enlace;
        }
        return (primeroPtr != null) ? primeroPtr.dato : -1;
    }

    /**
     * Método para eliminar duplicados en la lista
     */
    public void eliminarDuplicados() {
        Nodo actual = primero;
        while (actual != null && actual.enlace != null) {
            Nodo iterador = actual;
            while (iterador.enlace != null) {
                if (actual.dato == iterador.enlace.dato) {
                    iterador.enlace = iterador.enlace.enlace;
                } else {
                    iterador = iterador.enlace;
                }
            }
            actual = actual.enlace;
        }
    }


    /**
     * Método para obtener el tamaño de la lista enlazada
     */
    public int obtenerTamanio() {
        int count = 0;
        Nodo actual = primero;
        while (actual != null) {
            count++;
            actual = actual.enlace;
        }
        return count;
    }
    /**
     * Método para ordenar la lista
     */
    public void ordenarLista() {
        if (primero == null || primero.enlace == null) {
        return;
    }
}
    /**
     * Método para unir las listas
     */
    public void unirListas(Lista otraLista) {
        if (primero == null) {
            primero = otraLista.primero;
            return;
        }
        Nodo actual = primero;
        while (actual.enlace != null) {
            actual = actual.enlace;
        }
        actual.enlace = otraLista.primero;
    }

    /**
     * Método para serparar los pares de los impares
     */

    public void separarParesImpares(Lista listaPares, Lista listaImpares) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.dato % 2 == 0) {
                listaPares.insertarCabezaLista(actual.dato);
            } else {
                listaImpares.insertarCabezaLista(actual.dato);
            }
            actual = actual.enlace;
        }
    }


/**
* Crear los metodos que se solicitan
/**
 * 1 - Método para invertir la lista enlazada
 */

    /**
     * 2 - Método para obtener el elemento en la posición n desde el final
     */

    /**
     * 3 - Método para eliminar duplicados en una lista enlazada
     */


    /**
     * 4 - Método para obtener el tamaño de la lista enlazada
     */
    
   
    
}

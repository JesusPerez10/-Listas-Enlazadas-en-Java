Lista Enlazada en Java

Este proyecto implementa una Lista Enlazada Simple en Java con varias funcionalidades adicionales. Se han agregado métodos para ordenar la lista, unir dos listas, separar números pares e impares, invertir la lista, eliminar duplicados, obtener un elemento desde el final y calcular el tamaño de la lista.

1️⃣ Estructura del Código

Clase Nodo

Cada elemento de la lista es un objeto de la clase Nodo, que contiene:

Un dato (entero).

Un enlace al siguiente nodo.

Clase Lista

Esta clase implementa una lista enlazada simple con múltiples operaciones:

🔹 Métodos básicos

insertarCabezaLista(int entrada): Inserta un nodo al inicio de la lista.

insertarLista(Nodo anterior, int entrada): Inserta un nodo después de un nodo específico.

eliminar(int entrada): Elimina un nodo con un valor específico.

buscarLista(int destino): Busca un nodo con un valor dado.

visualizar(): Muestra los elementos de la lista.

leerPrimero(): Retorna el primer nodo de la lista.

2️⃣ Funciones Adicionales Implementadas

✅ Ordenar la lista de forma ascendente

public void ordenarLista() {
    if (primero == null || primero.enlace == null) {
        return;
    }
    boolean intercambiado;
    do {
        intercambiado = false;
        Nodo actual = primero;
        while (actual.enlace != null) {
            if (actual.dato > actual.enlace.dato) {
                int temp = actual.dato;
                actual.dato = actual.enlace.dato;
                actual.enlace.dato = temp;
                intercambiado = true;
            }
            actual = actual.enlace;
        }
    } while (intercambiado);
}

✅ Unir dos listas enlazadas

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

✅ Separar números pares e impares en dos listas diferentes

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

✅ Invertir la lista enlazada

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

✅ Obtener el elemento en la posición n desde el final

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

✅ Eliminar duplicados en la lista enlazada

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

✅ Obtener el tamaño de la lista enlazada

public int obtenerTamanio() {
    int count = 0;
    Nodo actual = primero;
    while (actual != null) {
        count++;
        actual = actual.enlace;
    }
    return count;
}

3️⃣ Ejemplo de Uso en main()

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

    lista.ordenarLista();
    System.out.println("\nLista ordenada:");
    lista.visualizar();
    
    Lista lista2 = new Lista();
    lista2.insertarCabezaLista(7);
    lista2.insertarCabezaLista(8);
    
    lista.unirListas(lista2);
    System.out.println("\nLista unida:");
    lista.visualizar();

    Lista listaPares = new Lista();
    Lista listaImpares = new Lista();
    lista.separarParesImpares(listaPares, listaImpares);
    
    System.out.println("\nLista de pares:");
    listaPares.visualizar();
    System.out.println("\nLista de impares:");
    listaImpares.visualizar();
}

4️⃣ Conclusión

Este proyecto proporciona una implementación completa de una lista enlazada simple en Java con múltiples funcionalidades avanzadas. Con estos métodos, se pueden realizar operaciones comunes de listas enlazadas de manera eficiente. 🚀


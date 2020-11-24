/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbolesbinarios;

/**
 *
 * @author DELL
 */
public class Arbol {

    Nodo raiz = null;

    public void insertar(int dato) {
        Nodo nuevo = new Nodo();

        nuevo.dato = dato;
        nuevo.izq = null;
        nuevo.der = null;

        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo aux = raiz;
            Nodo ant = null;
            while (aux != null) {
                ant = aux;
                if (nuevo.dato > aux.dato) {
                    aux = aux.der;
                } else {
                    aux = aux.izq;
                }
            }
            if (nuevo.dato > ant.dato) {
                ant.der = nuevo;
            } else {
                ant.izq = nuevo;
            }
        }
    }

    public void insertarUnico(int dato) {
        Nodo nuevo = new Nodo();

        nuevo.dato = dato;
        nuevo.izq = null;
        nuevo.der = null;

        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo aux = raiz;
            Nodo ant = null;
            while ((aux != null) && (aux.dato != dato)) {
                ant = aux;
                if (nuevo.dato > aux.dato) {
                    aux = aux.der;
                } else {
                    aux = aux.izq;
                }
            }
            if (aux == null) {
                if (nuevo.dato > ant.dato) {
                    ant.der = nuevo;
                } else {
                    ant.izq = nuevo;
                }
            }
        }
    }

    public void recorrer(Recorrido tipo) {
        switch (tipo) {
            case INORDER ->
                inorder(raiz);
            case PREORDER ->
                preorder(raiz);
            case POSTORDER ->
                postorder(raiz);
            case HOJAS ->
                soloHojas(raiz);
        }
    }

    void inorder(Nodo r) {
        if (r != null) {
            inorder(r.izq);
            System.out.print(r.dato + " ");
            inorder(r.der);
        }
    }

    void preorder(Nodo r) {
        if (r != null) {
            System.out.print(r.dato + " ");
            preorder(r.izq);
            preorder(r.der);
        }
    }

    void postorder(Nodo r) {
        if (r != null) {
            postorder(r.izq);
            postorder(r.der);
            System.out.print(r.dato + " ");
        }
    }

    void soloHojas(Nodo r) {
        if (r != null) {
            soloHojas(r.izq);
            if ((r.izq == null) && (r.der == null)) {
                System.out.print(r.dato + " ");
            }
            soloHojas(r.der);
        }
    }

    public Boolean buscar(int dato) {
        return buscarElemento(raiz, dato);
    }

    Boolean buscarElemento(Nodo r, int dato) {
        if (r != null) {
            if (r.dato == dato) {
                return true;
            } else if (dato < r.dato) {
                return buscarElemento(r.izq, dato);
            } else {
                return buscarElemento(r.der, dato);
            }
        } else {
            return false;
        }
    }

    public void eliminar(int dato) {
        if (raiz != null) {
            Nodo aux = raiz;
            Nodo ant = raiz;
            boolean esIzq = true;
            
            while (aux.dato != dato) {
                ant = aux;
                if (dato < aux.dato) {
                    esIzq = true;
                    aux = aux.izq;
                } else {
                    esIzq = false;
                    aux = aux.der;
                }
            }
            if ((aux.izq == null) && (aux.der == null)) {
                if (aux == raiz) {
                    raiz = null;
                } else if (esIzq) {
                    ant.izq = null;
                } else {
                    ant.der = null;
                }
            } else if (aux.der == null) {
                if (aux == raiz) {
                    raiz = aux.izq;
                } else if (esIzq) {
                    ant.izq = aux.izq;
                } else {
                    ant.der = aux.izq;
                }
            } else if (aux.izq == null) {
                if (aux == raiz) {
                    raiz = aux.der;
                } else if (esIzq) {
                    ant.izq = aux.der;
                } else {
                    ant.der = aux.der;
                }
            } else {
                Nodo reemplazar = obtenerReemplazar(aux);
                if (aux == raiz) {
                    raiz = reemplazar;
                } else if (esIzq) {
                    ant.izq = reemplazar;
                } else {
                    ant.der = reemplazar;
                }
                reemplazar.izq = aux.izq;
            }
        }
    }

    Nodo obtenerReemplazar(Nodo rem) {
        Nodo rempapa = rem;
        Nodo remplazo = rem;
        Nodo aux = rem.der;
        
        while (aux != null) {
            rempapa = remplazo;
            remplazo = aux;
            aux = aux.izq;
        }
        if (remplazo != rem.der) {
            rempapa.izq = remplazo.der;
            remplazo.der = rem.der;
        }
        return remplazo;
    }

}

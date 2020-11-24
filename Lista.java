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
public class Lista {
    Nodo inicio=null;
    Nodo fin=null;
    
    public  void put (int dato) {
	Nodo nuevo = nuevoNodo(dato);
	if(isEmpty()) {
		inicio=nuevo;
		fin=nuevo;
            }else {
		nuevo.der=inicio;
		inicio.izq=nuevo;
		inicio=nuevo;
		}
	}
    public int sacacola(){
        
        Nodo aux=fin;
        int resultado = aux.dato;
        fin =fin.izq;
        fin.der=null;
        aux.izq=null;
        
        return resultado;
        
    }
    public boolean isEmpty(){
        return inicio==null&&fin==null;
    }
    public Nodo nuevoNodo(int dato){
        Nodo nuevo =  new Nodo();
        nuevo.dato=dato;
        nuevo.der=null;
        nuevo.izq=null;
        return nuevo;
    }
}

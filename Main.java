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
public class Main {
    public static void main(String[] args) {
        Arbol arbolito = new Arbol();

        arbolito.insertarUnico(14);
        arbolito.insertarUnico(17);
        arbolito.insertarUnico(13);
        arbolito.insertarUnico(12);
        arbolito.insertarUnico(55);
        arbolito.insertarUnico(23);
        arbolito.insertarUnico(1);
        arbolito.insertarUnico(26);
        
        System.out.println(arbolito.buscar(23));
        arbolito.recorrer(Recorrido.INORDER);
        System.out.println();
        arbolito.recorrer(Recorrido.POSTORDER);
        System.out.println();
        arbolito.recorrer(Recorrido.PREORDER);
        System.out.println();
        arbolito.recorrer(Recorrido.HOJAS);
        System.out.println();
        arbolito.eliminar(12);
        arbolito.recorrer(Recorrido.INORDER);

                
    }
}

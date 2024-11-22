/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author chris
 */
public class Array {
    public static <T> Lista<T> asList(T... elements) {
        Lista<T> list = new Lista<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }
}


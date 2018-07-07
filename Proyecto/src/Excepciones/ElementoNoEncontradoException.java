/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author 1047470
 */
public class ElementoNoEncontradoException extends Exception {

    /**
     * Creates a new instance of <code>ElementoNoEncontradoException</code>
     * without detail message.
     */
    public ElementoNoEncontradoException() {
    }

    /**
     * Constructs an instance of <code>ElementoNoEncontradoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ElementoNoEncontradoException(String msg) {
        super(msg);
    }
}

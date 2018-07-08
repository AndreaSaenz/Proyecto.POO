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
public class IncompatibilidadContrasenaException extends Exception {

    /**
     * Creates a new instance of
     * <code>IncompatibilidadContrasenaException</code> without detail message.
     */
    /*public IncompatibilidadContrasenaException() {
    }*/

    /**
     * Constructs an instance of
     * <code>IncompatibilidadContrasenaException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public IncompatibilidadContrasenaException(String msg) {
        super(msg);
    }
}

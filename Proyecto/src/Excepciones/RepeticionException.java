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
public class RepeticionException extends Exception {

    /**
     * Creates a new instance of <code>NewException</code> without detail
     * message.
     */
    public RepeticionException() {
    }

    /**
     * Constructs an instance of <code>NewException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public RepeticionException(String msg) {
        super(msg);
    }
}

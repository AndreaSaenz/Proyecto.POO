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
public class LimiteIntentosException extends Exception {

    /**
     * Creates a new instance of <code>LimiteIntentosException</code> without
     * detail message.
     */
    /*public LimiteIntentosException() {
    }*/

    /**
     * Constructs an instance of <code>LimiteIntentosException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public LimiteIntentosException(String msg) {
        super(msg);
    }
}

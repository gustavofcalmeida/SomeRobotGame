/*
 * InvalidFileException.java
 *
 * Created on 15 de Maio de 2007, 22:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.gpp.proj1.map.editor;

/**
 *
 * @author Gustavo
 */
public class InvalidFileException extends java.lang.Exception {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5040042495280008054L;

	/**
     * Constructs an instance of <code>InvalidFileException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public InvalidFileException(String msg) {
        super(msg);
    }
}
